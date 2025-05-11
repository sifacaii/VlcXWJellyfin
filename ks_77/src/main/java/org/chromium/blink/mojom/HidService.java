package org.chromium.blink.mojom;

import org.chromium.device.mojom.HidConnection;
import org.chromium.device.mojom.HidConnectionClient;
import org.chromium.device.mojom.HidDeviceInfo;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/HidService.class */
public interface HidService extends Interface {
    public static final Interface.Manager<HidService, Proxy> MANAGER = HidService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/HidService$ConnectResponse.class */
    public interface ConnectResponse extends Callbacks.Callback1<HidConnection> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/HidService$GetDevicesResponse.class */
    public interface GetDevicesResponse extends Callbacks.Callback1<HidDeviceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/HidService$Proxy.class */
    public interface Proxy extends HidService, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/HidService$RequestDeviceResponse.class */
    public interface RequestDeviceResponse extends Callbacks.Callback1<HidDeviceInfo> {
    }

    void getDevices(GetDevicesResponse getDevicesResponse);

    void requestDevice(HidDeviceFilter[] hidDeviceFilterArr, RequestDeviceResponse requestDeviceResponse);

    void connect(String str, HidConnectionClient hidConnectionClient, ConnectResponse connectResponse);
}
