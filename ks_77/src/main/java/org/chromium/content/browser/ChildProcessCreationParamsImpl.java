package org.chromium.content.browser;

import android.os.Bundle;
import org.chromium.base.ContextUtils;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ChildProcessCreationParamsImpl.class */
public class ChildProcessCreationParamsImpl {
    private static final String EXTRA_LIBRARY_PROCESS_TYPE = "org.chromium.content.common.child_service_params.library_process_type";
    private static String sPackageNameForService;
    private static boolean sIsSandboxedServiceExternal;
    private static int sLibraryProcessType;
    private static boolean sBindToCallerCheck;
    private static boolean sIgnoreVisibilityForImportance;
    private static boolean sInitialized;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ChildProcessCreationParamsImpl.class.desiredAssertionStatus();
    }

    private ChildProcessCreationParamsImpl() {
    }

    public static void set(String packageNameForService, boolean isExternalSandboxedService, int libraryProcessType, boolean bindToCallerCheck, boolean ignoreVisibilityForImportance) {
        if (!$assertionsDisabled && sInitialized) {
            throw new AssertionError();
        }
        sPackageNameForService = packageNameForService;
        sIsSandboxedServiceExternal = isExternalSandboxedService;
        sLibraryProcessType = libraryProcessType;
        sBindToCallerCheck = bindToCallerCheck;
        sIgnoreVisibilityForImportance = ignoreVisibilityForImportance;
        sInitialized = true;
    }

    public static void addIntentExtras(Bundle extras) {
        if (sInitialized) {
            extras.putInt(EXTRA_LIBRARY_PROCESS_TYPE, sLibraryProcessType);
        }
    }

    public static String getPackageNameForService() {
        return sInitialized ? sPackageNameForService : ContextUtils.getApplicationContext().getPackageName();
    }

    public static boolean getIsSandboxedServiceExternal() {
        return sInitialized && sIsSandboxedServiceExternal;
    }

    public static boolean getBindToCallerCheck() {
        return sInitialized && sBindToCallerCheck;
    }

    public static boolean getIgnoreVisibilityForImportance() {
        return sInitialized && sIgnoreVisibilityForImportance;
    }

    public static int getLibraryProcessType(Bundle extras) {
        return extras.getInt(EXTRA_LIBRARY_PROCESS_TYPE, 2);
    }
}
