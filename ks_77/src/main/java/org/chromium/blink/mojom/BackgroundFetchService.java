package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchService.class */
public interface BackgroundFetchService extends Interface {
    public static final Interface.Manager<BackgroundFetchService, Proxy> MANAGER = BackgroundFetchService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchService$FetchResponse.class */
    public interface FetchResponse extends Callbacks.Callback2<Integer, BackgroundFetchRegistration> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchService$GetDeveloperIdsResponse.class */
    public interface GetDeveloperIdsResponse extends Callbacks.Callback2<Integer, String[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchService$GetIconDisplaySizeResponse.class */
    public interface GetIconDisplaySizeResponse extends Callbacks.Callback1<Size> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchService$GetRegistrationResponse.class */
    public interface GetRegistrationResponse extends Callbacks.Callback2<Integer, BackgroundFetchRegistration> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchService$Proxy.class */
    public interface Proxy extends BackgroundFetchService, Interface.Proxy {
    }

    void fetch(long j, String str, FetchApiRequest[] fetchApiRequestArr, BackgroundFetchOptions backgroundFetchOptions, Bitmap bitmap, BackgroundFetchUkmData backgroundFetchUkmData, FetchResponse fetchResponse);

    void getRegistration(long j, String str, GetRegistrationResponse getRegistrationResponse);

    void getDeveloperIds(long j, GetDeveloperIdsResponse getDeveloperIdsResponse);

    void getIconDisplaySize(GetIconDisplaySizeResponse getIconDisplaySizeResponse);
}
