package org.chromium.ui.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/PageTransition.class */
public @interface PageTransition {
    public static final int FIRST = 0;
    public static final int LINK = 0;
    public static final int TYPED = 1;
    public static final int AUTO_BOOKMARK = 2;
    public static final int AUTO_SUBFRAME = 3;
    public static final int MANUAL_SUBFRAME = 4;
    public static final int GENERATED = 5;
    public static final int AUTO_TOPLEVEL = 6;
    public static final int FORM_SUBMIT = 7;
    public static final int RELOAD = 8;
    public static final int KEYWORD = 9;
    public static final int KEYWORD_GENERATED = 10;
    public static final int LAST_CORE = 10;
    public static final int CORE_MASK = 255;
    public static final int BLOCKED = 8388608;
    public static final int FORWARD_BACK = 16777216;
    public static final int FROM_ADDRESS_BAR = 33554432;
    public static final int HOME_PAGE = 67108864;
    public static final int FROM_API = 134217728;
    public static final int CHAIN_START = 268435456;
    public static final int CHAIN_END = 536870912;
    public static final int CLIENT_REDIRECT = 1073741824;
    public static final int SERVER_REDIRECT = Integer.MIN_VALUE;
    public static final int IS_REDIRECT_MASK = -1073741824;
    public static final int QUALIFIER_MASK = -256;
}
