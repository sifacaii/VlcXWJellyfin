package org.chromium.mojo.system;

import java.io.Closeable;
import org.chromium.mojo.system.Core;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/Handle.class */
public interface Handle extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Core.HandleSignalsState querySignalsState();

    boolean isValid();

    UntypedHandle toUntypedHandle();

    Core getCore();

    Handle pass();

    int releaseNativeHandle();
}
