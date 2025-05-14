package org.sifacai.vlcxwjellyfin.Utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class CodecUtils {
    String TAG = "解码器：";

    public HashMap<String, ArrayList> codecs = new HashMap<>();
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

    private MediaCodecInfo.CodecProfileLevel getMaxProfile(String mime) {
        MediaCodecInfo.CodecProfileLevel cpl = null;
        ArrayList<MediaCodecInfo> infos = codecs.get(mime);
        for (MediaCodecInfo info : infos) {
            MediaCodecInfo.CodecCapabilities capabilities = info.getCapabilitiesForType(mime);
            for (MediaCodecInfo.CodecProfileLevel profileLevel : capabilities.profileLevels) {
                if (cpl == null || profileLevel.profile > cpl.profile) cpl = profileLevel;
            }
        }
        return cpl;
    }

    private Object[] getSupportedCodecProfileLevels() {
        CodecProfileLevelList profileLevels = new CodecProfileLevelList();

        for (String mimetype : codecs.keySet()) {
            MediaCodecInfo.CodecProfileLevel profile = getMaxProfile(mimetype);
            if (profile != null) profileLevels.addCodecProfileLevel(mimetype, profile);
        }

        return profileLevels.toArray();
    }

    public String getSupportedCodec() {
        JSONObject proJson = new JSONObject();
        Object[] cplas = getSupportedCodecProfileLevels();
        for (Object o : cplas) {
            CodecProfileLevelList.CodecProfileLevelAdapter cp = (CodecProfileLevelList.CodecProfileLevelAdapter) o;
            String mime = cp.getMimetype();
            mime = mime.replace("video/","");
            if(mime.endsWith("vp9")) mime="vp9";
            if(mime.endsWith("vp8")) mime="vp8";
            try {
                proJson.put(
                        mime,
                        new JSONObject()
                                .put("profile", cp.getProfile())
                                .put("level", cp.getLevel())
                );
            } catch (JSONException e) {
                Log.e(TAG, "getSupportedCodec: ", e);
            }
        }

        try {
            proJson.put("audiolist",String.join(",",audioList));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return proJson.toString();
    }

}
