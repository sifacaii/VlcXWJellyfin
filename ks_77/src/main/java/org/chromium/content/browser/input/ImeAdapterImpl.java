package org.chromium.content.browser.input;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.SuggestionSpan;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputConnection;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.TraceEvent;
import org.chromium.base.UserData;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.blink_public.web.WebInputEventModifier;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.WindowEventObserverManager;
import org.chromium.content.browser.input.ChromiumBaseInputConnection;
import org.chromium.content.browser.input.CursorAnchorInfoController;
import org.chromium.content.browser.picker.InputDialogContainer;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.ImeAdapter;
import org.chromium.content_public.browser.ImeEventObserver;
import org.chromium.content_public.browser.InputMethodManagerWrapper;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.ViewUtils;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ImeAdapterImpl.class */
public class ImeAdapterImpl implements ImeAdapter, WindowEventObserver, UserData {
    private static final String TAG = "cr_Ime";
    private static final boolean DEBUG_LOGS = false;
    private static final float SUGGESTION_HIGHLIGHT_BACKGROUND_TRANSPARENCY = 0.4f;
    public static final int COMPOSITION_KEY_CODE = 229;
    private static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    private static final int DEFAULT_SUGGESTION_SPAN_COLOR = -2000107320;
    private long mNativeImeAdapterAndroid;
    private InputMethodManagerWrapper mInputMethodManagerWrapper;
    private ChromiumBaseInputConnection mInputConnection;
    private ChromiumBaseInputConnection.Factory mInputConnectionFactory;
    private ShowKeyboardResultReceiver mShowKeyboardResultReceiver;
    private final WebContentsImpl mWebContents;
    private ViewAndroidDelegate mViewDelegate;
    private CursorAnchorInfoController mCursorAnchorInfoController;
    private int mTextInputFlags;
    private boolean mNodeEditable;
    private boolean mNodePassword;
    private Configuration mCurrentConfig;
    private int mLastSelectionStart;
    private int mLastSelectionEnd;
    private String mLastText;
    private int mLastCompositionStart;
    private int mLastCompositionEnd;
    private boolean mRestartInputOnNextStateUpdate;
    private boolean mIsConnected;
    static final /* synthetic */ boolean $assertionsDisabled;
    private final List<ImeEventObserver> mEventObservers = new ArrayList();
    private int mTextInputType = 0;
    private int mTextInputMode = 0;
    private int mTextInputAction = 0;
    private final Rect mFocusPreOSKViewportRect = new Rect();

    private native long nativeInit(WebContents webContents);

    private native boolean nativeSendKeyEvent(long j, KeyEvent keyEvent, int i, int i2, long j2, int i3, int i4, boolean z, int i5);

    private static native void nativeAppendUnderlineSpan(long j, int i, int i2);

    private static native void nativeAppendBackgroundColorSpan(long j, int i, int i2, int i3);

    private static native void nativeAppendSuggestionSpan(long j, int i, int i2, boolean z, boolean z2, int i3, int i4, String[] strArr);

    private native void nativeSetComposingText(long j, CharSequence charSequence, String str, int i);

    private native void nativeCommitText(long j, CharSequence charSequence, String str, int i);

    private native void nativeFinishComposingText(long j);

    private native void nativeSetEditableSelectionOffsets(long j, int i, int i2);

    private native void nativeSetComposingRegion(long j, int i, int i2);

    private native void nativeDeleteSurroundingText(long j, int i, int i2);

    private native void nativeDeleteSurroundingTextInCodePoints(long j, int i, int i2);

    private native boolean nativeRequestTextInputStateUpdate(long j);

    private native void nativeRequestCursorUpdate(long j, boolean z, boolean z2);

    private native void nativeAdvanceFocusInForm(long j, int i);

