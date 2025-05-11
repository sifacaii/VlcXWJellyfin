package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection.class */
public interface OutputProtection extends Interface {
    public static final Interface.Manager<OutputProtection, Proxy> MANAGER = OutputProtection_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection$EnableProtectionResponse.class */
    public interface EnableProtectionResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection$Proxy.class */
    public interface Proxy extends OutputProtection, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection$QueryStatusResponse.class */
    public interface QueryStatusResponse extends Callbacks.Callback3<Boolean, Integer, Integer> {
    }

    void queryStatus(QueryStatusResponse queryStatusResponse);

    void enableProtection(int i, EnableProtectionResponse enableProtectionResponse);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection$ProtectionType.class */
    public static final class ProtectionType {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int NONE = 0;
        public static final int HDCP = 1;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 1;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private ProtectionType() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection$LinkType.class */
    public static final class LinkType {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int NONE = 0;
        public static final int UNKNOWN = 1;
        public static final int INTERNAL = 2;
        public static final int VGA = 4;
        public static final int HDMI = 8;
        public static final int DVI = 16;
        public static final int DISPLAYPORT = 32;
        public static final int NETWORK = 64;

        public static boolean isKnownValue(int value) {
            switch (value) {
                case 0:
                case 1:
                case 2:
                case 4:
                case 8:
                case 16:
                case 32:
                case 64:
                    return true;
                default:
                    return false;
            }
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private LinkType() {
        }
    }
}
