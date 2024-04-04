package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsResponder.class */
public interface MdnsResponder extends Interface {
    public static final Interface.Manager<MdnsResponder, Proxy> MANAGER = MdnsResponder_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsResponder$CreateNameForAddressResponse.class */
    public interface CreateNameForAddressResponse extends Callbacks.Callback2<String, Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsResponder$Proxy.class */
    public interface Proxy extends MdnsResponder, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsResponder$RemoveNameForAddressResponse.class */
    public interface RemoveNameForAddressResponse extends Callbacks.Callback2<Boolean, Boolean> {
    }

    void createNameForAddress(IpAddress ipAddress, CreateNameForAddressResponse createNameForAddressResponse);

    void removeNameForAddress(IpAddress ipAddress, RemoveNameForAddressResponse removeNameForAddressResponse);
}
