package org.chromium.content_public.browser;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import org.chromium.content.browser.selection.SmartSelectionClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/SelectionClient.class */
public interface SelectionClient {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/SelectionClient$ResultCallback.class */
    public interface ResultCallback {
        void onClassified(Result result);
    }

    void onSelectionChanged(String str);

    void onSelectionEvent(int i, float f, float f2);

    void selectWordAroundCaretAck(boolean z, int i, int i2);

    boolean requestSelectionPopupUpdates(boolean z);

    void cancelAllRequests();

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/SelectionClient$Result.class */
    public static class Result {
        public int startAdjust;
        public int endAdjust;
        public CharSequence label;
        public Drawable icon;
        public Intent intent;
        public View.OnClickListener onClickListener;
        public TextClassification textClassification;
        public TextSelection textSelection;

        public boolean hasNamedAction() {
            return ((this.label == null && this.icon == null) || (this.intent == null && this.onClickListener == null)) ? false : true;
        }
    }

    default SelectionMetricsLogger getSelectionMetricsLogger() {
        return null;
    }

    default void setTextClassifier(TextClassifier textClassifier) {
    }

    default TextClassifier getTextClassifier() {
        return null;
    }

    default TextClassifier getCustomTextClassifier() {
        return null;
    }

    static SelectionClient createSmartSelectionClient(WebContents webContents) {
        ResultCallback callback = SelectionPopupController.fromWebContents(webContents).getResultCallback();
        return SmartSelectionClient.create(callback, webContents);
    }
}
