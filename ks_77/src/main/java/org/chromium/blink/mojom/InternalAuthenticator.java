package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/InternalAuthenticator.class */
public interface InternalAuthenticator extends Interface {
    public static final Interface.Manager<InternalAuthenticator, Proxy> MANAGER = InternalAuthenticator_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/InternalAuthenticator$GetAssertionResponse.class */
    public interface GetAssertionResponse extends Callbacks.Callback2<Integer, GetAssertionAuthenticatorResponse> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/InternalAuthenticator$IsUserVerifyingPlatformAuthenticatorAvailableResponse.class */
    public interface IsUserVerifyingPlatformAuthenticatorAvailableResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/InternalAuthenticator$MakeCredentialResponse.class */
    public interface MakeCredentialResponse extends Callbacks.Callback2<Integer, MakeCredentialAuthenticatorResponse> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/InternalAuthenticator$Proxy.class */
    public interface Proxy extends InternalAuthenticator, Interface.Proxy {
    }

    void makeCredential(PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions, MakeCredentialResponse makeCredentialResponse);

    void getAssertion(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, GetAssertionResponse getAssertionResponse);

    void isUserVerifyingPlatformAuthenticatorAvailable(IsUserVerifyingPlatformAuthenticatorAvailableResponse isUserVerifyingPlatformAuthenticatorAvailableResponse);
}
