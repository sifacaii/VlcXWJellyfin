package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageAreaGetAllCallback.class */
public interface StorageAreaGetAllCallback extends Interface {
    public static final Interface.Manager<StorageAreaGetAllCallback, Proxy> MANAGER = StorageAreaGetAllCallback_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageAreaGetAllCallback$Proxy.class */
    public interface Proxy extends StorageAreaGetAllCallback, Interface.Proxy {
    }

    void complete(boolean z);
}
