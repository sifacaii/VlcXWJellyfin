package org.chromium.media;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("media")
@TargetApi(21)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/ScreenCapture.class */
public class ScreenCapture extends Fragment {
    private static final String TAG = "cr_ScreenCapture";
    private static final int REQUEST_MEDIA_PROJECTION = 1;
    private final long mNativeScreenCaptureMachineAndroid;
    private final Object mCaptureStateLock = new Object();
    private int mCaptureState = 4;
    private MediaProjection mMediaProjection;
    private MediaProjectionManager mMediaProjectionManager;
    private VirtualDisplay mVirtualDisplay;
    private Surface mSurface;
    private ImageReader mImageReader;
    private HandlerThread mThread;
    private Handler mBackgroundHandler;
    private Display mDisplay;
    private int mCurrentOrientation;
    private Intent mResultData;
    private int mScreenDensity;
    private int mWidth;
    private int mHeight;
    private int mFormat;
    private int mResultCode;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/ScreenCapture$CaptureState.class */
    private @interface CaptureState {
        public static final int ATTACHED = 0;
        public static final int ALLOWED = 1;
        public static final int STARTED = 2;
        public static final int STOPPING = 3;
        public static final int STOPPED = 4;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/ScreenCapture$DeviceOrientation.class */
    private @interface DeviceOrientation {
        public static final int PORTRAIT = 0;
        public static final int LANDSCAPE = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnRGBAFrameAvailable(long j, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnI420FrameAvailable(long j, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3, int i4, int i5, int i6, int i7, long j2);

    private native void nativeOnActivityResult(long j, boolean z);

    private native void nativeOnOrientationChange(long j, int i);

    static {
        $assertionsDisabled = !ScreenCapture.class.desiredAssertionStatus();
    }

    ScreenCapture(long nativeScreenCaptureMachineAndroid) {
        this.mNativeScreenCaptureMachineAndroid = nativeScreenCaptureMachineAndroid;
    }

    @CalledByNative
    static ScreenCapture createScreenCaptureMachine(long nativeScreenCaptureMachineAndroid) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new ScreenCapture(nativeScreenCaptureMachineAndroid);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/ScreenCapture$CrImageReaderListener.class */
    public class CrImageReaderListener implements ImageReader.OnImageAvailableListener {
        private CrImageReaderListener() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader reader) {
            synchronized (ScreenCapture.this.mCaptureStateLock) {
                if (ScreenCapture.this.mCaptureState != 2) {
                    Log.e(ScreenCapture.TAG, "Get captured frame in unexpected state.", new Object[0]);
                } else if (ScreenCapture.this.maybeDoRotation()) {
                    ScreenCapture.this.createImageReaderWithFormat();
                    ScreenCapture.this.createVirtualDisplay();
                } else {
                    try {
                        Image image = reader.acquireLatestImage();
                        Throwable th = null;
                        if (image == null) {
                            if (image != null) {
                                if (0 == 0) {
                                    image.close();
                                    return;
                                }
                                try {
                                    image.close();
                                    return;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                    return;
                                }
                            }
                            return;
                        }
                        try {
                            if (reader.getWidth() != image.getWidth() || reader.getHeight() != image.getHeight()) {
                                Log.e(ScreenCapture.TAG, "ImageReader size (" + reader.getWidth() + "x" + reader.getHeight() + ") did not match Image size (" + image.getWidth() + "x" + image.getHeight() + ")", new Object[0]);
                                throw new IllegalStateException();
                            }
                            switch (image.getFormat()) {
                                case 1:
                                    if (image.getPlanes().length == 1) {
                                        ScreenCapture.this.nativeOnRGBAFrameAvailable(ScreenCapture.this.mNativeScreenCaptureMachineAndroid, image.getPlanes()[0].getBuffer(), image.getPlanes()[0].getRowStride(), image.getCropRect().left, image.getCropRect().top, image.getCropRect().width(), image.getCropRect().height(), image.getTimestamp());
                                        break;
                                    } else {
                                        Log.e(ScreenCapture.TAG, "Unexpected image planes for RGBA_8888 format: " + image.getPlanes().length, new Object[0]);
                                        throw new IllegalStateException();
                                    }
                                case 35:
                                    if (image.getPlanes().length == 3) {
                                        ScreenCapture.this.nativeOnI420FrameAvailable(ScreenCapture.this.mNativeScreenCaptureMachineAndroid, image.getPlanes()[0].getBuffer(), image.getPlanes()[0].getRowStride(), image.getPlanes()[1].getBuffer(), image.getPlanes()[2].getBuffer(), image.getPlanes()[1].getRowStride(), image.getPlanes()[1].getPixelStride(), image.getCropRect().left, image.getCropRect().top, image.getCropRect().width(), image.getCropRect().height(), image.getTimestamp());
                                        break;
                                    } else {
                                        Log.e(ScreenCapture.TAG, "Unexpected image planes for YUV_420_888 format: " + image.getPlanes().length, new Object[0]);
                                        throw new IllegalStateException();
                                    }
                                default:
                                    Log.e(ScreenCapture.TAG, "Unexpected image format: " + image.getFormat(), new Object[0]);
                                    throw new IllegalStateException();
                            }
                            if (image != null) {
                                if (0 != 0) {
                                    try {
                                        image.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                } else {
                                    image.close();
                                }
                            }
                        } catch (Throwable th4) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                if (image != null) {
                                    if (th4 != null) {
                                        try {
                                            image.close();
                                        } catch (Throwable th6) {
                                            th4.addSuppressed(th6);
                                        }
                                    } else {
                                        image.close();
                                    }
                                }
                                throw th5;
                            }
                        }
                    } catch (IllegalStateException ex) {
                        Log.e(ScreenCapture.TAG, "acquireLatestImage():" + ex, new Object[0]);
                    } catch (UnsupportedOperationException ex2) {
                        Log.i(ScreenCapture.TAG, "acquireLatestImage():" + ex2, new Object[0]);
                        if (ScreenCapture.this.mFormat == 35) {
                            ScreenCapture.this.mFormat = 1;
                            ScreenCapture.this.createImageReaderWithFormat();
                            ScreenCapture.this.createVirtualDisplay();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/ScreenCapture$MediaProjectionCallback.class */
    private class MediaProjectionCallback extends MediaProjection.Callback {
        private MediaProjectionCallback() {
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            ScreenCapture.this.changeCaptureStateAndNotify(4);
            ScreenCapture.this.mMediaProjection = null;
            if (ScreenCapture.this.mVirtualDisplay == null) {
                return;
            }
            ScreenCapture.this.mVirtualDisplay.release();
            ScreenCapture.this.mVirtualDisplay = null;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
        changeCaptureStateAndNotify(0);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "onAttach");
        changeCaptureStateAndNotify(0);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
        stopCapture();
    }

    @CalledByNative
    public boolean allocate(int width, int height) {
        this.mWidth = width;
        this.mHeight = height;
        this.mMediaProjectionManager = (MediaProjectionManager) ContextUtils.getApplicationContext().getSystemService("media_projection");
        if (this.mMediaProjectionManager == null) {
            Log.e(TAG, "mMediaProjectionManager is null", new Object[0]);
            return false;
        }
        WindowManager windowManager = (WindowManager) ContextUtils.getApplicationContext().getSystemService("window");
        this.mDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        this.mDisplay.getMetrics(metrics);
        this.mScreenDensity = metrics.densityDpi;
        return true;
    }

    @CalledByNative
    public boolean startPrompt() {
        Log.d(TAG, "startPrompt");
        Activity activity = ApplicationStatus.getLastTrackedFocusedActivity();
        if (activity == null) {
            Log.e(TAG, "activity is null", new Object[0]);
            return false;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(this, "screencapture");
        try {
            fragmentTransaction.commit();
            synchronized (this.mCaptureStateLock) {
                while (this.mCaptureState != 0) {
                    try {
                        this.mCaptureStateLock.wait();
                    } catch (InterruptedException ex) {
                        Log.e(TAG, "ScreenCaptureException: " + ex, new Object[0]);
                    }
                }
            }
            try {
                startActivityForResult(this.mMediaProjectionManager.createScreenCaptureIntent(), 1);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e(TAG, "ScreenCaptureException " + e, new Object[0]);
                return false;
            }
        } catch (RuntimeException e2) {
            Log.e(TAG, "ScreenCaptureExcaption " + e2, new Object[0]);
            return false;
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 1) {
            return;
        }
        if (resultCode == -1) {
            this.mResultCode = resultCode;
            this.mResultData = data;
            changeCaptureStateAndNotify(1);
        }
        nativeOnActivityResult(this.mNativeScreenCaptureMachineAndroid, resultCode == -1);
    }

    @CalledByNative
    public boolean startCapture() {
        Log.d(TAG, "startCapture");
        synchronized (this.mCaptureStateLock) {
            if (this.mCaptureState != 1) {
                Log.e(TAG, "startCapture() invoked without user permission.", new Object[0]);
                return false;
            }
            this.mMediaProjection = this.mMediaProjectionManager.getMediaProjection(this.mResultCode, this.mResultData);
            if (this.mMediaProjection == null) {
                Log.e(TAG, "mMediaProjection is null", new Object[0]);
                return false;
            }
            this.mMediaProjection.registerCallback(new MediaProjectionCallback(), null);
            this.mThread = new HandlerThread("ScreenCapture");
            this.mThread.start();
            this.mBackgroundHandler = new Handler(this.mThread.getLooper());
            this.mFormat = 1;
            maybeDoRotation();
            createImageReaderWithFormat();
            createVirtualDisplay();
            changeCaptureStateAndNotify(2);
            return true;
        }
    }

    @CalledByNative
    public void stopCapture() {
        Log.d(TAG, "stopCapture");
        synchronized (this.mCaptureStateLock) {
            if (this.mMediaProjection != null && this.mCaptureState == 2) {
                this.mMediaProjection.stop();
                changeCaptureStateAndNotify(3);
                while (this.mCaptureState != 4) {
                    try {
                        this.mCaptureStateLock.wait();
                    } catch (InterruptedException ex) {
                        Log.e(TAG, "ScreenCaptureEvent: " + ex, new Object[0]);
                    }
                }
            } else {
                changeCaptureStateAndNotify(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createImageReaderWithFormat() {
        if (this.mImageReader != null) {
            this.mImageReader.close();
        }
        this.mImageReader = ImageReader.newInstance(this.mWidth, this.mHeight, this.mFormat, 2);
        this.mSurface = this.mImageReader.getSurface();
        CrImageReaderListener imageReaderListener = new CrImageReaderListener();
        this.mImageReader.setOnImageAvailableListener(imageReaderListener, this.mBackgroundHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createVirtualDisplay() {
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.release();
        }
        this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("ScreenCapture", this.mWidth, this.mHeight, this.mScreenDensity, 16, this.mSurface, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCaptureStateAndNotify(int state) {
        synchronized (this.mCaptureStateLock) {
            this.mCaptureState = state;
            this.mCaptureStateLock.notifyAll();
        }
    }

    private int getDeviceRotation() {
        switch (this.mDisplay.getRotation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                if ($assertionsDisabled) {
                    return 0;
                }
                throw new AssertionError();
        }
    }

    private int getDeviceOrientation(int rotation) {
        switch (rotation) {
            case 0:
            case 180:
                return 0;
            case 90:
            case 270:
                return 1;
            default:
                if ($assertionsDisabled) {
                    return 1;
                }
                throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeDoRotation() {
        int rotation = getDeviceRotation();
        int orientation = getDeviceOrientation(rotation);
        if (orientation == this.mCurrentOrientation) {
            return false;
        }
        this.mCurrentOrientation = orientation;
        rotateCaptureOrientation(orientation);
        nativeOnOrientationChange(this.mNativeScreenCaptureMachineAndroid, rotation);
        return true;
    }

    private void rotateCaptureOrientation(int orientation) {
        if ((orientation == 1 && this.mWidth < this.mHeight) || (orientation == 0 && this.mHeight < this.mWidth)) {
            int i = this.mWidth;
            int i2 = this.mHeight;
            int i3 = this.mWidth;
            this.mHeight = i3;
            this.mWidth = i + (i2 - i3);
        }
    }
}
