package org.chromium.blink.test.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticatorManager.class */
public interface VirtualAuthenticatorManager extends Interface {
    public static final Interface.Manager<VirtualAuthenticatorManager, Proxy> MANAGER = VirtualAuthenticatorManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticatorManager$ClearAuthenticatorsResponse.class */
    public interface ClearAuthenticatorsResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticatorManager$CreateAuthenticatorResponse.class */
    public interface CreateAuthenticatorResponse extends Callbacks.Callback1<VirtualAuthenticator> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticatorManager$GetAuthenticatorsResponse.class */
    public interface GetAuthenticatorsResponse extends Callbacks.Callback1<VirtualAuthenticator[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticatorManager$Proxy.class */
    public interface Proxy extends VirtualAuthenticatorManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticatorManager$RemoveAuthenticatorResponse.class */
    public interface RemoveAuthenticatorResponse extends Callbacks.Callback1<Boolean> {
    }

    void createAuthenticator(VirtualAuthenticatorOptions virtualAuthenticatorOptions, CreateAuthenticatorResponse createAuthenticatorResponse);

    void getAuthenticators(GetAuthenticatorsResponse getAuthenticatorsResponse);

    void removeAuthenticator(String str, RemoveAuthenticatorResponse removeAuthenticatorResponse);

    void clearAuthenticators(ClearAuthenticatorsResponse clearAuthenticatorsResponse);
}
