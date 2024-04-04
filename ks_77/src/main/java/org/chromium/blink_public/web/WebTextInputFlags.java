package org.chromium.blink_public.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink_public/web/WebTextInputFlags.class */
public @interface WebTextInputFlags {
    public static final int NONE = 0;
    public static final int AUTOCOMPLETE_ON = 1;
    public static final int AUTOCOMPLETE_OFF = 2;
    public static final int AUTOCORRECT_ON = 4;
    public static final int AUTOCORRECT_OFF = 8;
    public static final int SPELLCHECK_ON = 16;
    public static final int SPELLCHECK_OFF = 32;
    public static final int AUTOCAPITALIZE_NONE = 64;
    public static final int AUTOCAPITALIZE_CHARACTERS = 128;
    public static final int AUTOCAPITALIZE_WORDS = 256;
    public static final int AUTOCAPITALIZE_SENTENCES = 512;
    public static final int HAVE_NEXT_FOCUSABLE_ELEMENT = 1024;
    public static final int HAVE_PREVIOUS_FOCUSABLE_ELEMENT = 2048;
    public static final int HAS_BEEN_PASSWORD_FIELD = 4096;
}
