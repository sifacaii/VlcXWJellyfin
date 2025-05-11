package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.FilePath;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileChooser.class */
public interface FileChooser extends Interface {
    public static final Interface.Manager<FileChooser, Proxy> MANAGER = FileChooser_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileChooser$EnumerateChosenDirectoryResponse.class */
    public interface EnumerateChosenDirectoryResponse extends Callbacks.Callback1<FileChooserResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileChooser$OpenFileChooserResponse.class */
    public interface OpenFileChooserResponse extends Callbacks.Callback1<FileChooserResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileChooser$Proxy.class */
    public interface Proxy extends FileChooser, Interface.Proxy {
    }

    void openFileChooser(FileChooserParams fileChooserParams, OpenFileChooserResponse openFileChooserResponse);

    void enumerateChosenDirectory(FilePath filePath, EnumerateChosenDirectoryResponse enumerateChosenDirectoryResponse);
}
