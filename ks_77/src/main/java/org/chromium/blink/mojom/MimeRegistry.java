package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MimeRegistry.class */
public interface MimeRegistry extends Interface {
    public static final Interface.Manager<MimeRegistry, Proxy> MANAGER = MimeRegistry_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MimeRegistry$GetMimeTypeFromExtensionResponse.class */
    public interface GetMimeTypeFromExtensionResponse extends Callbacks.Callback1<String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MimeRegistry$Proxy.class */
    public interface Proxy extends MimeRegistry, Interface.Proxy {
    }

    void getMimeTypeFromExtension(String str, GetMimeTypeFromExtensionResponse getMimeTypeFromExtensionResponse);
}
