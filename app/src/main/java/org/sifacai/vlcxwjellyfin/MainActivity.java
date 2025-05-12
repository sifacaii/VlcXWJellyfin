package org.sifacai.vlcxwjellyfin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.http.SslError;
import android.net.http.UrlRequest;
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

import com.pakdata.xwalk.refactor.XWalkClient;
import com.pakdata.xwalk.refactor.XWalkPreferences;
import com.pakdata.xwalk.refactor.XWalkResourceClient;
import com.pakdata.xwalk.refactor.XWalkSettings;
import com.pakdata.xwalk.refactor.XWalkUIClient;
import com.pakdata.xwalk.refactor.XWalkView;
import com.pakdata.xwalk.refactor.XWalkWebChromeClient;
import com.pakdata.xwalk.refactor.XWalkWebResourceRequest;
import com.pakdata.xwalk.refactor.XWalkWebResourceResponse;

import org.xwalk.core.XWalkInitializer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements XWalkInitializer.XWalkInitListener {

    private static final String TAG = "MainActivity";

    FrameLayout parent;
    XWalkInitializer xWalkInitializer;
    XWalkView xWalkView;

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

        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);
        XWalkPreferences.setValue(XWalkPreferences.ALLOW_UNIVERSAL_ACCESS_FROM_FILE,true);

        parent = findViewById(R.id.main);

        xWalkInitializer = new XWalkInitializer(this, this);
        xWalkInitializer.initAsync();

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                xWalkView.evaluateJavascript("window.InnerComponents.goBack()", null);
            }
        });
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
        loadXWalkview();
    }

    public void loadXWalkview() {

        xWalkView = new XWalkView(this);

        xWalkView.addJavascriptInterface(new JSBridge(this, xWalkView), "NativeApi");

        xWalkView.setUIClient(new MXWalkUIClient(xWalkView));

        xWalkView.setResourceClient(new XWalkResourceClient() {
            @Override
            public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView view, XWalkWebResourceRequest request) {
                String path = request.getUrl().getPath();
                if (path == null) return null;
                InputStream is = null;
                try {
                    if (path.toLowerCase(Locale.ROOT).matches(".*/main\\.[^/\\s]+\\.bundle\\.js") && !request.getUrl().getQuery().contains("deferred")) {
                        is = getAssets().open("native/injectionScript.js");
                    } else if (path.endsWith("NativeShell.js")) {
                        is = getAssets().open("native/NativeShell.js");
                    } else if (path.endsWith("ExternalPlayerPlugin.js")) {
                        is = getAssets().open("native/ExternalPlayerPlugin.js");
                    } else if (path.endsWith("clientSetting.js")) {
                        is = getAssets().open("native/clientSetting.js");
                    } else if (path.endsWith("clientSetting.html")) {
                        is = getAssets().open("native/clientSetting.html");
                        return new XWalkWebResourceResponse("text/html", "UTF-8", is);
                    }
                } catch (IOException e) {
                    Log.e(TAG, "shouldInterceptLoadRequest: " + e.getMessage().toString(), null);
                }
                if (is == null) {
                    return super.shouldInterceptLoadRequest(view, request);
                } else {
                    return new XWalkWebResourceResponse("application/javascript", "UTF-8", is);
                }
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
        settings.setUserAgentString("chrome/77.0.3865.92 crosswalk/77.0.3.0");

        parent.addView(xWalkView,
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        String url = "file:///android_asset/index.html";
        xWalkView.loadUrl(url);
    }
}