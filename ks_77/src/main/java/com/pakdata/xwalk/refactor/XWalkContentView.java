package com.pakdata.xwalk.refactor;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.ViewStructure;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import org.chromium.components.embedder_support.view.ContentView;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsAccessibility;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkContentView.class */
public class XWalkContentView extends ContentView {
    private XWalkView mXWalkView;

    public static XWalkContentView createContentView(Context context, WebContents webContents, XWalkView xwView) {
        if (Build.VERSION.SDK_INT >= 23) {
            return new XWalkContentViewApi23(context, webContents, xwView);
        }
        return new XWalkContentView(context, webContents, xwView);
    }

    private XWalkContentView(Context context, WebContents webContents, XWalkView xwView) {
        super(context, webContents);
        this.mXWalkView = xwView;
    }

    @Override // org.chromium.components.embedder_support.view.ContentView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return this.mXWalkView.onCreateInputConnection(outAttrs);
    }

    public InputConnection onCreateInputConnectionSuper(EditorInfo outAttrs) {
        return super.onCreateInputConnection(outAttrs);
    }

    @Override // org.chromium.components.embedder_support.view.ContentView, android.view.View
    public boolean performLongClick() {
        return this.mXWalkView.performLongClickDelegate();
    }

    @Override // org.chromium.components.embedder_support.view.ContentView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mXWalkView.onTouchEventDelegate(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override // org.chromium.components.embedder_support.view.ContentView, android.view.View, org.chromium.content_public.browser.ViewEventSink.InternalAccessDelegate
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        this.mXWalkView.onScrollChangedDelegate(l, t, oldl, oldt);
        this.mXWalkView.onOverScrolledDelegate(l, t, false, false);
    }

    public int computeHorizontalScrollRangeDelegate() {
        return computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffsetDelegate() {
        return computeHorizontalScrollOffset();
    }

    public int computeVerticalScrollRangeDelegate() {
        return computeVerticalScrollRange();
    }

    public int computeVerticalScrollOffsetDelegate() {
        return computeVerticalScrollOffset();
    }

    public int computeVerticalScrollExtentDelegate() {
        return computeVerticalScrollExtent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.components.embedder_support.view.ContentView, android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        this.mXWalkView.onFocusChangedDelegate(gainFocus, direction, previouslyFocusedRect);
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkContentView$XWalkContentViewApi23.class */
    public static class XWalkContentViewApi23 extends XWalkContentView {
        public XWalkContentViewApi23(Context context, WebContents webContents, XWalkView xwView) {
            super(context, webContents, xwView);
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
