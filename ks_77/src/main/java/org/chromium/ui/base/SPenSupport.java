package org.chromium.ui.base;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.os.Build;
import org.chromium.base.ContextUtils;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/SPenSupport.class */
public final class SPenSupport {
    private static final int SPEN_ACTION_DOWN = 211;
    private static final int SPEN_ACTION_UP = 212;
    private static final int SPEN_ACTION_MOVE = 213;
    private static final int SPEN_ACTION_CANCEL = 214;
    private static Boolean sIsSPenSupported;

    private static void initialize() {
        if (sIsSPenSupported != null) {
            return;
        }
        if (!"SAMSUNG".equalsIgnoreCase(Build.MANUFACTURER)) {
            sIsSPenSupported = false;
            return;
        }
        Context context = ContextUtils.getApplicationContext();
        FeatureInfo[] infos = context.getPackageManager().getSystemAvailableFeatures();
        for (FeatureInfo info : infos) {
            if ("com.sec.feature.spen_usp".equalsIgnoreCase(info.name)) {
                sIsSPenSupported = true;
                return;
            }
        }
        sIsSPenSupported = false;
    }

    public static int convertSPenEventAction(int eventActionMasked) {
        if (sIsSPenSupported == null) {
            initialize();
        }
        if (sIsSPenSupported.booleanValue()) {
            switch (eventActionMasked) {
                case 211:
                    return 0;
                case 212:
                    return 1;
                case 213:
                    return 2;
                case 214:
                    return 3;
                default:
                    return eventActionMasked;
            }
        }
        return eventActionMasked;
    }
}
