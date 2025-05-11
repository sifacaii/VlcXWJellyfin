package org.chromium.content.browser.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.chromium.base.UserData;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.blink_public.web.WebInputEventModifier;
import org.chromium.content.browser.RenderCoordinatesImpl;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.WindowEventObserverManager;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;
import org.chromium.content.browser.accessibility.captioning.CaptioningController;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.AccessibilitySnapshotCallback;
import org.chromium.content_public.browser.AccessibilitySnapshotNode;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsAccessibility;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/WebContentsAccessibilityImpl.class */
public class WebContentsAccessibilityImpl extends AccessibilityNodeProvider implements AccessibilityManager.AccessibilityStateChangeListener, WebContentsAccessibility, WindowEventObserver, UserData {
    private static final int ACTION_COLLAPSE = 524288;
    private static final int ACTION_EXPAND = 262144;
    private static final int ACTION_SET_TEXT = 2097152;
    private static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    private static final int WINDOW_CONTENT_CHANGED_DELAY_MS = 500;
    protected static final int ACTION_CONTEXT_CLICK = 16908348;
    protected static final int ACTION_SHOW_ON_SCREEN = 16908342;
    protected static final int ACTION_SCROLL_UP = 16908344;
    protected static final int ACTION_SCROLL_DOWN = 16908346;
    protected static final int ACTION_SCROLL_LEFT = 16908345;
    protected static final int ACTION_SCROLL_RIGHT = 16908347;
    private static final int NO_GRANULARITY_SELECTED = 0;
    private final WebContentsImpl mWebContents;
    protected AccessibilityManager mAccessibilityManager;
    protected final Context mContext;
    private String mProductVersion;
    protected long mNativeObj;
    private Rect mAccessibilityFocusRect;
    private boolean mIsHovering;
    protected int mCurrentRootId;
    protected ViewGroup mView;
    private boolean mUserHasTouchExplored;
    private boolean mPendingScrollToMakeNodeVisible;
    private boolean mNotifyFrameInfoInitializedCalled;
    private boolean mAccessibilityEnabledForTesting;
    private int mSelectionGranularity;
    private int mSelectionStartIndex;
    private int mSelectionEndIndex;
    protected int mAccessibilityFocusId;
    protected int mSelectionNodeId;
    private Runnable mSendWindowContentChangedRunnable;
    private View mAutofillPopupView;
    private CaptioningController mCaptioningController;
    private boolean mNativeAccessibilityAllowed;
    private boolean mShouldFocusOnPageLoad;
    private boolean mIsObscuredByAnotherView;
    private boolean mTouchExplorationEnabled;
    private int mLastHoverId = -1;
    private int[] mTempLocation = new int[2];

    private native long nativeInit(WebContents webContents);

    private native void nativeOnAutofillPopupDisplayed(long j);

    private native void nativeOnAutofillPopupDismissed(long j);

    private native int nativeGetIdForElementAfterElementHostingAutofillPopup(long j);

    private native int nativeGetRootId(long j);

    private native boolean nativeIsNodeValid(long j, int i);

    private native boolean nativeIsAutofillPopupNode(long j, int i);

    private native boolean nativeIsEditableText(long j, int i);

    private native boolean nativeIsFocused(long j, int i);

    private native int nativeGetEditableTextSelectionStart(long j, int i);

    private native int nativeGetEditableTextSelectionEnd(long j, int i);

    private native boolean nativePopulateAccessibilityNodeInfo(long j, AccessibilityNodeInfo accessibilityNodeInfo, int i);

    private native boolean nativePopulateAccessibilityEvent(long j, AccessibilityEvent accessibilityEvent, int i, int i2);

    private native void nativeClick(long j, int i);

    private native void nativeFocus(long j, int i);

    private native void nativeBlur(long j);

    private native void nativeScrollToMakeNodeVisible(long j, int i);

    private native int nativeFindElementType(long j, int i, String str, boolean z);

    private native void nativeSetTextFieldValue(long j, int i, String str);

    private native void nativeSetSelection(long j, int i, int i2, int i3);

    private native boolean nativeNextAtGranularity(long j, int i, boolean z, int i2, int i3);

    private native boolean nativePreviousAtGranularity(long j, int i, boolean z, int i2, int i3);

    private native boolean nativeAdjustSlider(long j, int i, boolean z);

    private native void nativeMoveAccessibilityFocus(long j, int i, int i2);

    private native boolean nativeIsSlider(long j, int i);

