package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobReaderClient.class */
public interface BlobReaderClient extends Interface {
    public static final Interface.Manager<BlobReaderClient, Proxy> MANAGER = BlobReaderClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobReaderClient$Proxy.class */
    public interface Proxy extends BlobReaderClient, Interface.Proxy {
    }

    void onCalculatedSize(long j, long j2);

    void onComplete(int i, long j);
}
