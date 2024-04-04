package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/KeySystemSupport.class */
public interface KeySystemSupport extends Interface {
    public static final Interface.Manager<KeySystemSupport, Proxy> MANAGER = KeySystemSupport_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/KeySystemSupport$IsKeySystemSupportedResponse.class */
    public interface IsKeySystemSupportedResponse extends Callbacks.Callback2<Boolean, KeySystemCapability> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/KeySystemSupport$Proxy.class */
    public interface Proxy extends KeySystemSupport, Interface.Proxy {
    }

    void isKeySystemSupported(String str, IsKeySystemSupportedResponse isKeySystemSupportedResponse);
}
