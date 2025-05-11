package org.chromium.components.embedder_support.delegate;

import android.content.Context;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.ui.base.WindowAndroid;

@JNINamespace("web_contents_delegate_android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/embedder_support/delegate/ColorChooserAndroid.class */
public class ColorChooserAndroid {
    private final ColorPickerDialog mDialog;
    private final long mNativeColorChooserAndroid;

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnColorChosen(long j, int i);

    private ColorChooserAndroid(long nativeColorChooserAndroid, Context context, int initialColor, ColorSuggestion[] suggestions) {
        OnColorChangedListener listener = new OnColorChangedListener() { // from class: org.chromium.components.embedder_support.delegate.ColorChooserAndroid.1
            @Override // org.chromium.components.embedder_support.delegate.OnColorChangedListener
            public void onColorChanged(int color) {
                ColorChooserAndroid.this.mDialog.dismiss();
                ColorChooserAndroid.this.nativeOnColorChosen(ColorChooserAndroid.this.mNativeColorChooserAndroid, color);
            }
        };
        this.mNativeColorChooserAndroid = nativeColorChooserAndroid;
        this.mDialog = new ColorPickerDialog(context, listener, initialColor, suggestions);
    }

    private void openColorChooser() {
        this.mDialog.show();
    }

    @CalledByNative
    public void closeColorChooser() {
        this.mDialog.dismiss();
    }

    @CalledByNative
    public static ColorChooserAndroid createColorChooserAndroid(long nativeColorChooserAndroid, WindowAndroid windowAndroid, int initialColor, ColorSuggestion[] suggestions) {
        if (windowAndroid == null) {
            return null;
        }
        Context windowContext = windowAndroid.getContext().get();
        if (WindowAndroid.activityFromContext(windowContext) == null) {
            return null;
        }
        ColorChooserAndroid chooser = new ColorChooserAndroid(nativeColorChooserAndroid, windowContext, initialColor, suggestions);
        chooser.openColorChooser();
        return chooser;
    }

    @CalledByNative
    private static ColorSuggestion[] createColorSuggestionArray(int size) {
        return new ColorSuggestion[size];
    }

    @CalledByNative
    private static void addToColorSuggestionArray(ColorSuggestion[] array, int index, int color, String label) {
        array[index] = new ColorSuggestion(color, label);
    }
}
