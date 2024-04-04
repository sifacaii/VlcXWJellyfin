package org.chromium.media;

import android.media.MediaCodec;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import org.chromium.base.Log;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("media")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/MediaCodecEncoder.class */
class MediaCodecEncoder extends MediaCodecBridge {
    private static final String TAG = "cr_MediaCodecEncoder";
    private SparseArray<ByteBuffer> mOutputBuffers;
    private ByteBuffer mConfigData;

    /* JADX INFO: Access modifiers changed from: protected */
    public MediaCodecEncoder(MediaCodec mediaCodec, int bitrateAdjuster) {
        super(mediaCodec, bitrateAdjuster, false);
        this.mOutputBuffers = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.media.MediaCodecBridge
    public ByteBuffer getOutputBuffer(int index) {
        return this.mOutputBuffers.get(index);
    }

    @Override // org.chromium.media.MediaCodecBridge
    protected void releaseOutputBuffer(int index, boolean render) {
        try {
            this.mMediaCodec.releaseOutputBuffer(index, render);
            this.mOutputBuffers.remove(index);
        } catch (IllegalStateException e) {
            Log.e(TAG, "Failed to release output buffer", e);
        }
    }

    @Override // org.chromium.media.MediaCodecBridge
    protected int dequeueOutputBufferInternal(MediaCodec.BufferInfo info, long timeoutUs) {
        int indexOrStatus = -1;
        try {
            indexOrStatus = this.mMediaCodec.dequeueOutputBuffer(info, timeoutUs);
            if (indexOrStatus >= 0) {
                boolean isConfigFrame = (info.flags & 2) != 0;
                if (isConfigFrame) {
                    Log.d(TAG, "Config frame generated. Offset: %d, size: %d", Integer.valueOf(info.offset), Integer.valueOf(info.size));
                    ByteBuffer codecOutputBuffer = getMediaCodecOutputBuffer(indexOrStatus);
                    codecOutputBuffer.position(info.offset);
                    codecOutputBuffer.limit(info.offset + info.size);
                    this.mConfigData = ByteBuffer.allocateDirect(info.size);
                    this.mConfigData.put(codecOutputBuffer);
                    StringBuilder spsData = new StringBuilder();
                    int i = 0;
                    while (true) {
                        if (i >= (info.size < 8 ? info.size : 8)) {
                            break;
                        }
                        spsData.append(Integer.toHexString(this.mConfigData.get(i) & 255)).append(" ");
                        i++;
                    }
                    Log.i(TAG, "spsData: %s", spsData.toString());
                    this.mMediaCodec.releaseOutputBuffer(indexOrStatus, false);
                    indexOrStatus = this.mMediaCodec.dequeueOutputBuffer(info, timeoutUs);
                }
            }
            if (indexOrStatus >= 0) {
                ByteBuffer codecOutputBuffer2 = getMediaCodecOutputBuffer(indexOrStatus);
                codecOutputBuffer2.position(info.offset);
                codecOutputBuffer2.limit(info.offset + info.size);
                boolean isKeyFrame = (info.flags & 1) != 0;
                if (isKeyFrame) {
                    Log.d(TAG, "Key frame generated");
                }
                if (isKeyFrame && this.mConfigData != null) {
                    Log.d(TAG, "Appending config frame of size %d to output buffer with size %d", Integer.valueOf(this.mConfigData.capacity()), Integer.valueOf(info.size));
                    ByteBuffer frameBuffer = ByteBuffer.allocateDirect(this.mConfigData.capacity() + info.size);
                    this.mConfigData.rewind();
                    frameBuffer.put(this.mConfigData);
                    frameBuffer.put(codecOutputBuffer2);
                    frameBuffer.rewind();
                    info.offset = 0;
                    info.size += this.mConfigData.capacity();
                    this.mOutputBuffers.put(indexOrStatus, frameBuffer);
                } else {
                    this.mOutputBuffers.put(indexOrStatus, codecOutputBuffer2);
                }
            }
        } catch (IllegalStateException e) {
            Log.e(TAG, "Failed to dequeue output buffer", e);
        }
        return indexOrStatus;
    }

    private ByteBuffer getMediaCodecOutputBuffer(int index) {
        ByteBuffer outputBuffer = super.getOutputBuffer(index);
        if (outputBuffer == null) {
            throw new IllegalStateException("Got null output buffer");
        }
        return outputBuffer;
    }
}
