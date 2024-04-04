package org.chromium.content.browser.picker;

import android.text.TextUtils;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/picker/DateTimeSuggestion.class */
public class DateTimeSuggestion {
    private final double mValue;
    private final String mLocalizedValue;
    private final String mLabel;

    public DateTimeSuggestion(double value, String localizedValue, String label) {
        this.mValue = value;
        this.mLocalizedValue = localizedValue;
        this.mLabel = label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double value() {
        return this.mValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String localizedValue() {
        return this.mLocalizedValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String label() {
        return this.mLabel;
    }

    public boolean equals(Object object) {
        if (!(object instanceof DateTimeSuggestion)) {
            return false;
        }
        DateTimeSuggestion other = (DateTimeSuggestion) object;
        return this.mValue == other.mValue && TextUtils.equals(this.mLocalizedValue, other.mLocalizedValue) && TextUtils.equals(this.mLabel, other.mLabel);
    }

    public int hashCode() {
        int hash = (37 * 31) + ((int) this.mValue);
        return (37 * ((37 * hash) + this.mLocalizedValue.hashCode())) + this.mLabel.hashCode();
    }
}
