package org.chromium.content_public.browser;

import android.content.Intent;
import android.view.ActionMode;
import android.view.textclassifier.TextClassifier;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content_public.browser.SelectionClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/SelectionPopupController.class */
public interface SelectionPopupController {
    void setActionModeCallback(ActionMode.Callback callback);

    void setNonSelectionActionModeCallback(ActionMode.Callback callback);

    SelectionClient.ResultCallback getResultCallback();

    String getSelectedText();

    boolean isFocusedNodeEditable();

    boolean hasSelection();

    void destroySelectActionMode();

    boolean isSelectActionBarShowing();

    ActionModeCallbackHelper getActionModeCallbackHelper();

    void clearSelection();

    void onReceivedProcessTextResult(int i, Intent intent);

    void setSelectionClient(SelectionClient selectionClient);

    void setTextClassifier(TextClassifier textClassifier);

    TextClassifier getTextClassifier();

    TextClassifier getCustomTextClassifier();

    void setPreserveSelectionOnNextLossOfFocus(boolean z);

    void updateTextSelectionUI(boolean z);

    static SelectionPopupController fromWebContents(WebContents webContents) {
        return SelectionPopupControllerImpl.fromWebContents(webContents);
    }

    static void setShouldGetReadbackViewFromWindowAndroid() {
        SelectionPopupControllerImpl.setShouldGetReadbackViewFromWindowAndroid();
    }
}
