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

            getDeviceProfile: testProfiles,

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


function testProfiles(profileBuilder) {
    let p = profileBuilder();

    p['TranscodingProfiles'] = [
        {
            "Container": "ts",
            "Type": "Video",
            "VideoCodec": "hevc",
            "AudioCodec": "mp3,aac",
            "Context": "Streaming",
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
    ];

    return p;
}


function getDeviceProfileAndroid(profileBuilder) {
    console.log(window);
}
