package org.chromium.components.embedder_support.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.base.TraceEvent;
import org.chromium.base.compat.ApiHelperForO;
import org.chromium.content_public.browser.ImeAdapter;
import org.chromium.content_public.browser.RenderCoordinates;
import org.chromium.content_public.browser.SmartClipProvider;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsAccessibility;
import org.chromium.ui.base.EventForwarder;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/embedder_support/view/ContentView.class */
public class ContentView extends FrameLayout implements ViewEventSink.InternalAccessDelegate, SmartClipProvider, ViewGroup.OnHierarchyChangeListener, View.OnSystemUiVisibilityChangeListener {
    private static final String TAG = "cr.ContentView";
    public static final int DEFAULT_MEASURE_SPEC;
    private final WebContents mWebContents;
    private final ObserverList<ViewGroup.OnHierarchyChangeListener> mHierarchyChangeListeners;
    private final ObserverList<View.OnSystemUiVisibilityChangeListener> mSystemUiChangeListeners;
    private ViewEventSink mViewEventSink;
    private EventForwarder mEventForwarder;
    private int mDesiredWidthMeasureSpec;
    private int mDesiredHeightMeasureSpec;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ContentView.class.desiredAssertionStatus();
        DEFAULT_MEASURE_SPEC = View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    public static ContentView createContentView(Context context, WebContents webContents) {
        if (Build.VERSION.SDK_INT >= 23) {
            return new ContentViewApi23(context, webContents);
        }
        return new ContentView(context, webContents);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ContentView(Context context, WebContents webContents) {
        super(context, null, 16842885);
        this.mHierarchyChangeListeners = new ObserverList<>();
        this.mSystemUiChangeListeners = new ObserverList<>();
        this.mDesiredWidthMeasureSpec = DEFAULT_MEASURE_SPEC;
        this.mDesiredHeightMeasureSpec = DEFAULT_MEASURE_SPEC;
        if (getScrollBarStyle() == 0) {
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
        }
        this.mWebContents = webContents;
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            ApiHelperForO.setDefaultFocusHighlightEnabled(this, false);
        }
        setOnHierarchyChangeListener(this);
        setOnSystemUiVisibilityChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WebContentsAccessibility getWebContentsAccessibility() {
        if (this.mWebContents.isDestroyed()) {
            return null;
        }
        return WebContentsAccessibility.fromWebContents(this.mWebContents);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        WebContentsAccessibility wcax = getWebContentsAccessibility();
        if (wcax != null && wcax.supportsAction(action)) {
            return wcax.performAction(action, arguments);
        }
        return super.performAccessibilityAction(action, arguments);
    }

    public void setDesiredMeasureSpec(int width, int height) {
        this.mDesiredWidthMeasureSpec = width;
        this.mDesiredHeightMeasureSpec = height;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener listener) {
        if (!$assertionsDisabled && listener != this) {
            throw new AssertionError("Use add/removeOnHierarchyChangeListener instead.");
        }
        super.setOnHierarchyChangeListener(listener);
    }

    public void addOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener listener) {
        this.mHierarchyChangeListeners.addObserver(listener);
    }

