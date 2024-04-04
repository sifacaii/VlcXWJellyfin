package com.pakdata.xwalk.refactor;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.net.URI;
import java.util.List;
import org.chromium.components.navigation_interception.NavigationParams;
import org.chromium.ui.base.PageTransition;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkNavigationHandlerImpl.class */
public class XWalkNavigationHandlerImpl implements XWalkNavigationHandler {
    private static final String TAG = "XWalkNavigationHandlerImpl";
    private static final String PROTOCOL_WTAI_PREFIX = "wtai://";
    private static final String PROTOCOL_WTAI_MC_PREFIX = "wtai://wp/mc;";
    private static final String ACTION_TEL_PREFIX = "tel:";
    private static final String ACTION_SMS_PREFIX = "sms:";
    private static final String ACTION_MAIL_PREFIX = "mailto:";
    private static final String ACTION_GEO_PREFIX = "geo:";
    private static final String ACTION_MARKET_PREFIX = "market:";
    private static final String ACTION_INTENT_PREFIX = "intent:";
    private Context mContext;
    public static final String EXTRA_BROWSER_FALLBACK_URL = "browser_fallback_url";
    private String mFallbackUrl;

    public XWalkNavigationHandlerImpl(Context context) {
        this.mContext = context;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkNavigationHandler
    public boolean handleNavigation(NavigationParams params) {
        Intent intent;
        String url = params.url;
        if (UrlUtilities.isAcceptedScheme(url)) {
            return false;
        }
        if (url.startsWith(PROTOCOL_WTAI_PREFIX)) {
            intent = createIntentForWTAI(url);
        } else {
            intent = createIntentForActionUri(url);
        }
        if (intent == null && shouldOverrideUrlLoadingInternal(params)) {
            return true;
        }
        if (intent == null || !startActivity(intent)) {
            return handleUrlByMimeType(url);
        }
        return true;
    }

    protected boolean startActivity(Intent intent) {
        try {
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(PageTransition.CHAIN_START);
            }
            this.mContext.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Log.w(TAG, "Activity not found for Intent:");
            Log.w(TAG, intent.toUri(0));
            return false;
        }
    }

