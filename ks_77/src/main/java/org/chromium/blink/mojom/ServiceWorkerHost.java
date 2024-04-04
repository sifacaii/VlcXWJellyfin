package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost.class */
public interface ServiceWorkerHost extends Interface {
    public static final Interface.Manager<ServiceWorkerHost, Proxy> MANAGER = ServiceWorkerHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost$ClaimClientsResponse.class */
    public interface ClaimClientsResponse extends Callbacks.Callback2<Integer, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost$FocusClientResponse.class */
    public interface FocusClientResponse extends Callbacks.Callback1<ServiceWorkerClientInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost$GetClientResponse.class */
    public interface GetClientResponse extends Callbacks.Callback1<ServiceWorkerClientInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost$GetClientsResponse.class */
    public interface GetClientsResponse extends Callbacks.Callback1<ServiceWorkerClientInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost$NavigateClientResponse.class */
    public interface NavigateClientResponse extends Callbacks.Callback3<Boolean, ServiceWorkerClientInfo, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost$OpenNewTabResponse.class */
    public interface OpenNewTabResponse extends Callbacks.Callback3<Boolean, ServiceWorkerClientInfo, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost$OpenPaymentHandlerWindowResponse.class */
    public interface OpenPaymentHandlerWindowResponse extends Callbacks.Callback3<Boolean, ServiceWorkerClientInfo, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost$Proxy.class */
    public interface Proxy extends ServiceWorkerHost, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerHost$SkipWaitingResponse.class */
    public interface SkipWaitingResponse extends Callbacks.Callback1<Boolean> {
    }

    void setCachedMetadata(Url url, byte[] bArr);

    void clearCachedMetadata(Url url);

    void getClients(ServiceWorkerClientQueryOptions serviceWorkerClientQueryOptions, GetClientsResponse getClientsResponse);

    void getClient(String str, GetClientResponse getClientResponse);

    void openNewTab(Url url, OpenNewTabResponse openNewTabResponse);

    void openPaymentHandlerWindow(Url url, OpenPaymentHandlerWindowResponse openPaymentHandlerWindowResponse);

    void postMessageToClient(String str, TransferableMessage transferableMessage);

    void focusClient(String str, FocusClientResponse focusClientResponse);

    void navigateClient(String str, Url url, NavigateClientResponse navigateClientResponse);

    void skipWaiting(SkipWaitingResponse skipWaitingResponse);

    void claimClients(ClaimClientsResponse claimClientsResponse);
}
