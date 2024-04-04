package com.pakdata.xwalk.refactor;

import android.util.Log;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkWebResourceResponse.class */
public class XWalkWebResourceResponse {
    private String mMimeType;
    private String mEncoding;
    private InputStream mData;
    private int mStatusCode;
    private String mReasonPhrase;
    private Map<String, String> mResponseHeaders;
    private String[] mResponseHeaderNames;
    private String[] mResponseHeaderValues;
    private CountDownLatch mReadyLatch;
    private boolean mReady;

    /* JADX INFO: Access modifiers changed from: package-private */
    public XWalkWebResourceResponse() {
        this.mMimeType = null;
        this.mEncoding = null;
        this.mData = null;
        this.mReadyLatch = new CountDownLatch(1);
        this.mReady = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XWalkWebResourceResponse(String mimeType, String encoding, InputStream data) {
        this.mMimeType = mimeType;
        this.mEncoding = encoding;
        setData(data);
        this.mReady = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XWalkWebResourceResponse(String mimeType, String encoding, InputStream data, int statusCode, String reasonPhrase, Map<String, String> responseHeaders) {
        this(mimeType, encoding, data);
        this.mStatusCode = statusCode;
        this.mReasonPhrase = reasonPhrase;
        this.mResponseHeaders = responseHeaders;
    }

    private void waitUntilReady() {
        Log.i("XWalkWebResponseInternal.waitUntilReady()", "Called [" + String.valueOf(Thread.currentThread().getId()) + "][" + Thread.currentThread().getName() + "]");
        if (!this.mReady && this.mReadyLatch != null) {
            Log.d("XWalkWebResourceResponse", "Waiting to be ready");
            try {
                this.mReadyLatch.await();
            } catch (InterruptedException e) {
                Log.w("XWalkWebResourceResponse", "oho Interrupted while waiting to be ready", e);
            }
        }
    }

    public void ready() {
        Log.i("XWalkWebResponseInternal.ready()", "Called [" + String.valueOf(Thread.currentThread().getId()) + "][" + Thread.currentThread().getName() + "]");
        if (!this.mReady) {
            if (this.mReadyLatch != null) {
                Log.d("XWalkWebResourceResponse", "Notified ready");
                this.mReadyLatch.countDown();
                this.mReady = true;
                return;
            }
            Log.w("XWalkWebResourceResponse", "Tried to notify ready, but no latch available");
        }
    }

    private void fillInResponseHeaderNamesAndValuesIfNeeded() {
        if (this.mResponseHeaders == null || this.mResponseHeaderNames != null) {
            return;
        }
        this.mResponseHeaderNames = new String[this.mResponseHeaders.size()];
        this.mResponseHeaderValues = new String[this.mResponseHeaders.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : this.mResponseHeaders.entrySet()) {
            this.mResponseHeaderNames[i] = entry.getKey();
            this.mResponseHeaderValues[i] = entry.getValue();
            i++;
        }
    }

    public void setMimeType(String mimeType) {
        this.mMimeType = mimeType;
    }

    public String getMimeType() {
        waitUntilReady();
        return this.mMimeType;
    }

    @CalledByNative
    public String getMimeTypeNative() {
        waitUntilReady();
        return this.mMimeType;
    }

    public void setEncoding(String encoding) {
        this.mEncoding = encoding;
    }

    public String getEncoding() {
        waitUntilReady();
        return this.mEncoding;
    }

    @CalledByNative
    public String getEncodingNative() {
        waitUntilReady();
        return this.mEncoding;
    }

    public void setData(InputStream data) {
        if (data != null && StringBufferInputStream.class.isAssignableFrom(data.getClass())) {
            throw new IllegalArgumentException("StringBufferInputStream is deprecated and must not be passed to a XWalkWebResourceResponse");
        }
        this.mData = data;
    }

    public InputStream getData() {
        waitUntilReady();
        return this.mData;
    }

    @CalledByNative
    public InputStream getDataNative() {
        waitUntilReady();
        return this.mData;
    }

    public void setStatusCodeAndReasonPhrase(int statusCode, String reasonPhrase) {
        if (statusCode < 100) {
            throw new IllegalArgumentException("statusCode can't be less than 100.");
        }
        if (statusCode > 599) {
            throw new IllegalArgumentException("statusCode can't be greater than 599.");
        }
        if (statusCode > 299 && statusCode < 400) {
            throw new IllegalArgumentException("statusCode can't be in the [300, 399] range.");
        }
        if (reasonPhrase == null) {
            throw new IllegalArgumentException("reasonPhrase can't be null.");
        }
        if (reasonPhrase.trim().isEmpty()) {
            throw new IllegalArgumentException("reasonPhrase can't be empty.");
        }
        for (int i = 0; i < reasonPhrase.length(); i++) {
            int c = reasonPhrase.charAt(i);
            if (c > 127) {
                throw new IllegalArgumentException("reasonPhrase can't contain non-ASCII characters.");
            }
        }
        this.mStatusCode = statusCode;
        this.mReasonPhrase = reasonPhrase;
    }

    public int getStatusCode() {
        waitUntilReady();
        return this.mStatusCode;
    }

    @CalledByNative
    public int getStatusCodeNative() {
        waitUntilReady();
        return this.mStatusCode;
    }

    public String getReasonPhrase() {
        waitUntilReady();
        return this.mReasonPhrase;
    }

    @CalledByNative
    public String getReasonPhraseNative() {
        waitUntilReady();
        return this.mReasonPhrase;
    }

    public void setResponseHeaders(Map<String, String> headers) {
        this.mResponseHeaders = headers;
    }

    public Map<String, String> getResponseHeaders() {
        waitUntilReady();
        return this.mResponseHeaders;
    }

    @CalledByNative
    private String[] getResponseHeaderNames() {
        waitUntilReady();
        fillInResponseHeaderNamesAndValuesIfNeeded();
        return this.mResponseHeaderNames;
    }

    @CalledByNative
    private String[] getResponseHeaderValues() {
        waitUntilReady();
        fillInResponseHeaderNamesAndValuesIfNeeded();
        return this.mResponseHeaderValues;
    }
}
