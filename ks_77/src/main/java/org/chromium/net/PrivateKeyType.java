package org.chromium.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/PrivateKeyType.class */
public @interface PrivateKeyType {
    public static final int RSA = 0;
    public static final int ECDSA = 2;
    public static final int INVALID = 255;
}
