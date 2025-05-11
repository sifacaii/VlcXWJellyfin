package org.chromium.ui.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.BuildInfo;
import org.chromium.base.Callback;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ObserverList;
import org.chromium.base.StrictModeContext;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.compat.ApiHelperForO;
import org.chromium.base.compat.ApiHelperForOMR1;
import org.chromium.ui.KeyboardVisibilityDelegate;
import org.chromium.ui.VSyncMonitor;
import org.chromium.ui.display.DisplayAndroid;
import org.chromium.ui.touchless.CursorObserver;
import org.chromium.ui.touchless.TouchlessEventHandler;
import org.chromium.ui.widget.Toast;

@JNINamespace("ui")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/WindowAndroid.class */
public class WindowAndroid implements AndroidPermissionDelegate, DisplayAndroid.DisplayAndroidObserver {
    private static final String TAG = "WindowAndroid";
    private static final float MAX_REFRESH_RATE_DELTA = 2.0f;
    private KeyboardVisibilityDelegate mKeyboardVisibilityDelegate;
    private long mNativeWindowAndroid;
    private final VSyncMonitor mVSyncMonitor;
    private final DisplayAndroid mDisplayAndroid;
    static final String WINDOW_CALLBACK_ERRORS = "window_callback_errors";
    public static final int START_INTENT_FAILURE = -1;
    private boolean mWindowisWideColorGamut;
    protected SparseArray<IntentCallback> mOutstandingIntents;
    private WeakReference<Context> mContextRef;
    protected HashMap<Integer, String> mIntentErrors;
    private HashSet<Animator> mAnimationsOverContent;
    private View mAnimationPlaceholderView;
    private final AccessibilityManager mAccessibilityManager;
    private boolean mIsTouchExplorationEnabled;
    private TouchExplorationMonitor mTouchExplorationMonitor;
    private AndroidPermissionDelegate mPermissionDelegate;
    private boolean mPendingVSyncRequest;
    private boolean mVSyncPaused;
    private List<Display.Mode> mSupportedRefreshRateModes;
    private ObserverList<ActivityStateObserver> mActivityStateObservers;
    private boolean mSelectionHandlesActive;
    private ObserverList<SelectionHandlesObserver> mSelectionHandlesObservers;
    private final ObserverList<OnCloseContextMenuListener> mContextMenuCloseListeners;
    private final VSyncMonitor.Listener mVSyncListener;
    private final CursorObserver mCursorObserver;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/WindowAndroid$ActivityStateObserver.class */
    public interface ActivityStateObserver {
        void onActivityPaused();

        void onActivityResumed();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/WindowAndroid$IntentCallback.class */
    public interface IntentCallback {
        void onIntentCompleted(WindowAndroid windowAndroid, int i, Intent intent);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/WindowAndroid$OnCloseContextMenuListener.class */
    public interface OnCloseContextMenuListener {
        void onContextMenuClosed();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/WindowAndroid$SelectionHandlesObserver.class */
    public interface SelectionHandlesObserver {
        void onSelectionHandlesStateChanged(boolean z);
    }

