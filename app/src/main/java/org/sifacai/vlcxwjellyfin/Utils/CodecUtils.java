package org.sifacai.vlcxwjellyfin.Utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Log;

import org.json.JSONArray;
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

    private CodecProfileLevelList.CodecProfileLevelAdapter getMaxProfile(String mime,Object[] codecProfileLevelList) {
        CodecProfileLevelList.CodecProfileLevelAdapter maxCP = null;
        for(Object o : codecProfileLevelList) {
            CodecProfileLevelList.CodecProfileLevelAdapter cp = (CodecProfileLevelList.CodecProfileLevelAdapter) o;
            if(mime != cp.getMimetype()) continue;

            if(maxCP == null || cp.getProfile() > maxCP.getProfile()){
                maxCP = cp;
            }
        }
        return maxCP;
    }

    private Object[] getSupportedCodecProfileLevels() {
        CodecProfileLevelList profileLevels = new CodecProfileLevelList();

        for (String mime : codecs.keySet()) {
            ArrayList<MediaCodecInfo> infos = codecs.get(mime);
            for (MediaCodecInfo info : infos) {
                MediaCodecInfo.CodecCapabilities capabilities = info.getCapabilitiesForType(mime);
                for (MediaCodecInfo.CodecProfileLevel profileLevel : capabilities.profileLevels) {
                    profileLevels.addCodecProfileLevel(mime, profileLevel);
                }
            }
        }

        return profileLevels.toArray();
    }

    public String getSupportedCodec() {
        JSONObject proJson = new JSONObject();

        JSONArray ja = new JSONArray();
        Object[] cplas = getSupportedCodecProfileLevels();

        for (String mime : codecs.keySet()) {
            CodecProfileLevelList.CodecProfileLevelAdapter cp = getMaxProfile(mime,cplas);
            if(cp!= null){
                String mimetype = mime.replace("video/", "");
                if (mimetype.endsWith("vp9")) mimetype = "vp9";
                if (mimetype.endsWith("vp8")) mimetype = "vp8";
                try {
                    ja.put(
                            new JSONObject().put("mime",mimetype)
                                    .put("profile",cp.getProfile())
                                    .put("level",cp.getLevel())
                    );
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        try {
            proJson.put("audiolist", String.join(",", audioList));
            proJson.put("videolist",ja);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return proJson.toString();
    }
}
