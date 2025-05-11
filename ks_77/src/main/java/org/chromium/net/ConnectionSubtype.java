package org.chromium.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/ConnectionSubtype.class */
public @interface ConnectionSubtype {
    public static final int SUBTYPE_UNKNOWN = 0;
    public static final int SUBTYPE_NONE = 1;
    public static final int SUBTYPE_OTHER = 2;
    public static final int SUBTYPE_GSM = 3;
    public static final int SUBTYPE_IDEN = 4;
    public static final int SUBTYPE_CDMA = 5;
    public static final int SUBTYPE_1XRTT = 6;
    public static final int SUBTYPE_GPRS = 7;
    public static final int SUBTYPE_EDGE = 8;
    public static final int SUBTYPE_UMTS = 9;
    public static final int SUBTYPE_EVDO_REV_0 = 10;
    public static final int SUBTYPE_EVDO_REV_A = 11;
    public static final int SUBTYPE_HSPA = 12;
    public static final int SUBTYPE_EVDO_REV_B = 13;
    public static final int SUBTYPE_HSDPA = 14;
    public static final int SUBTYPE_HSUPA = 15;
    public static final int SUBTYPE_EHRPD = 16;
    public static final int SUBTYPE_HSPAP = 17;
    public static final int SUBTYPE_LTE = 18;
    public static final int SUBTYPE_LTE_ADVANCED = 19;
    public static final int SUBTYPE_BLUETOOTH_1_2 = 20;
    public static final int SUBTYPE_BLUETOOTH_2_1 = 21;
    public static final int SUBTYPE_BLUETOOTH_3_0 = 22;
    public static final int SUBTYPE_BLUETOOTH_4_0 = 23;
    public static final int SUBTYPE_ETHERNET = 24;
    public static final int SUBTYPE_FAST_ETHERNET = 25;
    public static final int SUBTYPE_GIGABIT_ETHERNET = 26;
    public static final int SUBTYPE_10_GIGABIT_ETHERNET = 27;
    public static final int SUBTYPE_WIFI_B = 28;
    public static final int SUBTYPE_WIFI_G = 29;
    public static final int SUBTYPE_WIFI_N = 30;
    public static final int SUBTYPE_WIFI_AC = 31;
    public static final int SUBTYPE_WIFI_AD = 32;
    public static final int SUBTYPE_LAST = 32;
}
