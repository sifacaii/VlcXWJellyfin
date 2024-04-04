package com.pakdata.xwalk.refactor;

import java.io.Serializable;
import org.chromium.content_public.browser.NavigationHistory;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkNavigationHistory.class */
public class XWalkNavigationHistory implements Cloneable, Serializable {
    private NavigationHistory mHistory;
    private XWalkView mXWalkView;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkNavigationHistory$DirectionInternal.class */
    public enum DirectionInternal {
        BACKWARD,
        FORWARD
    }

    XWalkNavigationHistory() {
        this.mXWalkView = null;
        this.mHistory = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XWalkNavigationHistory(XWalkView view, NavigationHistory history) {
        this.mXWalkView = view;
        this.mHistory = history;
    }

    XWalkNavigationHistory(XWalkNavigationHistory history) {
        this.mXWalkView = history.mXWalkView;
        this.mHistory = history.mHistory;
    }

    public int size() {
        return this.mHistory.getEntryCount();
    }

    public boolean hasItemAt(int index) {
        return index >= 0 && index <= size() - 1;
    }

    public XWalkNavigationItem getItemAt(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        return new XWalkNavigationItem(this.mHistory.getEntryAtIndex(index));
    }

    public XWalkNavigationItem getCurrentItem() {
        return getItemAt(getCurrentIndex());
    }

    public boolean canGoBack() {
        return this.mXWalkView.canGoBack();
    }

    public boolean canGoForward() {
        return this.mXWalkView.canGoForward();
    }

    public boolean removeHistoryEntryAt(int index) {
        return this.mXWalkView.removeHistoryEntryAt(index);
    }

    public void navigate(DirectionInternal direction, int steps) {
        switch (direction) {
            case FORWARD:
                this.mXWalkView.navigateTo(steps);
                return;
            case BACKWARD:
                this.mXWalkView.navigateTo(-steps);
                return;
            default:
                return;
        }
    }

    public int getCurrentIndex() {
        return this.mHistory.getCurrentEntryIndex();
    }

    public void clear() {
        this.mXWalkView.clearHistory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public synchronized XWalkNavigationHistory m18clone() {
        return new XWalkNavigationHistory(this);
    }
}
