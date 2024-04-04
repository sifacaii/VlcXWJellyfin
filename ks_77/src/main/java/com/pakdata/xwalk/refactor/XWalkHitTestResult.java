package com.pakdata.xwalk.refactor;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkHitTestResult.class */
public class XWalkHitTestResult {
    private int mType = 0;
    private String mExtra;
    private String mHref;
    private String mAnchorText;
    private String mImgSrc;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkHitTestResult$type.class */
    public enum type {
        UNKNOWN_TYPE,
        ANCHOR_TYPE,
        PHONE_TYPE,
        GEO_TYPE,
        EMAIL_TYPE,
        IMAGE_TYPE,
        IMAGE_ANCHOR_TYPE,
        SRC_ANCHOR_TYPE,
        SRC_IMAGE_ANCHOR_TYPE,
        EDIT_TEXT_TYPE
    }

    public void setType(int type2) {
        this.mType = type2;
    }

    public void setExtra(String extra) {
        this.mExtra = extra;
    }

    public void setHref(String href) {
        this.mHref = href;
    }

    public void setAnchorText(String text) {
        this.mAnchorText = text;
    }

    public void setImgSrc(String imgSrc) {
        this.mImgSrc = imgSrc;
    }

    public type getType() {
        type a;
        switch (this.mType) {
            case 0:
                a = type.UNKNOWN_TYPE;
                break;
            case 1:
                a = type.ANCHOR_TYPE;
                break;
            case 2:
                a = type.PHONE_TYPE;
                break;
            case 3:
                a = type.GEO_TYPE;
                break;
            case 4:
                a = type.EMAIL_TYPE;
                break;
            case 5:
                a = type.IMAGE_TYPE;
                break;
            case 6:
                a = type.IMAGE_ANCHOR_TYPE;
                break;
            case 7:
                a = type.SRC_ANCHOR_TYPE;
                break;
            case 8:
                a = type.SRC_IMAGE_ANCHOR_TYPE;
                break;
            case 9:
                a = type.EDIT_TEXT_TYPE;
                break;
            default:
                a = type.UNKNOWN_TYPE;
                break;
        }
        return a;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public String getHref() {
        return this.mHref;
    }

    public String getAnchorText() {
        return this.mAnchorText;
    }

    public String getImgSrc() {
        return this.mImgSrc;
    }
}
