package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CredentialManager.class */
public interface CredentialManager extends Interface {
    public static final Interface.Manager<CredentialManager, Proxy> MANAGER = CredentialManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CredentialManager$GetResponse.class */
    public interface GetResponse extends Callbacks.Callback2<Integer, CredentialInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CredentialManager$PreventSilentAccessResponse.class */
    public interface PreventSilentAccessResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CredentialManager$Proxy.class */
    public interface Proxy extends CredentialManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CredentialManager$StoreResponse.class */
    public interface StoreResponse extends Callbacks.Callback0 {
    }

    void store(CredentialInfo credentialInfo, StoreResponse storeResponse);

    void preventSilentAccess(PreventSilentAccessResponse preventSilentAccessResponse);

    void get(int i, boolean z, Url[] urlArr, GetResponse getResponse);
}
