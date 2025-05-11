package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabaseHost.class */
public interface WebDatabaseHost extends Interface {
    public static final Interface.Manager<WebDatabaseHost, Proxy> MANAGER = WebDatabaseHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabaseHost$DeleteFileResponse.class */
    public interface DeleteFileResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabaseHost$GetFileAttributesResponse.class */
    public interface GetFileAttributesResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabaseHost$GetFileSizeResponse.class */
    public interface GetFileSizeResponse extends Callbacks.Callback1<Long> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabaseHost$GetSpaceAvailableResponse.class */
    public interface GetSpaceAvailableResponse extends Callbacks.Callback1<Long> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabaseHost$OpenFileResponse.class */
    public interface OpenFileResponse extends Callbacks.Callback1<File> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabaseHost$Proxy.class */
    public interface Proxy extends WebDatabaseHost, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabaseHost$SetFileSizeResponse.class */
    public interface SetFileSizeResponse extends Callbacks.Callback1<Boolean> {
    }

    void openFile(String16 string16, int i, OpenFileResponse openFileResponse);

    void deleteFile(String16 string16, boolean z, DeleteFileResponse deleteFileResponse);

    void getFileAttributes(String16 string16, GetFileAttributesResponse getFileAttributesResponse);

    void getFileSize(String16 string16, GetFileSizeResponse getFileSizeResponse);

    void setFileSize(String16 string16, long j, SetFileSizeResponse setFileSizeResponse);

    void getSpaceAvailable(Origin origin, GetSpaceAvailableResponse getSpaceAvailableResponse);

    void opened(Origin origin, String16 string16, String16 string162, long j);

    void modified(Origin origin, String16 string16);

    void closed(Origin origin, String16 string16);

    void handleSqliteError(Origin origin, String16 string16, int i);
}
