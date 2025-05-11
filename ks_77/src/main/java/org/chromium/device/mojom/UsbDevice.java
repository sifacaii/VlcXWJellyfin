package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice.class */
public interface UsbDevice extends Interface {
    public static final Interface.Manager<UsbDevice, Proxy> MANAGER = UsbDevice_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$ClaimInterfaceResponse.class */
    public interface ClaimInterfaceResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$ClearHaltResponse.class */
    public interface ClearHaltResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$CloseResponse.class */
    public interface CloseResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$ControlTransferInResponse.class */
    public interface ControlTransferInResponse extends Callbacks.Callback2<Integer, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$ControlTransferOutResponse.class */
    public interface ControlTransferOutResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$GenericTransferInResponse.class */
    public interface GenericTransferInResponse extends Callbacks.Callback2<Integer, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$GenericTransferOutResponse.class */
    public interface GenericTransferOutResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$IsochronousTransferInResponse.class */
    public interface IsochronousTransferInResponse extends Callbacks.Callback2<byte[], UsbIsochronousPacket[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$IsochronousTransferOutResponse.class */
    public interface IsochronousTransferOutResponse extends Callbacks.Callback1<UsbIsochronousPacket[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$OpenResponse.class */
    public interface OpenResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$Proxy.class */
    public interface Proxy extends UsbDevice, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$ReleaseInterfaceResponse.class */
    public interface ReleaseInterfaceResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$ResetResponse.class */
    public interface ResetResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$SetConfigurationResponse.class */
    public interface SetConfigurationResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDevice$SetInterfaceAlternateSettingResponse.class */
    public interface SetInterfaceAlternateSettingResponse extends Callbacks.Callback1<Boolean> {
    }

    void open(OpenResponse openResponse);

    void close(CloseResponse closeResponse);

    void setConfiguration(byte b, SetConfigurationResponse setConfigurationResponse);

    void claimInterface(byte b, ClaimInterfaceResponse claimInterfaceResponse);

    void releaseInterface(byte b, ReleaseInterfaceResponse releaseInterfaceResponse);

    void setInterfaceAlternateSetting(byte b, byte b2, SetInterfaceAlternateSettingResponse setInterfaceAlternateSettingResponse);

    void reset(ResetResponse resetResponse);

    void clearHalt(byte b, ClearHaltResponse clearHaltResponse);

    void controlTransferIn(UsbControlTransferParams usbControlTransferParams, int i, int i2, ControlTransferInResponse controlTransferInResponse);

    void controlTransferOut(UsbControlTransferParams usbControlTransferParams, byte[] bArr, int i, ControlTransferOutResponse controlTransferOutResponse);

    void genericTransferIn(byte b, int i, int i2, GenericTransferInResponse genericTransferInResponse);

    void genericTransferOut(byte b, byte[] bArr, int i, GenericTransferOutResponse genericTransferOutResponse);

    void isochronousTransferIn(byte b, int[] iArr, int i, IsochronousTransferInResponse isochronousTransferInResponse);

    void isochronousTransferOut(byte b, byte[] bArr, int[] iArr, int i, IsochronousTransferOutResponse isochronousTransferOutResponse);
}
