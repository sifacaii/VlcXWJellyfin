package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification.class */
public interface PlatformVerification extends Interface {
    public static final Interface.Manager<PlatformVerification, Proxy> MANAGER = PlatformVerification_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification$ChallengePlatformResponse.class */
    public interface ChallengePlatformResponse extends Callbacks.Callback4<Boolean, String, String, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification$GetStorageIdResponse.class */
    public interface GetStorageIdResponse extends Callbacks.Callback2<Integer, byte[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification$Proxy.class */
    public interface Proxy extends PlatformVerification, Interface.Proxy {
    }

    void challengePlatform(String str, String str2, ChallengePlatformResponse challengePlatformResponse);

    void getStorageId(int i, GetStorageIdResponse getStorageIdResponse);
}
