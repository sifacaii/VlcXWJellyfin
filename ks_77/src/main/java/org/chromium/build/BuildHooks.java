package org.chromium.build;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/build/BuildHooks.class */
public abstract class BuildHooks {
    private static ReportAssertionCallback sReportAssertionCallback;

    @FunctionalInterface
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/build/BuildHooks$ReportAssertionCallback.class */
    public interface ReportAssertionCallback {
        void run(AssertionError assertionError);
    }

    public static void assertFailureHandler(AssertionError assertionError) {
        throw assertionError;
    }

    public static void setReportAssertionCallback(ReportAssertionCallback callback) {
        throw new AssertionError();
    }
}
