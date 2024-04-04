package org.chromium.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import org.chromium.base.SysUtils;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/Toast.class */
public class Toast {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    private static int sExtraYOffset;
    private android.widget.Toast mToast;
    private ViewGroup mSWLayout;

    public Toast(Context context) {
        this(context, UiWidgetFactory.getInstance().createToast(context));
    }

    private Toast(Context context, android.widget.Toast toast) {
        this.mToast = toast;
        if (SysUtils.isLowEndDevice() && Build.VERSION.SDK_INT >= 21) {
            this.mSWLayout = new FrameLayout(new ContextWrapper(context) { // from class: org.chromium.ui.widget.Toast.1
                @Override // android.content.ContextWrapper, android.content.Context
                public ApplicationInfo getApplicationInfo() {
                    ApplicationInfo info = new ApplicationInfo(super.getApplicationInfo());
                    info.targetSdkVersion = 19;
                    info.flags &= -536870913;
                    return info;
                }
            });
            setView(toast.getView());
        }
        this.mToast.setGravity(this.mToast.getGravity(), this.mToast.getXOffset(), this.mToast.getYOffset() + sExtraYOffset);
    }

    public android.widget.Toast getAndroidToast() {
        return this.mToast;
    }

    public void show() {
        this.mToast.show();
    }

    public void cancel() {
        this.mToast.cancel();
    }

    public void setView(View view) {
        if (this.mSWLayout != null) {
            this.mSWLayout.removeAllViews();
            if (view != null) {
                this.mSWLayout.addView(view, -2, -2);
                this.mToast.setView(this.mSWLayout);
                return;
            }
            this.mToast.setView(null);
            return;
        }
        this.mToast.setView(view);
    }

    public View getView() {
        if (this.mToast.getView() == null) {
            return null;
        }
        if (this.mSWLayout != null) {
            return this.mSWLayout.getChildAt(0);
        }
        return this.mToast.getView();
    }

    public void setDuration(int duration) {
        this.mToast.setDuration(duration);
    }

    public int getDuration() {
        return this.mToast.getDuration();
    }

    public void setMargin(float horizontalMargin, float verticalMargin) {
        this.mToast.setMargin(horizontalMargin, verticalMargin);
    }

    public float getHorizontalMargin() {
        return this.mToast.getHorizontalMargin();
    }

    public float getVerticalMargin() {
        return this.mToast.getVerticalMargin();
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        this.mToast.setGravity(gravity, xOffset, yOffset);
    }

    public int getGravity() {
        return this.mToast.getGravity();
    }

    public int getXOffset() {
        return this.mToast.getXOffset();
    }

    public int getYOffset() {
        return this.mToast.getYOffset();
    }

    public void setText(int resId) {
        this.mToast.setText(resId);
    }

    public void setText(CharSequence s) {
        this.mToast.setText(s);
    }

    @SuppressLint({"ShowToast"})
    public static Toast makeText(Context context, CharSequence text, int duration) {
        return new Toast(context, UiWidgetFactory.getInstance().makeToast(context, text, duration));
    }

    public static Toast makeText(Context context, int resId, int duration) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    public static void setGlobalExtraYOffset(int yOffsetPx) {
        sExtraYOffset = yOffsetPx;
    }
}
