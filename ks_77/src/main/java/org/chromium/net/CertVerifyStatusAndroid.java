package org.chromium.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/CertVerifyStatusAndroid.class */
public @interface CertVerifyStatusAndroid {
    public static final int OK = 0;
    public static final int FAILED = -1;
    public static final int NO_TRUSTED_ROOT = -2;
    public static final int EXPIRED = -3;
    public static final int NOT_YET_VALID = -4;
    public static final int UNABLE_TO_PARSE = -5;
    public static final int INCORRECT_KEY_USAGE = -6;
}
