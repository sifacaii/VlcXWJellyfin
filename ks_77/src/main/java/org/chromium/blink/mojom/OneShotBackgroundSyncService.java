package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OneShotBackgroundSyncService.class */
public interface OneShotBackgroundSyncService extends Interface {
    public static final Interface.Manager<OneShotBackgroundSyncService, Proxy> MANAGER = OneShotBackgroundSyncService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OneShotBackgroundSyncService$GetRegistrationsResponse.class */
    public interface GetRegistrationsResponse extends Callbacks.Callback2<Integer, SyncRegistrationOptions[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OneShotBackgroundSyncService$Proxy.class */
    public interface Proxy extends OneShotBackgroundSyncService, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OneShotBackgroundSyncService$RegisterResponse.class */
    public interface RegisterResponse extends Callbacks.Callback2<Integer, SyncRegistrationOptions> {
    }

    void register(SyncRegistrationOptions syncRegistrationOptions, long j, RegisterResponse registerResponse);

    void didResolveRegistration(BackgroundSyncRegistrationInfo backgroundSyncRegistrationInfo);

    void getRegistrations(long j, GetRegistrationsResponse getRegistrationsResponse);
}
