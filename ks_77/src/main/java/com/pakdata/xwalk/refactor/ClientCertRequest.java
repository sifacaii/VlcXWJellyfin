package com.pakdata.xwalk.refactor;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/ClientCertRequest.class */
public interface ClientCertRequest {
    void cancel();

    void proceed(PrivateKey privateKey, List<X509Certificate> list);

    void ignore();

    String getHost();

    int getPort();

    String[] getKeyTypes();

    Principal[] getPrincipals();
}
