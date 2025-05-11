package org.chromium.ui.display;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/display/DisplayUtil.class */
public abstract class DisplayUtil {
    public static int getSmallestWidth(DisplayAndroid display) {
        int width = display.getDisplayWidth();
        int height = display.getDisplayHeight();
        return width < height ? width : height;
    }

    public static int pxToDp(DisplayAndroid display, int value) {
        return (int) ((value / display.getDipScale()) + 0.5f);
    }

    public static int dpToPx(DisplayAndroid display, int value) {
        return (int) ((value * display.getDipScale()) + 0.5f);
    }
}
