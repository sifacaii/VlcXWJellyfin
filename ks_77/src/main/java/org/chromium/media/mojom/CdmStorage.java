package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmStorage.class */
public interface CdmStorage extends Interface {
    public static final Interface.Manager<CdmStorage, Proxy> MANAGER = CdmStorage_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmStorage$OpenResponse.class */
    public interface OpenResponse extends Callbacks.Callback2<Integer, AssociatedInterfaceNotSupported> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmStorage$Proxy.class */
    public interface Proxy extends CdmStorage, Interface.Proxy {
    }

    void open(String str, OpenResponse openResponse);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmStorage$Status.class */
    public static final class Status {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int SUCCESS = 0;
        public static final int IN_USE = 1;
        public static final int FAILURE = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
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
