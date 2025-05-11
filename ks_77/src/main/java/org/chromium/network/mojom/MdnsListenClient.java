package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient.class */
public interface MdnsListenClient extends Interface {
    public static final Interface.Manager<MdnsListenClient, Proxy> MANAGER = MdnsListenClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient$Proxy.class */
    public interface Proxy extends MdnsListenClient, Interface.Proxy {
    }

    void onAddressResult(int i, int i2, IpEndPoint ipEndPoint);

    void onTextResult(int i, int i2, String[] strArr);

    void onHostnameResult(int i, int i2, HostPortPair hostPortPair);

    void onUnhandledResult(int i, int i2);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient$UpdateType.class */
    public static final class UpdateType {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int ADDED = 0;
        public static final int CHANGED = 1;
        public static final int REMOVED = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private UpdateType() {
        }
    }
}
