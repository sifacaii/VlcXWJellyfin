/* eslint-disable indent */

function getMediaStreamAudioTracks(mediaSource) {
    return mediaSource.MediaStreams.filter(function (s) {
        return s.Type === 'Audio';
    });
}

class mpvVideoPlayer {
    constructor({ events, loading, appRouter, globalize, appHost, appSettings, confirm, dashboard }) {
        this.events = events;
        this.loading = loading;
        this.appRouter = appRouter;
        this.globalize = globalize;
        this.appHost = appHost;
        this.appSettings = appSettings;

        // this can be removed after 10.9
        this.setTransparency = (dashboard && dashboard.setBackdropTransparency)
            ? dashboard.setBackdropTransparency.bind(dashboard)
            : appRouter.setTransparency.bind(appRouter);

        /**
         * @type {string}
         */
        this.name = 'MPV Video Player';
        /**
         * @type {string}
         */
        this.type = 'mediaplayer';
        /**
         * @type {string}
         */
        this.id = 'mpvvideoplayer';
        this.syncPlayWrapAs = 'htmlvideoplayer';
        this.priority = -1;
        this.useFullSubtitleUrls = true;
        /**
         * @type {boolean}
         */
        this.isFetching = false;

        /**
         * @type {HTMLDivElement | null | undefined}
         */
        this._videoDialog = undefined;
        /**
         * @type {number | undefined}
         */
        this._subtitleTrackIndexToSetOnPlaying = undefined;
        /**
         * @type {number | null}
         */
        this._audioTrackIndexToSetOnPlaying = undefined;
        /**
         * @type {boolean | undefined}
         */
        this._showTrackOffset = undefined;
        /**
         * @type {number | undefined}
         */
        this._currentTrackOffset = undefined;
        /**
         * @type {string[] | undefined}
         */
        this._supportedFeatures = undefined;
        /**
         * @type {string | undefined}
         */
        this._currentSrc = undefined;
        /**
         * @type {boolean | undefined}
         */
        this._started = undefined;
        /**
         * @type {boolean | undefined}
         */
        this._timeUpdated = undefined;
        /**
         * @type {number | null | undefined}
         */
        this._currentTime = undefined;
        /**
         * @private (used in other files)
         * @type {any | undefined}
         */
        this._currentPlayOptions = undefined;
        /**
         * @type {any | undefined}
         */
        this._lastProfile = undefined;
        /**
         * @type {number | undefined}
         */
        this._duration = undefined;
        /**
         * @type {boolean}
         */
        this._paused = false;
        /**
         * @type {int}
         */
        this._volume = 100;
        /**
         * @type {boolean}
         */
        this._muted = false;
        /**
         * @type {float}
         */
        this._playRate = 1;
        /**
         * @type {boolean}
         */
        this._hasConnection = false;
        this._mediaElement = undefined;
        this._currentSubtitlesOctopus = undefined;
        this._customTrackIndex = undefined;


        this.onEnded = () => {
            this.onEndedInternal();
        };

        /**
         * @private
         */
        this.onTimeUpdate = (e) => {
            const elem = e.target;
            // get the player position and the transcoding offset
            const time = elem.currentTime;

            if (time && !this._timeUpdated) {
                this._timeUpdated = true;
            }

            this._currentTime = time;

            this.events.trigger(this, 'timeupdate');
        };


        this.onNavigatedToOsd = () => {
            const dlg = this._videoDialog;
            if (dlg) {
                dlg.style.zIndex = 'unset';


                var that=this;
                var setStreamIndex = function () {
                    if (that._mediaElement.videoWidth > 0) {
                        that.setAudioStreamIndex(that._audioTrackIndexToSetOnPlaying);
                        that.setSubtitleStreamIndex(that._subtitleTrackIndexToSetOnPlaying);
                    } else {
                        setTimeout(setStreamIndex, 500);
                    }
                }
                setStreamIndex();
            }
        };


        this.onPlaying = (e) => {
            const elem = e.target;
            if (!this._started) {
                this._started = true;

                this.loading.hide();

                //this.setPlaybackRate(1);


                function setCurrentTimeIfNeeded(element, seconds) {
                    // If it's worth skipping (1 sec or less of a difference)
                    if (Math.abs((element.currentTime || 0) - seconds) >= 1) {
                        element.currentTime = seconds;
                    }
                }

                if (this._currentPlayOptions.playerStartPositionTicks) {
                    const seconds = (this._currentPlayOptions.playerStartPositionTicks || 0) / 10000000;

                    if (seconds) {
                        // Appending #t=xxx to the query string doesn't seem to work with HLS
                        // For plain video files, not all browsers support it either

                        if (elem.duration >= seconds) {
                            // media is ready, seek immediately
                            setCurrentTimeIfNeeded(elem, seconds);

                        } else {
                            // update video player position when media is ready to be sought
                            const events = ['durationchange', 'loadeddata', 'play', 'loadedmetadata'];
                            const onMediaChange = function (e) {
                                if (elem.currentTime === 0 && elem.duration >= seconds) {
                                    // seek only when video position is exactly zero,
                                    // as this is true only if video hasn't started yet or
                                    // user rewound to the very beginning
                                    // (but rewinding cannot happen as the first event with media of non-empty duration)
                                    console.debug(`seeking to ${seconds} on ${e.type} event`);
                                    setCurrentTimeIfNeeded(elem, seconds);
                                    events.forEach(name => elem.removeEventListener(name, onMediaChange));
                                }
                            };
                            events.forEach(name => elem.addEventListener(name, onMediaChange));
                        }
                    }
                }

                if (this._currentPlayOptions.fullscreen) {
                    this.appRouter.showVideoOsd().then(this.onNavigatedToOsd);
                } else {
                    this.setTransparency('backdrop');
                    this._videoDialog.dlg.style.zIndex = 'unset';
                }

                // Need to override default style.
                this._videoDialog.style.setProperty('background', 'transparent', 'important');
            }

            if (this._paused) {
                this._paused = false;
                this.events.trigger(this, 'unpause');
            }

            this.events.trigger(this, 'playing');
        };

        this.onPause = () => {
            this._paused = true;
            // For Syncplay ready notification
            this.events.trigger(this, 'pause');
        };

        this.onWaiting = () => {
            this.events.trigger(this, 'waiting');
        };

        /**
         * @private
         * @param e {Event} The event received from the `<video>` element
         */
        this.onError = function (error) {
            let that = this;
            return new Promise((resolve, reject) => {
                that.removeMediaDialog();
                console.error(`media error: ${error}`);

                const errorData = {
                    type: 'mediadecodeerror'
                };

                try {
                    confirm({
                        title: "Playback Failed",
                        text: `Playback failed with error "${error}". Retry with transcode? (Note this may hang the player.)`,
                        cancelText: "Cancel",
                        confirmText: "Retry"
                    }).then(() => {
                        that.events.trigger(this, 'error', [errorData]);
                    });
                } catch (ex) {
                    // User declined retry
                    errorData.streamInfo = {
                        // Prevent jellyfin-web retrying with transcode
                        // which crashes the player
                        mediaSource: {
                            SupportsTranscoding: false
                        }
                    };
                }
            });
        }

        this.onDuration = (duration) => {
            this._duration = duration;
        };
    }

