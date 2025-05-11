package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AudioContextManager.class */
public interface AudioContextManager extends Interface {
    public static final Interface.Manager<AudioContextManager, Proxy> MANAGER = AudioContextManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AudioContextManager$Proxy.class */
    public interface Proxy extends AudioContextManager, Interface.Proxy {
    }

    void audioContextAudiblePlaybackStarted(int i);

    void audioContextAudiblePlaybackStopped(int i);
}
