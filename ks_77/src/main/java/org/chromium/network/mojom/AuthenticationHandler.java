package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler.class */
public interface AuthenticationHandler extends Interface {
    public static final Interface.Manager<AuthenticationHandler, Proxy> MANAGER = AuthenticationHandler_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler$OnAuthRequiredResponse.class */
    public interface OnAuthRequiredResponse extends Callbacks.Callback1<AuthCredentials> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler$Proxy.class */
    public interface Proxy extends AuthenticationHandler, Interface.Proxy {
    }

    void onAuthRequired(AuthChallengeInfo authChallengeInfo, HttpResponseHeaders httpResponseHeaders, IpEndPoint ipEndPoint, OnAuthRequiredResponse onAuthRequiredResponse);
}
