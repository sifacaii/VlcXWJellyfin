package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient.class */
public interface TrustedHeaderClient extends Interface {
    public static final Interface.Manager<TrustedHeaderClient, Proxy> MANAGER = TrustedHeaderClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient$OnBeforeSendHeadersResponse.class */
    public interface OnBeforeSendHeadersResponse extends Callbacks.Callback2<Integer, HttpRequestHeaders> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient$OnHeadersReceivedResponse.class */
    public interface OnHeadersReceivedResponse extends Callbacks.Callback3<Integer, String, Url> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient$Proxy.class */
    public interface Proxy extends TrustedHeaderClient, Interface.Proxy {
    }

    void onBeforeSendHeaders(HttpRequestHeaders httpRequestHeaders, OnBeforeSendHeadersResponse onBeforeSendHeadersResponse);

    void onHeadersReceived(String str, OnHeadersReceivedResponse onHeadersReceivedResponse);
}
