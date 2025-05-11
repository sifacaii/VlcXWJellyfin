package org.chromium.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/ChildBindingState.class */
public @interface ChildBindingState {
    public static final int UNBOUND = 0;
    public static final int WAIVED = 1;
    public static final int MODERATE = 2;
    public static final int STRONG = 3;
    public static final int MAX_VALUE = 3;
}
