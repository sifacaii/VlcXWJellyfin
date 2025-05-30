export class ExternalPlayerPlugin {
    constructor({ events, playbackManager, appHost }) {
        window['ExtPlayer'] = this;

        this.events = events;
        this.playbackManager = playbackManager;
        this.appHost = appHost;

        this.name = 'External Player';
        this.type = 'mediaplayer';
        this.id = 'externalplayer';
        this.subtitleStreamIndex = -1;
        this.audioStreamIndex = -1;
        this.cachedDeviceProfile = null;

        // Prioritize first
        this.priority = -2;
        this.supportsProgress = false;
        this.isLocalPlayer = true;

        // Disable orientation lock
        this.isExternalPlayer = true;
        // _currentTime is in milliseconds
        this._currentTime = 0;
        this._paused = true;
        this._volume = 100;
        this._currentSrc = null;
        this._isIntro = false;
    }

    canPlayMediaType(mediaType) {
        return mediaType === 'Video';
    }

    canPlayItem(item, playOptions) {
        return localStorage.getItem('useExternalplayer') == 'true' && playOptions.fullscreen && !this.playbackManager.syncPlayEnabled;
    }

    currentSrc() {
        return this._currentSrc;
    }

    async play(options) {
        this._currentTime = options.playerStartPositionTicks / 10000 || 0;
        this._paused = false;
        this._currentSrc = options.url;
        this._isIntro = options.item && options.item.ProviderIds && options.item.ProviderIds.hasOwnProperty("prerolls.video");
        const playOptions = options.item.playOptions;
        playOptions.ids = options.item ? [options.item.Id] : [];
        playOptions.url = options.url;
        playOptions.backdropUrl = options.backdropUrl;
        playOptions.title = options.title;
        playOptions.playerStartPositionTicks = options.playerStartPositionTicks / 10000 || 0;
        window['NativeApi'].toExtPlayer(options.url);
    }

    setSubtitleStreamIndex(index) { }

    canSetAudioStreamIndex() {
        return false;
    }

    setAudioStreamIndex(index) {
    }

    duration(val) {
        return null;
    }

    destroy() { }

    pause() { }

    unpause() { }

    paused() {
        return this._paused;
    }

    async stop(destroyPlayer) {
        if (destroyPlayer) {
            this.destroy();
        }
    }

    volume(val) {
        return this._volume;
    }

    setMute(mute) {
    }

    isMuted() {
        return this._volume == 0;
    }

    async notifyEnded() {
        let stopInfo = {
            src: this._currentSrc
        };

        this.playbackManager._playNextAfterEnded = this._isIntro;
        this.events.trigger(this, 'stopped', [stopInfo]);
        this._currentSrc = this._currentTime = null;
    }

    async notifyTimeUpdate(currentTime) {
        // Use duration (as if playback completed) if no time is provided
        currentTime = currentTime || this.playbackManager.duration(this) / 10000;
        this._timeUpdated = this._currentTime != currentTime;
        this._currentTime = currentTime;
        this.events.trigger(this, 'timeupdate');
    }

    notifyCanceled() {
        // required to not mark an item as seen / completed without time changes
        let currentTime = this._currentTime || 0;
        this.notifyTimeUpdate(currentTime - 1);
        if (currentTime > 0) {
            this.notifyTimeUpdate(currentTime);
        }
        this.notifyEnded();
    }

    /**
     * Returns the currently known player time in milliseconds
     */
    currentTime() {
        return this._currentTime || 0;
    }

    async changeSubtitleStream(index) {
        var innerIndex = Number(index);
        this.subtitleStreamIndex = innerIndex;
    }

    async changeAudioStream(index) {
        var innerIndex = Number(index);
        this.audioStreamIndex = innerIndex;
    }

    async getDeviceProfile() {
        let profile = this.appHost.getDeviceProfile();
        return profile;
    }
}
