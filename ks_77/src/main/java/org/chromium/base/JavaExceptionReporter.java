package org.chromium.base;

import androidx.annotation.UiThread;

import java.lang.Thread;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("base::android")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/JavaExceptionReporter.class */
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler mParent;
    private final boolean mCrashAfterReport;
    private boolean mHandlingException;
    static final /* synthetic */ boolean $assertionsDisabled;

    private static native void nativeReportJavaException(boolean z, Throwable th);

    private static native void nativeReportJavaStackTrace(String str);

    static {
        $assertionsDisabled = !JavaExceptionReporter.class.desiredAssertionStatus();
    }

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler parent, boolean crashAfterReport) {
        this.mParent = parent;
        this.mCrashAfterReport = crashAfterReport;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread t, Throwable e) {
        if (!this.mHandlingException) {
            this.mHandlingException = true;
            nativeReportJavaException(this.mCrashAfterReport, e);
        }
        if (this.mParent != null) {
            this.mParent.uncaughtException(t, e);
        }
    }

    @UiThread
    public static void reportStackTrace(String stackTrace) {
        if (!$assertionsDisabled && !ThreadUtils.runningOnUiThread()) {
            throw new AssertionError();
        }
        nativeReportJavaStackTrace(PiiElider.sanitizeStacktrace(stackTrace));
    }

    @CalledByNative
    private static void installHandler(boolean crashAfterReport) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), crashAfterReport));
    }
}
