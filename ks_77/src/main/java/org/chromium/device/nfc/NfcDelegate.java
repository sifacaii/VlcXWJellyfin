package org.chromium.device.nfc;

import android.app.Activity;
import org.chromium.base.Callback;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/nfc/NfcDelegate.class */
public interface NfcDelegate {
    void trackActivityForHost(int i, Callback<Activity> callback);

    void stopTrackingActivityForHost(int i);
}
