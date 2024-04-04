package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Portal.class */
public interface Portal extends Interface {
    public static final Interface.Manager<Portal, Proxy> MANAGER = Portal_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Portal$ActivateResponse.class */
    public interface ActivateResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Portal$Proxy.class */
    public interface Proxy extends Portal, Interface.Proxy {
    }

    void navigate(Url url, Referrer referrer);

    void activate(TransferableMessage transferableMessage, ActivateResponse activateResponse);

    void postMessageToGuest(TransferableMessage transferableMessage, Origin origin);
}
