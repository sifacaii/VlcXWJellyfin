package org.chromium.device.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/FingerprintObserver.class */
public interface FingerprintObserver extends Interface {
    public static final Interface.Manager<FingerprintObserver, Proxy> MANAGER = FingerprintObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/FingerprintObserver$Proxy.class */
    public interface Proxy extends FingerprintObserver, Interface.Proxy {
    }

    void onRestarted();

    void onEnrollScanDone(int i, boolean z, int i2);

    void onAuthScanDone(int i, Map<String, String[]> map);

    void onSessionFailed();
}
