package org.chromium.content_public.browser;

import android.annotation.TargetApi;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/InputMethodManagerWrapper.class */
public interface InputMethodManagerWrapper {
    void restartInput(View view);

    void showSoftInput(View view, int i, ResultReceiver resultReceiver);

    boolean isActive(View view);

    boolean hideSoftInputFromWindow(IBinder iBinder, int i, ResultReceiver resultReceiver);

    void updateSelection(View view, int i, int i2, int i3, int i4);

    @TargetApi(21)
    void updateCursorAnchorInfo(View view, CursorAnchorInfo cursorAnchorInfo);

    void updateExtractedText(View view, int i, ExtractedText extractedText);

    void notifyUserAction();
}