    private Intent createIntentForWTAI(String url) {
        Intent intent = null;
        if (url.startsWith(PROTOCOL_WTAI_MC_PREFIX)) {
            String number = url.substring(PROTOCOL_WTAI_MC_PREFIX.length());
            String mcUrl = ACTION_TEL_PREFIX + number;
            intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse(mcUrl));
        }
        return intent;
    }

    private Intent createIntentForActionUri(String url) {
        String address;
        Intent intent = null;
        if (url.startsWith(ACTION_TEL_PREFIX)) {
            intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse(url));
        } else if (url.startsWith(ACTION_GEO_PREFIX)) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
        } else if (url.startsWith(ACTION_MAIL_PREFIX)) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
        } else if (url.startsWith(ACTION_SMS_PREFIX)) {
            intent = new Intent("android.intent.action.VIEW");
            int parmIndex = url.indexOf(63);
            if (parmIndex == -1) {
                address = url.substring(4);
            } else {
                address = url.substring(4, parmIndex);
                Uri uri = Uri.parse(url);
                String query = uri.getQuery();
                if (query != null && query.startsWith("body=")) {
                    intent.putExtra("sms_body", query.substring(5));
                }
            }
            intent.putExtra("address", address);
            intent.setDataAndType(Uri.parse(ACTION_SMS_PREFIX + address), "vnd.android-dir/mms-sms");
        } else if (url.startsWith(ACTION_MARKET_PREFIX)) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
        }
        return intent;
    }

    private boolean handleUrlByMimeType(String url) {
        MimeTypeMap map = MimeTypeMap.getSingleton();
        String extenstion = MimeTypeMap.getFileExtensionFromUrl(url);
        String mimeType = map.getMimeTypeFromExtension(extenstion);
        if (shouldHandleMimeType(mimeType)) {
            Intent sendIntent = new Intent();
            sendIntent.setAction("android.intent.action.VIEW");
            sendIntent.setDataAndType(Uri.parse(url), mimeType);
            if (sendIntent.resolveActivity(this.mContext.getPackageManager()) != null) {
                startActivity(sendIntent);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean shouldHandleMimeType(String mimeType) {
        if (mimeType == null || !mimeType.startsWith("application/") || mimeType.equals("application/xhtml+xml") || mimeType.equals("application/xml")) {
            return false;
        }
        return true;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkNavigationHandler
    public String getFallbackUrl() {
        return this.mFallbackUrl;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkNavigationHandler
    public void resetFallbackUrl() {
        this.mFallbackUrl = null;
    }

    private boolean shouldOverrideUrlLoadingInternal(NavigationParams params) {
        URI currentUri;
        URI previousUri;
        Intent previousIntent;
        Intent selector;
        String url = params.url;
        try {
            Intent intent = Intent.parseUri(url, 1);
            int pageTransitionCore = params.pageTransitionType & 255;
            boolean isLink = pageTransitionCore == 0;
            boolean isFormSubmit = pageTransitionCore == 7;
            boolean isFromIntent = (params.pageTransitionType & PageTransition.FROM_API) != 0;
            boolean isForwardBackNavigation = (params.pageTransitionType & 16777216) != 0;
            boolean isExternalProtocol = !UrlUtilities.isAcceptedScheme(url);
            boolean isTyped = pageTransitionCore == 1;
            boolean typedRedirectToExternalProtocol = isTyped && params.isRedirect && isExternalProtocol;
            boolean hasBrowserFallbackUrl = false;
            String browserFallbackUrl = UrlUtilities.safeGetStringExtra(intent, EXTRA_BROWSER_FALLBACK_URL);
            if (browserFallbackUrl != null && UrlUtilities.isValidForIntentFallbackNavigation(browserFallbackUrl)) {
                hasBrowserFallbackUrl = true;
            } else {
                browserFallbackUrl = null;
            }
            if (isForwardBackNavigation) {
                return false;
            }
            boolean linkNotFromIntent = isLink && !isFromIntent;
            boolean incomingIntentRedirect = isLink && isFromIntent && params.isRedirect;
            boolean isRedirectFromFormSubmit = isFormSubmit && params.isRedirect;
            if ((!typedRedirectToExternalProtocol && !linkNotFromIntent && !incomingIntentRedirect && !isRedirectFromFormSubmit) || url.matches(".*youtube\\.com.*[?&]pairingCode=.*")) {
                return false;
            }
            List<ComponentName> resolvingComponentNames = UrlUtilities.getIntentHandlers(this.mContext, intent);
            boolean canResolveActivity = resolvingComponentNames.size() > 0;
            if (!canResolveActivity) {
                if (hasBrowserFallbackUrl) {
                    this.mFallbackUrl = browserFallbackUrl;
                    return false;
                }
                String packagename = intent.getPackage();
                if (packagename != null) {
                    try {
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packagename + "&referrer=" + this.mContext.getPackageName()));
                        intent2.addCategory("android.intent.category.BROWSABLE");
                        intent2.setPackage("com.android.vending");
                        intent2.addFlags(PageTransition.CHAIN_START);
                        this.mContext.startActivity(intent2);
                        return true;
                    } catch (ActivityNotFoundException e) {
                        return false;
                    }
                }
                return false;
            }
            if (hasBrowserFallbackUrl) {
                intent.removeExtra(EXTRA_BROWSER_FALLBACK_URL);
            }
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            if (Build.VERSION.SDK_INT >= 15 && (selector = intent.getSelector()) != null) {
                selector.addCategory("android.intent.category.BROWSABLE");
                selector.setComponent(null);
            }
            intent.putExtra("com.android.browser.application_id", this.mContext.getPackageName());
            intent.addFlags(PageTransition.CHAIN_START);
            if (!isExternalProtocol) {
                if (!UrlUtilities.isSpecializedHandlerAvailable(this.mContext, intent)) {
                    return false;
                }
                if (params.referrer != null && (isLink || isFormSubmit)) {
                    try {
                        currentUri = new URI(url);
                        previousUri = new URI(params.referrer);
                    } catch (Exception e2) {
                        currentUri = null;
                        previousUri = null;
                    }
                    if (currentUri != null && previousUri != null && TextUtils.equals(currentUri.getHost(), previousUri.getHost())) {
                        try {
                            previousIntent = Intent.parseUri(params.referrer, 1);
                        } catch (Exception e3) {
                            previousIntent = null;
                        }
                        if (previousIntent != null) {
                            List<ComponentName> currentHandlers = UrlUtilities.getIntentHandlers(this.mContext, intent);
                            List<ComponentName> previousHandlers = UrlUtilities.getIntentHandlers(this.mContext, previousIntent);
                            if (previousHandlers.containsAll(currentHandlers)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return intent != null && startActivity(intent);
        } catch (Exception ex) {
            Log.w(TAG, "Bad URI=" + url + " ex=" + ex);
            return false;
        }
    }
}
