package org.chromium.device.geolocation;

import android.location.Location;
import java.util.concurrent.FutureTask;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;

@VisibleForTesting
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/geolocation/LocationProviderAdapter.class */
public class LocationProviderAdapter {
    private static final String TAG = "cr_LocationProvider";
    private LocationProvider mImpl = LocationProviderFactory.create();
    static final /* synthetic */ boolean $assertionsDisabled;

    private static native void nativeNewLocationAvailable(double d, double d2, double d3, boolean z, double d4, boolean z2, double d5, boolean z3, double d6, boolean z4, double d7);

    private static native void nativeNewErrorAvailable(String str);

    static {
        $assertionsDisabled = !LocationProviderAdapter.class.desiredAssertionStatus();
    }

    private LocationProviderAdapter() {
    }

    @CalledByNative
    public static LocationProviderAdapter create() {
        return new LocationProviderAdapter();
    }

    @CalledByNative
    public void start(final boolean enableHighAccuracy) {
        FutureTask<Void> task = new FutureTask<>(new Runnable() { // from class: org.chromium.device.geolocation.LocationProviderAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                LocationProviderAdapter.this.mImpl.start(enableHighAccuracy);
            }
        }, null);
        ThreadUtils.runOnUiThread((FutureTask) task);
    }

    @CalledByNative
    public void stop() {
        FutureTask<Void> task = new FutureTask<>(new Runnable() { // from class: org.chromium.device.geolocation.LocationProviderAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                LocationProviderAdapter.this.mImpl.stop();
            }
        }, null);
        ThreadUtils.runOnUiThread((FutureTask) task);
    }

    public boolean isRunning() {
        if ($assertionsDisabled || ThreadUtils.runningOnUiThread()) {
            return this.mImpl.isRunning();
        }
        throw new AssertionError();
    }

    public static void onNewLocationAvailable(Location location) {
        nativeNewLocationAvailable(location.getLatitude(), location.getLongitude(), location.getTime() / 1000.0d, location.hasAltitude(), location.getAltitude(), location.hasAccuracy(), location.getAccuracy(), location.hasBearing(), location.getBearing(), location.hasSpeed(), location.getSpeed());
    }

    public static void newErrorAvailable(String message) {
        Log.e(TAG, "newErrorAvailable %s", message);
        nativeNewErrorAvailable(message);
    }
}
