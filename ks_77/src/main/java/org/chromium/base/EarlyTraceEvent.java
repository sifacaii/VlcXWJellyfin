package org.chromium.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("base::android")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/EarlyTraceEvent.class */
public class EarlyTraceEvent {
    private static final String TRACE_CONFIG_FILENAME = "/data/local/chrome-trace-config.json";
    @VisibleForTesting
    static final int STATE_DISABLED = 0;
    @VisibleForTesting
    static final int STATE_ENABLED = 1;
    @VisibleForTesting
    static final int STATE_FINISHING = 2;
    @VisibleForTesting
    static final int STATE_FINISHED = 3;
    private static final String BACKGROUND_STARTUP_TRACING_ENABLED_KEY = "bg_startup_tracing";
    private static boolean sCachedBackgroundStartupTracingFlag;
    private static final Object sLock = new Object();
    @VisibleForTesting
    static volatile int sState = 0;
    @GuardedBy("sLock")
    @VisibleForTesting
    static List<Event> sCompletedEvents;
    @GuardedBy("sLock")
    @VisibleForTesting
    static Map<String, Event> sPendingEventByKey;
    @GuardedBy("sLock")
    @VisibleForTesting
    static List<AsyncEvent> sAsyncEvents;
    @GuardedBy("sLock")
    @VisibleForTesting
    static List<String> sPendingAsyncEvents;

    private static native void nativeRecordEarlyEvent(String str, long j, long j2, int i, long j3);

    private static native void nativeRecordEarlyStartAsyncEvent(String str, long j, long j2);

    private static native void nativeRecordEarlyFinishAsyncEvent(String str, long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/EarlyTraceEvent$Event.class */
    public static final class Event {
        final String mName;
        final int mThreadId = Process.myTid();
        final long mBeginTimeNanos = elapsedRealtimeNanos();
        final long mBeginThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        long mEndTimeNanos;
        long mEndThreadTimeMillis;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !EarlyTraceEvent.class.desiredAssertionStatus();
        }

        Event(String name) {
            this.mName = name;
        }

        void end() {
            if (!$assertionsDisabled && this.mEndTimeNanos != 0) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && this.mEndThreadTimeMillis != 0) {
                throw new AssertionError();
            }
            this.mEndTimeNanos = elapsedRealtimeNanos();
            this.mEndThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        }

