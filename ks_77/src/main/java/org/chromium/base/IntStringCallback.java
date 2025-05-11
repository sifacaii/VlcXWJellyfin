package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/IntStringCallback.class */
public interface IntStringCallback {
    @CalledByNative
    void onResult(int i, String str);
}
