package org.chromium.content_public.browser;

import org.chromium.content.browser.selection.LGEmailActionModeWorkaroundImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/LGEmailActionModeWorkaround.class */
public final class LGEmailActionModeWorkaround {
    private LGEmailActionModeWorkaround() {
    }

    public static boolean isSafeVersion(int versionCode) {
        return LGEmailActionModeWorkaroundImpl.isSafeVersion(versionCode);
    }
}
