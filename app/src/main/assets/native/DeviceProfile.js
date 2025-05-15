class DeviceCodecInfo {
    profile = {
        Name: 'AndroidTV-Profile',
        MaxStreamingBitrate: 120000000,
        MaxStaticBitrate: 100000000,
        MusicStreamingTranscodingBitrate: 384000,
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

    constructor() {
        this.codecInfo = JSON.parse(window.NativeApi.getMediaCodecInfo());
        console.log(this.codecInfo);
        this.audiolist = this.codecInfo.audiolist;
        this.videolist = this.codecInfo.videolist;

        this.CodecProfiles = [];
        this.VideoCodec = [];

        this.init();
    }

    init() {
        this.videolist.forEach(ele => {
            switch (ele.mime) {
                case 'avc':
                    this.avc(ele);
                    break;
                case 'hevc':
                    this.hevc(ele);
                    break;
                case 'vp8':
                    this.vp8(ele);
                    break;
                case 'vp9':
                    this.vp9(ele);
                    break;
                case 'av01':
                    this.av1(ele);
                    break
            }
        });
    }

    avc(ele) {
        let cp = {
            "Type": "Video",
            "Codec": "h264",
            "Conditions": [
                {
                    "Condition": "EqualsAny",
                    "Property": "VideoProfile",
                    "Value": "main|baseline|constrained baseline" +
                        (ele.profile >= 3 ? "|high" : "") +
                        (ele.profile >= 4 ? "|high 10" : ""),
                    "IsRequired": false
                }, {
                    "Condition": "LessThanEqual",
                    "Property": "VideoLevel",
                    "Value": ele.level,
                    "IsRequired": false
                }
            ]
        }
        this.CodecProfiles.push(cp);
        this.VideoCodec.push('h264');
    }

    hevc(ele) {
        let cp = {
            "Type": "Video",
            "Codec": "hevc",
            "Conditions": [
                {
                    "Condition": "EqualsAny",
                    "Property": "VideoProfile",
                    "Value": "main" + (ele.profile >= 17 ? "|main 10" : ""),
                    "IsRequired": false
                }, {

                    "Condition": "LessThanEqual",
                    "Property": "VideoLevel",
                    "Value": ele.level,
                    "IsRequired": false

                }
            ]
        }
        this.CodecProfiles.push(cp);
        this.VideoCodec.push('hevc');
    }

    vp8(ele) {
        let cp = {
            "Type": "Video",
            "Codec": "vp8",
            "Conditions": [{
                "Condition": "LessThanEqual",
                "Property": "VideoLevel",
                "Value": ele.level,
                "IsRequired": false
            }]
        }
        this.CodecProfiles.push(cp);
        this.VideoCodec.push('vp8');
    }

    vp9(ele) {
        let l = ele.level / 10;
        let cp = {
            "Type": "Video",
            "Codec": "vp9",
            "Conditions": [
                {
                    "Condition": "EqualsAny",
                    "Property": "VideoRangeType",
                    "Value": "SDR",
                    "IsRequired": false
                }, {
                    "Condition": "LessThanEqual",
                    "Property": "VideoLevel",
                    "Value": l.toString(),
                    "IsRequired": false
                }
            ]
        }
        this.CodecProfiles.push(cp);
        this.VideoCodec.push('vp9');
    }

    av1(ele) {
        let cp = {
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
                }, {
                    "Condition": "LessThanEqual",
                    "Property": "VideoLevel",
                    "Value": ele.level,
                    "IsRequired": false
                }
            ]
        }
        this.CodecProfiles.push(cp);
        this.VideoCodec.push('av1');
    }

    getProfiles() {
        this.profile['CodecProfiles'] = this.CodecProfiles;

        this.profile['DirectPlayProfiles'] = [
            {
                "Container": "asf,hls,m4v,mkv,mov,mp4,ogm,ogv,ts,vob,webm,wmv,xvid",
                "AudioCodec": this.audiolist,
                "VideoCodec": this.VideoCodec.join(','),
                "Type": "Video"
            },
            {
                "Container": "",
                "AudioCodec": this.audiolist,
                "Type": "Audio"
            },
            { 'Type': 'Photo' }
        ]

        this.profile['TranscodingProfiles'] = [
            {
                "Container": "ts",
                "Type": "Video",
                "VideoCodec": this.VideoCodec.join(','),
                "AudioCodec": this.audiolist,
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
        ]

        if (localStorage.getItem('forceDirectPlay') == 'true') {
            this.profile['DirectPlayProfiles'] = [{ Type: 'Video' }, { Type: 'Audio' }, { "Type": "Photo" }];
            this.profile['TranscodingProfiles'] = [
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

        return this.profile;
    }

}

window.DeviceProfile = new DeviceCodecInfo();