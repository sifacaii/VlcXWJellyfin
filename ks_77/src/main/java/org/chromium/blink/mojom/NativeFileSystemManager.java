package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemManager.class */
public interface NativeFileSystemManager extends Interface {
    public static final Interface.Manager<NativeFileSystemManager, Proxy> MANAGER = NativeFileSystemManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemManager$ChooseEntriesResponse.class */
    public interface ChooseEntriesResponse extends Callbacks.Callback2<NativeFileSystemError, NativeFileSystemEntry[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemManager$GetSandboxedFileSystemResponse.class */
    public interface GetSandboxedFileSystemResponse extends Callbacks.Callback2<NativeFileSystemError, NativeFileSystemDirectoryHandle> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemManager$Proxy.class */
    public interface Proxy extends NativeFileSystemManager, Interface.Proxy {
    }

    void getSandboxedFileSystem(GetSandboxedFileSystemResponse getSandboxedFileSystemResponse);

    void chooseEntries(int i, ChooseFileSystemEntryAcceptsOption[] chooseFileSystemEntryAcceptsOptionArr, boolean z, ChooseEntriesResponse chooseEntriesResponse);
}
