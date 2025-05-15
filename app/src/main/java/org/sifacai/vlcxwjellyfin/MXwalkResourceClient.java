package org.sifacai.vlcxwjellyfin;

import android.net.http.SslError;
import android.util.Log;
import android.webkit.ValueCallback;

import com.pakdata.xwalk.refactor.XWalkResourceClient;
import com.pakdata.xwalk.refactor.XWalkView;
import com.pakdata.xwalk.refactor.XWalkWebResourceRequest;
import com.pakdata.xwalk.refactor.XWalkWebResourceResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class MXwalkResourceClient extends XWalkResourceClient {

    @Override
    public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView view, XWalkWebResourceRequest request) {
        String path = request.getUrl().getPath();
        if (path == null) return null;
        InputStream is = null;
        try {
            if (path.toLowerCase(Locale.ROOT).matches(".*/main\\.[^/\\s]+\\.bundle\\.js") && !request.getUrl().getQuery().contains("deferred")) {
                is = view.getContext().getAssets().open("native/injectionScript.js");
            } else if (path.endsWith("NativeShell.js")) {
                is = view.getContext().getAssets().open("native/NativeShell.js");
            } else if (path.endsWith("ExternalPlayerPlugin.js")) {
                is = view.getContext().getAssets().open("native/ExternalPlayerPlugin.js");
            } else if (path.endsWith("clientSetting.js")) {
                is = view.getContext().getAssets().open("native/clientSetting.js");
            } else if (path.endsWith("clientSetting.html")) {
                is = view.getContext().getAssets().open("native/clientSetting.html");
                return new XWalkWebResourceResponse("text/html", "UTF-8", is);
            } else if (path.endsWith("DeviceProfile.js")) {
                is = view.getContext().getAssets().open("native/DeviceProfile.js");
            }
        } catch (IOException e) {
            Log.e("MXwalkResourceClient", "shouldInterceptLoadRequest: " + e.getMessage().toString(), null);
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
}
