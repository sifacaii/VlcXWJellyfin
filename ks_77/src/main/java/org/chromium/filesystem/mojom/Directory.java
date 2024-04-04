package org.chromium.filesystem.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory.class */
public interface Directory extends Interface {
    public static final Interface.Manager<Directory, Proxy> MANAGER = Directory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$DeleteResponse.class */
    public interface DeleteResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$ExistsResponse.class */
    public interface ExistsResponse extends Callbacks.Callback2<Integer, Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$FlushResponse.class */
    public interface FlushResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$IsWritableResponse.class */
    public interface IsWritableResponse extends Callbacks.Callback2<Integer, Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$OpenDirectoryResponse.class */
    public interface OpenDirectoryResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$OpenFileHandleResponse.class */
    public interface OpenFileHandleResponse extends Callbacks.Callback2<Integer, org.chromium.mojo_base.mojom.File> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$OpenFileHandlesResponse.class */
    public interface OpenFileHandlesResponse extends Callbacks.Callback1<FileOpenResult[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$OpenFileResponse.class */
    public interface OpenFileResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$Proxy.class */
    public interface Proxy extends Directory, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$ReadEntireFileResponse.class */
    public interface ReadEntireFileResponse extends Callbacks.Callback2<Integer, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$ReadResponse.class */
    public interface ReadResponse extends Callbacks.Callback2<Integer, DirectoryEntry[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$RenameResponse.class */
    public interface RenameResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$ReplaceResponse.class */
    public interface ReplaceResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$StatFileResponse.class */
    public interface StatFileResponse extends Callbacks.Callback2<Integer, FileInformation> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory$WriteFileResponse.class */
    public interface WriteFileResponse extends Callbacks.Callback1<Integer> {
    }

    void read(ReadResponse readResponse);

    void openFile(String str, InterfaceRequest<File> interfaceRequest, int i, OpenFileResponse openFileResponse);

    void openFileHandle(String str, int i, OpenFileHandleResponse openFileHandleResponse);

    void openFileHandles(FileOpenDetails[] fileOpenDetailsArr, OpenFileHandlesResponse openFileHandlesResponse);

    void openDirectory(String str, InterfaceRequest<Directory> interfaceRequest, int i, OpenDirectoryResponse openDirectoryResponse);

    void rename(String str, String str2, RenameResponse renameResponse);

    void replace(String str, String str2, ReplaceResponse replaceResponse);

    void delete(String str, int i, DeleteResponse deleteResponse);

    void exists(String str, ExistsResponse existsResponse);

    void isWritable(String str, IsWritableResponse isWritableResponse);

    void flush(FlushResponse flushResponse);

    void statFile(String str, StatFileResponse statFileResponse);

    void clone(InterfaceRequest<Directory> interfaceRequest);

    void readEntireFile(String str, ReadEntireFileResponse readEntireFileResponse);

    void writeFile(String str, byte[] bArr, WriteFileResponse writeFileResponse);
}
