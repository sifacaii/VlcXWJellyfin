package org.chromium.content.browser.accessibility.captioning;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/captioning/SystemCaptioningBridge.class */
public interface SystemCaptioningBridge {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/captioning/SystemCaptioningBridge$SystemCaptioningBridgeListener.class */
    public interface SystemCaptioningBridgeListener {
        void onSystemCaptioningChanged(TextTrackSettings textTrackSettings);
    }

    void syncToListener(SystemCaptioningBridgeListener systemCaptioningBridgeListener);

    void addListener(SystemCaptioningBridgeListener systemCaptioningBridgeListener);

    void removeListener(SystemCaptioningBridgeListener systemCaptioningBridgeListener);
}
