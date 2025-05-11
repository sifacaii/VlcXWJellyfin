package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.Bitmap;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ImageDownloader.class */
public interface ImageDownloader extends Interface {
    public static final Interface.Manager<ImageDownloader, Proxy> MANAGER = ImageDownloader_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ImageDownloader$DownloadImageResponse.class */
    public interface DownloadImageResponse extends Callbacks.Callback3<Integer, Bitmap[], Size[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ImageDownloader$Proxy.class */
    public interface Proxy extends ImageDownloader, Interface.Proxy {
    }

    void downloadImage(Url url, boolean z, int i, boolean z2, DownloadImageResponse downloadImageResponse);
}
