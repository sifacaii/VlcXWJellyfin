package org.chromium.filesystem.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File.class */
public interface File extends Interface {
    public static final Interface.Manager<File, Proxy> MANAGER = File_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$AsHandleResponse.class */
    public interface AsHandleResponse extends Callbacks.Callback2<Integer, org.chromium.mojo_base.mojom.File> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$CloseResponse.class */
    public interface CloseResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$DupResponse.class */
    public interface DupResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$FlushResponse.class */
    public interface FlushResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$LockResponse.class */
    public interface LockResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$Proxy.class */
    public interface Proxy extends File, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$ReadResponse.class */
    public interface ReadResponse extends Callbacks.Callback2<Integer, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$SeekResponse.class */
    public interface SeekResponse extends Callbacks.Callback2<Integer, Long> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$StatResponse.class */
    public interface StatResponse extends Callbacks.Callback2<Integer, FileInformation> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$TellResponse.class */
    public interface TellResponse extends Callbacks.Callback2<Integer, Long> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$TouchResponse.class */
    public interface TouchResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$TruncateResponse.class */
    public interface TruncateResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$UnlockResponse.class */
    public interface UnlockResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/File$WriteResponse.class */
    public interface WriteResponse extends Callbacks.Callback2<Integer, Integer> {
    }

    void close(CloseResponse closeResponse);

    void read(int i, long j, int i2, ReadResponse readResponse);

    void write(byte[] bArr, long j, int i, WriteResponse writeResponse);

    void tell(TellResponse tellResponse);

    void seek(long j, int i, SeekResponse seekResponse);

    void stat(StatResponse statResponse);

    void truncate(long j, TruncateResponse truncateResponse);

    void touch(TimespecOrNow timespecOrNow, TimespecOrNow timespecOrNow2, TouchResponse touchResponse);

    void dup(InterfaceRequest<File> interfaceRequest, DupResponse dupResponse);

    void flush(FlushResponse flushResponse);

    void lock(LockResponse lockResponse);

    void unlock(UnlockResponse unlockResponse);

    void asHandle(AsHandleResponse asHandleResponse);
}
