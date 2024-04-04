package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NonPersistentNotificationListener.class */
public interface NonPersistentNotificationListener extends Interface {
    public static final Interface.Manager<NonPersistentNotificationListener, Proxy> MANAGER = NonPersistentNotificationListener_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NonPersistentNotificationListener$OnClickResponse.class */
    public interface OnClickResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NonPersistentNotificationListener$OnCloseResponse.class */
    public interface OnCloseResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NonPersistentNotificationListener$Proxy.class */
    public interface Proxy extends NonPersistentNotificationListener, Interface.Proxy {
    }

    void onShow();

    void onClick(OnClickResponse onClickResponse);

    void onClose(OnCloseResponse onCloseResponse);
}
