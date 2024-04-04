package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.network.mojom.DataPipeGetter;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Blob.class */
public interface Blob extends Interface {
    public static final Interface.Manager<Blob, Proxy> MANAGER = Blob_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Blob$GetInternalUuidResponse.class */
    public interface GetInternalUuidResponse extends Callbacks.Callback1<String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Blob$Proxy.class */
    public interface Proxy extends Blob, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Blob$ReadSideDataResponse.class */
    public interface ReadSideDataResponse extends Callbacks.Callback1<BigBuffer> {
    }

    void clone(InterfaceRequest<Blob> interfaceRequest);

    void asDataPipeGetter(InterfaceRequest<DataPipeGetter> interfaceRequest);

    void readAll(DataPipe.ProducerHandle producerHandle, BlobReaderClient blobReaderClient);

    void readRange(long j, long j2, DataPipe.ProducerHandle producerHandle, BlobReaderClient blobReaderClient);

    void readSideData(ReadSideDataResponse readSideDataResponse);

    void getInternalUuid(GetInternalUuidResponse getInternalUuidResponse);
}
