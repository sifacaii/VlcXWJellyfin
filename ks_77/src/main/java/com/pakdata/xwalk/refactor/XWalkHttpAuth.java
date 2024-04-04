package com.pakdata.xwalk.refactor;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkHttpAuth.class */
public interface XWalkHttpAuth {
    void proceed(String str, String str2);

    void cancel();

    boolean isFirstAttempt();
}
