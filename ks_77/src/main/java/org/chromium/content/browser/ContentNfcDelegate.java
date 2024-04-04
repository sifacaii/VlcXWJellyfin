package org.chromium.content.browser;

import android.app.Activity;
import org.chromium.base.Callback;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.device.nfc.NfcDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ContentNfcDelegate.class */
public class ContentNfcDelegate implements NfcDelegate {
    @CalledByNative
    private static ContentNfcDelegate create() {
        return new ContentNfcDelegate();
    }

    @Override // org.chromium.device.nfc.NfcDelegate
    public void trackActivityForHost(int hostId, Callback<Activity> callback) {
        NfcHost host = NfcHost.fromContextId(hostId);
        if (host == null) {
            return;
        }
        host.trackActivityChanges(callback);
    }

    @Override // org.chromium.device.nfc.NfcDelegate
    public void stopTrackingActivityForHost(int hostId) {
        NfcHost host = NfcHost.fromContextId(hostId);
        if (host == null) {
            return;
        }
        host.stopTrackingActivityChanges();
    }
}
