package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/UkmSourceIdFrameHost.class */
public interface UkmSourceIdFrameHost extends Interface {
    public static final Interface.Manager<UkmSourceIdFrameHost, Proxy> MANAGER = UkmSourceIdFrameHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/UkmSourceIdFrameHost$Proxy.class */
    public interface Proxy extends UkmSourceIdFrameHost, Interface.Proxy {
    }

    void setDocumentSourceId(long j);
}
