package org.chromium.components.download;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/download/DownloadState.class */
public @interface DownloadState {
    public static final int IN_PROGRESS = 0;
    public static final int COMPLETE = 1;
    public static final int CANCELLED = 2;
    public static final int INTERRUPTED = 3;
    public static final int MAX_DOWNLOAD_STATE = 4;
}
