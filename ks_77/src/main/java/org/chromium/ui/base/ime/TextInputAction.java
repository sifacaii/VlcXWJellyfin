package org.chromium.ui.base.ime;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/ime/TextInputAction.class */
public @interface TextInputAction {
    public static final int DEFAULT = 0;
    public static final int ENTER = 1;
    public static final int DONE = 2;
    public static final int GO = 3;
    public static final int NEXT = 4;
    public static final int PREVIOUS = 5;
    public static final int SEARCH = 6;
    public static final int SEND = 7;
    public static final int MAX_VALUE = 7;
}
