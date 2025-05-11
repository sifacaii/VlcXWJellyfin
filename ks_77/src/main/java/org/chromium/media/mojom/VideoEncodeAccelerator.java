package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.SharedBufferHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator.class */
public interface VideoEncodeAccelerator extends Interface {
    public static final Interface.Manager<VideoEncodeAccelerator, Proxy> MANAGER = VideoEncodeAccelerator_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator$EncodeResponse.class */
    public interface EncodeResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator$InitializeResponse.class */
    public interface InitializeResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator$Proxy.class */
    public interface Proxy extends VideoEncodeAccelerator, Interface.Proxy {
    }

    void initialize(VideoEncodeAcceleratorConfig videoEncodeAcceleratorConfig, VideoEncodeAcceleratorClient videoEncodeAcceleratorClient, InitializeResponse initializeResponse);

    void encode(VideoFrame videoFrame, boolean z, EncodeResponse encodeResponse);

    void useOutputBitstreamBuffer(int i, SharedBufferHandle sharedBufferHandle);

    void requestEncodingParametersChange(VideoBitrateAllocation videoBitrateAllocation, int i);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator$Error.class */
    public static final class Error {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int ILLEGAL_STATE = 0;
        public static final int INVALID_ARGUMENT = 1;
        public static final int PLATFORM_FAILURE = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Error() {
        }
    }
}
