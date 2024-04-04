package org.chromium.content.browser.input;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import org.chromium.base.Log;
import org.chromium.base.VisibleForTesting;
import org.chromium.content.browser.input.ChromiumBaseInputConnection;
import org.chromium.content_public.browser.InputMethodManagerWrapper;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ThreadedInputConnectionFactory.class */
public class ThreadedInputConnectionFactory implements ChromiumBaseInputConnection.Factory {
    private static final String TAG = "cr_Ime";
    private static final boolean DEBUG_LOGS = false;
    private static final int CHECK_REGISTER_RETRY = 1;
    private final InputMethodManagerWrapper mInputMethodManagerWrapper;
    private ThreadedInputConnectionProxyView mProxyView;
    private ThreadedInputConnection mThreadedInputConnection;
    private CheckInvalidator mCheckInvalidator;
    private boolean mReentrantTriggering;
    private final InputMethodUma mInputMethodUma = createInputMethodUma();
    private boolean mTriggerDelayedOnCreateInputConnection = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ThreadedInputConnectionFactory$LazyHandlerHolder.class */
    public static class LazyHandlerHolder {
        private static final Handler sHandler;

        private LazyHandlerHolder() {
        }

        static {
            HandlerThread handlerThread = new HandlerThread("InputConnectionHandlerThread", 5);
            handlerThread.start();
            sHandler = new Handler(handlerThread.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ThreadedInputConnectionFactory$CheckInvalidator.class */
    public static class CheckInvalidator {
        private boolean mInvalid;

        private CheckInvalidator() {
        }

        public void invalidate() {
            ImeUtils.checkOnUiThread();
            this.mInvalid = true;
        }

        public boolean isInvalid() {
            ImeUtils.checkOnUiThread();
            return this.mInvalid;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadedInputConnectionFactory(InputMethodManagerWrapper inputMethodManagerWrapper) {
        this.mInputMethodManagerWrapper = inputMethodManagerWrapper;
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection.Factory
    public Handler getHandler() {
        return LazyHandlerHolder.sHandler;
    }

    @VisibleForTesting
    protected ThreadedInputConnectionProxyView createProxyView(Handler handler, View containerView) {
        return new ThreadedInputConnectionProxyView(containerView.getContext(), handler, containerView, this);
    }

    @VisibleForTesting
    protected InputMethodUma createInputMethodUma() {
        return new InputMethodUma();
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection.Factory
    @VisibleForTesting
    public void setTriggerDelayedOnCreateInputConnection(boolean trigger) {
        this.mTriggerDelayedOnCreateInputConnection = trigger;
    }

    private boolean shouldTriggerDelayedOnCreateInputConnection() {
        return this.mTriggerDelayedOnCreateInputConnection;
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection.Factory
    public ThreadedInputConnection initializeAndGet(View view, ImeAdapterImpl imeAdapter, int inputType, int inputFlags, int inputMode, int inputAction, int selectionStart, int selectionEnd, EditorInfo outAttrs) {
        ImeUtils.checkOnUiThread();
        ImeUtils.computeEditorInfo(inputType, inputFlags, inputMode, inputAction, selectionStart, selectionEnd, outAttrs);
        if (Build.VERSION.SDK_INT < 24 || "com.htc.android.mail".equals(view.getContext().getPackageName())) {
            if (this.mCheckInvalidator != null) {
                this.mCheckInvalidator.invalidate();
            }
            if (shouldTriggerDelayedOnCreateInputConnection()) {
                triggerDelayedOnCreateInputConnection(view);
                return null;
            }
        }
        if (this.mThreadedInputConnection == null) {
            this.mThreadedInputConnection = new ThreadedInputConnection(view, imeAdapter, getHandler());
        } else {
            this.mThreadedInputConnection.resetOnUiThread();
        }
        return this.mThreadedInputConnection;
    }

    private void triggerDelayedOnCreateInputConnection(final View view) {
        if (!this.mReentrantTriggering && view.hasFocus()) {
            this.mCheckInvalidator = new CheckInvalidator();
            if (!view.hasWindowFocus()) {
                this.mCheckInvalidator.invalidate();
            }
            this.mProxyView = createProxyView(getHandler(), view);
            this.mReentrantTriggering = true;
            this.mProxyView.requestFocus();
            this.mReentrantTriggering = false;
            view.getHandler().post(new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnectionFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    ThreadedInputConnectionFactory.this.mProxyView.onWindowFocusChanged(true);
                    ThreadedInputConnectionFactory.this.mInputMethodManagerWrapper.isActive(view);
                    ThreadedInputConnectionFactory.this.getHandler().post(new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnectionFactory.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ThreadedInputConnectionFactory.this.postCheckRegisterResultOnUiThread(view, ThreadedInputConnectionFactory.this.mCheckInvalidator, 1);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postCheckRegisterResultOnUiThread(final View view, final CheckInvalidator checkInvalidator, final int retry) {
        Handler viewHandler = view.getHandler();
        if (viewHandler == null) {
            return;
        }
        viewHandler.post(new Runnable() { // from class: org.chromium.content.browser.input.ThreadedInputConnectionFactory.2
            @Override // java.lang.Runnable
            public void run() {
                ThreadedInputConnectionFactory.this.checkRegisterResult(view, checkInvalidator, retry);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRegisterResult(View view, CheckInvalidator checkInvalidator, int retry) {
        if (this.mInputMethodManagerWrapper.isActive(this.mProxyView)) {
            onRegisterProxyViewSuccess();
        } else if (retry > 0) {
            postCheckRegisterResultOnUiThread(view, checkInvalidator, retry - 1);
        } else if (checkInvalidator.isInvalid()) {
        } else {
            onRegisterProxyViewFailure();
        }
    }

    @VisibleForTesting
    protected void onRegisterProxyViewSuccess() {
        Log.d(TAG, "onRegisterProxyViewSuccess");
        this.mInputMethodUma.recordProxyViewSuccess();
    }

    @VisibleForTesting
    protected void onRegisterProxyViewFailure() {
        Log.w(TAG, "onRegisterProxyViewFailure", new Object[0]);
        this.mInputMethodUma.recordProxyViewFailure();
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection.Factory
    public void onWindowFocusChanged(boolean gainFocus) {
        if (!gainFocus && this.mCheckInvalidator != null) {
            this.mCheckInvalidator.invalidate();
        }
        if (this.mProxyView != null) {
            this.mProxyView.onOriginalViewWindowFocusChanged(gainFocus);
        }
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection.Factory
    public void onViewFocusChanged(boolean gainFocus) {
        if (!gainFocus && this.mCheckInvalidator != null) {
            this.mCheckInvalidator.invalidate();
        }
        if (this.mProxyView != null) {
            this.mProxyView.onOriginalViewFocusChanged(gainFocus);
        }
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection.Factory
    public void onViewAttachedToWindow() {
        if (this.mProxyView != null) {
            this.mProxyView.onOriginalViewAttachedToWindow();
        }
    }

    @Override // org.chromium.content.browser.input.ChromiumBaseInputConnection.Factory
    public void onViewDetachedFromWindow() {
        if (this.mCheckInvalidator != null) {
            this.mCheckInvalidator.invalidate();
        }
        if (this.mProxyView != null) {
            this.mProxyView.onOriginalViewDetachedFromWindow();
        }
    }
}
