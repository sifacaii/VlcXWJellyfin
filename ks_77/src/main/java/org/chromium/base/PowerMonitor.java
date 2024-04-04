package org.chromium.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/PowerMonitor.class */
public class PowerMonitor {
    private static PowerMonitor sInstance;
    private boolean mIsBatteryPower;
    static final /* synthetic */ boolean $assertionsDisabled;

    private static native void nativeOnBatteryChargingChanged();

    static {
        $assertionsDisabled = !PowerMonitor.class.desiredAssertionStatus();
    }

    public static void createForTests() {
        sInstance = new PowerMonitor();
    }

    public static void create() {
        ThreadUtils.assertOnUiThread();
        if (sInstance != null) {
            return;
        }
        Context context = ContextUtils.getApplicationContext();
        sInstance = new PowerMonitor();
        IntentFilter ifilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent batteryStatusIntent = context.registerReceiver(null, ifilter);
        if (batteryStatusIntent != null) {
            onBatteryChargingChanged(batteryStatusIntent);
        }
        IntentFilter powerConnectedFilter = new IntentFilter();
        powerConnectedFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        powerConnectedFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(new BroadcastReceiver() { // from class: org.chromium.base.PowerMonitor.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                PowerMonitor.onBatteryChargingChanged(intent);
            }
        }, powerConnectedFilter);
    }

    private PowerMonitor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onBatteryChargingChanged(Intent intent) {
        if (!$assertionsDisabled && sInstance == null) {
            throw new AssertionError();
        }
        int chargePlug = intent.getIntExtra("plugged", -1);
        sInstance.mIsBatteryPower = (chargePlug == 2 || chargePlug == 1) ? false : true;
        nativeOnBatteryChargingChanged();
    }

    @CalledByNative
    private static boolean isBatteryPower() {
        if (sInstance == null) {
            create();
        }
        return sInstance.mIsBatteryPower;
    }
}
