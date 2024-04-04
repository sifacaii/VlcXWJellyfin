package org.chromium.blink_public.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink_public/web/WebInputEventModifier.class */
public @interface WebInputEventModifier {
    public static final int SHIFT_KEY = 1;
    public static final int CONTROL_KEY = 2;
    public static final int ALT_KEY = 4;
    public static final int META_KEY = 8;
    public static final int IS_KEY_PAD = 16;
    public static final int IS_AUTO_REPEAT = 32;
    public static final int LEFT_BUTTON_DOWN = 64;
    public static final int MIDDLE_BUTTON_DOWN = 128;
    public static final int RIGHT_BUTTON_DOWN = 256;
    public static final int CAPS_LOCK_ON = 512;
    public static final int NUM_LOCK_ON = 1024;
    public static final int IS_LEFT = 2048;
    public static final int IS_RIGHT = 4096;
    public static final int IS_TOUCH_ACCESSIBILITY = 8192;
    public static final int IS_COMPOSING = 16384;
    public static final int ALT_GR_KEY = 32768;
    public static final int FN_KEY = 65536;
    public static final int SYMBOL_KEY = 131072;
    public static final int SCROLL_LOCK_ON = 262144;
    public static final int IS_COMPATIBILITY_EVENT_FOR_TOUCH = 524288;
    public static final int BACK_BUTTON_DOWN = 1048576;
    public static final int FORWARD_BUTTON_DOWN = 2097152;
    public static final int RELATIVE_MOTION_EVENT = 4194304;
    public static final int FROM_DEBUGGER = 8388608;
    public static final int TARGET_FRAME_MOVED_RECENTLY = 16777216;
    public static final int KEY_MODIFIERS = 229391;
    public static final int NO_MODIFIERS = 0;
}
