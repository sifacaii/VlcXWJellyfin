package org.chromium.blink.mojom.document_metadata;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/document_metadata/CopylessPaste.class */
public interface CopylessPaste extends Interface {
    public static final Interface.Manager<CopylessPaste, Proxy> MANAGER = CopylessPaste_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/document_metadata/CopylessPaste$GetEntitiesResponse.class */
    public interface GetEntitiesResponse extends Callbacks.Callback1<WebPage> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/document_metadata/CopylessPaste$Proxy.class */
    public interface Proxy extends CopylessPaste, Interface.Proxy {
    }

    void getEntities(GetEntitiesResponse getEntitiesResponse);
}
