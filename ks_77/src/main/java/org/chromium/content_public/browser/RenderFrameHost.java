package org.chromium.content_public.browser;

import org.chromium.base.Callback;
import org.chromium.services.service_manager.InterfaceProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/RenderFrameHost.class */
public interface RenderFrameHost {
    String getLastCommittedURL();

    void getCanonicalUrlForSharing(Callback<String> callback);

    InterfaceProvider getRemoteInterfaces();

    void notifyUserActivation();

    boolean isIncognito();

    boolean isRenderFrameCreated();
}
