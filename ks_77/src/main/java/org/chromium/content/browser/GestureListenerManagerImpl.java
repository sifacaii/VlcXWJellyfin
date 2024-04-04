package org.chromium.content.browser;

import android.view.View;
import org.chromium.base.ObserverList;
import org.chromium.base.TraceEvent;
import org.chromium.base.UserData;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.input.ImeAdapterImpl;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.GestureListenerManager;
import org.chromium.content_public.browser.GestureStateListener;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/GestureListenerManagerImpl.class */
public class GestureListenerManagerImpl implements GestureListenerManager, WindowEventObserver, UserData {
    private final WebContentsImpl mWebContents;
    private final ObserverList<GestureStateListener> mListeners = new ObserverList<>();
    private final ObserverList.RewindableIterator<GestureStateListener> mIterator = this.mListeners.rewindableIterator();
    private ViewAndroidDelegate mViewDelegate;
    private ViewEventSink.InternalAccessDelegate mScrollDelegate;
    private long mNativeGestureListenerManager;
    private boolean mIsTouchScrollInProgress;
    private boolean mHasActiveFlingScroll;

    private native long nativeInit(WebContentsImpl webContentsImpl);

    private native void nativeResetGestureDetection(long j);

    private native void nativeSetDoubleTapSupportEnabled(long j, boolean z);

    private native void nativeSetMultiTouchZoomSupportEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/GestureListenerManagerImpl$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<GestureListenerManagerImpl> INSTANCE = GestureListenerManagerImpl::new;

