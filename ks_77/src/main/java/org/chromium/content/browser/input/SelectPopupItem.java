package org.chromium.content.browser.input;

import org.chromium.ui.DropdownItemBase;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/SelectPopupItem.class */
public class SelectPopupItem extends DropdownItemBase {
    private final String mLabel;
    private final int mType;

    public SelectPopupItem(String label, int type) {
        this.mLabel = label;
        this.mType = type;
    }

    @Override // org.chromium.ui.DropdownItemBase, org.chromium.ui.DropdownItem
    public String getLabel() {
        return this.mLabel;
    }

    @Override // org.chromium.ui.DropdownItemBase, org.chromium.ui.DropdownItem
    public boolean isEnabled() {
        return this.mType == 2 || this.mType == 0;
    }

    @Override // org.chromium.ui.DropdownItemBase, org.chromium.ui.DropdownItem
    public boolean isGroupHeader() {
        return this.mType == 0;
    }

    public int getType() {
        return this.mType;
    }
}
