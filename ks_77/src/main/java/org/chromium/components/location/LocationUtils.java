package org.chromium.components.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.Callback;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.content_public.common.ContentSwitches;
import org.chromium.ui.base.PageTransition;
import org.chromium.ui.base.WindowAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/location/LocationUtils.class */
public class LocationUtils {
    private static Factory sFactory;
    private static LocationUtils sInstance;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/location/LocationUtils$Factory.class */
    public interface Factory {
        LocationUtils create();
    }

    protected LocationUtils() {
    }

    public static LocationUtils getInstance() {
        ThreadUtils.assertOnUiThread();
        if (sInstance == null) {
            if (sFactory == null) {
                sInstance = new LocationUtils();
            } else {
                sInstance = sFactory.create();
            }
        }
        return sInstance;
    }

    private boolean hasPermission(String name) {
        Context context = ContextUtils.getApplicationContext();
        return ApiCompatibilityUtils.checkPermission(context, name, Process.myPid(), Process.myUid()) == 0;
    }

    public boolean hasAndroidLocationPermission() {
        return hasPermission("android.permission.ACCESS_COARSE_LOCATION") || hasPermission("android.permission.ACCESS_FINE_LOCATION");
    }

    @SuppressLint({"NewApi"})
    public boolean isSystemLocationSettingEnabled() {
        Context context = ContextUtils.getApplicationContext();
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT >= 19 ? Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0 : !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
        }
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return locationManager != null && locationManager.isLocationEnabled();
    }

    @SuppressLint({"NewApi"})
    public boolean isSystemLocationSettingSensorsOnly() {
        Context context = ContextUtils.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 28) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            return locationManager != null && locationManager.isLocationEnabled() && locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled(ContentSwitches.NETWORK_SANDBOX_TYPE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) == 1;
        } else {
            String locationProviders = Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed");
            return locationProviders.contains("gps") && !locationProviders.contains(ContentSwitches.NETWORK_SANDBOX_TYPE);
        }
    }

    public boolean canPromptToEnableSystemLocationSetting() {
        return false;
    }

    public void promptToEnableSystemLocationSetting(int promptContext, WindowAndroid window, Callback<Integer> callback) {
        callback.onResult(3);
    }

    public Intent getSystemLocationSettingsIntent() {
        Intent i = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        i.setFlags(PageTransition.CHAIN_START);
        return i;
    }

    @VisibleForTesting
    public static void setFactory(Factory factory) {
        sFactory = factory;
        sInstance = null;
    }
}
