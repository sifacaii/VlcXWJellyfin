package org.chromium.device.geolocation;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.VisibleForTesting;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/geolocation/LocationProviderAndroid.class */
public class LocationProviderAndroid implements LocationListener, LocationProvider {
    private static final String TAG = "cr_LocationProvider";
    private LocationManager mLocationManager;
    private boolean mIsRunning;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !LocationProviderAndroid.class.desiredAssertionStatus();
    }

    @Override // org.chromium.device.geolocation.LocationProvider
    public void start(boolean enableHighAccuracy) {
        ThreadUtils.assertOnUiThread();
        unregisterFromLocationUpdates();
        registerForLocationUpdates(enableHighAccuracy);
    }

    @Override // org.chromium.device.geolocation.LocationProvider
    public void stop() {
        ThreadUtils.assertOnUiThread();
        unregisterFromLocationUpdates();
    }

    @Override // org.chromium.device.geolocation.LocationProvider
    public boolean isRunning() {
        ThreadUtils.assertOnUiThread();
        return this.mIsRunning;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (this.mIsRunning) {
            LocationProviderAdapter.onNewLocationAvailable(location);
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String provider) {
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String provider) {
    }

    @VisibleForTesting
    public void setLocationManagerForTesting(LocationManager manager) {
        this.mLocationManager = manager;
    }

    private void createLocationManagerIfNeeded() {
        if (this.mLocationManager != null) {
            return;
        }
        this.mLocationManager = (LocationManager) ContextUtils.getApplicationContext().getSystemService("location");
        if (this.mLocationManager == null) {
            Log.e(TAG, "Could not get location manager.", new Object[0]);
        }
    }

    private void registerForLocationUpdates(boolean enableHighAccuracy) {
        createLocationManagerIfNeeded();
        if (usePassiveOneShotLocation()) {
            return;
        }
        if (!$assertionsDisabled && this.mIsRunning) {
            throw new AssertionError();
        }
        this.mIsRunning = true;
        try {
            Criteria criteria = new Criteria();
            if (enableHighAccuracy) {
                criteria.setAccuracy(1);
            }
            this.mLocationManager.requestLocationUpdates(0L, 0.0f, criteria, this, ThreadUtils.getUiThreadLooper());
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Caught IllegalArgumentException registering for location updates.", new Object[0]);
            unregisterFromLocationUpdates();
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        } catch (SecurityException e2) {
            Log.e(TAG, "Caught security exception while registering for location updates from the system. The application does not have sufficient geolocation permissions.", new Object[0]);
            unregisterFromLocationUpdates();
            LocationProviderAdapter.newErrorAvailable("application does not have sufficient geolocation permissions.");
        }
    }

    private void unregisterFromLocationUpdates() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mLocationManager.removeUpdates(this);
        }
    }

    private boolean usePassiveOneShotLocation() {
        if (!isOnlyPassiveLocationProviderEnabled()) {
            return false;
        }
        Location location = this.mLocationManager.getLastKnownLocation("passive");
        if (location != null) {
            ThreadUtils.assertOnUiThread();
            LocationProviderAdapter.onNewLocationAvailable(location);
            return true;
        }
        return true;
    }

    private boolean isOnlyPassiveLocationProviderEnabled() {
        List<String> providers = this.mLocationManager.getProviders(true);
        return providers != null && providers.size() == 1 && providers.get(0).equals("passive");
    }
}
