package org.chromium.media;

import android.annotation.SuppressLint;
import android.media.AudioTrack;
import android.os.Build;
import java.nio.ByteBuffer;
import org.chromium.base.Log;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.blink.mojom.WebFeature;

@JNINamespace("media")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/AudioTrackOutputStream.class */
class AudioTrackOutputStream {
    private static final String TAG = "AudioTrackOutput";
    private static final int CHANNEL_ALIGNMENT = 16;
    private long mNativeAudioTrackOutputStream;
    private Callback mCallback;
    private AudioTrack mAudioTrack;
    private int mBufferSizeInBytes;
    private WorkerThread mWorkerThread;
    private int mLastPlaybackHeadPosition;
    private long mTotalPlayedFrames;
    private long mTotalReadFrames;
    private ByteBuffer mReadBuffer;
    private ByteBuffer mWriteBuffer;
    private int mLeftSize;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/AudioTrackOutputStream$Callback.class */
    public interface Callback {
        int getMinBufferSize(int i, int i2, int i3);

        AudioTrack createAudioTrack(int i, int i2, int i3, int i4, int i5, int i6);

        AudioBufferInfo onMoreData(ByteBuffer byteBuffer, long j);

        long getAddress(ByteBuffer byteBuffer);

        void onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native AudioBufferInfo nativeOnMoreData(long j, ByteBuffer byteBuffer, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnError(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native long nativeGetAddress(long j, ByteBuffer byteBuffer);

    static {
        $assertionsDisabled = !AudioTrackOutputStream.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/AudioTrackOutputStream$AudioBufferInfo.class */
    public static class AudioBufferInfo {
        private final int mNumFrames;
        private final int mNumBytes;

        public AudioBufferInfo(int frames, int bytes) {
            this.mNumFrames = frames;
            this.mNumBytes = bytes;
        }

        public int getNumFrames() {
            return this.mNumFrames;
        }

        public int getNumBytes() {
            return this.mNumBytes;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/AudioTrackOutputStream$WorkerThread.class */
    class WorkerThread extends Thread {
        private volatile boolean mDone;

        WorkerThread() {
        }

        public void finish() {
            this.mDone = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int left;
            while (!this.mDone && (left = AudioTrackOutputStream.this.writeData()) >= 0) {
                if (left <= 0) {
                    AudioTrackOutputStream.this.readMoreData();
                }
            }
        }
    }

    @CalledByNative
    private static AudioTrackOutputStream create() {
        return new AudioTrackOutputStream(null);
    }

    @VisibleForTesting
    static AudioTrackOutputStream create(Callback callback) {
        return new AudioTrackOutputStream(callback);
    }

    private AudioTrackOutputStream(Callback callback) {
        this.mCallback = callback;
        if (this.mCallback != null) {
            return;
        }
        this.mCallback = new Callback() { // from class: org.chromium.media.AudioTrackOutputStream.1
            @Override // org.chromium.media.AudioTrackOutputStream.Callback
            public int getMinBufferSize(int sampleRateInHz, int channelConfig, int audioFormat) {
                return AudioTrack.getMinBufferSize(sampleRateInHz, channelConfig, audioFormat);
            }

            @Override // org.chromium.media.AudioTrackOutputStream.Callback
            public AudioTrack createAudioTrack(int streamType, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes, int mode) {
                return new AudioTrack(streamType, sampleRateInHz, channelConfig, audioFormat, bufferSizeInBytes, mode);
            }

            @Override // org.chromium.media.AudioTrackOutputStream.Callback
            public AudioBufferInfo onMoreData(ByteBuffer audioData, long delayInFrames) {
                return AudioTrackOutputStream.this.nativeOnMoreData(AudioTrackOutputStream.this.mNativeAudioTrackOutputStream, audioData, delayInFrames);
            }

            @Override // org.chromium.media.AudioTrackOutputStream.Callback
            public long getAddress(ByteBuffer byteBuffer) {
                return AudioTrackOutputStream.this.nativeGetAddress(AudioTrackOutputStream.this.mNativeAudioTrackOutputStream, byteBuffer);
            }

            @Override // org.chromium.media.AudioTrackOutputStream.Callback
            public void onError() {
                AudioTrackOutputStream.this.nativeOnError(AudioTrackOutputStream.this.mNativeAudioTrackOutputStream);
            }
        };
    }

    private int getChannelConfig(int channelCount) {
        switch (channelCount) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
            case 5:
            case 7:
            default:
                return 1;
            case 4:
                return WebFeature.SVG_LOCATABLE_NEAREST_VIEWPORT_ELEMENT;
            case 6:
                return 252;
            case 8:
                if (Build.VERSION.SDK_INT >= 23) {
                    return 6396;
                }
                return WebFeature.CSS_FILTER_OPACITY;
        }
    }

    @CalledByNative
    boolean open(int channelCount, int sampleRate, int sampleFormat) {
        if ($assertionsDisabled || this.mAudioTrack == null) {
            int channelConfig = getChannelConfig(channelCount);
            this.mBufferSizeInBytes = 3 * this.mCallback.getMinBufferSize(sampleRate, channelConfig, sampleFormat);
            try {
                Log.d(TAG, "Crate AudioTrack with sample rate:%d, channel:%d, format:%d ", Integer.valueOf(sampleRate), Integer.valueOf(channelConfig), Integer.valueOf(sampleFormat));
                this.mAudioTrack = this.mCallback.createAudioTrack(3, sampleRate, channelConfig, sampleFormat, this.mBufferSizeInBytes, 1);
                if (!$assertionsDisabled && this.mAudioTrack == null) {
                    throw new AssertionError();
                } else if (this.mAudioTrack.getState() == 0) {
                    Log.e(TAG, "Cannot create AudioTrack", new Object[0]);
                    this.mAudioTrack = null;
                    return false;
                } else {
                    this.mLastPlaybackHeadPosition = 0;
                    this.mTotalPlayedFrames = 0L;
                    return true;
                }
            } catch (IllegalArgumentException ile) {
                Log.e(TAG, "Exception creating AudioTrack for playback: ", ile);
                return false;
            }
        }
        throw new AssertionError();
    }

    private ByteBuffer allocateAlignedByteBuffer(int capacity, int alignment) {
        int mask = alignment - 1;
        ByteBuffer buffer = ByteBuffer.allocateDirect(capacity + mask);
        long address = this.mCallback.getAddress(buffer);
        int offset = (alignment - ((int) (address & mask))) & mask;
        buffer.position(offset);
        buffer.limit(offset + capacity);
        return buffer.slice();
    }

    @CalledByNative
    void start(long nativeAudioTrackOutputStream) {
        Log.d(TAG, "AudioTrackOutputStream.start()");
        if (this.mWorkerThread != null) {
            return;
        }
        this.mNativeAudioTrackOutputStream = nativeAudioTrackOutputStream;
        this.mTotalReadFrames = 0L;
        this.mReadBuffer = allocateAlignedByteBuffer(this.mBufferSizeInBytes, 16);
        this.mAudioTrack.play();
        this.mWorkerThread = new WorkerThread();
        this.mWorkerThread.start();
    }

    @CalledByNative
    void stop() {
        Log.d(TAG, "AudioTrackOutputStream.stop()");
        if (this.mWorkerThread != null) {
            this.mWorkerThread.finish();
            try {
                this.mWorkerThread.interrupt();
                this.mWorkerThread.join();
            } catch (InterruptedException e) {
                Log.e(TAG, "Exception while waiting for AudioTrack worker thread finished: ", e);
            } catch (SecurityException e2) {
                Log.e(TAG, "Exception while waiting for AudioTrack worker thread finished: ", e2);
            }
            this.mWorkerThread = null;
        }
        this.mAudioTrack.pause();
        this.mAudioTrack.flush();
        this.mLastPlaybackHeadPosition = 0;
        this.mTotalPlayedFrames = 0L;
        this.mNativeAudioTrackOutputStream = 0L;
    }

    @CalledByNative
    void setVolume(double volume) {
        float scaledVolume = (float) (volume * AudioTrack.getMaxVolume());
        this.mAudioTrack.setStereoVolume(scaledVolume, scaledVolume);
    }

    @CalledByNative
    void close() {
        Log.d(TAG, "AudioTrackOutputStream.close()");
        if (this.mAudioTrack != null) {
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
    }

    @CalledByNative
    AudioBufferInfo createAudioBufferInfo(int frames, int size) {
        return new AudioBufferInfo(frames, size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readMoreData() {
        if (!$assertionsDisabled && this.mNativeAudioTrackOutputStream == 0) {
            throw new AssertionError();
        }
        int position = this.mAudioTrack.getPlaybackHeadPosition();
        this.mTotalPlayedFrames += position - this.mLastPlaybackHeadPosition;
        this.mLastPlaybackHeadPosition = position;
        long delayInFrames = this.mTotalReadFrames - this.mTotalPlayedFrames;
        if (delayInFrames < 0) {
            delayInFrames = 0;
        }
        AudioBufferInfo info = this.mCallback.onMoreData(this.mReadBuffer.duplicate(), delayInFrames);
        if (info == null || info.getNumBytes() <= 0) {
            return;
        }
        this.mTotalReadFrames += info.getNumFrames();
        this.mWriteBuffer = this.mReadBuffer.asReadOnlyBuffer();
        this.mLeftSize = info.getNumBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int writeData() {
        if (this.mLeftSize == 0) {
            return 0;
        }
        int written = writeAudioTrack();
        if (written < 0) {
            Log.e(TAG, "AudioTrack.write() failed. Error:" + written, new Object[0]);
            this.mCallback.onError();
            return written;
        } else if ($assertionsDisabled || this.mLeftSize >= written) {
            this.mLeftSize -= written;
            return this.mLeftSize;
        } else {
            throw new AssertionError();
        }
    }

    @SuppressLint({"NewApi"})
    private int writeAudioTrack() {
        return this.mAudioTrack.write(this.mWriteBuffer, this.mLeftSize, 0);
    }
}
