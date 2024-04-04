package org.chromium.base;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/StreamUtil.class */
public class StreamUtil {
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    public static void closeQuietly(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException e) {
        }
    }
}
