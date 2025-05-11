package org.chromium.content.browser.accessibility.captioning;

import org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/captioning/EmptyCaptioningBridge.class */
public class EmptyCaptioningBridge implements SystemCaptioningBridge {
    @Override // org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge
    public void syncToListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
    }

    @Override // org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge
    public void addListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
    }

    @Override // org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge
    public void removeListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
    }
}
