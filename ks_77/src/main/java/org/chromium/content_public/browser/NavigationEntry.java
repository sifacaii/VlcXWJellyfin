package org.chromium.content_public.browser;

import android.graphics.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/NavigationEntry.class */
public class NavigationEntry {
    private final int mIndex;
    private final String mUrl;
    private final String mOriginalUrl;
    private final String mVirtualUrl;
    private final String mReferrerUrl;
    private final String mTitle;
    private Bitmap mFavicon;
    private int mTransition;
    private long mTimestamp;

    public NavigationEntry(int index, String url, String virtualUrl, String originalUrl, String referrerUrl, String title, Bitmap favicon, int transition, long timestamp) {
        this.mIndex = index;
        this.mUrl = url;
        this.mVirtualUrl = virtualUrl;
        this.mOriginalUrl = originalUrl;
        this.mReferrerUrl = referrerUrl;
        this.mTitle = title;
        this.mFavicon = favicon;
        this.mTransition = transition;
        this.mTimestamp = timestamp;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVirtualUrl() {
        return this.mVirtualUrl;
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    public String getReferrerUrl() {
        return this.mReferrerUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public Bitmap getFavicon() {
        return this.mFavicon;
    }

    public void updateFavicon(Bitmap favicon) {
        this.mFavicon = favicon;
    }

    public int getTransition() {
        return this.mTransition;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }
}
