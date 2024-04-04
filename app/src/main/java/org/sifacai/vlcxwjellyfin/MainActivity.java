package org.sifacai.vlcxwjellyfin;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
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
import java.nio.charset.StandardCharsets;
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

        allowSelfCertificate();

        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);

        parent = findViewById(R.id.main);

        xWalkInitializer = new XWalkInitializer(this, this);
        xWalkInitializer.initAsync();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        xWalkView.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_ESCAPE));
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

        xWalkView = new XWalkView(this);

        xWalkView.addJavascriptInterface(new JSBridge(this),"NativeApi");

        xWalkView.setResourceClient(new XWalkResourceClient() {
            @Override
            public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView view, XWalkWebResourceRequest request) {
                //Log.d(TAG, "shouldInterceptLoadRequest: " + request.getUrl());
                if (request.getUrl().toString().contains("&fromJellyfin")) {
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

        xWalkView.getSettings().setCacheMode(XWalkSettings.LOAD_NO_CACHE);

        parent.addView(xWalkView,
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        String url = "file:///android_asset/dist/index.html";
        xWalkView.loadUrl(url);

    }

    private void allowSelfCertificate() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            X509Certificate[] myTrustedAnchors = new X509Certificate[0];
                            return myTrustedAnchors;
                        }

                        @Override
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        } catch (Exception e) {
            Toast.makeText(this,"SSL证书错误",Toast.LENGTH_SHORT);
        }
    }
}