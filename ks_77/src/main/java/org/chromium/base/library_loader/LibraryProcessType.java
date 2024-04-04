package org.chromium.base.library_loader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/library_loader/LibraryProcessType.class */
public @interface LibraryProcessType {
    public static final int PROCESS_UNINITIALIZED = 0;
    public static final int PROCESS_BROWSER = 1;
    public static final int PROCESS_CHILD = 2;
    public static final int PROCESS_WEBVIEW = 3;
    public static final int PROCESS_WEBVIEW_CHILD = 4;
}
