package org.chromium.content.browser.selection;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextSelection;
import java.lang.reflect.Method;
import org.chromium.content.browser.selection.SmartSelectionMetricsLogger;

@TargetApi(26)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SelectionEventProxyImpl.class */
public class SelectionEventProxyImpl implements SmartSelectionMetricsLogger.SelectionEventProxy {
    private static final String TAG = "SmartSelectionLogger";
    private static final boolean DEBUG = false;
    private static final String SELECTION_EVENT_CLASS = "android.view.textclassifier.logging.SmartSelectionEventTracker$SelectionEvent";
    private static Class<?> sSelectionEventClass;
    private static Method sSelectionStartedMethod;
    private static Method sSelectionModifiedMethod;
    private static Method sSelectionModifiedClassificationMethod;
    private static Method sSelectionModifiedSelectionMethod;
    private static Method sSelectionActionMethod;
    private static Method sSelectionActionClassificationMethod;
    private static boolean sReflectionFailed;

    public static SelectionEventProxyImpl create() {
        if (sReflectionFailed) {
            return null;
        }
        if (sSelectionEventClass == null) {
            try {
                sSelectionEventClass = Class.forName(SELECTION_EVENT_CLASS);
                sSelectionStartedMethod = sSelectionEventClass.getMethod("selectionStarted", Integer.TYPE);
                sSelectionModifiedMethod = sSelectionEventClass.getMethod("selectionModified", Integer.TYPE, Integer.TYPE);
                sSelectionModifiedClassificationMethod = sSelectionEventClass.getMethod("selectionModified", Integer.TYPE, Integer.TYPE, TextClassification.class);
                sSelectionModifiedSelectionMethod = sSelectionEventClass.getMethod("selectionModified", Integer.TYPE, Integer.TYPE, TextSelection.class);
                sSelectionActionMethod = sSelectionEventClass.getMethod("selectionAction", Integer.TYPE, Integer.TYPE, Integer.TYPE);
                sSelectionActionClassificationMethod = sSelectionEventClass.getMethod("selectionAction", Integer.TYPE, Integer.TYPE, Integer.TYPE, TextClassification.class);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                sReflectionFailed = true;
                return null;
            }
        }
        return new SelectionEventProxyImpl();
    }

    private SelectionEventProxyImpl() {
    }

    @Override // org.chromium.content.browser.selection.SmartSelectionMetricsLogger.SelectionEventProxy
    public Object createSelectionStarted(int start) {
        try {
            return sSelectionStartedMethod.invoke(null, Integer.valueOf(start));
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

    @Override // org.chromium.content.browser.selection.SmartSelectionMetricsLogger.SelectionEventProxy
    public Object createSelectionModified(int start, int end) {
        try {
            return sSelectionModifiedMethod.invoke(null, Integer.valueOf(start), Integer.valueOf(end));
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

    @Override // org.chromium.content.browser.selection.SmartSelectionMetricsLogger.SelectionEventProxy
    public Object createSelectionModifiedClassification(int start, int end, @NonNull Object classification) {
        try {
            return sSelectionModifiedClassificationMethod.invoke(null, Integer.valueOf(start), Integer.valueOf(end), (TextClassification) classification);
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

    @Override // org.chromium.content.browser.selection.SmartSelectionMetricsLogger.SelectionEventProxy
    public Object createSelectionModifiedSelection(int start, int end, @NonNull Object selection) {
        try {
            return sSelectionModifiedSelectionMethod.invoke(null, Integer.valueOf(start), Integer.valueOf(end), (TextSelection) selection);
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

    @Override // org.chromium.content.browser.selection.SmartSelectionMetricsLogger.SelectionEventProxy
    public Object createSelectionAction(int start, int end, int actionType) {
        try {
            return sSelectionActionMethod.invoke(null, Integer.valueOf(start), Integer.valueOf(end), Integer.valueOf(actionType));
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

    @Override // org.chromium.content.browser.selection.SmartSelectionMetricsLogger.SelectionEventProxy
    public Object createSelectionAction(int start, int end, int actionType, @NonNull Object classification) {
        try {
            return sSelectionActionClassificationMethod.invoke(null, Integer.valueOf(start), Integer.valueOf(end), Integer.valueOf(actionType), (TextClassification) classification);
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }
}
