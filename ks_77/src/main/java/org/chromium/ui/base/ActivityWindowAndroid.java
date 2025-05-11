package org.chromium.ui.base;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import java.lang.ref.WeakReference;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.Callback;
import org.chromium.base.ContextUtils;
import org.chromium.ui.base.WindowAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/ActivityWindowAndroid.class */
public class ActivityWindowAndroid extends WindowAndroid implements ApplicationStatus.ActivityStateListener {
    private static final int REQUEST_CODE_PREFIX = 1000;
    private static final int REQUEST_CODE_RANGE_SIZE = 100;
    private int mNextRequestCode;
    private boolean mListenToActivityState;

    public ActivityWindowAndroid(Context context) {
        this(context, true);
    }

    public ActivityWindowAndroid(Context context, boolean listenToActivityState) {
        super(context);
        Activity activity = activityFromContext(context);
        if (activity == null) {
            throw new IllegalArgumentException("Context is not and does not wrap an Activity");
        }
        this.mListenToActivityState = listenToActivityState;
        if (listenToActivityState) {
            ApplicationStatus.registerStateListenerForActivity(this, activity);
        }
        setKeyboardDelegate(createKeyboardVisibilityDelegate());
        setAndroidPermissionDelegate(createAndroidPermissionDelegate());
    }

    protected ActivityAndroidPermissionDelegate createAndroidPermissionDelegate() {
        return new ActivityAndroidPermissionDelegate(getActivity());
    }

    protected ActivityKeyboardVisibilityDelegate createKeyboardVisibilityDelegate() {
        return new ActivityKeyboardVisibilityDelegate(getActivity());
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public ActivityKeyboardVisibilityDelegate getKeyboardDelegate() {
        return (ActivityKeyboardVisibilityDelegate) super.getKeyboardDelegate();
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public int showCancelableIntent(PendingIntent intent, WindowAndroid.IntentCallback callback, Integer errorId) {
        Activity activity = getActivity().get();
        if (activity == null) {
            return -1;
        }
        int requestCode = generateNextRequestCode();
        try {
            activity.startIntentSenderForResult(intent.getIntentSender(), requestCode, new Intent(), 0, 0, 0);
            storeCallbackData(requestCode, callback, errorId);
            return requestCode;
        } catch (IntentSender.SendIntentException e) {
            return -1;
        }
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public int showCancelableIntent(Intent intent, WindowAndroid.IntentCallback callback, Integer errorId) {
        Activity activity = getActivity().get();
        if (activity == null) {
            return -1;
        }
        int requestCode = generateNextRequestCode();
        try {
            activity.startActivityForResult(intent, requestCode);
            storeCallbackData(requestCode, callback, errorId);
            return requestCode;
        } catch (ActivityNotFoundException e) {
            return -1;
        }
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public int showCancelableIntent(Callback<Integer> intentTrigger, WindowAndroid.IntentCallback callback, Integer errorId) {
        Activity activity = getActivity().get();
        if (activity == null) {
            return -1;
        }
        int requestCode = generateNextRequestCode();
        intentTrigger.onResult(Integer.valueOf(requestCode));
        storeCallbackData(requestCode, callback, errorId);
        return requestCode;
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public void cancelIntent(int requestCode) {
        Activity activity = getActivity().get();
        if (activity == null) {
            return;
        }
        activity.finishActivity(requestCode);
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        WindowAndroid.IntentCallback callback = this.mOutstandingIntents.get(requestCode);
        this.mOutstandingIntents.delete(requestCode);
        String errorMessage = this.mIntentErrors.remove(Integer.valueOf(requestCode));
        if (callback != null) {
            callback.onIntentCompleted(this, resultCode, data);
            return true;
        } else if (errorMessage != null) {
            showCallbackNonExistentError(errorMessage);
            return true;
        } else {
            return false;
        }
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public WeakReference<Activity> getActivity() {
        return new WeakReference<>(activityFromContext(getContext().get()));
    }

    @Override // org.chromium.base.ApplicationStatus.ActivityStateListener
    public void onActivityStateChange(Activity activity, int newState) {
        if (newState == 5) {
            onActivityStopped();
        } else if (newState == 2) {
            onActivityStarted();
        } else if (newState == 4) {
            onActivityPaused();
        } else if (newState == 3) {
            onActivityResumed();
        }
    }

    @Override // org.chromium.ui.base.WindowAndroid
    public int getActivityState() {
        return this.mListenToActivityState ? ApplicationStatus.getStateForActivity(getActivity().get()) : super.getActivityState();
    }

    private int generateNextRequestCode() {
        int requestCode = 1000 + this.mNextRequestCode;
        this.mNextRequestCode = (this.mNextRequestCode + 1) % 100;
        return requestCode;
    }

    private void storeCallbackData(int requestCode, WindowAndroid.IntentCallback callback, Integer errorId) {
        this.mOutstandingIntents.put(requestCode, callback);
        this.mIntentErrors.put(Integer.valueOf(requestCode), errorId == null ? null : ContextUtils.getApplicationContext().getString(errorId.intValue()));
    }
}
