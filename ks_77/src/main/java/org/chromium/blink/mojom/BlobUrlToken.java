package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobUrlToken.class */
public interface BlobUrlToken extends Interface {
    public static final Interface.Manager<BlobUrlToken, Proxy> MANAGER = BlobUrlToken_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobUrlToken$GetTokenResponse.class */
    public interface GetTokenResponse extends Callbacks.Callback1<UnguessableToken> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobUrlToken$Proxy.class */
    public interface Proxy extends BlobUrlToken, Interface.Proxy {
    }

    void clone(InterfaceRequest<BlobUrlToken> interfaceRequest);

    void getToken(GetTokenResponse getTokenResponse);
}
