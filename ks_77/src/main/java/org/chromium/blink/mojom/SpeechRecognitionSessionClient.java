package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SpeechRecognitionSessionClient.class */
public interface SpeechRecognitionSessionClient extends Interface {
    public static final Interface.Manager<SpeechRecognitionSessionClient, Proxy> MANAGER = SpeechRecognitionSessionClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SpeechRecognitionSessionClient$Proxy.class */
    public interface Proxy extends SpeechRecognitionSessionClient, Interface.Proxy {
    }

    void resultRetrieved(SpeechRecognitionResult[] speechRecognitionResultArr);

    void errorOccurred(SpeechRecognitionError speechRecognitionError);

    void started();

    void audioStarted();

    void soundStarted();

    void soundEnded();

    void audioEnded();

    void ended();
}