        @VisibleForTesting
        @SuppressLint({"NewApi"})
        static long elapsedRealtimeNanos() {
            if (Build.VERSION.SDK_INT >= 17) {
                return SystemClock.elapsedRealtimeNanos();
            }
            return SystemClock.elapsedRealtime() * 1000000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/EarlyTraceEvent$AsyncEvent.class */
    public static final class AsyncEvent {
        final boolean mIsStart;
        final String mName;
        final long mId;
        final long mTimestampNanos = Event.elapsedRealtimeNanos();

        AsyncEvent(String name, long id, boolean isStart) {
            this.mName = name;
            this.mId = id;
            this.mIsStart = isStart;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void maybeEnable() {
        ThreadUtils.assertOnUiThread();
        if (sState != 0) {
            return;
        }
        boolean shouldEnable = false;
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        try {
            if (CommandLine.getInstance().hasSwitch("trace-startup")) {
                shouldEnable = true;
            } else {
                try {
                    shouldEnable = new File(TRACE_CONFIG_FILENAME).exists();
                } catch (SecurityException e) {
                }
            }
            if (ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, false)) {
                if (shouldEnable) {
                    setBackgroundStartupTracingFlag(false);
                    sCachedBackgroundStartupTracingFlag = false;
                } else {
                    sCachedBackgroundStartupTracingFlag = true;
                    shouldEnable = true;
                }
            }
            if (shouldEnable) {
                enable();
            }
        } finally {
            StrictMode.setThreadPolicy(oldPolicy);
        }
    }

    @VisibleForTesting
    static void enable() {
        synchronized (sLock) {
            if (sState != 0) {
                return;
            }
            sCompletedEvents = new ArrayList();
            sPendingEventByKey = new HashMap();
            sAsyncEvents = new ArrayList();
            sPendingAsyncEvents = new ArrayList();
            sState = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void disable() {
        synchronized (sLock) {
            if (enabled()) {
                sState = 2;
                maybeFinishLocked();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isActive() {
        int state = sState;
        return state == 1 || state == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean enabled() {
        return sState == 1;
    }

    @CalledByNative
    static void setBackgroundStartupTracingFlag(boolean enabled) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, enabled).apply();
    }

    @CalledByNative
    public static boolean getBackgroundStartupTracingFlag() {
        return sCachedBackgroundStartupTracingFlag;
    }

    public static void begin(String name) {
        if (enabled()) {
            Event event = new Event(name);
            synchronized (sLock) {
                if (enabled()) {
                    Event conflictingEvent = sPendingEventByKey.put(makeEventKeyForCurrentThread(name), event);
                    if (conflictingEvent != null) {
                        throw new IllegalArgumentException("Multiple pending trace events can't have the same name: " + name);
                    }
                }
            }
        }
    }

    public static void end(String name) {
        if (isActive()) {
            synchronized (sLock) {
                if (isActive()) {
                    Event event = sPendingEventByKey.remove(makeEventKeyForCurrentThread(name));
                    if (event == null) {
                        return;
                    }
                    event.end();
                    sCompletedEvents.add(event);
                    if (sState == 2) {
                        maybeFinishLocked();
                    }
                }
            }
        }
    }

    public static void startAsync(String name, long id) {
        if (enabled()) {
            AsyncEvent event = new AsyncEvent(name, id, true);
            synchronized (sLock) {
                if (enabled()) {
                    sAsyncEvents.add(event);
                    sPendingAsyncEvents.add(name);
                }
            }
        }
    }

    public static void finishAsync(String name, long id) {
        if (isActive()) {
            AsyncEvent event = new AsyncEvent(name, id, false);
            synchronized (sLock) {
                if (isActive()) {
                    if (sPendingAsyncEvents.remove(name)) {
                        sAsyncEvents.add(event);
                        if (sState == 2) {
                            maybeFinishLocked();
                        }
                    }
                }
            }
        }
    }

    @VisibleForTesting
    static void resetForTesting() {
        synchronized (sLock) {
            sState = 0;
            sCompletedEvents = null;
            sPendingEventByKey = null;
            sAsyncEvents = null;
            sPendingAsyncEvents = null;
        }
    }

    @GuardedBy("sLock")
    private static void maybeFinishLocked() {
        if (!sCompletedEvents.isEmpty()) {
            dumpEvents(sCompletedEvents);
            sCompletedEvents.clear();
        }
        if (!sAsyncEvents.isEmpty()) {
            dumpAsyncEvents(sAsyncEvents);
            sAsyncEvents.clear();
        }
        if (sPendingEventByKey.isEmpty() && sPendingAsyncEvents.isEmpty()) {
            sState = 3;
            sPendingEventByKey = null;
            sCompletedEvents = null;
            sPendingAsyncEvents = null;
            sAsyncEvents = null;
        }
    }

    private static void dumpEvents(List<Event> events) {
        long offsetNanos = getOffsetNanos();
        for (Event e : events) {
            nativeRecordEarlyEvent(e.mName, e.mBeginTimeNanos + offsetNanos, e.mEndTimeNanos + offsetNanos, e.mThreadId, e.mEndThreadTimeMillis - e.mBeginThreadTimeMillis);
        }
    }

    private static void dumpAsyncEvents(List<AsyncEvent> events) {
        long offsetNanos = getOffsetNanos();
        for (AsyncEvent e : events) {
            if (e.mIsStart) {
                nativeRecordEarlyStartAsyncEvent(e.mName, e.mId, e.mTimestampNanos + offsetNanos);
            } else {
                nativeRecordEarlyFinishAsyncEvent(e.mName, e.mId, e.mTimestampNanos + offsetNanos);
            }
        }
    }

    private static long getOffsetNanos() {
        long nativeNowNanos = TimeUtils.nativeGetTimeTicksNowUs() * 1000;
        long javaNowNanos = Event.elapsedRealtimeNanos();
        return nativeNowNanos - javaNowNanos;
    }

    @VisibleForTesting
    static String makeEventKeyForCurrentThread(String name) {
        return name + "@" + Process.myTid();
    }
}
