package org.chromium.components.autofill;

import android.content.Context;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;

import java.util.List;
import java.util.Set;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.ui.DropdownDividerDrawable;
import org.chromium.ui.DropdownItem;
import org.xwalk.core.R;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/autofill/AutofillDropdownAdapter.class */
public class AutofillDropdownAdapter extends ArrayAdapter<DropdownItem> {
    private final Context mContext;
    private final Set<Integer> mSeparators;
    private final boolean mAreAllItemsEnabled;
    private final int mLabelMargin;
    private final boolean mIsRefresh;

    public AutofillDropdownAdapter(Context context, List<? extends DropdownItem> items, Set<Integer> separators, boolean isRefresh) {
        super(context, isRefresh ? R.layout.autofill_dropdown_item_refresh : R.layout.autofill_dropdown_item);
        this.mContext = context;
        addAll(items);
        this.mSeparators = separators;
        this.mAreAllItemsEnabled = checkAreAllItemsEnabled();
        this.mLabelMargin = context.getResources().getDimensionPixelSize(R.dimen.autofill_dropdown_item_label_margin);
        this.mIsRefresh = isRefresh;
    }

    private boolean checkAreAllItemsEnabled() {
        for (int i = 0; i < getCount(); i++) {
            DropdownItem item = getItem(i);
            if (item.isEnabled() && !item.isGroupHeader()) {
                return false;
            }
        }
        return true;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        int dividerColor;
        View layout = convertView;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.mContext);
            int layoutId = this.mIsRefresh ? R.layout.autofill_dropdown_item_refresh : R.layout.autofill_dropdown_item;
            layout = inflater.inflate(layoutId, (ViewGroup) null);
            layout.setBackground(new DropdownDividerDrawable(null));
        }
        DropdownItem item = getItem(position);
        if (this.mIsRefresh) {
            TextView labelView = populateLabelView(item, layout);
            populateSublabelView(item, layout);
            ImageView iconView = populateIconView((ImageView) layout.findViewById(R.id.end_dropdown_icon), item);
            if (iconView != null) {
                iconView.setLayoutParams(getSizeParamsForIconView(iconView, item));
            }
            if (item.isMultilineLabel()) {
                labelView.setSingleLine(false);
                LinearLayout wrapper = (LinearLayout) layout.findViewById(R.id.dropdown_label_wrapper);
                int paddingHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.autofill_dropdown_refresh_vertical_padding);
                wrapper.setPadding(0, paddingHeight, 0, paddingHeight);
            }
            return layout;
        }
        int height = this.mContext.getResources().getDimensionPixelSize(R.dimen.autofill_dropdown_item_height);
        DropdownDividerDrawable divider = (DropdownDividerDrawable) layout.getBackground();
        if (position == 0) {
            divider.setDividerColor(0);
        } else {
            int dividerHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.autofill_dropdown_item_divider_height);
            height += dividerHeight;
            divider.setHeight(dividerHeight);
            if (this.mSeparators != null && this.mSeparators.contains(Integer.valueOf(position))) {
                dividerColor = ApiCompatibilityUtils.getColor(this.mContext.getResources(), R.color.dropdown_dark_divider_color);
            } else {
                dividerColor = ApiCompatibilityUtils.getColor(this.mContext.getResources(), R.color.dropdown_divider_color);
            }
            divider.setDividerColor(dividerColor);
        }
        LinearLayout wrapper2 = (LinearLayout) layout.findViewById(R.id.dropdown_label_wrapper);
        if (item.isMultilineLabel()) {
            height = -2;
        }
        wrapper2.setOrientation(LinearLayout.VERTICAL);
        wrapper2.setLayoutParams(new LinearLayout.LayoutParams(0, height, 1.0f));
        TextView labelView2 = populateLabelView(item, layout);
        labelView2.setSingleLine(!item.isMultilineLabel());
        if (item.isMultilineLabel()) {
            int existingStart = ViewCompat.getPaddingStart(labelView2);
            int existingEnd = ViewCompat.getPaddingEnd(labelView2);
            ViewCompat.setPaddingRelative(labelView2, existingStart, this.mLabelMargin, existingEnd, this.mLabelMargin);
        }
        if (item.isGroupHeader() || item.isBoldLabel()) {
            labelView2.setTypeface(null, Typeface.BOLD);
        } else {
            labelView2.setTypeface(null, Typeface.NORMAL);
        }
        labelView2.setTextColor(ApiCompatibilityUtils.getColor(this.mContext.getResources(), item.getLabelFontColorResId()));
        labelView2.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.text_size_large));
        TextView sublabelView = populateSublabelView(item, layout);
        if (sublabelView != null) {
            sublabelView.setTextSize(0, this.mContext.getResources().getDimension(item.getSublabelFontSizeResId()));
        }
        ImageView iconViewStart = (ImageView) layout.findViewById(R.id.start_dropdown_icon);
        ImageView iconViewEnd = (ImageView) layout.findViewById(R.id.end_dropdown_icon);
        if (item.isIconAtStart()) {
            iconViewEnd.setVisibility(View.GONE);
        } else {
            iconViewStart.setVisibility(View.GONE);
        }
        ImageView iconView2 = populateIconView(item.isIconAtStart() ? iconViewStart : iconViewEnd, item);
        if (iconView2 != null) {
            iconView2.setLayoutParams(getSizeAndMarginParamsForIconView(iconView2, item));
        }
        return layout;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mAreAllItemsEnabled;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        if (position < 0 || position >= getCount()) {
            return false;
        }
        DropdownItem item = getItem(position);
        return item.isEnabled() && !item.isGroupHeader();
    }

    private TextView populateLabelView(DropdownItem item, View layout) {
        TextView labelView = (TextView) layout.findViewById(R.id.dropdown_label);
        labelView.setEnabled(item.isEnabled());
        labelView.setText(item.getLabel());
        return labelView;
    }

    private TextView populateSublabelView(DropdownItem item, View layout) {
        TextView sublabelView = (TextView) layout.findViewById(R.id.dropdown_sublabel);
        CharSequence sublabel = item.getSublabel();
        if (TextUtils.isEmpty(sublabel)) {
            sublabelView.setVisibility(View.GONE);
            return null;
        }
        sublabelView.setText(sublabel);
        sublabelView.setVisibility(View.VISIBLE);
        return sublabelView;
    }

    private ImageView populateIconView(ImageView iconView, DropdownItem item) {
        if (item.getIconId() == 0) {
            iconView.setVisibility(View.GONE);
            return null;
        }
        iconView.setImageDrawable(AppCompatResources.getDrawable(this.mContext, item.getIconId()));
        iconView.setVisibility(View.VISIBLE);
        return iconView;
    }

    private ViewGroup.MarginLayoutParams getSizeParamsForIconView(ImageView iconView, DropdownItem item) {
        int dimensionPixelSize;
        ViewGroup.MarginLayoutParams iconLayoutParams = (ViewGroup.MarginLayoutParams) iconView.getLayoutParams();
        int iconSizeResId = item.getIconSizeResId();
        if (iconSizeResId == 0) {
            dimensionPixelSize = -2;
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(iconSizeResId);
        }
        int iconSize = dimensionPixelSize;
        iconLayoutParams.width = iconSize;
        iconLayoutParams.height = iconSize;
        return iconLayoutParams;
    }

    private ViewGroup.MarginLayoutParams getSizeAndMarginParamsForIconView(ImageView iconView, DropdownItem item) {
        ViewGroup.MarginLayoutParams params = getSizeParamsForIconView(iconView, item);
        int iconMargin = this.mContext.getResources().getDimensionPixelSize(item.getIconMarginResId());
        MarginLayoutParamsCompat.setMarginStart(params, iconMargin);
        MarginLayoutParamsCompat.setMarginEnd(params, iconMargin);
        return params;
    }
}
