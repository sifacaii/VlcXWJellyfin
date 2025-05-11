package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Authenticator.class */
public interface Authenticator extends Interface {
    public static final Interface.Manager<Authenticator, Proxy> MANAGER = Authenticator_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Authenticator$GetAssertionResponse.class */
    public interface GetAssertionResponse extends Callbacks.Callback2<Integer, GetAssertionAuthenticatorResponse> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Authenticator$IsUserVerifyingPlatformAuthenticatorAvailableResponse.class */
    public interface IsUserVerifyingPlatformAuthenticatorAvailableResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Authenticator$MakeCredentialResponse.class */
    public interface MakeCredentialResponse extends Callbacks.Callback2<Integer, MakeCredentialAuthenticatorResponse> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Authenticator$Proxy.class */
    public interface Proxy extends Authenticator, Interface.Proxy {
    }

    void makeCredential(PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions, MakeCredentialResponse makeCredentialResponse);

    void getAssertion(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, GetAssertionResponse getAssertionResponse);

    void isUserVerifyingPlatformAuthenticatorAvailable(IsUserVerifyingPlatformAuthenticatorAvailableResponse isUserVerifyingPlatformAuthenticatorAvailableResponse);

    void cancel();
}
