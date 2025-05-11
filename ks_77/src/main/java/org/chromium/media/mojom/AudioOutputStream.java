package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioOutputStream.class */
public interface AudioOutputStream extends Interface {
    public static final Interface.Manager<AudioOutputStream, Proxy> MANAGER = AudioOutputStream_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioOutputStream$Proxy.class */
    public interface Proxy extends AudioOutputStream, Interface.Proxy {
    }

    void play();

    void pause();

    void flush();

    void setVolume(double d);
}
