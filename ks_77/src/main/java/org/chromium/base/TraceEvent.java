package org.chromium.base;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
import org.chromium.blink.mojom.WebFeature;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

@JNINamespace("base::android")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/TraceEvent.class */
public class TraceEvent implements AutoCloseable {
    private static volatile boolean sEnabled;
    private static volatile boolean sATraceEnabled;
    private final String mName;

    private static native void nativeRegisterEnabledObserver();

    private static native void nativeStartATrace();

    private static native void nativeStopATrace();

    private static native void nativeInstant(String str, String str2);

    private static native void nativeBegin(String str, String str2);

    private static native void nativeEnd(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeBeginToplevel(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeEndToplevel(String str);

    private static native void nativeStartAsync(String str, long j);

    private static native void nativeFinishAsync(String str, long j);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/TraceEvent$BasicLooperMonitor.class */
    private static class BasicLooperMonitor implements Printer {
        private static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        private static final int SHORTEST_LOG_PREFIX_LENGTH;
        private String mCurrentTarget;
        static final /* synthetic */ boolean $assertionsDisabled;

        private BasicLooperMonitor() {
        }

        static {
            $assertionsDisabled = !TraceEvent.class.desiredAssertionStatus();
            SHORTEST_LOG_PREFIX_LENGTH = "<<<<< Finished to ".length();
        }

        @Override // android.util.Printer
        public void println(String line) {
            if (line.startsWith(">")) {
                beginHandling(line);
            } else if (!$assertionsDisabled && !line.startsWith("<")) {
                throw new AssertionError();
            } else {
                endHandling(line);
            }
        }

        void beginHandling(String line) {
            boolean earlyTracingActive = EarlyTraceEvent.isActive();
            if (TraceEvent.sEnabled || earlyTracingActive) {
                this.mCurrentTarget = getTraceEventName(line);
                if (TraceEvent.sEnabled) {
                    TraceEvent.nativeBeginToplevel(this.mCurrentTarget);
                } else {
                    EarlyTraceEvent.begin(this.mCurrentTarget);
                }
            }
        }

        void endHandling(String line) {
            boolean earlyTracingActive = EarlyTraceEvent.isActive();
            if ((TraceEvent.sEnabled || earlyTracingActive) && this.mCurrentTarget != null) {
                if (TraceEvent.sEnabled) {
                    TraceEvent.nativeEndToplevel(this.mCurrentTarget);
                } else {
                    EarlyTraceEvent.end(this.mCurrentTarget);
                }
            }
            this.mCurrentTarget = null;
        }

        private static String getTraceEventName(String line) {
            return LOOPER_TASK_PREFIX + getTarget(line) + "(" + getTargetName(line) + ")";
        }

        private static String getTarget(String logLine) {
            int start = logLine.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            int end = start == -1 ? -1 : logLine.indexOf(41, start);
            return end != -1 ? logLine.substring(start + 1, end) : CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
        }

        private static String getTargetName(String logLine) {
            int start = logLine.indexOf(WebFeature.NAVIGATOR_VENDOR_SUB, SHORTEST_LOG_PREFIX_LENGTH);
            int end = start == -1 ? -1 : logLine.indexOf(58, start);
            if (end == -1) {
                end = logLine.length();
            }
            return start != -1 ? logLine.substring(start + 2, end) : CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/TraceEvent$IdleTracingLooperMonitor.class */
    private static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        private static final String TAG = "TraceEvent.LooperMonitor";
        private static final String IDLE_EVENT_NAME = "Looper.queueIdle";
        private static final long FRAME_DURATION_MILLIS = 16;
        private static final long MIN_INTERESTING_DURATION_MILLIS = 16;
        private static final long MIN_INTERESTING_BURST_DURATION_MILLIS = 48;
        private long mLastIdleStartedAt;
        private long mLastWorkStartedAt;
        private int mNumTasksSeen;
        private int mNumIdlesSeen;
        private int mNumTasksSinceLastIdle;
        private boolean mIdleMonitorAttached;

        private IdleTracingLooperMonitor() {
            super();
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.sEnabled && !this.mIdleMonitorAttached) {
                this.mLastIdleStartedAt = SystemClock.elapsedRealtime();
                Looper.myQueue().addIdleHandler(this);
                this.mIdleMonitorAttached = true;
                android.util.Log.v(TAG, "attached idle handler");
            } else if (this.mIdleMonitorAttached && !TraceEvent.sEnabled) {
                Looper.myQueue().removeIdleHandler(this);
                this.mIdleMonitorAttached = false;
                android.util.Log.v(TAG, "detached idle handler");
            }
        }

        @Override // org.chromium.base.TraceEvent.BasicLooperMonitor
        final void beginHandling(String line) {
            if (this.mNumTasksSinceLastIdle == 0) {
                TraceEvent.end(IDLE_EVENT_NAME);
            }
            this.mLastWorkStartedAt = SystemClock.elapsedRealtime();
            syncIdleMonitoring();
            super.beginHandling(line);
        }

        @Override // org.chromium.base.TraceEvent.BasicLooperMonitor
        final void endHandling(String line) {
            long elapsed = SystemClock.elapsedRealtime() - this.mLastWorkStartedAt;
            if (elapsed > 16) {
                traceAndLog(5, "observed a task that took " + elapsed + "ms: " + line);
            }
            super.endHandling(line);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        private static void traceAndLog(int level, String message) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", message);
            android.util.Log.println(level, TAG, message);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long now = SystemClock.elapsedRealtime();
            if (this.mLastIdleStartedAt == 0) {
                this.mLastIdleStartedAt = now;
            }
            long elapsed = now - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (elapsed > 48) {
                String statsString = this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + elapsed + "ms elapsed since last idle";
                traceAndLog(3, statsString);
            }
            this.mLastIdleStartedAt = now;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/TraceEvent$LooperMonitorHolder.class */
    private static final class LooperMonitorHolder {
        private static final BasicLooperMonitor sInstance;

        private LooperMonitorHolder() {
        }

        static {
            sInstance = CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_IDLE_TRACING) ? new IdleTracingLooperMonitor() : new BasicLooperMonitor();
        }
    }

    private TraceEvent(String name, String arg) {
        this.mName = name;
        begin(name, arg);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }

    public static TraceEvent scoped(String name, String arg) {
        if (EarlyTraceEvent.enabled() || enabled()) {
            return new TraceEvent(name, arg);
        }
        return null;
    }

    public static TraceEvent scoped(String name) {
        return scoped(name, null);
    }

    public static void registerNativeEnabledObserver() {
        nativeRegisterEnabledObserver();
    }

    @CalledByNative
    public static void setEnabled(boolean enabled) {
        if (enabled) {
            EarlyTraceEvent.disable();
        }
        if (sEnabled != enabled) {
            sEnabled = enabled;
            if (sATraceEnabled) {
                return;
            }
            ThreadUtils.getUiThreadLooper().setMessageLogging(enabled ? LooperMonitorHolder.sInstance : null);
        }
    }

    public static void maybeEnableEarlyTracing() {
        EarlyTraceEvent.maybeEnable();
        if (EarlyTraceEvent.isActive()) {
            ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.sInstance);
        }
    }

    public static void setATraceEnabled(boolean enabled) {
        if (sATraceEnabled == enabled) {
            return;
        }
        sATraceEnabled = enabled;
        if (enabled) {
            nativeStartATrace();
        } else {
            nativeStopATrace();
        }
    }

    public static boolean enabled() {
        return sEnabled;
    }

    public static void instant(String name) {
        if (sEnabled) {
            nativeInstant(name, null);
        }
    }

    public static void instant(String name, String arg) {
        if (sEnabled) {
            nativeInstant(name, arg);
        }
    }

    public static void startAsync(String name, long id) {
        EarlyTraceEvent.startAsync(name, id);
        if (sEnabled) {
            nativeStartAsync(name, id);
        }
    }

    public static void finishAsync(String name, long id) {
        EarlyTraceEvent.finishAsync(name, id);
        if (sEnabled) {
            nativeFinishAsync(name, id);
        }
    }

    public static void begin(String name) {
        begin(name, null);
    }

    public static void begin(String name, String arg) {
        EarlyTraceEvent.begin(name);
        if (sEnabled) {
            nativeBegin(name, arg);
        }
    }

    public static void end(String name) {
        end(name, null);
    }

    public static void end(String name, String arg) {
        EarlyTraceEvent.end(name);
        if (sEnabled) {
            nativeEnd(name, arg);
        }
    }
}
