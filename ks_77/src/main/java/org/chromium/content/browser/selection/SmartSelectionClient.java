package org.chromium.content.browser.selection;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.textclassifier.TextClassifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.content_public.browser.SelectionMetricsLogger;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.WindowAndroid;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SmartSelectionClient.class */
public class SmartSelectionClient implements SelectionClient {
    private static final int NUM_EXTRA_CHARS = 240;
    private long mNativeSmartSelectionClient;
    private SmartSelectionProvider mProvider;
    private SelectionClient.ResultCallback mCallback;
    private SmartSelectionMetricsLogger mSmartSelectionMetricLogger;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SmartSelectionClient$RequestType.class */
    private @interface RequestType {
        public static final int CLASSIFY = 0;
        public static final int SUGGEST_AND_CLASSIFY = 1;
    }

    private native long nativeInit(WebContents webContents);

    private native void nativeRequestSurroundingText(long j, int i, int i2);

    private native void nativeCancelAllRequests(long j);

    static {
        $assertionsDisabled = !SmartSelectionClient.class.desiredAssertionStatus();
    }

    public static SmartSelectionClient create(SelectionClient.ResultCallback callback, WebContents webContents) {
        WindowAndroid windowAndroid = webContents.getTopLevelNativeWindow();
        if (Build.VERSION.SDK_INT < 26 || windowAndroid == null || !isDeviceProvisioned(windowAndroid.getContext().get()) || webContents.isIncognito()) {
            return null;
        }
        return new SmartSelectionClient(callback, webContents, windowAndroid);
    }

    private SmartSelectionClient(SelectionClient.ResultCallback callback, WebContents webContents, WindowAndroid windowAndroid) {
        if (!$assertionsDisabled && Build.VERSION.SDK_INT < 26) {
            throw new AssertionError();
        }
        this.mProvider = new SmartSelectionProvider(callback, windowAndroid);
        this.mCallback = callback;
        this.mSmartSelectionMetricLogger = SmartSelectionMetricsLogger.create(windowAndroid.getContext().get());
        this.mNativeSmartSelectionClient = nativeInit(webContents);
    }

    @CalledByNative
    private void onNativeSideDestroyed(long nativeSmartSelectionClient) {
        if (!$assertionsDisabled && nativeSmartSelectionClient != this.mNativeSmartSelectionClient) {
            throw new AssertionError();
        }
        this.mNativeSmartSelectionClient = 0L;
        this.mProvider.cancelAllRequests();
    }

    @Override // org.chromium.content_public.browser.SelectionClient
    public void onSelectionChanged(String selection) {
    }

    @Override // org.chromium.content_public.browser.SelectionClient
    public void onSelectionEvent(int eventType, float posXPix, float posYPix) {
    }

    @Override // org.chromium.content_public.browser.SelectionClient
    public void selectWordAroundCaretAck(boolean didSelect, int startAdjust, int endAdjust) {
    }

    @Override // org.chromium.content_public.browser.SelectionClient
    public boolean requestSelectionPopupUpdates(boolean shouldSuggest) {
        requestSurroundingText(shouldSuggest ? 1 : 0);
        return true;
    }

    @Override // org.chromium.content_public.browser.SelectionClient
    public void cancelAllRequests() {
        if (this.mNativeSmartSelectionClient != 0) {
            nativeCancelAllRequests(this.mNativeSmartSelectionClient);
        }
        this.mProvider.cancelAllRequests();
    }

    @Override // org.chromium.content_public.browser.SelectionClient
    public SelectionMetricsLogger getSelectionMetricsLogger() {
        return this.mSmartSelectionMetricLogger;
    }

    @Override // org.chromium.content_public.browser.SelectionClient
    public void setTextClassifier(TextClassifier textClassifier) {
        this.mProvider.setTextClassifier(textClassifier);
    }

    @Override // org.chromium.content_public.browser.SelectionClient
    public TextClassifier getTextClassifier() {
        return this.mProvider.getTextClassifier();
    }

    @Override // org.chromium.content_public.browser.SelectionClient
    public TextClassifier getCustomTextClassifier() {
        return this.mProvider.getCustomTextClassifier();
    }

    private void requestSurroundingText(int callbackData) {
        if (this.mNativeSmartSelectionClient == 0) {
            onSurroundingTextReceived(callbackData, CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE, 0, 0);
        } else {
            nativeRequestSurroundingText(this.mNativeSmartSelectionClient, 240, callbackData);
        }
    }

    @CalledByNative
    private void onSurroundingTextReceived(int callbackData, String text, int start, int end) {
        if (!textHasValidSelection(text, start, end)) {
            this.mCallback.onClassified(new SelectionClient.Result());
            return;
        }
        switch (callbackData) {
            case 0:
                this.mProvider.sendClassifyRequest(text, start, end);
                return;
            case 1:
                this.mProvider.sendSuggestAndClassifyRequest(text, start, end);
                return;
            default:
                if (!$assertionsDisabled) {
                    throw new AssertionError("Unexpected callback data");
                }
                return;
        }
    }

    private static boolean isDeviceProvisioned(Context context) {
        return context == null || context.getContentResolver() == null || Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) != 0;
    }

    private boolean textHasValidSelection(String text, int start, int end) {
        return !TextUtils.isEmpty(text) && 0 <= start && start < end && end <= text.length();
    }
}
