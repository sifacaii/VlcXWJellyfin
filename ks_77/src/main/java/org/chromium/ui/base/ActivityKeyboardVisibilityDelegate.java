package org.chromium.ui.base;

import android.app.Activity;
import androidx.annotation.Nullable;
import android.view.View;
import java.lang.ref.WeakReference;
import org.chromium.ui.KeyboardVisibilityDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/ActivityKeyboardVisibilityDelegate.class */
public class ActivityKeyboardVisibilityDelegate extends KeyboardVisibilityDelegate implements View.OnLayoutChangeListener {
    private boolean mIsKeyboardShowing;
    private WeakReference<Activity> mActivity;

    public ActivityKeyboardVisibilityDelegate(WeakReference<Activity> activity) {
        this.mActivity = activity;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity.get();
    }

    @Override // org.chromium.ui.KeyboardVisibilityDelegate
    public void registerKeyboardVisibilityCallbacks() {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        View content = activity.findViewById(16908290);
        this.mIsKeyboardShowing = isKeyboardShowing(activity, content);
        content.addOnLayoutChangeListener(this);
    }

    @Override // org.chromium.ui.KeyboardVisibilityDelegate
    public void unregisterKeyboardVisibilityCallbacks() {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.findViewById(16908290).removeOnLayoutChangeListener(this);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        boolean isShowing;
        Activity activity = getActivity();
        if (activity == null || this.mIsKeyboardShowing == (isShowing = isKeyboardShowing(activity, v))) {
            return;
        }
        this.mIsKeyboardShowing = isShowing;
        notifyListeners(isShowing);
    }
}
