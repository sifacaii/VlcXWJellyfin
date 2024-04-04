package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioLog.class */
public interface AudioLog extends Interface {
    public static final Interface.Manager<AudioLog, Proxy> MANAGER = AudioLog_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioLog$Proxy.class */
    public interface Proxy extends AudioLog, Interface.Proxy {
    }

    void onCreated(AudioParameters audioParameters, String str);

    void onStarted();

    void onStopped();

    void onClosed();

    void onError();

    void onSetVolume(double d);

    void onProcessingStateChanged(String str);

    void onLogMessage(String str);
}
