package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorage.class */
public interface CacheStorage extends Interface {
    public static final Interface.Manager<CacheStorage, Proxy> MANAGER = CacheStorage_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorage$DeleteResponse.class */
    public interface DeleteResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorage$HasResponse.class */
    public interface HasResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorage$KeysResponse.class */
    public interface KeysResponse extends Callbacks.Callback1<String16[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorage$MatchResponse.class */
    public interface MatchResponse extends Callbacks.Callback1<MatchResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorage$OpenResponse.class */
    public interface OpenResponse extends Callbacks.Callback1<OpenResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorage$Proxy.class */
    public interface Proxy extends CacheStorage, Interface.Proxy {
    }

    void has(String16 string16, long j, HasResponse hasResponse);

    void delete(String16 string16, long j, DeleteResponse deleteResponse);

    void keys(long j, KeysResponse keysResponse);

    void match(FetchApiRequest fetchApiRequest, MultiCacheQueryOptions multiCacheQueryOptions, long j, MatchResponse matchResponse);

    void open(String16 string16, long j, OpenResponse openResponse);
}
