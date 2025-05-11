package org.chromium.content.browser.input;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.os.StrictMode;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.content_public.browser.InputMethodManagerWrapper;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/InputMethodManagerWrapperImpl.class */
public class InputMethodManagerWrapperImpl implements InputMethodManagerWrapper {
    private static final boolean DEBUG_LOGS = false;
    private static final String TAG = "cr_IMM";
    private final Context mContext;

    public InputMethodManagerWrapperImpl(Context context) {
        this.mContext = context;
    }

    private InputMethodManager getInputMethodManager() {
        return (InputMethodManager) this.mContext.getSystemService("input_method");
    }

    @Override // org.chromium.content_public.browser.InputMethodManagerWrapper
    public void restartInput(View view) {
        InputMethodManager manager = getInputMethodManager();
        if (manager == null) {
            return;
        }
        manager.restartInput(view);
    }

    @Override // org.chromium.content_public.browser.InputMethodManagerWrapper
    public void showSoftInput(View view, int flags, ResultReceiver resultReceiver) {
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();
        try {
            InputMethodManager manager = getInputMethodManager();
            if (manager != null) {
                manager.showSoftInput(view, flags, resultReceiver);
            }
        } finally {
            StrictMode.setThreadPolicy(oldPolicy);
        }
    }

    @Override // org.chromium.content_public.browser.InputMethodManagerWrapper
    public boolean isActive(View view) {
        InputMethodManager manager = getInputMethodManager();
        boolean active = manager != null && manager.isActive(view);
        return active;
    }

    @Override // org.chromium.content_public.browser.InputMethodManagerWrapper
    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags, ResultReceiver resultReceiver) {
        boolean z;
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();
        try {
            InputMethodManager manager = getInputMethodManager();
            if (manager != null) {
                if (manager.hideSoftInputFromWindow(windowToken, flags, resultReceiver)) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            StrictMode.setThreadPolicy(oldPolicy);
        }
    }

    @Override // org.chromium.content_public.browser.InputMethodManagerWrapper
    public void updateSelection(View view, int selStart, int selEnd, int candidatesStart, int candidatesEnd) {
        InputMethodManager manager = getInputMethodManager();
        if (manager == null) {
            return;
        }
        manager.updateSelection(view, selStart, selEnd, candidatesStart, candidatesEnd);
    }

    @Override // org.chromium.content_public.browser.InputMethodManagerWrapper
    public void updateCursorAnchorInfo(View view, CursorAnchorInfo cursorAnchorInfo) {
        InputMethodManager manager;
        if (Build.VERSION.SDK_INT < 21 || (manager = getInputMethodManager()) == null) {
            return;
        }
        manager.updateCursorAnchorInfo(view, cursorAnchorInfo);
    }

    @Override // org.chromium.content_public.browser.InputMethodManagerWrapper
    public void updateExtractedText(View view, int token, ExtractedText text) {
        InputMethodManager manager = getInputMethodManager();
        if (manager == null) {
            return;
        }
        manager.updateExtractedText(view, token, text);
    }

    @Override // org.chromium.content_public.browser.InputMethodManagerWrapper
    public void notifyUserAction() {
        InputMethodManager manager;
        if (Build.VERSION.SDK_INT <= 23 && (manager = getInputMethodManager()) != null) {
            try {
                Method method = InputMethodManager.class.getMethod("notifyUserAction", new Class[0]);
                method.invoke(manager, new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            }
        }
    }
}
