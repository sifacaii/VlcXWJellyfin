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

import com.pakdata.xwalk.refactor.XWalkView;

import org.chromium.ui.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class JSBridge {
    String TAG = "JSBridge";
    Context context;
    XWalkView xWalkView;

    public JSBridge(Context context, XWalkView xWalkView) {
        this.context = context;
        this.xWalkView = xWalkView;
    }

    @JavascriptInterface
    public void toExtPlayer(String url) {
        MainActivity ma = (MainActivity) context;
        ma.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Uri uri = Uri.parse(url);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setDataAndType(uri, "video/*");
                    ma.startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT);
                }
            }
        });
    }

    @JavascriptInterface
    public void toServerSelect() {
        ((MainActivity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                xWalkView.loadUrl("file:///android_asset/index.html?autoConnect=false");
            }
        });
    }

    @JavascriptInterface
    public void setLayout(String layout) {
        String ua = "chrome/77.0.3865.92 crosswalk/77.0.3.0 iphone";
        if(layout.equals("tv")){
            ua = "chrome/77.0.3865.92 crosswalk/77.0.3.0 web0s";
        }
        String finalUa = ua;
        ((MainActivity)context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                xWalkView.setUserAgentString(finalUa);
            }
        });
    }

    @JavascriptInterface
    public void exitApp() {
        exitApp(null);
    }

    @JavascriptInterface
    public void exitApp(String lj) {
        if (lj != null) {
            System.exit(0);
        } else {
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
    }

    @JavascriptInterface
    public String getMediaCodecInfo(){
        DeviceProfile dp = new DeviceProfile();
        return dp.getMediaCodecInfo();
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
