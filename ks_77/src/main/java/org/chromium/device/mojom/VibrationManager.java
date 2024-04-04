package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/VibrationManager.class */
public interface VibrationManager extends Interface {
    public static final Interface.Manager<VibrationManager, Proxy> MANAGER = VibrationManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/VibrationManager$CancelResponse.class */
    public interface CancelResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/VibrationManager$Proxy.class */
    public interface Proxy extends VibrationManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/VibrationManager$VibrateResponse.class */
    public interface VibrateResponse extends Callbacks.Callback0 {
    }

    void vibrate(long j, VibrateResponse vibrateResponse);

    void cancel(CancelResponse cancelResponse);
}
