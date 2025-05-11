package com.pakdata.xwalk.refactor;

import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkCookieManager.class */
public class XWalkCookieManager {
    private static final String TAG = "XWalkCookieManager";

    private native void nativeSetAcceptCookie(boolean z);

    private native boolean nativeAcceptCookie();

    private native void nativeSetCookie(String str, String str2);

    private native String nativeGetCookie(String str);

    private native void nativeRemoveSessionCookie();

    private native void nativeRemoveAllCookie();

    private native void nativeRemoveExpiredCookie();

    private native void nativeFlushCookieStore();

    private native boolean nativeHasCookies();

    private native boolean nativeAllowFileSchemeCookies();

    private native void nativeSetAcceptFileSchemeCookies(boolean z);

    private native byte[] nativeSaveCookies();

    private native boolean nativeRestoreCookies(byte[] bArr);

    private native void nativeSetDbKey(String str);

    private native int nativeRekeyDb(String str, String str2);

    private native void nativeSetZone(String str);

    private native int nativeNukeDomain(String str);

    private native void nativePageLoadStarted(String str);

    private native void nativeReset();

    public byte[] saveCookies() {
        return nativeSaveCookies();
    }

    public boolean restoreCookies(byte[] cookies) {
        return nativeRestoreCookies(cookies);
    }

    public void setAcceptCookie(boolean accept) {
        nativeSetAcceptCookie(accept);
    }

    public boolean acceptCookie() {
        return nativeAcceptCookie();
    }

    public void setCookie(String url, String value) {
        try {
            nativeSetCookie(new URL(url).toString(), value);
        } catch (MalformedURLException e) {
            Log.e(TAG, "Not setting cookie due to invalid URL", e);
        }
    }

    public String getCookie(String url) {
        try {
            String cookie = nativeGetCookie(new URL(url).toString());
            if (cookie != null) {
                if (!cookie.trim().isEmpty()) {
                    return cookie;
                }
            }
            return null;
        } catch (MalformedURLException e) {
            Log.e(TAG, "Unable to get cookies due to invalid URL", e);
            return null;
        }
    }

    public void removeSessionCookie() {
        nativeRemoveSessionCookie();
    }

    public void removeAllCookie() {
        nativeRemoveAllCookie();
    }

    public boolean hasCookies() {
        return nativeHasCookies();
    }

    public void removeExpiredCookie() {
        nativeRemoveExpiredCookie();
    }

    public void flushCookieStore() {
        nativeFlushCookieStore();
    }

    public boolean allowFileSchemeCookies() {
        return nativeAllowFileSchemeCookies();
    }

    public void setAcceptFileSchemeCookies(boolean accept) {
        nativeSetAcceptFileSchemeCookies(accept);
    }

    public void setDbKey(String dbKey) {
        nativeSetDbKey(dbKey);
    }

    public int rekeyDb(String oldKey, String newKey) {
        return nativeRekeyDb(oldKey, newKey);
    }

    public void setZone(String zone) {
        nativeSetZone(zone);
    }

    public int nukeDomain(String domain) {
        return nativeNukeDomain(domain);
    }

    public void pageLoadStarted(String url) {
        nativePageLoadStarted(url);
    }

    public void reset() {
        nativeReset();
    }
}
