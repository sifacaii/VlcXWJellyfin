package org.chromium.content_public.browser;

import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.Map;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;
import org.chromium.content_public.common.ContentUrlConstants;
import org.chromium.content_public.common.Referrer;
import org.chromium.content_public.common.ResourceRequestBody;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/LoadUrlParams.class */
public class LoadUrlParams {
    String mUrl;
    String mInitiatorOrigin;
    int mLoadUrlType;
    int mTransitionType;
    Referrer mReferrer;
    private Map<String, String> mExtraHeaders;
    private String mVerbatimHeaders;
    int mUaOverrideOption;
    ResourceRequestBody mPostData;
    String mBaseUrlForDataUrl;
    String mVirtualUrlForDataUrl;
    String mDataUrlAsString;
    boolean mCanLoadLocalResources;
    boolean mIsRendererInitiated;
    boolean mShouldReplaceCurrentEntry;
    long mIntentReceivedTimestamp;
    long mInputStartTimestamp;
    boolean mHasUserGesture;
    boolean mShouldClearHistoryList;

    private static native boolean nativeIsDataScheme(String str);

    public LoadUrlParams(String url) {
        this(url, 0);
    }

    public LoadUrlParams(String url, int transitionType) {
        this.mUrl = url;
        this.mTransitionType = transitionType;
        this.mLoadUrlType = 0;
        this.mUaOverrideOption = 0;
        this.mPostData = null;
        this.mBaseUrlForDataUrl = null;
        this.mVirtualUrlForDataUrl = null;
        this.mDataUrlAsString = null;
    }

    public static LoadUrlParams createLoadDataParams(String data, String mimeType, boolean isBase64Encoded) {
        return createLoadDataParams(data, mimeType, isBase64Encoded, null);
    }

    public static LoadUrlParams createLoadDataParams(String data, String mimeType, boolean isBase64Encoded, String charset) {
        LoadUrlParams params = new LoadUrlParams(buildDataUri(data, mimeType, isBase64Encoded, charset));
        params.setLoadType(2);
        params.setTransitionType(1);
        return params;
    }

    private static String buildDataUri(String data, String mimeType, boolean isBase64Encoded, String charset) {
        StringBuilder dataUrl = new StringBuilder("data:");
        dataUrl.append(mimeType);
        if (charset != null && !charset.isEmpty()) {
            dataUrl.append(";charset=" + charset);
        }
        if (isBase64Encoded) {
            dataUrl.append(";base64");
        }
        dataUrl.append(",");
        dataUrl.append(data);
        return dataUrl.toString();
    }

    public static LoadUrlParams createLoadDataParamsWithBaseUrl(String data, String mimeType, boolean isBase64Encoded, String baseUrl, String historyUrl) {
        return createLoadDataParamsWithBaseUrl(data, mimeType, isBase64Encoded, baseUrl, historyUrl, null);
    }

    public static LoadUrlParams createLoadDataParamsWithBaseUrl(String data, String mimeType, boolean isBase64Encoded, String baseUrl, String historyUrl, String charset) {
        LoadUrlParams params;
        if (baseUrl == null || !baseUrl.toLowerCase(Locale.US).startsWith("data:")) {
            params = createLoadDataParams(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE, mimeType, isBase64Encoded, charset);
            params.setBaseUrlForDataUrl(baseUrl != null ? baseUrl : ContentUrlConstants.ABOUT_BLANK_DISPLAY_URL);
            params.setVirtualUrlForDataUrl(historyUrl != null ? historyUrl : ContentUrlConstants.ABOUT_BLANK_DISPLAY_URL);
            params.setDataUrlAsString(buildDataUri(data, mimeType, isBase64Encoded, charset));
        } else {
            params = createLoadDataParams(data, mimeType, isBase64Encoded, charset);
        }
        return params;
    }

