package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.content.pm.PackageInfo;
import android.net.LinkProperties;
import org.chromium.base.annotations.DoNotInline;

@DoNotInline
@TargetApi(28)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/compat/ApiHelperForP.class */
public final class ApiHelperForP {
    private ApiHelperForP() {
    }

    public static boolean isPrivateDnsActive(LinkProperties linkProperties) {
        return linkProperties.isPrivateDnsActive();
    }

    public static String getPrivateDnsServerName(LinkProperties linkProperties) {
        return linkProperties.getPrivateDnsServerName();
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }
}
