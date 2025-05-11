package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchRegistrationObserver.class */
public interface BackgroundFetchRegistrationObserver extends Interface {
    public static final Interface.Manager<BackgroundFetchRegistrationObserver, Proxy> MANAGER = BackgroundFetchRegistrationObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchRegistrationObserver$Proxy.class */
    public interface Proxy extends BackgroundFetchRegistrationObserver, Interface.Proxy {
    }

    void onProgress(long j, long j2, long j3, long j4, int i, int i2);

    void onRecordsUnavailable();

    void onRequestCompleted(FetchApiRequest fetchApiRequest, FetchApiResponse fetchApiResponse);
}
