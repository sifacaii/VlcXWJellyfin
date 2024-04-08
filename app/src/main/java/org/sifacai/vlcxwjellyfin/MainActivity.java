package org.sifacai.vlcxwjellyfin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pakdata.xwalk.refactor.XWalkPreferences;
import com.pakdata.xwalk.refactor.XWalkResourceClient;
import com.pakdata.xwalk.refactor.XWalkSettings;
import com.pakdata.xwalk.refactor.XWalkView;
import com.pakdata.xwalk.refactor.XWalkWebResourceRequest;
import com.pakdata.xwalk.refactor.XWalkWebResourceResponse;

import org.xwalk.core.XWalkInitializer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity extends AppCompatActivity implements XWalkInitializer.XWalkInitListener {

    private static final String TAG = "MainActivity";

    FrameLayout parent;
    XWalkInitializer xWalkInitializer;
    XWalkView xWalkView;

    int deviceType;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);

        parent = findViewById(R.id.main);

        xWalkInitializer = new XWalkInitializer(this, this);
        xWalkInitializer.initAsync();

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(deviceType == Utils.DeviceType.TV) {
                    xWalkView.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ESCAPE));
                }else{
                    xWalkView.goBack();
                }
            }
        });
    }

    private void checkDeviceType() {
        deviceType = Utils.getDeviceType(this);
        if(deviceType == Utils.DeviceType.UNKNOWN){
            askDeviceType();
        }else{
            loadXWalkview();
        }
    }

    AlertDialog dialog;
    private void askDeviceType() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.devices_type_select, null);

        Button tvb=view.findViewById(R.id.tvbutton);
        Button mbb=view.findViewById(R.id.mbbutton);

        tvb.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    ViewCompat.animate(v).scaleX(1.2f).scaleY(1.2f).start();
                }else{
                    ViewCompat.animate(v).scaleX(1f).scaleY(1f).start();
                }
            }
        });

        mbb.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    ViewCompat.animate(v).scaleX(1.2f).scaleY(1.2f).start();
                }else{
                    ViewCompat.animate(v).scaleX(1f).scaleY(1f).start();
                }
            }
        });

        tvb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                deviceType = Utils.DeviceType.TV;
                Utils.setDeviceType(MainActivity.this,deviceType);
            }
        });

        mbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                deviceType = Utils.DeviceType.MOBILE;
                Utils.setDeviceType(MainActivity.this,deviceType);
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择设备类型");
        builder.setMessage(R.string.device_select_desc);
        builder.setView(view);
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                loadXWalkview();
            }
        });

        dialog.show();
    }

    @Override
    public void onXWalkInitStarted() {

    }

    @Override
    public void onXWalkInitCancelled() {

    }

    @Override
    public void onXWalkInitFailed() {

    }

    @Override
    public void onXWalkInitCompleted() {
        checkDeviceType();
    }

    public void loadXWalkview() {

        xWalkView = new XWalkView(this);

        xWalkView.addJavascriptInterface(new JSBridge(this), "NativeApi");

        xWalkView.setResourceClient(new XWalkResourceClient() {
            @Override
            public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView view, XWalkWebResourceRequest request) {
                //Log.d(TAG, "shouldInterceptLoadRequest: " + request.getUrl());
                String url = request.getUrl().toString();
                if (!url.toLowerCase().contains(".m3u8") && url.contains("&fromJellyfin") ) {
                    String m3u8 = "#EXTM3U\n" +
                            "#EXT-X-TARGETDURATION:1";
                    InputStream is = new ByteArrayInputStream(m3u8.getBytes());
                    return new XWalkWebResourceResponse("audio/x-mpegurl", "UTF-8", is);
                }
                return super.shouldInterceptLoadRequest(view, request);
            }

            @Override
            public void onReceivedSslError(XWalkView view, ValueCallback<Boolean> callback, SslError error) {
                //super.onReceivedSslError(view, callback, error);
                callback.onReceiveValue(true);
            }
        });

        XWalkSettings settings = xWalkView.getSettings();
        settings.setCacheMode(XWalkSettings.LOAD_NO_CACHE);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        if(deviceType == Utils.DeviceType.TV){
            settings.setUserAgentString("mozilla/5.0 applewebkit/537.36 (khtml, like gecko) chrome/77.0.3865.92 crosswalk/77.0.3.0 safari/537.36");
        }else{
            settings.setUserAgentString("mozilla/5.0 applewebkit/537.36 (khtml, like gecko) chrome/77.0.3865.92 crosswalk/77.0.3.0 mobile safari/537.36");
        }

//        DisplayMetrics metrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int mDensity = metrics.densityDpi;
//
//        int tz = 100 - (mDensity / 10);
//        settings.setTextZoom(tz);

        parent.addView(xWalkView,
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        String url = "file:///android_asset/dist/index.html";
        xWalkView.loadUrl(url);
    }
}