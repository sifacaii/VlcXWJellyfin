package org.chromium.content_public.browser;

import android.content.Intent;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ActionModeCallbackHelper.class */
public abstract class ActionModeCallbackHelper {
    private static final String TAG = "ActionModeHelper";
    public static final int MAX_SEARCH_QUERY_LENGTH = 1000;
    public static final int MENU_ITEM_SHARE = 1;
    public static final int MENU_ITEM_WEB_SEARCH = 2;
    public static final int MENU_ITEM_PROCESS_TEXT = 4;
    public static final EmptyActionCallback EMPTY_CALLBACK = new EmptyActionCallback();

    public abstract boolean supportsFloatingActionMode();

    public abstract boolean isActionModeValid();

    public abstract void finishActionMode();

    public abstract String getSelectedText();

    public abstract void onReceivedProcessTextResult(int i, Intent intent);

    public abstract void setAllowedMenuItems(int i);

    public abstract void onCreateActionMode(ActionMode actionMode, Menu menu);

    public abstract boolean onPrepareActionMode(ActionMode actionMode, Menu menu);

    public abstract boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem);

    public abstract void onDestroyActionMode();

    public abstract void onGetContentRect(ActionMode actionMode, View view, Rect rect);

    public static String sanitizeQuery(String query, int maxLength) {
        return SelectionPopupControllerImpl.sanitizeQuery(query, maxLength);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ActionModeCallbackHelper$EmptyActionCallback.class */
    public static class EmptyActionCallback implements ActionMode.Callback {
        private EmptyActionCallback() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
        }
    }
}
