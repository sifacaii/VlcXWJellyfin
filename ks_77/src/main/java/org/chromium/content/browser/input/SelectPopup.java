package org.chromium.content.browser.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.UserData;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.PopupController;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.WindowEventObserverManager;
import org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.DeviceFormFactor;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/SelectPopup.class */
public class SelectPopup implements PopupController.HideablePopup, ViewAndroidDelegate.ContainerViewObserver, WindowEventObserver, UserData {
    private final WebContentsImpl mWebContents;
    private View mContainerView;
    private Ui mPopupView;
    private long mNativeSelectPopup;
    private long mNativeSelectPopupSourceFrame;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/SelectPopup$Ui.class */
    public interface Ui {
        void show();

        void hide(boolean z);
    }

    private native void nativeSelectMenuItems(long j, long j2, int[] iArr);

    static {
        $assertionsDisabled = !SelectPopup.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/SelectPopup$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<SelectPopup> INSTANCE = SelectPopup::new;

        private UserDataFactoryLazyHolder() {
        }
    }

    public static SelectPopup fromWebContents(WebContents webContents) {
        return (SelectPopup) ((WebContentsImpl) webContents).getOrSetUserData(SelectPopup.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    @CalledByNative
    private static SelectPopup create(WebContents webContents, long nativePtr) {
        SelectPopup selectPopup = fromWebContents(webContents);
        selectPopup.mNativeSelectPopup = nativePtr;
        return selectPopup;
    }

    public SelectPopup(WebContents webContents) {
        this.mWebContents = (WebContentsImpl) webContents;
        ViewAndroidDelegate viewDelegate = this.mWebContents.getViewAndroidDelegate();
        if (!$assertionsDisabled && viewDelegate == null) {
            throw new AssertionError();
        }
        this.mContainerView = viewDelegate.getContainerView();
        viewDelegate.addObserver(this);
        PopupController.register(this.mWebContents, this);
        WindowEventObserverManager.from(this.mWebContents).addObserver(this);
    }

    public void close() {
        this.mPopupView = null;
    }

    @Override // org.chromium.content.browser.PopupController.HideablePopup
    public void hide() {
        if (this.mPopupView != null) {
            this.mPopupView.hide(true);
        }
    }

    @Override // org.chromium.ui.base.ViewAndroidDelegate.ContainerViewObserver
    public void onUpdateContainerView(ViewGroup view) {
        this.mContainerView = view;
        hide();
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onWindowAndroidChanged(WindowAndroid windowAndroid) {
        close();
    }

    @CalledByNative
    private void show(View anchorView, long nativeSelectPopupSourceFrame, String[] items, int[] enabled, boolean multiple, int[] selectedIndices, boolean rightAligned) {
        if (this.mContainerView.getParent() == null || this.mContainerView.getVisibility() != 0) {
            this.mNativeSelectPopupSourceFrame = nativeSelectPopupSourceFrame;
            selectMenuItems(null);
            return;
        }
        PopupController.hidePopupsAndClearSelection(this.mWebContents);
        if (!$assertionsDisabled && this.mNativeSelectPopupSourceFrame != 0) {
            throw new AssertionError("Zombie popup did not clear the frame source");
        }
        Context context = this.mWebContents.getContext();
        if (context == null) {
            return;
        }
        if (!$assertionsDisabled && items.length != enabled.length) {
            throw new AssertionError();
        }
        List<SelectPopupItem> popupItems = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            popupItems.add(new SelectPopupItem(items[i], enabled[i]));
        }
        WebContentsAccessibilityImpl wcax = WebContentsAccessibilityImpl.fromWebContents((WebContents) this.mWebContents);
        if (DeviceFormFactor.isTablet() && !multiple && !wcax.isTouchExplorationEnabled()) {
            this.mPopupView = new SelectPopupDropdown(this, context, anchorView, popupItems, selectedIndices, rightAligned, this.mWebContents);
        } else {
            this.mPopupView = new SelectPopupDialog(this, context, popupItems, multiple, selectedIndices);
        }
        this.mNativeSelectPopupSourceFrame = nativeSelectPopupSourceFrame;
        this.mPopupView.show();
    }

    @CalledByNative
    public void hideWithoutCancel() {
        if (this.mPopupView == null) {
            return;
        }
        this.mPopupView.hide(false);
        this.mPopupView = null;
        this.mNativeSelectPopupSourceFrame = 0L;
    }

    @CalledByNative
    private void onNativeDestroyed() {
        this.mNativeSelectPopup = 0L;
    }

    @VisibleForTesting
    public boolean isVisibleForTesting() {
        return this.mPopupView != null;
    }

    public void selectMenuItems(int[] indices) {
        if (this.mNativeSelectPopup != 0) {
            nativeSelectMenuItems(this.mNativeSelectPopup, this.mNativeSelectPopupSourceFrame, indices);
        }
        this.mNativeSelectPopupSourceFrame = 0L;
        this.mPopupView = null;
    }
}