    currentSrc() {
        return this._currentSrc;
    }

    play(options){
        if(this.appSettings.get('TO_EXT_PLAYER') === "true"){
            this.loading.hide();
            let url = options.url;
            return new Promise((resolve)=>{
                if(url) window.NativeApi.toExtPlayer(url);

                resolve();
            });
        }else{
            return this.playToVlc(options);
        }
    }

    playToVlc(options) {
        var _this2 = this;
        this._started = false;
        this._timeUpdated = false;
        this._currentTime = null;

        this.resetSubtitleOffset();
        this.loading.show();

        return this.createMediaElement(options).then((elem) => {
            return _this2.setCurrentSrc(elem, options);
        });

    }

    // getStreamByIndex(mediaStreams, jellyIndex) {
    //     console.log('getStreamByIndex');
    //     for (const source of mediaStreams) {
    //         if (source.Index == jellyIndex) {
    //             return source;
    //         }
    //     }

    //     return null;
    // }

    setCurrentSrc(elem, options) {
        var that = this;
        elem.removeEventListener('error', this.onError);

        let val = options.url;
        val += "&fromJellyfin";
        this._currentSrc = val;
        console.debug(`playing url: ${val}`);

        // Convert to seconds
        const seconds = (options.playerStartPositionTicks || 0) / 10000000;
        if (seconds) {
            val += `#t=${seconds}`;
        }

        // Convert to seconds
        const ms = (options.playerStartPositionTicks || 0) / 10000;
        this._currentPlayOptions = options;

        this._subtitleTrackIndexToSetOnPlaying = options.mediaSource.DefaultSubtitleStreamIndex == null ? -1 : options.mediaSource.DefaultSubtitleStreamIndex;
        if (this._subtitleTrackIndexToSetOnPlaying != null && this._subtitleTrackIndexToSetOnPlaying >= 0) {
            const initialSubtitleStream = options.mediaSource.MediaStreams[this._subtitleTrackIndexToSetOnPlaying];
            if (!initialSubtitleStream || initialSubtitleStream.DeliveryMethod === 'Encode') {
                this._subtitleTrackIndexToSetOnPlaying = -1;
            }
        }

        this._audioTrackIndexToSetOnPlaying = options.mediaSource.DefaultAudioStreamIndex;

        // 硬件解码设置
        val += this.getDecoderSetting();

        elem.src = val;
        elem.play()
            .catch((e) => {
                const errorName = (e.name || '').toLowerCase();
                if (errorName === 'notallowederror' ||
                    errorName === 'aborterror') {
                    // swallow this error because the user can still click the play button on the video element
                    return Promise.resolve();
                }
                return Promise.reject();
            })
            .then(() => {
                elem.addEventListener('error', that.onError);
                return Promise.resolve();
            });
    }

