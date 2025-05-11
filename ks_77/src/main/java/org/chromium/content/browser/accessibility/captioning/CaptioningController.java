package org.chromium.content.browser.accessibility.captioning;

import android.annotation.TargetApi;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge;
import org.chromium.content_public.browser.WebContents;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/captioning/CaptioningController.class */
public class CaptioningController implements SystemCaptioningBridge.SystemCaptioningBridgeListener {
    private SystemCaptioningBridge mSystemCaptioningBridge = CaptioningBridgeFactory.getSystemCaptioningBridge();
    private long mNativeCaptioningController;

    private native long nativeInit(WebContents webContents);

    private native void nativeSetTextTrackSettings(long j, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public CaptioningController(WebContents webContents) {
        this.mNativeCaptioningController = nativeInit(webContents);
    }

    @CalledByNative
    private void onDestroy() {
        this.mNativeCaptioningController = 0L;
    }

    @CalledByNative
    private void onRenderProcessChange() {
        this.mSystemCaptioningBridge.syncToListener(this);
    }

    @Override // org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge.SystemCaptioningBridgeListener
    @TargetApi(19)
    public void onSystemCaptioningChanged(TextTrackSettings settings) {
        if (this.mNativeCaptioningController == 0) {
            return;
        }
        nativeSetTextTrackSettings(this.mNativeCaptioningController, settings.getTextTracksEnabled(), settings.getTextTrackBackgroundColor(), settings.getTextTrackFontFamily(), settings.getTextTrackFontStyle(), settings.getTextTrackFontVariant(), settings.getTextTrackTextColor(), settings.getTextTrackTextShadow(), settings.getTextTrackTextSize());
    }

    public void startListening() {
        this.mSystemCaptioningBridge.addListener(this);
    }

    public void stopListening() {
        this.mSystemCaptioningBridge.removeListener(this);
    }
}
