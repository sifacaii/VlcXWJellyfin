package org.chromium.content.browser.input;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import org.chromium.base.VisibleForTesting;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ChromiumBaseInputConnection.class */
public interface ChromiumBaseInputConnection extends InputConnection {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ChromiumBaseInputConnection$Factory.class */
    public interface Factory {
        ChromiumBaseInputConnection initializeAndGet(View view, ImeAdapterImpl imeAdapterImpl, int i, int i2, int i3, int i4, int i5, int i6, EditorInfo editorInfo);

        @VisibleForTesting
        Handler getHandler();

        void onWindowFocusChanged(boolean z);

        void onViewFocusChanged(boolean z);

        void onViewAttachedToWindow();

        void onViewDetachedFromWindow();

        void setTriggerDelayedOnCreateInputConnection(boolean z);
    }

    void updateStateOnUiThread(String str, int i, int i2, int i3, int i4, boolean z, boolean z2);

    boolean sendKeyEventOnUiThread(KeyEvent keyEvent);

    void onRestartInputOnUiThread();

    @Override // android.view.inputmethod.InputConnection
    @VisibleForTesting
    Handler getHandler();

    void unblockOnUiThread();
}
