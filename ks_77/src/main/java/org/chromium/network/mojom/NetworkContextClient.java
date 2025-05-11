package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient.class */
public interface NetworkContextClient extends Interface {
    public static final Interface.Manager<NetworkContextClient, Proxy> MANAGER = NetworkContextClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient$OnCanSendDomainReliabilityUploadResponse.class */
    public interface OnCanSendDomainReliabilityUploadResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient$OnCanSendReportingReportsResponse.class */
    public interface OnCanSendReportingReportsResponse extends Callbacks.Callback1<Origin[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient$OnClearSiteDataResponse.class */
    public interface OnClearSiteDataResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient$Proxy.class */
    public interface Proxy extends NetworkContextClient, Interface.Proxy {
    }

    void onCanSendReportingReports(Origin[] originArr, OnCanSendReportingReportsResponse onCanSendReportingReportsResponse);

    void onCanSendDomainReliabilityUpload(Url url, OnCanSendDomainReliabilityUploadResponse onCanSendDomainReliabilityUploadResponse);

    void onClearSiteData(int i, int i2, Url url, String str, int i3, OnClearSiteDataResponse onClearSiteDataResponse);

    void onCookiesChanged(boolean z, int i, int i2, Url url, Url url2, CookieWithStatus[] cookieWithStatusArr);

    void onCookiesRead(boolean z, int i, int i2, Url url, Url url2, CookieWithStatus[] cookieWithStatusArr);
}
