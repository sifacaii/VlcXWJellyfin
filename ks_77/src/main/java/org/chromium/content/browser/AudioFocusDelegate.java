package org.chromium.content.browser;

import android.media.AudioManager;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/AudioFocusDelegate.class */
public class AudioFocusDelegate implements AudioManager.OnAudioFocusChangeListener {
    private static final String TAG = "MediaSession";
    private int mFocusType;
    private boolean mIsDucking;
    private long mNativeAudioFocusDelegateAndroid;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeOnSuspend(long j);

    private native void nativeOnResume(long j);

    private native void nativeOnStartDucking(long j);

    private native void nativeOnStopDucking(long j);

    private native void nativeRecordSessionDuck(long j);

    static {
        $assertionsDisabled = !AudioFocusDelegate.class.desiredAssertionStatus();
    }

    private AudioFocusDelegate(long nativeAudioFocusDelegateAndroid) {
        this.mNativeAudioFocusDelegateAndroid = nativeAudioFocusDelegateAndroid;
    }

    @CalledByNative
    private static AudioFocusDelegate create(long nativeAudioFocusDelegateAndroid) {
        return new AudioFocusDelegate(nativeAudioFocusDelegateAndroid);
    }

    @CalledByNative
    private void tearDown() {
        if (!$assertionsDisabled && !ThreadUtils.runningOnUiThread()) {
            throw new AssertionError();
        }
        abandonAudioFocus();
        this.mNativeAudioFocusDelegateAndroid = 0L;
    }

    @CalledByNative
    private boolean requestAudioFocus(boolean transientFocus) {
        if ($assertionsDisabled || ThreadUtils.runningOnUiThread()) {
            this.mFocusType = transientFocus ? 3 : 1;
            return requestAudioFocusInternal();
        }
        throw new AssertionError();
    }

    @CalledByNative
    private void abandonAudioFocus() {
        if (!$assertionsDisabled && !ThreadUtils.runningOnUiThread()) {
            throw new AssertionError();
        }
        AudioManager am = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        am.abandonAudioFocus(this);
    }

    @CalledByNative
    private boolean isFocusTransient() {
        return this.mFocusType == 3;
    }

    private boolean requestAudioFocusInternal() {
        AudioManager am = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        int result = am.requestAudioFocus(this, 3, this.mFocusType);
        return result == 1;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        if (!$assertionsDisabled && !ThreadUtils.runningOnUiThread()) {
            throw new AssertionError();
        }
        if (this.mNativeAudioFocusDelegateAndroid == 0) {
            return;
        }
        switch (focusChange) {
            case -3:
                this.mIsDucking = true;
                nativeRecordSessionDuck(this.mNativeAudioFocusDelegateAndroid);
                nativeOnStartDucking(this.mNativeAudioFocusDelegateAndroid);
                return;
            case -2:
                nativeOnSuspend(this.mNativeAudioFocusDelegateAndroid);
                return;
            case -1:
                abandonAudioFocus();
                nativeOnSuspend(this.mNativeAudioFocusDelegateAndroid);
                return;
            case 0:
            default:
                Log.w(TAG, "onAudioFocusChange called with unexpected value %d", Integer.valueOf(focusChange));
                return;
            case 1:
                if (this.mIsDucking) {
                    nativeOnStopDucking(this.mNativeAudioFocusDelegateAndroid);
                    this.mIsDucking = false;
                    return;
                }
                nativeOnResume(this.mNativeAudioFocusDelegateAndroid);
                return;
        }
    }
}
