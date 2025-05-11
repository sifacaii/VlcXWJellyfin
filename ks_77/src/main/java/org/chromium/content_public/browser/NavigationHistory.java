package org.chromium.content_public.browser;

import java.util.ArrayList;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/NavigationHistory.class */
public class NavigationHistory {
    private final ArrayList<NavigationEntry> mEntries = new ArrayList<>();
    private int mCurrentEntryIndex;

    public void addEntry(NavigationEntry entry) {
        this.mEntries.add(entry);
    }

    public void setCurrentEntryIndex(int currentEntryIndex) {
        this.mCurrentEntryIndex = currentEntryIndex;
    }

    public int getEntryCount() {
        return this.mEntries.size();
    }

    public NavigationEntry getEntryAtIndex(int index) {
        return this.mEntries.get(index);
    }

    public int getCurrentEntryIndex() {
        return this.mCurrentEntryIndex;
    }
}
