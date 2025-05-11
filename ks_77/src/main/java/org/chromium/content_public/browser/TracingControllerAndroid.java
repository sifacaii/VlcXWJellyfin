package org.chromium.content_public.browser;

import android.content.Context;
import android.util.Pair;
import org.chromium.base.Callback;
import org.chromium.content.browser.TracingControllerAndroidImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/TracingControllerAndroid.class */
public interface TracingControllerAndroid {
    boolean isTracing();

    String getOutputPath();

    boolean startTracing(String str, boolean z, String str2, String str3, boolean z2);

    void stopTracing(Callback<Void> callback);

    boolean getKnownCategories(Callback<String[]> callback);

    boolean getTraceBufferUsage(Callback<Pair<Float, Long>> callback);

    void destroy();

    static TracingControllerAndroid create(Context context) {
        return new TracingControllerAndroidImpl(context);
    }
}
