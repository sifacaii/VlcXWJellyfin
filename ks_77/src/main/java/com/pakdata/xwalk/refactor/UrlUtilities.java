package com.pakdata.xwalk.refactor;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.chromium.base.CollectionUtil;
import org.chromium.content_public.common.ContentUrlConstants;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/UrlUtilities.class */
public class UrlUtilities {
    private static final String TAG = "UrlUtilities";
    private static final HashSet<String> ACCEPTED_SCHEMES = CollectionUtil.newHashSet(ContentUrlConstants.ABOUT_SCHEME, AndroidProtocolHandler.APP_SCHEME, "content", "data", AndroidProtocolHandler.FILE_SCHEME, "http", "https", "javascript", "tenta");
    private static final HashSet<String> FALLBACK_VALID_SCHEMES = CollectionUtil.newHashSet("http", "https");

    public static boolean isValidForIntentFallbackNavigation(String uri) {
        try {
            return isValidForIntentFallbackNavigation(new URI(uri));
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static boolean isValidForIntentFallbackNavigation(URI uri) {
        return FALLBACK_VALID_SCHEMES.contains(uri.getScheme());
    }

    public static boolean isAcceptedScheme(URI uri) {
        return ACCEPTED_SCHEMES.contains(uri.getScheme());
    }

    public static boolean isAcceptedScheme(String uri) {
        try {
            return isAcceptedScheme(new URI(uri));
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static String safeGetStringExtra(Intent intent, String name) {
        try {
            return intent.getStringExtra(name);
        } catch (Throwable th) {
            Log.e(TAG, "getStringExtra failed on intent: " + intent);
            return null;
        }
    }

    public static List<ComponentName> getIntentHandlers(Context context, Intent intent) {
        List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent, 0);
        List<ComponentName> nameList = new ArrayList<>();
        for (ResolveInfo r : list) {
            nameList.add(new ComponentName(r.activityInfo.packageName, r.activityInfo.name));
        }
        return nameList;
    }

    public static boolean isSpecializedHandlerAvailable(Context context, Intent intent) {
        return isPackageSpecializedHandler(context, null, intent);
    }

    public static boolean isPackageSpecializedHandler(Context context, String packageName, Intent intent) {
        try {
            List<ResolveInfo> handlers = context.getPackageManager().queryIntentActivities(intent, 64);
            if (handlers == null || handlers.size() == 0) {
                return false;
            }
            for (ResolveInfo resolveInfo : handlers) {
                IntentFilter filter = resolveInfo.filter;
                if (filter != null && filter.countDataAuthorities() != 0 && filter.countDataPaths() != 0) {
                    if (TextUtils.isEmpty(packageName)) {
                        return true;
                    }
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(packageName)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (RuntimeException e) {
            Log.e(TAG, "isPackageSpecializedHandler e=" + e);
            return false;
        }
    }
}
