package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderFactory.class */
public interface UrlLoaderFactory extends Interface {
    public static final Interface.Manager<UrlLoaderFactory, Proxy> MANAGER = UrlLoaderFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderFactory$Proxy.class */
    public interface Proxy extends UrlLoaderFactory, Interface.Proxy {
    }

    void createLoaderAndStart(InterfaceRequest<UrlLoader> interfaceRequest, int i, int i2, int i3, UrlRequest urlRequest, UrlLoaderClient urlLoaderClient, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag);

    void clone(InterfaceRequest<UrlLoaderFactory> interfaceRequest);
}
