package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader.class */
public interface UrlLoader extends Interface {
    public static final int CLIENT_DISCONNECT_REASON = 1;
    public static final Interface.Manager<UrlLoader, Proxy> MANAGER = UrlLoader_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader$Proxy.class */
    public interface Proxy extends UrlLoader, Interface.Proxy {
    }

    void followRedirect(String[] strArr, HttpRequestHeaders httpRequestHeaders, Url url);

    void proceedWithResponse();

    void setPriority(int i, int i2);

    void pauseReadingBodyFromNet();

    void resumeReadingBodyFromNet();
}
