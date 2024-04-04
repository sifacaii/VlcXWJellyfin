package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SmsReceiver.class */
public interface SmsReceiver extends Interface {
    public static final Interface.Manager<SmsReceiver, Proxy> MANAGER = SmsReceiver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SmsReceiver$Proxy.class */
    public interface Proxy extends SmsReceiver, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SmsReceiver$ReceiveResponse.class */
    public interface ReceiveResponse extends Callbacks.Callback2<Integer, String> {
    }

    void receive(TimeDelta timeDelta, ReceiveResponse receiveResponse);
}
