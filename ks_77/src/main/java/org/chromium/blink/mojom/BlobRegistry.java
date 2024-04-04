package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobRegistry.class */
public interface BlobRegistry extends Interface {
    public static final Interface.Manager<BlobRegistry, Proxy> MANAGER = BlobRegistry_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobRegistry$GetBlobFromUuidResponse.class */
    public interface GetBlobFromUuidResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobRegistry$Proxy.class */
    public interface Proxy extends BlobRegistry, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobRegistry$RegisterFromStreamResponse.class */
    public interface RegisterFromStreamResponse extends Callbacks.Callback1<SerializedBlob> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BlobRegistry$RegisterResponse.class */
    public interface RegisterResponse extends Callbacks.Callback0 {
    }

    void register(InterfaceRequest<Blob> interfaceRequest, String str, String str2, String str3, DataElement[] dataElementArr, RegisterResponse registerResponse);

    void registerFromStream(String str, String str2, long j, DataPipe.ConsumerHandle consumerHandle, AssociatedInterfaceNotSupported associatedInterfaceNotSupported, RegisterFromStreamResponse registerFromStreamResponse);

    void getBlobFromUuid(InterfaceRequest<Blob> interfaceRequest, String str, GetBlobFromUuidResponse getBlobFromUuidResponse);

    void urlStoreForOrigin(Origin origin, AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);
}
