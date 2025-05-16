package org.sifacai.vlcxwjellyfin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pakdata.xwalk.refactor.XWalkPreferences;
import com.pakdata.xwalk.refactor.XWalkSettings;
import com.pakdata.xwalk.refactor.XWalkView;

import org.xwalk.core.XWalkInitializer;

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

        xWalkView.setResourceClient(new MXwalkResourceClient());

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