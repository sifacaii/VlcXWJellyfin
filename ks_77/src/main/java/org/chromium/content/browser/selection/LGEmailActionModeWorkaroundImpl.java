package org.chromium.content.browser.selection;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.base.Log;
import org.chromium.base.PackageUtils;
import org.chromium.base.task.PostTask;
import org.chromium.content_public.browser.UiThreadTaskTraits;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/LGEmailActionModeWorkaroundImpl.class */
public final class LGEmailActionModeWorkaroundImpl {
    private static final String TAG = "cr_Ime";
    public static final int LGEmailWorkaroundMaxVersion = 67502100;

    private LGEmailActionModeWorkaroundImpl() {
    }

    public static boolean isSafeVersion(int versionCode) {
        return versionCode > 67502100;
    }

    public static void runIfNecessary(Context context, ActionMode actionMode) {
        if (shouldAllowActionModeDestroyOnNonUiThread(context)) {
            allowActionModeDestroyOnNonUiThread(actionMode);
        }
    }

    private static boolean shouldAllowActionModeDestroyOnNonUiThread(Context context) {
        int appTargetSdkVersion;
        String appName = context.getPackageName();
        int versionCode = PackageUtils.getPackageVersion(context, appName);
        if (versionCode != -1 && (appTargetSdkVersion = context.getApplicationInfo().targetSdkVersion) >= 23 && appTargetSdkVersion <= 24 && "com.lge.email".equals(appName) && versionCode <= 67502100) {
            Log.w(TAG, "Working around action mode LG Email bug in WebView (http://crbug.com/651706). APK name: com.lge.email, versionCode: " + versionCode, new Object[0]);
            return true;
        }
        return false;
    }

    @TargetApi(23)
    private static void allowActionModeDestroyOnNonUiThread(ActionMode actionMode) {
        try {
            final ActionMode.Callback2 c = (ActionMode.Callback2) getField(actionMode, "mCallback");
            setField(actionMode, "mCallback", new ActionMode.Callback2() { // from class: org.chromium.content.browser.selection.LGEmailActionModeWorkaroundImpl.1
                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return c.onCreateActionMode(mode, menu);
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return c.onPrepareActionMode(mode, menu);
                }

                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return c.onActionItemClicked(mode, item);
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(final ActionMode mode) {
                    PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.selection.LGEmailActionModeWorkaroundImpl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.onDestroyActionMode(mode);
                        }
                    });
                }
            });
            Object floatingToolbar = getField(actionMode, "mFloatingToolbar");
            Object popup = getField(floatingToolbar, "mPopup");
            final ViewGroup contentContainer = (ViewGroup) getField(popup, "mContentContainer");
            final PopupWindow popupWindow = (PopupWindow) getField(popup, "mPopupWindow");
            Method createExitAnimation = floatingToolbar.getClass().getDeclaredMethod("createExitAnimation", View.class, Integer.TYPE, Animator.AnimatorListener.class);
            createExitAnimation.setAccessible(true);
            Object newDismissAnimation = createExitAnimation.invoke(null, contentContainer, 150, new AnimatorListenerAdapter() { // from class: org.chromium.content.browser.selection.LGEmailActionModeWorkaroundImpl.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.selection.LGEmailActionModeWorkaroundImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            popupWindow.dismiss();
                            contentContainer.removeAllViews();
                        }
                    });
                }
            });
            setField(popup, "mDismissAnimation", newDismissAnimation);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
        } catch (Exception e2) {
            Log.w(TAG, "Error occurred during LGEmailActionModeWorkaround: ", e2);
        }
    }

    private static Object getField(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(obj);
    }

    private static void setField(Object obj, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(obj, value);
    }
}
