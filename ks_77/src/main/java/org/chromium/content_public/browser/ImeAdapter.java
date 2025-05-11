package org.chromium.content_public.browser;

import android.content.Context;
import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import org.chromium.base.VisibleForTesting;
import org.chromium.content.browser.input.ImeAdapterImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ImeAdapter.class */
public interface ImeAdapter {
    @VisibleForTesting
    public static final int COMPOSITION_KEY_CODE = 229;

    InputConnection getActiveInputConnection();

    void addEventObserver(ImeEventObserver imeEventObserver);

    InputConnection onCreateInputConnection(EditorInfo editorInfo);

    boolean onCheckIsTextEditor();

    void setInputMethodManagerWrapper(InputMethodManagerWrapper inputMethodManagerWrapper);

    void advanceFocusInForm(int i);

    @VisibleForTesting
    ResultReceiver getNewShowKeyboardReceiver();

    @VisibleForTesting
    InputConnection getInputConnectionForTest();

    @VisibleForTesting
    void setComposingTextForTest(CharSequence charSequence, int i);

    static ImeAdapter fromWebContents(WebContents webContents) {
        return ImeAdapterImpl.fromWebContents(webContents);
    }

    static InputMethodManagerWrapper createDefaultInputMethodManagerWrapper(Context context) {
        return ImeAdapterImpl.createDefaultInputMethodManagerWrapper(context);
    }
}
