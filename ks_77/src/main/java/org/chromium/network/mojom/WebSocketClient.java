package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketClient.class */
public interface WebSocketClient extends Interface {
    public static final Interface.Manager<WebSocketClient, Proxy> MANAGER = WebSocketClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketClient$Proxy.class */
    public interface Proxy extends WebSocketClient, Interface.Proxy {
    }

    void onDataFrame(boolean z, int i, ReadOnlyBuffer readOnlyBuffer);

    void addSendFlowControlQuota(long j);

    void onDropChannel(boolean z, short s, String str);

    void onClosingHandshake();
}
