/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
*/
(function (AppInfo) {
    'use strict';

    var AppInfo = {
        deviceId: window.NativeApi.getDeviceId(),
        deviceName: window.NativeApi.getDeviceName(),
        appName: window.NativeApi.getAppName(),
        appVersion: window.NativeApi.getAppVersionName()
    };

    // List of supported features
    var SupportedFeatures = [
        'exit',
        'externallinks',
        'externallinkdisplay',
        'htmlaudioautoplay',
        'htmlvideoautoplay',
        'imageanalysis',
        'displaylanguage',
        'otherapppromotions',
        'targetblank',
        'screensaver',
        //'subtitleappearancesettings',
        //'subtitleburnsettings',
        'multiserver',
        'clientsettings',
        'remotecontrol',
        'remotevideo',
        'displaymode',
        'exitmenu'
    ];

    var plugins = [
        '_mpvVideoPlayer',
        '_clientSetting'
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
                window.NativeApi.appExit();
            },

            getDefaultLayout: function () {
                return 'tv';
            },

            getDeviceProfile: createDeviceProfile,

            getSyncProfile: createDeviceProfile,

            supports: function (command) {
                var isSupported = command && SupportedFeatures.indexOf(command.toLowerCase()) != -1;
                return isSupported;
            }
        },

        // selectServer: function () {
        // },

        downloadFile: function (url) {
        },

        enableFullscreen: function () {
            return true;
        },

        disableFullscreen: function () {
        },

        openClientSettings: function () {
            window.clientSetting();
        },

        getPlugins: function () {
            return plugins;
        },

        openUrl: function (url, target) {
        },

        updateMediaSession: function (mediaInfo) {
        },

        hideMediaSession: function () {
        }
    };

})();

function createDeviceProfile(profileBuilder) {
    return {
        'Name': 'Jellyfin Media Player',
        'MusicStreamingTranscodingBitrate': 1280000,
        'TimelineOffsetSeconds': 5,
        'TranscodingProfiles': [
            { 'Type': 'Audio' },
            {
                'Container': 'ts',
                'Type': 'Video',
                'Protocol': 'hls',
                'AudioCodec': 'aac,mp3,ac3,opus,flac,vorbis',
                'VideoCodec': 'h264,h265,hevc,mpeg4,mpeg2video',
                'MaxAudioChannels': '6'
            },
            { 'Container': 'jpeg', 'Type': 'Photo' }
        ],
        'DirectPlayProfiles': [{ 'Type': 'Video' }, { 'Type': 'Audio' }, { 'Type': 'Photo' }],
        'ResponseProfiles': [],
        'ContainerProfiles': [],
        'CodecProfiles': [],
        'SubtitleProfiles': [
            { 'Format': 'srt', 'Method': 'External' },
            { 'Format': 'srt', 'Method': 'Embed' },
            { 'Format': 'ass', 'Method': 'External' },
            { 'Format': 'ass', 'Method': 'Embed' },
            { 'Format': 'sub', 'Method': 'Embed' },
            { 'Format': 'sub', 'Method': 'External' },
            { 'Format': 'ssa', 'Method': 'Embed' },
            { 'Format': 'ssa', 'Method': 'External' },
            { 'Format': 'smi', 'Method': 'Embed' },
            { 'Format': 'smi', 'Method': 'External' },
            { 'Format': 'pgssub', 'Method': 'Embed' },
            { 'Format': 'dvdsub', 'Method': 'Embed' },
            { 'Format': 'pgs', 'Method': 'Embed' }
        ]
    };
}