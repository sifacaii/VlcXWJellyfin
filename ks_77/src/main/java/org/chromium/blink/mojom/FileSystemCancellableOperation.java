package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemCancellableOperation.class */
public interface FileSystemCancellableOperation extends Interface {
    public static final Interface.Manager<FileSystemCancellableOperation, Proxy> MANAGER = FileSystemCancellableOperation_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemCancellableOperation$CancelResponse.class */
    public interface CancelResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemCancellableOperation$Proxy.class */
    public interface Proxy extends FileSystemCancellableOperation, Interface.Proxy {
    }

    void cancel(CancelResponse cancelResponse);
}
