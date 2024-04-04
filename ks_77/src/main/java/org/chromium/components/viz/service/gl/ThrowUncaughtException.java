package org.chromium.components.viz.service.gl;

import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/viz/service/gl/ThrowUncaughtException.class */
abstract class ThrowUncaughtException {
    ThrowUncaughtException() {
    }

    @CalledByNative
    private static void post() {
        ThreadUtils.postOnUiThread(new Runnable() { // from class: org.chromium.components.viz.service.gl.ThrowUncaughtException.1
            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException("Intentional exception not caught by JNI");
            }
        });
    }
}
