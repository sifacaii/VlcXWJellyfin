package org.chromium.device.power_save_blocker;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/power_save_blocker/PowerSaveBlocker.class */
class PowerSaveBlocker {
    private static HashMap<View, Integer> sBlockViewCounter;
    private WeakReference<View> mKeepScreenOnView;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PowerSaveBlocker.class.desiredAssertionStatus();
        sBlockViewCounter = new HashMap<>();
    }

    @CalledByNative
    private static PowerSaveBlocker create() {
        return new PowerSaveBlocker();
    }

    private PowerSaveBlocker() {
    }

    @CalledByNative
    private void applyBlock(View view) {
        if (!$assertionsDisabled && this.mKeepScreenOnView != null) {
            throw new AssertionError();
        }
        this.mKeepScreenOnView = new WeakReference<>(view);
        Integer prev_counter = sBlockViewCounter.get(view);
        if (prev_counter == null) {
            sBlockViewCounter.put(view, 1);
        } else if (!$assertionsDisabled && prev_counter.intValue() < 0) {
            throw new AssertionError();
        } else {
            sBlockViewCounter.put(view, Integer.valueOf(prev_counter.intValue() + 1));
        }
        if (prev_counter == null || prev_counter.intValue() == 0) {
            view.setKeepScreenOn(true);
        }
    }

    @CalledByNative
    private void removeBlock() {
        if (this.mKeepScreenOnView == null) {
            return;
        }
        View view = this.mKeepScreenOnView.get();
        this.mKeepScreenOnView = null;
        Integer prev_counter = sBlockViewCounter.get(view);
        if (!$assertionsDisabled && prev_counter == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && prev_counter.intValue() <= 0) {
            throw new AssertionError();
        }
        sBlockViewCounter.put(view, Integer.valueOf(prev_counter.intValue() - 1));
        if (prev_counter.intValue() == 1) {
            view.setKeepScreenOn(false);
        }
    }
}
