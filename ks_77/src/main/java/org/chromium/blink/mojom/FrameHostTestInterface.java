package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FrameHostTestInterface.class */
public interface FrameHostTestInterface extends Interface {
    public static final Interface.Manager<FrameHostTestInterface, Proxy> MANAGER = FrameHostTestInterface_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FrameHostTestInterface$GetNameResponse.class */
    public interface GetNameResponse extends Callbacks.Callback1<String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FrameHostTestInterface$Proxy.class */
    public interface Proxy extends FrameHostTestInterface, Interface.Proxy {
    }

    void ping(Url url, String str);

    void getName(GetNameResponse getNameResponse);
}
