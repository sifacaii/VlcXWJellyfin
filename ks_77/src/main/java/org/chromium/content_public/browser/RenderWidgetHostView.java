package org.chromium.content_public.browser;

import org.chromium.base.Callback;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/RenderWidgetHostView.class */
public interface RenderWidgetHostView {
    boolean isReady();

    int getBackgroundColor();

    void writeContentBitmapToDiskAsync(int i, int i2, String str, Callback<String> callback);

    void insetViewportBottom(int i);
}
