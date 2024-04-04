package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager.class */
public interface OriginPolicyManager extends Interface {
    public static final Interface.Manager<OriginPolicyManager, Proxy> MANAGER = OriginPolicyManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager$Proxy.class */
    public interface Proxy extends OriginPolicyManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager$RetrieveOriginPolicyResponse.class */
    public interface RetrieveOriginPolicyResponse extends Callbacks.Callback1<OriginPolicy> {
    }

    void retrieveOriginPolicy(Origin origin, String str, RetrieveOriginPolicyResponse retrieveOriginPolicyResponse);

    void addExceptionFor(Origin origin);
}
