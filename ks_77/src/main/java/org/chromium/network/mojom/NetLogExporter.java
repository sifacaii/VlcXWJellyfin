package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.File;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter.class */
public interface NetLogExporter extends Interface {
    public static final long UNLIMITED_FILE_SIZE = -1;
    public static final Interface.Manager<NetLogExporter, Proxy> MANAGER = NetLogExporter_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter$Proxy.class */
    public interface Proxy extends NetLogExporter, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter$StartResponse.class */
    public interface StartResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter$StopResponse.class */
    public interface StopResponse extends Callbacks.Callback1<Integer> {
    }

    void start(File file, DictionaryValue dictionaryValue, int i, long j, StartResponse startResponse);

    void stop(DictionaryValue dictionaryValue, StopResponse stopResponse);
}
