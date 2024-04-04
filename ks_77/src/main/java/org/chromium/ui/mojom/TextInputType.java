package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/mojom/TextInputType.class */
public final class TextInputType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NONE = 0;
    public static final int TEXT = 1;
    public static final int PASSWORD = 2;
    public static final int SEARCH = 3;
    public static final int EMAIL = 4;
    public static final int NUMBER = 5;
    public static final int TELEPHONE = 6;
    public static final int URL = 7;
    public static final int DATE = 8;
    public static final int DATE_TIME = 9;
    public static final int DATE_TIME_LOCAL = 10;
    public static final int MONTH = 11;
    public static final int TIME = 12;
    public static final int WEEK = 13;
    public static final int TEXT_AREA = 14;
    public static final int CONTENT_EDITABLE = 15;
    public static final int DATE_TIME_FIELD = 16;
    public static final int MAX = 16;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 16;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private TextInputType() {
    }
}
