package org.chromium.blink_public.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink_public/web/WebTextInputMode.class */
public @interface WebTextInputMode {
    public static final int DEFAULT = 0;
    public static final int NONE = 1;
    public static final int TEXT = 2;
    public static final int TEL = 3;
    public static final int URL = 4;
    public static final int EMAIL = 5;
    public static final int NUMERIC = 6;
    public static final int DECIMAL = 7;
    public static final int SEARCH = 8;
    public static final int MAX = 8;
}
