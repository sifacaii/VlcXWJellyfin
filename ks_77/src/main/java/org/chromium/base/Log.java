package org.chromium.base;

import java.util.Locale;
import org.chromium.base.annotations.RemovableInRelease;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/Log.class */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sTagPrefix = "cr_";
    private static final String sDeprecatedTagPrefix = "cr.";

    private Log() {
    }

    private static String formatLog(String messageTemplate, Object... params) {
        if (params != null && params.length != 0) {
            messageTemplate = String.format(Locale.US, messageTemplate, params);
        }
        return messageTemplate;
    }

    public static String normalizeTag(String tag) {
        if (tag.startsWith(sTagPrefix)) {
            return tag;
        }
        int unprefixedTagStart = 0;
        if (tag.startsWith(sDeprecatedTagPrefix)) {
            unprefixedTagStart = sDeprecatedTagPrefix.length();
        }
        return sTagPrefix + tag.substring(unprefixedTagStart, tag.length());
    }

    private static String formatLogWithStack(String messageTemplate, Object... params) {
        return "[" + getCallOrigin() + "] " + formatLog(messageTemplate, params);
    }

    public static boolean isLoggable(String tag, int level) {
        return android.util.Log.isLoggable(tag, level);
    }

    private static void verbose(String tag, String messageTemplate, Object... args) {
        String message = formatLogWithStack(messageTemplate, args);
        Throwable tr = getThrowableToLog(args);
        if (tr != null) {
            android.util.Log.v(normalizeTag(tag), message, tr);
        } else {
            android.util.Log.v(normalizeTag(tag), message);
        }
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void v(String tag, String message) {
        verbose(tag, message, new Object[0]);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void v(String tag, String messageTemplate, Object arg1) {
        verbose(tag, messageTemplate, arg1);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void v(String tag, String messageTemplate, Object arg1, Object arg2) {
        verbose(tag, messageTemplate, arg1, arg2);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void v(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3) {
        verbose(tag, messageTemplate, arg1, arg2, arg3);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void v(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3, Object arg4) {
        verbose(tag, messageTemplate, arg1, arg2, arg3, arg4);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void v(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        verbose(tag, messageTemplate, arg1, arg2, arg3, arg4, arg5);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void v(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
        verbose(tag, messageTemplate, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void v(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
        verbose(tag, messageTemplate, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private static void debug(String tag, String messageTemplate, Object... args) {
        String message = formatLogWithStack(messageTemplate, args);
        Throwable tr = getThrowableToLog(args);
        if (tr != null) {
            android.util.Log.d(normalizeTag(tag), message, tr);
        } else {
            android.util.Log.d(normalizeTag(tag), message);
        }
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void d(String tag, String message) {
        debug(tag, message, new Object[0]);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void d(String tag, String messageTemplate, Object arg1) {
        debug(tag, messageTemplate, arg1);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void d(String tag, String messageTemplate, Object arg1, Object arg2) {
        debug(tag, messageTemplate, arg1, arg2);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void d(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3) {
        debug(tag, messageTemplate, arg1, arg2, arg3);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void d(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3, Object arg4) {
        debug(tag, messageTemplate, arg1, arg2, arg3, arg4);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void d(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        debug(tag, messageTemplate, arg1, arg2, arg3, arg4, arg5);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void d(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
        debug(tag, messageTemplate, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @RemovableInRelease
    @VisibleForTesting
    public static void d(String tag, String messageTemplate, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
        debug(tag, messageTemplate, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @VisibleForTesting
    public static void i(String tag, String messageTemplate, Object... args) {
        String message = formatLog(messageTemplate, args);
        Throwable tr = getThrowableToLog(args);
        if (tr != null) {
            android.util.Log.i(normalizeTag(tag), message, tr);
        } else {
            android.util.Log.i(normalizeTag(tag), message);
        }
    }

    @VisibleForTesting
    public static void w(String tag, String messageTemplate, Object... args) {
        String message = formatLog(messageTemplate, args);
        Throwable tr = getThrowableToLog(args);
        if (tr != null) {
            android.util.Log.w(normalizeTag(tag), message, tr);
        } else {
            android.util.Log.w(normalizeTag(tag), message);
        }
    }

    @VisibleForTesting
    public static void e(String tag, String messageTemplate, Object... args) {
        String message = formatLog(messageTemplate, args);
        Throwable tr = getThrowableToLog(args);
        if (tr != null) {
            android.util.Log.e(normalizeTag(tag), message, tr);
        } else {
            android.util.Log.e(normalizeTag(tag), message);
        }
    }

    @VisibleForTesting
    public static void wtf(String tag, String messageTemplate, Object... args) {
        String message = formatLog(messageTemplate, args);
        Throwable tr = getThrowableToLog(args);
        if (tr != null) {
            android.util.Log.wtf(normalizeTag(tag), message, tr);
        } else {
            android.util.Log.wtf(normalizeTag(tag), message);
        }
    }

    public static String getStackTraceString(Throwable tr) {
        return android.util.Log.getStackTraceString(tr);
    }

    private static Throwable getThrowableToLog(Object[] args) {
        if (args == null || args.length == 0) {
            return null;
        }
        Object lastArg = args[args.length - 1];
        if (lastArg instanceof Throwable) {
            return (Throwable) lastArg;
        }
        return null;
    }

    private static String getCallOrigin() {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        String logClassName = Log.class.getName();
        int callerStackIndex = 0;
        while (true) {
            if (callerStackIndex >= st.length) {
                break;
            } else if (!st[callerStackIndex].getClassName().equals(logClassName)) {
                callerStackIndex++;
            } else {
                callerStackIndex += 4;
                break;
            }
        }
        return st[callerStackIndex].getFileName() + ":" + st[callerStackIndex].getLineNumber();
    }
}