        private UserDataFactoryLazyHolder() {
        }
    }

    public static GestureListenerManagerImpl fromWebContents(WebContents webContents) {
        return (GestureListenerManagerImpl) ((WebContentsImpl) webContents).getOrSetUserData(GestureListenerManagerImpl.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    public GestureListenerManagerImpl(WebContents webContents) {
        this.mWebContents = (WebContentsImpl) webContents;
        this.mViewDelegate = this.mWebContents.getViewAndroidDelegate();
        WindowEventObserverManager.from(this.mWebContents).addObserver(this);
        this.mNativeGestureListenerManager = nativeInit(this.mWebContents);
    }

    private void resetGestureDetection() {
        if (this.mNativeGestureListenerManager != 0) {
            nativeResetGestureDetection(this.mNativeGestureListenerManager);
        }
    }

    public void setScrollDelegate(ViewEventSink.InternalAccessDelegate scrollDelegate) {
        this.mScrollDelegate = scrollDelegate;
    }

    @Override // org.chromium.content_public.browser.GestureListenerManager
    public void addListener(GestureStateListener listener) {
        this.mListeners.addObserver(listener);
    }

    @Override // org.chromium.content_public.browser.GestureListenerManager
    public void removeListener(GestureStateListener listener) {
        this.mListeners.removeObserver(listener);
    }

    @Override // org.chromium.content_public.browser.GestureListenerManager
    public void updateMultiTouchZoomSupport(boolean supportsMultiTouchZoom) {
        if (this.mNativeGestureListenerManager == 0) {
            return;
        }
        nativeSetMultiTouchZoomSupportEnabled(this.mNativeGestureListenerManager, supportsMultiTouchZoom);
    }

    @Override // org.chromium.content_public.browser.GestureListenerManager
    public void updateDoubleTapSupport(boolean supportsDoubleTap) {
        if (this.mNativeGestureListenerManager == 0) {
            return;
        }
        nativeSetDoubleTapSupportEnabled(this.mNativeGestureListenerManager, supportsDoubleTap);
    }

    @CalledByNative
    private void updateOnTouchDown() {
        this.mIterator.rewind();
        while (this.mIterator.hasNext()) {
            this.mIterator.next().onTouchDown();
        }
    }

    public boolean hasActiveFlingScroll() {
        return this.mHasActiveFlingScroll;
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onWindowFocusChanged(boolean gainFocus) {
        if (!gainFocus) {
            resetGestureDetection();
        }
        this.mIterator.rewind();
        while (this.mIterator.hasNext()) {
            this.mIterator.next().onWindowFocusChanged(gainFocus);
        }
    }

    public void updateOnScrollChanged(int offset, int extent) {
        this.mIterator.rewind();
        while (this.mIterator.hasNext()) {
            this.mIterator.next().onScrollOffsetOrExtentChanged(offset, extent);
        }
    }

    public void updateOnScrollEnd() {
        setTouchScrollInProgress(false);
        this.mIterator.rewind();
        while (this.mIterator.hasNext()) {
            this.mIterator.next().onScrollEnded(verticalScrollOffset(), verticalScrollExtent());
        }
    }

    public void updateOnScaleLimitsChanged(float minScale, float maxScale) {
        this.mIterator.rewind();
        while (this.mIterator.hasNext()) {
            this.mIterator.next().onScaleLimitsChanged(minScale, maxScale);
        }
    }

    private void resetFlingGesture() {
        if (this.mHasActiveFlingScroll) {
            onFlingEnd();
            this.mHasActiveFlingScroll = false;
        }
    }

    @CalledByNative
    private void onFlingEnd() {
        this.mHasActiveFlingScroll = false;
        setTouchScrollInProgress(false);
        this.mIterator.rewind();
        while (this.mIterator.hasNext()) {
            this.mIterator.next().onFlingEndGesture(verticalScrollOffset(), verticalScrollExtent());
        }
    }

    @CalledByNative
    private void onEventAck(int event, boolean consumed) {
        switch (event) {
            case 11:
                setTouchScrollInProgress(true);
                this.mIterator.rewind();
                while (this.mIterator.hasNext()) {
                    this.mIterator.next().onScrollStarted(verticalScrollOffset(), verticalScrollExtent());
                }
                return;
            case 12:
                updateOnScrollEnd();
                return;
            case 13:
                if (consumed) {
                    destroyPastePopup();
                    this.mIterator.rewind();
                    while (this.mIterator.hasNext()) {
                        this.mIterator.next().onScrollUpdateGestureConsumed();
                    }
                    return;
                }
                return;
            case 14:
                if (consumed) {
                    this.mHasActiveFlingScroll = true;
                    setTouchScrollInProgress(false);
                    this.mIterator.rewind();
                    while (this.mIterator.hasNext()) {
                        this.mIterator.next().onFlingStartGesture(verticalScrollOffset(), verticalScrollExtent());
                    }
                    return;
                }
                updateOnScrollEnd();
                return;
            case 15:
            case 18:
            case 19:
            case 20:
            case 22:
            default:
                return;
            case 16:
                this.mIterator.rewind();
                while (this.mIterator.hasNext()) {
                    this.mIterator.next().onPinchStarted();
                }
                return;
            case 17:
                this.mIterator.rewind();
                while (this.mIterator.hasNext()) {
                    this.mIterator.next().onPinchEnded();
                }
                return;
            case 21:
                destroyPastePopup();
                this.mIterator.rewind();
                while (this.mIterator.hasNext()) {
                    this.mIterator.next().onSingleTap(consumed);
                }
                return;
            case 23:
                if (consumed) {
                    this.mViewDelegate.getContainerView().performHapticFeedback(0);
                    this.mIterator.rewind();
                    while (this.mIterator.hasNext()) {
                        this.mIterator.next().onLongPress();
                    }
                    return;
                }
                return;
        }
    }

    private void destroyPastePopup() {
        SelectionPopupControllerImpl controller = getSelectionPopupController();
        if (controller != null) {
            controller.destroyPastePopup();
        }
    }

    @CalledByNative
    private void resetPopupsAndInput(boolean renderProcessGone) {
        ImeAdapterImpl imeAdapter;
        PopupController.hidePopupsAndClearSelection(this.mWebContents);
        resetScrollInProgress();
        if (!renderProcessGone || (imeAdapter = ImeAdapterImpl.fromWebContents((WebContents) this.mWebContents)) == null) {
            return;
        }
        imeAdapter.resetAndHideKeyboard();
    }

    @CalledByNative
    private void onNativeDestroyed() {
        this.mIterator.rewind();
        while (this.mIterator.hasNext()) {
            this.mIterator.next().onDestroyed();
        }
        this.mListeners.clear();
        this.mNativeGestureListenerManager = 0L;
    }

    @CalledByNative
    private boolean filterTapOrPressEvent(int type, int x, int y) {
        if (type == 5 && offerLongPressToEmbedder()) {
            return true;
        }
        return false;
    }

    @CalledByNative
    private void updateScrollInfo(float scrollOffsetX, float scrollOffsetY, float pageScaleFactor, float minPageScaleFactor, float maxPageScaleFactor, float contentWidth, float contentHeight, float viewportWidth, float viewportHeight, float topBarShownPix, boolean topBarChanged) {
        TraceEvent.begin("GestureListenerManagerImpl:updateScrollInfo");
        RenderCoordinatesImpl rc = this.mWebContents.getRenderCoordinates();
        float deviceScale = rc.getDeviceScaleFactor();
        View containerView = this.mViewDelegate.getContainerView();
        float contentWidth2 = Math.max(contentWidth, containerView.getWidth() / (deviceScale * pageScaleFactor));
        float contentHeight2 = Math.max(contentHeight, containerView.getHeight() / (deviceScale * pageScaleFactor));
        boolean scaleLimitsChanged = (minPageScaleFactor == rc.getMinPageScaleFactor() && maxPageScaleFactor == rc.getMaxPageScaleFactor()) ? false : true;
        boolean pageScaleChanged = pageScaleFactor != rc.getPageScaleFactor();
        boolean scrollChanged = (!pageScaleChanged && scrollOffsetX == rc.getScrollX() && scrollOffsetY == rc.getScrollY()) ? false : true;
        if (scrollChanged) {
            this.mScrollDelegate.onScrollChanged((int) rc.fromLocalCssToPix(scrollOffsetX), (int) rc.fromLocalCssToPix(scrollOffsetY), (int) rc.getScrollXPix(), (int) rc.getScrollYPix());
        }
        rc.updateFrameInfo(scrollOffsetX, scrollOffsetY, contentWidth2, contentHeight2, viewportWidth, viewportHeight, pageScaleFactor, minPageScaleFactor, maxPageScaleFactor, topBarShownPix);
        if (scrollChanged || topBarChanged) {
            updateOnScrollChanged(verticalScrollOffset(), verticalScrollExtent());
        }
        if (scaleLimitsChanged) {
            updateOnScaleLimitsChanged(minPageScaleFactor, maxPageScaleFactor);
        }
        TraceEvent.end("GestureListenerManagerImpl:updateScrollInfo");
    }

    @Override // org.chromium.content_public.browser.GestureListenerManager
    public boolean isScrollInProgress() {
        return this.mIsTouchScrollInProgress || this.mHasActiveFlingScroll;
    }

    private void setTouchScrollInProgress(boolean touchScrollInProgress) {
        this.mIsTouchScrollInProgress = touchScrollInProgress;
        getSelectionPopupController().setScrollInProgress(isScrollInProgress());
    }

    private void resetScrollInProgress() {
        if (isScrollInProgress()) {
            boolean touchScrollInProgress = this.mIsTouchScrollInProgress;
            setTouchScrollInProgress(false);
            if (touchScrollInProgress) {
                updateOnScrollEnd();
            }
            resetFlingGesture();
        }
    }

    private SelectionPopupControllerImpl getSelectionPopupController() {
        return SelectionPopupControllerImpl.fromWebContents((WebContents) this.mWebContents);
    }

    private boolean offerLongPressToEmbedder() {
        return this.mViewDelegate.getContainerView().performLongClick();
    }

    private int verticalScrollOffset() {
        return this.mWebContents.getRenderCoordinates().getScrollYPixInt();
    }

    private int verticalScrollExtent() {
        return this.mWebContents.getRenderCoordinates().getLastFrameViewportHeightPixInt();
    }
}
