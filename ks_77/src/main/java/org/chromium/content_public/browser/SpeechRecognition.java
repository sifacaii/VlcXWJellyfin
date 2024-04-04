package org.chromium.content_public.browser;

import org.chromium.content.browser.SpeechRecognitionImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/SpeechRecognition.class */
public final class SpeechRecognition {
    private SpeechRecognition() {
    }

    public static boolean initialize() {
        return SpeechRecognitionImpl.initialize();
    }
}
