package org.chromium.content_public.browser;

import org.chromium.content.browser.ChildProcessCreationParamsImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ChildProcessCreationParams.class */
public final class ChildProcessCreationParams {
    public static void set(String packageNameForService, boolean isExternalSandboxedService, int libraryProcessType, boolean bindToCallerCheck, boolean ignoreVisibilityForImportance) {
        ChildProcessCreationParamsImpl.set(packageNameForService, isExternalSandboxedService, libraryProcessType, bindToCallerCheck, ignoreVisibilityForImportance);
    }
}
