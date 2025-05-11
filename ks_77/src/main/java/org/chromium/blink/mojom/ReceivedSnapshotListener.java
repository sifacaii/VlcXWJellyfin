package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ReceivedSnapshotListener.class */
public interface ReceivedSnapshotListener extends Interface {
    public static final Interface.Manager<ReceivedSnapshotListener, Proxy> MANAGER = ReceivedSnapshotListener_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ReceivedSnapshotListener$Proxy.class */
    public interface Proxy extends ReceivedSnapshotListener, Interface.Proxy {
    }

    void didReceiveSnapshotFile();
}
