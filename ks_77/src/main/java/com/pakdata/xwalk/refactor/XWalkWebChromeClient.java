package com.pakdata.xwalk.refactor;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import com.pakdata.xwalk.refactor.XWalkGeolocationPermissions;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkWebChromeClient.class */
public class XWalkWebChromeClient {
    private long XWALK_MAX_QUOTA = 104857600;

    public void onReceivedIcon(XWalkView view, Bitmap icon) {
    }

    public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(this.XWALK_MAX_QUOTA);
    }

    public void onReachedMaxAppCacheSize(long requiredStorage, long quota, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(this.XWALK_MAX_QUOTA);
    }

    public void onGeolocationPermissionsShowPrompt(String origin, XWalkGeolocationPermissions.Callback callback) {
        callback.invoke(origin, false, false);
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public boolean onJsTimeout() {
        return true;
    }

    @Deprecated
    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId());
        return false;
    }

    public void getVisitedHistory(ValueCallback<String[]> callback) {
    }

    public void setInstallableWebApp() {
    }

    public void setupAutoFill(Message msg) {
    }
}
