package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioOutputStreamObserver.class */
public interface AudioOutputStreamObserver extends Interface {
    public static final Interface.Manager<AudioOutputStreamObserver, Proxy> MANAGER = AudioOutputStreamObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioOutputStreamObserver$Proxy.class */
    public interface Proxy extends AudioOutputStreamObserver, Interface.Proxy {
    }

    void didStartPlaying();

    void didStopPlaying();

    void didChangeAudibleState(boolean z);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioOutputStreamObserver$DisconnectReason.class */
    public static final class DisconnectReason {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int DEFAULT = 0;
        public static final int PLATFORM_ERROR = 1;
        public static final int TERMINATED_BY_CLIENT = 2;
        public static final int STREAM_CREATION_FAILED = 3;
        public static final int DOCUMENT_DESTROYED = 4;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 4;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private DisconnectReason() {
        }
    }
}
