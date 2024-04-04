package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy.class */
public interface CdmProxy extends Interface {
    public static final Interface.Manager<CdmProxy, Proxy> MANAGER = CdmProxy_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$CreateMediaCryptoSessionResponse.class */
    public interface CreateMediaCryptoSessionResponse extends Callbacks.Callback3<Integer, Integer, Long> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$InitializeResponse.class */
    public interface InitializeResponse extends Callbacks.Callback4<Integer, Integer, Integer, Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$ProcessResponse.class */
    public interface ProcessResponse extends Callbacks.Callback2<Integer, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$Proxy.class */
    public interface Proxy extends CdmProxy, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$RemoveKeyResponse.class */
    public interface RemoveKeyResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$SetKeyResponse.class */
    public interface SetKeyResponse extends Callbacks.Callback1<Integer> {
    }

    void initialize(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, InitializeResponse initializeResponse);

    void process(int i, int i2, byte[] bArr, int i3, ProcessResponse processResponse);

    void createMediaCryptoSession(byte[] bArr, CreateMediaCryptoSessionResponse createMediaCryptoSessionResponse);

    void setKey(int i, byte[] bArr, int i2, byte[] bArr2, SetKeyResponse setKeyResponse);

    void removeKey(int i, byte[] bArr, RemoveKeyResponse removeKeyResponse);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$Status.class */
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$Protocol.class */
    public static final class Protocol {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Protocol() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$Function.class */
    public static final class Function {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Function() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxy$KeyType.class */
    public static final class KeyType {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private KeyType() {
        }
    }
}
