package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationController.class */
public interface PresentationController extends Interface {
    public static final Interface.Manager<PresentationController, Proxy> MANAGER = PresentationController_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationController$Proxy.class */
    public interface Proxy extends PresentationController, Interface.Proxy {
    }

    void onScreenAvailabilityUpdated(Url url, int i);

    void onDefaultPresentationStarted(PresentationConnectionResult presentationConnectionResult);

    void onConnectionStateChanged(PresentationInfo presentationInfo, int i);

    void onConnectionClosed(PresentationInfo presentationInfo, int i, String str);
}
