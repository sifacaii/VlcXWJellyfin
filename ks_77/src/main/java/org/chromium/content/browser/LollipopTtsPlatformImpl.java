package org.chromium.content.browser;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.speech.tts.UtteranceProgressListener;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("content")
@TargetApi(21)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/LollipopTtsPlatformImpl.class */
class LollipopTtsPlatformImpl extends TtsPlatformImpl {
    /* JADX INFO: Access modifiers changed from: protected */
    public LollipopTtsPlatformImpl(long nativeTtsPlatformImplAndroid) {
        super(nativeTtsPlatformImplAndroid);
    }

    @Override // org.chromium.content.browser.TtsPlatformImpl
    protected void addOnUtteranceProgressListener() {
        this.mTextToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() { // from class: org.chromium.content.browser.LollipopTtsPlatformImpl.1
            @Override // android.speech.tts.UtteranceProgressListener
            public void onDone(String utteranceId) {
                LollipopTtsPlatformImpl.this.sendEndEventOnUiThread(utteranceId);
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onError(String utteranceId, int errorCode) {
                LollipopTtsPlatformImpl.this.sendErrorEventOnUiThread(utteranceId);
            }

            @Override // android.speech.tts.UtteranceProgressListener
            @Deprecated
            public void onError(String utteranceId) {
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onStart(String utteranceId) {
                LollipopTtsPlatformImpl.this.sendStartEventOnUiThread(utteranceId);
            }
        });
    }

    @Override // org.chromium.content.browser.TtsPlatformImpl
    protected int callSpeak(String text, float volume, int utteranceId) {
        Bundle params = new Bundle();
        if (volume != 1.0d) {
            params.putFloat("volume", volume);
        }
        return this.mTextToSpeech.speak(text, 0, params, Integer.toString(utteranceId));
    }
}
