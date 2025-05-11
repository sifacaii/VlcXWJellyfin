package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioInputStream.class */
public interface AudioInputStream extends Interface {
    public static final Interface.Manager<AudioInputStream, Proxy> MANAGER = AudioInputStream_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioInputStream$Proxy.class */
    public interface Proxy extends AudioInputStream, Interface.Proxy {
    }

    void record();

    void setVolume(double d);
}
