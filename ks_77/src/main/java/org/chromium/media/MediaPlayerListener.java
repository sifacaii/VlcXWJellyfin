package org.chromium.media;

import android.media.MediaPlayer;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("media")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/MediaPlayerListener.class */
class MediaPlayerListener implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener {
    private static final int MEDIA_ERROR_FORMAT = 0;
    private static final int MEDIA_ERROR_DECODE = 1;
    private static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 2;
    private static final int MEDIA_ERROR_INVALID_CODE = 3;
    private static final int MEDIA_ERROR_SERVER_DIED = 4;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    private long mNativeMediaPlayerListener;

    private native void nativeOnMediaError(long j, int i);

    private native void nativeOnVideoSizeChanged(long j, int i, int i2);

    private native void nativeOnMediaPrepared(long j);

    private native void nativeOnPlaybackComplete(long j);

    private MediaPlayerListener(long nativeMediaPlayerListener) {
        this.mNativeMediaPlayerListener = nativeMediaPlayerListener;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mp, int what, int extra) {
        int errorType;
        switch (what) {
            case 1:
                switch (extra) {
                    case MEDIA_ERROR_MALFORMED /* -1007 */:
                        errorType = 1;
                        break;
                    case -110:
                        errorType = 3;
                        break;
                    default:
                        errorType = 0;
                        break;
                }
            case 100:
                errorType = 4;
                break;
            case 200:
                errorType = 2;
                break;
            default:
                errorType = 3;
                break;
        }
        nativeOnMediaError(this.mNativeMediaPlayerListener, errorType);
        return true;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        nativeOnVideoSizeChanged(this.mNativeMediaPlayerListener, width, height);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mp) {
        nativeOnPlaybackComplete(this.mNativeMediaPlayerListener);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mp) {
        nativeOnMediaPrepared(this.mNativeMediaPlayerListener);
    }

    @CalledByNative
    private static MediaPlayerListener create(long nativeMediaPlayerListener, MediaPlayerBridge mediaPlayerBridge) {
        MediaPlayerListener listener = new MediaPlayerListener(nativeMediaPlayerListener);
        if (mediaPlayerBridge != null) {
            mediaPlayerBridge.setOnCompletionListener(listener);
            mediaPlayerBridge.setOnErrorListener(listener);
            mediaPlayerBridge.setOnPreparedListener(listener);
            mediaPlayerBridge.setOnVideoSizeChangedListener(listener);
        }
        return listener;
    }
}