    public void removeOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener listener) {
        this.mHierarchyChangeListeners.removeObserver(listener);
    }

    @Override // android.view.View
    public void setOnSystemUiVisibilityChangeListener(View.OnSystemUiVisibilityChangeListener listener) {
        if (!$assertionsDisabled && listener != this) {
            throw new AssertionError("Use add/removeOnSystemUiVisibilityChangeListener instead.");
        }
        super.setOnSystemUiVisibilityChangeListener(listener);
    }

    public void addOnSystemUiVisibilityChangeListener(View.OnSystemUiVisibilityChangeListener listener) {
        this.mSystemUiChangeListeners.addObserver(listener);
    }

    public void removeOnSystemUiVisibilityChangeListener(View.OnSystemUiVisibilityChangeListener listener) {
        this.mSystemUiChangeListeners.removeObserver(listener);
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View parent, View child) {
        Iterator<ViewGroup.OnHierarchyChangeListener> it = this.mHierarchyChangeListeners.iterator();
        while (it.hasNext()) {
            ViewGroup.OnHierarchyChangeListener listener = it.next();
            listener.onChildViewRemoved(parent, child);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View parent, View child) {
        Iterator<ViewGroup.OnHierarchyChangeListener> it = this.mHierarchyChangeListeners.iterator();
        while (it.hasNext()) {
            ViewGroup.OnHierarchyChangeListener listener = it.next();
            listener.onChildViewAdded(parent, child);
        }
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int visibility) {
        Iterator<View.OnSystemUiVisibilityChangeListener> it = this.mSystemUiChangeListeners.iterator();
        while (it.hasNext()) {
            View.OnSystemUiVisibilityChangeListener listener = it.next();
            listener.onSystemUiVisibilityChange(visibility);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mDesiredWidthMeasureSpec != DEFAULT_MEASURE_SPEC) {
            widthMeasureSpec = this.mDesiredWidthMeasureSpec;
        }
        if (this.mDesiredHeightMeasureSpec != DEFAULT_MEASURE_SPEC) {
            heightMeasureSpec = this.mDesiredHeightMeasureSpec;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        WebContentsAccessibility wcax = getWebContentsAccessibility();
        AccessibilityNodeProvider provider = wcax != null ? wcax.getAccessibilityNodeProvider() : null;
        return provider != null ? provider : super.getAccessibilityNodeProvider();
    }

    @Override // android.view.View, org.chromium.content_public.browser.ViewEventSink.InternalAccessDelegate
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        if (this.mWebContents.isDestroyed()) {
            return null;
        }
        return ImeAdapter.fromWebContents(this.mWebContents).onCreateInputConnection(outAttrs);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        if (this.mWebContents.isDestroyed()) {
            return false;
        }
        return ImeAdapter.fromWebContents(this.mWebContents).onCheckIsTextEditor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        try {
            TraceEvent.begin("ContentView.onFocusChanged");
            super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
            getViewEventSink().setHideKeyboardOnBlur(true);
            getViewEventSink().onViewFocusChanged(gainFocus);
            TraceEvent.end("ContentView.onFocusChanged");
        } catch (Throwable th) {
            TraceEvent.end("ContentView.onFocusChanged");
            throw th;
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        getViewEventSink().onWindowFocusChanged(hasWindowFocus);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return getEventForwarder().onKeyUp(keyCode, event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        return isFocused() ? getEventForwarder().dispatchKeyEvent(event) : super.dispatchKeyEvent(event);
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent event) {
        return getEventForwarder().onDragEvent(event, this);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return getEventForwarder().onTouchEvent(event);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        boolean consumed = getEventForwarder().onHoverEvent(event);
        WebContentsAccessibility wcax = getWebContentsAccessibility();
        if (wcax != null && !wcax.isTouchExplorationEnabled()) {
            super.onHoverEvent(event);
        }
        return consumed;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent event) {
        return getEventForwarder().onGenericMotionEvent(event);
    }

    private EventForwarder getEventForwarder() {
        if (this.mEventForwarder == null) {
            this.mEventForwarder = this.mWebContents.getEventForwarder();
        }
        return this.mEventForwarder;
    }

    private ViewEventSink getViewEventSink() {
        if (this.mViewEventSink == null) {
            this.mViewEventSink = ViewEventSink.from(this.mWebContents);
        }
        return this.mViewEventSink;
    }

    @Override // android.view.View
    public boolean performLongClick() {
        return false;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        getViewEventSink().onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override // android.view.View
    public void scrollBy(int x, int y) {
        getEventForwarder().scrollBy(x, y);
    }

    @Override // android.view.View
    public void scrollTo(int x, int y) {
        getEventForwarder().scrollTo(x, y);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        RenderCoordinates rc = RenderCoordinates.fromWebContents(this.mWebContents);
        if (rc != null) {
            return rc.getLastFrameViewportWidthPixInt();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        RenderCoordinates rc = RenderCoordinates.fromWebContents(this.mWebContents);
        if (rc != null) {
            return rc.getScrollXPixInt();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        RenderCoordinates rc = RenderCoordinates.fromWebContents(this.mWebContents);
        if (rc != null) {
            return rc.getContentWidthPixInt();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        RenderCoordinates rc = RenderCoordinates.fromWebContents(this.mWebContents);
        if (rc != null) {
            return rc.getLastFrameViewportHeightPixInt();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        RenderCoordinates rc = RenderCoordinates.fromWebContents(this.mWebContents);
        if (rc != null) {
            return rc.getScrollYPixInt();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeVerticalScrollRange() {
        RenderCoordinates rc = RenderCoordinates.fromWebContents(this.mWebContents);
        if (rc != null) {
            return rc.getContentHeightPixInt();
        }
        return 0;
    }

    @Override // android.view.View
    public boolean awakenScrollBars(int startDelay, boolean invalidate) {
        if (getScrollBarStyle() == 0) {
            return false;
        }
        return super.awakenScrollBars(startDelay, invalidate);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewEventSink().onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewEventSink().onDetachedFromWindow();
    }

    @Override // org.chromium.content_public.browser.SmartClipProvider
    public void extractSmartClipData(int x, int y, int width, int height) {
        this.mWebContents.requestSmartClipExtract(x, y, width, height);
    }

    @Override // org.chromium.content_public.browser.SmartClipProvider
    public void setSmartClipResultHandler(Handler resultHandler) {
        this.mWebContents.setSmartClipResultHandler(resultHandler);
    }

    @Override // org.chromium.content_public.browser.ViewEventSink.InternalAccessDelegate
    public boolean super_onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    @Override // org.chromium.content_public.browser.ViewEventSink.InternalAccessDelegate
    public boolean super_dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override // org.chromium.content_public.browser.ViewEventSink.InternalAccessDelegate
    public boolean super_onGenericMotionEvent(MotionEvent event) {
        return super.onGenericMotionEvent(event);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/embedder_support/view/ContentView$ContentViewApi23.class */
    private static class ContentViewApi23 extends ContentView {
        public ContentViewApi23(Context context, WebContents webContents) {
            super(context, webContents);
        }

        @Override // android.view.View
        public void onProvideVirtualStructure(ViewStructure structure) {
            WebContentsAccessibility wcax = getWebContentsAccessibility();
            if (wcax != null) {
                wcax.onProvideVirtualStructure(structure, false);
            }
        }
    }
}
