package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.BigBuffer;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient.class */
public interface UrlLoaderClient extends Interface {
    public static final Interface.Manager<UrlLoaderClient, Proxy> MANAGER = UrlLoaderClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient$OnUploadProgressResponse.class */
    public interface OnUploadProgressResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient$Proxy.class */
    public interface Proxy extends UrlLoaderClient, Interface.Proxy {
    }

    void onReceiveResponse(UrlResponseHead urlResponseHead);

    void onReceiveRedirect(UrlRequestRedirectInfo urlRequestRedirectInfo, UrlResponseHead urlResponseHead);

    void onUploadProgress(long j, long j2, OnUploadProgressResponse onUploadProgressResponse);

    void onReceiveCachedMetadata(BigBuffer bigBuffer);

    void onTransferSizeUpdated(int i);

    void onStartLoadingResponseBody(DataPipe.ConsumerHandle consumerHandle);

    void onComplete(UrlLoaderCompletionStatus urlLoaderCompletionStatus);
}
