package org.chromium.content.browser;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.View;
import org.chromium.base.annotations.DoNotInline;
import org.chromium.content.browser.selection.FloatingActionModeCallback;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;

@DoNotInline
@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ContentApiHelperForM.class */
public final class ContentApiHelperForM {
    private ContentApiHelperForM() {
    }

    public static ActionMode startActionMode(View view, SelectionPopupControllerImpl selectionPopupController, ActionMode.Callback callback) {
        return view.startActionMode(new FloatingActionModeCallback(selectionPopupController, callback), 1);
    }
}
