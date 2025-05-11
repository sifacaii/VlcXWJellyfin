package org.chromium.content.browser.input;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import java.util.List;
import org.chromium.content.browser.input.SelectPopup;
import org.chromium.content_public.browser.GestureListenerManager;
import org.chromium.content_public.browser.GestureStateListener;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.DropdownAdapter;
import org.chromium.ui.DropdownPopupWindow;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/SelectPopupDropdown.class */
public class SelectPopupDropdown implements SelectPopup.Ui {
    private final SelectPopup mSelectPopup;
    private final DropdownPopupWindow mDropdownPopupWindow;
    private boolean mSelectionNotified;

    public SelectPopupDropdown(SelectPopup selectPopup, Context context, View anchorView, List<SelectPopupItem> items, int[] selected, boolean rightAligned, WebContents webContents) {
        this.mSelectPopup = selectPopup;
        this.mDropdownPopupWindow = new DropdownPopupWindow(context, anchorView);
        this.mDropdownPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: org.chromium.content.browser.input.SelectPopupDropdown.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SelectPopupDropdown.this.notifySelection(new int[]{position});
                SelectPopupDropdown.this.hide(false);
            }
        });
        int initialSelection = -1;
        this.mDropdownPopupWindow.setInitialSelection(selected.length > 0 ? selected[0] : initialSelection);
        this.mDropdownPopupWindow.setAdapter(new DropdownAdapter(context, items, null));
        this.mDropdownPopupWindow.setRtl(rightAligned);
        this.mDropdownPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: org.chromium.content.browser.input.SelectPopupDropdown.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                SelectPopupDropdown.this.notifySelection(null);
            }
        });
        GestureListenerManager.fromWebContents(webContents).addListener(new GestureStateListener() { // from class: org.chromium.content.browser.input.SelectPopupDropdown.3
            @Override // org.chromium.content_public.browser.GestureStateListener
            public void onScrollStarted(int scrollOffsetY, int scrollExtentY) {
                SelectPopupDropdown.this.hide(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySelection(int[] indicies) {
        if (this.mSelectionNotified) {
            return;
        }
        this.mSelectPopup.selectMenuItems(indicies);
        this.mSelectionNotified = true;
    }

    @Override // org.chromium.content.browser.input.SelectPopup.Ui
    public void show() {
        this.mDropdownPopupWindow.postShow();
    }

    @Override // org.chromium.content.browser.input.SelectPopup.Ui
    public void hide(boolean sendsCancelMessage) {
        if (sendsCancelMessage) {
            this.mDropdownPopupWindow.dismiss();
            notifySelection(null);
            return;
        }
        this.mSelectionNotified = true;
        this.mDropdownPopupWindow.dismiss();
    }
}
