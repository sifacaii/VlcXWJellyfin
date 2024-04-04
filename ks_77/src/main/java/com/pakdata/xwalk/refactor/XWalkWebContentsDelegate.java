package com.pakdata.xwalk.refactor;

import android.view.KeyEvent;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkWebContentsDelegate.class */
abstract class XWalkWebContentsDelegate extends WebContentsDelegateAndroid {
    @CalledByNative
    public abstract boolean addNewContents(boolean z, boolean z2);

    @Override // org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid
    @CalledByNative
    public abstract void closeContents();

    @Override // org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid
    @CalledByNative
    public abstract void activateContents();

    @Override // org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid
    @CalledByNative
    public abstract void rendererUnresponsive();

    @Override // org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid
    @CalledByNative
    public abstract void rendererResponsive();

    @Override // org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid
    @CalledByNative
    public abstract void handleKeyboardEvent(KeyEvent keyEvent);

    @Override // org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid
    @CalledByNative
    public abstract boolean addMessageToConsole(int i, String str, int i2, String str2);

    @Override // org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid
    @CalledByNative
    public abstract void showRepostFormWarningDialog();

    @CalledByNative
    public abstract boolean shouldOverrideRunFileChooser(int i, int i2, int i3, String str, String str2, String str3, boolean z);

    @Override // org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid
    @CalledByNative
    public abstract void navigationStateChanged(int i);

    @CalledByNative
    public abstract void setOverlayMode(boolean z);

    @Override // org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid
    @CalledByNative
    public boolean shouldCreateWebContents(String targetUrl) {
        return true;
    }

    @CalledByNative
    public void updatePreferredSize(int widthCss, int heightCss) {
    }

    public void toggleFullscreen(boolean enterFullscreen) {
    }

    @CalledByNative
    public boolean isFullscreen() {
        return false;
    }
}
