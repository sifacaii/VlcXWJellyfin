package org.chromium.device.battery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.device.battery.BatteryStatusManager;
import org.chromium.device.mojom.BatteryMonitor;
import org.chromium.device.mojom.BatteryStatus;
import org.chromium.services.service_manager.InterfaceFactory;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/battery/BatteryMonitorFactory.class */
public class BatteryMonitorFactory implements InterfaceFactory<BatteryMonitor> {
    private static final String TAG = "BattMonitorFactory";
    static final /* synthetic */ boolean $assertionsDisabled;
    private final HashSet<BatteryMonitorImpl> mSubscribedMonitors = new HashSet<>();
    private final BatteryStatusManager.BatteryStatusCallback mCallback = new BatteryStatusManager.BatteryStatusCallback() { // from class: org.chromium.device.battery.BatteryMonitorFactory.1
        @Override // org.chromium.device.battery.BatteryStatusManager.BatteryStatusCallback
        public void onBatteryStatusChanged(BatteryStatus batteryStatus) {
            ThreadUtils.assertOnUiThread();
            List<BatteryMonitorImpl> monitors = new ArrayList<>(BatteryMonitorFactory.this.mSubscribedMonitors);
            for (BatteryMonitorImpl monitor : monitors) {
                monitor.didChange(batteryStatus);
            }
        }
    };
    private final BatteryStatusManager mManager = new BatteryStatusManager(this.mCallback);

    static {
        $assertionsDisabled = !BatteryMonitorFactory.class.desiredAssertionStatus();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.chromium.services.service_manager.InterfaceFactory
    public BatteryMonitor createImpl() {
        ThreadUtils.assertOnUiThread();
        if (this.mSubscribedMonitors.isEmpty() && !this.mManager.start()) {
            Log.e(TAG, "BatteryStatusManager failed to start.", new Object[0]);
        }
        BatteryMonitorImpl monitor = new BatteryMonitorImpl(this);
        this.mSubscribedMonitors.add(monitor);
        return monitor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unsubscribe(BatteryMonitorImpl monitor) {
        ThreadUtils.assertOnUiThread();
        if (!$assertionsDisabled && !this.mSubscribedMonitors.contains(monitor)) {
            throw new AssertionError();
        }
        this.mSubscribedMonitors.remove(monitor);
        if (this.mSubscribedMonitors.isEmpty()) {
            this.mManager.stop();
        }
    }
}
