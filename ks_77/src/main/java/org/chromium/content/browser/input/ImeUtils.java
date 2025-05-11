package org.chromium.content.browser.input;

import android.text.Editable;
import android.text.Selection;
import android.util.StringBuilderPrinter;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import java.util.Locale;
import org.chromium.base.ThreadUtils;
import org.chromium.blink.mojom.WebFeature;
import org.chromium.blink_public.web.WebInputEventModifier;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;
import org.chromium.device.mojom.HidConstants;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/ImeUtils.class */
public class ImeUtils {
    public static void computeEditorInfo(int inputType, int inputFlags, int inputMode, int inputAction, int initialSelStart, int initialSelEnd, EditorInfo outAttrs) {
        outAttrs.inputType = HidConstants.GENERIC_DESKTOP_SYSTEM_UNDOCK;
        if ((inputFlags & 2) != 0) {
            outAttrs.inputType |= WebInputEventModifier.IS_COMPATIBILITY_EVENT_FOR_TOUCH;
        }
        if (inputMode == 0) {
            if (inputType == 1) {
                if ((inputFlags & 8) == 0) {
                    outAttrs.inputType |= 32768;
                }
            } else if (inputType == 14 || inputType == 15) {
                outAttrs.inputType |= WebInputEventModifier.SYMBOL_KEY;
                if ((inputFlags & 8) == 0) {
                    outAttrs.inputType |= 32768;
                }
            } else if (inputType == 2) {
                outAttrs.inputType = 225;
            } else if (inputType == 7) {
                outAttrs.inputType = 17;
            } else if (inputType == 4) {
                outAttrs.inputType = WebFeature.SVG_POINT_MATRIX_TRANSFORM;
            } else if (inputType == 6) {
                outAttrs.inputType = 3;
            } else if (inputType == 5) {
                outAttrs.inputType = 8194;
            }
        } else {
            switch (inputMode) {
                case 0:
                case 1:
                case 2:
                case 8:
                default:
                    outAttrs.inputType |= WebInputEventModifier.SYMBOL_KEY;
                    if ((inputFlags & 8) == 0) {
                        outAttrs.inputType |= 32768;
                        break;
                    }
                    break;
                case 3:
                    outAttrs.inputType = 3;
                    break;
                case 4:
                    outAttrs.inputType = 17;
                    break;
                case 5:
                    outAttrs.inputType = WebFeature.SVG_POINT_MATRIX_TRANSFORM;
                    break;
                case 6:
                    outAttrs.inputType = 2;
                    break;
                case 7:
                    outAttrs.inputType = 8194;
                    break;
            }
        }
        outAttrs.imeOptions |= getImeAction(inputType, inputFlags, inputMode, inputAction, (outAttrs.inputType & WebInputEventModifier.SYMBOL_KEY) != 0);
        if ((inputFlags & 128) != 0) {
            outAttrs.inputType |= 4096;
        } else if ((inputFlags & 256) != 0) {
            outAttrs.inputType |= 8192;
        } else if ((inputFlags & 512) != 0) {
            outAttrs.inputType |= 16384;
        }
        if ((inputFlags & 4096) != 0) {
            outAttrs.inputType = 225;
        }
        outAttrs.initialSelStart = initialSelStart;
        outAttrs.initialSelEnd = initialSelEnd;
    }

    private static int getImeAction(int inputType, int inputFlags, int inputMode, int inputAction, boolean isMultiLineInput) {
        int imeAction = 0;
        if (inputAction == 0) {
            if (inputMode == 0 && inputType == 3) {
                imeAction = 0 | 3;
            } else if (isMultiLineInput) {
                imeAction = 0 | 1;
            } else if ((inputFlags & 1024) != 0) {
                imeAction = 0 | 5;
            } else {
                imeAction = 0 | 2;
            }
        } else {
            switch (inputAction) {
                case 1:
                    imeAction = 0 | 1;
                    break;
                case 2:
                    imeAction = 0 | 6;
                    break;
                case 3:
                    imeAction = 0 | 2;
                    break;
                case 4:
                    imeAction = 0 | 5;
                    break;
                case 5:
                    imeAction = 0 | 7;
                    break;
                case 6:
                    imeAction = 0 | 3;
                    break;
                case 7:
                    imeAction = 0 | 4;
                    break;
            }
        }
        return imeAction;
    }

    static String getEditorInfoDebugString(EditorInfo editorInfo) {
        StringBuilder builder = new StringBuilder();
        StringBuilderPrinter printer = new StringBuilderPrinter(builder);
        editorInfo.dump(printer, CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE);
        return builder.toString();
    }

    static String getEditableDebugString(Editable editable) {
        return String.format(Locale.US, "Editable {[%s] SEL[%d %d] COM[%d %d]}", editable.toString(), Integer.valueOf(Selection.getSelectionStart(editable)), Integer.valueOf(Selection.getSelectionEnd(editable)), Integer.valueOf(BaseInputConnection.getComposingSpanStart(editable)), Integer.valueOf(BaseInputConnection.getComposingSpanEnd(editable)));
    }

    static String getCorrectionInfoDebugString(CorrectionInfo correctionInfo) {
        return correctionInfo.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkCondition(boolean condition) {
        if (!condition) {
            throw new AssertionError();
        }
    }

    static void checkCondition(String msg, boolean condition) {
        if (!condition) {
            throw new AssertionError(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkOnUiThread() {
        checkCondition("Should be on UI thread.", ThreadUtils.runningOnUiThread());
    }
}
