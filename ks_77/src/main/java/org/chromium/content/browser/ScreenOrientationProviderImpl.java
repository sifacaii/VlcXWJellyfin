package org.chromium.content.browser;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import android.util.Pair;
import java.util.Map;
import java.util.WeakHashMap;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content_public.browser.ScreenOrientationDelegate;
import org.chromium.content_public.browser.ScreenOrientationProvider;
import org.chromium.content_public.common.ScreenOrientationConstants;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ScreenOrientationProviderImpl.class */
public class ScreenOrientationProviderImpl implements ApplicationStatus.ActivityStateListener, ScreenOrientationProvider {
    private static final String TAG = "cr.ScreenOrientation";
    private ScreenOrientationDelegate mDelegate;
    private Map<Activity, Pair<Boolean, Integer>> mDelayedRequests = new WeakHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ScreenOrientationProviderImpl$Holder.class */
    public static class Holder {
        private static ScreenOrientationProviderImpl sInstance = new ScreenOrientationProviderImpl();

        private Holder() {
        }
    }

    @CalledByNative
    public static ScreenOrientationProviderImpl getInstance() {
        return Holder.sInstance;
    }

    private static int getOrientationFromWebScreenOrientations(byte orientation, @Nullable WindowAndroid window, Context context) {
        switch (orientation) {
            case 0:
                return -1;
            case 1:
                return 1;
            case 2:
                return 9;
            case 3:
                return 0;
            case 4:
                return 8;
            case 5:
                return 10;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                DisplayAndroid displayAndroid = window != null ? window.getDisplay() : DisplayAndroid.getNonMultiDisplay(context);
                int rotation = displayAndroid.getRotation();
                if (rotation == 0 || rotation == 2) {
                    if (displayAndroid.getDisplayHeight() >= displayAndroid.getDisplayWidth()) {
                        return 1;
                    }
                    return 0;
                } else if (displayAndroid.getDisplayHeight() < displayAndroid.getDisplayWidth()) {
                    return 1;
                } else {
                    return 0;
                }
            default:
                Log.w(TAG, "Trying to lock to unsupported orientation!", new Object[0]);
                return -1;
        }
    }

    @Override // org.chromium.base.ApplicationStatus.ActivityStateListener
    public void onActivityStateChange(Activity activity, int newState) {
        if (newState == 6) {
            this.mDelayedRequests.remove(activity);
        }
    }

    @Override // org.chromium.content_public.browser.ScreenOrientationProvider
    @CalledByNative
    public void lockOrientation(@Nullable WindowAndroid window, byte webScreenOrientation) {
        Activity activity;
        int orientation;
        if (window == null || (activity = window.getActivity().get()) == null || (orientation = getOrientationFromWebScreenOrientations(webScreenOrientation, window, activity)) == -1) {
            return;
        }
        setMaybeDelayedRequestedOrientation(activity, true, orientation);
    }

    @Override // org.chromium.content_public.browser.ScreenOrientationProvider
    @CalledByNative
    public void unlockOrientation(@Nullable WindowAndroid window) {
        Activity activity;
        if (window == null || (activity = window.getActivity().get()) == null) {
            return;
        }
        int orientation = activity.getIntent().getIntExtra(ScreenOrientationConstants.EXTRA_ORIENTATION, 0);
        int defaultOrientation = getOrientationFromWebScreenOrientations((byte) orientation, window, activity);
        if (defaultOrientation == -1) {
            try {
                ActivityInfo info = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128);
                defaultOrientation = info.screenOrientation;
            } catch (PackageManager.NameNotFoundException e) {
                setMaybeDelayedRequestedOrientation(activity, false, defaultOrientation);
                return;
            } catch (Throwable th) {
                setMaybeDelayedRequestedOrientation(activity, false, defaultOrientation);
                throw th;
            }
        }
        setMaybeDelayedRequestedOrientation(activity, false, defaultOrientation);
    }

    @Override // org.chromium.content_public.browser.ScreenOrientationProvider
    public void delayOrientationRequests(WindowAndroid window) {
        Activity activity = window.getActivity().get();
        if (activity == null || areRequestsDelayedForActivity(activity)) {
            return;
        }
        this.mDelayedRequests.put(activity, null);
        ApplicationStatus.registerStateListenerForActivity(this, activity);
    }

    @Override // org.chromium.content_public.browser.ScreenOrientationProvider
    public void runDelayedOrientationRequests(WindowAndroid window) {
        Activity activity = window.getActivity().get();
        if (activity == null || !areRequestsDelayedForActivity(activity)) {
            return;
        }
        Pair<Boolean, Integer> delayedRequest = this.mDelayedRequests.remove(activity);
        if (delayedRequest != null) {
            setRequestedOrientationNow(activity, ((Boolean) delayedRequest.first).booleanValue(), ((Integer) delayedRequest.second).intValue());
        }
        if (this.mDelayedRequests.isEmpty()) {
            ApplicationStatus.unregisterActivityStateListener(this);
        }
    }

    @CalledByNative
    public boolean isOrientationLockEnabled() {
        return this.mDelegate == null || this.mDelegate.canLockOrientation();
    }

    @Override // org.chromium.content_public.browser.ScreenOrientationProvider
    public void setOrientationDelegate(ScreenOrientationDelegate delegate) {
        this.mDelegate = delegate;
    }

    private boolean areRequestsDelayedForActivity(Activity activity) {
        return this.mDelayedRequests.containsKey(activity);
    }

    private void setMaybeDelayedRequestedOrientation(Activity activity, boolean lock, int orientation) {
        if (areRequestsDelayedForActivity(activity)) {
            this.mDelayedRequests.put(activity, Pair.create(Boolean.valueOf(lock), Integer.valueOf(orientation)));
        } else {
            setRequestedOrientationNow(activity, lock, orientation);
        }
    }

    private void setRequestedOrientationNow(Activity activity, boolean lock, int orientation) {
        if (this.mDelegate != null) {
            if (!lock || this.mDelegate.canLockOrientation()) {
                if (!lock && !this.mDelegate.canUnlockOrientation(activity, orientation)) {
                    return;
                }
            } else {
                return;
            }
        }
        activity.setRequestedOrientation(orientation);
    }
}
