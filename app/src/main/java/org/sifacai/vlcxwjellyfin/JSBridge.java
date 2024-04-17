package org.sifacai.vlcxwjellyfin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;

import org.chromium.ui.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class JSBridge {
    String TAG = "JSBridge";
    Context context;

    public JSBridge(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void toExtPlayer(String url){
        MainActivity ma = (MainActivity)context;
        ma.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Uri uri = Uri.parse(url);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setDataAndType(uri, "video/*");
                    ma.startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT);
                }
            }
        });
    }

    @JavascriptInterface
    public void toVlcPlayer(String JsonStr){
        try {
            JSONObject options = new JSONObject(JsonStr);
            String url = options.getString("url");
            if(!url.equals("")){
                ((MainActivity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        VLCPlayer player = new VLCPlayer(context);
                        player.init();
                        player.setMedia(url);
                        ((MainActivity)context).addContentView(player,
                                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                        player.playORpause();
                    }
                });
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @JavascriptInterface
    public void setPlaybackRate(String rate) {
        org.libvlc.Global.setPlaybackRate(Float.valueOf(rate));
    }

    @JavascriptInterface
    public float getPlaybackRate() {
        return org.libvlc.Global.getPlaybackRate();
    }

    @JavascriptInterface
    public void setAudioTrackId(int index) {
        org.libvlc.Global.setAudioTrackId(index);
    }

    @JavascriptInterface
    public void setSubtitleTrackId(int index) {
        org.libvlc.Global.setSubtitleTrackId(index);
    }

    @JavascriptInterface
    public int getAudioTrackId() {
        return org.libvlc.Global.getCurrentAudioTrackId();
    }

    @JavascriptInterface
    public int getSubtitleTrackId() {
        return org.libvlc.Global.getCurrentSubtitleTrackId();
    }

    @JavascriptInterface
    public String getSubtitleTracksInfo() {
        Log.d(TAG, "getSubtitleTracksInfo: ");
        String s = "[";
        HashMap<String, Integer> info = org.libvlc.Global.getSubtitleTracksInfo();
        if (info != null) {
            for (String key : info.keySet()) {
                if (s == "[") s += getTrackJsonStr(key, info.get(key));
                else s += "," + getTrackJsonStr(key, info.get(key));
            }
        }
        return s + "]";
    }

    @JavascriptInterface
    public String getAudioTracksInfo() {
        String s = "[";
        HashMap<String, Integer> info = org.libvlc.Global.getAudioTracksInfo();
        if (info != null) {
            for (String key : info.keySet()) {
                if (s == "[") s += getTrackJsonStr(key, info.get(key));
                else s += "," + getTrackJsonStr(key, info.get(key));
            }
        }
        return s + "]";
    }

    public String getTrackJsonStr(String name, int index) {
        return "{\"DisplayTitle\":\"" + name + "\",\"Index\":" + index + "}";
    }

    @JavascriptInterface
    public void addExternalTrack(String json) {
        try {
            JSONArray tracks = new JSONArray(json);
            for (int i = 0; i < tracks.length(); i++) {
                JSONObject t = tracks.getJSONObject(i);
                Uri uri = Uri.parse((String) t.get("DeliveryUrl"));
                org.libvlc.Global.addExternalTrack(t.getString("Type"), uri, false);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @JavascriptInterface
    public void appExit() {
        Log.d(TAG, "appExit: ");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("确认退出？");
        builder.setTitle("确认退出");
        builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                System.exit(0);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @JavascriptInterface
    public String getAppName() {
        try {
            PackageManager packageManager = context.getPackageManager();
            return String.valueOf(packageManager.getApplicationLabel(context.getApplicationInfo()));
        } catch (Throwable e) {

        }
        return "";
    }


    /**
     * 获取当前app version code
     */
    @JavascriptInterface
    public long getAppVersionCode() {
        long appVersionCode = 0;
        try {
            PackageInfo packageInfo = context.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                appVersionCode = packageInfo.getLongVersionCode();
            } else {
                appVersionCode = packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {

        }
        return appVersionCode;
    }

    /**
     * 获取当前app version name
     */
    @JavascriptInterface
    public String getAppVersionName() {
        String appVersionName = "";
        try {
            PackageInfo packageInfo = context.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            appVersionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("", e.getMessage());
        }
        return appVersionName;
    }

    /**
     * 设备名称
     *
     * @return 设备名称
     */
    @JavascriptInterface
    public String getDeviceName() {
        return Build.DEVICE;
    }

    /**
     * 获取设备ID
     *
     * @return
     */
    @JavascriptInterface
    public String getDeviceId() {
        return ("Android_" + Build.MANUFACTURER + "_" +
                Build.BRAND + "_" +
                Build.MODEL + "_" +
                Build.SERIAL).replace(" ", "-");
    }

}
