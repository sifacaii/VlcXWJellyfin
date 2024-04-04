package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SpeechRecognizer.class */
public interface SpeechRecognizer extends Interface {
    public static final Interface.Manager<SpeechRecognizer, Proxy> MANAGER = SpeechRecognizer_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SpeechRecognizer$Proxy.class */
    public interface Proxy extends SpeechRecognizer, Interface.Proxy {
    }

    void start(StartSpeechRecognitionRequestParams startSpeechRecognitionRequestParams);
}
