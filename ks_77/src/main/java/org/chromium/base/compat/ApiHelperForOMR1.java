package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.view.Window;
import org.chromium.base.annotations.DoNotInline;

@DoNotInline
@TargetApi(27)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/compat/ApiHelperForOMR1.class */
public final class ApiHelperForOMR1 {
    private ApiHelperForOMR1() {
    }

    public static boolean isWideColorGamut(Window window) {
        return window.isWideColorGamut();
    }
}
