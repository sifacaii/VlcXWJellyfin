package org.chromium.ui.base;

import java.util.Arrays;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("ui")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/ResourceBundle.class */
public final class ResourceBundle {
    private static String[] sCompressedLocales;
    private static String[] sUncompressedLocales;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ResourceBundle.class.desiredAssertionStatus();
    }

    private ResourceBundle() {
    }

    public static void setNoAvailableLocalePaks() {
        if (!$assertionsDisabled && (sCompressedLocales != null || sUncompressedLocales != null)) {
            throw new AssertionError();
        }
        sCompressedLocales = new String[0];
        sUncompressedLocales = new String[0];
    }

    public static void setAvailablePakLocales(String[] compressed, String[] uncompressed) {
        if (!$assertionsDisabled && (sCompressedLocales != null || sUncompressedLocales != null)) {
            throw new AssertionError();
        }
        sCompressedLocales = compressed;
        sUncompressedLocales = uncompressed;
    }

    public static String[] getAvailableCompressedPakLocales() {
        if ($assertionsDisabled || sCompressedLocales != null) {
            return sCompressedLocales;
        }
        throw new AssertionError();
    }

    @CalledByNative
    private static String getLocalePakResourcePath(String locale) {
        if ($assertionsDisabled || sUncompressedLocales != null) {
            if (Arrays.binarySearch(sUncompressedLocales, locale) >= 0) {
                return "assets/stored-locales/" + locale + ".pak";
            }
            return null;
        }
        throw new AssertionError();
    }
}
