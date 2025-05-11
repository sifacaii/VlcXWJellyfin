package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost.class */
public interface VideoCaptureHost extends Interface {
    public static final Interface.Manager<VideoCaptureHost, Proxy> MANAGER = VideoCaptureHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost$GetDeviceFormatsInUseResponse.class */
    public interface GetDeviceFormatsInUseResponse extends Callbacks.Callback1<VideoCaptureFormat[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost$GetDeviceSupportedFormatsResponse.class */
    public interface GetDeviceSupportedFormatsResponse extends Callbacks.Callback1<VideoCaptureFormat[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost$Proxy.class */
    public interface Proxy extends VideoCaptureHost, Interface.Proxy {
    }

    void start(int i, int i2, VideoCaptureParams videoCaptureParams, VideoCaptureObserver videoCaptureObserver);

    void stop(int i);

    void pause(int i);

    void resume(int i, int i2, VideoCaptureParams videoCaptureParams);

    void requestRefreshFrame(int i);

    void releaseBuffer(int i, int i2, double d);

    void getDeviceSupportedFormats(int i, int i2, GetDeviceSupportedFormatsResponse getDeviceSupportedFormatsResponse);

    void getDeviceFormatsInUse(int i, int i2, GetDeviceFormatsInUseResponse getDeviceFormatsInUseResponse);

    void onFrameDropped(int i, int i2);

    void onLog(int i, String str);
}
