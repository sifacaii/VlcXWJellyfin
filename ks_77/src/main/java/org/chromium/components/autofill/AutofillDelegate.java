package org.chromium.components.autofill;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/autofill/AutofillDelegate.class */
public interface AutofillDelegate {
    void dismissed();

    void suggestionSelected(int i);

    void deleteSuggestion(int i);

    void accessibilityFocusCleared();
}
