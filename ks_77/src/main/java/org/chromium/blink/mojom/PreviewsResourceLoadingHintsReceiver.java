package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PreviewsResourceLoadingHintsReceiver.class */
public interface PreviewsResourceLoadingHintsReceiver extends Interface {
    public static final Interface.Manager<PreviewsResourceLoadingHintsReceiver, Proxy> MANAGER = PreviewsResourceLoadingHintsReceiver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PreviewsResourceLoadingHintsReceiver$Proxy.class */
    public interface Proxy extends PreviewsResourceLoadingHintsReceiver, Interface.Proxy {
    }

    void setResourceLoadingHints(PreviewsResourceLoadingHints previewsResourceLoadingHints);
}
