package org.chromium.media;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.os.Build;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.chromium.base.Log;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.blink.mojom.WebFeature;
import org.chromium.content_public.common.ContentSwitches;
import org.chromium.media.PhotoCapabilities;
import org.chromium.media.VideoCapture;

@JNINamespace("media")
@TargetApi(15)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCaptureCamera.class */
public class VideoCaptureCamera extends VideoCapture implements Camera.PreviewCallback {
    private static final String TAG = "VideoCapture";
    private static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    private static final int NUM_CAPTURE_BUFFERS = 3;
    private static final SparseArray<String> COLOR_TEMPERATURES_MAP;
    private int mExpectedFrameSize;
    private final Object mPhotoTakenCallbackLock;
    private long mPhotoTakenCallbackId;
    private int mPhotoWidth;
    private int mPhotoHeight;
    private Camera.Area mAreaOfInterest;
    private Camera.Parameters mPreviewParameters;
    private Camera mCamera;
    private ReentrantLock mPreviewBufferLock;
    private boolean mIsRunning;
    private int[] mGlTextures;
    private SurfaceTexture mSurfaceTexture;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !VideoCaptureCamera.class.desiredAssertionStatus();
        COLOR_TEMPERATURES_MAP = new SparseArray<>();
        COLOR_TEMPERATURES_MAP.append(WebFeature.INPUT_TYPE_RADIO, "incandescent");
        COLOR_TEMPERATURES_MAP.append(WebFeature.CREDENTIAL_MANAGER_CREATE_SUCCESS_WITH_UVM, "warm-fluorescent");
        COLOR_TEMPERATURES_MAP.append(4250, "fluorescent");
        COLOR_TEMPERATURES_MAP.append(4600, "twilight");
        COLOR_TEMPERATURES_MAP.append(5500, "daylight");
        COLOR_TEMPERATURES_MAP.append(6000, "cloudy-daylight");
        COLOR_TEMPERATURES_MAP.append(7000, "shade");
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCaptureCamera$BuggyDeviceHack.class */
    private static class BuggyDeviceHack {
        private static final String[] COLORSPACE_BUGGY_DEVICE_LIST = {"SAMSUNG-SGH-I747", "ODROID-U2", "XT1092", "XT1095", "XT1096", "XT1097"};

        private BuggyDeviceHack() {
        }

        static int getImageFormat() {
            String[] strArr;
            for (String buggyDevice : COLORSPACE_BUGGY_DEVICE_LIST) {
                if (buggyDevice.contentEquals(Build.MODEL)) {
                    return 17;
                }
            }
            return AndroidImageFormat.YV12;
        }
    }

