package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageArea.class */
public interface StorageArea extends Interface {
    public static final int PER_STORAGE_AREA_QUOTA = 10485760;
    public static final int PER_STORAGE_AREA_OVER_QUOTA_ALLOWANCE = 102400;
    public static final Interface.Manager<StorageArea, Proxy> MANAGER = StorageArea_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageArea$DeleteAllResponse.class */
    public interface DeleteAllResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageArea$DeleteResponse.class */
    public interface DeleteResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageArea$GetAllResponse.class */
    public interface GetAllResponse extends Callbacks.Callback2<Boolean, KeyValue[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageArea$GetResponse.class */
    public interface GetResponse extends Callbacks.Callback2<Boolean, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageArea$Proxy.class */
    public interface Proxy extends StorageArea, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageArea$PutResponse.class */
    public interface PutResponse extends Callbacks.Callback1<Boolean> {
    }

    void addObserver(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);

    void put(byte[] bArr, byte[] bArr2, byte[] bArr3, String str, PutResponse putResponse);

    void delete(byte[] bArr, byte[] bArr2, String str, DeleteResponse deleteResponse);

    void deleteAll(String str, DeleteAllResponse deleteAllResponse);

    void get(byte[] bArr, GetResponse getResponse);

    void getAll(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, GetAllResponse getAllResponse);
}
