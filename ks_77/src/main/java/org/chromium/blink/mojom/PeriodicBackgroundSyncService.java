package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PeriodicBackgroundSyncService.class */
public interface PeriodicBackgroundSyncService extends Interface {
    public static final Interface.Manager<PeriodicBackgroundSyncService, Proxy> MANAGER = PeriodicBackgroundSyncService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PeriodicBackgroundSyncService$GetRegistrationsResponse.class */
    public interface GetRegistrationsResponse extends Callbacks.Callback2<Integer, SyncRegistrationOptions[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PeriodicBackgroundSyncService$Proxy.class */
    public interface Proxy extends PeriodicBackgroundSyncService, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PeriodicBackgroundSyncService$RegisterResponse.class */
    public interface RegisterResponse extends Callbacks.Callback2<Integer, SyncRegistrationOptions> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PeriodicBackgroundSyncService$UnregisterResponse.class */
    public interface UnregisterResponse extends Callbacks.Callback1<Integer> {
    }

    void register(SyncRegistrationOptions syncRegistrationOptions, long j, RegisterResponse registerResponse);

    void unregister(long j, String str, UnregisterResponse unregisterResponse);

    void getRegistrations(long j, GetRegistrationsResponse getRegistrationsResponse);
}
