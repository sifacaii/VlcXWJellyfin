package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchRegistrationService.class */
public interface BackgroundFetchRegistrationService extends Interface {
    public static final Interface.Manager<BackgroundFetchRegistrationService, Proxy> MANAGER = BackgroundFetchRegistrationService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchRegistrationService$AbortResponse.class */
    public interface AbortResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchRegistrationService$MatchRequestsResponse.class */
    public interface MatchRequestsResponse extends Callbacks.Callback1<BackgroundFetchSettledFetch[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchRegistrationService$Proxy.class */
    public interface Proxy extends BackgroundFetchRegistrationService, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchRegistrationService$UpdateUiResponse.class */
    public interface UpdateUiResponse extends Callbacks.Callback1<Integer> {
    }

    void updateUi(String str, Bitmap bitmap, UpdateUiResponse updateUiResponse);

    void abort(AbortResponse abortResponse);

    void matchRequests(FetchApiRequest fetchApiRequest, CacheQueryOptions cacheQueryOptions, boolean z, MatchRequestsResponse matchRequestsResponse);

    void addRegistrationObserver(BackgroundFetchRegistrationObserver backgroundFetchRegistrationObserver);
}
