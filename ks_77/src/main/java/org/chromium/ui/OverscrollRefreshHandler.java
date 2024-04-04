package org.chromium.ui;

import org.chromium.base.annotations.CalledByNative;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/OverscrollRefreshHandler.class */
public interface OverscrollRefreshHandler {
    @CalledByNative
    boolean start(int i, float f, float f2, boolean z);

    @CalledByNative
    void pull(float f, float f2);

    @CalledByNative
    void release(boolean z);

    @CalledByNative
    void reset();

    void setEnabled(boolean z);
}
