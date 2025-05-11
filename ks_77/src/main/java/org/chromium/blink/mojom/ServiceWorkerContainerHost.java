package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerContainerHost.class */
public interface ServiceWorkerContainerHost extends Interface {
    public static final Interface.Manager<ServiceWorkerContainerHost, Proxy> MANAGER = ServiceWorkerContainerHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerContainerHost$GetRegistrationForReadyResponse.class */
    public interface GetRegistrationForReadyResponse extends Callbacks.Callback1<ServiceWorkerRegistrationObjectInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerContainerHost$GetRegistrationResponse.class */
    public interface GetRegistrationResponse extends Callbacks.Callback3<Integer, String, ServiceWorkerRegistrationObjectInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerContainerHost$GetRegistrationsResponse.class */
    public interface GetRegistrationsResponse extends Callbacks.Callback3<Integer, String, ServiceWorkerRegistrationObjectInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerContainerHost$PingResponse.class */
    public interface PingResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerContainerHost$Proxy.class */
    public interface Proxy extends ServiceWorkerContainerHost, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerContainerHost$RegisterResponse.class */
    public interface RegisterResponse extends Callbacks.Callback3<Integer, String, ServiceWorkerRegistrationObjectInfo> {
    }

    void register(Url url, ServiceWorkerRegistrationOptions serviceWorkerRegistrationOptions, RegisterResponse registerResponse);

    void getRegistration(Url url, GetRegistrationResponse getRegistrationResponse);

    void getRegistrations(GetRegistrationsResponse getRegistrationsResponse);

    void getRegistrationForReady(GetRegistrationForReadyResponse getRegistrationForReadyResponse);

    void ensureControllerServiceWorker(InterfaceRequest<ControllerServiceWorker> interfaceRequest, int i);

    void cloneContainerHost(InterfaceRequest<ServiceWorkerContainerHost> interfaceRequest);

    void ping(PingResponse pingResponse);

    void hintToUpdateServiceWorker();

    void onExecutionReady();
}
