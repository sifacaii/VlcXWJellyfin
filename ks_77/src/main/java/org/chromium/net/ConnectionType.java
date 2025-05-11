package org.chromium.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/ConnectionType.class */
public @interface ConnectionType {
    public static final int CONNECTION_UNKNOWN = 0;
    public static final int CONNECTION_ETHERNET = 1;
    public static final int CONNECTION_WIFI = 2;
    public static final int CONNECTION_2G = 3;
    public static final int CONNECTION_3G = 4;
    public static final int CONNECTION_4G = 5;
    public static final int CONNECTION_NONE = 6;
    public static final int CONNECTION_BLUETOOTH = 7;
    public static final int CONNECTION_LAST = 7;
}
