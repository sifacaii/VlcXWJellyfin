package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/QuotaDispatcherHost.class */
public interface QuotaDispatcherHost extends Interface {
    public static final Interface.Manager<QuotaDispatcherHost, Proxy> MANAGER = QuotaDispatcherHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/QuotaDispatcherHost$Proxy.class */
    public interface Proxy extends QuotaDispatcherHost, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/QuotaDispatcherHost$QueryStorageUsageAndQuotaResponse.class */
    public interface QueryStorageUsageAndQuotaResponse extends Callbacks.Callback4<Integer, Long, Long, UsageBreakdown> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/QuotaDispatcherHost$RequestStorageQuotaResponse.class */
    public interface RequestStorageQuotaResponse extends Callbacks.Callback3<Integer, Long, Long> {
    }

    void queryStorageUsageAndQuota(Origin origin, int i, QueryStorageUsageAndQuotaResponse queryStorageUsageAndQuotaResponse);

    void requestStorageQuota(Origin origin, int i, long j, RequestStorageQuotaResponse requestStorageQuotaResponse);
}
