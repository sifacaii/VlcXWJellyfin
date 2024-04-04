package org.chromium.ui.gfx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/gfx/BitmapFormat.class */
public @interface BitmapFormat {
    public static final int NO_CONFIG = 0;
    public static final int ALPHA_8 = 1;
    public static final int ARGB_4444 = 2;
    public static final int ARGB_8888 = 3;
    public static final int RGB_565 = 4;
}
