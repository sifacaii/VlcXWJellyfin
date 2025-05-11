package org.chromium.chrome.browser.keyboard_accessory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/chrome/browser/keyboard_accessory/AccessoryTabType.class */
public @interface AccessoryTabType {
    public static final int ALL = 0;
    public static final int PASSWORDS = 1;
    public static final int CREDIT_CARDS = 2;
    public static final int ADDRESSES = 3;
    public static final int TOUCH_TO_FILL = 4;
    public static final int COUNT = 5;
}
