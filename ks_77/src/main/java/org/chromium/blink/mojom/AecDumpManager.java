package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AecDumpManager.class */
public interface AecDumpManager extends Interface {
    public static final Interface.Manager<AecDumpManager, Proxy> MANAGER = AecDumpManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AecDumpManager$Proxy.class */
    public interface Proxy extends AecDumpManager, Interface.Proxy {
    }

    void add(AecDumpAgent aecDumpAgent);
}
