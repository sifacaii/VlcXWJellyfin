package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushMessaging.class */
public interface PushMessaging extends Interface {
    public static final Interface.Manager<PushMessaging, Proxy> MANAGER = PushMessaging_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushMessaging$GetSubscriptionResponse.class */
    public interface GetSubscriptionResponse extends Callbacks.Callback2<Integer, PushSubscription> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushMessaging$Proxy.class */
    public interface Proxy extends PushMessaging, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushMessaging$SubscribeResponse.class */
    public interface SubscribeResponse extends Callbacks.Callback2<Integer, PushSubscription> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushMessaging$UnsubscribeResponse.class */
    public interface UnsubscribeResponse extends Callbacks.Callback3<Integer, Boolean, String> {
    }

    void subscribe(long j, PushSubscriptionOptions pushSubscriptionOptions, boolean z, SubscribeResponse subscribeResponse);

    void unsubscribe(long j, UnsubscribeResponse unsubscribeResponse);

    void getSubscription(long j, GetSubscriptionResponse getSubscriptionResponse);
}