    setAudioStreamIndex(index) {
        this._audioTrackIndexToSetOnPlaying = index;
        window.NativeApi.setAudioTrackId(index);
    }

    setSubtitleStreamIndex(streamIndex) {
        this._subtitleTrackIndexToSetOnPlaying = streamIndex;

        this.destroySubtitleOctopus();

        const mediaStreamTextTracks = this._currentPlayOptions.mediaSource.MediaStreams.filter((s) => {
            return s.Type === 'Subtitle';
        });

        let track = streamIndex === -1 ? null : mediaStreamTextTracks.filter(function (t) {
            return t.Index === streamIndex;
        })[0];

        if (track == null) {
            window.NativeApi.setSubtitleTrackId(-1);
            return;
        }
        if (track.IsExternal) {
            window.NativeApi.setSubtitleTrackId(-1);
            this.renderExternalSubtitles(track);
        } else {
            window.NativeApi.setSubtitleTrackId(streamIndex);
        }
    }

    renderExternalSubtitles(subtitleTracks) {
        var that = this;
        let baseUrl = this.appRouter.baseUrl();
        var options = {
            video: this._mediaElement,
            subUrl: subtitleTracks.DeliveryUrl,
            fonts: ['../../js/msyh.ttc'],
            workerUrl: baseUrl + '/libraries/subtitles-octopus-worker.js', 
            legacyWorkerUrl: baseUrl + '/libraries/subtitles-octopus-worker-legacy.js',
            onError() {
                that._currentSubtitlesOctopus = undefined;
                setTimeout(() => {
                    that.events.trigger(this._mediaElement, 'error', [{ type: 'mediadecodeerror' }]);
                }, 0);
            }
        }
        this._currentSubtitlesOctopus = new SubtitlesOctopus(options);
    }

