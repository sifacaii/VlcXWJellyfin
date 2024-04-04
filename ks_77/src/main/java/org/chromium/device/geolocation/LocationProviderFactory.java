package org.chromium.device.geolocation;

import org.chromium.base.ContextUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/geolocation/LocationProviderFactory.class */
public class LocationProviderFactory {
    private static LocationProvider sProviderImpl;
    private static boolean sUseGmsCoreLocationProvider;

    private LocationProviderFactory() {
    }

    @VisibleForTesting
    public static void setLocationProviderImpl(LocationProvider provider) {
        sProviderImpl = provider;
    }

    @CalledByNative
    public static void useGmsCoreLocationProvider() {
        sUseGmsCoreLocationProvider = true;
    }

    public static LocationProvider create() {
        if (sProviderImpl != null) {
            return sProviderImpl;
        }
        if (sUseGmsCoreLocationProvider && LocationProviderGmsCore.isGooglePlayServicesAvailable(ContextUtils.getApplicationContext())) {
            sProviderImpl = new LocationProviderGmsCore(ContextUtils.getApplicationContext());
        } else {
            sProviderImpl = new LocationProviderAndroid();
        }
        return sProviderImpl;
    }
}
