package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.Bitmap;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContentIndexService.class */
public interface ContentIndexService extends Interface {
    public static final int MAX_ICON_DIMENSION = 256;
    public static final Interface.Manager<ContentIndexService, Proxy> MANAGER = ContentIndexService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContentIndexService$AddResponse.class */
    public interface AddResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContentIndexService$DeleteResponse.class */
    public interface DeleteResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContentIndexService$GetDescriptionsResponse.class */
    public interface GetDescriptionsResponse extends Callbacks.Callback2<Integer, ContentDescription[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContentIndexService$Proxy.class */
    public interface Proxy extends ContentIndexService, Interface.Proxy {
    }

    void add(long j, ContentDescription contentDescription, Bitmap bitmap, Url url, AddResponse addResponse);

    void delete(long j, String str, DeleteResponse deleteResponse);

    void getDescriptions(long j, GetDescriptionsResponse getDescriptionsResponse);
}
