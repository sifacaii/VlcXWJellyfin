package org.chromium.content_public.browser;

import android.os.Handler;
import org.chromium.base.annotations.UsedByReflection;
import org.chromium.content.browser.AppWebMessagePort;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;
import org.chromium.mojo.system.MessagePipeHandle;

@UsedByReflection(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/MessagePort.class */
public interface MessagePort {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/MessagePort$MessageCallback.class */
    public interface MessageCallback {
        void onMessage(String str, MessagePort[] messagePortArr);
    }

    void close();

    boolean isClosed();

    boolean isTransferred();

    boolean isStarted();

    void setMessageCallback(MessageCallback messageCallback, Handler handler);

    void postMessage(String str, MessagePort[] messagePortArr);

    static MessagePort[] createPair() {
        return AppWebMessagePort.createPair();
    }

    static MessagePort create(MessagePipeHandle handle) {
        return AppWebMessagePort.create(handle);
    }
}
