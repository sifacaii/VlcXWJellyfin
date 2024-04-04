package org.chromium.content_public.browser;

import android.util.Pair;
import java.lang.annotation.Annotation;
import java.util.Map;
import org.chromium.content.browser.JavascriptInjectorImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/JavascriptInjector.class */
public interface JavascriptInjector {
    Map<String, Pair<Object, Class>> getInterfaces();

    void setAllowInspection(boolean z);

    void addPossiblyUnsafeInterface(Object obj, String str, Class<? extends Annotation> cls);

    void removeInterface(String str);

    static JavascriptInjector fromWebContents(WebContents webContents) {
        return JavascriptInjectorImpl.fromWebContents(webContents);
    }
}
