package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.view.PointerIcon;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.chromium.base.annotations.DoNotInline;

@DoNotInline
@TargetApi(24)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/compat/ApiHelperForN.class */
public final class ApiHelperForN {
    private ApiHelperForN() {
    }

    public static boolean shouldOverrideUrlLoading(WebViewClient webViewClient, WebView webView, WebResourceRequest request) {
        return webViewClient.shouldOverrideUrlLoading(webView, request);
    }

    public static JobInfo getPendingJob(JobScheduler scheduler, int jobId) {
        return scheduler.getPendingJob(jobId);
    }

    public static boolean startDragAndDrop(View view, ClipData data, View.DragShadowBuilder shadowBuilder, Object myLocalState, int flags) {
        return view.startDragAndDrop(data, shadowBuilder, myLocalState, flags);
    }

    public static void setPointerIcon(View view, PointerIcon icon) {
        view.setPointerIcon(icon);
    }

    public static PointerIcon createPointerIcon(Bitmap bitmap, float width, float height) {
        return PointerIcon.create(bitmap, width, height);
    }

    public static void setCryptoInfoPattern(MediaCodec.CryptoInfo cryptoInfo, int encrypt, int skip) {
        cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(encrypt, skip));
    }

    public static void setVrModeEnabled(Activity activity, boolean enabled, ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        activity.setVrModeEnabled(enabled, requestedComponent);
    }
}
