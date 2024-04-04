package org.chromium.mojo.bindings;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import org.chromium.mojo.system.MojoException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/DelegatingConnectionErrorHandler.class */
public class DelegatingConnectionErrorHandler implements ConnectionErrorHandler {
    private final Set<ConnectionErrorHandler> mHandlers = Collections.newSetFromMap(new WeakHashMap());

    @Override // org.chromium.mojo.bindings.ConnectionErrorHandler
    public void onConnectionError(MojoException e) {
        for (ConnectionErrorHandler handler : this.mHandlers) {
            handler.onConnectionError(e);
        }
    }

    public void addConnectionErrorHandler(ConnectionErrorHandler handler) {
        this.mHandlers.add(handler);
    }

    public void removeConnectionErrorHandler(ConnectionErrorHandler handler) {
        this.mHandlers.remove(handler);
    }
}
