package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthChallengeResponder.class */
public interface AuthChallengeResponder extends Interface {
    public static final Interface.Manager<AuthChallengeResponder, Proxy> MANAGER = AuthChallengeResponder_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthChallengeResponder$Proxy.class */
    public interface Proxy extends AuthChallengeResponder, Interface.Proxy {
    }

    void onAuthCredentials(AuthCredentials authCredentials);
}
