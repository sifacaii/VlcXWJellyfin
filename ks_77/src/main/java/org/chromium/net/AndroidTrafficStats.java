package org.chromium.net;

import android.net.TrafficStats;
import android.os.Process;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("net::android::traffic_stats")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/AndroidTrafficStats.class */
public class AndroidTrafficStats {
    private AndroidTrafficStats() {
    }

    @CalledByNative
    private static long getTotalTxBytes() {
        long bytes = TrafficStats.getTotalTxBytes();
        if (bytes != -1) {
            return bytes;
        }
        return 0L;
    }

    @CalledByNative
    private static long getTotalRxBytes() {
        long bytes = TrafficStats.getTotalRxBytes();
        if (bytes != -1) {
            return bytes;
        }
        return 0L;
    }

    @CalledByNative
    private static long getCurrentUidTxBytes() {
        long bytes = TrafficStats.getUidTxBytes(Process.myUid());
        if (bytes != -1) {
            return bytes;
        }
        return 0L;
    }

    @CalledByNative
    private static long getCurrentUidRxBytes() {
        long bytes = TrafficStats.getUidRxBytes(Process.myUid());
        if (bytes != -1) {
            return bytes;
        }
        return 0L;
    }
}
