package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.view.Display;
import android.view.View;
import org.chromium.base.annotations.DoNotInline;

@DoNotInline
@TargetApi(26)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/compat/ApiHelperForO.class */
public final class ApiHelperForO {
    private ApiHelperForO() {
    }

    public static boolean isWideColorGamut(Display display) {
        return display.isWideColorGamut();
    }

    public static boolean isScreenWideColorGamut(Configuration configuration) {
        return configuration.isScreenWideColorGamut();
    }

    public static boolean isInstantApp(PackageManager packageManager) {
        return packageManager.isInstantApp();
    }

    public static void setDefaultFocusHighlightEnabled(View view, boolean enabled) {
        view.setDefaultFocusHighlightEnabled(enabled);
    }
}
