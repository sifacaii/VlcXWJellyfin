(function (AppInfo) {
    'use strict';

    var AppInfo = {
        deviceId: window['NativeApi'].getDeviceId(),
        deviceName: window['NativeApi'].getDeviceName(),
        appName: window['NativeApi'].getAppName(),
        appVersion: window['NativeApi'].getAppVersionCode()
    };

    // List of supported features
    var SupportedFeatures = [
        //'fullscreenchange',
        'exit',
        'externallinks',
        'htmlaudioautoplay',
        'htmlvideoautoplay',
        'displaylanguage',
        'targetblank',
        'screensaver',
        'subtitleappearancesettings',
        'subtitleburnsettings',
        'multiserver',
        'clientsettings',
        'remotecontrol',
        'remotevideo',
        'displaymode',
        'exitmenu'
    ];

    var plugins = [
        '_outputInnerComponent',
        '_ExternalPlayer'
    ];

    window.NativeShell = {
        AppHost: {
            init: function () {
                return Promise.resolve(AppInfo);
            },

            appName: function () {
                return AppInfo.appName;
            },

            appVersion: function () {
                return AppInfo.appVersion;
            },

            deviceId: function () {
                return AppInfo.deviceId;
            },

            deviceName: function () {
                return AppInfo.deviceName;
            },

            exit: function () {
                window['NativeApi'].exitApp("lj");
            },

            getDefaultLayout: function () {
                return 'mobile';
            },

            getDeviceProfile: getDeviceProfile,

            supports: function (command) {
                var isSupported = command && SupportedFeatures.indexOf(command.toLowerCase()) != -1;
                return isSupported;
            }
        },

        // downloadFile: function (url) {
        // },

        selectServer: function () {
            window['NativeApi'].toServerSelect();
        },

        getPlugins: function () {
            return plugins;
        },

        openUrl: function (url, target) {
        },

        openClientSettings: function () {
            import('./clientSetting.js').then((settingDialog) => {
                settingDialog.default.show().then(dlg => { });
            });
        },

        enableFullscreen() {
            //window.JSBridge.postMessage({ "func": "enableFullscreen" });
        },

        disableFullscreen() {
            //window.JSBridge.postMessage({ "func": "disableFullscreen" });
        },
    };
})();

/**
 * 导出内部组件
 * @returns 
 */
window._outputInnerComponent = function () {
    return new Promise(function (resolve) {
        resolve(
            class InnerComponent {
                constructor(components) {
                    window['InnerComponents'] = this;
                    this.Components = components;
                }

                goBack() {
                    var appRouter = window['Emby']['Page'];
                    if (appRouter.canGoBack()) {
                        appRouter.back();
                    } else {
                        window['NativeApi'].exitApp();
                    }
                }
            });
    });
};

window._ExternalPlayer = function () {
    return new Promise(resolve => {
        import('./ExternalPlayerPlugin.js').then(({ ExternalPlayerPlugin }) => {
            resolve(ExternalPlayerPlugin);
        });
    });
}

const DeviceCodecInfo = JSON.parse(window.NativeApi.getMediaCodecInfo());

