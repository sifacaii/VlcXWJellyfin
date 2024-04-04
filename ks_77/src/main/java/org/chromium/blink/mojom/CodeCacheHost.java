package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CodeCacheHost.class */
public interface CodeCacheHost extends Interface {
    public static final Interface.Manager<CodeCacheHost, Proxy> MANAGER = CodeCacheHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CodeCacheHost$FetchCachedCodeResponse.class */
    public interface FetchCachedCodeResponse extends Callbacks.Callback2<Time, BigBuffer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CodeCacheHost$Proxy.class */
    public interface Proxy extends CodeCacheHost, Interface.Proxy {
    }

    void didGenerateCacheableMetadata(int i, Url url, Time time, BigBuffer bigBuffer);

    void fetchCachedCode(int i, Url url, FetchCachedCodeResponse fetchCachedCodeResponse);

    void clearCodeCacheEntry(int i, Url url);

    void didGenerateCacheableMetadataInCacheStorage(Url url, Time time, BigBuffer bigBuffer, Origin origin, String str);
}
