package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmFile.class */
public interface CdmFile extends Interface {
    public static final Interface.Manager<CdmFile, Proxy> MANAGER = CdmFile_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmFile$Proxy.class */
    public interface Proxy extends CdmFile, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmFile$ReadResponse.class */
    public interface ReadResponse extends Callbacks.Callback2<Integer, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmFile$WriteResponse.class */
    public interface WriteResponse extends Callbacks.Callback1<Integer> {
    }

    void read(ReadResponse readResponse);

    void write(byte[] bArr, WriteResponse writeResponse);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmFile$Status.class */
    public static final class Status {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int SUCCESS = 0;
        public static final int FAILURE = 1;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 1;
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
