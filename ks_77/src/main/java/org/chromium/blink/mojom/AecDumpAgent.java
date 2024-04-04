package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.File;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AecDumpAgent.class */
public interface AecDumpAgent extends Interface {
    public static final Interface.Manager<AecDumpAgent, Proxy> MANAGER = AecDumpAgent_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AecDumpAgent$Proxy.class */
    public interface Proxy extends AecDumpAgent, Interface.Proxy {
    }

    void start(File file);

    void stop();
}
