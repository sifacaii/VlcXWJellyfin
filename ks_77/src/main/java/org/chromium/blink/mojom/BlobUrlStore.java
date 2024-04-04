package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.network.mojom.UrlLoaderFactory;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobUrlStore.class */
public interface BlobUrlStore extends Interface {
    public static final Interface.Manager<BlobUrlStore, Proxy> MANAGER = BlobUrlStore_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobUrlStore$Proxy.class */
    public interface Proxy extends BlobUrlStore, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobUrlStore$RegisterResponse.class */
    public interface RegisterResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobUrlStore$ResolveResponse.class */
    public interface ResolveResponse extends Callbacks.Callback1<Blob> {
    }

    void register(Blob blob, Url url, RegisterResponse registerResponse);

    void revoke(Url url);

    void resolve(Url url, ResolveResponse resolveResponse);

    void resolveAsUrlLoaderFactory(Url url, InterfaceRequest<UrlLoaderFactory> interfaceRequest);

    void resolveForNavigation(Url url, InterfaceRequest<BlobUrlToken> interfaceRequest);
}
