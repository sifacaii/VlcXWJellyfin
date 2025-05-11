package org.chromium.ui.base;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.compat.ApiHelperForM;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/ActivityAndroidPermissionDelegate.class */
public class ActivityAndroidPermissionDelegate implements AndroidPermissionDelegate {
    private WeakReference<Activity> mActivity;
    private Handler mHandler = new Handler();
    private SparseArray<PermissionCallback> mOutstandingPermissionRequests = new SparseArray<>();
    private int mNextRequestCode;
    private static final int REQUEST_CODE_PREFIX = 1000;
    private static final int REQUEST_CODE_RANGE_SIZE = 100;
    private static final String PERMISSION_QUERIED_KEY_PREFIX = "HasRequestedAndroidPermission::";
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ActivityAndroidPermissionDelegate.class.desiredAssertionStatus();
    }

    public ActivityAndroidPermissionDelegate(WeakReference<Activity> activity) {
        this.mActivity = activity;
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    public boolean hasPermission(String permission) {
        return ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), permission, Process.myPid(), Process.myUid()) == 0;
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    public boolean canRequestPermission(String permission) {
        Activity activity;
        if (Build.VERSION.SDK_INT < 23 || (activity = this.mActivity.get()) == null || isPermissionRevokedByPolicy(permission)) {
            return false;
        }
        if (ApiHelperForM.shouldShowRequestPermissionRationale(activity, permission)) {
            return true;
        }
        String permissionQueriedKey = getHasRequestedPermissionKey(permission);
        SharedPreferences prefs = ContextUtils.getAppSharedPreferences();
        if (prefs.getBoolean(permissionQueriedKey, false)) {
            logUMAOnRequestPermissionDenied(permission);
            return false;
        }
        return true;
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    public boolean isPermissionRevokedByPolicy(String permission) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 23 && (activity = this.mActivity.get()) != null) {
            return ApiHelperForM.isPermissionRevokedByPolicy(activity, permission);
        }
        return false;
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    public void requestPermissions(final String[] permissions, final PermissionCallback callback) {
        if (requestPermissionsInternal(permissions, callback)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: org.chromium.ui.base.ActivityAndroidPermissionDelegate.1
            @Override // java.lang.Runnable
            public void run() {
                int[] results = new int[permissions.length];
                for (int i = 0; i < permissions.length; i++) {
                    results[i] = ActivityAndroidPermissionDelegate.this.hasPermission(permissions[i]) ? 0 : -1;
                }
                callback.onRequestPermissionsResult(permissions, results);
            }
        });
    }

    @Override // org.chromium.ui.base.AndroidPermissionDelegate
    public boolean handlePermissionResult(int requestCode, String[] permissions, int[] grantResults) {
        Activity activity = this.mActivity.get();
        if ($assertionsDisabled || activity != null) {
            SharedPreferences.Editor editor = ContextUtils.getAppSharedPreferences().edit();
            for (String str : permissions) {
                editor.putBoolean(getHasRequestedPermissionKey(str), true);
            }
            editor.apply();
            PermissionCallback callback = this.mOutstandingPermissionRequests.get(requestCode);
            this.mOutstandingPermissionRequests.delete(requestCode);
            if (callback == null) {
                return false;
            }
            callback.onRequestPermissionsResult(permissions, grantResults);
            return true;
        }
        throw new AssertionError();
    }

    protected void logUMAOnRequestPermissionDenied(String permission) {
    }

    private boolean requestPermissionsInternal(String[] permissions, PermissionCallback callback) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 23 && (activity = this.mActivity.get()) != null) {
            int requestCode = 1000 + this.mNextRequestCode;
            this.mNextRequestCode = (this.mNextRequestCode + 1) % 100;
            this.mOutstandingPermissionRequests.put(requestCode, callback);
            ApiHelperForM.requestActivityPermissions(activity, permissions, requestCode);
            return true;
        }
        return false;
    }

    private String getHasRequestedPermissionKey(String permission) {
        String permissionQueriedKey = permission;
        if (Build.VERSION.SDK_INT < 26) {
            try {
                PermissionInfo permissionInfo = ContextUtils.getApplicationContext().getPackageManager().getPermissionInfo(permission, PackageManager.GET_META_DATA);
                if (!TextUtils.isEmpty(permissionInfo.group)) {
                    permissionQueriedKey = permissionInfo.group;
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return PERMISSION_QUERIED_KEY_PREFIX + permissionQueriedKey;
    }
}
