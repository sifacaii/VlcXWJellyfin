package org.chromium.mojo.bindings;

import org.chromium.blink.mojom.WebFeature;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.Watcher;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/BindingsHelper.class */
public class BindingsHelper {
    public static final int ALIGNMENT = 8;
    public static final int SERIALIZED_HANDLE_SIZE = 4;
    public static final int SERIALIZED_INTERFACE_SIZE = 8;
    public static final int POINTER_SIZE = 8;
    public static final int UNION_SIZE = 16;
    public static final DataHeader MAP_STRUCT_HEADER = new DataHeader(24, 0);
    public static final int UNSPECIFIED_ARRAY_LENGTH = -1;
    public static final int NOTHING_NULLABLE = 0;
    public static final int ARRAY_NULLABLE = 1;
    public static final int ELEMENT_NULLABLE = 2;

    public static boolean isArrayNullable(int arrayNullability) {
        return (arrayNullability & 1) > 0;
    }

    public static boolean isElementNullable(int arrayNullability) {
        return (arrayNullability & 2) > 0;
    }

    public static int align(int size) {
        return ((size + 8) - 1) & (-8);
    }

    public static long align(long size) {
        return ((size + 8) - 1) & (-8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int utf8StringSizeInBytes(String s) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int codepoint = c;
            if (isSurrogate(c)) {
                i++;
                char c2 = s.charAt(i);
                codepoint = Character.toCodePoint(c, c2);
            }
            res++;
            if (codepoint > 127) {
                res++;
                if (codepoint > 2047) {
                    res++;
                    if (codepoint > 65535) {
                        res++;
                        if (codepoint > 2097151) {
                            res++;
                            if (codepoint > 67108863) {
                                res++;
                            }
                        }
                    }
                }
            }
            i++;
        }
        return res;
    }

    public static boolean equals(Object o1, Object o2) {
        if (o1 == o2) {
            return true;
        }
        if (o1 == null) {
            return false;
        }
        return o1.equals(o2);
    }

    public static int hashCode(Object o) {
        if (o == null) {
            return 0;
        }
        return o.hashCode();
    }

    public static int hashCode(boolean o) {
        return o ? WebFeature.HTML_MEDIA_ELEMENT_CONTROLS_ATTRIBUTE : WebFeature.V8_SLOPPY_MODE_BLOCK_SCOPED_FUNCTION_REDEFINITION;
    }

    public static int hashCode(long o) {
        return (int) (o ^ (o >>> 32));
    }

    public static int hashCode(float o) {
        return Float.floatToIntBits(o);
    }

    public static int hashCode(double o) {
        return hashCode(Double.doubleToLongBits(o));
    }

    public static int hashCode(int o) {
        return o;
    }

    private static boolean isSurrogate(char c) {
        return c >= 55296 && c < 57344;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Watcher getWatcherForHandle(Handle handle) {
        if (handle.getCore() != null) {
            return handle.getCore().getWatcher();
        }
        return null;
    }
}
