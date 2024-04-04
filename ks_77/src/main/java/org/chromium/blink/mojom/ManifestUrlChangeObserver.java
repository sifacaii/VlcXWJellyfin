package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestUrlChangeObserver.class */
public interface ManifestUrlChangeObserver extends Interface {
    public static final Interface.Manager<ManifestUrlChangeObserver, Proxy> MANAGER = ManifestUrlChangeObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestUrlChangeObserver$Proxy.class */
    public interface Proxy extends ManifestUrlChangeObserver, Interface.Proxy {
    }

    void manifestUrlChanged(Url url);
}
