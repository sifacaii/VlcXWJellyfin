package org.chromium.viz.mojom;

import org.chromium.gpu.mojom.SyncToken;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/TextureReleaser.class */
public interface TextureReleaser extends Interface {
    public static final Interface.Manager<TextureReleaser, Proxy> MANAGER = TextureReleaser_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/TextureReleaser$Proxy.class */
    public interface Proxy extends TextureReleaser, Interface.Proxy {
    }

    void release(SyncToken syncToken, boolean z);
}
