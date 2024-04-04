package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RendererPreferenceWatcher.class */
public interface RendererPreferenceWatcher extends Interface {
    public static final Interface.Manager<RendererPreferenceWatcher, Proxy> MANAGER = RendererPreferenceWatcher_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RendererPreferenceWatcher$Proxy.class */
    public interface Proxy extends RendererPreferenceWatcher, Interface.Proxy {
    }

    void notifyUpdate(RendererPreferences rendererPreferences);
}
