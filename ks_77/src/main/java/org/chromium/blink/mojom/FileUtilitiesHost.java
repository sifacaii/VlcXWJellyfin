package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileUtilitiesHost.class */
public interface FileUtilitiesHost extends Interface {
    public static final Interface.Manager<FileUtilitiesHost, Proxy> MANAGER = FileUtilitiesHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileUtilitiesHost$GetFileInfoResponse.class */
    public interface GetFileInfoResponse extends Callbacks.Callback1<FileInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileUtilitiesHost$Proxy.class */
    public interface Proxy extends FileUtilitiesHost, Interface.Proxy {
    }

    void getFileInfo(FilePath filePath, GetFileInfoResponse getFileInfoResponse);
}
