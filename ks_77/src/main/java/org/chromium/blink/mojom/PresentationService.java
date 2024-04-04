package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationService.class */
public interface PresentationService extends Interface {
    public static final Interface.Manager<PresentationService, Proxy> MANAGER = PresentationService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationService$Proxy.class */
    public interface Proxy extends PresentationService, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationService$ReconnectPresentationResponse.class */
    public interface ReconnectPresentationResponse extends Callbacks.Callback2<PresentationConnectionResult, PresentationError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationService$StartPresentationResponse.class */
    public interface StartPresentationResponse extends Callbacks.Callback2<PresentationConnectionResult, PresentationError> {
    }

    void setController(PresentationController presentationController);

    void setReceiver(PresentationReceiver presentationReceiver);

    void setDefaultPresentationUrls(Url[] urlArr);

    void listenForScreenAvailability(Url url);

    void stopListeningForScreenAvailability(Url url);

    void startPresentation(Url[] urlArr, StartPresentationResponse startPresentationResponse);

    void reconnectPresentation(Url[] urlArr, String str, ReconnectPresentationResponse reconnectPresentationResponse);

    void closeConnection(Url url, String str);

    void terminate(Url url, String str);
}
