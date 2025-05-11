package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CopyOutputResultSender.class */
public interface CopyOutputResultSender extends Interface {
    public static final Interface.Manager<CopyOutputResultSender, Proxy> MANAGER = CopyOutputResultSender_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CopyOutputResultSender$Proxy.class */
    public interface Proxy extends CopyOutputResultSender, Interface.Proxy {
    }

    void sendResult(CopyOutputResult copyOutputResult);
}
