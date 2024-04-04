package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient.class */
public interface NetworkServiceClient extends Interface {
    public static final Interface.Manager<NetworkServiceClient, Proxy> MANAGER = NetworkServiceClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient$OnFileUploadRequestedResponse.class */
    public interface OnFileUploadRequestedResponse extends Callbacks.Callback2<Integer, File[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient$OnGenerateHttpNegotiateAuthTokenResponse.class */
    public interface OnGenerateHttpNegotiateAuthTokenResponse extends Callbacks.Callback2<Integer, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient$OnLoadingStateUpdateResponse.class */
    public interface OnLoadingStateUpdateResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient$OnSslCertificateErrorResponse.class */
    public interface OnSslCertificateErrorResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient$Proxy.class */
    public interface Proxy extends NetworkServiceClient, Interface.Proxy {
    }

    void onAuthRequired(UnguessableToken unguessableToken, int i, int i2, int i3, Url url, boolean z, AuthChallengeInfo authChallengeInfo, UrlResponseHead urlResponseHead, AuthChallengeResponder authChallengeResponder);

    void onCertificateRequested(UnguessableToken unguessableToken, int i, int i2, int i3, SslCertRequestInfo sslCertRequestInfo, ClientCertificateResponder clientCertificateResponder);

    void onSslCertificateError(int i, int i2, Url url, int i3, SslInfo sslInfo, boolean z, OnSslCertificateErrorResponse onSslCertificateErrorResponse);

    void onFileUploadRequested(int i, boolean z, FilePath[] filePathArr, OnFileUploadRequestedResponse onFileUploadRequestedResponse);

    void onLoadingStateUpdate(LoadInfo[] loadInfoArr, OnLoadingStateUpdateResponse onLoadingStateUpdateResponse);

    void onDataUseUpdate(int i, long j, long j2);

    void onGenerateHttpNegotiateAuthToken(String str, boolean z, String str2, String str3, OnGenerateHttpNegotiateAuthTokenResponse onGenerateHttpNegotiateAuthTokenResponse);

    void onRawRequest(int i, int i2, String str, CookieWithStatus[] cookieWithStatusArr, HttpRawHeaderPair[] httpRawHeaderPairArr);

    void onRawResponse(int i, int i2, String str, CookieAndLineWithStatus[] cookieAndLineWithStatusArr, HttpRawHeaderPair[] httpRawHeaderPairArr, String str2);
}
