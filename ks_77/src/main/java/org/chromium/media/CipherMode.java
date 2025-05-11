package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/CipherMode.class */
public @interface CipherMode {
    public static final int UNENCRYPTED = 0;
    public static final int AES_CTR = 1;
    public static final int AES_CBC = 2;
    public static final int MAX = 2;
}
