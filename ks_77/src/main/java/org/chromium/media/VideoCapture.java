package org.chromium.media;

import android.view.WindowManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("media")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCapture.class */
public abstract class VideoCapture {
    protected int mCameraNativeOrientation;
    protected boolean mInvertDeviceOrientationReadings;
    protected VideoCaptureFormat mCaptureFormat;
    protected final int mId;
    protected final long mNativeVideoCaptureDeviceAndroid;
    protected boolean mUseBackgroundThreadForTesting;

    @CalledByNative
    public abstract boolean allocate(int i, int i2, int i3, boolean z);

    @CalledByNative
    public abstract boolean startCaptureMaybeAsync();

    @CalledByNative
    public abstract boolean stopCaptureAndBlockUntilStopped();

    @CalledByNative
    public abstract void getPhotoCapabilitiesAsync(long j);

    @CalledByNative
    public abstract void setPhotoOptions(double d, int i, double d2, int i2, double d3, double d4, double[] dArr, boolean z, double d5, double d6, int i3, double d7, boolean z2, boolean z3, int i4, boolean z4, boolean z5, double d8);

    @CalledByNative
    public abstract void takePhotoAsync(long j);

    @CalledByNative
    public abstract void deallocate();

    public native void nativeOnFrameAvailable(long j, byte[] bArr, int i, int i2);

    public native void nativeOnI420FrameAvailable(long j, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3, int i4, int i5, int i6, long j2);

    public native void nativeOnError(long j, int i, String str);

    public native void nativeOnFrameDropped(long j, int i);

    public native void nativeOnGetPhotoCapabilitiesReply(long j, long j2, PhotoCapabilities photoCapabilities);

    public native void nativeOnPhotoTaken(long j, long j2, byte[] bArr);

    public native void nativeOnStarted(long j);

    public native void nativeDCheckCurrentlyOnIncomingTaskRunner(long j);

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCapture$FramerateRange.class */
    public static class FramerateRange {
        public int min;
        public int max;

        public FramerateRange(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoCapture(int id, long nativeVideoCaptureDeviceAndroid) {
        this.mId = id;
        this.mNativeVideoCaptureDeviceAndroid = nativeVideoCaptureDeviceAndroid;
    }

    @CalledByNative
    public final int queryWidth() {
        return this.mCaptureFormat.mWidth;
    }

    @CalledByNative
    public final int queryHeight() {
        return this.mCaptureFormat.mHeight;
    }

    @CalledByNative
    public final int queryFrameRate() {
        return this.mCaptureFormat.mFramerate;
    }

    @CalledByNative
    public final int getColorspace() {
        switch (this.mCaptureFormat.mPixelFormat) {
            case 0:
            default:
                return 0;
            case 17:
                return 17;
            case 35:
                return 35;
            case AndroidImageFormat.YV12 /* 842094169 */:
                return AndroidImageFormat.YV12;
        }
    }

    @CalledByNative
    public final void setTestMode() {
        this.mUseBackgroundThreadForTesting = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getCameraRotation() {
        int rotation = this.mInvertDeviceOrientationReadings ? 360 - getDeviceRotation() : getDeviceRotation();
        return (this.mCameraNativeOrientation + rotation) % 360;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getDeviceRotation() {
        int orientation;
        WindowManager wm = (WindowManager) ContextUtils.getApplicationContext().getSystemService("window");
        switch (wm.getDefaultDisplay().getRotation()) {
            case 0:
            default:
                orientation = 0;
                break;
            case 1:
                orientation = 90;
                break;
            case 2:
                orientation = 180;
                break;
            case 3:
                orientation = 270;
                break;
        }
        return orientation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyTakePhotoError(long callbackId) {
        nativeOnPhotoTaken(this.mNativeVideoCaptureDeviceAndroid, callbackId, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static FramerateRange getClosestFramerateRange(List<FramerateRange> framerateRanges, final int targetFramerate) {
        return (FramerateRange) Collections.min(framerateRanges, new Comparator<FramerateRange>() { // from class: org.chromium.media.VideoCapture.1
            private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
            private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
            private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
            private static final int MIN_FPS_THRESHOLD = 8000;
            private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
            private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;

            private int progressivePenalty(int value, int threshold, int lowWeight, int highWeight) {
                if (value < threshold) {
                    return value * lowWeight;
                }
                return (threshold * lowWeight) + ((value - threshold) * highWeight);
            }

            int diff(FramerateRange range) {
                int minFpsError = progressivePenalty(range.min, MIN_FPS_THRESHOLD, 1, 4);
                int maxFpsError = progressivePenalty(Math.abs(targetFramerate - range.max), MAX_FPS_DIFF_THRESHOLD, 1, 3);
                return minFpsError + maxFpsError;
            }

            @Override // java.util.Comparator
            public int compare(FramerateRange range1, FramerateRange range2) {
                return diff(range1) - diff(range2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int[] integerArrayListToArray(ArrayList<Integer> intArrayList) {
        int[] intArray = new int[intArrayList.size()];
        for (int i = 0; i < intArrayList.size(); i++) {
            intArray[i] = intArrayList.get(i).intValue();
        }
        return intArray;
    }
}
