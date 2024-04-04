package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocket.class */
public interface WebSocket extends Interface {
    public static final int INSUFFICIENT_RESOURCES = 1;
    public static final int INTERNAL_FAILURE = 2;
    public static final Interface.Manager<WebSocket, Proxy> MANAGER = WebSocket_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocket$Proxy.class */
    public interface Proxy extends WebSocket, Interface.Proxy {
    }

    void sendFrame(boolean z, int i, byte[] bArr);

    void addReceiveFlowControlQuota(long j);

    void startClosingHandshake(short s, String str);
}
