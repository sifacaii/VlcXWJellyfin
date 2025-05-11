package org.chromium.ui.resources;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/AndroidResourceType.class */
public @interface AndroidResourceType {
    public static final int STATIC = 0;
    public static final int DYNAMIC = 1;
    public static final int DYNAMIC_BITMAP = 2;
    public static final int SYSTEM = 3;
    public static final int COUNT = 4;
    public static final int FIRST = 0;
    public static final int LAST = 3;
}
