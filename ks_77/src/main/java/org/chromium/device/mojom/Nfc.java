package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Nfc.class */
public interface Nfc extends Interface {
    public static final Interface.Manager<Nfc, Proxy> MANAGER = Nfc_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Nfc$CancelAllWatchesResponse.class */
    public interface CancelAllWatchesResponse extends Callbacks.Callback1<NfcError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Nfc$CancelPushResponse.class */
    public interface CancelPushResponse extends Callbacks.Callback1<NfcError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Nfc$CancelWatchResponse.class */
    public interface CancelWatchResponse extends Callbacks.Callback1<NfcError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Nfc$Proxy.class */
    public interface Proxy extends Nfc, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Nfc$PushResponse.class */
    public interface PushResponse extends Callbacks.Callback1<NfcError> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Nfc$WatchResponse.class */
    public interface WatchResponse extends Callbacks.Callback2<Integer, NfcError> {
    }

    void setClient(NfcClient nfcClient);

    void push(NdefMessage ndefMessage, NfcPushOptions nfcPushOptions, PushResponse pushResponse);

    void cancelPush(int i, CancelPushResponse cancelPushResponse);

    void watch(NfcReaderOptions nfcReaderOptions, WatchResponse watchResponse);

    void cancelWatch(int i, CancelWatchResponse cancelWatchResponse);

    void cancelAllWatches(CancelAllWatchesResponse cancelAllWatchesResponse);

    void suspendNfcOperations();

    void resumeNfcOperations();
}
