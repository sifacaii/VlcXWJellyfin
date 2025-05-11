package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorageCache.class */
public interface CacheStorageCache extends Interface {
    public static final Interface.Manager<CacheStorageCache, Proxy> MANAGER = CacheStorageCache_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorageCache$BatchResponse.class */
    public interface BatchResponse extends Callbacks.Callback1<CacheStorageVerboseError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorageCache$KeysResponse.class */
    public interface KeysResponse extends Callbacks.Callback1<CacheKeysResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorageCache$MatchAllResponse.class */
    public interface MatchAllResponse extends Callbacks.Callback1<MatchAllResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorageCache$MatchResponse.class */
    public interface MatchResponse extends Callbacks.Callback1<MatchResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorageCache$Proxy.class */
    public interface Proxy extends CacheStorageCache, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorageCache$SetSideDataResponse.class */
    public interface SetSideDataResponse extends Callbacks.Callback1<Integer> {
    }

    void match(FetchApiRequest fetchApiRequest, CacheQueryOptions cacheQueryOptions, long j, MatchResponse matchResponse);

    void matchAll(FetchApiRequest fetchApiRequest, CacheQueryOptions cacheQueryOptions, long j, MatchAllResponse matchAllResponse);

    void keys(FetchApiRequest fetchApiRequest, CacheQueryOptions cacheQueryOptions, long j, KeysResponse keysResponse);

    void batch(BatchOperation[] batchOperationArr, long j, BatchResponse batchResponse);

    void setSideData(Url url, Time time, byte[] bArr, long j, SetSideDataResponse setSideDataResponse);
}
