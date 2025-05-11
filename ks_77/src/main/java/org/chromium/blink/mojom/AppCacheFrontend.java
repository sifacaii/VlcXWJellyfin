package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.UrlLoaderFactory;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheFrontend.class */
public interface AppCacheFrontend extends Interface {
    public static final Interface.Manager<AppCacheFrontend, Proxy> MANAGER = AppCacheFrontend_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheFrontend$Proxy.class */
    public interface Proxy extends AppCacheFrontend, Interface.Proxy {
    }

    void cacheSelected(AppCacheInfo appCacheInfo);

    void eventRaised(int i);

    void progressEventRaised(Url url, int i, int i2);

    void errorEventRaised(AppCacheErrorDetails appCacheErrorDetails);

    void logMessage(int i, String str);

    void setSubresourceFactory(UrlLoaderFactory urlLoaderFactory);
}
