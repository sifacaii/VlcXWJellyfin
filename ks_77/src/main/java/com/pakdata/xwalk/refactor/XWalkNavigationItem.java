package com.pakdata.xwalk.refactor;

import org.chromium.content_public.browser.NavigationEntry;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkNavigationItem.class */
public class XWalkNavigationItem implements Cloneable {
    private NavigationEntry mEntry;

    XWalkNavigationItem() {
        this.mEntry = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XWalkNavigationItem(NavigationEntry entry) {
        this.mEntry = entry;
    }

    XWalkNavigationItem(XWalkNavigationItem item) {
        this.mEntry = item.mEntry;
    }

    public String getUrl() {
        return this.mEntry.getUrl();
    }

    public String getOriginalUrl() {
        return this.mEntry.getOriginalUrl();
    }

    public String getTitle() {
        return this.mEntry.getTitle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public synchronized XWalkNavigationItem m21clone() {
        return new XWalkNavigationItem(this);
    }
}
