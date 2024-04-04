package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabase.class */
public interface WebDatabase extends Interface {
    public static final Interface.Manager<WebDatabase, Proxy> MANAGER = WebDatabase_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebDatabase$Proxy.class */
    public interface Proxy extends WebDatabase, Interface.Proxy {
    }

    void updateSize(Origin origin, String16 string16, long j);

    void closeImmediately(Origin origin, String16 string16);
}
