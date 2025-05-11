package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileWriter.class */
public interface NativeFileSystemFileWriter extends Interface {
    public static final Interface.Manager<NativeFileSystemFileWriter, Proxy> MANAGER = NativeFileSystemFileWriter_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileWriter$CloseResponse.class */
    public interface CloseResponse extends Callbacks.Callback1<NativeFileSystemError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileWriter$Proxy.class */
    public interface Proxy extends NativeFileSystemFileWriter, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileWriter$TruncateResponse.class */
    public interface TruncateResponse extends Callbacks.Callback1<NativeFileSystemError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileWriter$WriteResponse.class */
    public interface WriteResponse extends Callbacks.Callback2<NativeFileSystemError, Long> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileWriter$WriteStreamResponse.class */
    public interface WriteStreamResponse extends Callbacks.Callback2<NativeFileSystemError, Long> {
    }

    void write(long j, Blob blob, WriteResponse writeResponse);

    void writeStream(long j, DataPipe.ConsumerHandle consumerHandle, WriteStreamResponse writeStreamResponse);

    void truncate(long j, TruncateResponse truncateResponse);

    void close(CloseResponse closeResponse);
}
