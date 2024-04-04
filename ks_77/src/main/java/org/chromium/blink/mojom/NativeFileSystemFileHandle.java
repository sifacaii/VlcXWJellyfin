package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileHandle.class */
public interface NativeFileSystemFileHandle extends Interface {
    public static final Interface.Manager<NativeFileSystemFileHandle, Proxy> MANAGER = NativeFileSystemFileHandle_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileHandle$AsBlobResponse.class */
    public interface AsBlobResponse extends Callbacks.Callback2<NativeFileSystemError, SerializedBlob> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileHandle$CreateFileWriterResponse.class */
    public interface CreateFileWriterResponse extends Callbacks.Callback2<NativeFileSystemError, NativeFileSystemFileWriter> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileHandle$GetPermissionStatusResponse.class */
    public interface GetPermissionStatusResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileHandle$Proxy.class */
    public interface Proxy extends NativeFileSystemFileHandle, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileHandle$RemoveResponse.class */
    public interface RemoveResponse extends Callbacks.Callback1<NativeFileSystemError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemFileHandle$RequestPermissionResponse.class */
    public interface RequestPermissionResponse extends Callbacks.Callback1<Integer> {
    }

    void getPermissionStatus(boolean z, GetPermissionStatusResponse getPermissionStatusResponse);

    void requestPermission(boolean z, RequestPermissionResponse requestPermissionResponse);

    void asBlob(AsBlobResponse asBlobResponse);

    void remove(RemoveResponse removeResponse);

    void createFileWriter(CreateFileWriterResponse createFileWriterResponse);

    void transfer(InterfaceRequest<NativeFileSystemTransferToken> interfaceRequest);
}
