package org.sifacai.vlcxwjellyfin;

import static android.media.MediaFormat.MIMETYPE_VIDEO_AV1;
import static android.media.MediaFormat.MIMETYPE_VIDEO_AVC;
import static android.media.MediaFormat.MIMETYPE_VIDEO_HEVC;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import org.json.JSONException;
import org.json.JSONObject;
import org.sifacai.vlcxwjellyfin.Utils.CodecUtils;


public class DeviceProfile {
    String TAG = "解码器：";

    public String getDeviceProfile() {
        JSONObject jo = new JSONObject();
        CodecUtils cu = new CodecUtils();
        try {
            jo.put("audioList",String.join(",",cu.audioList));

            if(cu.isSupport(MediaFormat.MIMETYPE_VIDEO_VP8)) {
                jo.put("vp8", true);
            }
            if(cu.isSupport(MediaFormat.MIMETYPE_VIDEO_VP9)){
                jo.put("vp9",true);
                jo.put("vp9Level",cu.getVideoLevel(MediaFormat.MIMETYPE_VIDEO_VP9));
            }
            if(cu.isSupport(MIMETYPE_VIDEO_AVC)){
                jo.put("h264",true);
                jo.put("h264High10" ,cu.hasProfile(MIMETYPE_VIDEO_AVC,MediaCodecInfo.CodecProfileLevel.AVCProfileHigh10,MediaCodecInfo.CodecProfileLevel.AVCLevel4));
                jo.put("h264Level",cu.getAVClevel());
            }
            if(cu.isSupport(MIMETYPE_VIDEO_HEVC)){
                jo.put("hevc",true);
                jo.put("hevcHigh10",cu.hasProfile(MIMETYPE_VIDEO_HEVC,MediaCodecInfo.CodecProfileLevel.HEVCProfileMain10, MediaCodecInfo.CodecProfileLevel.HEVCHighTierLevel4));
                jo.put("hevcLevel",cu.getHEVClevel());
            }
            if(cu.isSupport(MIMETYPE_VIDEO_AV1)){
                jo.put("av1",true);
                jo.put("av1Level",cu.getAV1level());
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jo.toString();
    }
}
