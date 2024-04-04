package org.chromium.content_public.common;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/common/Referrer.class */
public class Referrer {
    private final String mUrl;
    private final int mPolicy;

    public Referrer(String url, int policy) {
        this.mUrl = url;
        this.mPolicy = policy;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getPolicy() {
        return this.mPolicy;
    }
}
