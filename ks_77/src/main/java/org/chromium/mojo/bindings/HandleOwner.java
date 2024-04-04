package org.chromium.mojo.bindings;

import java.io.Closeable;
import org.chromium.mojo.system.Handle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/HandleOwner.class */
public interface HandleOwner<H extends Handle> extends Closeable {
    H passHandle();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
