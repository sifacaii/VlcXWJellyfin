package com.pakdata.xwalk.refactor;

import android.content.Context;
import android.view.View;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.components.autofill.AutofillDelegate;
import org.chromium.components.autofill.AutofillPopup;
import org.chromium.components.autofill.AutofillSuggestion;
import org.chromium.ui.base.WindowAndroid;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkAutofillClientAndroid.class */
public class XWalkAutofillClientAndroid {
    private final long mNativeXWalkAutofillClientAndroid;
    private AutofillPopup mAutofillPopup;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDismissed(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSuggestionSelected(long j, int i);

    @CalledByNative
    public static XWalkAutofillClientAndroid create(long nativeClient) {
        return new XWalkAutofillClientAndroid(nativeClient);
    }

    private XWalkAutofillClientAndroid(long nativeXWalkAutofillClient) {
        this.mNativeXWalkAutofillClientAndroid = nativeXWalkAutofillClient;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    @CalledByNative
    private void showAutofillPopup(View anchorView, boolean isRtl, AutofillSuggestion[] suggestions) {
        if (this.mAutofillPopup == null) {
            if (WindowAndroid.activityFromContext(this.mContext) == null) {
                nativeDismissed(this.mNativeXWalkAutofillClientAndroid);
                return;
            }
            this.mAutofillPopup = new AutofillPopup(this.mContext, anchorView, new AutofillDelegate() { // from class: com.pakdata.xwalk.refactor.XWalkAutofillClientAndroid.1
                @Override // org.chromium.components.autofill.AutofillDelegate
                public void dismissed() {
                    XWalkAutofillClientAndroid.this.nativeDismissed(XWalkAutofillClientAndroid.this.mNativeXWalkAutofillClientAndroid);
                }

                @Override // org.chromium.components.autofill.AutofillDelegate
                public void suggestionSelected(int listIndex) {
                    XWalkAutofillClientAndroid.this.nativeSuggestionSelected(XWalkAutofillClientAndroid.this.mNativeXWalkAutofillClientAndroid, listIndex);
                }

                @Override // org.chromium.components.autofill.AutofillDelegate
                public void deleteSuggestion(int listIndex) {
                }

                @Override // org.chromium.components.autofill.AutofillDelegate
                public void accessibilityFocusCleared() {
                }
            });
        }
        this.mAutofillPopup.filterAndShow(suggestions, isRtl, false);
    }

    @CalledByNative
    public void hideAutofillPopup() {
        if (this.mAutofillPopup == null) {
            return;
        }
        this.mAutofillPopup.dismiss();
        this.mAutofillPopup = null;
    }

    @CalledByNative
    private static AutofillSuggestion[] createAutofillSuggestionArray(int size) {
        return new AutofillSuggestion[size];
    }

    @CalledByNative
    private static void addToAutofillSuggestionArray(AutofillSuggestion[] array, int index, String name, String label, int uniqueId) {
        array[index] = new AutofillSuggestion(name, label, 0, false, uniqueId, false, false, false);
    }
}
