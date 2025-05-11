package org.chromium.ui.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/MenuSourceType.class */
public @interface MenuSourceType {
    public static final int MENU_SOURCE_NONE = 0;
    public static final int MENU_SOURCE_MOUSE = 1;
    public static final int MENU_SOURCE_KEYBOARD = 2;
    public static final int MENU_SOURCE_TOUCH = 3;
    public static final int MENU_SOURCE_TOUCH_EDIT_MENU = 4;
    public static final int MENU_SOURCE_LONG_PRESS = 5;
    public static final int MENU_SOURCE_LONG_TAP = 6;
    public static final int MENU_SOURCE_TOUCH_HANDLE = 7;
    public static final int MENU_SOURCE_STYLUS = 8;
    public static final int MENU_SOURCE_ADJUST_SELECTION = 9;
    public static final int MENU_SOURCE_ADJUST_SELECTION_RESET = 10;
    public static final int MENU_SOURCE_TYPE_LAST = 10;
}
