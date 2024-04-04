package org.chromium.device.vibration;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;
import org.chromium.device.mojom.VibrationManager;
import org.chromium.mojo.system.MojoException;
import org.chromium.services.service_manager.InterfaceFactory;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/vibration/VibrationManagerImpl.class */
public class VibrationManagerImpl implements VibrationManager {
    private static final String TAG = "VibrationManagerImpl";
    private static final long MINIMUM_VIBRATION_DURATION_MS = 1;
    private static final long MAXIMUM_VIBRATION_DURATION_MS = 10000;
    private final AudioManager mAudioManager;
    private final Vibrator mVibrator;
    private final boolean mHasVibratePermission;
    private static long sVibrateMilliSecondsForTesting = -1;
    private static boolean sVibrateCancelledForTesting;

    public VibrationManagerImpl() {
        Context appContext = ContextUtils.getApplicationContext();
        this.mAudioManager = (AudioManager) appContext.getSystemService("audio");
        this.mVibrator = (Vibrator) appContext.getSystemService("vibrator");
        this.mHasVibratePermission = appContext.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0;
        if (!this.mHasVibratePermission) {
            Log.w(TAG, "Failed to use vibrate API, requires VIBRATE permission.", new Object[0]);
        }
    }

    @Override // org.chromium.mojo.bindings.Interface, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.chromium.mojo.bindings.ConnectionErrorHandler
    public void onConnectionError(MojoException e) {
    }

    @Override // org.chromium.device.mojom.VibrationManager
    public void vibrate(long milliseconds, VibrationManager.VibrateResponse callback) {
        long sanitizedMilliseconds = Math.max((long) MINIMUM_VIBRATION_DURATION_MS, Math.min(milliseconds, (long) MAXIMUM_VIBRATION_DURATION_MS));
        if (this.mAudioManager.getRingerMode() != 0 && this.mHasVibratePermission) {
            this.mVibrator.vibrate(sanitizedMilliseconds);
        }
        setVibrateMilliSecondsForTesting(sanitizedMilliseconds);
        callback.call();
    }

    @Override // org.chromium.device.mojom.VibrationManager
    public void cancel(VibrationManager.CancelResponse callback) {
        if (this.mHasVibratePermission) {
            this.mVibrator.cancel();
        }
        setVibrateCancelledForTesting(true);
        callback.call();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/vibration/VibrationManagerImpl$Factory.class */
    public static class Factory implements InterfaceFactory<VibrationManager> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.services.service_manager.InterfaceFactory
        public VibrationManager createImpl() {
            return new VibrationManagerImpl();
        }
    }

    static void setVibrateMilliSecondsForTesting(long milliseconds) {
        sVibrateMilliSecondsForTesting = milliseconds;
    }

    static void setVibrateCancelledForTesting(boolean cancelled) {
        sVibrateCancelledForTesting = cancelled;
    }

    @CalledByNative
    static long getVibrateMilliSecondsForTesting() {
        return sVibrateMilliSecondsForTesting;
    }

    @CalledByNative
    static boolean getVibrateCancelledForTesting() {
        return sVibrateCancelledForTesting;
    }
}
