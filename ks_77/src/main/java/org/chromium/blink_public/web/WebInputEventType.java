package org.chromium.blink_public.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink_public/web/WebInputEventType.class */
public @interface WebInputEventType {
    public static final int UNDEFINED = -1;
    public static final int TYPE_FIRST = -1;
    public static final int MOUSE_DOWN = 0;
    public static final int MOUSE_TYPE_FIRST = 0;
    public static final int MOUSE_UP = 1;
    public static final int MOUSE_MOVE = 2;
    public static final int MOUSE_ENTER = 3;
    public static final int MOUSE_LEAVE = 4;
    public static final int CONTEXT_MENU = 5;
    public static final int MOUSE_TYPE_LAST = 5;
    public static final int MOUSE_WHEEL = 6;
    public static final int RAW_KEY_DOWN = 7;
    public static final int KEYBOARD_TYPE_FIRST = 7;
    public static final int KEY_DOWN = 8;
    public static final int KEY_UP = 9;
    public static final int CHAR = 10;
    public static final int KEYBOARD_TYPE_LAST = 10;
    public static final int GESTURE_SCROLL_BEGIN = 11;
    public static final int GESTURE_TYPE_FIRST = 11;
    public static final int GESTURE_SCROLL_END = 12;
    public static final int GESTURE_SCROLL_UPDATE = 13;
    public static final int GESTURE_FLING_START = 14;
    public static final int GESTURE_FLING_CANCEL = 15;
    public static final int GESTURE_PINCH_BEGIN = 16;
    public static final int GESTURE_PINCH_TYPE_FIRST = 16;
    public static final int GESTURE_PINCH_END = 17;
    public static final int GESTURE_PINCH_UPDATE = 18;
    public static final int GESTURE_PINCH_TYPE_LAST = 18;
    public static final int GESTURE_TAP_DOWN = 19;
    public static final int GESTURE_SHOW_PRESS = 20;
    public static final int GESTURE_TAP = 21;
    public static final int GESTURE_TAP_CANCEL = 22;
    public static final int GESTURE_LONG_PRESS = 23;
    public static final int GESTURE_LONG_TAP = 24;
    public static final int GESTURE_TWO_FINGER_TAP = 25;
    public static final int GESTURE_TAP_UNCONFIRMED = 26;
    public static final int GESTURE_DOUBLE_TAP = 27;
    public static final int GESTURE_TYPE_LAST = 27;
    public static final int TOUCH_START = 28;
    public static final int TOUCH_TYPE_FIRST = 28;
    public static final int TOUCH_MOVE = 29;
    public static final int TOUCH_END = 30;
    public static final int TOUCH_CANCEL = 31;
    public static final int TOUCH_SCROLL_STARTED = 32;
    public static final int TOUCH_TYPE_LAST = 32;
    public static final int POINTER_DOWN = 33;
    public static final int POINTER_TYPE_FIRST = 33;
    public static final int POINTER_UP = 34;
    public static final int POINTER_MOVE = 35;
    public static final int POINTER_RAW_UPDATE = 36;
    public static final int POINTER_CANCEL = 37;
    public static final int POINTER_CAUSED_UA_ACTION = 38;
    public static final int POINTER_TYPE_LAST = 38;
    public static final int TYPE_LAST = 38;
}
