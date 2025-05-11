package org.chromium.content.browser;

import org.chromium.base.CommandLine;
import org.chromium.base.StrictModeContext;
import org.chromium.ui.base.DeviceFormFactor;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/DeviceUtilsImpl.class */
public class DeviceUtilsImpl {
    private DeviceUtilsImpl() {
    }

    public static void addDeviceSpecificUserAgentSwitch() {
        StrictModeContext ignored = StrictModeContext.allowDiskReads();
        Throwable th = null;
        try {
            if (!DeviceFormFactor.isTablet()) {
                CommandLine.getInstance().appendSwitch("use-mobile-user-agent");
            }
            if (ignored != null) {
                if (0 != 0) {
                    try {
                        ignored.close();
                        return;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        return;
                    }
                }
                ignored.close();
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                if (ignored != null) {
                    if (th3 != null) {
                        try {
                            ignored.close();
                        } catch (Throwable th5) {
                            th3.addSuppressed(th5);
                        }
                    } else {
                        ignored.close();
                    }
                }
                throw th4;
            }
        }
    }
}
