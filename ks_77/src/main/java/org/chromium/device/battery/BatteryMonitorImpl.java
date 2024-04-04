package org.chromium.device.battery;

import org.chromium.base.Log;
import org.chromium.device.mojom.BatteryMonitor;
import org.chromium.device.mojom.BatteryStatus;
import org.chromium.mojo.system.MojoException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/battery/BatteryMonitorImpl.class */
public class BatteryMonitorImpl implements BatteryMonitor {
    private static final String TAG = "BatteryMonitorImpl";
    private final BatteryMonitorFactory mFactory;
    private BatteryMonitor.QueryNextStatusResponse mCallback;
    private BatteryStatus mStatus;
    private boolean mHasStatusToReport = false;
    private boolean mSubscribed = true;

    public BatteryMonitorImpl(BatteryMonitorFactory batteryMonitorFactory) {
        this.mFactory = batteryMonitorFactory;
    }

    private void unsubscribe() {
        if (this.mSubscribed) {
            this.mFactory.unsubscribe(this);
            this.mSubscribed = false;
        }
    }

    @Override // org.chromium.mojo.bindings.Interface, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        unsubscribe();
    }

    @Override // org.chromium.mojo.bindings.ConnectionErrorHandler
    public void onConnectionError(MojoException e) {
        unsubscribe();
    }

    @Override // org.chromium.device.mojom.BatteryMonitor
    public void queryNextStatus(BatteryMonitor.QueryNextStatusResponse callback) {
        if (this.mCallback != null) {
            Log.e(TAG, "Overlapped call to queryNextStatus!", new Object[0]);
            unsubscribe();
            return;
        }
        this.mCallback = callback;
        if (this.mHasStatusToReport) {
            reportStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void didChange(BatteryStatus batteryStatus) {
        this.mStatus = batteryStatus;
        this.mHasStatusToReport = true;
        if (this.mCallback != null) {
            reportStatus();
        }
    }

    void reportStatus() {
        this.mCallback.call(this.mStatus);
        this.mCallback = null;
        this.mHasStatusToReport = false;
    }
}
