package org.chromium.media;

import android.os.Build;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

/* JADX INFO: Access modifiers changed from: package-private */
@JNINamespace("media")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCaptureFactory.class */
public class VideoCaptureFactory {
    VideoCaptureFactory() {
    }

    static /* synthetic */ boolean access$000() {
        return isLReleaseOrLater();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCaptureFactory$ChromiumCameraInfo.class */
    static class ChromiumCameraInfo {
        private static int sNumberOfSystemCameras = -1;
        private static final String TAG = "cr.media";

        ChromiumCameraInfo() {
        }

        static /* synthetic */ int access$100() {
            return getNumberOfCameras();
        }

        private static int getNumberOfCameras() {
            if (sNumberOfSystemCameras == -1) {
                if (Build.VERSION.SDK_INT < 23 && ContextUtils.getApplicationContext().getPackageManager().checkPermission("android.permission.CAMERA", ContextUtils.getApplicationContext().getPackageName()) != 0) {
                    sNumberOfSystemCameras = 0;
                    Log.w(TAG, "Missing android.permission.CAMERA permission, no system camera available.", new Object[0]);
                } else if (VideoCaptureFactory.access$000()) {
                    sNumberOfSystemCameras = VideoCaptureCamera2.getNumberOfCameras();
                } else {
                    sNumberOfSystemCameras = VideoCaptureCamera.getNumberOfCameras();
                }
            }
            return sNumberOfSystemCameras;
        }
    }

    private static boolean isLReleaseOrLater() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @CalledByNative
    static boolean isLegacyOrDeprecatedDevice(int id) {
        return !isLReleaseOrLater() || VideoCaptureCamera2.isLegacyDevice(id);
    }

    @CalledByNative
    static VideoCapture createVideoCapture(int id, long nativeVideoCaptureDeviceAndroid) {
        if (isLegacyOrDeprecatedDevice(id)) {
            return new VideoCaptureCamera(id, nativeVideoCaptureDeviceAndroid);
        }
        return new VideoCaptureCamera2(id, nativeVideoCaptureDeviceAndroid);
    }

    @CalledByNative
    static int getNumberOfCameras() {
        return ChromiumCameraInfo.access$100();
    }

    @CalledByNative
    static int getCaptureApiType(int id) {
        if (isLegacyOrDeprecatedDevice(id)) {
            return VideoCaptureCamera.getCaptureApiType(id);
        }
        return VideoCaptureCamera2.getCaptureApiType(id);
    }

    @CalledByNative
    static int getFacingMode(int id) {
        if (isLegacyOrDeprecatedDevice(id)) {
            return VideoCaptureCamera.getFacingMode(id);
        }
        return VideoCaptureCamera2.getFacingMode(id);
    }

    @CalledByNative
    static String getDeviceName(int id) {
        if (isLegacyOrDeprecatedDevice(id)) {
            return VideoCaptureCamera.getName(id);
        }
        return VideoCaptureCamera2.getName(id);
    }

    @CalledByNative
    static VideoCaptureFormat[] getDeviceSupportedFormats(int id) {
        if (isLegacyOrDeprecatedDevice(id)) {
            return VideoCaptureCamera.getDeviceSupportedFormats(id);
        }
        return VideoCaptureCamera2.getDeviceSupportedFormats(id);
    }

    @CalledByNative
    static int getCaptureFormatWidth(VideoCaptureFormat format) {
        return format.getWidth();
    }

    @CalledByNative
    static int getCaptureFormatHeight(VideoCaptureFormat format) {
        return format.getHeight();
    }

    @CalledByNative
    static int getCaptureFormatFramerate(VideoCaptureFormat format) {
        return format.getFramerate();
    }

    @CalledByNative
    static int getCaptureFormatPixelFormat(VideoCaptureFormat format) {
        return format.getPixelFormat();
    }
}
