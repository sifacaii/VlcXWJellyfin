package org.chromium.mojo.bindings;

import org.chromium.mojo.system.MojoException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/ConnectionErrorHandler.class */
public interface ConnectionErrorHandler {
    void onConnectionError(MojoException mojoException);
}
