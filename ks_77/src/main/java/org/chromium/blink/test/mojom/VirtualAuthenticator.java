package org.chromium.blink.test.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticator.class */
public interface VirtualAuthenticator extends Interface {
    public static final Interface.Manager<VirtualAuthenticator, Proxy> MANAGER = VirtualAuthenticator_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticator$AddRegistrationResponse.class */
    public interface AddRegistrationResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticator$ClearRegistrationsResponse.class */
    public interface ClearRegistrationsResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticator$GetRegistrationsResponse.class */
    public interface GetRegistrationsResponse extends Callbacks.Callback1<RegisteredKey[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticator$GetUniqueIdResponse.class */
    public interface GetUniqueIdResponse extends Callbacks.Callback1<String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticator$GetUserPresenceResponse.class */
    public interface GetUserPresenceResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticator$Proxy.class */
    public interface Proxy extends VirtualAuthenticator, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticator$SetUserPresenceResponse.class */
    public interface SetUserPresenceResponse extends Callbacks.Callback0 {
    }

    void getUniqueId(GetUniqueIdResponse getUniqueIdResponse);

    void addRegistration(RegisteredKey registeredKey, AddRegistrationResponse addRegistrationResponse);

    void getRegistrations(GetRegistrationsResponse getRegistrationsResponse);

    void clearRegistrations(ClearRegistrationsResponse clearRegistrationsResponse);

    void setUserPresence(boolean z, SetUserPresenceResponse setUserPresenceResponse);

    void getUserPresence(GetUserPresenceResponse getUserPresenceResponse);
}