    private native long nativeInit(int i, float f, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnVSync(long j, long j2, long j3);

    private native void nativeOnVisibilityChanged(long j, boolean z);

    private native void nativeOnActivityStopped(long j);

    private native void nativeOnActivityStarted(long j);

    private native void nativeSetVSyncPaused(long j, boolean z);

    private native void nativeOnUpdateRefreshRate(long j, float f);

    private native void nativeDestroy(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnCursorVisibilityChanged(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFallbackCursorModeToggled(long j, boolean z);

    private native void nativeOnSupportedRefreshRatesUpdated(long j, float[] fArr);

    static {
        $assertionsDisabled = !WindowAndroid.class.desiredAssertionStatus();
    }

    @TargetApi(19)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/WindowAndroid$TouchExplorationMonitor.class */
    private class TouchExplorationMonitor {
        private AccessibilityManager.TouchExplorationStateChangeListener mTouchExplorationListener;

        TouchExplorationMonitor() {
            this.mTouchExplorationListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: org.chromium.ui.base.WindowAndroid.TouchExplorationMonitor.1
                @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
                public void onTouchExplorationStateChanged(boolean enabled) {
                    WindowAndroid.this.mIsTouchExplorationEnabled = WindowAndroid.this.mAccessibilityManager.isTouchExplorationEnabled();
                    WindowAndroid.this.refreshWillNotDraw();
                }
            };
            WindowAndroid.this.mAccessibilityManager.addTouchExplorationStateChangeListener(this.mTouchExplorationListener);
        }

        void destroy() {
            WindowAndroid.this.mAccessibilityManager.removeTouchExplorationStateChangeListener(this.mTouchExplorationListener);
        }
    }

    public View getReadbackView() {
        return null;
    }

    public static Activity activityFromContext(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return activityFromContext(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public boolean isInsideVSync() {
        return this.mVSyncMonitor.isInsideVSync();
    }

    public long getVsyncPeriodInMillis() {
        return this.mVSyncMonitor.getVSyncPeriodInMicroseconds() / 1000;
    }

    public WindowAndroid(Context context) {
        this(context, DisplayAndroid.getNonMultiDisplay(context));
    }

    @SuppressLint({"UseSparseArrays"})
    protected WindowAndroid(Context context, DisplayAndroid display) {
        this.mKeyboardVisibilityDelegate = KeyboardVisibilityDelegate.getInstance();
        this.mAnimationsOverContent = new HashSet<>();
        this.mActivityStateObservers = new ObserverList<>();
        this.mSelectionHandlesObservers = new ObserverList<>();
        this.mContextMenuCloseListeners = new ObserverList<>();
        this.mVSyncListener = new VSyncMonitor.Listener() { // from class: org.chromium.ui.base.WindowAndroid.1
            @Override // org.chromium.ui.VSyncMonitor.Listener
            public void onVSync(VSyncMonitor monitor, long vsyncTimeMicros) {
                if (WindowAndroid.this.mVSyncPaused) {
                    WindowAndroid.this.mPendingVSyncRequest = true;
                } else if (WindowAndroid.this.mNativeWindowAndroid != 0) {
                    WindowAndroid.this.nativeOnVSync(WindowAndroid.this.mNativeWindowAndroid, vsyncTimeMicros, WindowAndroid.this.mVSyncMonitor.getVSyncPeriodInMicroseconds());
                }
            }
        };
        this.mCursorObserver = new CursorObserver() { // from class: org.chromium.ui.base.WindowAndroid.2
            @Override // org.chromium.ui.touchless.CursorObserver
            public void onCursorVisibilityChanged(boolean visible) {
                if (WindowAndroid.this.mNativeWindowAndroid != 0) {
                    WindowAndroid.this.nativeOnCursorVisibilityChanged(WindowAndroid.this.mNativeWindowAndroid, visible);
                }
            }

            @Override // org.chromium.ui.touchless.CursorObserver
            public void onFallbackCursorModeToggled(boolean isOn) {
                if (WindowAndroid.this.mNativeWindowAndroid != 0) {
                    WindowAndroid.this.nativeOnFallbackCursorModeToggled(WindowAndroid.this.mNativeWindowAndroid, isOn);
                }
            }
        };
        this.mContextRef = new WeakReference<>(context);
        this.mOutstandingIntents = new SparseArray<>();
        this.mIntentErrors = new HashMap<>();
        this.mDisplayAndroid = display;
        this.mDisplayAndroid.addObserver(this);
        if (Build.VERSION.SDK_INT >= 23) {
            recomputeSupportedRefreshRates();
        }
        StrictModeContext ignored = StrictModeContext.allowDiskReads();
        Throwable th = null;
        try {
            this.mVSyncMonitor = new VSyncMonitor(context, this.mVSyncListener, this.mDisplayAndroid.getRefreshRate());
            this.mAccessibilityManager = (AccessibilityManager) ContextUtils.getApplicationContext().getSystemService("accessibility");
            if (ignored != null) {
                if (0 != 0) {
                    try {
                        ignored.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                } else {
                    ignored.close();
                }
            }
            if (Build.VERSION.SDK_INT >= 26 && !Build.VERSION.RELEASE.equals("8.0.0") && activityFromContext(context) != null) {
                Configuration configuration = context.getResources().getConfiguration();
                boolean isScreenWideColorGamut = ApiHelperForO.isScreenWideColorGamut(configuration);
                display.updateIsDisplayServerWideColorGamut(Boolean.valueOf(isScreenWideColorGamut));
            }
            TouchlessEventHandler.addCursorObserver(this.mCursorObserver);
        } finally {
        }
    }

    @CalledByNative
    private static long createForTesting() {
        WindowAndroid windowAndroid = new WindowAndroid(ContextUtils.getApplicationContext());
        return windowAndroid.getNativePointer();
    }

    @CalledByNative
    private void clearNativePointer() {
        this.mNativeWindowAndroid = 0L;
    }

    @VisibleForTesting
    public void setAndroidPermissionDelegate(AndroidPermissionDelegate delegate) {
        this.mPermissionDelegate = delegate;
    }

    public boolean showIntent(PendingIntent intent, IntentCallback callback, Integer errorId) {
        return showCancelableIntent(intent, callback, errorId) >= 0;
    }

    public boolean showIntent(Intent intent, IntentCallback callback, Integer errorId) {
        return showCancelableIntent(intent, callback, errorId) >= 0;
    }

    public int showCancelableIntent(PendingIntent intent, IntentCallback callback, Integer errorId) {
        Log.d(TAG, "Can't show intent as context is not an Activity: " + intent);
        return -1;
    }

    public int showCancelableIntent(Intent intent, IntentCallback callback, Integer errorId) {
        Log.d(TAG, "Can't show intent as context is not an Activity: " + intent);
        return -1;
    }

    public int showCancelableIntent(Callback<Integer> intentTrigger, IntentCallback callback, Integer errorId) {
        Log.d(TAG, "Can't show intent as context is not an Activity");
        return -1;
    }

    public void cancelIntent(int requestCode) {
        Log.d(TAG, "Can't cancel intent as context is not an Activity: " + requestCode);
    }

    public boolean removeIntentCallback(IntentCallback callback) {
        int requestCode = this.mOutstandingIntents.indexOfValue(callback);
        if (requestCode < 0) {
            return false;
        }
        this.mOutstandingIntents.remove(requestCode);
        this.mIntentErrors.remove(Integer.valueOf(requestCode));
        return true;
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    @CalledByNative
    public final boolean hasPermission(String permission) {
        return this.mPermissionDelegate != null ? this.mPermissionDelegate.hasPermission(permission) : ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), permission, Process.myPid(), Process.myUid()) == 0;
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    @CalledByNative
    public final boolean canRequestPermission(String permission) {
        if (this.mPermissionDelegate != null) {
            return this.mPermissionDelegate.canRequestPermission(permission);
        }
        Log.w(TAG, "Cannot determine the request permission state as the context is not an Activity", new Object[0]);
        if ($assertionsDisabled) {
            return false;
        }
        throw new AssertionError("Failed to determine the request permission state using a WindowAndroid without an Activity");
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    public final boolean isPermissionRevokedByPolicy(String permission) {
        if (this.mPermissionDelegate != null) {
            return this.mPermissionDelegate.isPermissionRevokedByPolicy(permission);
        }
        Log.w(TAG, "Cannot determine the policy permission state as the context is not an Activity", new Object[0]);
        if ($assertionsDisabled) {
            return false;
        }
        throw new AssertionError("Failed to determine the policy permission state using a WindowAndroid without an Activity");
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    public final void requestPermissions(String[] permissions, PermissionCallback callback) {
        if (this.mPermissionDelegate != null) {
            this.mPermissionDelegate.requestPermissions(permissions, callback);
            return;
        }
        Log.w(TAG, "Cannot request permissions as the context is not an Activity", new Object[0]);
        if (!$assertionsDisabled) {
            throw new AssertionError("Failed to request permissions using a WindowAndroid without an Activity");
        }
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    public boolean handlePermissionResult(int requestCode, String[] permissions, int[] grantResults) {
        if (this.mPermissionDelegate != null) {
            return this.mPermissionDelegate.handlePermissionResult(requestCode, permissions, grantResults);
        }
        return false;
    }

    public void showError(String error) {
        if (error != null) {
            Toast.makeText(ContextUtils.getApplicationContext(), error, 0).show();
        }
    }

    public void showError(int resId) {
        showError(ContextUtils.getApplicationContext().getString(resId));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showCallbackNonExistentError(String error) {
        showError(error);
    }

    public void sendBroadcast(Intent intent) {
        ContextUtils.getApplicationContext().sendBroadcast(intent);
    }

    public DisplayAndroid getDisplay() {
        return this.mDisplayAndroid;
    }

    public WeakReference<Activity> getActivity() {
        return new WeakReference<>(null);
    }

    public Context getApplicationContext() {
        return ContextUtils.getApplicationContext();
    }

    public void saveInstanceState(Bundle bundle) {
        bundle.putSerializable(WINDOW_CALLBACK_ERRORS, this.mIntentErrors);
    }

    public void restoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Object errors = bundle.getSerializable(WINDOW_CALLBACK_ERRORS);
        if (errors instanceof HashMap) {
            HashMap<Integer, String> intentErrors = (HashMap) errors;
            this.mIntentErrors = intentErrors;
        }
    }

    public void onVisibilityChanged(boolean visible) {
        if (this.mNativeWindowAndroid == 0) {
            return;
        }
        nativeOnVisibilityChanged(this.mNativeWindowAndroid, visible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityStopped() {
        if (this.mNativeWindowAndroid == 0) {
            return;
        }
        nativeOnActivityStopped(this.mNativeWindowAndroid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityStarted() {
        if (this.mNativeWindowAndroid == 0) {
            return;
        }
        nativeOnActivityStarted(this.mNativeWindowAndroid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityPaused() {
        Iterator<ActivityStateObserver> it = this.mActivityStateObservers.iterator();
        while (it.hasNext()) {
            ActivityStateObserver observer = it.next();
            observer.onActivityPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResumed() {
        Iterator<ActivityStateObserver> it = this.mActivityStateObservers.iterator();
        while (it.hasNext()) {
            ActivityStateObserver observer = it.next();
            observer.onActivityResumed();
        }
    }

    public void addActivityStateObserver(ActivityStateObserver observer) {
        if (!$assertionsDisabled && this.mActivityStateObservers.hasObserver(observer)) {
            throw new AssertionError();
        }
        this.mActivityStateObservers.addObserver(observer);
    }

    public void removeActivityStateObserver(ActivityStateObserver observer) {
        if (!$assertionsDisabled && !this.mActivityStateObservers.hasObserver(observer)) {
            throw new AssertionError();
        }
        this.mActivityStateObservers.removeObserver(observer);
    }

    public void addSelectionHandlesObserver(SelectionHandlesObserver observer) {
        if (!$assertionsDisabled && this.mSelectionHandlesObservers.hasObserver(observer)) {
            throw new AssertionError();
        }
        this.mSelectionHandlesObservers.addObserver(observer);
        observer.onSelectionHandlesStateChanged(this.mSelectionHandlesActive);
    }

    public void removeSelectionHandlesObserver(SelectionHandlesObserver observer) {
        if (!$assertionsDisabled && !this.mSelectionHandlesObservers.hasObserver(observer)) {
            throw new AssertionError();
        }
        this.mSelectionHandlesObservers.removeObserver(observer);
    }

    @CalledByNative
    private void onSelectionHandlesStateChanged(boolean active) {
        this.mSelectionHandlesActive = active;
        Iterator<SelectionHandlesObserver> it = this.mSelectionHandlesObservers.iterator();
        while (it.hasNext()) {
            SelectionHandlesObserver observer = it.next();
            observer.onSelectionHandlesStateChanged(active);
        }
    }

    public int getActivityState() {
        return 6;
    }

    @CalledByNative
    private void requestVSyncUpdate() {
        if (this.mVSyncPaused) {
            this.mPendingVSyncRequest = true;
        } else {
            this.mVSyncMonitor.requestUpdate();
        }
    }

    public boolean canResolveActivity(Intent intent) {
        return ContextUtils.getApplicationContext().getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    public void destroy() {
        if (this.mNativeWindowAndroid != 0) {
            nativeDestroy(this.mNativeWindowAndroid);
        }
        if (Build.VERSION.SDK_INT >= 19 && this.mTouchExplorationMonitor != null) {
            this.mTouchExplorationMonitor.destroy();
        }
        TouchlessEventHandler.removeCursorObserver(this.mCursorObserver);
    }

    @CalledByNative
    private long getNativePointer() {
        if (this.mNativeWindowAndroid == 0) {
            this.mNativeWindowAndroid = nativeInit(this.mDisplayAndroid.getDisplayId(), getMouseWheelScrollFactor(), getWindowIsWideColorGamut());
            nativeSetVSyncPaused(this.mNativeWindowAndroid, this.mVSyncPaused);
        }
        return this.mNativeWindowAndroid;
    }

    private float getMouseWheelScrollFactor() {
        TypedValue outValue = new TypedValue();
        Context context = getContext().get();
        if (context != null && context.getTheme().resolveAttribute(16842829, outValue, true)) {
            return outValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    private Window getWindow() {
        Activity activity = activityFromContext(this.mContextRef.get());
        if (activity == null) {
            return null;
        }
        return activity.getWindow();
    }

    private boolean getWindowIsWideColorGamut() {
        Window window;
        if (BuildInfo.isAtLeastQ() && (window = getWindow()) != null) {
            return ApiHelperForOMR1.isWideColorGamut(window);
        }
        return false;
    }

    public void setAnimationPlaceholderView(View view) {
        this.mAnimationPlaceholderView = view;
        this.mIsTouchExplorationEnabled = this.mAccessibilityManager.isTouchExplorationEnabled();
        refreshWillNotDraw();
        if (Build.VERSION.SDK_INT >= 19) {
            this.mTouchExplorationMonitor = new TouchExplorationMonitor();
        }
    }

    public KeyboardVisibilityDelegate getKeyboardDelegate() {
        return this.mKeyboardVisibilityDelegate;
    }

    @VisibleForTesting
    public void setKeyboardDelegate(KeyboardVisibilityDelegate keyboardDelegate) {
        this.mKeyboardVisibilityDelegate = keyboardDelegate;
        KeyboardVisibilityDelegate.setInstance(keyboardDelegate);
    }

    public void addContextMenuCloseListener(OnCloseContextMenuListener listener) {
        this.mContextMenuCloseListeners.addObserver(listener);
    }

    public void removeContextMenuCloseListener(OnCloseContextMenuListener listener) {
        this.mContextMenuCloseListeners.removeObserver(listener);
    }

    public void onContextMenuClosed() {
        Iterator<OnCloseContextMenuListener> it = this.mContextMenuCloseListeners.iterator();
        while (it.hasNext()) {
            OnCloseContextMenuListener listener = it.next();
            listener.onContextMenuClosed();
        }
    }

    public void startAnimationOverContent(Animator animation) {
        if (this.mAnimationPlaceholderView == null) {
            return;
        }
        if (animation.isStarted()) {
            throw new IllegalArgumentException("Already started.");
        }
        boolean added = this.mAnimationsOverContent.add(animation);
        if (!added) {
            throw new IllegalArgumentException("Already Added.");
        }
        animation.start();
        refreshWillNotDraw();
        animation.addListener(new AnimatorListenerAdapter() { // from class: org.chromium.ui.base.WindowAndroid.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation2) {
                animation2.removeListener(this);
                WindowAndroid.this.mAnimationsOverContent.remove(animation2);
                WindowAndroid.this.refreshWillNotDraw();
            }
        });
    }

    public WeakReference<Context> getContext() {
        return new WeakReference<>(this.mContextRef.get());
    }

    @CalledByNative
    protected IBinder getWindowToken() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.peekDecorView()) == null) {
            return null;
        }
        return decorView.getWindowToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshWillNotDraw() {
        boolean willNotDraw = !this.mIsTouchExplorationEnabled && this.mAnimationsOverContent.isEmpty();
        if (this.mAnimationPlaceholderView.willNotDraw() != willNotDraw) {
            this.mAnimationPlaceholderView.setWillNotDraw(willNotDraw);
        }
    }

    @VisibleForTesting
    public boolean haveAnimationsEnded() {
        return this.mAnimationsOverContent.isEmpty();
    }

    public void setVSyncPaused(boolean paused) {
        if (this.mVSyncPaused == paused) {
            return;
        }
        this.mVSyncPaused = paused;
        if (!this.mVSyncPaused && this.mPendingVSyncRequest) {
            requestVSyncUpdate();
        }
        if (this.mNativeWindowAndroid != 0) {
            nativeSetVSyncPaused(this.mNativeWindowAndroid, paused);
        }
    }

    @Override // org.chromium.ui.display.DisplayAndroid.DisplayAndroidObserver
    public void onRefreshRateChanged(float refreshRate) {
        this.mVSyncMonitor.updateRefreshRate(refreshRate);
        if (this.mNativeWindowAndroid != 0) {
            nativeOnUpdateRefreshRate(this.mNativeWindowAndroid, refreshRate);
        }
    }

    @Override // org.chromium.ui.display.DisplayAndroid.DisplayAndroidObserver
    @TargetApi(23)
    public void onCurrentModeChanged(Display.Mode currentMode) {
        recomputeSupportedRefreshRates();
    }

    @Override // org.chromium.ui.display.DisplayAndroid.DisplayAndroidObserver
    @TargetApi(23)
    public void onDisplayModesChanged(List<Display.Mode> supportedModes) {
        recomputeSupportedRefreshRates();
    }

    @SuppressLint({"NewApi"})
    @TargetApi(23)
    private void recomputeSupportedRefreshRates() {
        Display.Mode currentMode = this.mDisplayAndroid.getCurrentMode();
        if (!$assertionsDisabled && currentMode == null) {
            throw new AssertionError();
        }
        List<Display.Mode> supportedModes = this.mDisplayAndroid.getSupportedModes();
        if (!$assertionsDisabled && supportedModes == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && supportedModes.size() <= 0) {
            throw new AssertionError();
        }
        List<Display.Mode> supportedRefreshRateModes = new ArrayList<>();
        for (int i = 0; i < supportedModes.size(); i++) {
            if (currentMode.equals(supportedModes.get(i))) {
                supportedRefreshRateModes.add(supportedModes.get(i));
            } else if (currentMode.getPhysicalWidth() == supportedModes.get(i).getPhysicalWidth() && currentMode.getPhysicalHeight() == supportedModes.get(i).getPhysicalHeight() && currentMode.getRefreshRate() != supportedModes.get(i).getRefreshRate()) {
                supportedRefreshRateModes.add(supportedModes.get(i));
            }
        }
        boolean changed = !supportedRefreshRateModes.equals(this.mSupportedRefreshRateModes);
        if (changed) {
            this.mSupportedRefreshRateModes = supportedRefreshRateModes;
            if (this.mNativeWindowAndroid != 0) {
                nativeOnSupportedRefreshRatesUpdated(this.mNativeWindowAndroid, getSupportedRefreshRates());
            }
        }
    }

    @CalledByNative
    private float getRefreshRate() {
        return this.mDisplayAndroid.getRefreshRate();
    }

    @SuppressLint({"NewApi"})
    @TargetApi(23)
    @CalledByNative
    private float[] getSupportedRefreshRates() {
        if (this.mSupportedRefreshRateModes == null) {
            return null;
        }
        float[] supportedRefreshRates = new float[this.mSupportedRefreshRateModes.size()];
        for (int i = 0; i < this.mSupportedRefreshRateModes.size(); i++) {
            supportedRefreshRates[i] = this.mSupportedRefreshRateModes.get(i).getRefreshRate();
        }
        return supportedRefreshRates;
    }

    @SuppressLint({"NewApi"})
    @CalledByNative
    private void setPreferredRefreshRate(float preferredRefreshRate) {
        if (this.mSupportedRefreshRateModes == null || !BuildInfo.isAtLeastQ()) {
            return;
        }
        int preferredModeId = getPreferredModeId(preferredRefreshRate);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        if (params.preferredDisplayModeId == preferredModeId) {
            return;
        }
        params.preferredDisplayModeId = preferredModeId;
        window.setAttributes(params);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(23)
    private int getPreferredModeId(float preferredRefreshRate) {
        if (preferredRefreshRate == 0.0f) {
            return 0;
        }
        Display.Mode preferredMode = null;
        float preferredModeDelta = Float.MAX_VALUE;
        for (int i = 0; i < this.mSupportedRefreshRateModes.size(); i++) {
            Display.Mode mode = this.mSupportedRefreshRateModes.get(i);
            float delta = Math.abs(preferredRefreshRate - mode.getRefreshRate());
            if (delta < preferredModeDelta) {
                preferredModeDelta = delta;
                preferredMode = mode;
            }
        }
        if (preferredModeDelta > MAX_REFRESH_RATE_DELTA) {
            Log.e(TAG, "Refresh rate not supported : " + preferredRefreshRate, new Object[0]);
            return 0;
        }
        return preferredMode.getModeId();
    }
}
