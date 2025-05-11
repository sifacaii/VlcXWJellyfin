package org.chromium.mojo.bindings;

import java.io.Closeable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/MessageReceiver.class */
public interface MessageReceiver extends Closeable {
    boolean accept(Message message);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
