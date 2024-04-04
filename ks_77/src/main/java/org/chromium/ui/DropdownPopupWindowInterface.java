package org.chromium.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import org.chromium.base.VisibleForTesting;

@VisibleForTesting
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/DropdownPopupWindowInterface.class */
public interface DropdownPopupWindowInterface {
    void setAdapter(ListAdapter listAdapter);

    void setInitialSelection(int i);

    void show();

    void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    void setRtl(boolean z);

    void disableHideOnOutsideTap();

    void setContentDescriptionForAccessibility(CharSequence charSequence);

    void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener);

    void setFooterView(View view);

    void postShow();

    void dismiss();

    ListView getListView();

    boolean isShowing();
}
