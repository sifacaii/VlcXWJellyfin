package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationReceiver.class */
public interface PresentationReceiver extends Interface {
    public static final Interface.Manager<PresentationReceiver, Proxy> MANAGER = PresentationReceiver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationReceiver$Proxy.class */
    public interface Proxy extends PresentationReceiver, Interface.Proxy {
    }

    void onReceiverConnectionAvailable(PresentationInfo presentationInfo, PresentationConnection presentationConnection, InterfaceRequest<PresentationConnection> interfaceRequest);
}
