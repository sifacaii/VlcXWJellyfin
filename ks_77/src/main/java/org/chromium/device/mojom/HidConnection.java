package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidConnection.class */
public interface HidConnection extends Interface {
    public static final Interface.Manager<HidConnection, Proxy> MANAGER = HidConnection_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidConnection$GetFeatureReportResponse.class */
    public interface GetFeatureReportResponse extends Callbacks.Callback2<Boolean, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidConnection$Proxy.class */
    public interface Proxy extends HidConnection, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidConnection$ReadResponse.class */
    public interface ReadResponse extends Callbacks.Callback3<Boolean, Byte, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidConnection$SendFeatureReportResponse.class */
    public interface SendFeatureReportResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidConnection$WriteResponse.class */
    public interface WriteResponse extends Callbacks.Callback1<Boolean> {
    }

    void read(ReadResponse readResponse);

    void write(byte b, byte[] bArr, WriteResponse writeResponse);

    void getFeatureReport(byte b, GetFeatureReportResponse getFeatureReportResponse);

    void sendFeatureReport(byte b, byte[] bArr, SendFeatureReportResponse sendFeatureReportResponse);
}