    @VisibleForTesting
    public static LoadUrlParams createLoadHttpPostParams(String url, byte[] postData) {
        LoadUrlParams params = new LoadUrlParams(url);
        params.setLoadType(1);
        params.setTransitionType(1);
        params.setPostData(ResourceRequestBody.createFromBytes(postData));
        return params;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setInitiatorOrigin(String initiatorOrigin) {
        this.mInitiatorOrigin = initiatorOrigin;
    }

    @Nullable
    public String getInitiatorOrigin() {
        return this.mInitiatorOrigin;
    }

    public String getBaseUrl() {
        return this.mBaseUrlForDataUrl;
    }

    public void setLoadType(int loadType) {
        this.mLoadUrlType = loadType;
    }

    public void setTransitionType(int transitionType) {
        this.mTransitionType = transitionType;
    }

    public int getTransitionType() {
        return this.mTransitionType;
    }

    public void setReferrer(Referrer referrer) {
        this.mReferrer = referrer;
    }

    public Referrer getReferrer() {
        return this.mReferrer;
    }

    public void setExtraHeaders(Map<String, String> extraHeaders) {
        this.mExtraHeaders = extraHeaders;
    }

    public Map<String, String> getExtraHeaders() {
        return this.mExtraHeaders;
    }

    public String getExtraHeadersString() {
        return getExtraHeadersString("\n", false);
    }

    public String getExtraHttpRequestHeadersString() {
        return getExtraHeadersString("\r\n", true);
    }

    private String getExtraHeadersString(String delimiter, boolean addTerminator) {
        if (this.mExtraHeaders == null) {
            return null;
        }
        StringBuilder headerBuilder = new StringBuilder();
        for (Map.Entry<String, String> header : this.mExtraHeaders.entrySet()) {
            if (headerBuilder.length() > 0) {
                headerBuilder.append(delimiter);
            }
            headerBuilder.append(header.getKey().toLowerCase(Locale.US));
            headerBuilder.append(":");
            headerBuilder.append(header.getValue());
        }
        if (addTerminator) {
            headerBuilder.append(delimiter);
        }
        return headerBuilder.toString();
    }

    public void setVerbatimHeaders(String headers) {
        this.mVerbatimHeaders = headers;
    }

    public String getVerbatimHeaders() {
        return this.mVerbatimHeaders;
    }

    public void setOverrideUserAgent(int uaOption) {
        this.mUaOverrideOption = uaOption;
    }

    public int getUserAgentOverrideOption() {
        return this.mUaOverrideOption;
    }

    public void setPostData(ResourceRequestBody postData) {
        this.mPostData = postData;
    }

    public ResourceRequestBody getPostData() {
        return this.mPostData;
    }

    public void setBaseUrlForDataUrl(String baseUrl) {
        this.mBaseUrlForDataUrl = baseUrl;
    }

    public String getVirtualUrlForDataUrl() {
        return this.mVirtualUrlForDataUrl;
    }

    public void setVirtualUrlForDataUrl(String virtualUrl) {
        this.mVirtualUrlForDataUrl = virtualUrl;
    }

    public String getDataUrlAsString() {
        return this.mDataUrlAsString;
    }

    public void setDataUrlAsString(String url) {
        this.mDataUrlAsString = url;
    }

    public void setCanLoadLocalResources(boolean canLoad) {
        this.mCanLoadLocalResources = canLoad;
    }

    public boolean getCanLoadLocalResources() {
        return this.mCanLoadLocalResources;
    }

    public int getLoadUrlType() {
        return this.mLoadUrlType;
    }

    public void setIsRendererInitiated(boolean rendererInitiated) {
        this.mIsRendererInitiated = rendererInitiated;
    }

    public boolean getIsRendererInitiated() {
        return this.mIsRendererInitiated;
    }

    public void setShouldReplaceCurrentEntry(boolean shouldReplaceCurrentEntry) {
        this.mShouldReplaceCurrentEntry = shouldReplaceCurrentEntry;
    }

    public boolean getShouldReplaceCurrentEntry() {
        return this.mShouldReplaceCurrentEntry;
    }

    public void setIntentReceivedTimestamp(long intentReceivedTimestamp) {
        this.mIntentReceivedTimestamp = intentReceivedTimestamp;
    }

    public long getIntentReceivedTimestamp() {
        return this.mIntentReceivedTimestamp;
    }

    public void setInputStartTimestamp(long inputStartTimestamp) {
        this.mInputStartTimestamp = inputStartTimestamp;
    }

    public long getInputStartTimestamp() {
        return this.mInputStartTimestamp;
    }

    public void setHasUserGesture(boolean hasUserGesture) {
        this.mHasUserGesture = hasUserGesture;
    }

    public boolean getHasUserGesture() {
        return this.mHasUserGesture;
    }

    public void setShouldClearHistoryList(boolean shouldClearHistoryList) {
        this.mShouldClearHistoryList = shouldClearHistoryList;
    }

    public boolean getShouldClearHistoryList() {
        return this.mShouldClearHistoryList;
    }

    public boolean isBaseUrlDataScheme() {
        if (this.mBaseUrlForDataUrl == null && this.mLoadUrlType == 2) {
            return true;
        }
        return nativeIsDataScheme(this.mBaseUrlForDataUrl);
    }
}
