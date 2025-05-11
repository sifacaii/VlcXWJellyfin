package org.chromium.content.browser.accessibility.captioning;

import android.os.Build;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/captioning/CaptioningBridgeFactory.class */
public class CaptioningBridgeFactory {
    public static SystemCaptioningBridge getSystemCaptioningBridge() {
        if (Build.VERSION.SDK_INT >= 19) {
            return KitKatCaptioningBridge.getInstance();
        }
        return new EmptyCaptioningBridge();
    }
}
