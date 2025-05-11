package org.sifacai.vlcxwjellyfin;

import static android.media.MediaCodecInfo.CodecProfileLevel.AVCLevel4;
import static android.media.MediaCodecInfo.CodecProfileLevel.H263Level10;
import static android.media.MediaCodecInfo.CodecProfileLevel.H263Level45;
import static android.media.MediaFormat.MIMETYPE_VIDEO_H263;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Log;
import android.util.Range;
import android.util.Size;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeviceProfile {
    String TAG = "设备支持：";

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

    boolean supportsAVC = false;
    boolean supportsAVCHigh10 = false;
    int avcMainLevel = 0;
    int avcHigh10Level = 0;
    boolean supportsHevc = false;
    boolean supportsHevcMain10 = false;
    int hevcMainLevel = 0;
    int hevcMain10Level = 0;
    boolean supportsAV1 = false;
    boolean supportsAV1Main10 = false;
    String maxResolutionAVC = null; //mediaTest.getMaxResolution(MimeTypes.VIDEO_H264)
    String maxResolutionHevc = null; //mediaTest.getMaxResolution(MimeTypes.VIDEO_H265)
    String maxResolutionAV1 = null; //mediaTest.getMaxResolution(MimeTypes.VIDEO_AV1)

    ArrayList<String> audioList = new ArrayList<>();

    public String getMediaCodecInfo() {
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo curInfo = MediaCodecList.getCodecInfoAt(i);
            if (!curInfo.isEncoder()) {
                String[] types = curInfo.getSupportedTypes();

                for (String mimetype : types) {
                    MediaCodecInfo.CodecCapabilities capabilities = curInfo.getCapabilitiesForType(mimetype);

                    mimetype = mimetype.toLowerCase();
                    if (mimetype.startsWith("audio/")) {
                        AppendAudio(mimetype);
                    } else if (mimetype.startsWith("video/")) {
                        switch (mimetype.toLowerCase()) {
                            case "video/avc":
                                supportsAVC = true;
                                supportsAVCHigh10 = hasDecoder(mimetype, MediaCodecInfo.CodecProfileLevel.AVCProfileHigh10, AVCLevel4);
                                avcMainLevel = getAVCLevel(MediaCodecInfo.CodecProfileLevel.AVCProfileMain);
                                avcHigh10Level = getAVCLevel(MediaCodecInfo.CodecProfileLevel.AVCProfileHigh10);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    Size size = getMaxResolution(mimetype);
                                    maxResolutionAVC = size.getWidth() + "*" + size.getHeight();
                                }else {
                                    maxResolutionAVC = "1280*720";
                                }
                                break;
                            case "video/hevc":
                                supportsHevc = true;
                                supportsHevcMain10 = hasDecoder(mimetype, MediaCodecInfo.CodecProfileLevel.HEVCProfileMain10, MediaCodecInfo.CodecProfileLevel.HEVCMainTierLevel4);
                                hevcMainLevel = getHevcLevel(MediaCodecInfo.CodecProfileLevel.HEVCProfileMain);
                                hevcMain10Level = getHevcLevel(MediaCodecInfo.CodecProfileLevel.HEVCProfileMain10);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    Size size = getMaxResolution(mimetype);
                                    maxResolutionHevc = size.getWidth() + "*" + size.getHeight();
                                }
                                break;
                            case "video/av01":
                                supportsAV1 = true;
                                supportsAV1Main10 = hasDecoder(mimetype, MediaCodecInfo.CodecProfileLevel.AV1ProfileMain10, MediaCodecInfo.CodecProfileLevel.AV1Level5);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    Size size = getMaxResolution(mimetype);
                                    maxResolutionAV1 = size.getWidth() + "*" + size.getHeight();
                                }
                                break;
                        }
                    }
                }
            }
        }

        JSONObject jo = new JSONObject();
        try {
            jo.put("supportsAVC", supportsAVC);
            jo.put("supportsAVCHigh10", supportsAVCHigh10);
            jo.put("avcMainLevel", avcMainLevel);
            jo.put("avcHigh10Level", avcHigh10Level);
            jo.put("supportsHevc", supportsHevc);
            jo.put("supportsHevcMain10", supportsHevcMain10);
            jo.put("hevcMainLevel", hevcMainLevel);
            jo.put("hevcMain10Level", hevcMain10Level);
            jo.put("supportsAV1", supportsAV1);
            jo.put("supportsAV1Main10", supportsAV1Main10);
            jo.put("maxResolutionAVC", maxResolutionAVC);
            jo.put("maxResolutionHevc", maxResolutionHevc);
            jo.put("maxResolutionAV1", maxResolutionAV1);
            jo.put("audioList", String.join(",", audioList));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jo.toString();
    }

    public String AppendAudio(String mimetype) {
        String type = mimetype.replace("audio/", "");
        switch (type) {
            case "mpeg":
                type = "mp3";
                break;
            case "3gpp":
                type = "3gp";
                break;
        }
        if(audioList.indexOf(type) == -1){
            audioList.add(type);
        }
        return type;
    }

    public int getAVCLevel(int profile) {
        int level = getDecoderLevel("video/avc", profile);
        int aLevel = 0;
        for (int key : avcLevels.keySet()) {
            if (key == level) return avcLevels.get(key);
            if (key > level) return aLevel;
            aLevel = avcLevels.get(key);
        }
        return 0;
    }

    public int getHevcLevel(int profile) {
        int level = getDecoderLevel("video/hevc", profile);
        int hLevel = 0;
        for (int key : hevcLevels.keySet()) {
            if (key == level) return hevcLevels.get(key);
            if (key > level) return hLevel;
            hLevel = hevcLevels.get(key);
        }

        return 0;
    }

    public int getDecoderLevel(String mime, int profile) {
        int maxLevel = 0;
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);

            if (codecInfo.isEncoder()) continue;

            boolean supp = false;
            for (String type : codecInfo.getSupportedTypes()) {
                if (type.equals(mime)) {
                    supp = true;
                    break;
                }
            }
            if (!supp) continue;

            MediaCodecInfo.CodecCapabilities capabilities = codecInfo.getCapabilitiesForType(mime);
            for (MediaCodecInfo.CodecProfileLevel profileLevel : capabilities.profileLevels) {
                if (profileLevel.profile != profile) continue;

                if (profileLevel.profile == profile) {                     //profileLevel.level;
                    if (maxLevel < profileLevel.level) {
                        maxLevel = profileLevel.level;
                    }
                }
            }
        }

        return maxLevel;
    }

    private boolean hasDecoder(String mime, int profile, int level) {
        return supports(mime, profile, level);
    }

    private boolean supports(String mime, int profile, int level) {
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo info = MediaCodecList.getCodecInfoAt(i);
            if (info.isEncoder()) continue;

            try {
                MediaCodecInfo.CodecCapabilities caps = info.getCapabilitiesForType(mime);
                for (MediaCodecInfo.CodecProfileLevel pl : caps.profileLevels) {
                    if (pl.profile != profile) {
                        continue;
                    }
                    // H.263 levels are not completely ordered:
                    // Level45 support only implies Level10 support
                    if (mime.equalsIgnoreCase(MIMETYPE_VIDEO_H263)) {
                        if (pl.level != level && pl.level == H263Level45 && level > H263Level10) {
                            continue;
                        }
                    }
                    if (pl.level >= level) {
                        return true;
                    }
                }
            } catch (IllegalArgumentException e) {
            }

        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Size getMaxResolution(String mime) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);

            if (codecInfo.isEncoder()) continue;

            boolean supp = false;
            for (String type : codecInfo.getSupportedTypes()) {
                if (type.equals(mime)) {
                    supp = true;
                    break;
                }
            }
            if (!supp) continue;

            MediaCodecInfo.CodecCapabilities capabilities = codecInfo.getCapabilitiesForType(mime);
            MediaCodecInfo.VideoCapabilities videoCapabilities = capabilities.getVideoCapabilities();
            if (videoCapabilities != null) {
                Range wr = videoCapabilities.getSupportedWidths();
                if (wr != null) {
                    maxWidth = (int) wr.getUpper();
                }
                Range hr = videoCapabilities.getSupportedHeights();
                if (hr != null) {
                    maxHeight = (int) hr.getUpper();
                }
            }

            break;
        }

        return new Size(maxWidth, maxHeight);
    }
}
