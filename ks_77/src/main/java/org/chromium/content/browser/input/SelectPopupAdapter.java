package org.chromium.content.browser.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/SelectPopupAdapter.class */
public class SelectPopupAdapter extends ArrayAdapter<SelectPopupItem> {
    private List<SelectPopupItem> mItems;
    private boolean mAreAllItemsEnabled;

    public SelectPopupAdapter(Context context, int layoutResource, List<SelectPopupItem> items) {
        super(context, layoutResource, items);
        this.mItems = new ArrayList(items);
        this.mAreAllItemsEnabled = true;
        for (int i = 0; i < this.mItems.size(); i++) {
            if (this.mItems.get(i).getType() != 2) {
                this.mAreAllItemsEnabled = false;
                return;
            }
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position < 0 || position >= getCount()) {
            return null;
        }
        View convertView2 = super.getView(position, convertView, parent);
        ((TextView) convertView2).setText(this.mItems.get(position).getLabel());
        if (convertView2 instanceof CheckedTextView) {
            CheckedTextView view = (CheckedTextView) convertView2;
            if (this.mItems.get(position).getType() == 0) {
                if (view.getCheckMarkDrawable() != null) {
                    view.setTag(view.getCheckMarkDrawable());
                    view.setCheckMarkDrawable((Drawable) null);
                }
            } else if (view.getCheckMarkDrawable() == null) {
                view.setCheckMarkDrawable((Drawable) view.getTag());
            }
        }
        convertView2.setEnabled(this.mItems.get(position).getType() != 1);
        return convertView2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mAreAllItemsEnabled;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return position >= 0 && position < getCount() && this.mItems.get(position).getType() == 2;
    }
}
