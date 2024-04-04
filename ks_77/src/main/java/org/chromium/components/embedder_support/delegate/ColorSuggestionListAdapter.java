package org.chromium.components.embedder_support.delegate;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import androidx.core.view.MarginLayoutParamsCompat;

import org.xwalk.core.R;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/embedder_support/delegate/ColorSuggestionListAdapter.class */
public class ColorSuggestionListAdapter extends BaseAdapter implements View.OnClickListener {
    private Context mContext;
    private ColorSuggestion[] mSuggestions;
    private OnColorSuggestionClickListener mListener;
    private static final int COLORS_PER_ROW = 4;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/embedder_support/delegate/ColorSuggestionListAdapter$OnColorSuggestionClickListener.class */
    public interface OnColorSuggestionClickListener {
        void onColorSuggestionClick(ColorSuggestion colorSuggestion);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorSuggestionListAdapter(Context context, ColorSuggestion[] suggestions) {
        this.mContext = context;
        this.mSuggestions = suggestions;
    }

    public void setOnColorSuggestionClickListener(OnColorSuggestionClickListener listener) {
        this.mListener = listener;
    }

    private void setUpColorButton(View button, int index) {
        if (index >= this.mSuggestions.length) {
            button.setTag(null);
            button.setContentDescription(null);
            button.setVisibility(View.INVISIBLE);
            return;
        }
        button.setTag(this.mSuggestions[index]);
        button.setVisibility(View.VISIBLE);
        ColorSuggestion suggestion = this.mSuggestions[index];
        LayerDrawable layers = (LayerDrawable) button.getBackground();
        GradientDrawable swatch = (GradientDrawable) layers.findDrawableByLayerId(R.id.color_button_swatch);
        swatch.setColor(suggestion.mColor);
        String description = suggestion.mLabel;
        if (TextUtils.isEmpty(description)) {
            description = String.format("#%06X", Integer.valueOf(16777215 & suggestion.mColor));
        }
        button.setContentDescription(description);
        button.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        ColorSuggestion suggestion;
        if (this.mListener == null || (suggestion = (ColorSuggestion) v.getTag()) == null) {
            return;
        }
        this.mListener.onColorSuggestionClick(suggestion);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout;
        if (convertView instanceof LinearLayout) {
            layout = (LinearLayout) convertView;
        } else {
            layout = new LinearLayout(this.mContext);
            layout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setBackgroundColor(-1);
            int buttonHeight = this.mContext.getResources().getDimensionPixelOffset(R.dimen.color_button_height);
            for (int i = 0; i < 4; i++) {
                View button = new View(this.mContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, buttonHeight, 1.0f);
                MarginLayoutParamsCompat.setMarginStart(layoutParams, -1);
                if (i == 3) {
                    MarginLayoutParamsCompat.setMarginEnd(layoutParams, -1);
                }
                button.setLayoutParams(layoutParams);
                button.setBackgroundResource(R.drawable.color_button_background);
                layout.addView(button);
            }
        }
        for (int i2 = 0; i2 < 4; i2++) {
            setUpColorButton(layout.getChildAt(i2), (position * 4) + i2);
        }
        return layout;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ((this.mSuggestions.length + 4) - 1) / 4;
    }
}
