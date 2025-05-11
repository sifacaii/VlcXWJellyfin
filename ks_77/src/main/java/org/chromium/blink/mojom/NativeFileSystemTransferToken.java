package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemTransferToken.class */
public interface NativeFileSystemTransferToken extends Interface {
    public static final Interface.Manager<NativeFileSystemTransferToken, Proxy> MANAGER = NativeFileSystemTransferToken_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemTransferToken$GetInternalIdResponse.class */
    public interface GetInternalIdResponse extends Callbacks.Callback1<UnguessableToken> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemTransferToken$Proxy.class */
    public interface Proxy extends NativeFileSystemTransferToken, Interface.Proxy {
    }

    void getInternalId(GetInternalIdResponse getInternalIdResponse);
}
