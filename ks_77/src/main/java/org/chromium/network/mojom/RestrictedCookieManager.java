package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager.class */
public interface RestrictedCookieManager extends Interface {
    public static final Interface.Manager<RestrictedCookieManager, Proxy> MANAGER = RestrictedCookieManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager$AddChangeListenerResponse.class */
    public interface AddChangeListenerResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager$CookiesEnabledForResponse.class */
    public interface CookiesEnabledForResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager$GetAllForUrlResponse.class */
    public interface GetAllForUrlResponse extends Callbacks.Callback1<CanonicalCookie[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager$GetCookiesStringResponse.class */
    public interface GetCookiesStringResponse extends Callbacks.Callback1<String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager$Proxy.class */
    public interface Proxy extends RestrictedCookieManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager$SetCanonicalCookieResponse.class */
    public interface SetCanonicalCookieResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager$SetCookieFromStringResponse.class */
    public interface SetCookieFromStringResponse extends Callbacks.Callback0 {
    }

    void getAllForUrl(Url url, Url url2, CookieManagerGetOptions cookieManagerGetOptions, GetAllForUrlResponse getAllForUrlResponse);

    void setCanonicalCookie(CanonicalCookie canonicalCookie, Url url, Url url2, SetCanonicalCookieResponse setCanonicalCookieResponse);

    void addChangeListener(Url url, Url url2, CookieChangeListener cookieChangeListener, AddChangeListenerResponse addChangeListenerResponse);

    void setCookieFromString(Url url, Url url2, String str, SetCookieFromStringResponse setCookieFromStringResponse);

    void getCookiesString(Url url, Url url2, GetCookiesStringResponse getCookiesStringResponse);

    void cookiesEnabledFor(Url url, Url url2, CookiesEnabledForResponse cookiesEnabledForResponse);
}
