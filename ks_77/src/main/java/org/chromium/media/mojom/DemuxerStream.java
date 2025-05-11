package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream.class */
public interface DemuxerStream extends Interface {
    public static final Interface.Manager<DemuxerStream, Proxy> MANAGER = DemuxerStream_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream$InitializeResponse.class */
    public interface InitializeResponse extends Callbacks.Callback4<Integer, DataPipe.ConsumerHandle, AudioDecoderConfig, VideoDecoderConfig> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream$Proxy.class */
    public interface Proxy extends DemuxerStream, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream$ReadResponse.class */
    public interface ReadResponse extends Callbacks.Callback4<Integer, DecoderBuffer, AudioDecoderConfig, VideoDecoderConfig> {
    }

    void initialize(InitializeResponse initializeResponse);

    void read(ReadResponse readResponse);

    void enableBitstreamConverter();

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream$Type.class */
    public static final class Type {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Type() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream$Status.class */
    public static final class Status {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Status() {
        }
    }
}
