package org.chromium.content.browser.input;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.chromium.base.task.PostTask;
import org.chromium.content_public.browser.UiThreadTaskTraits;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ThreadedInputConnectionProxyView.class */
public class ThreadedInputConnectionProxyView extends View {
    private static final String TAG = "cr_Ime";
    private static final boolean DEBUG_LOGS = false;
    private final Handler mImeThreadHandler;
    private final View mContainerView;
    private final AtomicBoolean mFocused;
    private final AtomicBoolean mWindowFocused;
    private final AtomicReference<IBinder> mWindowToken;
    private final AtomicReference<View> mRootView;
    private final ThreadedInputConnectionFactory mFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadedInputConnectionProxyView(Context context, Handler imeThreadHandler, View containerView, ThreadedInputConnectionFactory factory) {
        super(context);
        this.mFocused = new AtomicBoolean();
        this.mWindowFocused = new AtomicBoolean();
        this.mWindowToken = new AtomicReference<>();
        this.mRootView = new AtomicReference<>();
        this.mImeThreadHandler = imeThreadHandler;
        this.mContainerView = containerView;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setVisibility(0);
        this.mFocused.set(this.mContainerView.hasFocus());
        this.mWindowFocused.set(this.mContainerView.hasWindowFocus());
        this.mWindowToken.set(this.mContainerView.getWindowToken());
        this.mRootView.set(this.mContainerView.getRootView());
        this.mFactory = factory;
    }

    public void onOriginalViewFocusChanged(boolean gainFocus) {
        this.mFocused.set(gainFocus);
    }

    public void onOriginalViewWindowFocusChanged(boolean gainFocus) {
        this.mWindowFocused.set(gainFocus);
    }

    public void onOriginalViewAttachedToWindow() {
        this.mWindowToken.set(this.mContainerView.getWindowToken());
        this.mRootView.set(this.mContainerView.getRootView());
    }

    public void onOriginalViewDetachedFromWindow() {
        this.mWindowToken.set(null);
        this.mRootView.set(null);
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.mImeThreadHandler;
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        return this.mContainerView == view;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return (InputConnection) PostTask.runSynchronously(UiThreadTaskTraits.USER_BLOCKING, () -> {
            this.mFactory.setTriggerDelayedOnCreateInputConnection(false);
            InputConnection connection = this.mContainerView.onCreateInputConnection(outAttrs);
            this.mFactory.setTriggerDelayedOnCreateInputConnection(true);
            return connection;
        });
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.mWindowFocused.get();
    }

    @Override // android.view.View
    public View getRootView() {
        if (this.mWindowFocused.get()) {
            return this.mRootView.get();
        }
        return null;
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.mFocused.get();
    }

    @Override // android.view.View
    public IBinder getWindowToken() {
        return this.mWindowToken.get();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
    }
}
