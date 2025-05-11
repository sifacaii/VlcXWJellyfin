package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.WebSocketClient;
import org.chromium.network.mojom.WebSocketHandshakeClient;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebSocketConnector.class */
public interface WebSocketConnector extends Interface {
    public static final Interface.Manager<WebSocketConnector, Proxy> MANAGER = WebSocketConnector_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebSocketConnector$Proxy.class */
    public interface Proxy extends WebSocketConnector, Interface.Proxy {
    }

    void connect(Url url, String[] strArr, Url url2, String str, WebSocketHandshakeClient webSocketHandshakeClient, WebSocketClient webSocketClient);
}
