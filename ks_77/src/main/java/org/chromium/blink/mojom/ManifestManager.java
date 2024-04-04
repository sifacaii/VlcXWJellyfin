package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestManager.class */
public interface ManifestManager extends Interface {
    public static final Interface.Manager<ManifestManager, Proxy> MANAGER = ManifestManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestManager$Proxy.class */
    public interface Proxy extends ManifestManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestManager$RequestManifestDebugInfoResponse.class */
    public interface RequestManifestDebugInfoResponse extends Callbacks.Callback2<Url, ManifestDebugInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestManager$RequestManifestResponse.class */
    public interface RequestManifestResponse extends Callbacks.Callback2<Url, Manifest_> {
    }

    void requestManifest(RequestManifestResponse requestManifestResponse);

    void requestManifestDebugInfo(RequestManifestDebugInfoResponse requestManifestDebugInfoResponse);
}
