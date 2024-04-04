package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ClientCertificateResponder.class */
public interface ClientCertificateResponder extends Interface {
    public static final Interface.Manager<ClientCertificateResponder, Proxy> MANAGER = ClientCertificateResponder_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ClientCertificateResponder$Proxy.class */
    public interface Proxy extends ClientCertificateResponder, Interface.Proxy {
    }

    void continueWithCertificate(X509Certificate x509Certificate, String str, short[] sArr, SslPrivateKey sslPrivateKey);

    void continueWithoutCertificate();

    void cancelRequest();
}
