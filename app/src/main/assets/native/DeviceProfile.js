class DeviceCodecInfo {
    profile = {
        Name: 'AndroidTV-Profile',
        MaxStreamingBitrate: 120000000,
        MaxStaticBitrate: 100000000,
        MusicStreamingTranscodingBitrate: 384000,
        SubtitleProfiles: [
            {
                "Format": "vtt",
                "Method": "External"
            },
            {
                "Format": "ass",
                "Method": "External"
            },
            {
                "Format": "ssa",
                "Method": "External"
            }
        ],
        'ResponseProfiles': [],
        'ContainerProfiles': []
    }

    MaxVideoWidth = {
        Condition: 'LessThanEqual',
        Property: 'Width',
        Value: 1280,
        IsRequired: false
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

        this.CodecProfiles.push({
            "Type": "Video",
            "Conditions": [this.MaxVideoWidth]
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

        let audios = [];
        let selectTranscodeVideoAudioCodec = localStorage.getItem("selectTranscodeVideoAudioCodec") || "";
        if (selectTranscodeVideoAudioCodec === "") {
            audios = this.audiolist.slice();
        } else {
            audios.push(selectTranscodeVideoAudioCodec);
        }

        if (localStorage.getItem('forceDirectPlay') == 'true') {
            this.profile['CodecProfiles'] = [];
            this.profile['DirectPlayProfiles'] = [{ Type: 'Video' }, { Type: 'Audio' }, { "Type": "Photo" }];
            this.profile['TranscodingProfiles'] = [];
            return this.profile;
        }

        let maxVideoWidth = localStorage.getItem('MaxVideoWidth') || 0;
        maxVideoWidth = maxVideoWidth == 0 ? 1280 : maxVideoWidth;
        this.MaxVideoWidth.Value = maxVideoWidth;

        this.profile['CodecProfiles'] = this.CodecProfiles;

        this.profile['DirectPlayProfiles'] = [
            {
                "Container": "m4v,mov,xvid,vob,wmv,ogm,ogv,mp4,webm",
                "AudioCodec": audios.join(','),
                "VideoCodec": this.VideoCodec.join(','),
                "Type": "Video"
            },
            {
                "Container": "",
                "AudioCodec": audios.join(','),
                "Type": "Audio"
            },
            { 'Type': 'Photo' }
        ]

        let maxAudioChannels = localStorage.getItem('AllowedAudioChannels') || -1;
        maxAudioChannels = maxAudioChannels == -1 ? 2 : maxAudioChannels;

        this.profile['TranscodingProfiles'] = [
            {
                "Container": "ts",
                "Type": "Video",
                "VideoCodec": this.VideoCodec.join(','),
                "AudioCodec": audios.join(','),
                "Context": "Streaming",
                "Protocol": "hls",
                'MaxAudioChannels': maxAudioChannels
            },
            {
                "Container": "mp3",
                "Type": "Audio",
                "AudioCodec": "mp3",
                "Protocol": "http",
                "Conditions": []
            }
        ]

        return this.profile;
    }

}

window.DeviceProfile = new DeviceCodecInfo();