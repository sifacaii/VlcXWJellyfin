package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheHost.class */
public interface AppCacheHost extends Interface {
    public static final Interface.Manager<AppCacheHost, Proxy> MANAGER = AppCacheHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheHost$GetResourceListResponse.class */
    public interface GetResourceListResponse extends Callbacks.Callback1<AppCacheResourceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheHost$GetStatusResponse.class */
    public interface GetStatusResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheHost$Proxy.class */
    public interface Proxy extends AppCacheHost, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheHost$StartUpdateResponse.class */
    public interface StartUpdateResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheHost$SwapCacheResponse.class */
    public interface SwapCacheResponse extends Callbacks.Callback1<Boolean> {
    }

    void setSpawningHostId(UnguessableToken unguessableToken);

    void selectCache(Url url, long j, Url url2);

    void selectCacheForSharedWorker(long j);

    void markAsForeignEntry(Url url, long j);

    void getStatus(GetStatusResponse getStatusResponse);

    void startUpdate(StartUpdateResponse startUpdateResponse);

    void swapCache(SwapCacheResponse swapCacheResponse);

    void getResourceList(GetResourceListResponse getResourceListResponse);
}