    static {
        $assertionsDisabled = !ImeAdapterImpl.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ImeAdapterImpl$ShowKeyboardResultReceiver.class */
    public static class ShowKeyboardResultReceiver extends ResultReceiver {
        private final WeakReference<ImeAdapterImpl> mImeAdapter;

        public ShowKeyboardResultReceiver(ImeAdapterImpl imeAdapter, Handler handler) {
            super(handler);
            this.mImeAdapter = new WeakReference<>(imeAdapter);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int resultCode, Bundle resultData) {
            ImeAdapterImpl imeAdapter = this.mImeAdapter.get();
            if (imeAdapter == null) {
                return;
            }
            imeAdapter.onShowKeyboardReceiveResult(resultCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ImeAdapterImpl$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<ImeAdapterImpl> INSTANCE = ImeAdapterImpl::new;

        private UserDataFactoryLazyHolder() {
        }
    }

    public static ImeAdapterImpl fromWebContents(WebContents webContents) {
        return (ImeAdapterImpl) ((WebContentsImpl) webContents).getOrSetUserData(ImeAdapterImpl.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    public static InputMethodManagerWrapper createDefaultInputMethodManagerWrapper(Context context) {
        return new InputMethodManagerWrapperImpl(context);
    }

    public ImeAdapterImpl(WebContents webContents) {
        this.mWebContents = (WebContentsImpl) webContents;
        this.mViewDelegate = this.mWebContents.getViewAndroidDelegate();
        if (!$assertionsDisabled && this.mViewDelegate == null) {
            throw new AssertionError();
        }
        InputMethodManagerWrapper wrapper = createDefaultInputMethodManagerWrapper(ContextUtils.getApplicationContext());
        this.mCurrentConfig = new Configuration(getContainerView().getResources().getConfiguration());
        if (Build.VERSION.SDK_INT >= 21) {
            this.mCursorAnchorInfoController = CursorAnchorInfoController.create(wrapper, new CursorAnchorInfoController.ComposingTextDelegate() { // from class: org.chromium.content.browser.input.ImeAdapterImpl.1
                @Override // org.chromium.content.browser.input.CursorAnchorInfoController.ComposingTextDelegate
                public CharSequence getText() {
                    return ImeAdapterImpl.this.mLastText;
                }

                @Override // org.chromium.content.browser.input.CursorAnchorInfoController.ComposingTextDelegate
                public int getSelectionStart() {
                    return ImeAdapterImpl.this.mLastSelectionStart;
                }

                @Override // org.chromium.content.browser.input.CursorAnchorInfoController.ComposingTextDelegate
                public int getSelectionEnd() {
                    return ImeAdapterImpl.this.mLastSelectionEnd;
                }

                @Override // org.chromium.content.browser.input.CursorAnchorInfoController.ComposingTextDelegate
                public int getComposingTextStart() {
                    return ImeAdapterImpl.this.mLastCompositionStart;
                }

                @Override // org.chromium.content.browser.input.CursorAnchorInfoController.ComposingTextDelegate
                public int getComposingTextEnd() {
                    return ImeAdapterImpl.this.mLastCompositionEnd;
                }
            });
        } else {
            this.mCursorAnchorInfoController = null;
        }
        this.mInputMethodManagerWrapper = wrapper;
        this.mNativeImeAdapterAndroid = nativeInit(this.mWebContents);
        WindowEventObserverManager.from(this.mWebContents).addObserver(this);
    }

    @Override // org.chromium.content_public.browser.ImeAdapter
    public InputConnection getActiveInputConnection() {
        return this.mInputConnection;
    }

    @Override // org.chromium.content_public.browser.ImeAdapter
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        boolean allowKeyboardLearning = (this.mWebContents == null || this.mWebContents.isIncognito()) ? false : true;
        return onCreateInputConnection(outAttrs, allowKeyboardLearning);
    }

    @Override // org.chromium.content_public.browser.ImeAdapter
    public boolean onCheckIsTextEditor() {
        return isTextInputType(this.mTextInputType);
    }

    private boolean isHardwareKeyboardAttached() {
        return this.mCurrentConfig.keyboard != 1;
    }

    @Override // org.chromium.content_public.browser.ImeAdapter
    public void addEventObserver(ImeEventObserver eventObserver) {
        this.mEventObservers.add(eventObserver);
    }

    private void createInputConnectionFactory() {
        if (this.mInputConnectionFactory != null) {
            return;
        }
        this.mInputConnectionFactory = new ThreadedInputConnectionFactory(this.mInputMethodManagerWrapper);
    }

    private boolean isValid() {
        return this.mNativeImeAdapterAndroid != 0 && this.mIsConnected;
    }

    private boolean focusedNodeAllowsSoftKeyboard() {
        return (this.mTextInputType == 0 || this.mTextInputMode == 1) ? false : true;
    }

    private boolean focusedNodeEditable() {
        return this.mTextInputType != 0;
    }

    private View getContainerView() {
        return this.mViewDelegate.getContainerView();
    }

    public ChromiumBaseInputConnection onCreateInputConnection(EditorInfo outAttrs, boolean allowKeyboardLearning) {
        outAttrs.imeOptions = 301989888;
        if (!allowKeyboardLearning) {
            outAttrs.imeOptions |= 16777216;
        }
        if (!focusedNodeEditable()) {
            setInputConnection(null);
            return null;
        } else if (this.mInputConnectionFactory == null) {
            return null;
        } else {
            View containerView = getContainerView();
            setInputConnection(this.mInputConnectionFactory.initializeAndGet(containerView, this, this.mTextInputType, this.mTextInputFlags, this.mTextInputMode, this.mTextInputAction, this.mLastSelectionStart, this.mLastSelectionEnd, outAttrs));
            if (this.mCursorAnchorInfoController != null) {
                this.mCursorAnchorInfoController.onRequestCursorUpdates(false, false, containerView);
            }
            if (isValid()) {
                nativeRequestCursorUpdate(this.mNativeImeAdapterAndroid, false, false);
            }
            return this.mInputConnection;
        }
    }

    private void setInputConnection(ChromiumBaseInputConnection inputConnection) {
        if (this.mInputConnection == inputConnection) {
            return;
        }
        if (this.mInputConnection != null) {
            this.mInputConnection.unblockOnUiThread();
        }
        this.mInputConnection = inputConnection;
    }

    @Override // org.chromium.content_public.browser.ImeAdapter
    public void setInputMethodManagerWrapper(InputMethodManagerWrapper immw) {
        this.mInputMethodManagerWrapper = immw;
        if (this.mCursorAnchorInfoController != null) {
            this.mCursorAnchorInfoController.setInputMethodManagerWrapper(immw);
        }
    }

    @VisibleForTesting
    void setInputConnectionFactory(ChromiumBaseInputConnection.Factory factory) {
        this.mInputConnectionFactory = factory;
    }

    @VisibleForTesting
    ChromiumBaseInputConnection.Factory getInputConnectionFactoryForTest() {
        return this.mInputConnectionFactory;
    }

    @VisibleForTesting
    public void setTriggerDelayedOnCreateInputConnectionForTest(boolean trigger) {
        this.mInputConnectionFactory.setTriggerDelayedOnCreateInputConnection(trigger);
    }

    @Override // org.chromium.content_public.browser.ImeAdapter
    @VisibleForTesting
    public InputConnection getInputConnectionForTest() {
        return this.mInputConnection;
    }

    @Override // org.chromium.content_public.browser.ImeAdapter
    @VisibleForTesting
    public void setComposingTextForTest(CharSequence text, int newCursorPosition) {
        this.mInputConnection.getHandler().post(() -> {
            this.mInputConnection.setComposingText(text, newCursorPosition);
        });
    }

    private static int getModifiers(int metaState) {
        int modifiers = 0;
        if ((metaState & 1) != 0) {
            modifiers = 0 | 1;
        }
        if ((metaState & 2) != 0) {
            modifiers |= 4;
        }
        if ((metaState & 4096) != 0) {
            modifiers |= 2;
        }
        if ((metaState & WebInputEventModifier.BACK_BUTTON_DOWN) != 0) {
            modifiers |= 512;
        }
        if ((metaState & WebInputEventModifier.FORWARD_BUTTON_DOWN) != 0) {
            modifiers |= 1024;
        }
        return modifiers;
    }

    @CalledByNative
    private void updateState(int textInputType, int textInputFlags, int textInputMode, int textInputAction, boolean showIfNeeded, String text, int selectionStart, int selectionEnd, int compositionStart, int compositionEnd, boolean replyToRequest) {
        TraceEvent.begin("ImeAdapter.updateState");
        try {
            boolean needsRestart = false;
            boolean hide = false;
            if (this.mRestartInputOnNextStateUpdate) {
                needsRestart = true;
                this.mRestartInputOnNextStateUpdate = false;
            }
            this.mTextInputFlags = textInputFlags;
            if (this.mTextInputMode != textInputMode) {
                this.mTextInputMode = textInputMode;
                hide = textInputMode == 1 && !isHardwareKeyboardAttached();
                needsRestart = true;
            }
            if (this.mTextInputType != textInputType) {
                this.mTextInputType = textInputType;
                if (textInputType == 0) {
                    hide = true;
                } else {
                    needsRestart = true;
                }
            } else if (textInputType == 0) {
                hide = true;
            }
            if (this.mTextInputAction != textInputAction) {
                this.mTextInputAction = textInputAction;
                needsRestart = true;
            }
            boolean editable = focusedNodeEditable();
            boolean password = textInputType == 2;
            if (this.mNodeEditable != editable || this.mNodePassword != password) {
                for (ImeEventObserver observer : this.mEventObservers) {
                    observer.onNodeAttributeUpdated(editable, password);
                }
                this.mNodeEditable = editable;
                this.mNodePassword = password;
            }
            if (this.mCursorAnchorInfoController != null && (!TextUtils.equals(this.mLastText, text) || this.mLastSelectionStart != selectionStart || this.mLastSelectionEnd != selectionEnd || this.mLastCompositionStart != compositionStart || this.mLastCompositionEnd != compositionEnd)) {
                this.mCursorAnchorInfoController.invalidateLastCursorAnchorInfo();
            }
            this.mLastText = text;
            this.mLastSelectionStart = selectionStart;
            this.mLastSelectionEnd = selectionEnd;
            this.mLastCompositionStart = compositionStart;
            this.mLastCompositionEnd = compositionEnd;
            if (hide) {
                hideKeyboard();
            } else {
                if (needsRestart) {
                    restartInput();
                }
                if (showIfNeeded && focusedNodeAllowsSoftKeyboard()) {
                    showSoftKeyboard();
                }
            }
            if (this.mInputConnection != null) {
                boolean singleLine = (this.mTextInputType == 14 || this.mTextInputType == 15) ? false : true;
                this.mInputConnection.updateStateOnUiThread(text, selectionStart, selectionEnd, compositionStart, compositionEnd, singleLine, replyToRequest);
            }
        } finally {
            TraceEvent.end("ImeAdapter.updateState");
        }
    }

    private void showSoftKeyboard() {
        if (isValid()) {
            View containerView = getContainerView();
            this.mInputMethodManagerWrapper.showSoftInput(containerView, 0, getNewShowKeyboardReceiver());
            if (containerView.getResources().getConfiguration().keyboard != 1) {
                this.mWebContents.scrollFocusedEditableNodeIntoView();
            }
        }
    }

    public void onShowKeyboardReceiveResult(int resultCode) {
        View containerView = getContainerView();
        if (resultCode == 2) {
            containerView.getWindowVisibleDisplayFrame(this.mFocusPreOSKViewportRect);
        } else if (ViewUtils.hasFocus(containerView) && resultCode == 0) {
            this.mWebContents.scrollFocusedEditableNodeIntoView();
        }
    }

    @CalledByNative
    private void updateAfterViewSizeChanged() {
        if (!this.mFocusPreOSKViewportRect.isEmpty()) {
            Rect rect = new Rect();
            getContainerView().getWindowVisibleDisplayFrame(rect);
            if (!rect.equals(this.mFocusPreOSKViewportRect)) {
                if (rect.width() == this.mFocusPreOSKViewportRect.width()) {
                    if (!$assertionsDisabled && this.mWebContents == null) {
                        throw new AssertionError();
                    }
                    this.mWebContents.scrollFocusedEditableNodeIntoView();
                }
                cancelRequestToScrollFocusedEditableNodeIntoView();
            }
        }
    }

    @CalledByNative
    private void updateOnTouchDown() {
        cancelRequestToScrollFocusedEditableNodeIntoView();
    }

    public void cancelRequestToScrollFocusedEditableNodeIntoView() {
        this.mFocusPreOSKViewportRect.setEmpty();
    }

    @Override // org.chromium.content_public.browser.ImeAdapter
    public ResultReceiver getNewShowKeyboardReceiver() {
        if (this.mShowKeyboardResultReceiver == null) {
            this.mShowKeyboardResultReceiver = new ShowKeyboardResultReceiver(this, new Handler());
        }
        return this.mShowKeyboardResultReceiver;
    }

    private void hideKeyboard() {
        if (isValid()) {
            View view = this.mViewDelegate.getContainerView();
            if (this.mInputMethodManagerWrapper.isActive(view)) {
                this.mInputMethodManagerWrapper.hideSoftInputFromWindow(view.getWindowToken(), 0, null);
            }
            if (!focusedNodeEditable() && this.mInputConnection != null) {
                ChromiumBaseInputConnection inputConnection = this.mInputConnection;
                restartInput();
                inputConnection.unblockOnUiThread();
            }
        }
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onConfigurationChanged(Configuration newConfig) {
        if (isValid()) {
            if (this.mCurrentConfig.keyboard == newConfig.keyboard && this.mCurrentConfig.keyboardHidden == newConfig.keyboardHidden && this.mCurrentConfig.hardKeyboardHidden == newConfig.hardKeyboardHidden) {
                return;
            }
            this.mCurrentConfig = new Configuration(newConfig);
            if (focusedNodeAllowsSoftKeyboard()) {
                restartInput();
                showSoftKeyboard();
            } else if (focusedNodeEditable()) {
                restartInput();
                if (!isHardwareKeyboardAttached()) {
                    hideKeyboard();
                } else {
                    showSoftKeyboard();
                }
            }
        }
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onWindowFocusChanged(boolean gainFocus) {
        if (this.mInputConnectionFactory != null) {
            this.mInputConnectionFactory.onWindowFocusChanged(gainFocus);
        }
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onAttachedToWindow() {
        if (this.mInputConnectionFactory != null) {
            this.mInputConnectionFactory.onViewAttachedToWindow();
        }
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onDetachedFromWindow() {
        resetAndHideKeyboard();
        if (this.mInputConnectionFactory != null) {
            this.mInputConnectionFactory.onViewDetachedFromWindow();
        }
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onViewFocusChanged(boolean gainFocus, boolean hideKeyboardOnBlur) {
        if (!gainFocus && hideKeyboardOnBlur) {
            resetAndHideKeyboard();
        }
        if (this.mInputConnectionFactory != null) {
            this.mInputConnectionFactory.onViewFocusChanged(gainFocus);
        }
    }

    private static boolean isTextInputType(int type) {
        return (type == 0 || InputDialogContainer.isDialogInputType(type)) ? false : true;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return this.mInputConnection != null ? this.mInputConnection.sendKeyEventOnUiThread(event) : sendKeyEvent(event);
    }

    public void resetAndHideKeyboard() {
        this.mTextInputType = 0;
        this.mTextInputFlags = 0;
        this.mTextInputMode = 0;
        this.mRestartInputOnNextStateUpdate = false;
        hideKeyboard();
    }

    public void reset() {
        resetAndHideKeyboard();
    }

    @CalledByNative
    private void onNativeDestroyed() {
        resetAndHideKeyboard();
        this.mNativeImeAdapterAndroid = 0L;
        this.mIsConnected = false;
        if (this.mCursorAnchorInfoController != null) {
            this.mCursorAnchorInfoController.focusedNodeChanged(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateSelection(int selectionStart, int selectionEnd, int compositionStart, int compositionEnd) {
        this.mInputMethodManagerWrapper.updateSelection(getContainerView(), selectionStart, selectionEnd, compositionStart, compositionEnd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateExtractedText(int token, ExtractedText extractedText) {
        this.mInputMethodManagerWrapper.updateExtractedText(getContainerView(), token, extractedText);
    }

    void restartInput() {
        if (isValid()) {
            this.mInputMethodManagerWrapper.restartInput(getContainerView());
            if (this.mInputConnection != null) {
                this.mInputConnection.onRestartInputOnUiThread();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performContextMenuAction(int id) {
        switch (id) {
            case 16908319:
                this.mWebContents.selectAll();
                return true;
            case 16908320:
                this.mWebContents.cut();
                return true;
            case 16908321:
                this.mWebContents.copy();
                return true;
            case 16908322:
                this.mWebContents.paste();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performEditorAction(int actionCode) {
        if (isValid()) {
            if (this.mTextInputAction == 0) {
                switch (actionCode) {
                    case 5:
                        advanceFocusInForm(1);
                        return true;
                    case 7:
                        advanceFocusInForm(2);
                        return true;
                }
            }
            sendSyntheticKeyPress(66, 22);
            return true;
        }
        return false;
    }

    public void performPrivateCommand(String action, Bundle data) {
        this.mViewDelegate.performPrivateImeCommand(action, data);
    }

    @Override // org.chromium.content_public.browser.ImeAdapter
    public void advanceFocusInForm(int focusType) {
        if (this.mNativeImeAdapterAndroid == 0) {
            return;
        }
        nativeAdvanceFocusInForm(this.mNativeImeAdapterAndroid, focusType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyUserAction() {
        this.mInputMethodManagerWrapper.notifyUserAction();
    }

    public void sendSyntheticKeyPress(int keyCode, int flags) {
        long eventTime = SystemClock.uptimeMillis();
        sendKeyEvent(new KeyEvent(eventTime, eventTime, 0, keyCode, 0, 0, -1, 0, flags));
        sendKeyEvent(new KeyEvent(eventTime, eventTime, 1, keyCode, 0, 0, -1, 0, flags));
    }

    private void onImeEvent() {
        for (ImeEventObserver observer : this.mEventObservers) {
            observer.onImeEvent();
        }
        if (this.mNodeEditable && this.mWebContents.getRenderWidgetHostView() != null) {
            this.mWebContents.getRenderWidgetHostView().dismissTextHandles();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sendCompositionToNative(CharSequence text, int newCursorPosition, boolean isCommit, int unicodeFromKeyEvent) {
        if (isValid()) {
            onImeEvent();
            long timestampMs = SystemClock.uptimeMillis();
            nativeSendKeyEvent(this.mNativeImeAdapterAndroid, null, 7, 0, timestampMs, 229, 0, false, unicodeFromKeyEvent);
            if (isCommit) {
                nativeCommitText(this.mNativeImeAdapterAndroid, text, text.toString(), newCursorPosition);
            } else {
                nativeSetComposingText(this.mNativeImeAdapterAndroid, text, text.toString(), newCursorPosition);
            }
            nativeSendKeyEvent(this.mNativeImeAdapterAndroid, null, 9, 0, timestampMs, 229, 0, false, unicodeFromKeyEvent);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean finishComposingText() {
        if (isValid()) {
            nativeFinishComposingText(this.mNativeImeAdapterAndroid);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sendKeyEvent(KeyEvent event) {
        int type;
        if (isValid()) {
            int action = event.getAction();
            if (action == 0) {
                type = 8;
            } else if (action == 1) {
                type = 9;
            } else {
                return false;
            }
            for (ImeEventObserver observer : this.mEventObservers) {
                observer.onBeforeSendKeyEvent(event);
            }
            onImeEvent();
            return nativeSendKeyEvent(this.mNativeImeAdapterAndroid, event, type, getModifiers(event.getMetaState()), event.getEventTime(), event.getKeyCode(), event.getScanCode(), false, event.getUnicodeChar());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        onImeEvent();
        if (isValid()) {
            nativeSendKeyEvent(this.mNativeImeAdapterAndroid, null, 7, 0, SystemClock.uptimeMillis(), 229, 0, false, 0);
            nativeDeleteSurroundingText(this.mNativeImeAdapterAndroid, beforeLength, afterLength);
            nativeSendKeyEvent(this.mNativeImeAdapterAndroid, null, 9, 0, SystemClock.uptimeMillis(), 229, 0, false, 0);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        onImeEvent();
        if (isValid()) {
            nativeSendKeyEvent(this.mNativeImeAdapterAndroid, null, 7, 0, SystemClock.uptimeMillis(), 229, 0, false, 0);
            nativeDeleteSurroundingTextInCodePoints(this.mNativeImeAdapterAndroid, beforeLength, afterLength);
            nativeSendKeyEvent(this.mNativeImeAdapterAndroid, null, 9, 0, SystemClock.uptimeMillis(), 229, 0, false, 0);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setEditableSelectionOffsets(int start, int end) {
        if (isValid()) {
            nativeSetEditableSelectionOffsets(this.mNativeImeAdapterAndroid, start, end);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setComposingRegion(int start, int end) {
        if (isValid()) {
            if (start <= end) {
                nativeSetComposingRegion(this.mNativeImeAdapterAndroid, start, end);
                return true;
            }
            nativeSetComposingRegion(this.mNativeImeAdapterAndroid, end, start);
            return true;
        }
        return false;
    }

    @CalledByNative
    private void focusedNodeChanged(boolean isEditable) {
        if (this.mCursorAnchorInfoController != null) {
            this.mCursorAnchorInfoController.focusedNodeChanged(isEditable);
        }
        if (this.mTextInputType != 0 && this.mInputConnection != null && isEditable) {
            this.mRestartInputOnNextStateUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean requestTextInputStateUpdate() {
        if (isValid() && this.mInputConnection != null) {
            return nativeRequestTextInputStateUpdate(this.mNativeImeAdapterAndroid);
        }
        return false;
    }

    public boolean onRequestCursorUpdates(int cursorUpdateMode) {
        boolean immediateRequest = (cursorUpdateMode & 1) != 0;
        boolean monitorRequest = (cursorUpdateMode & 2) != 0;
        if (isValid()) {
            nativeRequestCursorUpdate(this.mNativeImeAdapterAndroid, immediateRequest, monitorRequest);
        }
        if (this.mCursorAnchorInfoController == null) {
            return false;
        }
        return this.mCursorAnchorInfoController.onRequestCursorUpdates(immediateRequest, monitorRequest, getContainerView());
    }

    @CalledByNative
    private void updateFrameInfo(float scaleFactor, float contentOffsetYPix, boolean hasInsertionMarker, boolean isInsertionMarkerVisible, float insertionMarkerHorizontal, float insertionMarkerTop, float insertionMarkerBottom) {
        if (this.mCursorAnchorInfoController == null) {
            return;
        }
        this.mCursorAnchorInfoController.onUpdateFrameInfo(scaleFactor, contentOffsetYPix, hasInsertionMarker, isInsertionMarkerVisible, insertionMarkerHorizontal, insertionMarkerTop, insertionMarkerBottom, getContainerView());
    }

    private int getUnderlineColorForSuggestionSpan(SuggestionSpan suggestionSpan) {
        try {
            Method getUnderlineColorMethod = SuggestionSpan.class.getMethod("getUnderlineColor", new Class[0]);
            return ((Integer) getUnderlineColorMethod.invoke(suggestionSpan, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            return DEFAULT_SUGGESTION_SPAN_COLOR;
        } catch (NoSuchMethodException e2) {
            return DEFAULT_SUGGESTION_SPAN_COLOR;
        } catch (InvocationTargetException e3) {
            return DEFAULT_SUGGESTION_SPAN_COLOR;
        }
    }

    @CalledByNative
    private void populateImeTextSpansFromJava(CharSequence text, long imeTextSpans) {
        if (text instanceof SpannableString) {
            SpannableString spannableString = (SpannableString) text;
            CharacterStyle[] spans = (CharacterStyle[]) spannableString.getSpans(0, text.length(), CharacterStyle.class);
            for (CharacterStyle span : spans) {
                int spanFlags = spannableString.getSpanFlags(span);
                if (span instanceof BackgroundColorSpan) {
                    nativeAppendBackgroundColorSpan(imeTextSpans, spannableString.getSpanStart(span), spannableString.getSpanEnd(span), ((BackgroundColorSpan) span).getBackgroundColor());
                } else if (span instanceof UnderlineSpan) {
                    nativeAppendUnderlineSpan(imeTextSpans, spannableString.getSpanStart(span), spannableString.getSpanEnd(span));
                } else if (span instanceof SuggestionSpan) {
                    SuggestionSpan suggestionSpan = (SuggestionSpan) span;
                    boolean removeOnFinishComposing = (spanFlags & 256) != 0;
                    boolean isEasyCorrectSpan = (suggestionSpan.getFlags() & 1) != 0;
                    boolean isMisspellingSpan = (suggestionSpan.getFlags() & 2) != 0;
                    boolean isAutoCorrectionSpan = (suggestionSpan.getFlags() & 4) != 0;
                    if (isEasyCorrectSpan || isMisspellingSpan || isAutoCorrectionSpan) {
                        int underlineColor = getUnderlineColorForSuggestionSpan(suggestionSpan);
                        int newAlpha = (int) (Color.alpha(underlineColor) * SUGGESTION_HIGHLIGHT_BACKGROUND_TRANSPARENCY);
                        int suggestionHighlightColor = (underlineColor & 16777215) + (newAlpha << 24);
                        nativeAppendSuggestionSpan(imeTextSpans, spannableString.getSpanStart(suggestionSpan), spannableString.getSpanEnd(suggestionSpan), isMisspellingSpan || isAutoCorrectionSpan, removeOnFinishComposing, underlineColor, suggestionHighlightColor, isAutoCorrectionSpan ? new String[0] : suggestionSpan.getSuggestions());
                    }
                }
            }
        }
    }

    @CalledByNative
    private void cancelComposition() {
        if (this.mInputConnection != null) {
            restartInput();
        }
    }

    @CalledByNative
    private void setCharacterBounds(float[] characterBounds) {
        if (this.mCursorAnchorInfoController == null) {
            return;
        }
        this.mCursorAnchorInfoController.setCompositionCharacterBounds(characterBounds, getContainerView());
    }

    @CalledByNative
    private void onConnectedToRenderProcess() {
        this.mIsConnected = true;
        createInputConnectionFactory();
        resetAndHideKeyboard();
    }
}
