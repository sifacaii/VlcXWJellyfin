package org.chromium.content.browser.input;

import android.app.Activity;
import android.content.Context;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.picker.DateTimeSuggestion;
import org.chromium.content.browser.picker.InputDialogContainer;
import org.chromium.ui.base.WindowAndroid;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/DateTimeChooserAndroid.class */
class DateTimeChooserAndroid {
    private final long mNativeDateTimeChooserAndroid;
    private final InputDialogContainer mInputDialogContainer;

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeReplaceDateTime(long j, double d);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeCancelDialog(long j);

    private DateTimeChooserAndroid(Context context, long nativeDateTimeChooserAndroid) {
        this.mNativeDateTimeChooserAndroid = nativeDateTimeChooserAndroid;
        this.mInputDialogContainer = new InputDialogContainer(context, new InputDialogContainer.InputActionDelegate() { // from class: org.chromium.content.browser.input.DateTimeChooserAndroid.1
            @Override // org.chromium.content.browser.picker.InputDialogContainer.InputActionDelegate
            public void replaceDateTime(double value) {
                DateTimeChooserAndroid.this.nativeReplaceDateTime(DateTimeChooserAndroid.this.mNativeDateTimeChooserAndroid, value);
            }

            @Override // org.chromium.content.browser.picker.InputDialogContainer.InputActionDelegate
            public void cancelDateTimeDialog() {
                DateTimeChooserAndroid.this.nativeCancelDialog(DateTimeChooserAndroid.this.mNativeDateTimeChooserAndroid);
            }
        });
    }

    private void showDialog(int dialogType, double dialogValue, double min, double max, double step, DateTimeSuggestion[] suggestions) {
        this.mInputDialogContainer.showDialog(dialogType, dialogValue, min, max, step, suggestions);
    }

    @CalledByNative
    private static DateTimeChooserAndroid createDateTimeChooser(WindowAndroid windowAndroid, long nativeDateTimeChooserAndroid, int dialogType, double dialogValue, double min, double max, double step, DateTimeSuggestion[] suggestions) {
        Activity windowAndroidActivity = windowAndroid.getActivity().get();
        if (windowAndroidActivity == null) {
            return null;
        }
        DateTimeChooserAndroid chooser = new DateTimeChooserAndroid(windowAndroidActivity, nativeDateTimeChooserAndroid);
        chooser.showDialog(dialogType, dialogValue, min, max, step, suggestions);
        return chooser;
    }

    @CalledByNative
    private static DateTimeSuggestion[] createSuggestionsArray(int size) {
        return new DateTimeSuggestion[size];
    }

    @CalledByNative
    private static void setDateTimeSuggestionAt(DateTimeSuggestion[] array, int index, double value, String localizedValue, String label) {
        array[index] = new DateTimeSuggestion(value, localizedValue, label);
    }
}
