package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketHandshakeClient.class */
public interface WebSocketHandshakeClient extends Interface {
    public static final Interface.Manager<WebSocketHandshakeClient, Proxy> MANAGER = WebSocketHandshakeClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketHandshakeClient$Proxy.class */
    public interface Proxy extends WebSocketHandshakeClient, Interface.Proxy {
    }

    void onOpeningHandshakeStarted(WebSocketHandshakeRequest webSocketHandshakeRequest);

    void onResponseReceived(WebSocketHandshakeResponse webSocketHandshakeResponse);

    void onConnectionEstablished(WebSocket webSocket, String str, String str2, long j);
}