function getDeviceProfile(profileBuilder) {
    //console.log(DeviceCodecInfo);

    let maxResolutionAVC = DeviceCodecInfo.maxResolutionAVC ? DeviceCodecInfo.maxResolutionAVC : "1280*720";
    let maxResolutionHevc = DeviceCodecInfo.maxResolutionHevc ? DeviceCodecInfo.maxResolutionHevc : "1920*1080";
    let maxResolutionAV1 = DeviceCodecInfo.maxResolutionAV1 ? DeviceCodecInfo.maxResolutionAV1 : "1920*1080";

    let avcResolution = maxResolutionAVC.split('*');
    let hevcResolution = maxResolutionHevc.split('*');
    let av1Resolution = maxResolutionAV1.split('*');

    var profile = {
        Name: 'AndroidTV-Profile',
        MaxStreamingBitrate: 120000000,
        MaxStaticBitrate: 100000000,
        MusicStreamingTranscodingBitrate: 384000,
        DirectPlayProfiles: [
            {
                "Container": "asf,hls,m4v,mkv,mov,mp4,ogm,ogv,ts,vob,webm,wmv,xvid",
                //"AudioCodec": "aac,aac_latm,ac3,alac,dca,dts,eac3,flac,mlp,mp2,mp3,opus,pcm_alaw,pcm_mulaw,pcm_s16le,pcm_s20le,pcm_s24le,truehd,vorbis",
                "AudioCodec": DeviceCodecInfo.audioList,
                "VideoCodec": (DeviceCodecInfo.supportsAV1 ? "av1," : "") +
                    (DeviceCodecInfo.supportsAVC ? "h264," : "") +
                    (DeviceCodecInfo.supportsHevc ? "hevc," : "") + "mpeg,mpeg2video,vp8,vp9",
                "Type": "Video"
            },
            {
                "Container": "",
                "AudioCodec": DeviceCodecInfo.audioList,
                "VideoCodec": "",
                "Type": "Audio"
            },
            { 'Type': 'Photo' }
        ],
        CodecProfiles: [
            DeviceCodecInfo.supportsAVC ? {
                "Type": "Video",
                "Codec": "h264",
                "Conditions": [
                    {
                        "Condition": "EqualsAny",
                        "Property": "VideoProfile",
                        "Value": "high|main|baseline|constrained baseline" + (DeviceCodecInfo.supportsAVCHigh10 ? "|high 10" : ""),
                        "IsRequired": false
                    },
                    {
                        "Condition": "LessThanEqual",
                        "Property": "VideoLevel",
                        "Value": DeviceCodecInfo.avcMainLevel,
                        "IsRequired": false
                    },
                    {
                        "Condition": "LessThanEqual",
                        "Property": "Width",
                        "Value": avcResolution[0],
                        "IsRequired": false
                    },
                    {
                        "Condition": "LessThanEqual",
                        "Property": "Height",
                        "Value": avcResolution[1],
                        "IsRequired": false
                    }
                ]
            } : {},
            DeviceCodecInfo.supportsHevc ? {
                "Type": "Video",
                "Codec": "hevc",
                "Conditions": [
                    {
                        "Condition": "EqualsAny",
                        "Property": "VideoProfile",
                        "Value": "main",
                        "IsRequired": false
                    },
                    {
                        "Condition": "EqualsAny",
                        "Property": "VideoRangeType",
                        "Value": "SDR|HDR10|HLG",
                        "IsRequired": false
                    },
                    {
                        "Condition": "LessThanEqual",
                        "Property": "VideoLevel",
                        "Value": DeviceCodecInfo.hevcMainLevel,
                        "IsRequired": false
                    },
                    {
                        "Condition": "LessThanEqual",
                        "Property": "Width",
                        "Value": hevcResolution[0],
                        "IsRequired": false
                    },
                    {
                        "Condition": "LessThanEqual",
                        "Property": "Height",
                        "Value": hevcResolution[1],
                        "IsRequired": false
                    }
                ]
            } : {},
            DeviceCodecInfo.supportsAV1 ? {
                "Type": "Video",
                "Codec": "av1"
            } : {}
        ],
        TranscodingProfiles: [
            {
                "Container": "ts",
                "Type": "Video",
                "VideoCodec":
                    (DeviceCodecInfo.supportsAV1 ? "av1," : "") +
                    (DeviceCodecInfo.supportsHevc ? "hevc," : "") +
                    (DeviceCodecInfo.supportsAVC ? "h264," : "") + "vp9,vp8,mpeg4,mpeg2video",
                "AudioCodec": DeviceCodecInfo.audioList,
                "Protocol": "hls",
                "EnableSubtitlesInManifest": true,
                "Conditions": [],
                'MaxAudioChannels': '2'
            },
            {
                "Container": "mp3",
                "Type": "Audio",
                "VideoCodec": "",
                "AudioCodec": "mp3",
                "Protocol": "http",
                "Conditions": []
            }
        ],
        SubtitleProfiles: [
            { "Format": "vtt", "Method": "Embed" },
            { "Format": "vtt", "Method": "External" },
            { "Format": "vtt", "Method": "Hls" },
            { "Format": "webvtt", "Method": "Embed" },
            { "Format": "webvtt", "Method": "External" },
            { "Format": "webvtt", "Method": "Hls" },
            { "Format": "srt", "Method": "Embed" },
            { "Format": "srt", "Method": "External" },
            { "Format": "subrip", "Method": "Embed" },
            { "Format": "subrip", "Method": "External" },
            { "Format": "ttml", "Method": "Embed" },
            { "Format": "ttml", "Method": "External" },
            { "Format": "dvbsub", "Method": "Embed" },
            { "Format": "dvbsub", "Method": "Encode" },
            { "Format": "dvdsub", "Method": "Embed" },
            { "Format": "dvdsub", "Method": "Encode" },
            { "Format": "idx", "Method": "Embed" },
            { "Format": "idx", "Method": "Encode" },
            { "Format": "pgs", "Method": "Embed" },
            { "Format": "pgs", "Method": "Encode" },
            { "Format": "pgssub", "Method": "Embed" },
            { "Format": "pgssub", "Method": "Encode" },
            { "Format": "ass", "Method": "Encode" },
            { "Format": "ssa", "Method": "Encode" }
        ],
        'ResponseProfiles': [],
        'ContainerProfiles': []
    }

    if (localStorage.getItem('forceDirectPlay') == 'true') {
        profile['DirectPlayProfiles'] = [{ Type: 'Video' }, { Type: 'Audio' }, { "Type": "Photo" }];
        profile['TranscodingProfiles'] = [
            {
                "Container": "ts",
                "Type": "Video",
                "Protocol": "hls",
                "EnableSubtitlesInManifest": true,
                "Conditions": [],
                'MaxAudioChannels': '2'
            },
            {
                "Container": "mp3",
                "Type": "Audio",
                "VideoCodec": "",
                "AudioCodec": "mp3",
                "Protocol": "http",
                "Conditions": []
            }
        ]
    }

    return profile;
}