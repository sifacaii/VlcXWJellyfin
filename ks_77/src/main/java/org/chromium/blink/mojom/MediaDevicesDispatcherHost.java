package org.chromium.blink.mojom;

import org.chromium.media.mojom.VideoCaptureFormat;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaDevicesDispatcherHost.class */
public interface MediaDevicesDispatcherHost extends Interface {
    public static final Interface.Manager<MediaDevicesDispatcherHost, Proxy> MANAGER = MediaDevicesDispatcherHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaDevicesDispatcherHost$EnumerateDevicesResponse.class */
    public interface EnumerateDevicesResponse extends Callbacks.Callback3<MediaDeviceInfo[][], VideoInputDeviceCapabilities[], AudioInputDeviceCapabilities[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaDevicesDispatcherHost$GetAllVideoInputDeviceFormatsResponse.class */
    public interface GetAllVideoInputDeviceFormatsResponse extends Callbacks.Callback1<VideoCaptureFormat[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaDevicesDispatcherHost$GetAudioInputCapabilitiesResponse.class */
    public interface GetAudioInputCapabilitiesResponse extends Callbacks.Callback1<AudioInputDeviceCapabilities[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaDevicesDispatcherHost$GetAvailableVideoInputDeviceFormatsResponse.class */
    public interface GetAvailableVideoInputDeviceFormatsResponse extends Callbacks.Callback1<VideoCaptureFormat[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaDevicesDispatcherHost$GetVideoInputCapabilitiesResponse.class */
    public interface GetVideoInputCapabilitiesResponse extends Callbacks.Callback1<VideoInputDeviceCapabilities[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaDevicesDispatcherHost$Proxy.class */
    public interface Proxy extends MediaDevicesDispatcherHost, Interface.Proxy {
    }

    void enumerateDevices(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, EnumerateDevicesResponse enumerateDevicesResponse);

    void getVideoInputCapabilities(GetVideoInputCapabilitiesResponse getVideoInputCapabilitiesResponse);

    void getAllVideoInputDeviceFormats(String str, GetAllVideoInputDeviceFormatsResponse getAllVideoInputDeviceFormatsResponse);

    void getAvailableVideoInputDeviceFormats(String str, GetAvailableVideoInputDeviceFormatsResponse getAvailableVideoInputDeviceFormatsResponse);

    void getAudioInputCapabilities(GetAudioInputCapabilitiesResponse getAudioInputCapabilitiesResponse);

    void addMediaDevicesListener(boolean z, boolean z2, boolean z3, MediaDevicesListener mediaDevicesListener);
}
