package org.chromium.chrome.browser.keyboard_accessory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/chrome/browser/keyboard_accessory/AccessoryAction.class */
public @interface AccessoryAction {
    public static final int GENERATE_PASSWORD_AUTOMATIC = 0;
    public static final int MANAGE_PASSWORDS = 1;
    public static final int AUTOFILL_SUGGESTION = 2;
    public static final int MANAGE_CREDIT_CARDS = 3;
    public static final int MANAGE_ADDRESSES = 4;
    public static final int GENERATE_PASSWORD_MANUAL = 5;
    public static final int COUNT = 6;
}