    private static Camera.CameraInfo getCameraInfo(int id) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(id, cameraInfo);
            return cameraInfo;
        } catch (RuntimeException ex) {
            Log.e(TAG, "getCameraInfo: Camera.getCameraInfo: " + ex, new Object[0]);
            return null;
        }
    }

    private static Camera.Parameters getCameraParameters(Camera camera) {
        try {
            Camera.Parameters parameters = camera.getParameters();
            return parameters;
        } catch (RuntimeException ex) {
            Log.e(TAG, "getCameraParameters: android.hardware.Camera.getParameters: " + ex, new Object[0]);
            if (camera != null) {
                camera.release();
                return null;
            }
            return null;
        }
    }

    private String getClosestWhiteBalance(int colorTemperature, List<String> supportedTemperatures) {
        int diff;
        int minDiff = Integer.MAX_VALUE;
        String matchedTemperature = null;
        for (int i = 0; i < COLOR_TEMPERATURES_MAP.size(); i++) {
            if (supportedTemperatures.contains(COLOR_TEMPERATURES_MAP.valueAt(i)) && (diff = Math.abs(colorTemperature - COLOR_TEMPERATURES_MAP.keyAt(i))) < minDiff) {
                minDiff = diff;
                matchedTemperature = COLOR_TEMPERATURES_MAP.valueAt(i);
            }
        }
        return matchedTemperature;
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCaptureCamera$CrErrorCallback.class */
    private class CrErrorCallback implements Camera.ErrorCallback {
        private CrErrorCallback() {
        }

        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int error, Camera camera) {
            VideoCaptureCamera.this.nativeOnError(VideoCaptureCamera.this.mNativeVideoCaptureDeviceAndroid, 68, "Error id: " + error);
            synchronized (VideoCaptureCamera.this.mPhotoTakenCallbackLock) {
                if (VideoCaptureCamera.this.mPhotoTakenCallbackId == 0) {
                    return;
                }
                VideoCaptureCamera.this.notifyTakePhotoError(VideoCaptureCamera.this.mPhotoTakenCallbackId);
                VideoCaptureCamera.this.mPhotoTakenCallbackId = 0L;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCaptureCamera$CrPictureCallback.class */
    private class CrPictureCallback implements Camera.PictureCallback {
        private CrPictureCallback() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] data, Camera camera) {
            try {
                Log.d(VideoCaptureCamera.TAG, "|mPreviewParameters|: %s", VideoCaptureCamera.this.mPreviewParameters.flatten());
                camera.setParameters(VideoCaptureCamera.this.mPreviewParameters);
            } catch (RuntimeException ex) {
                Log.e(VideoCaptureCamera.TAG, "onPictureTaken, setParameters() " + ex, new Object[0]);
            }
            try {
                camera.startPreview();
            } catch (RuntimeException ex2) {
                Log.e(VideoCaptureCamera.TAG, "onPictureTaken, startPreview() " + ex2, new Object[0]);
            }
            synchronized (VideoCaptureCamera.this.mPhotoTakenCallbackLock) {
                if (VideoCaptureCamera.this.mPhotoTakenCallbackId != 0) {
                    VideoCaptureCamera.this.nativeOnPhotoTaken(VideoCaptureCamera.this.mNativeVideoCaptureDeviceAndroid, VideoCaptureCamera.this.mPhotoTakenCallbackId, data);
                }
                VideoCaptureCamera.this.mPhotoTakenCallbackId = 0L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getNumberOfCameras() {
        return Camera.getNumberOfCameras();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getCaptureApiType(int id) {
        if (getCameraInfo(id) == null) {
            return 11;
        }
        return 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getFacingMode(int id) {
        Camera.CameraInfo cameraInfo = getCameraInfo(id);
        if (cameraInfo == null) {
            return 0;
        }
        switch (cameraInfo.facing) {
            case 0:
                return 2;
            case 1:
                return 1;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getName(int id) {
        String str;
        Camera.CameraInfo cameraInfo = getCameraInfo(id);
        if (cameraInfo == null) {
            return null;
        }
        StringBuilder append = new StringBuilder().append("camera ").append(id).append(", facing ");
        if (cameraInfo.facing == 1) {
            str = "front";
        } else {
            str = "back";
        }
        return append.append(str).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:19|(2:53|54)(2:21|(2:52|48)(1:23))|24|25|26|27|(1:29)|30|(1:32)|33|(8:36|(1:38)|39|(1:41)|42|(2:45|43)|46|34)|47|48|17) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
        r17 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bd, code lost:
        org.chromium.base.Log.e(org.chromium.media.VideoCaptureCamera.TAG, "Camera.Parameters.getSupportedPreviewFpsRange: ", r17);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.chromium.media.VideoCaptureFormat[] getDeviceSupportedFormats(int r8) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.media.VideoCaptureCamera.getDeviceSupportedFormats(int):org.chromium.media.VideoCaptureFormat[]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoCaptureCamera(int id, long nativeVideoCaptureDeviceAndroid) {
        super(id, nativeVideoCaptureDeviceAndroid);
        this.mPhotoTakenCallbackLock = new Object();
        this.mPreviewBufferLock = new ReentrantLock();
    }

    @Override // org.chromium.media.VideoCapture
    public boolean allocate(int width, int height, int frameRate, boolean enableFaceDetection) {
        Log.d(TAG, "allocate: requested (%d x %d) @%dfps", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(frameRate));
        try {
            this.mCamera = Camera.open(this.mId);
            Camera.CameraInfo cameraInfo = getCameraInfo(this.mId);
            if (cameraInfo == null) {
                this.mCamera.release();
                this.mCamera = null;
                return false;
            }
            this.mCameraNativeOrientation = cameraInfo.orientation;
            this.mInvertDeviceOrientationReadings = cameraInfo.facing == 0;
            Log.d(TAG, "allocate: Rotation dev=%d, cam=%d, facing back? %s", Integer.valueOf(getDeviceRotation()), Integer.valueOf(this.mCameraNativeOrientation), Boolean.valueOf(this.mInvertDeviceOrientationReadings));
            Camera.Parameters parameters = getCameraParameters(this.mCamera);
            if (parameters == null) {
                this.mCamera = null;
                return false;
            }
            List<int[]> listFpsRange = parameters.getSupportedPreviewFpsRange();
            if (listFpsRange == null || listFpsRange.size() == 0) {
                Log.e(TAG, "allocate: no fps range found", new Object[0]);
                return false;
            }
            ArrayList<VideoCapture.FramerateRange> framerateRanges = new ArrayList<>(listFpsRange.size());
            for (int[] range : listFpsRange) {
                framerateRanges.add(new VideoCapture.FramerateRange(range[0], range[1]));
            }
            int frameRateScaled = frameRate * 1000;
            VideoCapture.FramerateRange chosenFramerateRange = getClosestFramerateRange(framerateRanges, frameRateScaled);
            int[] chosenFpsRange = {chosenFramerateRange.min, chosenFramerateRange.max};
            Log.d(TAG, "allocate: fps set to [%d-%d]", Integer.valueOf(chosenFpsRange[0]), Integer.valueOf(chosenFpsRange[1]));
            List<Camera.Size> listCameraSize = parameters.getSupportedPreviewSizes();
            int minDiff = Integer.MAX_VALUE;
            int matchedWidth = width;
            int matchedHeight = height;
            for (Camera.Size size : listCameraSize) {
                int diff = Math.abs(size.width - width) + Math.abs(size.height - height);
                Log.d(TAG, "allocate: supported (%d, %d), diff=%d", Integer.valueOf(size.width), Integer.valueOf(size.height), Integer.valueOf(diff));
                if (diff < minDiff && size.width % 32 == 0) {
                    minDiff = diff;
                    matchedWidth = size.width;
                    matchedHeight = size.height;
                }
            }
            if (minDiff == Integer.MAX_VALUE) {
                Log.e(TAG, "allocate: can not find a multiple-of-32 resolution", new Object[0]);
                return false;
            }
            Log.d(TAG, "allocate: matched (%d x %d)", Integer.valueOf(matchedWidth), Integer.valueOf(matchedHeight));
            if (parameters.isVideoStabilizationSupported()) {
                Log.d(TAG, "Image stabilization supported, currently: " + parameters.getVideoStabilization() + ", setting it.");
                parameters.setVideoStabilization(true);
            } else {
                Log.d(TAG, "Image stabilization not supported.");
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            } else {
                Log.d(TAG, "Continuous focus mode not supported.");
            }
            this.mCaptureFormat = new VideoCaptureFormat(matchedWidth, matchedHeight, chosenFpsRange[1] / 1000, BuggyDeviceHack.getImageFormat());
            parameters.setPictureSize(matchedWidth, matchedHeight);
            parameters.setPreviewSize(matchedWidth, matchedHeight);
            parameters.setPreviewFpsRange(chosenFpsRange[0], chosenFpsRange[1]);
            parameters.setPreviewFormat(this.mCaptureFormat.mPixelFormat);
            try {
                this.mCamera.setParameters(parameters);
                this.mGlTextures = new int[1];
                GLES20.glGenTextures(1, this.mGlTextures, 0);
                GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, this.mGlTextures[0]);
                GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
                GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
                GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
                GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
                this.mSurfaceTexture = new SurfaceTexture(this.mGlTextures[0]);
                this.mSurfaceTexture.setOnFrameAvailableListener(null);
                try {
                    this.mCamera.setPreviewTexture(this.mSurfaceTexture);
                    this.mCamera.setErrorCallback(new CrErrorCallback());
                    this.mExpectedFrameSize = ((this.mCaptureFormat.mWidth * this.mCaptureFormat.mHeight) * ImageFormat.getBitsPerPixel(this.mCaptureFormat.mPixelFormat)) / 8;
                    for (int i = 0; i < 3; i++) {
                        byte[] buffer = new byte[this.mExpectedFrameSize];
                        this.mCamera.addCallbackBuffer(buffer);
                    }
                    return true;
                } catch (IOException ex) {
                    Log.e(TAG, "allocate: " + ex, new Object[0]);
                    return false;
                }
            } catch (RuntimeException ex2) {
                Log.e(TAG, "setParameters: " + ex2, new Object[0]);
                return false;
            }
        } catch (RuntimeException ex3) {
            Log.e(TAG, "allocate: Camera.open: " + ex3, new Object[0]);
            return false;
        }
    }

    @Override // org.chromium.media.VideoCapture
    public boolean startCaptureMaybeAsync() {
        if (this.mCamera == null) {
            Log.e(TAG, "startCaptureAsync: mCamera is null", new Object[0]);
            return false;
        }
        this.mPreviewBufferLock.lock();
        try {
            if (this.mIsRunning) {
                return true;
            }
            setPreviewCallback(this);
            try {
                this.mCamera.startPreview();
                this.mPreviewBufferLock.lock();
                try {
                    nativeOnStarted(this.mNativeVideoCaptureDeviceAndroid);
                    this.mIsRunning = true;
                    return true;
                } finally {
                }
            } catch (RuntimeException ex) {
                Log.e(TAG, "startCaptureAsync: Camera.startPreview: " + ex, new Object[0]);
                return false;
            }
        } finally {
        }
    }

    @Override // org.chromium.media.VideoCapture
    public boolean stopCaptureAndBlockUntilStopped() {
        if (this.mCamera == null) {
            Log.e(TAG, "stopCaptureAndBlockUntilStopped: mCamera is null", new Object[0]);
            return true;
        }
        this.mPreviewBufferLock.lock();
        try {
            if (!this.mIsRunning) {
                return true;
            }
            this.mIsRunning = false;
            this.mCamera.stopPreview();
            setPreviewCallback(null);
            return true;
        } finally {
            this.mPreviewBufferLock.unlock();
        }
    }

    @Override // org.chromium.media.VideoCapture
    public void getPhotoCapabilitiesAsync(long callbackId) {
        int index;
        Camera.Parameters parameters = getCameraParameters(this.mCamera);
        if (parameters == null) {
            nativeOnGetPhotoCapabilitiesReply(this.mNativeVideoCaptureDeviceAndroid, callbackId, null);
            return;
        }
        PhotoCapabilities.Builder builder = new PhotoCapabilities.Builder();
        Log.i(TAG, " CAM params: %s", parameters.flatten());
        builder.setInt(0, 0).setInt(1, 0).setInt(2, 0).setInt(3, 0);
        List<Camera.Size> supportedSizes = parameters.getSupportedPictureSizes();
        int minWidth = Integer.MAX_VALUE;
        int minHeight = Integer.MAX_VALUE;
        int maxWidth = 0;
        int maxHeight = 0;
        for (Camera.Size size : supportedSizes) {
            if (size.width < minWidth) {
                minWidth = size.width;
            }
            if (size.height < minHeight) {
                minHeight = size.height;
            }
            if (size.width > maxWidth) {
                maxWidth = size.width;
            }
            if (size.height > maxHeight) {
                maxHeight = size.height;
            }
        }
        Camera.Size currentSize = parameters.getPreviewSize();
        builder.setInt(4, minHeight).setInt(5, maxHeight).setInt(7, 1).setInt(6, currentSize.height).setInt(8, minWidth).setInt(9, maxWidth).setInt(11, 1).setInt(10, currentSize.width);
        int maxZoom = 0;
        int currentZoom = 0;
        int minZoom = 0;
        int stepZoom = 0;
        if (parameters.isZoomSupported()) {
            maxZoom = parameters.getZoomRatios().get(parameters.getMaxZoom()).intValue();
            currentZoom = parameters.getZoomRatios().get(parameters.getZoom()).intValue();
            minZoom = parameters.getZoomRatios().get(0).intValue();
            if (parameters.getZoomRatios().size() > 1) {
                stepZoom = parameters.getZoomRatios().get(1).intValue() - parameters.getZoomRatios().get(0).intValue();
            }
        }
        builder.setDouble(0, minZoom).setDouble(1, maxZoom).setDouble(2, currentZoom).setDouble(3, stepZoom);
        List<String> focusModes = parameters.getSupportedFocusModes();
        if (!$assertionsDisabled && focusModes == null) {
            throw new AssertionError("getSupportedFocusModes() should never return null");
        }
        ArrayList<Integer> jniFocusModes = new ArrayList<>(3);
        if (focusModes.contains("continuous-video") || focusModes.contains("continuous-picture") || focusModes.contains("edof")) {
            jniFocusModes.add(4);
        }
        if (focusModes.contains(ContentSwitches.TOUCH_EVENT_FEATURE_DETECTION_AUTO) || focusModes.contains("macro")) {
            jniFocusModes.add(3);
        }
        if (focusModes.contains("infinity") || focusModes.contains("fixed")) {
            jniFocusModes.add(2);
        }
        builder.setMeteringModeArray(0, integerArrayListToArray(jniFocusModes));
        String focusMode = parameters.getFocusMode();
        int jniFocusMode = 1;
        if (focusMode.equals("continuous-video") || focusMode.equals("continuous-picture") || focusMode.equals("edof")) {
            jniFocusMode = 4;
        } else if (focusMode.equals(ContentSwitches.TOUCH_EVENT_FEATURE_DETECTION_AUTO) || focusMode.equals("macro")) {
            jniFocusMode = 3;
        } else if (focusMode.equals("infinity") || focusMode.equals("fixed")) {
            jniFocusMode = 2;
        }
        builder.setMeteringMode(0, jniFocusMode);
        ArrayList<Integer> jniExposureModes = new ArrayList<>(2);
        jniExposureModes.add(4);
        if (parameters.isAutoExposureLockSupported()) {
            jniExposureModes.add(2);
        }
        builder.setMeteringModeArray(1, integerArrayListToArray(jniExposureModes));
        int jniExposureMode = 4;
        if (parameters.isAutoExposureLockSupported() && parameters.getAutoExposureLock()) {
            jniExposureMode = 2;
        }
        builder.setMeteringMode(1, jniExposureMode);
        float step = parameters.getExposureCompensationStep();
        builder.setDouble(11, step).setDouble(8, parameters.getMinExposureCompensation() * step).setDouble(9, parameters.getMaxExposureCompensation() * step).setDouble(10, parameters.getExposureCompensation() * step);
        ArrayList<Integer> jniWhiteBalanceModes = new ArrayList<>(2);
        List<String> whiteBalanceModes = parameters.getSupportedWhiteBalance();
        if (whiteBalanceModes != null) {
            if (!whiteBalanceModes.isEmpty()) {
                jniWhiteBalanceModes.add(4);
            }
            if (parameters.isAutoWhiteBalanceLockSupported()) {
                jniWhiteBalanceModes.add(2);
            }
        }
        builder.setMeteringModeArray(2, integerArrayListToArray(jniWhiteBalanceModes));
        int jniWhiteBalanceMode = 4;
        if (parameters.isAutoWhiteBalanceLockSupported() && parameters.getAutoWhiteBalanceLock()) {
            jniWhiteBalanceMode = 2;
        }
        builder.setMeteringMode(2, jniWhiteBalanceMode);
        builder.setInt(12, COLOR_TEMPERATURES_MAP.keyAt(0)).setInt(13, COLOR_TEMPERATURES_MAP.keyAt(COLOR_TEMPERATURES_MAP.size() - 1)).setInt(15, 50);
        if (jniWhiteBalanceMode == 2 && (index = COLOR_TEMPERATURES_MAP.indexOfValue(parameters.getWhiteBalance())) >= 0) {
            builder.setInt(14, COLOR_TEMPERATURES_MAP.keyAt(index));
        }
        List<String> flashModes = parameters.getSupportedFlashModes();
        if (flashModes != null) {
            builder.setBool(0, flashModes.contains("torch")).setBool(1, "torch".equals(parameters.getFlashMode())).setBool(2, flashModes.contains("red-eye"));
            ArrayList<Integer> modes = new ArrayList<>(0);
            if (flashModes.contains("off")) {
                modes.add(1);
            }
            if (flashModes.contains(ContentSwitches.TOUCH_EVENT_FEATURE_DETECTION_AUTO)) {
                modes.add(2);
            }
            if (flashModes.contains("on")) {
                modes.add(3);
            }
            builder.setFillLightModeArray(integerArrayListToArray(modes));
        }
        nativeOnGetPhotoCapabilitiesReply(this.mNativeVideoCaptureDeviceAndroid, callbackId, builder.build());
    }

    @Override // org.chromium.media.VideoCapture
    public void setPhotoOptions(double zoom, int focusMode, double focusDistance, int exposureMode, double width, double height, double[] pointsOfInterest2D, boolean hasExposureCompensation, double exposureCompensation, double exposureTime, int whiteBalanceMode, double iso, boolean hasRedEyeReduction, boolean redEyeReduction, int fillLightMode, boolean hasTorch, boolean torch, double colorTemperature) {
        String str;
        Camera.Parameters parameters = getCameraParameters(this.mCamera);
        if (parameters == null) {
            return;
        }
        if (parameters.isZoomSupported() && zoom > 0.0d) {
            List<Integer> zoomRatios = parameters.getZoomRatios();
            int i = 1;
            while (i < zoomRatios.size() && zoom >= zoomRatios.get(i).intValue()) {
                i++;
            }
            parameters.setZoom(i - 1);
        }
        if (focusMode == 2) {
            parameters.setFocusMode("fixed");
        } else if (focusMode == 3) {
            parameters.setFocusMode(ContentSwitches.TOUCH_EVENT_FEATURE_DETECTION_AUTO);
        } else if (focusMode == 4) {
            parameters.setFocusMode("continuous-picture");
        }
        if (parameters.isAutoExposureLockSupported()) {
            if (exposureMode == 2) {
                parameters.setAutoExposureLock(true);
            } else if (exposureMode != 1) {
                parameters.setAutoExposureLock(false);
            }
        }
        if (width > 0.0d) {
            this.mPhotoWidth = (int) Math.round(width);
        }
        if (height > 0.0d) {
            this.mPhotoHeight = (int) Math.round(height);
        }
        if (this.mAreaOfInterest != null && !this.mAreaOfInterest.rect.isEmpty() && zoom > 0.0d) {
            this.mAreaOfInterest = null;
        }
        if (focusMode == 1 || exposureMode == 1) {
            this.mAreaOfInterest = null;
        }
        boolean pointsOfInterestSupported = parameters.getMaxNumMeteringAreas() > 0 || parameters.getMaxNumFocusAreas() > 0;
        if (pointsOfInterestSupported && pointsOfInterest2D.length > 0) {
            if (!$assertionsDisabled && pointsOfInterest2D.length != 2) {
                throw new AssertionError("Only 1 point of interest supported");
            }
            if (!$assertionsDisabled && (pointsOfInterest2D[0] > 1.0d || pointsOfInterest2D[0] < 0.0d)) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && (pointsOfInterest2D[1] > 1.0d || pointsOfInterest2D[1] < 0.0d)) {
                throw new AssertionError();
            }
            int centerX = (int) (Math.round(pointsOfInterest2D[0] * 2000.0d) - 1000);
            int centerY = (int) (Math.round(pointsOfInterest2D[1] * 2000.0d) - 1000);
            this.mAreaOfInterest = new Camera.Area(new Rect(Math.max(-1000, centerX - WebFeature.NAVIGATOR_VENDOR_SUB), Math.max(-1000, centerY - WebFeature.NAVIGATOR_VENDOR_SUB), Math.min(1000, centerX + WebFeature.NAVIGATOR_VENDOR_SUB), Math.min(1000, centerY + WebFeature.NAVIGATOR_VENDOR_SUB)), 1000);
            Log.d(TAG, "Area of interest %s", this.mAreaOfInterest.rect.toString());
        }
        if (this.mAreaOfInterest != null) {
            parameters.setFocusAreas(Arrays.asList(this.mAreaOfInterest));
            parameters.setMeteringAreas(Arrays.asList(this.mAreaOfInterest));
        }
        if (hasExposureCompensation) {
            int unnormalizedExposureCompensation = (int) Math.round(exposureCompensation / parameters.getExposureCompensationStep());
            parameters.setExposureCompensation(unnormalizedExposureCompensation);
        }
        if (whiteBalanceMode == 4 && parameters.getSupportedWhiteBalance() != null) {
            parameters.setWhiteBalance(ContentSwitches.TOUCH_EVENT_FEATURE_DETECTION_AUTO);
        } else if (whiteBalanceMode == 2 && parameters.isAutoWhiteBalanceLockSupported()) {
            parameters.setAutoWhiteBalanceLock(true);
        }
        if (colorTemperature > 0.0d) {
            String closestSetting = getClosestWhiteBalance((int) colorTemperature, parameters.getSupportedWhiteBalance());
            Log.d(TAG, " Color temperature (%f ==> %s)", Double.valueOf(colorTemperature), closestSetting);
            if (closestSetting != null) {
                parameters.setWhiteBalance(closestSetting);
            }
        }
        if (parameters.getSupportedFlashModes() != null) {
            if (hasTorch && torch) {
                parameters.setFlashMode("torch");
            } else if (fillLightMode != 0) {
                switch (fillLightMode) {
                    case 1:
                        parameters.setFlashMode("off");
                        break;
                    case 2:
                        if (hasRedEyeReduction && redEyeReduction) {
                            str = "red-eye";
                        } else {
                            str = ContentSwitches.TOUCH_EVENT_FEATURE_DETECTION_AUTO;
                        }
                        parameters.setFlashMode(str);
                        break;
                    case 3:
                        parameters.setFlashMode("on");
                        break;
                }
            }
        }
        try {
            this.mCamera.setParameters(parameters);
            if (focusMode != 3) {
                return;
            }
            this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: org.chromium.media.VideoCaptureCamera.1
                @Override // android.hardware.Camera.AutoFocusCallback
                public void onAutoFocus(boolean success, Camera camera) {
                    Log.d(VideoCaptureCamera.TAG, "onAutoFocus() finished: %s ", success ? "success" : "failed");
                }
            });
        } catch (RuntimeException ex) {
            Log.e(TAG, "setParameters: ", ex);
        }
    }

    @Override // org.chromium.media.VideoCapture
    public void takePhotoAsync(long callbackId) {
        if (this.mCamera == null || !this.mIsRunning) {
            Log.e(TAG, "takePhotoAsync: mCamera is null or is not running", new Object[0]);
            notifyTakePhotoError(callbackId);
            return;
        }
        synchronized (this.mPhotoTakenCallbackLock) {
            if (this.mPhotoTakenCallbackId != 0) {
                notifyTakePhotoError(callbackId);
                return;
            }
            this.mPhotoTakenCallbackId = callbackId;
            this.mPreviewParameters = getCameraParameters(this.mCamera);
            if (this.mPreviewParameters == null) {
                notifyTakePhotoError(callbackId);
                return;
            }
            Camera.Parameters photoParameters = getCameraParameters(this.mCamera);
            if (photoParameters == null) {
                notifyTakePhotoError(callbackId);
                return;
            }
            photoParameters.setRotation(getCameraRotation());
            if (this.mPhotoWidth > 0 || this.mPhotoHeight > 0) {
                List<Camera.Size> supportedSizes = photoParameters.getSupportedPictureSizes();
                Camera.Size closestSize = null;
                int minDiff = Integer.MAX_VALUE;
                for (Camera.Size size : supportedSizes) {
                    int diff = (this.mPhotoWidth > 0 ? Math.abs(size.width - this.mPhotoWidth) : 0) + (this.mPhotoHeight > 0 ? Math.abs(size.height - this.mPhotoHeight) : 0);
                    if (diff < minDiff) {
                        minDiff = diff;
                        closestSize = size;
                    }
                }
                if (minDiff != Integer.MAX_VALUE) {
                    Log.d(TAG, "requested resolution: (%dx%d); matched (%dx%d)", Integer.valueOf(this.mPhotoWidth), Integer.valueOf(this.mPhotoHeight), Integer.valueOf(closestSize.width), Integer.valueOf(closestSize.height));
                    photoParameters.setPictureSize(closestSize.width, closestSize.height);
                }
            }
            try {
                Log.d(TAG, "|photoParameters|: %s", photoParameters.flatten());
                this.mCamera.setParameters(photoParameters);
                this.mCamera.takePicture(null, null, null, new CrPictureCallback());
            } catch (RuntimeException ex) {
                Log.e(TAG, "setParameters " + ex, new Object[0]);
                notifyTakePhotoError(callbackId);
            }
        }
    }

    @Override // org.chromium.media.VideoCapture
    public void deallocate() {
        if (this.mCamera == null) {
            return;
        }
        stopCaptureAndBlockUntilStopped();
        try {
            this.mCamera.setPreviewTexture(null);
            if (this.mGlTextures != null) {
                GLES20.glDeleteTextures(1, this.mGlTextures, 0);
            }
            this.mCaptureFormat = null;
            this.mCamera.release();
            this.mCamera = null;
        } catch (IOException ex) {
            Log.e(TAG, "deallocate: failed to deallocate camera, " + ex, new Object[0]);
        }
    }

    private void setPreviewCallback(Camera.PreviewCallback cb) {
        this.mCamera.setPreviewCallbackWithBuffer(cb);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] data, Camera camera) {
        this.mPreviewBufferLock.lock();
        try {
            if (this.mIsRunning) {
                if (data.length == this.mExpectedFrameSize) {
                    nativeOnFrameAvailable(this.mNativeVideoCaptureDeviceAndroid, data, this.mExpectedFrameSize, getCameraRotation());
                } else {
                    nativeOnFrameDropped(this.mNativeVideoCaptureDeviceAndroid, 8);
                }
                this.mPreviewBufferLock.unlock();
                if (camera != null) {
                    camera.addCallbackBuffer(data);
                }
            }
        } finally {
            this.mPreviewBufferLock.unlock();
            if (camera != null) {
                camera.addCallbackBuffer(data);
            }
        }
    }
}
