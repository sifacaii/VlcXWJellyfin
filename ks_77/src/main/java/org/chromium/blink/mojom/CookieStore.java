package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CookieStore.class */
public interface CookieStore extends Interface {
    public static final Interface.Manager<CookieStore, Proxy> MANAGER = CookieStore_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CookieStore$AppendSubscriptionsResponse.class */
    public interface AppendSubscriptionsResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CookieStore$GetSubscriptionsResponse.class */
    public interface GetSubscriptionsResponse extends Callbacks.Callback2<CookieChangeSubscription[], Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CookieStore$Proxy.class */
    public interface Proxy extends CookieStore, Interface.Proxy {
    }

    void appendSubscriptions(long j, CookieChangeSubscription[] cookieChangeSubscriptionArr, AppendSubscriptionsResponse appendSubscriptionsResponse);

    void getSubscriptions(long j, GetSubscriptionsResponse getSubscriptionsResponse);
}
