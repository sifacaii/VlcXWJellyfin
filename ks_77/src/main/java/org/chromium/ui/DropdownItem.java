package org.chromium.ui;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/DropdownItem.class */
public interface DropdownItem {
    public static final int NO_ICON = 0;

    String getLabel();

    String getSublabel();

    int getIconId();

    boolean isEnabled();

    boolean isGroupHeader();

    boolean isMultilineLabel();

    boolean isBoldLabel();

    int getLabelFontColorResId();

    int getSublabelFontSizeResId();

    boolean isIconAtStart();

    int getIconSizeResId();

    int getIconMarginResId();
}
