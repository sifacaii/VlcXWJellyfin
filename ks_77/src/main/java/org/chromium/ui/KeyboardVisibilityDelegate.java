package org.chromium.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.base.Log;
import org.chromium.base.ObserverList;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/KeyboardVisibilityDelegate.class */
public class KeyboardVisibilityDelegate {
    private static final String TAG = "KeyboardVisibility";
    private static final int KEYBOARD_RETRY_ATTEMPTS = 10;
    private static final long KEYBOARD_RETRY_DELAY_MS = 100;
    private static final float KEYBOARD_DETECT_BOTTOM_THRESHOLD_DP = 100.0f;
    private static KeyboardVisibilityDelegate sInstance = new KeyboardVisibilityDelegate();
    private final ObserverList<KeyboardVisibilityListener> mKeyboardVisibilityListeners = new ObserverList<>();

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/KeyboardVisibilityDelegate$KeyboardVisibilityListener.class */
    public interface KeyboardVisibilityListener {
        void keyboardVisibilityChanged(boolean z);
    }

    protected void registerKeyboardVisibilityCallbacks() {
    }

    protected void unregisterKeyboardVisibilityCallbacks() {
    }

    public static void setInstance(KeyboardVisibilityDelegate delegate) {
        sInstance = delegate;
    }

    public static KeyboardVisibilityDelegate getInstance() {
        return sInstance;
    }

    @SuppressLint({"NewApi"})
    public void showKeyboard(final View view) {
        final Handler handler = new Handler();
        final AtomicInteger attempt = new AtomicInteger();
        Runnable openRunnable = new Runnable() { // from class: org.chromium.ui.KeyboardVisibilityDelegate.1
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService("input_method");
                StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();
                try {
                    try {
                        imm.showSoftInput(view, 0);
                        StrictMode.setThreadPolicy(oldPolicy);
                    } catch (IllegalArgumentException e) {
                        if (attempt.incrementAndGet() <= 10) {
                            handler.postDelayed(this, KeyboardVisibilityDelegate.KEYBOARD_RETRY_DELAY_MS);
                        } else {
                            Log.e(KeyboardVisibilityDelegate.TAG, "Unable to open keyboard.  Giving up.", e);
                        }
                        StrictMode.setThreadPolicy(oldPolicy);
                    }
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(oldPolicy);
                    throw th;
                }
            }
        };
        openRunnable.run();
    }

    public boolean hideKeyboard(View view) {
        return hideAndroidSoftKeyboard(view);
    }

    protected boolean hideAndroidSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService("input_method");
        return imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public int calculateKeyboardHeight(View rootView) {
        WindowInsets insets;
        Rect appRect = new Rect();
        rootView.getWindowVisibleDisplayFrame(appRect);
        int statusBarHeight = appRect.top;
        int bottomMargin = rootView.getHeight() - (appRect.height() + statusBarHeight);
        if (bottomMargin <= 0) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 23 && (insets = rootView.getRootWindowInsets()) != null) {
            bottomMargin -= insets.getStableInsetBottom();
        }
        return bottomMargin;
    }

    protected int calculateKeyboardDetectionThreshold(Context context, View rootView) {
        Rect appRect = new Rect();
        rootView.getWindowVisibleDisplayFrame(appRect);
        boolean navControlsOnSide = appRect.width() != rootView.getWidth();
        if (navControlsOnSide || Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (KEYBOARD_DETECT_BOTTOM_THRESHOLD_DP * density);
    }

    public boolean isKeyboardShowing(Context context, View view) {
        return isAndroidSoftKeyboardShowing(context, view);
    }

    protected boolean isAndroidSoftKeyboardShowing(Context context, View view) {
        View rootView = view.getRootView();
        return rootView != null && calculateKeyboardHeight(rootView) > calculateKeyboardDetectionThreshold(context, rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyListeners(boolean isShowing) {
        Iterator<KeyboardVisibilityListener> it = this.mKeyboardVisibilityListeners.iterator();
        while (it.hasNext()) {
            KeyboardVisibilityListener listener = it.next();
            listener.keyboardVisibilityChanged(isShowing);
        }
    }

    public void addKeyboardVisibilityListener(KeyboardVisibilityListener listener) {
        if (this.mKeyboardVisibilityListeners.isEmpty()) {
            registerKeyboardVisibilityCallbacks();
        }
        this.mKeyboardVisibilityListeners.addObserver(listener);
    }

    public void removeKeyboardVisibilityListener(KeyboardVisibilityListener listener) {
        this.mKeyboardVisibilityListeners.removeObserver(listener);
        if (this.mKeyboardVisibilityListeners.isEmpty()) {
            unregisterKeyboardVisibilityCallbacks();
        }
    }
}
