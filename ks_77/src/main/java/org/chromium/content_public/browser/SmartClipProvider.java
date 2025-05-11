package org.chromium.content_public.browser;

import android.os.Handler;
import org.chromium.base.annotations.UsedByReflection;

@UsedByReflection("ExternalOemSupport")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/SmartClipProvider.class */
public interface SmartClipProvider {
    @UsedByReflection("ExternalOemSupport")
    void extractSmartClipData(int i, int i2, int i3, int i4);

    @UsedByReflection("ExternalOemSupport")
    void setSmartClipResultHandler(Handler handler);
}
