package org.chromium.content_public.browser;

import android.view.KeyEvent;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ImeEventObserver.class */
public interface ImeEventObserver {
    default void onImeEvent() {
    }

    default void onNodeAttributeUpdated(boolean editable, boolean password) {
    }

    default void onBeforeSendKeyEvent(KeyEvent event) {
    }
}
