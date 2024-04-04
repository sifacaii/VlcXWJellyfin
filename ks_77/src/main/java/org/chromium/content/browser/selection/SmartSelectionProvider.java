package org.chromium.content.browser.selection;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.LocaleList;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.task.AsyncTask;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.ui.base.WindowAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SmartSelectionProvider.class */
public class SmartSelectionProvider {
    private static final String TAG = "SmartSelProvider";
    private SelectionClient.ResultCallback mResultCallback;
    private WindowAndroid mWindowAndroid;
    private ClassificationTask mClassificationTask;
    private TextClassifier mTextClassifier;
    private Handler mHandler = new Handler();
    private Runnable mFailureResponseRunnable = new Runnable() { // from class: org.chromium.content.browser.selection.SmartSelectionProvider.1
        @Override // java.lang.Runnable
        public void run() {
            SmartSelectionProvider.this.mResultCallback.onClassified(new SelectionClient.Result());
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SmartSelectionProvider$RequestType.class */
    private @interface RequestType {
        public static final int CLASSIFY = 0;
        public static final int SUGGEST_AND_CLASSIFY = 1;
    }

    public SmartSelectionProvider(SelectionClient.ResultCallback callback, WindowAndroid windowAndroid) {
        this.mResultCallback = callback;
        this.mWindowAndroid = windowAndroid;
    }

    public void sendSuggestAndClassifyRequest(CharSequence text, int start, int end) {
        sendSmartSelectionRequest(1, text, start, end);
    }

    public void sendClassifyRequest(CharSequence text, int start, int end) {
        sendSmartSelectionRequest(0, text, start, end);
    }

    public void cancelAllRequests() {
        if (this.mClassificationTask != null) {
            this.mClassificationTask.cancel(false);
            this.mClassificationTask = null;
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        this.mTextClassifier = textClassifier;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    public TextClassifier getTextClassifier() {
        if (this.mTextClassifier != null) {
            return this.mTextClassifier;
        }
        Context context = this.mWindowAndroid.getContext().get();
        if (context == null) {
            return null;
        }
        return ((TextClassificationManager) context.getSystemService("textclassification")).getTextClassifier();
    }

    public TextClassifier getCustomTextClassifier() {
        return this.mTextClassifier;
    }

    @TargetApi(26)
    private void sendSmartSelectionRequest(int requestType, CharSequence text, int start, int end) {
        TextClassifier classifier = getTextClassifier();
        if (classifier == null || classifier == TextClassifier.NO_OP) {
            this.mHandler.post(this.mFailureResponseRunnable);
            return;
        }
        if (this.mClassificationTask != null) {
            this.mClassificationTask.cancel(false);
            this.mClassificationTask = null;
        }
        this.mClassificationTask = new ClassificationTask(classifier, requestType, text, start, end);
        this.mClassificationTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SmartSelectionProvider$ClassificationTask.class */
    public class ClassificationTask extends AsyncTask<SelectionClient.Result> {
        private final TextClassifier mTextClassifier;
        private final int mRequestType;
        private final CharSequence mText;
        private final int mOriginalStart;
        private final int mOriginalEnd;

        ClassificationTask(TextClassifier classifier, int requestType, CharSequence text, int start, int end) {
            this.mTextClassifier = classifier;
            this.mRequestType = requestType;
            this.mText = text;
            this.mOriginalStart = start;
            this.mOriginalEnd = end;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.base.task.AsyncTask
        public SelectionClient.Result doInBackground() {
            int start = this.mOriginalStart;
            int end = this.mOriginalEnd;
            TextSelection textSelection = null;
            if (this.mRequestType == 1) {
                textSelection = this.mTextClassifier.suggestSelection(this.mText, start, end, LocaleList.getAdjustedDefault());
                start = Math.max(0, textSelection.getSelectionStartIndex());
                end = Math.min(this.mText.length(), textSelection.getSelectionEndIndex());
                if (isCancelled()) {
                    return new SelectionClient.Result();
                }
            }
            TextClassification tc = this.mTextClassifier.classifyText(this.mText, start, end, LocaleList.getAdjustedDefault());
            return makeResult(start, end, tc, textSelection);
        }

        private SelectionClient.Result makeResult(int start, int end, TextClassification tc, TextSelection ts) {
            SelectionClient.Result result = new SelectionClient.Result();
            result.startAdjust = start - this.mOriginalStart;
            result.endAdjust = end - this.mOriginalEnd;
            result.label = tc.getLabel();
            result.icon = tc.getIcon();
            result.intent = tc.getIntent();
            result.onClickListener = tc.getOnClickListener();
            result.textSelection = ts;
            result.textClassification = tc;
            return result;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.base.task.AsyncTask
        public void onPostExecute(SelectionClient.Result result) {
            SmartSelectionProvider.this.mResultCallback.onClassified(result);
        }
    }
}
