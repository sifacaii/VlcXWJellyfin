package org.chromium.content.browser.selection;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import org.chromium.content_public.browser.ActionModeCallbackHelper;

@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/FloatingActionModeCallback.class */
public class FloatingActionModeCallback extends ActionMode.Callback2 {
    private final ActionModeCallbackHelper mHelper;
    private final ActionMode.Callback mCallback;

    public FloatingActionModeCallback(ActionModeCallbackHelper helper, ActionMode.Callback callback) {
        this.mHelper = helper;
        this.mCallback = callback;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        if (mode.getType() != 1) {
            return false;
        }
        return this.mCallback.onCreateActionMode(mode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return this.mCallback.onPrepareActionMode(mode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return this.mCallback.onActionItemClicked(mode, item);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode mode) {
        this.mCallback.onDestroyActionMode(mode);
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(ActionMode mode, View view, Rect outRect) {
        this.mHelper.onGetContentRect(mode, view, outRect);
    }
}
