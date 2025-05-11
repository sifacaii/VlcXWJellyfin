package org.chromium.content.browser.input;

import android.content.Context;
import org.chromium.base.UserData;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.PopupController;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.WindowEventObserverManager;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/TextSuggestionHost.class */
public class TextSuggestionHost implements WindowEventObserver, PopupController.HideablePopup, UserData {
    private long mNativeTextSuggestionHost;
    private final WebContentsImpl mWebContents;
    private final Context mContext;
    private final ViewAndroidDelegate mViewDelegate;
    private boolean mIsAttachedToWindow;
    private WindowAndroid mWindowAndroid;
    private SpellCheckPopupWindow mSpellCheckPopupWindow;
    private TextSuggestionsPopupWindow mTextSuggestionsPopupWindow;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeApplySpellCheckSuggestion(long j, String str);

    private native void nativeApplyTextSuggestion(long j, int i, int i2);

    private native void nativeDeleteActiveSuggestionRange(long j);

    private native void nativeOnNewWordAddedToDictionary(long j, String str);

    private native void nativeOnSuggestionMenuClosed(long j);

    static {
        $assertionsDisabled = !TextSuggestionHost.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/TextSuggestionHost$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<TextSuggestionHost> INSTANCE = TextSuggestionHost::new;

        private UserDataFactoryLazyHolder() {
        }
    }

    @VisibleForTesting
    static TextSuggestionHost fromWebContents(WebContents webContents) {
        return (TextSuggestionHost) ((WebContentsImpl) webContents).getOrSetUserData(TextSuggestionHost.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    @CalledByNative
    private static TextSuggestionHost create(WebContents webContents, long nativePtr) {
        TextSuggestionHost host = fromWebContents(webContents);
        host.setNativePtr(nativePtr);
        return host;
    }

    public TextSuggestionHost(WebContents webContents) {
        this.mWebContents = (WebContentsImpl) webContents;
        this.mContext = this.mWebContents.getContext();
        this.mWindowAndroid = this.mWebContents.getTopLevelNativeWindow();
        this.mViewDelegate = this.mWebContents.getViewAndroidDelegate();
        if (!$assertionsDisabled && this.mViewDelegate == null) {
            throw new AssertionError();
        }
        PopupController.register(this.mWebContents, this);
        WindowEventObserverManager.from(this.mWebContents).addObserver(this);
    }

    private void setNativePtr(long nativePtr) {
        this.mNativeTextSuggestionHost = nativePtr;
    }

    private float getContentOffsetYPix() {
        return this.mWebContents.getRenderCoordinates().getContentOffsetYPix();
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onWindowAndroidChanged(WindowAndroid newWindowAndroid) {
        this.mWindowAndroid = newWindowAndroid;
        if (this.mSpellCheckPopupWindow != null) {
            this.mSpellCheckPopupWindow.updateWindowAndroid(this.mWindowAndroid);
        }
        if (this.mTextSuggestionsPopupWindow != null) {
            this.mTextSuggestionsPopupWindow.updateWindowAndroid(this.mWindowAndroid);
        }
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onAttachedToWindow() {
        this.mIsAttachedToWindow = true;
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onDetachedFromWindow() {
        this.mIsAttachedToWindow = false;
    }

    @Override // org.chromium.ui.display.DisplayAndroid.DisplayAndroidObserver
    public void onRotationChanged(int rotation) {
        hidePopups();
    }

    @Override // org.chromium.content.browser.PopupController.HideablePopup
    public void hide() {
        hidePopups();
    }

    @CalledByNative
    private void showSpellCheckSuggestionMenu(double caretXPx, double caretYPx, String markedText, String[] suggestions) {
        if (!this.mIsAttachedToWindow) {
            onSuggestionMenuClosed(false);
            return;
        }
        hidePopups();
        this.mSpellCheckPopupWindow = new SpellCheckPopupWindow(this.mContext, this, this.mWindowAndroid, this.mViewDelegate.getContainerView());
        this.mSpellCheckPopupWindow.show(caretXPx, caretYPx + getContentOffsetYPix(), markedText, suggestions);
    }

    @CalledByNative
    private void showTextSuggestionMenu(double caretXPx, double caretYPx, String markedText, SuggestionInfo[] suggestions) {
        if (!this.mIsAttachedToWindow) {
            onSuggestionMenuClosed(false);
            return;
        }
        hidePopups();
        this.mTextSuggestionsPopupWindow = new TextSuggestionsPopupWindow(this.mContext, this, this.mWindowAndroid, this.mViewDelegate.getContainerView());
        this.mTextSuggestionsPopupWindow.show(caretXPx, caretYPx + getContentOffsetYPix(), markedText, suggestions);
    }

    @CalledByNative
    public void hidePopups() {
        if (this.mTextSuggestionsPopupWindow != null && this.mTextSuggestionsPopupWindow.isShowing()) {
            this.mTextSuggestionsPopupWindow.dismiss();
            this.mTextSuggestionsPopupWindow = null;
        }
        if (this.mSpellCheckPopupWindow != null && this.mSpellCheckPopupWindow.isShowing()) {
            this.mSpellCheckPopupWindow.dismiss();
            this.mSpellCheckPopupWindow = null;
        }
    }

    public void applySpellCheckSuggestion(String suggestion) {
        nativeApplySpellCheckSuggestion(this.mNativeTextSuggestionHost, suggestion);
    }

    public void applyTextSuggestion(int markerTag, int suggestionIndex) {
        nativeApplyTextSuggestion(this.mNativeTextSuggestionHost, markerTag, suggestionIndex);
    }

    public void deleteActiveSuggestionRange() {
        nativeDeleteActiveSuggestionRange(this.mNativeTextSuggestionHost);
    }

    public void onNewWordAddedToDictionary(String word) {
        nativeOnNewWordAddedToDictionary(this.mNativeTextSuggestionHost, word);
    }

    public void onSuggestionMenuClosed(boolean dismissedByItemTap) {
        if (!dismissedByItemTap) {
            nativeOnSuggestionMenuClosed(this.mNativeTextSuggestionHost);
        }
        this.mSpellCheckPopupWindow = null;
        this.mTextSuggestionsPopupWindow = null;
    }

    @CalledByNative
    private void onNativeDestroyed() {
        hidePopups();
        this.mNativeTextSuggestionHost = 0L;
    }

    @VisibleForTesting
    public SuggestionsPopupWindow getTextSuggestionsPopupWindowForTesting() {
        return this.mTextSuggestionsPopupWindow;
    }

    @VisibleForTesting
    public SuggestionsPopupWindow getSpellCheckPopupWindowForTesting() {
        return this.mSpellCheckPopupWindow;
    }
}
