package org.chromium.ui.gfx;

import android.annotation.TargetApi;
import android.provider.Settings;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("gfx")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/gfx/Animation.class */
public class Animation {
    @CalledByNative
    @TargetApi(17)
    private static boolean prefersReducedMotion() {
        float durationScale = Settings.Global.getFloat(ContextUtils.getApplicationContext().getContentResolver(), "animator_duration_scale", 1.0f);
        return ((double) durationScale) == 0.0d;
    }
}