    destroySubtitleOctopus() {
        const octopus = this._currentSubtitlesOctopus;
        if (octopus) {
            octopus.dispose();
        }
        this._currentSubtitlesOctopus = null;
    }

    resetSubtitleOffset() {
        this._currentTrackOffset = 0;
        this._showTrackOffset = false;
    }

    enableShowingSubtitleOffset() {
        this._showTrackOffset = true;
    }

    disableShowingSubtitleOffset() {
        this._showTrackOffset = false;
    }

    isShowingSubtitleOffsetEnabled() {
        return this._showTrackOffset;
    }

    onEndedInternal() {
        const stopInfo = {
            src: this._currentSrc
        };

        this.events.trigger(this, 'stopped', [stopInfo]);

        this._currentTime = null;
        this._currentSrc = null;
        this._currentPlayOptions = null;
    }

    stop(destroyPlayer) {
        this.onEndedInternal();

        if (destroyPlayer) {
            this.destroy();
        }
        return Promise.resolve();
    }

    removeMediaDialog() {
        this.loading.hide();

        this.setTransparency('none');

        document.body.classList.remove('hide-scroll');

        const dlg = this._videoDialog;
        if (dlg) {
            this._videoDialog = null;
            dlg.parentNode.removeChild(dlg);
        }
    }

    destroy() {
        this.removeMediaDialog();

        this._hasConnection = false;
        this._duration = undefined;

        this.destroySubtitleOctopus();

        if (this._mediaElement) {
            let videoElement = this._mediaElement;

            videoElement.removeEventListener('timeupdate', this.onTimeUpdate);
            videoElement.removeEventListener('ended', this.onEnded);
            videoElement.removeEventListener('pause', this.onPause);
            videoElement.removeEventListener('playing', this.onPlaying);
            videoElement.removeEventListener('waiting', this.onWaiting);
            videoElement.removeEventListener('error', this.onError);

            this._mediaElement = null;
        }

    }

    createMediaElement(options) {
        const dlg = document.querySelector('.videoPlayerContainer');

        if (!dlg) {
            this.loading.show();

            const dlg = document.createElement('div');

            dlg.classList.add('videoPlayerContainer');

            const duration = 240;
            dlg.style.animation = `htmlvideoplayer-zoomin ${duration}ms ease-in normal`;

            if (options.fullscreen) {
                dlg.classList.add('videoPlayerContainer-onTop');
            }

            var html = '';
            var cssClass = 'htmlvideoplayer'; // Can't autoplay in these browsers so we need to use the full controls, at least until playback starts
            html += '<video class="' + cssClass + '" preload="metadata" autoplay="autoplay" webkit-playsinline playsinline>';
            html += '</video>';
            dlg.innerHTML = html;

            var videoElement = dlg.querySelector('video');
            this._mediaElement = videoElement;

            videoElement.volume = this.appSettings.get('volume') || 1;
            videoElement.addEventListener('timeupdate', this.onTimeUpdate);
            videoElement.addEventListener('ended', this.onEnded);
            videoElement.addEventListener('pause', this.onPause);
            videoElement.addEventListener('playing', this.onPlaying);
            videoElement.addEventListener('waiting', this.onWaiting);
            videoElement.addEventListener("loadeddata", this.loadeddata);

            if (options.backdropUrl) {
                videoElement.poster = options.backdropUrl;
            }

            document.body.insertBefore(dlg, document.body.firstChild);
            this._videoDialog = dlg;

            if (options.fullscreen) {
                document.body.classList.add('hide-scroll');
            }
            return Promise.resolve(videoElement);
        } else {
            if (options.fullscreen) {
                document.body.classList.add('hide-scroll');
            }

            return Promise.resolve(dlg.querySelector('video'));
        }
    }

    canPlayMediaType(mediaType) {
        return (mediaType || '').toLowerCase() === 'video';
    }

    supportsPlayMethod(playMethod, item) {
        if (this.appHost.supportsPlayMethod) {
            return this.appHost.supportsPlayMethod(playMethod, item);
        }

        return true;
    }

