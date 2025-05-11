package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslPrivateKey.class */
public interface SslPrivateKey extends Interface {
    public static final Interface.Manager<SslPrivateKey, Proxy> MANAGER = SslPrivateKey_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslPrivateKey$Proxy.class */
    public interface Proxy extends SslPrivateKey, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslPrivateKey$SignResponse.class */
    public interface SignResponse extends Callbacks.Callback2<Integer, byte[]> {
    }

    void sign(short s, byte[] bArr, SignResponse signResponse);
}
