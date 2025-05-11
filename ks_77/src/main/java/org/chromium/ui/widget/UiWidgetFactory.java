package org.chromium.ui.widget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.PopupWindow;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/UiWidgetFactory.class */
public class UiWidgetFactory {
    private static UiWidgetFactory sFactory;

    protected UiWidgetFactory() {
    }

    public static UiWidgetFactory getInstance() {
        if (sFactory == null) {
            sFactory = new UiWidgetFactory();
        }
        return sFactory;
    }

    public static void setInstance(UiWidgetFactory widgetFactory) {
        sFactory = widgetFactory;
    }

    public PopupWindow createPopupWindow(Context context) {
        return new PopupWindow(context);
    }

    public AlertDialog createAlertDialog(Context context) {
        return new AlertDialog.Builder(context).create();
    }

    @SuppressLint({"ShowToast"})
    public android.widget.Toast createToast(Context context) {
        return new android.widget.Toast(context);
    }

    @SuppressLint({"ShowToast"})
    public android.widget.Toast makeToast(Context context, CharSequence text, int duration) {
        return android.widget.Toast.makeText(context, text, duration);
    }
}
