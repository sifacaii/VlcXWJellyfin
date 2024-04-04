package org.chromium.base;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

@JNINamespace("base::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/ApkAssets.class */
public class ApkAssets {
    private static final String LOGTAG = "ApkAssets";

    @CalledByNative
    public static long[] open(String fileName) {
        AssetFileDescriptor afd = null;
        try {
            try {
                AssetManager manager = ContextUtils.getApplicationContext().getAssets();
                afd = manager.openNonAssetFd(fileName);
                long[] jArr = {afd.getParcelFileDescriptor().detachFd(), afd.getStartOffset(), afd.getLength()};
                if (afd != null) {
                    try {
                        afd.close();
                    } catch (IOException e2) {
                        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e2);
                    }
                }
                return jArr;
            } catch (Throwable th) {
                if (afd != null) {
                    try {
                        afd.close();
                    } catch (IOException e22) {
                        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e22);
                        throw th;
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            if (!e.getMessage().equals(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE) && !e.getMessage().equals(fileName)) {
                android.util.Log.e(LOGTAG, "Error while loading asset " + fileName + ": " + e);
            }
            long[] jArr2 = {-1, -1, -1};
            if (afd != null) {
                try {
                    afd.close();
                } catch (IOException e23) {
                    android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e23);
                    return jArr2;
                }
            }
            return jArr2;
        }
    }
}
