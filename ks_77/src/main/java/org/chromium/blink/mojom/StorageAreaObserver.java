package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageAreaObserver.class */
public interface StorageAreaObserver extends Interface {
    public static final Interface.Manager<StorageAreaObserver, Proxy> MANAGER = StorageAreaObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StorageAreaObserver$Proxy.class */
    public interface Proxy extends StorageAreaObserver, Interface.Proxy {
    }

    void keyAdded(byte[] bArr, byte[] bArr2, String str);

    void keyChanged(byte[] bArr, byte[] bArr2, byte[] bArr3, String str);

    void keyDeleted(byte[] bArr, byte[] bArr2, String str);

    void allDeleted(String str);

    void shouldSendOldValueOnMutations(boolean z);
}
