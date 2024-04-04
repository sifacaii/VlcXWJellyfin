package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.Time;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BytesProvider.class */
public interface BytesProvider extends Interface {
    public static final Interface.Manager<BytesProvider, Proxy> MANAGER = BytesProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BytesProvider$Proxy.class */
    public interface Proxy extends BytesProvider, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BytesProvider$RequestAsFileResponse.class */
    public interface RequestAsFileResponse extends Callbacks.Callback1<Time> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BytesProvider$RequestAsReplyResponse.class */
    public interface RequestAsReplyResponse extends Callbacks.Callback1<byte[]> {
    }

    void requestAsReply(RequestAsReplyResponse requestAsReplyResponse);

    void requestAsStream(DataPipe.ProducerHandle producerHandle);

    void requestAsFile(long j, long j2, File file, long j3, RequestAsFileResponse requestAsFileResponse);
}
