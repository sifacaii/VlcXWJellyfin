package org.chromium.filesystem.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem.class */
public interface FileSystem extends Interface {
    public static final Interface.Manager<FileSystem, Proxy> MANAGER = FileSystem_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem$OpenPersistentFileSystemResponse.class */
    public interface OpenPersistentFileSystemResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem$OpenTempDirectoryResponse.class */
    public interface OpenTempDirectoryResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem$Proxy.class */
    public interface Proxy extends FileSystem, Interface.Proxy {
    }

    void openTempDirectory(InterfaceRequest<Directory> interfaceRequest, OpenTempDirectoryResponse openTempDirectoryResponse);

    void openPersistentFileSystem(InterfaceRequest<Directory> interfaceRequest, OpenPersistentFileSystemResponse openPersistentFileSystemResponse);
}