    getDeviceProfile(item, options) {
        if (this.appHost.getDeviceProfile) {
            return this.appHost.getDeviceProfile(item, options);
        }

        return Promise.resolve({});
    }


    static getSupportedFeatures() {
        return ['PlaybackRate', 'SetAspectRatio'];
    }

    supports(feature) {
        if (!this._supportedFeatures) {
            this._supportedFeatures = mpvVideoPlayer.getSupportedFeatures();
        }

        return this._supportedFeatures.includes(feature);
    }

    // Save this for when playback stops, because querying the time at that point might return 0
    currentTime(val) {
        const mediaElement = this._mediaElement;

        if (mediaElement) {
            if (val != null) {
                mediaElement.currentTime = val / 1000;
                return;
            }

            const currentTime = this._currentTime;
            if (currentTime) {
                return currentTime * 1000;
            }

            return (mediaElement.currentTime || 0) * 1000;
        }
    }

    duration() {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            const duration = mediaElement.duration;
            if (this.isValidDuration(duration)) {
                return duration * 1000;
            }
        }

        return null;
    }

    canSetAudioStreamIndex() {
        return true;
    }

    seekable() {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            const seekable = mediaElement.seekable;
            if (seekable && seekable.length) {
                let start = seekable.start(0);
                let end = seekable.end(0);

                if (!this.isValidDuration(start)) {
                    start = 0;
                }
                if (!this.isValidDuration(end)) {
                    end = 0;
                }

                return (end - start) > 0;
            }

            return false;
        }
    }

    isValidDuration(duration) {
        if (duration && !isNaN(duration) && duration !== Number.POSITIVE_INFINITY && duration !== Number.NEGATIVE_INFINITY) {
            return true;
        }

        return false;
    }

    pause() {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            mediaElement.pause();
        }
    }

    // This is a retry after error
    resume() {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            mediaElement.play();
        }
    }

    unpause() {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            mediaElement.play();
        }
    }

    paused() {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            return mediaElement.paused;
        }

        return false;
    }

    setPlaybackRate(value) {
        this._playRate = value;
        window.NativeApi.setPlaybackRate(value);
    }

    getPlaybackRate() {
        return this._playRate;
    }

    getSupportedPlaybackRates() {
        var SupportedPlaybackRates = [{
            name: '0.5x',
            id: 0.5
        }, {
            name: '0.75x',
            id: 0.75
        }, {
            name: '1x',
            id: 1.0
        }, {
            name: '1.25x',
            id: 1.25
        }, {
            name: '1.5x',
            id: 1.5
        }, {
            name: '1.75x',
            id: 1.75
        }, {
            name: '2x',
            id: 2.0
        }];
        return SupportedPlaybackRates;
    }

    setVolume(val) {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            mediaElement.volume = Math.pow(val / 100, 3);
        }
    }

    getVolume() {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            return Math.min(Math.round(Math.pow(mediaElement.volume, 1 / 3) * 100), 100);
        }
    }

    volumeUp() {
        this.setVolume(Math.min(this.getVolume() + 2, 100));
    }

    volumeDown() {
        this.setVolume(Math.max(this.getVolume() - 2, 0));
    }

    setMute(mute) {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            mediaElement.muted = mute;
        }
    }

    isMuted() {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            return mediaElement.muted;
        }
        return false;
    }

    getBufferedRanges() {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            const ranges = [];
            const seekable = mediaElement.buffered || [];

            let offset;
            const currentPlayOptions = this._currentPlayOptions;
            if (currentPlayOptions) {
                offset = currentPlayOptions.transcodingOffsetTicks;
            }

            offset = offset || 0;

            for (let i = 0, length = seekable.length; i < length; i++) {
                let start = seekable.start(i);
                let end = seekable.end(i);

                if (!this.isValidDuration(start)) {
                    start = 0;
                }
                if (!this.isValidDuration(end)) {
                    end = 0;
                    continue;
                }

                ranges.push({
                    start: (start * 10000000) + offset,
                    end: (end * 10000000) + offset
                });
            }

            return ranges;
        }
        return [];
    }

    getDecoderSetting(){
        let hacc = this.appSettings.get('VLC_HACC') || false;
        let forceHacc = this.appSettings.get('VLC_FORCE_HACC') || false;
        return "&hacc=" + hacc + "&forceHacc=" + forceHacc;
    }

    getStats() {
        const mediaElement = this._mediaElement;
        const playOptions = this._currentPlayOptions || [];

        const categories = [];

        if (!mediaElement) {
            return Promise.resolve({
                categories: categories
            });
        }

        const mediaCategory = {
            stats: [],
            type: 'media'
        };
        categories.push(mediaCategory);

        if (playOptions.url) {
            //  create an anchor element (note: no need to append this element to the document)
            let link = document.createElement('a');
            //  set href to any path
            link.setAttribute('href', playOptions.url);
            const protocol = (link.protocol || '').replace(':', '');

            if (protocol) {
                mediaCategory.stats.push({
                    label: this.globalize.translate('LabelProtocol'),
                    value: protocol
                });
            }

            link = null;
        }

        mediaCategory.stats.push({
            label: this.globalize.translate('LabelStreamType'),
            value: 'Video'
        });

        const videoCategory = {
            stats: [],
            type: 'video'
        };
        categories.push(videoCategory);

        const devicePixelRatio = window.devicePixelRatio || 1;
        const rect = mediaElement.getBoundingClientRect ? mediaElement.getBoundingClientRect() : {};
        let height = Math.round(rect.height * devicePixelRatio);
        let width = Math.round(rect.width * devicePixelRatio);

        // Don't show player dimensions on smart TVs because the app UI could be lower resolution than the video and this causes users to think there is a problem
        if (width && height) {
            videoCategory.stats.push({
                label: this.globalize.translate('LabelPlayerDimensions'),
                value: `${width}x${height}`
            });
        }

        height = mediaElement.videoHeight;
        width = mediaElement.videoWidth;

        if (width && height) {
            videoCategory.stats.push({
                label: this.globalize.translate('LabelVideoResolution'),
                value: `${width}x${height}`
            });
        }

        if (mediaElement.getVideoPlaybackQuality) {
            const playbackQuality = mediaElement.getVideoPlaybackQuality();

            const droppedVideoFrames = playbackQuality.droppedVideoFrames || 0;
            videoCategory.stats.push({
                label: this.globalize.translate('LabelDroppedFrames'),
                value: droppedVideoFrames
            });

            const corruptedVideoFrames = playbackQuality.corruptedVideoFrames || 0;
            videoCategory.stats.push({
                label: this.globalize.translate('LabelCorruptedFrames'),
                value: corruptedVideoFrames
            });
        }

        const audioCategory = {
            stats: [],
            type: 'audio'
        };
        categories.push(audioCategory);

        const sinkId = mediaElement.sinkId;
        if (sinkId) {
            audioCategory.stats.push({
                label: 'Sink Id:',
                value: sinkId
            });
        }

        return Promise.resolve({
            categories: categories
        });
    }

    getSupportedAspectRatios() {
        return [{
            name: this.globalize.translate('Auto'),
            id: 'auto'
        }, {
            name: this.globalize.translate('AspectRatioCover'),
            id: 'cover'
        }, {
            name: this.globalize.translate('AspectRatioFill'),
            id: 'fill'
        }];
    }

    getAspectRatio() {
        return this._currentAspectRatio || 'auto';
    }

    setAspectRatio(val) {
        const mediaElement = this._mediaElement;
        if (mediaElement) {
            if (val === 'auto') {
                mediaElement.style.removeProperty('object-fit');
            } else {
                mediaElement.style['object-fit'] = val;
            }
        }
        this._currentAspectRatio = val;
    }

}


window._mpvVideoPlayer = function () {
    return new Promise(function (resolve) {
        resolve(mpvVideoPlayer);
    });
};