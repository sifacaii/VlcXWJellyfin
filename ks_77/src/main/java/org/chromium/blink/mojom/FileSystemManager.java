package org.chromium.blink.mojom;

import org.chromium.filesystem.mojom.DirectoryEntry;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager.class */
public interface FileSystemManager extends Interface {
    public static final Interface.Manager<FileSystemManager, Proxy> MANAGER = FileSystemManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$CopyResponse.class */
    public interface CopyResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$CreateResponse.class */
    public interface CreateResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$CreateSnapshotFileResponse.class */
    public interface CreateSnapshotFileResponse extends Callbacks.Callback4<FileInfo, FilePath, Integer, ReceivedSnapshotListener> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$ExistsResponse.class */
    public interface ExistsResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$GetPlatformPathResponse.class */
    public interface GetPlatformPathResponse extends Callbacks.Callback1<FilePath> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$MoveResponse.class */
    public interface MoveResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$OpenResponse.class */
    public interface OpenResponse extends Callbacks.Callback3<String, Url, Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$Proxy.class */
    public interface Proxy extends FileSystemManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$ReadDirectorySyncResponse.class */
    public interface ReadDirectorySyncResponse extends Callbacks.Callback2<DirectoryEntry[], Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$ReadMetadataResponse.class */
    public interface ReadMetadataResponse extends Callbacks.Callback2<FileInfo, Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$RemoveResponse.class */
    public interface RemoveResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$ResolveUrlResponse.class */
    public interface ResolveUrlResponse extends Callbacks.Callback4<FileSystemInfo, FilePath, Boolean, Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$TouchFileResponse.class */
    public interface TouchFileResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$TruncateResponse.class */
    public interface TruncateResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$TruncateSyncResponse.class */
    public interface TruncateSyncResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemManager$WriteSyncResponse.class */
    public interface WriteSyncResponse extends Callbacks.Callback2<Long, Integer> {
    }

    void open(Origin origin, int i, OpenResponse openResponse);

    void resolveUrl(Url url, ResolveUrlResponse resolveUrlResponse);

    void move(Url url, Url url2, MoveResponse moveResponse);

    void copy(Url url, Url url2, CopyResponse copyResponse);

    void remove(Url url, boolean z, RemoveResponse removeResponse);

    void readMetadata(Url url, ReadMetadataResponse readMetadataResponse);

    void create(Url url, boolean z, boolean z2, boolean z3, CreateResponse createResponse);

    void exists(Url url, boolean z, ExistsResponse existsResponse);

    void readDirectory(Url url, FileSystemOperationListener fileSystemOperationListener);

    void readDirectorySync(Url url, ReadDirectorySyncResponse readDirectorySyncResponse);

    void write(Url url, String str, long j, InterfaceRequest<FileSystemCancellableOperation> interfaceRequest, FileSystemOperationListener fileSystemOperationListener);

    void writeSync(Url url, String str, long j, WriteSyncResponse writeSyncResponse);

    void truncate(Url url, long j, InterfaceRequest<FileSystemCancellableOperation> interfaceRequest, TruncateResponse truncateResponse);

    void truncateSync(Url url, long j, TruncateSyncResponse truncateSyncResponse);

    void touchFile(Url url, Time time, Time time2, TouchFileResponse touchFileResponse);

    void createSnapshotFile(Url url, CreateSnapshotFileResponse createSnapshotFileResponse);

    void getPlatformPath(Url url, GetPlatformPathResponse getPlatformPathResponse);
}
