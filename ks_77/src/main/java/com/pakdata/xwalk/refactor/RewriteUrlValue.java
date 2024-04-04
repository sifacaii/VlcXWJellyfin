package com.pakdata.xwalk.refactor;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/RewriteUrlValue.class */
public class RewriteUrlValue {
    private String url;
    private int transitionType;

    private void nativeInit(String url, int trType) {
        this.url = url;
        this.transitionType = trType;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTransitionType() {
        return this.transitionType;
    }

    public void setTransitionType(int transitionType) {
        this.transitionType = transitionType;
    }
}
