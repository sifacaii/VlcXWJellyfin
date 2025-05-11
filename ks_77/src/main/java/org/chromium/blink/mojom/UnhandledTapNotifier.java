package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/UnhandledTapNotifier.class */
public interface UnhandledTapNotifier extends Interface {
    public static final Interface.Manager<UnhandledTapNotifier, Proxy> MANAGER = UnhandledTapNotifier_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/UnhandledTapNotifier$Proxy.class */
    public interface Proxy extends UnhandledTapNotifier, Interface.Proxy {
    }

    void showUnhandledTapUiIfNeeded(UnhandledTapInfo unhandledTapInfo);
}
