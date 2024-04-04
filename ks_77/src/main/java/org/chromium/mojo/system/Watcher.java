package org.chromium.mojo.system;

import org.chromium.mojo.system.Core;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/Watcher.class */
public interface Watcher {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/Watcher$Callback.class */
    public interface Callback {
        void onResult(int i);
    }

    int start(Handle handle, Core.HandleSignals handleSignals, Callback callback);

    void cancel();

    void destroy();
}
