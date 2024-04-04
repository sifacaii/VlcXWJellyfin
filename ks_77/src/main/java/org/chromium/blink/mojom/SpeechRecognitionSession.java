package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SpeechRecognitionSession.class */
public interface SpeechRecognitionSession extends Interface {
    public static final Interface.Manager<SpeechRecognitionSession, Proxy> MANAGER = SpeechRecognitionSession_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SpeechRecognitionSession$Proxy.class */
    public interface Proxy extends SpeechRecognitionSession, Interface.Proxy {
    }

    void abort();

    void stopCapture();
}
