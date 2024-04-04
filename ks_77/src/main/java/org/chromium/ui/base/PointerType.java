package org.chromium.ui.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/PointerType.class */
public @interface PointerType {
    public static final int NONE = 1;
    public static final int FIRST = 1;
    public static final int COARSE = 2;
    public static final int FINE = 4;
    public static final int LAST = 4;
}
