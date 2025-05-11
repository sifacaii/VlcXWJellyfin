package com.pakdata.xwalk.refactor;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import org.chromium.content_public.browser.ActionModeCallbackHelper;
import org.chromium.content_public.browser.SelectionPopupController;
import org.chromium.content_public.browser.WebContents;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkActionModeCallback.class */
public class XWalkActionModeCallback implements ActionMode.Callback {
    private final ActionModeCallbackHelper mHelper;
    private int mAllowedMenuItems;

    public XWalkActionModeCallback(WebContents webContents) {
        this.mHelper = SelectionPopupController.fromWebContents(webContents).getActionModeCallbackHelper();
        this.mHelper.setAllowedMenuItems(0);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        if (5 != this.mAllowedMenuItems) {
            this.mHelper.setAllowedMenuItems(5);
            this.mAllowedMenuItems = 5;
        }
        this.mHelper.onCreateActionMode(mode, menu);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode arg0) {
        this.mHelper.onDestroyActionMode();
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return this.mHelper.onPrepareActionMode(mode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (!this.mHelper.isActionModeValid()) {
            return true;
        }
        return this.mHelper.onActionItemClicked(mode, item);
    }
}
