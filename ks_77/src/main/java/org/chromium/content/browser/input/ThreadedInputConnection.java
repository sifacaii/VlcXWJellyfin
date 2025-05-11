package org.chromium.content.browser.input;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.task.PostTask;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;
import org.chromium.content_public.browser.UiThreadTaskTraits;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ThreadedInputConnection.class */
public class ThreadedInputConnection extends BaseInputConnection implements ChromiumBaseInputConnection {
    private static final String TAG = "cr_Ime";
    private static final boolean DEBUG_LOGS = false;
    private static final TextInputState UNBLOCKER = new TextInputState(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE, new Range(0, 0), new Range(-1, -1), false, false) { // from class: org.chromium.content.browser.input.ThreadedInputConnection.1
        @Override // org.chromium.content.browser.input.TextInputState
        public boolean shouldUnblock() {
            return true;
        }
    };
    private final Runnable mProcessPendingInputStatesRunnable;
    private final Runnable mRequestTextInputStateUpdate;
    private final Runnable mNotifyUserActionRunnable;
    private final Runnable mFinishComposingTextRunnable;
    private final ImeAdapterImpl mImeAdapter;
    private final Handler mHandler;
    private int mNumNestedBatchEdits;
    private final BlockingQueue<TextInputState> mQueue;
    private int mPendingAccent;
    private TextInputState mCachedTextInputState;
    private int mCurrentExtractedTextRequestToken;
    private boolean mShouldUpdateExtractedText;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadedInputConnection(View view, ImeAdapterImpl imeAdapter, Handler handler) {
        super(view, true);
        this.mProcessPendingInputStatesRunnable = new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.2
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.processPendingInputStates();
            }
        };
        this.mRequestTextInputStateUpdate = new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.3
            @Override // java.lang.Runnable
            public void run() {
                boolean result = ThreadedInputConnection.this.mImeAdapter.requestTextInputStateUpdate();
                if (!result) {
                    ThreadedInputConnection.this.unblockOnUiThread();
                }
            }
        };
        this.mNotifyUserActionRunnable = new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.4
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.mImeAdapter.notifyUserAction();
            }
        };
        this.mFinishComposingTextRunnable = new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.5
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.finishComposingTextOnUiThread();
            }
        };
        this.mQueue = new LinkedBlockingQueue();
        ImeUtils.checkOnUiThread();
        this.mImeAdapter = imeAdapter;
        this.mHandler = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetOnUiThread() {
        ImeUtils.checkOnUiThread();
        this.mHandler.post(new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.6
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.mNumNestedBatchEdits = 0;
                ThreadedInputConnection.this.mPendingAccent = 0;
                ThreadedInputConnection.this.mCurrentExtractedTextRequestToken = 0;
                ThreadedInputConnection.this.mShouldUpdateExtractedText = false;
            }
        });
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection
    public void updateStateOnUiThread(String text, int selectionStart, int selectionEnd, int compositionStart, int compositionEnd, boolean singleLine, boolean replyToRequest) {
        ImeUtils.checkOnUiThread();
        this.mCachedTextInputState = new TextInputState(text, new Range(selectionStart, selectionEnd), new Range(compositionStart, compositionEnd), singleLine, replyToRequest);
        addToQueueOnUiThread(this.mCachedTextInputState);
        if (!replyToRequest) {
            this.mHandler.post(this.mProcessPendingInputStatesRunnable);
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection, org.chromium.content.browser.input.ChromiumBaseInputConnection
    public Handler getHandler() {
        return this.mHandler;
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection
    public void onRestartInputOnUiThread() {
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection
    public boolean sendKeyEventOnUiThread(final KeyEvent event) {
        ImeUtils.checkOnUiThread();
        this.mHandler.post(new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.7
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.sendKeyEvent(event);
            }
        });
        return true;
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection
    @VisibleForTesting
    public void unblockOnUiThread() {
        ImeUtils.checkOnUiThread();
        addToQueueOnUiThread(UNBLOCKER);
        this.mHandler.post(this.mProcessPendingInputStatesRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPendingInputStates() {
        assertOnImeThread();
        while (true) {
            TextInputState state = this.mQueue.poll();
            if (state == null) {
                return;
            }
            if (!state.shouldUnblock()) {
                updateSelection(state);
            }
        }
    }

    private void updateSelection(TextInputState textInputState) {
        if (textInputState == null) {
            return;
        }
        assertOnImeThread();
        if (this.mNumNestedBatchEdits != 0) {
            return;
        }
        Range selection = textInputState.selection();
        Range composition = textInputState.composition();
        if (this.mShouldUpdateExtractedText) {
            ExtractedText extractedText = convertToExtractedText(textInputState);
            this.mImeAdapter.updateExtractedText(this.mCurrentExtractedTextRequestToken, extractedText);
        }
        this.mImeAdapter.updateSelection(selection.start(), selection.end(), composition.start(), composition.end());
    }

    private TextInputState requestAndWaitForTextInputState() {
        if (runningOnUiThread()) {
            Log.w(TAG, "InputConnection API is not called on IME thread. Returning cached result.", new Object[0]);
            return this.mCachedTextInputState;
        }
        assertOnImeThread();
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, this.mRequestTextInputStateUpdate);
        return blockAndGetStateUpdate();
    }

    private void addToQueueOnUiThread(TextInputState textInputState) {
        ImeUtils.checkOnUiThread();
        try {
            this.mQueue.put(textInputState);
        } catch (InterruptedException e) {
            Log.e(TAG, "addToQueueOnUiThread interrupted", e);
        }
    }

    BlockingQueue<TextInputState> getQueueForTest() {
        return this.mQueue;
    }

    @VisibleForTesting
    protected boolean runningOnUiThread() {
        return ThreadUtils.runningOnUiThread();
    }

    private void assertOnImeThread() {
        ImeUtils.checkCondition(this.mHandler.getLooper() == Looper.myLooper());
    }

    private TextInputState blockAndGetStateUpdate() {
        assertOnImeThread();
        boolean z = false;
        while (true) {
            try {
                boolean shouldUpdateSelection = z;
                TextInputState state = this.mQueue.take();
                if (state.shouldUnblock()) {
                    return null;
                }
                if (state.replyToRequest()) {
                    if (shouldUpdateSelection) {
                        updateSelection(state);
                    }
                    return state;
                }
                z = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
                ImeUtils.checkCondition(false);
                return null;
            }
        }
    }

    private void notifyUserAction() {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, this.mNotifyUserActionRunnable);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        if (text == null) {
            return false;
        }
        return updateComposingText(text, newCursorPosition, false);
    }

    @VisibleForTesting
    public boolean updateComposingText(final CharSequence text, final int newCursorPosition, final boolean isPendingAccent) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.8
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.updateComposingTextOnUiThread(text, newCursorPosition, isPendingAccent);
            }
        });
        notifyUserAction();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateComposingTextOnUiThread(CharSequence text, int newCursorPosition, boolean isPendingAccent) {
        int accentToSend = isPendingAccent ? this.mPendingAccent | Integer.MIN_VALUE : 0;
        cancelCombiningAccentOnUiThread();
        this.mImeAdapter.sendCompositionToNative(text, newCursorPosition, false, accentToSend);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(final CharSequence text, final int newCursorPosition) {
        if (text == null) {
            return false;
        }
        if (TextUtils.equals(text, "\n")) {
            beginBatchEdit();
            commitText(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE, 1);
            PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.9
                @Override // java.lang.Runnable
                public void run() {
                    ThreadedInputConnection.this.mImeAdapter.sendSyntheticKeyPress(66, 6);
                }
            });
            endBatchEdit();
            return true;
        }
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.10
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.commitTextOnUiThread(text, newCursorPosition);
            }
        });
        notifyUserAction();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitTextOnUiThread(CharSequence text, int newCursorPosition) {
        cancelCombiningAccentOnUiThread();
        this.mImeAdapter.sendCompositionToNative(text, newCursorPosition, true, 0);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(final int actionCode) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.11
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.mImeAdapter.performEditorAction(actionCode);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(final int id) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.12
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.mImeAdapter.performContextMenuAction(id);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        assertOnImeThread();
        this.mShouldUpdateExtractedText = (flags & 1) > 0;
        if (this.mShouldUpdateExtractedText) {
            this.mCurrentExtractedTextRequestToken = request != null ? request.token : 0;
        }
        TextInputState textInputState = requestAndWaitForTextInputState();
        return convertToExtractedText(textInputState);
    }

    private ExtractedText convertToExtractedText(TextInputState textInputState) {
        if (textInputState == null) {
            return null;
        }
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = textInputState.text();
        extractedText.partialEndOffset = textInputState.text().length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = textInputState.selection().start();
        extractedText.selectionEnd = textInputState.selection().end();
        extractedText.flags = textInputState.singleLine() ? 1 : 0;
        return extractedText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        assertOnImeThread();
        assertOnImeThread();
        this.mNumNestedBatchEdits++;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        assertOnImeThread();
        if (this.mNumNestedBatchEdits == 0) {
            return false;
        }
        this.mNumNestedBatchEdits--;
        if (this.mNumNestedBatchEdits == 0) {
            updateSelection(requestAndWaitForTextInputState());
        }
        return this.mNumNestedBatchEdits != 0;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(final int beforeLength, final int afterLength) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.13
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadedInputConnection.this.mPendingAccent != 0) {
                    ThreadedInputConnection.this.finishComposingTextOnUiThread();
                }
                ThreadedInputConnection.this.mImeAdapter.deleteSurroundingText(beforeLength, afterLength);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(final int beforeLength, final int afterLength) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.14
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadedInputConnection.this.mPendingAccent != 0) {
                    ThreadedInputConnection.this.finishComposingTextOnUiThread();
                }
                ThreadedInputConnection.this.mImeAdapter.deleteSurroundingTextInCodePoints(beforeLength, afterLength);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(final KeyEvent event) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.15
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadedInputConnection.this.handleCombiningAccentOnUiThread(event)) {
                    return;
                }
                ThreadedInputConnection.this.mImeAdapter.sendKeyEvent(event);
            }
        });
        notifyUserAction();
        return true;
    }

    private void commitCodePointOnUiThread(int codePoint, int pendingAccentToSet) {
        StringBuilder builder = new StringBuilder();
        builder.appendCodePoint(codePoint);
        String text = builder.toString();
        this.mImeAdapter.sendCompositionToNative(text, 1, true, 0);
        setCombiningAccentOnUiThread(pendingAccentToSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleCombiningAccentOnUiThread(KeyEvent event) {
        int action = event.getAction();
        int unicodeChar = event.getUnicodeChar();
        if (action != 0) {
            return false;
        }
        if (event.getKeyCode() == 67) {
            setCombiningAccentOnUiThread(0);
            return false;
        } else if ((unicodeChar & Integer.MIN_VALUE) != 0) {
            int newPendingAccent = unicodeChar & Integer.MAX_VALUE;
            if (this.mPendingAccent != 0) {
                if (newPendingAccent == this.mPendingAccent) {
                    commitCodePointOnUiThread(this.mPendingAccent, 0);
                    return true;
                }
                commitCodePointOnUiThread(this.mPendingAccent, newPendingAccent);
                return true;
            }
            setCombiningAccentOnUiThread(newPendingAccent);
            return true;
        } else if (this.mPendingAccent != 0 && unicodeChar != 0) {
            int combined = KeyEvent.getDeadChar(this.mPendingAccent, unicodeChar);
            if (combined != 0) {
                commitCodePointOnUiThread(combined, 0);
                return true;
            }
            commitCodePointOnUiThread(this.mPendingAccent, 0);
            finishComposingTextOnUiThread();
            return false;
        } else {
            return false;
        }
    }

    @VisibleForTesting
    public void setCombiningAccentOnUiThread(int pendingAccent) {
        this.mPendingAccent = pendingAccent;
    }

    private void cancelCombiningAccentOnUiThread() {
        this.mPendingAccent = 0;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, this.mFinishComposingTextRunnable);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishComposingTextOnUiThread() {
        this.mImeAdapter.finishComposingText();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(final int start, final int end) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.16
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.mImeAdapter.setEditableSelectionOffsets(start, end);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(final int start, final int end) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.17
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.mImeAdapter.setComposingRegion(start, end);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int maxChars, int flags) {
        TextInputState textInputState = requestAndWaitForTextInputState();
        if (textInputState == null) {
            return null;
        }
        return textInputState.getTextBeforeSelection(maxChars);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int maxChars, int flags) {
        TextInputState textInputState = requestAndWaitForTextInputState();
        if (textInputState == null) {
            return null;
        }
        return textInputState.getTextAfterSelection(maxChars);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int flags) {
        TextInputState textInputState = requestAndWaitForTextInputState();
        if (textInputState == null) {
            return null;
        }
        return textInputState.getSelectedText();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        TextInputState textInputState = requestAndWaitForTextInputState();
        int result = 0;
        if (textInputState != null) {
            result = TextUtils.getCapsMode(textInputState.text(), textInputState.selection().start(), reqModes);
        }
        return result;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo text) {
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean enabled) {
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(final String action, final Bundle data) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.18
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.mImeAdapter.performPrivateCommand(action, data);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(final int cursorUpdateMode) {
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnection.19
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnection.this.mImeAdapter.onRequestCursorUpdates(cursorUpdateMode);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    @SuppressLint({"MissingSuperCall"})
    public void closeConnection() {
    }
}
