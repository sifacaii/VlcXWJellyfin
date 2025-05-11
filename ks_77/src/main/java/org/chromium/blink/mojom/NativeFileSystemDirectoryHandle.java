package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemDirectoryHandle.class */
public interface NativeFileSystemDirectoryHandle extends Interface {
    public static final Interface.Manager<NativeFileSystemDirectoryHandle, Proxy> MANAGER = NativeFileSystemDirectoryHandle_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemDirectoryHandle$GetDirectoryResponse.class */
    public interface GetDirectoryResponse extends Callbacks.Callback2<NativeFileSystemError, NativeFileSystemDirectoryHandle> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemDirectoryHandle$GetEntriesResponse.class */
    public interface GetEntriesResponse extends Callbacks.Callback2<NativeFileSystemError, NativeFileSystemEntry[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemDirectoryHandle$GetFileResponse.class */
    public interface GetFileResponse extends Callbacks.Callback2<NativeFileSystemError, NativeFileSystemFileHandle> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemDirectoryHandle$GetPermissionStatusResponse.class */
    public interface GetPermissionStatusResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemDirectoryHandle$Proxy.class */
    public interface Proxy extends NativeFileSystemDirectoryHandle, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemDirectoryHandle$RemoveEntryResponse.class */
    public interface RemoveEntryResponse extends Callbacks.Callback1<NativeFileSystemError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemDirectoryHandle$RequestPermissionResponse.class */
    public interface RequestPermissionResponse extends Callbacks.Callback1<Integer> {
    }

    void getPermissionStatus(boolean z, GetPermissionStatusResponse getPermissionStatusResponse);

    void requestPermission(boolean z, RequestPermissionResponse requestPermissionResponse);

    void getFile(String str, boolean z, GetFileResponse getFileResponse);

    void getDirectory(String str, boolean z, GetDirectoryResponse getDirectoryResponse);

    void getEntries(GetEntriesResponse getEntriesResponse);

    void removeEntry(String str, boolean z, RemoveEntryResponse removeEntryResponse);

    void transfer(InterfaceRequest<NativeFileSystemTransferToken> interfaceRequest);
}
