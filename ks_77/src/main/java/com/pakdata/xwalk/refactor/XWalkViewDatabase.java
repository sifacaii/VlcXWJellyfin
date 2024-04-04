package com.pakdata.xwalk.refactor;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkViewDatabase.class */
public class XWalkViewDatabase {
    private static final Object sync = new Object();

    public static boolean hasFormData() {
        boolean hasFormData;
        synchronized (sync) {
            hasFormData = XWalkFormDatabase.hasFormData();
        }
        return hasFormData;
    }

    public static void clearFormData() {
        synchronized (sync) {
            XWalkFormDatabase.clearFormData();
        }
    }
}
