package org.chromium.content.browser.selection;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.chromium.base.VisibleForTesting;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.content_public.browser.SelectionMetricsLogger;

@TargetApi(26)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SmartSelectionMetricsLogger.class */
public class SmartSelectionMetricsLogger implements SelectionMetricsLogger {
    private static final String TAG = "SmartSelectionLogger";
    private static final boolean DEBUG = false;
    private static final String TRACKER_CLASS = "android.view.textclassifier.logging.SmartSelectionEventTracker";
    private static Class<?> sTrackerClass;
    private static Class<?> sSelectionEventClass;
    private static Constructor sTrackerConstructor;
    private static Method sLogEventMethod;
    private static boolean sReflectionFailed;
    private Context mContext;
    private Object mTracker;
    private SelectionEventProxy mSelectionEventProxy;
    private SelectionIndicesConverter mConverter;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SmartSelectionMetricsLogger$ActionType.class */
    public @interface ActionType {
        public static final int OVERTYPE = 100;
        public static final int COPY = 101;
        public static final int PASTE = 102;
        public static final int CUT = 103;
        public static final int SHARE = 104;
        public static final int SMART_SHARE = 105;
        public static final int DRAG = 106;
        public static final int ABANDON = 107;
        public static final int OTHER = 108;
        public static final int SELECT_ALL = 200;
        public static final int RESET = 201;
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SmartSelectionMetricsLogger$SelectionEventProxy.class */
    public interface SelectionEventProxy {
        Object createSelectionStarted(int i);

        Object createSelectionModified(int i, int i2);

        Object createSelectionModifiedClassification(int i, int i2, Object obj);

        Object createSelectionModifiedSelection(int i, int i2, Object obj);

        Object createSelectionAction(int i, int i2, int i3);

        Object createSelectionAction(int i, int i2, int i3, Object obj);
    }

    public static SmartSelectionMetricsLogger create(Context context) {
        if (Build.VERSION.SDK_INT <= 26 || context == null || sReflectionFailed) {
            return null;
        }
        if (sTrackerClass == null) {
            try {
                sTrackerClass = Class.forName(TRACKER_CLASS);
                sSelectionEventClass = Class.forName("android.view.textclassifier.logging.SmartSelectionEventTracker$SelectionEvent");
                sTrackerConstructor = sTrackerClass.getConstructor(Context.class, Integer.TYPE);
                sLogEventMethod = sTrackerClass.getMethod("logEvent", sSelectionEventClass);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                sReflectionFailed = true;
                return null;
            }
        }
        SelectionEventProxy selectionEventProxy = SelectionEventProxyImpl.create();
        if (selectionEventProxy == null) {
            return null;
        }
        return new SmartSelectionMetricsLogger(context, selectionEventProxy);
    }

    private SmartSelectionMetricsLogger(Context context, SelectionEventProxy selectionEventProxy) {
        this.mContext = context;
        this.mSelectionEventProxy = selectionEventProxy;
    }

    @VisibleForTesting
    protected SmartSelectionMetricsLogger(SelectionEventProxy selectionEventProxy) {
        this.mSelectionEventProxy = selectionEventProxy;
    }

    public void logSelectionStarted(String selectionText, int startOffset, boolean editable) {
        this.mTracker = createTracker(this.mContext, editable);
        this.mConverter = new SelectionIndicesConverter();
        this.mConverter.updateSelectionState(selectionText, startOffset);
        this.mConverter.setInitialStartOffset(startOffset);
        logEvent(this.mSelectionEventProxy.createSelectionStarted(0));
    }

    public void logSelectionModified(String selectionText, int startOffset, SelectionClient.Result result) {
        if (this.mTracker == null) {
            return;
        }
        if (!this.mConverter.updateSelectionState(selectionText, startOffset)) {
            this.mTracker = null;
            return;
        }
        int endOffset = startOffset + selectionText.length();
        int[] indices = new int[2];
        if (!this.mConverter.getWordDelta(startOffset, endOffset, indices)) {
            this.mTracker = null;
        } else if (result != null && result.textSelection != null) {
            logEvent(this.mSelectionEventProxy.createSelectionModifiedSelection(indices[0], indices[1], result.textSelection));
        } else if (result != null && result.textClassification != null) {
            logEvent(this.mSelectionEventProxy.createSelectionModifiedClassification(indices[0], indices[1], result.textClassification));
        } else {
            logEvent(this.mSelectionEventProxy.createSelectionModified(indices[0], indices[1]));
        }
    }

    public void logSelectionAction(String selectionText, int startOffset, int action, SelectionClient.Result result) {
        if (this.mTracker == null) {
            return;
        }
        if (!this.mConverter.updateSelectionState(selectionText, startOffset)) {
            this.mTracker = null;
            return;
        }
        int endOffset = startOffset + selectionText.length();
        int[] indices = new int[2];
        if (!this.mConverter.getWordDelta(startOffset, endOffset, indices)) {
            this.mTracker = null;
            return;
        }
        if (result != null && result.textClassification != null) {
            logEvent(this.mSelectionEventProxy.createSelectionAction(indices[0], indices[1], action, result.textClassification));
        } else {
            logEvent(this.mSelectionEventProxy.createSelectionAction(indices[0], indices[1], action));
        }
        if (isTerminal(action)) {
            this.mTracker = null;
        }
    }

    public Object createTracker(Context context, boolean editable) {
        try {
            Constructor constructor = sTrackerConstructor;
            Object[] objArr = new Object[2];
            objArr[0] = context;
            objArr[1] = Integer.valueOf(editable ? 4 : 2);
            return constructor.newInstance(objArr);
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

    public void logEvent(Object selectionEvent) {
        if (selectionEvent == null) {
            return;
        }
        try {
            sLogEventMethod.invoke(this.mTracker, sSelectionEventClass.cast(selectionEvent));
        } catch (ClassCastException | ReflectiveOperationException e) {
        }
    }

    public static boolean isTerminal(int actionType) {
        switch (actionType) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
                return true;
            default:
                return false;
        }
    }
}
