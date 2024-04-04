package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WorkerContentSettingsProxy.class */
public interface WorkerContentSettingsProxy extends Interface {
    public static final Interface.Manager<WorkerContentSettingsProxy, Proxy> MANAGER = WorkerContentSettingsProxy_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WorkerContentSettingsProxy$AllowCacheStorageResponse.class */
    public interface AllowCacheStorageResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WorkerContentSettingsProxy$AllowIndexedDbResponse.class */
    public interface AllowIndexedDbResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WorkerContentSettingsProxy$Proxy.class */
    public interface Proxy extends WorkerContentSettingsProxy, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WorkerContentSettingsProxy$RequestFileSystemAccessSyncResponse.class */
    public interface RequestFileSystemAccessSyncResponse extends Callbacks.Callback1<Boolean> {
    }

    void allowIndexedDb(AllowIndexedDbResponse allowIndexedDbResponse);

    void allowCacheStorage(AllowCacheStorageResponse allowCacheStorageResponse);

    void requestFileSystemAccessSync(RequestFileSystemAccessSyncResponse requestFileSystemAccessSyncResponse);
}
