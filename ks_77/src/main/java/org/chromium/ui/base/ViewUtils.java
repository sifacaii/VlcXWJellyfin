package org.chromium.ui.base;

import android.view.View;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/ViewUtils.class */
public final class ViewUtils {
    private ViewUtils() {
    }

    public static boolean hasFocus(View view) {
        if (isFocusable(view)) {
            return view.hasFocus();
        }
        return true;
    }

    public static void requestFocus(View view) {
        if (!isFocusable(view) || view.isFocused()) {
            return;
        }
        view.requestFocus();
    }

    private static boolean isFocusable(View view) {
        return view.isInTouchMode() ? view.isFocusableInTouchMode() : view.isFocusable();
    }
}
