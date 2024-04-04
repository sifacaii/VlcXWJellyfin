package org.chromium.ui.resources.dynamics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/dynamics/ViewResourceInflater.class */
public class ViewResourceInflater {
    private int mLayoutId;
    private int mViewId;
    private Context mContext;
    private ViewGroup mContainer;
    private DynamicResourceLoader mResourceLoader;
    private ViewResourceAdapter mResourceAdapter;
    private View mView;
    private boolean mNeedsLayoutUpdate;
    private boolean mIsInvalidated;
    private boolean mIsAttached;
    private ViewInflaterOnDrawListener mOnDrawListener;
    private static final int INVALID_ID = -1;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ViewResourceInflater.class.desiredAssertionStatus();
    }

    public ViewResourceInflater(int layoutId, int viewId, Context context, ViewGroup container, DynamicResourceLoader resourceLoader) {
        this.mLayoutId = layoutId;
        this.mViewId = viewId;
        this.mContext = context;
        this.mContainer = container;
        this.mResourceLoader = resourceLoader;
    }

    public void inflate() {
        if (this.mView != null) {
            return;
        }
        this.mView = LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mContainer, false);
        if (!$assertionsDisabled && this.mView.getId() != this.mViewId) {
            throw new AssertionError();
        }
        onFinishInflate();
        registerResource();
        this.mNeedsLayoutUpdate = true;
    }

    public void invalidate() {
        invalidate(false);
    }

    public void invalidate(boolean didViewSizeChange) {
        if (this.mView == null) {
            inflate();
        }
        this.mIsInvalidated = true;
        if (!this.mIsAttached && shouldAttachView()) {
            attachView();
        }
        if (this.mIsAttached) {
            if (didViewSizeChange || this.mNeedsLayoutUpdate) {
                updateLayoutParams();
            }
        } else {
            layout();
            invalidateResource();
        }
        this.mNeedsLayoutUpdate = false;
    }

    public void destroy() {
        if (this.mView == null) {
            return;
        }
        unregisterResource();
        detachView();
        this.mView = null;
        this.mLayoutId = -1;
        this.mViewId = -1;
        this.mContext = null;
        this.mContainer = null;
        this.mResourceLoader = null;
    }

    public int getMeasuredWidth() {
        if ($assertionsDisabled || this.mView != null) {
            return this.mView.getMeasuredWidth();
        }
        throw new AssertionError();
    }

    public int getMeasuredHeight() {
        if ($assertionsDisabled || this.mView != null) {
            return this.mView.getMeasuredHeight();
        }
        throw new AssertionError();
    }

    public int getViewId() {
        return this.mViewId;
    }

    protected void onFinishInflate() {
    }

    protected boolean shouldAttachView() {
        return true;
    }

    protected boolean shouldDetachViewAfterCapturing() {
        return true;
    }

    protected int getWidthMeasureSpec() {
        return getUnspecifiedMeasureSpec();
    }

    protected int getHeightMeasureSpec() {
        return getUnspecifiedMeasureSpec();
    }

    protected void layout() {
        this.mView.measure(getWidthMeasureSpec(), getHeightMeasureSpec());
        this.mView.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    protected View getView() {
        return this.mView;
    }

    protected Context getContext() {
        return this.mContext;
    }

    private void attachView() {
        if (!this.mIsAttached) {
            if (!$assertionsDisabled && this.mView.getParent() != null) {
                throw new AssertionError();
            }
            this.mContainer.addView(this.mView);
            this.mIsAttached = true;
            if (this.mOnDrawListener == null) {
                this.mOnDrawListener = new ViewInflaterOnDrawListener();
                this.mView.getViewTreeObserver().addOnDrawListener(this.mOnDrawListener);
            }
        }
    }

    private void detachView() {
        if (this.mIsAttached) {
            if (this.mOnDrawListener != null) {
                this.mView.getViewTreeObserver().removeOnDrawListener(this.mOnDrawListener);
                this.mOnDrawListener = null;
            }
            if (!$assertionsDisabled && this.mView.getParent() == null) {
                throw new AssertionError();
            }
            this.mContainer.removeView(this.mView);
            this.mIsAttached = false;
        }
    }

    private void updateLayoutParams() {
        if (!$assertionsDisabled && this.mView == null) {
            throw new AssertionError();
        }
        int widthMeasureSpec = getWidthMeasureSpec();
        int width = -2;
        if (View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
            width = View.MeasureSpec.getSize(widthMeasureSpec);
        }
        int heightMeasureSpec = getHeightMeasureSpec();
        int height = -2;
        if (View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824) {
            height = View.MeasureSpec.getSize(heightMeasureSpec);
        }
        ViewGroup.LayoutParams params = this.mView.getLayoutParams();
        params.width = width;
        params.height = height;
        this.mView.setLayoutParams(params);
    }

    private int getUnspecifiedMeasureSpec() {
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    private void registerResource() {
        if (this.mResourceAdapter == null) {
            this.mResourceAdapter = new ViewInflaterAdapter(this.mView.findViewById(this.mViewId));
        }
        if (this.mResourceLoader != null) {
            this.mResourceLoader.registerResource(this.mViewId, this.mResourceAdapter);
        }
    }

    private void unregisterResource() {
        if (this.mResourceLoader != null) {
            this.mResourceLoader.unregisterResource(this.mViewId);
        }
        this.mResourceAdapter = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateResource() {
        if (this.mIsInvalidated && this.mView != null && this.mResourceAdapter != null) {
            this.mIsInvalidated = false;
            this.mResourceAdapter.invalidate(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/dynamics/ViewResourceInflater$ViewInflaterAdapter.class */
    public class ViewInflaterAdapter extends ViewResourceAdapter {
        public ViewInflaterAdapter(View view) {
            super(view);
        }

        @Override // org.chromium.ui.resources.dynamics.ViewResourceAdapter
        protected void onCaptureEnd() {
            ViewResourceInflater.this.onCaptureEnd();
        }
    }

    protected void onCaptureEnd() {
        if (shouldDetachViewAfterCapturing()) {
            detachView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/dynamics/ViewResourceInflater$ViewInflaterOnDrawListener.class */
    public class ViewInflaterOnDrawListener implements ViewTreeObserver.OnDrawListener {
        private ViewInflaterOnDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            ViewResourceInflater.this.invalidateResource();
        }
    }
}
