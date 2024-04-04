package org.chromium.network.mojom;

import org.chromium.content_settings.mojom.ContentSettingPatternSource;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager.class */
public interface CookieManager extends Interface {
    public static final Interface.Manager<CookieManager, Proxy> MANAGER = CookieManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager$AllowFileSchemeCookiesResponse.class */
    public interface AllowFileSchemeCookiesResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager$DeleteCanonicalCookieResponse.class */
    public interface DeleteCanonicalCookieResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager$DeleteCookiesResponse.class */
    public interface DeleteCookiesResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager$FlushCookieStoreResponse.class */
    public interface FlushCookieStoreResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager$GetAllCookiesResponse.class */
    public interface GetAllCookiesResponse extends Callbacks.Callback1<CanonicalCookie[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager$GetCookieListResponse.class */
    public interface GetCookieListResponse extends Callbacks.Callback2<CanonicalCookie[], CookieWithStatus[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager$Proxy.class */
    public interface Proxy extends CookieManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager$SetCanonicalCookieResponse.class */
    public interface SetCanonicalCookieResponse extends Callbacks.Callback1<Integer> {
    }

    void getAllCookies(GetAllCookiesResponse getAllCookiesResponse);

    void getCookieList(Url url, CookieOptions cookieOptions, GetCookieListResponse getCookieListResponse);

    void setCanonicalCookie(CanonicalCookie canonicalCookie, String str, CookieOptions cookieOptions, SetCanonicalCookieResponse setCanonicalCookieResponse);

    void deleteCanonicalCookie(CanonicalCookie canonicalCookie, DeleteCanonicalCookieResponse deleteCanonicalCookieResponse);

    void deleteCookies(CookieDeletionFilter cookieDeletionFilter, DeleteCookiesResponse deleteCookiesResponse);

    void addCookieChangeListener(Url url, String str, CookieChangeListener cookieChangeListener);

    void addGlobalChangeListener(CookieChangeListener cookieChangeListener);

    void cloneInterface(InterfaceRequest<CookieManager> interfaceRequest);

    void flushCookieStore(FlushCookieStoreResponse flushCookieStoreResponse);

    void allowFileSchemeCookies(boolean z, AllowFileSchemeCookiesResponse allowFileSchemeCookiesResponse);

    void setContentSettings(ContentSettingPatternSource[] contentSettingPatternSourceArr);

    void setForceKeepSessionState();

    void blockThirdPartyCookies(boolean z);
}
