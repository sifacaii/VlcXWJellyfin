package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Process;
import android.view.ActionMode;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.chromium.base.annotations.DoNotInline;

@DoNotInline
@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/compat/ApiHelperForM.class */
public final class ApiHelperForM {
    private ApiHelperForM() {
    }

    public static void onPageCommitVisible(WebViewClient webViewClient, WebView webView, String url) {
        webViewClient.onPageCommitVisible(webView, url);
    }

    public static boolean isProcess64Bit() {
        return Process.is64Bit();
    }

    public static Network getBoundNetworkForProcess(ConnectivityManager connectivityManager) {
        return connectivityManager.getBoundNetworkForProcess();
    }

    public static long getNetworkHandle(Network network) {
        return network.getNetworkHandle();
    }

    public static Network getActiveNetwork(ConnectivityManager connectivityManager) {
        return connectivityManager.getActiveNetwork();
    }

    public static NetworkInfo getNetworkInfo(ConnectivityManager connectivityManager, Network network) {
        return connectivityManager.getNetworkInfo(network);
    }

    public static void requestActivityPermissions(Activity activity, String[] permissions, int requestCode) {
        activity.requestPermissions(permissions, requestCode);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
        return activity.shouldShowRequestPermissionRationale(permission);
    }

    public static boolean isPermissionRevokedByPolicy(Activity activity, String permission) {
        return activity.getPackageManager().isPermissionRevokedByPolicy(permission, activity.getPackageName());
    }

    public static void invalidateContentRectOnActionMode(ActionMode actionMode) {
        actionMode.invalidateContentRect();
    }

    public static void onWindowFocusChangedOnActionMode(ActionMode actionMode, boolean gainFocus) {
        actionMode.onWindowFocusChanged(gainFocus);
    }

    public static int getActionModeType(ActionMode actionMode) {
        return actionMode.getType();
    }

    public static long getDefaultActionModeHideDuration() {
        return ViewConfiguration.getDefaultActionModeHideDuration();
    }

    public static void hideActionMode(ActionMode actionMode, long duration) {
        actionMode.hide(duration);
    }
}
