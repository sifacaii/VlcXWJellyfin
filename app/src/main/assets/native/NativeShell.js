(function (AppInfo) {
    'use strict';

    // 禁用 hls.js 播放器
    window.MediaSource = null;

    var AppInfo = {
        deviceId: window['NativeApi'].getDeviceId(),
        deviceName: window['NativeApi'].getDeviceName(),
        appName: window['NativeApi'].getAppName(),
        appVersion: window['NativeApi'].getAppVersionCode()
    };

    // List of supported features
    var SupportedFeatures = [
        'fullscreenchange',
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

    //默认布局
    var defaultLayout = window['NativeApi'].getLayout() || 'tv';

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
                return defaultLayout;
            },

            getDeviceProfile: getDeviceProfileAndroid,

            supports: function (command) {
                if (command === 'fullscreenchange' && defaultLayout === 'tv') return false;

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
        },

        disableFullscreen() {
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

const CodecProfiles = [];
if (DeviceCodecInfo.vp9) {
    CodecProfiles.push({
        "Type": "Video",
        "Codec": "vp9",
        "Conditions": [
            {
                "Condition": "EqualsAny",
                "Property": "VideoRangeType",
                "Value": "SDR",
                "IsRequired": false
            }
        ]
    });
}
if (DeviceCodecInfo.h264) {
    CodecProfiles.push(
        {
            "Type": "Video",
            "Codec": "h264",
            "Conditions": [
                {
                    "Condition": "EqualsAny",
                    "Property": "VideoProfile",
                    "Value": "high|main|baseline|constrained baseline" + (DeviceCodecInfo.h264High10 ? "|high 10" : ""),
                    "IsRequired": false
                },
                {
                    "Condition": "LessThanEqual",
                    "Property": "VideoLevel",
                    "Value": DeviceCodecInfo.h264Level ? DeviceCodecInfo.h264Level : 41,
                    "IsRequired": false
                }
            ]
        }
    );
}
if (DeviceCodecInfo.hevc) {
    CodecProfiles.push(
        {
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
                    "Condition": "LessThanEqual",
                    "Property": "VideoLevel",
                    "Value": DeviceCodecInfo.hevcLevel ? DeviceCodecInfo.hevcLevel : 120,
                    "IsRequired": false
                }
            ]
        }
    );
}
if (DeviceCodecInfo.av1) {
    CodecProfiles.push(
        {
            "Type": "Video",
            "Codec": "av1",
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
                    "Value": "SDR",
                    "IsRequired": false
                },
                {
                    "Condition": "LessThanEqual",
                    "Property": "VideoLevel",
                    "Value": DeviceCodecInfo.av1Level ? DeviceCodecInfo.av1Level : 15,
                    "IsRequired": false
                }
            ]
        }
    );
}

const VideoCodec = (DeviceCodecInfo.av1 ? "av1," : "") +
    (DeviceCodecInfo.hevc ? "hevc," : "") +
    (DeviceCodecInfo.h264 ? "h264," : "") +
    (DeviceCodecInfo.vp9 ? "vp9," : "") +
    (DeviceCodecInfo.vp8 ? "vp8," : "") +
    "mpeg,mpeg2video";

const DirectPlayProfiles = [
    {
        "Container": "asf,hls,m4v,mkv,mov,mp4,ogm,ogv,ts,vob,webm,wmv,xvid",
        "AudioCodec": DeviceCodecInfo.audioList,
        "VideoCodec": VideoCodec,
        "Type": "Video"
    },
    {
        "Container": "",
        "AudioCodec": DeviceCodecInfo.audioList,
        "Type": "Audio"
    },
    { 'Type': 'Photo' }
]

function getDeviceProfileAndroid(profileBuilder) {

    var profile = {
        Name: 'AndroidTV-Profile',
        MaxStreamingBitrate: 120000000,
        MaxStaticBitrate: 100000000,
        MusicStreamingTranscodingBitrate: 384000,
        DirectPlayProfiles: DirectPlayProfiles,
        CodecProfiles: CodecProfiles,
        TranscodingProfiles: [
            {
                "Container": "ts",
                "Type": "Video",
                "VideoCodec": VideoCodec,
                "AudioCodec": DeviceCodecInfo.audioList,
                "Protocol": "hls",
                "EnableSubtitlesInManifest": true,
                "Conditions": [],
                'MaxAudioChannels': '2'
            },
            {
                "Container": "mp3",
                "Type": "Audio",
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
                "AudioCodec": "mp3",
                "Protocol": "http",
                "Conditions": []
            }
        ]
    }

    return profile;
}