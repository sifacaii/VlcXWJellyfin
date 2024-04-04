package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamDispatcherHost.class */
public interface MediaStreamDispatcherHost extends Interface {
    public static final Interface.Manager<MediaStreamDispatcherHost, Proxy> MANAGER = MediaStreamDispatcherHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamDispatcherHost$GenerateStreamResponse.class */
    public interface GenerateStreamResponse extends Callbacks.Callback4<Integer, String, MediaStreamDevice[], MediaStreamDevice[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamDispatcherHost$OpenDeviceResponse.class */
    public interface OpenDeviceResponse extends Callbacks.Callback3<Boolean, String, MediaStreamDevice> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamDispatcherHost$Proxy.class */
    public interface Proxy extends MediaStreamDispatcherHost, Interface.Proxy {
    }

    void generateStream(int i, StreamControls streamControls, boolean z, GenerateStreamResponse generateStreamResponse);

    void cancelRequest(int i);

    void stopStreamDevice(String str, int i);

    void openDevice(int i, String str, int i2, OpenDeviceResponse openDeviceResponse);

    void closeDevice(String str);

    void setCapturingLinkSecured(int i, int i2, boolean z);

    void onStreamStarted(String str);
}
