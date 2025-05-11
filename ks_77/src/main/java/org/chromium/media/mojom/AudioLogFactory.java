package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioLogFactory.class */
public interface AudioLogFactory extends Interface {
    public static final Interface.Manager<AudioLogFactory, Proxy> MANAGER = AudioLogFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioLogFactory$Proxy.class */
    public interface Proxy extends AudioLogFactory, Interface.Proxy {
    }

    void createAudioLog(int i, int i2, InterfaceRequest<AudioLog> interfaceRequest);
}
