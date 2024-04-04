package org.chromium.blink.mojom;

import org.chromium.filesystem.mojom.DirectoryEntry;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemOperationListener.class */
public interface FileSystemOperationListener extends Interface {
    public static final Interface.Manager<FileSystemOperationListener, Proxy> MANAGER = FileSystemOperationListener_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileSystemOperationListener$Proxy.class */
    public interface Proxy extends FileSystemOperationListener, Interface.Proxy {
    }

    void resultsRetrieved(DirectoryEntry[] directoryEntryArr, boolean z);

    void didWrite(long j, boolean z);

    void errorOccurred(int i);
}
