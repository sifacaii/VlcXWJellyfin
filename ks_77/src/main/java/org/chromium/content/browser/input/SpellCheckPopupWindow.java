package org.chromium.content.browser.input;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import org.chromium.ui.base.WindowAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/SpellCheckPopupWindow.class */
public class SpellCheckPopupWindow extends SuggestionsPopupWindow {
    private String[] mSuggestions;

    public SpellCheckPopupWindow(Context context, TextSuggestionHost textSuggestionHost, WindowAndroid windowAndroid, View parentView) {
        super(context, textSuggestionHost, windowAndroid, parentView);
        this.mSuggestions = new String[0];
    }

    public void show(double caretX, double caretY, String highlightedText, String[] suggestions) {
        this.mSuggestions = (String[]) suggestions.clone();
        setAddToDictionaryEnabled(true);
        super.show(caretX, caretY, highlightedText);
    }

    @Override // org.chromium.content.browser.input.SuggestionsPopupWindow
    protected int getSuggestionsCount() {
        return this.mSuggestions.length;
    }

    @Override // org.chromium.content.browser.input.SuggestionsPopupWindow
    protected Object getSuggestionItem(int position) {
        return this.mSuggestions[position];
    }

    @Override // org.chromium.content.browser.input.SuggestionsPopupWindow
    protected SpannableString getSuggestionText(int position) {
        return new SpannableString(this.mSuggestions[position]);
    }

    @Override // org.chromium.content.browser.input.SuggestionsPopupWindow
    protected void applySuggestion(int position) {
        this.mTextSuggestionHost.applySpellCheckSuggestion(this.mSuggestions[position]);
    }
}
