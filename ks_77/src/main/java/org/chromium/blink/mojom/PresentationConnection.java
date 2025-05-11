package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationConnection.class */
public interface PresentationConnection extends Interface {
    public static final Interface.Manager<PresentationConnection, Proxy> MANAGER = PresentationConnection_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationConnection$Proxy.class */
    public interface Proxy extends PresentationConnection, Interface.Proxy {
    }

    void onMessage(PresentationConnectionMessage presentationConnectionMessage);

    void didChangeState(int i);

    void didClose(int i);
}
