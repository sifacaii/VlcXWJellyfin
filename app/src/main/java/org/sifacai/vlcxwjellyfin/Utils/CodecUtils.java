package org.sifacai.vlcxwjellyfin.Utils;

import static android.media.MediaCodecInfo.CodecProfileLevel.AV1Level73;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.util.Size;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CodecUtils {
    String TAG = "解码器：";

    // AVC levels转换到ffprobe等级 *10
    public static final Map<Integer, Integer> avcLevels = new HashMap<>();

    static {
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel1b, 9);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel1, 10);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel11, 11);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel12, 12);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel13, 13);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel2, 20);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel21, 21);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel22, 22);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel3, 30);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel31, 31);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel32, 32);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel4, 40);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel41, 41);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel42, 42);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel5, 50);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel51, 51);
        avcLevels.put(MediaCodecInfo.CodecProfileLevel.AVCLevel52, 52);
    }

    // HEVC levels转换到ffprobe等级 *30
    public static final Map<Integer, Integer> hevcLevels = new HashMap<>();

    static {
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel1, 30);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel2, 60);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel21, 63);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel3, 90);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel31, 93);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel4, 120);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel41, 123);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel5, 150);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel51, 153);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel52, 156);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel6, 180);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel61, 183);
        hevcLevels.put(MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel62, 186);
    }

    public int[] av1Levels = new int[]{
            MediaCodecInfo.CodecProfileLevel.AV1Level2,
            MediaCodecInfo.CodecProfileLevel.AV1Level21,
            MediaCodecInfo.CodecProfileLevel.AV1Level22,
            MediaCodecInfo.CodecProfileLevel.AV1Level23,
            MediaCodecInfo.CodecProfileLevel.AV1Level3,
            MediaCodecInfo.CodecProfileLevel.AV1Level31,
            MediaCodecInfo.CodecProfileLevel.AV1Level32,
            MediaCodecInfo.CodecProfileLevel.AV1Level33,
            MediaCodecInfo.CodecProfileLevel.AV1Level4,
            MediaCodecInfo.CodecProfileLevel.AV1Level41,
            MediaCodecInfo.CodecProfileLevel.AV1Level42,
            MediaCodecInfo.CodecProfileLevel.AV1Level43,
            MediaCodecInfo.CodecProfileLevel.AV1Level5,
            MediaCodecInfo.CodecProfileLevel.AV1Level51,
            MediaCodecInfo.CodecProfileLevel.AV1Level52,
            MediaCodecInfo.CodecProfileLevel.AV1Level53,
            MediaCodecInfo.CodecProfileLevel.AV1Level6,
            MediaCodecInfo.CodecProfileLevel.AV1Level61,
            MediaCodecInfo.CodecProfileLevel.AV1Level62,
            MediaCodecInfo.CodecProfileLevel.AV1Level63,
            MediaCodecInfo.CodecProfileLevel.AV1Level7,
            MediaCodecInfo.CodecProfileLevel.AV1Level71,
            MediaCodecInfo.CodecProfileLevel.AV1Level72,
            MediaCodecInfo.CodecProfileLevel.AV1Level73
    };

    public HashMap<String, ArrayList> codecs = new HashMap<>();
    public ArrayList<MediaCodecInfo> mediaCodecInfos = new ArrayList<>();
    public ArrayList<String> audioList = new ArrayList<>();

    public CodecUtils() {
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo info = MediaCodecList.getCodecInfoAt(i);
            if (info.isEncoder()) continue;
            for (String mimetype : info.getSupportedTypes()) {
                if (mimetype.startsWith("audio/")) {
                    AppendAudio(mimetype);
                }
                if (mimetype.startsWith("video/")) {
                    if (!codecs.containsKey(mimetype))
                        codecs.put(mimetype, new ArrayList<MediaCodecInfo>());
                    ArrayList<MediaCodecInfo> infos = codecs.get(mimetype);
                    infos.add(info);
                }
            }
        }
    }

    private String AppendAudio(String mimetype) {
        String type = mimetype.replace("audio/", "");
        switch (type) {
            case "mpeg":
                type = "mp3";
                break;
            case "3gpp":
                type = "3gp";
                break;
        }
        if (audioList.indexOf(type) == -1) {
            audioList.add(type);
        }
        return type;
    }

    public boolean isSupport(String mime) {
        return codecs.containsKey(mime);
    }

    public boolean hasProfile(String mime, int profile) {
        if (!codecs.containsKey(mime)) return false;
        ArrayList<MediaCodecInfo> infos = codecs.get(mime);
        for (MediaCodecInfo info : infos) {
            MediaCodecInfo.CodecCapabilities capabilities = info.getCapabilitiesForType(mime);
            for (MediaCodecInfo.CodecProfileLevel profileLevel : capabilities.profileLevels) {
                if (profileLevel.profile == profile) return true;
            }
        }
        return false;
    }

    public boolean hasProfile(String mime, int profile, int level) {
        if (!codecs.containsKey(mime)) return false;
        ArrayList<MediaCodecInfo> infos = codecs.get(mime);
        for (MediaCodecInfo info : infos) {
            MediaCodecInfo.CodecCapabilities capabilities = info.getCapabilitiesForType(mime);
            for (MediaCodecInfo.CodecProfileLevel profileLevel : capabilities.profileLevels) {
                if (profileLevel.profile == profile && profileLevel.level == level) return true;
            }
        }
        return false;
    }

    public int getVideoLevel(String mime) {
        int level = 0;
        ArrayList<MediaCodecInfo> infos = codecs.get(mime);
        for (MediaCodecInfo info : infos) {
            MediaCodecInfo.CodecCapabilities capabilities = info.getCapabilitiesForType(mime);
            for (MediaCodecInfo.CodecProfileLevel profileLevel : capabilities.profileLevels) {
                //Log.d(TAG, String.format("%s %s: profile:%d , level:%d",info.getName(),mime,profileLevel.profile,profileLevel.level));
                if(profileLevel.level > level) level = profileLevel.level;
            }
        }
        return level;
    }

    public int getAVClevel() {
        int videoLevel = getVideoLevel(MediaFormat.MIMETYPE_VIDEO_AVC);
        Integer l = null;
        if (videoLevel > 0) {
            l = (videoLevel > MediaCodecInfo.CodecProfileLevel.AVCLevel52) ? 52 : avcLevels.get(videoLevel);
        }
        return l == null ? 41 : l;
    }

    public int getHEVClevel() {
        int videoLevel = getVideoLevel(MediaFormat.MIMETYPE_VIDEO_HEVC);
        Integer l = null;
        if (videoLevel > 0) {
            for (int key : hevcLevels.keySet()){
                if(key >= videoLevel){
                    l = hevcLevels.get(key);
                }
            }
        }
        return l == null ? 120 : l;
    }

    public int getAV1level() {
        int videoLevel = getVideoLevel(MediaFormat.MIMETYPE_VIDEO_AV1);
        Integer l = 0;
        if (videoLevel > AV1Level73) {
            l = 23;
        } else {
            for (int seq = 0; seq < av1Levels.length; seq++) {
                if (av1Levels[seq] == videoLevel) {
                    l = seq;
                    break;
                }
            }
        }
        return l == null ? 12 : l;
    }

    public void test(String mime) {
        ArrayList<MediaCodecInfo> infos = codecs.get(mime);
        for (MediaCodecInfo info : infos) {
            MediaCodecInfo.CodecCapabilities capabilities = info.getCapabilitiesForType(mime);
            for (MediaCodecInfo.CodecProfileLevel profileLevel : capabilities.profileLevels) {
                Log.d(TAG, String.format("%s %s：profilea：%d，level：%d", mime, info.getName(), profileLevel.profile, profileLevel.level));
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public String getMaxResolution(String mime) {
        int maxWidth = 0;
        int maxHeight = 0;

        ArrayList<MediaCodecInfo> infos = codecs.get(mime);
        for (MediaCodecInfo info : infos) {
            MediaCodecInfo.CodecCapabilities capabilities = info.getCapabilitiesForType(mime);
            int width = capabilities.getVideoCapabilities().getSupportedWidths().getUpper();
            int height = capabilities.getVideoCapabilities().getSupportedHeights().getUpper();
            if(width > maxWidth && height > maxHeight){
                maxWidth = width;
                maxHeight = height;
            }
        }

        return String.format("%d*%d",maxWidth,maxHeight);
    }

}
