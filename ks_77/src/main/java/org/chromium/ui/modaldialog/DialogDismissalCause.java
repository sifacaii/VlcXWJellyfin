package org.chromium.ui.modaldialog;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modaldialog/DialogDismissalCause.class */
public @interface DialogDismissalCause {
    public static final int UNKNOWN = 0;
    public static final int POSITIVE_BUTTON_CLICKED = 1;
    public static final int NEGATIVE_BUTTON_CLICKED = 2;
    public static final int ACTION_ON_CONTENT = 3;
    public static final int DISMISSED_BY_NATIVE = 4;
    public static final int NAVIGATE_BACK_OR_TOUCH_OUTSIDE = 5;
    public static final int TAB_SWITCHED = 6;
    public static final int TAB_DESTROYED = 7;
    public static final int ACTIVITY_DESTROYED = 8;
    public static final int NOT_ATTACHED_TO_WINDOW = 9;
}
