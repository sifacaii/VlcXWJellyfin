package org.chromium.webshare.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService.class */
public interface ShareService extends Interface {
    public static final Interface.Manager<ShareService, Proxy> MANAGER = ShareService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService$Proxy.class */
    public interface Proxy extends ShareService, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService$ShareResponse.class */
    public interface ShareResponse extends Callbacks.Callback1<Integer> {
    }

    void share(String str, String str2, Url url, SharedFile[] sharedFileArr, ShareResponse shareResponse);
}
