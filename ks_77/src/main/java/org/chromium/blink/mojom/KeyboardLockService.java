package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/KeyboardLockService.class */
public interface KeyboardLockService extends Interface {
    public static final Interface.Manager<KeyboardLockService, Proxy> MANAGER = KeyboardLockService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/KeyboardLockService$GetKeyboardLayoutMapResponse.class */
    public interface GetKeyboardLayoutMapResponse extends Callbacks.Callback1<GetKeyboardLayoutMapResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/KeyboardLockService$Proxy.class */
    public interface Proxy extends KeyboardLockService, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/KeyboardLockService$RequestKeyboardLockResponse.class */
    public interface RequestKeyboardLockResponse extends Callbacks.Callback1<Integer> {
    }

    void requestKeyboardLock(String[] strArr, RequestKeyboardLockResponse requestKeyboardLockResponse);

    void cancelKeyboardLock();

    void getKeyboardLayoutMap(GetKeyboardLayoutMapResponse getKeyboardLayoutMapResponse);
}