    private native boolean nativeScroll(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public native String nativeGetSupportedHtmlElementTypes(long j);

    private native void nativeShowContextMenu(long j, int i);

    private native boolean nativeIsEnabled(long j);

    private native void nativeEnable(long j);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean nativeAreInlineTextBoxesLoaded(long j, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeLoadInlineTextBoxes(long j, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public native int[] nativeGetCharacterBoundingBoxes(long j, int i, int i2, int i3);

    private native int nativeGetTextLength(long j, int i);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/WebContentsAccessibilityImpl$Factory.class */
    private static class Factory implements WebContentsImpl.UserDataFactory<WebContentsAccessibilityImpl> {
        private Factory() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.content.browser.webcontents.WebContentsImpl.UserDataFactory
        public WebContentsAccessibilityImpl create(WebContents webContents) {
            if (Build.VERSION.SDK_INT >= 26) {
                return new OWebContentsAccessibility(webContents);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return new LollipopWebContentsAccessibility(webContents);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new KitKatWebContentsAccessibility(webContents);
            }
            return new WebContentsAccessibilityImpl(webContents);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/WebContentsAccessibilityImpl$UserDataFactoryLazyHolder.class */
    private static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<WebContentsAccessibilityImpl> INSTANCE = new Factory();

        private UserDataFactoryLazyHolder() {
        }
    }

    public static WebContentsAccessibilityImpl fromWebContents(WebContents webContents) {
        return (WebContentsAccessibilityImpl) ((WebContentsImpl) webContents).getOrSetUserData(WebContentsAccessibilityImpl.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WebContentsAccessibilityImpl(WebContents webContents) {
        this.mWebContents = (WebContentsImpl) webContents;
        this.mView = this.mWebContents.getViewAndroidDelegate().getContainerView();
        this.mContext = this.mView.getContext();
        this.mProductVersion = this.mWebContents.getProductVersion();
        this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        this.mCaptioningController = new CaptioningController(this.mWebContents);
        WindowEventObserverManager.from(this.mWebContents).addObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNativeInit() {
        this.mAccessibilityFocusId = -1;
        this.mSelectionNodeId = -1;
        this.mIsHovering = false;
        this.mCurrentRootId = -1;
    }

    @CalledByNative
    protected void onNativeObjectDestroyed() {
        this.mNativeObj = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNativeInitialized() {
        return this.mNativeObj != 0;
    }

    private boolean isEnabled() {
        if (isNativeInitialized()) {
            return nativeIsEnabled(this.mNativeObj);
        }
        return false;
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    @VisibleForTesting
    public void setAccessibilityEnabledForTesting() {
        this.mAccessibilityEnabledForTesting = true;
    }

    public void onDetachedFromWindow() {
        this.mAccessibilityManager.removeAccessibilityStateChangeListener(this);
        this.mCaptioningController.stopListening();
    }

    public void onAttachedToWindow() {
        this.mAccessibilityManager.addAccessibilityStateChangeListener(this);
        refreshState();
        this.mCaptioningController.startListening();
    }

    public void refreshState() {
        setState(this.mAccessibilityManager.isEnabled());
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.mIsObscuredByAnotherView) {
            return null;
        }
        if (!isNativeInitialized()) {
            if (!this.mNativeAccessibilityAllowed) {
                return null;
            }
            this.mNativeObj = nativeInit(this.mWebContents);
            onNativeInit();
        }
        if (!isEnabled()) {
            nativeEnable(this.mNativeObj);
            return null;
        }
        return this;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
        if (!isAccessibilityEnabled()) {
            return null;
        }
        int rootId = nativeGetRootId(this.mNativeObj);
        if (virtualViewId == -1) {
            return createNodeForHost(rootId);
        }
        if (!isFrameInfoInitialized()) {
            return null;
        }
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(this.mView);
        info.setPackageName(this.mContext.getPackageName());
        info.setSource(this.mView, virtualViewId);
        if (virtualViewId == rootId) {
            info.setParent(this.mView);
        }
        if (nativePopulateAccessibilityNodeInfo(this.mNativeObj, info, virtualViewId)) {
            return info;
        }
        info.recycle();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text, int virtualViewId) {
        return new ArrayList();
    }

    private static boolean isValidMovementGranularity(int granularity) {
        switch (granularity) {
            case 1:
            case 2:
            case 4:
                return true;
            case 3:
            default:
                return false;
        }
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean enabled) {
        setState(enabled);
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public void setObscuredByAnotherView(boolean isObscured) {
        if (isObscured != this.mIsObscuredByAnotherView) {
            this.mIsObscuredByAnotherView = isObscured;
            this.mView.sendAccessibilityEvent(2048);
        }
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public boolean isTouchExplorationEnabled() {
        return this.mTouchExplorationEnabled;
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public void setState(boolean state) {
        if (!state) {
            this.mNativeAccessibilityAllowed = false;
            this.mTouchExplorationEnabled = false;
            return;
        }
        this.mNativeAccessibilityAllowed = true;
        this.mTouchExplorationEnabled = this.mAccessibilityManager.isTouchExplorationEnabled();
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public void setShouldFocusOnPageLoad(boolean on) {
        this.mShouldFocusOnPageLoad = on;
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public boolean supportsAction(int action) {
        return false;
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public boolean performAction(int action, Bundle arguments) {
        return false;
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    @TargetApi(23)
    public void onProvideVirtualStructure(ViewStructure structure, final boolean ignoreScrollOffset) {
        if (this.mWebContents.isIncognito()) {
            structure.setChildCount(0);
            return;
        }
        structure.setChildCount(1);
        final ViewStructure viewRoot = structure.asyncNewChild(0);
        this.mWebContents.requestAccessibilitySnapshot(new AccessibilitySnapshotCallback() { // from class: org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.1
            @Override // org.chromium.content_public.browser.AccessibilitySnapshotCallback
            public void onAccessibilitySnapshot(AccessibilitySnapshotNode root) {
                viewRoot.setClassName(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE);
                viewRoot.setHint(WebContentsAccessibilityImpl.this.mProductVersion);
                if (root != null) {
                    WebContentsAccessibilityImpl.this.createVirtualStructure(viewRoot, root, ignoreScrollOffset);
                } else {
                    viewRoot.asyncCommit();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void createVirtualStructure(ViewStructure viewNode, AccessibilitySnapshotNode node, boolean ignoreScrollOffset) {
        viewNode.setClassName(node.className);
        if (node.hasSelection) {
            viewNode.setText(node.text, node.startSelection, node.endSelection);
        } else {
            viewNode.setText(node.text);
        }
        RenderCoordinatesImpl renderCoordinates = this.mWebContents.getRenderCoordinates();
        int left = (int) renderCoordinates.fromLocalCssToPix(node.x);
        int top = (int) renderCoordinates.fromLocalCssToPix(node.y);
        int width = (int) renderCoordinates.fromLocalCssToPix(node.width);
        int height = (int) renderCoordinates.fromLocalCssToPix(node.height);
        Rect boundsInParent = new Rect(left, top, left + width, top + height);
        if (node.isRootNode) {
            boundsInParent.offset(0, (int) renderCoordinates.getContentOffsetYPix());
            if (!ignoreScrollOffset) {
                boundsInParent.offset(-((int) renderCoordinates.getScrollXPix()), -((int) renderCoordinates.getScrollYPix()));
            }
        }
        viewNode.setDimens(boundsInParent.left, boundsInParent.top, 0, 0, width, height);
        viewNode.setChildCount(node.children.size());
        if (node.hasStyle) {
            float textSize = renderCoordinates.fromLocalCssToPix(node.textSize);
            int style = (node.bold ? 1 : 0) | (node.italic ? 2 : 0) | (node.underline ? 4 : 0) | (node.lineThrough ? 8 : 0);
            viewNode.setTextStyle(textSize, node.color, node.bgcolor, style);
        }
        for (int i = 0; i < node.children.size(); i++) {
            createVirtualStructure(viewNode.asyncNewChild(i), node.children.get(i), true);
        }
        viewNode.asyncCommit();
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int virtualViewId, int action, Bundle arguments) {
        String newText;
        String elementType;
        String elementType2;
        if (!isAccessibilityEnabled() || !nativeIsNodeValid(this.mNativeObj, virtualViewId)) {
            return false;
        }
        switch (action) {
            case 1:
                if (!this.mView.hasFocus()) {
                    this.mView.requestFocus();
                }
                nativeFocus(this.mNativeObj, virtualViewId);
                return true;
            case 2:
                nativeBlur(this.mNativeObj);
                return true;
            case 16:
                if (!this.mView.hasFocus()) {
                    this.mView.requestFocus();
                }
                nativeClick(this.mNativeObj, virtualViewId);
                return true;
            case 64:
                if (moveAccessibilityFocusToId(virtualViewId)) {
                    if (!this.mIsHovering) {
                        nativeScrollToMakeNodeVisible(this.mNativeObj, this.mAccessibilityFocusId);
                        return true;
                    }
                    this.mPendingScrollToMakeNodeVisible = true;
                    return true;
                }
                return true;
            case 128:
                sendAccessibilityEvent(virtualViewId, 65536);
                if (this.mAccessibilityFocusId == virtualViewId) {
                    nativeMoveAccessibilityFocus(this.mNativeObj, this.mAccessibilityFocusId, -1);
                    this.mAccessibilityFocusId = -1;
                    this.mAccessibilityFocusRect = null;
                    return true;
                }
                return true;
            case 256:
                if (arguments == null) {
                    return false;
                }
                int granularity = arguments.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
                boolean extend = arguments.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
                if (!isValidMovementGranularity(granularity)) {
                    return false;
                }
                return nextAtGranularity(granularity, extend, virtualViewId);
            case 512:
                if (arguments == null) {
                    return false;
                }
                int granularity2 = arguments.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
                boolean extend2 = arguments.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
                if (!isValidMovementGranularity(granularity2)) {
                    return false;
                }
                return previousAtGranularity(granularity2, extend2, virtualViewId);
            case 1024:
                if (arguments == null || (elementType2 = arguments.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING")) == null) {
                    return false;
                }
                return jumpToElementType(virtualViewId, elementType2.toUpperCase(Locale.US), true);
            case 2048:
                if (arguments == null || (elementType = arguments.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING")) == null) {
                    return false;
                }
                return jumpToElementType(virtualViewId, elementType.toUpperCase(Locale.US), false);
            case 4096:
                return scrollForward(virtualViewId);
            case 8192:
                return scrollBackward(virtualViewId);
            case 16384:
                if (this.mWebContents != null) {
                    this.mWebContents.copy();
                    return true;
                }
                return false;
            case 32768:
                if (this.mWebContents != null) {
                    this.mWebContents.paste();
                    return true;
                }
                return false;
            case 65536:
                if (this.mWebContents != null) {
                    this.mWebContents.cut();
                    return true;
                }
                return false;
            case WebInputEventModifier.SYMBOL_KEY /* 131072 */:
                if (nativeIsEditableText(this.mNativeObj, virtualViewId)) {
                    int selectionStart = 0;
                    int selectionEnd = 0;
                    if (arguments != null) {
                        selectionStart = arguments.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
                        selectionEnd = arguments.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
                    }
                    nativeSetSelection(this.mNativeObj, virtualViewId, selectionStart, selectionEnd);
                    return true;
                }
                return false;
            case 262144:
            case 524288:
                nativeClick(this.mNativeObj, virtualViewId);
                return true;
            case 2097152:
                if (!nativeIsEditableText(this.mNativeObj, virtualViewId) || arguments == null || (newText = arguments.getString(ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE)) == null) {
                    return false;
                }
                nativeSetTextFieldValue(this.mNativeObj, virtualViewId, newText);
                nativeSetSelection(this.mNativeObj, virtualViewId, newText.length(), newText.length());
                return true;
            case ACTION_SHOW_ON_SCREEN /* 16908342 */:
                nativeScrollToMakeNodeVisible(this.mNativeObj, virtualViewId);
                return true;
            case ACTION_SCROLL_UP /* 16908344 */:
                return nativeScroll(this.mNativeObj, virtualViewId, 2);
            case ACTION_SCROLL_LEFT /* 16908345 */:
                return nativeScroll(this.mNativeObj, virtualViewId, 4);
            case ACTION_SCROLL_DOWN /* 16908346 */:
                return nativeScroll(this.mNativeObj, virtualViewId, 3);
            case ACTION_SCROLL_RIGHT /* 16908347 */:
                return nativeScroll(this.mNativeObj, virtualViewId, 5);
            case ACTION_CONTEXT_CLICK /* 16908348 */:
                nativeShowContextMenu(this.mNativeObj, virtualViewId);
                return true;
            default:
                return false;
        }
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public void onAutofillPopupDisplayed(View autofillPopupView) {
        if (isAccessibilityEnabled()) {
            this.mAutofillPopupView = autofillPopupView;
            nativeOnAutofillPopupDisplayed(this.mNativeObj);
        }
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public void onAutofillPopupDismissed() {
        if (isAccessibilityEnabled()) {
            nativeOnAutofillPopupDismissed(this.mNativeObj);
            this.mAutofillPopupView = null;
        }
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public void onAutofillPopupAccessibilityFocusCleared() {
        int id;
        if (!isAccessibilityEnabled() || (id = nativeGetIdForElementAfterElementHostingAutofillPopup(this.mNativeObj)) == 0) {
            return;
        }
        moveAccessibilityFocusToId(id);
        nativeScrollToMakeNodeVisible(this.mNativeObj, this.mAccessibilityFocusId);
    }

    @CalledByNative
    private boolean onHoverEvent(int action) {
        if (!isAccessibilityEnabled()) {
            return false;
        }
        if (action == 10) {
            this.mIsHovering = false;
            if (this.mLastHoverId != -1) {
                sendAccessibilityEvent(this.mLastHoverId, 256);
                this.mLastHoverId = -1;
            }
            if (this.mPendingScrollToMakeNodeVisible) {
                nativeScrollToMakeNodeVisible(this.mNativeObj, this.mAccessibilityFocusId);
            }
            this.mPendingScrollToMakeNodeVisible = false;
            return true;
        }
        this.mIsHovering = true;
        this.mUserHasTouchExplored = true;
        return true;
    }

    @CalledByNative
    private void notifyFrameInfoInitialized() {
        if (this.mNotifyFrameInfoInitializedCalled) {
            return;
        }
        this.mNotifyFrameInfoInitializedCalled = true;
        sendWindowContentChangedOnView();
        if (this.mShouldFocusOnPageLoad && this.mAccessibilityFocusId != -1) {
            moveAccessibilityFocusToIdAndRefocusIfNeeded(this.mAccessibilityFocusId);
        }
    }

    private boolean jumpToElementType(int virtualViewId, String elementType, boolean forwards) {
        int id = nativeFindElementType(this.mNativeObj, virtualViewId, elementType, forwards);
        if (id == 0) {
            return false;
        }
        moveAccessibilityFocusToId(id);
        nativeScrollToMakeNodeVisible(this.mNativeObj, this.mAccessibilityFocusId);
        return true;
    }

    private void setGranularityAndUpdateSelection(int granularity) {
        this.mSelectionGranularity = granularity;
        if (this.mSelectionGranularity == 0) {
            this.mSelectionStartIndex = -1;
            this.mSelectionEndIndex = -1;
        }
        if (nativeIsEditableText(this.mNativeObj, this.mAccessibilityFocusId) && nativeIsFocused(this.mNativeObj, this.mAccessibilityFocusId)) {
            this.mSelectionStartIndex = nativeGetEditableTextSelectionStart(this.mNativeObj, this.mAccessibilityFocusId);
            this.mSelectionEndIndex = nativeGetEditableTextSelectionEnd(this.mNativeObj, this.mAccessibilityFocusId);
        }
    }

    private boolean nextAtGranularity(int granularity, boolean extendSelection, int virtualViewId) {
        if (virtualViewId != this.mSelectionNodeId) {
            return false;
        }
        setGranularityAndUpdateSelection(granularity);
        return nativeNextAtGranularity(this.mNativeObj, this.mSelectionGranularity, extendSelection, virtualViewId, this.mSelectionStartIndex);
    }

    private boolean previousAtGranularity(int granularity, boolean extendSelection, int virtualViewId) {
        if (virtualViewId != this.mSelectionNodeId) {
            return false;
        }
        setGranularityAndUpdateSelection(granularity);
        return nativePreviousAtGranularity(this.mNativeObj, this.mSelectionGranularity, extendSelection, virtualViewId, this.mSelectionEndIndex);
    }

    @CalledByNative
    private void finishGranularityMove(String text, boolean extendSelection, int itemStartIndex, int itemEndIndex, boolean forwards) {
        AccessibilityEvent selectionEvent = buildAccessibilityEvent(this.mSelectionNodeId, 8192);
        if (selectionEvent == null) {
            return;
        }
        AccessibilityEvent traverseEvent = buildAccessibilityEvent(this.mSelectionNodeId, WebInputEventModifier.SYMBOL_KEY);
        if (traverseEvent == null) {
            selectionEvent.recycle();
            return;
        }
        if (forwards) {
            this.mSelectionEndIndex = itemEndIndex;
        } else {
            this.mSelectionEndIndex = itemStartIndex;
        }
        if (!extendSelection) {
            this.mSelectionStartIndex = this.mSelectionEndIndex;
        }
        if (nativeIsEditableText(this.mNativeObj, this.mSelectionNodeId) && nativeIsFocused(this.mNativeObj, this.mSelectionNodeId)) {
            nativeSetSelection(this.mNativeObj, this.mSelectionNodeId, this.mSelectionStartIndex, this.mSelectionEndIndex);
        }
        selectionEvent.setFromIndex(this.mSelectionStartIndex);
        selectionEvent.setToIndex(this.mSelectionStartIndex);
        selectionEvent.setItemCount(text.length());
        if (forwards && nativeIsEditableText(this.mNativeObj, this.mSelectionNodeId)) {
            traverseEvent.setFromIndex(itemStartIndex - 1);
            traverseEvent.setToIndex(itemEndIndex - 1);
        } else {
            traverseEvent.setFromIndex(itemStartIndex);
            traverseEvent.setToIndex(itemEndIndex);
        }
        traverseEvent.setItemCount(text.length());
        traverseEvent.setMovementGranularity(this.mSelectionGranularity);
        traverseEvent.setContentDescription(text);
        if (forwards) {
            traverseEvent.setAction(256);
        } else {
            traverseEvent.setAction(512);
        }
        this.mView.requestSendAccessibilityEvent(this.mView, selectionEvent);
        this.mView.requestSendAccessibilityEvent(this.mView, traverseEvent);
    }

    private boolean scrollForward(int virtualViewId) {
        if (nativeIsSlider(this.mNativeObj, virtualViewId)) {
            return nativeAdjustSlider(this.mNativeObj, virtualViewId, true);
        }
        return nativeScroll(this.mNativeObj, virtualViewId, 0);
    }

    private boolean scrollBackward(int virtualViewId) {
        if (nativeIsSlider(this.mNativeObj, virtualViewId)) {
            return nativeAdjustSlider(this.mNativeObj, virtualViewId, false);
        }
        return nativeScroll(this.mNativeObj, virtualViewId, 1);
    }

    private boolean moveAccessibilityFocusToId(int newAccessibilityFocusId) {
        if (newAccessibilityFocusId == this.mAccessibilityFocusId) {
            return false;
        }
        nativeMoveAccessibilityFocus(this.mNativeObj, this.mAccessibilityFocusId, newAccessibilityFocusId);
        this.mAccessibilityFocusId = newAccessibilityFocusId;
        this.mAccessibilityFocusRect = null;
        this.mSelectionNodeId = this.mAccessibilityFocusId;
        this.mSelectionGranularity = 0;
        this.mSelectionStartIndex = -1;
        this.mSelectionEndIndex = nativeGetTextLength(this.mNativeObj, newAccessibilityFocusId);
        if (nativeIsAutofillPopupNode(this.mNativeObj, this.mAccessibilityFocusId)) {
            this.mAutofillPopupView.requestFocus();
        }
        sendAccessibilityEvent(this.mAccessibilityFocusId, 32768);
        return true;
    }

    private void moveAccessibilityFocusToIdAndRefocusIfNeeded(int newAccessibilityFocusId) {
        if (newAccessibilityFocusId == this.mAccessibilityFocusId) {
            sendAccessibilityEvent(newAccessibilityFocusId, 65536);
            this.mAccessibilityFocusId = -1;
        }
        moveAccessibilityFocusToId(newAccessibilityFocusId);
    }

    @CalledByNative
    private void sendDelayedWindowContentChangedEvent() {
        if (this.mSendWindowContentChangedRunnable != null) {
            return;
        }
        this.mSendWindowContentChangedRunnable = new Runnable() { // from class: org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.2
            @Override // java.lang.Runnable
            public void run() {
                WebContentsAccessibilityImpl.this.sendWindowContentChangedOnView();
            }
        };
        this.mView.postDelayed(this.mSendWindowContentChangedRunnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWindowContentChangedOnView() {
        if (this.mSendWindowContentChangedRunnable != null) {
            this.mView.removeCallbacks(this.mSendWindowContentChangedRunnable);
            this.mSendWindowContentChangedRunnable = null;
        }
        this.mView.sendAccessibilityEvent(2048);
    }

    private void sendWindowContentChangedOnVirtualView(int virtualViewId) {
        sendAccessibilityEvent(virtualViewId, 2048);
    }

    private void sendAccessibilityEvent(int virtualViewId, int eventType) {
        if (virtualViewId == -1) {
            this.mView.sendAccessibilityEvent(eventType);
            return;
        }
        AccessibilityEvent event = buildAccessibilityEvent(virtualViewId, eventType);
        if (event != null) {
            this.mView.requestSendAccessibilityEvent(this.mView, event);
        }
    }

    private AccessibilityEvent buildAccessibilityEvent(int virtualViewId, int eventType) {
        if (!isAccessibilityEnabled() || !isFrameInfoInitialized()) {
            return null;
        }
        this.mView.postInvalidate();
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        event.setPackageName(this.mContext.getPackageName());
        event.setSource(this.mView, virtualViewId);
        if (!nativePopulateAccessibilityEvent(this.mNativeObj, event, virtualViewId, eventType)) {
            event.recycle();
            return null;
        }
        return event;
    }

    private Bundle getOrCreateBundleForAccessibilityEvent(AccessibilityEvent event) {
        Bundle bundle = (Bundle) event.getParcelableData();
        if (bundle == null) {
            bundle = new Bundle();
            event.setParcelableData(bundle);
        }
        return bundle;
    }

    @Override // org.chromium.content_public.browser.WebContentsAccessibility
    public boolean isAccessibilityEnabled() {
        return isNativeInitialized() && (this.mAccessibilityEnabledForTesting || this.mAccessibilityManager.isEnabled());
    }

    private AccessibilityNodeInfo createNodeForHost(int rootId) {
        AccessibilityNodeInfo result = AccessibilityNodeInfo.obtain(this.mView);
        AccessibilityNodeInfo source = AccessibilityNodeInfo.obtain(this.mView);
        this.mView.onInitializeAccessibilityNodeInfo(source);
        Rect rect = new Rect();
        source.getBoundsInParent(rect);
        result.setBoundsInParent(rect);
        source.getBoundsInScreen(rect);
        result.setBoundsInScreen(rect);
        ViewParent parent = this.mView.getParentForAccessibility();
        if (parent instanceof View) {
            result.setParent((View) parent);
        }
        result.setVisibleToUser(source.isVisibleToUser());
        result.setEnabled(source.isEnabled());
        result.setPackageName(source.getPackageName());
        result.setClassName(source.getClassName());
        if (isFrameInfoInitialized()) {
            result.addChild(this.mView, rootId);
        }
        return result;
    }

    private boolean isFrameInfoInitialized() {
        if (this.mWebContents == null) {
            return true;
        }
        RenderCoordinatesImpl rc = this.mWebContents.getRenderCoordinates();
        return (((double) rc.getContentWidthCss()) == 0.0d && ((double) rc.getContentHeightCss()) == 0.0d) ? false : true;
    }

    @CalledByNative
    private void handlePageLoaded(int id) {
        if (this.mShouldFocusOnPageLoad && !this.mUserHasTouchExplored) {
            moveAccessibilityFocusToIdAndRefocusIfNeeded(id);
        }
    }

    @CalledByNative
    private void handleFocusChanged(int id) {
        if (this.mShouldFocusOnPageLoad || this.mAccessibilityFocusId != -1) {
            sendAccessibilityEvent(id, 8);
            moveAccessibilityFocusToId(id);
        }
    }

    @CalledByNative
    private void handleCheckStateChanged(int id) {
        sendAccessibilityEvent(id, 1);
    }

    @CalledByNative
    private void handleClicked(int id) {
        sendAccessibilityEvent(id, 1);
    }

    @CalledByNative
    private void handleTextSelectionChanged(int id) {
        sendAccessibilityEvent(id, 8192);
    }

    @CalledByNative
    private void handleEditableTextChanged(int id) {
        sendAccessibilityEvent(id, 16);
    }

    @CalledByNative
    private void handleSliderChanged(int id) {
        sendAccessibilityEvent(id, 4096);
    }

    @CalledByNative
    private void handleContentChanged(int id) {
        int rootId = nativeGetRootId(this.mNativeObj);
        if (rootId != this.mCurrentRootId) {
            this.mCurrentRootId = rootId;
            sendWindowContentChangedOnView();
            return;
        }
        sendWindowContentChangedOnVirtualView(id);
    }

    @CalledByNative
    private void handleNavigate() {
        this.mAccessibilityFocusId = -1;
        this.mAccessibilityFocusRect = null;
        this.mUserHasTouchExplored = false;
        sendWindowContentChangedOnView();
    }

    @CalledByNative
    private void handleScrollPositionChanged(int id) {
        sendAccessibilityEvent(id, 4096);
    }

    @CalledByNative
    private void handleScrolledToAnchor(int id) {
        moveAccessibilityFocusToId(id);
    }

    @CalledByNative
    private void handleHover(int id) {
        if (this.mLastHoverId != id && this.mIsHovering) {
            sendAccessibilityEvent(id, 128);
            if (this.mLastHoverId != -1) {
                sendAccessibilityEvent(this.mLastHoverId, 256);
            }
            this.mLastHoverId = id;
        }
    }

    @CalledByNative
    private void announceLiveRegionText(String text) {
        this.mView.announceForAccessibility(text);
    }

    @CalledByNative
    private void setAccessibilityNodeInfoParent(AccessibilityNodeInfo node, int parentId) {
        node.setParent(this.mView, parentId);
    }

    @CalledByNative
    private void addAccessibilityNodeInfoChild(AccessibilityNodeInfo node, int childId) {
        node.addChild(this.mView, childId);
    }

    @CalledByNative
    private void setAccessibilityNodeInfoBooleanAttributes(AccessibilityNodeInfo node, int virtualViewId, boolean checkable, boolean checked, boolean clickable, boolean enabled, boolean focusable, boolean focused, boolean password, boolean scrollable, boolean selected, boolean visibleToUser) {
        node.setCheckable(checkable);
        node.setChecked(checked);
        node.setClickable(clickable);
        node.setEnabled(enabled);
        node.setFocusable(focusable);
        node.setFocused(focused);
        node.setPassword(password);
        node.setScrollable(scrollable);
        node.setSelected(selected);
        node.setVisibleToUser(visibleToUser);
        node.setMovementGranularities(7);
        if (this.mAccessibilityFocusId == virtualViewId) {
            node.setAccessibilityFocused(true);
        } else {
            node.setAccessibilityFocused(false);
        }
    }

    protected void addAction(AccessibilityNodeInfo node, int actionId) {
        if (actionId > 2097152) {
            return;
        }
        node.addAction(actionId);
    }

    @CalledByNative
    private void addAccessibilityNodeInfoActions(AccessibilityNodeInfo node, int virtualViewId, boolean canScrollForward, boolean canScrollBackward, boolean canScrollUp, boolean canScrollDown, boolean canScrollLeft, boolean canScrollRight, boolean clickable, boolean editableText, boolean enabled, boolean focusable, boolean focused, boolean isCollapsed, boolean isExpanded, boolean hasNonEmptyValue) {
        addAction(node, 1024);
        addAction(node, 2048);
        addAction(node, 256);
        addAction(node, 512);
        addAction(node, ACTION_SHOW_ON_SCREEN);
        addAction(node, ACTION_CONTEXT_CLICK);
        if (editableText && enabled) {
            addAction(node, 2097152);
            addAction(node, 32768);
            if (hasNonEmptyValue) {
                addAction(node, WebInputEventModifier.SYMBOL_KEY);
                addAction(node, 65536);
                addAction(node, 16384);
            }
        }
        if (canScrollForward) {
            addAction(node, 4096);
        }
        if (canScrollBackward) {
            addAction(node, 8192);
        }
        if (canScrollUp) {
            addAction(node, ACTION_SCROLL_UP);
        }
        if (canScrollDown) {
            addAction(node, ACTION_SCROLL_DOWN);
        }
        if (canScrollLeft) {
            addAction(node, ACTION_SCROLL_LEFT);
        }
        if (canScrollRight) {
            addAction(node, ACTION_SCROLL_RIGHT);
        }
        if (focusable) {
            if (focused) {
                addAction(node, 2);
            } else {
                addAction(node, 1);
            }
        }
        if (this.mAccessibilityFocusId == virtualViewId) {
            addAction(node, 128);
        } else {
            addAction(node, 64);
        }
        if (clickable) {
            addAction(node, 16);
        }
        if (isCollapsed) {
            addAction(node, 262144);
        }
        if (isExpanded) {
            addAction(node, 524288);
        }
    }

    @CalledByNative
    private void setAccessibilityNodeInfoClassName(AccessibilityNodeInfo node, String className) {
        node.setClassName(className);
    }

    @SuppressLint({"NewApi"})
    @CalledByNative
    private void setAccessibilityNodeInfoText(AccessibilityNodeInfo node, String text, boolean annotateAsLink, boolean isEditableText, String language) {
        CharSequence computedText = computeText(text, isEditableText, language);
        node.setText(computedText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CharSequence computeText(String text, boolean annotateAsLink, String language) {
        if (annotateAsLink) {
            SpannableString spannable = new SpannableString(text);
            spannable.setSpan(new URLSpan(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE), 0, spannable.length(), 0);
            return spannable;
        }
        return text;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convertWebRectToAndroidCoordinates(Rect rect) {
        RenderCoordinatesImpl rc = this.mWebContents.getRenderCoordinates();
        rect.offset(-((int) rc.getScrollX()), -((int) rc.getScrollY()));
        rect.left = (int) rc.fromLocalCssToPix(rect.left);
        rect.top = (int) rc.fromLocalCssToPix(rect.top);
        rect.bottom = (int) rc.fromLocalCssToPix(rect.bottom);
        rect.right = (int) rc.fromLocalCssToPix(rect.right);
        rect.offset(0, (int) rc.getContentOffsetYPix());
        int[] viewLocation = new int[2];
        this.mView.getLocationOnScreen(viewLocation);
        rect.offset(viewLocation[0], viewLocation[1]);
        int viewportRectTop = viewLocation[1] + ((int) rc.getContentOffsetYPix());
        int viewportRectBottom = viewportRectTop + this.mView.getHeight();
        if (rect.top < viewportRectTop) {
            rect.top = viewportRectTop;
        }
        if (rect.bottom > viewportRectBottom) {
            rect.bottom = viewportRectBottom;
        }
    }

    @CalledByNative
    private void setAccessibilityNodeInfoLocation(AccessibilityNodeInfo node, int virtualViewId, int absoluteLeft, int absoluteTop, int parentRelativeLeft, int parentRelativeTop, int width, int height, boolean isRootNode) {
        Rect boundsInParent = new Rect(parentRelativeLeft, parentRelativeTop, parentRelativeLeft + width, parentRelativeTop + height);
        if (isRootNode) {
            RenderCoordinatesImpl rc = this.mWebContents.getRenderCoordinates();
            boundsInParent.offset(0, (int) rc.getContentOffsetYPix());
        }
        node.setBoundsInParent(boundsInParent);
        Rect rect = new Rect(absoluteLeft, absoluteTop, absoluteLeft + width, absoluteTop + height);
        convertWebRectToAndroidCoordinates(rect);
        node.setBoundsInScreen(rect);
        if (virtualViewId == this.mAccessibilityFocusId && virtualViewId != this.mCurrentRootId) {
            if (this.mAccessibilityFocusRect == null) {
                this.mAccessibilityFocusRect = rect;
            } else if (!this.mAccessibilityFocusRect.equals(rect)) {
                this.mAccessibilityFocusRect = rect;
                moveAccessibilityFocusToIdAndRefocusIfNeeded(virtualViewId);
            }
        }
    }

    @CalledByNative
    protected void setAccessibilityNodeInfoKitKatAttributes(AccessibilityNodeInfo node, boolean isRoot, boolean isEditableText, String role, String roleDescription, String hint, int selectionStartIndex, int selectionEndIndex, boolean hasImage, boolean contentInvalid) {
    }

    @CalledByNative
    protected void setAccessibilityNodeInfoLollipopAttributes(AccessibilityNodeInfo node, boolean canOpenPopup, boolean contentInvalid, boolean dismissable, boolean multiLine, int inputType, int liveRegion, String errorMessage) {
    }

    @CalledByNative
    protected void setAccessibilityNodeInfoCollectionInfo(AccessibilityNodeInfo node, int rowCount, int columnCount, boolean hierarchical) {
    }

    @CalledByNative
    protected void setAccessibilityNodeInfoCollectionItemInfo(AccessibilityNodeInfo node, int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading) {
    }

    @CalledByNative
    protected void setAccessibilityNodeInfoRangeInfo(AccessibilityNodeInfo node, int rangeType, float min, float max, float current) {
    }

    @CalledByNative
    protected void setAccessibilityNodeInfoViewIdResourceName(AccessibilityNodeInfo node, String viewIdResourceName) {
    }

    @CalledByNative
    protected void setAccessibilityNodeInfoOAttributes(AccessibilityNodeInfo node, boolean hasCharacterLocations) {
    }

    @CalledByNative
    private void setAccessibilityEventBooleanAttributes(AccessibilityEvent event, boolean checked, boolean enabled, boolean password, boolean scrollable) {
        event.setChecked(checked);
        event.setEnabled(enabled);
        event.setPassword(password);
        event.setScrollable(scrollable);
    }

    @CalledByNative
    private void setAccessibilityEventClassName(AccessibilityEvent event, String className) {
        event.setClassName(className);
    }

    @CalledByNative
    private void setAccessibilityEventListAttributes(AccessibilityEvent event, int currentItemIndex, int itemCount) {
        event.setCurrentItemIndex(currentItemIndex);
        event.setItemCount(itemCount);
    }

    @CalledByNative
    private void setAccessibilityEventScrollAttributes(AccessibilityEvent event, int scrollX, int scrollY, int maxScrollX, int maxScrollY) {
        event.setScrollX(scrollX);
        event.setScrollY(scrollY);
        event.setMaxScrollX(maxScrollX);
        event.setMaxScrollY(maxScrollY);
    }

    @CalledByNative
    private void setAccessibilityEventTextChangedAttrs(AccessibilityEvent event, int fromIndex, int addedCount, int removedCount, String beforeText, String text) {
        event.setFromIndex(fromIndex);
        event.setAddedCount(addedCount);
        event.setRemovedCount(removedCount);
        event.setBeforeText(beforeText);
        event.getText().add(text);
    }

    @CalledByNative
    private void setAccessibilityEventSelectionAttrs(AccessibilityEvent event, int fromIndex, int toIndex, int itemCount, String text) {
        event.setFromIndex(fromIndex);
        event.setToIndex(toIndex);
        event.setItemCount(itemCount);
        event.getText().add(text);
    }

    @CalledByNative
    protected void setAccessibilityEventLollipopAttributes(AccessibilityEvent event, boolean canOpenPopup, boolean contentInvalid, boolean dismissable, boolean multiLine, int inputType, int liveRegion) {
        Bundle bundle = getOrCreateBundleForAccessibilityEvent(event);
        bundle.putBoolean("AccessibilityNodeInfo.canOpenPopup", canOpenPopup);
        bundle.putBoolean("AccessibilityNodeInfo.contentInvalid", contentInvalid);
        bundle.putBoolean("AccessibilityNodeInfo.dismissable", dismissable);
        bundle.putBoolean("AccessibilityNodeInfo.multiLine", multiLine);
        bundle.putInt("AccessibilityNodeInfo.inputType", inputType);
        bundle.putInt("AccessibilityNodeInfo.liveRegion", liveRegion);
    }

    @CalledByNative
    protected void setAccessibilityEventCollectionInfo(AccessibilityEvent event, int rowCount, int columnCount, boolean hierarchical) {
        Bundle bundle = getOrCreateBundleForAccessibilityEvent(event);
        bundle.putInt("AccessibilityNodeInfo.CollectionInfo.rowCount", rowCount);
        bundle.putInt("AccessibilityNodeInfo.CollectionInfo.columnCount", columnCount);
        bundle.putBoolean("AccessibilityNodeInfo.CollectionInfo.hierarchical", hierarchical);
    }

    @CalledByNative
    protected void setAccessibilityEventHeadingFlag(AccessibilityEvent event, boolean heading) {
        Bundle bundle = getOrCreateBundleForAccessibilityEvent(event);
        bundle.putBoolean("AccessibilityNodeInfo.CollectionItemInfo.heading", heading);
    }

    @CalledByNative
    protected void setAccessibilityEventCollectionItemInfo(AccessibilityEvent event, int rowIndex, int rowSpan, int columnIndex, int columnSpan) {
        Bundle bundle = getOrCreateBundleForAccessibilityEvent(event);
        bundle.putInt("AccessibilityNodeInfo.CollectionItemInfo.rowIndex", rowIndex);
        bundle.putInt("AccessibilityNodeInfo.CollectionItemInfo.rowSpan", rowSpan);
        bundle.putInt("AccessibilityNodeInfo.CollectionItemInfo.columnIndex", columnIndex);
        bundle.putInt("AccessibilityNodeInfo.CollectionItemInfo.columnSpan", columnSpan);
    }

    @CalledByNative
    protected void setAccessibilityEventRangeInfo(AccessibilityEvent event, int rangeType, float min, float max, float current) {
        Bundle bundle = getOrCreateBundleForAccessibilityEvent(event);
        bundle.putInt("AccessibilityNodeInfo.RangeInfo.type", rangeType);
        bundle.putFloat("AccessibilityNodeInfo.RangeInfo.min", min);
        bundle.putFloat("AccessibilityNodeInfo.RangeInfo.max", max);
        bundle.putFloat("AccessibilityNodeInfo.RangeInfo.current", current);
    }

    @CalledByNative
    boolean shouldRespectDisplayedPasswordText() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @CalledByNative
    boolean shouldExposePasswordText() {
        ContentResolver contentResolver = this.mContext.getContentResolver();
        return Build.VERSION.SDK_INT >= 26 ? Settings.System.getInt(contentResolver, "show_password", 1) == 1 : Settings.Secure.getInt(contentResolver, "speak_password", 0) == 1;
    }

    @CalledByNative
    private int getAccessibilityServiceEventTypeMask() {
        int eventTypeMask = 0;
        for (AccessibilityServiceInfo service : this.mAccessibilityManager.getEnabledAccessibilityServiceList(-1)) {
            eventTypeMask |= service.eventTypes;
        }
        return eventTypeMask;
    }

    @CalledByNative
    private int getAccessibilityServiceFeedbackTypeMask() {
        int feedbackTypeMask = 0;
        for (AccessibilityServiceInfo service : this.mAccessibilityManager.getEnabledAccessibilityServiceList(-1)) {
            feedbackTypeMask |= service.feedbackType;
        }
        return feedbackTypeMask;
    }

    @CalledByNative
    private int getAccessibilityServiceFlagsMask() {
        int flagsMask = 0;
        for (AccessibilityServiceInfo service : this.mAccessibilityManager.getEnabledAccessibilityServiceList(-1)) {
            flagsMask |= service.flags;
        }
        return flagsMask;
    }

    @CalledByNative
    protected int getAccessibilityServiceCapabilitiesMask() {
        return 0;
    }
}
