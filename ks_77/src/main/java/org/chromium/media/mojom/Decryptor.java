package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Decryptor.class */
public interface Decryptor extends Interface {
    public static final Interface.Manager<Decryptor, Proxy> MANAGER = Decryptor_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Decryptor$DecryptAndDecodeAudioResponse.class */
    public interface DecryptAndDecodeAudioResponse extends Callbacks.Callback2<Integer, AudioBuffer[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Decryptor$DecryptAndDecodeVideoResponse.class */
    public interface DecryptAndDecodeVideoResponse extends Callbacks.Callback3<Integer, VideoFrame, FrameResourceReleaser> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Decryptor$DecryptResponse.class */
    public interface DecryptResponse extends Callbacks.Callback2<Integer, DecoderBuffer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Decryptor$InitializeAudioDecoderResponse.class */
    public interface InitializeAudioDecoderResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Decryptor$InitializeVideoDecoderResponse.class */
    public interface InitializeVideoDecoderResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Decryptor$Proxy.class */
    public interface Proxy extends Decryptor, Interface.Proxy {
    }

    void initialize(DataPipe.ConsumerHandle consumerHandle, DataPipe.ConsumerHandle consumerHandle2, DataPipe.ConsumerHandle consumerHandle3, DataPipe.ProducerHandle producerHandle);

    void decrypt(int i, DecoderBuffer decoderBuffer, DecryptResponse decryptResponse);

    void cancelDecrypt(int i);

    void initializeAudioDecoder(AudioDecoderConfig audioDecoderConfig, InitializeAudioDecoderResponse initializeAudioDecoderResponse);

    void initializeVideoDecoder(VideoDecoderConfig videoDecoderConfig, InitializeVideoDecoderResponse initializeVideoDecoderResponse);

    void decryptAndDecodeAudio(DecoderBuffer decoderBuffer, DecryptAndDecodeAudioResponse decryptAndDecodeAudioResponse);

    void decryptAndDecodeVideo(DecoderBuffer decoderBuffer, DecryptAndDecodeVideoResponse decryptAndDecodeVideoResponse);

    void resetDecoder(int i);

    void deinitializeDecoder(int i);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Decryptor$Status.class */
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Decryptor$StreamType.class */
    public static final class StreamType {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private StreamType() {
        }
    }
}
