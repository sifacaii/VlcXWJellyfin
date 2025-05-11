package org.chromium.content.browser.accessibility.captioning;

import android.annotation.TargetApi;
import android.view.accessibility.CaptioningManager;
import java.util.Locale;
import org.chromium.base.ContextUtils;
import org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge;

@TargetApi(19)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/captioning/KitKatCaptioningBridge.class */
public class KitKatCaptioningBridge implements SystemCaptioningBridge {
    private final CaptioningManager.CaptioningChangeListener mCaptioningChangeListener = new KitKatCaptioningChangeListener();
    private final CaptioningChangeDelegate mCaptioningChangeDelegate = new CaptioningChangeDelegate();
    private final CaptioningManager mCaptioningManager = (CaptioningManager) ContextUtils.getApplicationContext().getSystemService("captioning");
    private static KitKatCaptioningBridge sKitKatCaptioningBridge;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/captioning/KitKatCaptioningBridge$KitKatCaptioningChangeListener.class */
    private class KitKatCaptioningChangeListener extends CaptioningManager.CaptioningChangeListener {
        private KitKatCaptioningChangeListener() {
        }

        @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
        public void onEnabledChanged(boolean enabled) {
            KitKatCaptioningBridge.this.mCaptioningChangeDelegate.onEnabledChanged(enabled);
        }

        @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
        public void onFontScaleChanged(float fontScale) {
            KitKatCaptioningBridge.this.mCaptioningChangeDelegate.onFontScaleChanged(fontScale);
        }

        @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
        public void onLocaleChanged(Locale locale) {
            KitKatCaptioningBridge.this.mCaptioningChangeDelegate.onLocaleChanged(locale);
        }

        @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
        public void onUserStyleChanged(CaptioningManager.CaptionStyle userStyle) {
            CaptioningStyle captioningStyle = KitKatCaptioningBridge.this.getCaptioningStyleFrom(userStyle);
            KitKatCaptioningBridge.this.mCaptioningChangeDelegate.onUserStyleChanged(captioningStyle);
        }
    }

    public static KitKatCaptioningBridge getInstance() {
        if (sKitKatCaptioningBridge == null) {
            sKitKatCaptioningBridge = new KitKatCaptioningBridge();
        }
        return sKitKatCaptioningBridge;
    }

    private KitKatCaptioningBridge() {
    }

    private void syncToDelegate() {
        this.mCaptioningChangeDelegate.onEnabledChanged(this.mCaptioningManager.isEnabled());
        this.mCaptioningChangeDelegate.onFontScaleChanged(this.mCaptioningManager.getFontScale());
        this.mCaptioningChangeDelegate.onLocaleChanged(this.mCaptioningManager.getLocale());
        this.mCaptioningChangeDelegate.onUserStyleChanged(getCaptioningStyleFrom(this.mCaptioningManager.getUserStyle()));
    }

    @Override // org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge
    public void syncToListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
        if (!this.mCaptioningChangeDelegate.hasActiveListener()) {
            syncToDelegate();
        }
        this.mCaptioningChangeDelegate.notifyListener(listener);
    }

    @Override // org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge
    public void addListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
        if (!this.mCaptioningChangeDelegate.hasActiveListener()) {
            this.mCaptioningManager.addCaptioningChangeListener(this.mCaptioningChangeListener);
            syncToDelegate();
        }
        this.mCaptioningChangeDelegate.addListener(listener);
        this.mCaptioningChangeDelegate.notifyListener(listener);
    }

    @Override // org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge
    public void removeListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
        this.mCaptioningChangeDelegate.removeListener(listener);
        if (!this.mCaptioningChangeDelegate.hasActiveListener()) {
            this.mCaptioningManager.removeCaptioningChangeListener(this.mCaptioningChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CaptioningStyle getCaptioningStyleFrom(CaptioningManager.CaptionStyle userStyle) {
        return CaptioningStyle.createFrom(userStyle);
    }
}
