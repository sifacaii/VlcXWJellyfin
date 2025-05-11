package org.chromium.base;

import org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/ImportantFileWriterAndroid.class */
public class ImportantFileWriterAndroid {
    private static native boolean nativeWriteFileAtomically(String str, byte[] bArr);

    public static boolean writeFileAtomically(String fileName, byte[] data) {
        return nativeWriteFileAtomically(fileName, data);
    }
}
