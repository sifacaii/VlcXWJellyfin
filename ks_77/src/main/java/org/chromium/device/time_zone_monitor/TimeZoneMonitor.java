package org.chromium.device.time_zone_monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/time_zone_monitor/TimeZoneMonitor.class */
class TimeZoneMonitor {
    private static final String TAG = "cr_TimeZoneMonitor";
    private final IntentFilter mFilter = new IntentFilter("android.intent.action.TIMEZONE_CHANGED");
    private final BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() { // from class: org.chromium.device.time_zone_monitor.TimeZoneMonitor.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
                TimeZoneMonitor.this.nativeTimeZoneChangedFromJava(TimeZoneMonitor.this.mNativePtr);
            } else {
                Log.e(TimeZoneMonitor.TAG, "unexpected intent", new Object[0]);
            }
        }
    };
    private long mNativePtr;

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeTimeZoneChangedFromJava(long j);

    private TimeZoneMonitor(long nativePtr) {
        this.mNativePtr = nativePtr;
        ContextUtils.getApplicationContext().registerReceiver(this.mBroadcastReceiver, this.mFilter);
    }

    @CalledByNative
    static TimeZoneMonitor getInstance(long nativePtr) {
        return new TimeZoneMonitor(nativePtr);
    }

    @CalledByNative
    void stop() {
        ContextUtils.getApplicationContext().unregisterReceiver(this.mBroadcastReceiver);
        this.mNativePtr = 0L;
    }
}
