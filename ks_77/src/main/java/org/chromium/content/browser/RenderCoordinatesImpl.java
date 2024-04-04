package org.chromium.content.browser;

import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.RenderCoordinates;
import org.chromium.content_public.browser.WebContents;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/RenderCoordinatesImpl.class */
public class RenderCoordinatesImpl implements RenderCoordinates {
    private float mScrollXCss;
    private float mScrollYCss;
    private float mContentWidthCss;
    private float mContentHeightCss;
    private float mLastFrameViewportWidthCss;
    private float mLastFrameViewportHeightCss;
    private float mPageScaleFactor = 1.0f;
    private float mMinPageScaleFactor = 1.0f;
    private float mMaxPageScaleFactor = 1.0f;
    private float mDeviceScaleFactor = 1.0f;
    private float mTopContentOffsetYPix;

    public static RenderCoordinatesImpl fromWebContents(WebContents webContents) {
        return ((WebContentsImpl) webContents).getRenderCoordinates();
    }

    public void reset() {
        this.mScrollYCss = 0.0f;
        this.mScrollXCss = 0.0f;
        this.mPageScaleFactor = 1.0f;
    }

    @Override // org.chromium.content_public.browser.RenderCoordinates
    public int getScrollXPixInt() {
        return (int) Math.floor(getScrollXPix());
    }

    @Override // org.chromium.content_public.browser.RenderCoordinates
    public int getScrollYPixInt() {
        return (int) Math.floor(getScrollYPix());
    }

    @Override // org.chromium.content_public.browser.RenderCoordinates
    public int getContentWidthPixInt() {
        return (int) Math.ceil(getContentWidthPix());
    }

    @Override // org.chromium.content_public.browser.RenderCoordinates
    public int getContentHeightPixInt() {
        return (int) Math.ceil(getContentHeightPix());
    }

    @Override // org.chromium.content_public.browser.RenderCoordinates
    public int getLastFrameViewportWidthPixInt() {
        return (int) Math.ceil(getLastFrameViewportWidthPix());
    }

    @Override // org.chromium.content_public.browser.RenderCoordinates
    public int getLastFrameViewportHeightPixInt() {
        return (int) Math.ceil(getLastFrameViewportHeightPix());
    }

    @Override // org.chromium.content_public.browser.RenderCoordinates
    public int getMaxVerticalScrollPixInt() {
        return (int) Math.floor(getMaxVerticalScrollPix());
    }

    @Override // org.chromium.content_public.browser.RenderCoordinates
    public int getMaxHorizontalScrollPixInt() {
        return (int) Math.floor(getMaxHorizontalScrollPix());
    }

    void updateContentSizeCss(float contentWidthCss, float contentHeightCss) {
        this.mContentWidthCss = contentWidthCss;
        this.mContentHeightCss = contentHeightCss;
    }

    public void setDeviceScaleFactor(float dipScale) {
        this.mDeviceScaleFactor = dipScale;
    }

    public void updateFrameInfo(float scrollXCss, float scrollYCss, float contentWidthCss, float contentHeightCss, float viewportWidthCss, float viewportHeightCss, float pageScaleFactor, float minPageScaleFactor, float maxPageScaleFactor, float contentOffsetYPix) {
        this.mScrollXCss = scrollXCss;
        this.mScrollYCss = scrollYCss;
        this.mPageScaleFactor = pageScaleFactor;
        this.mMinPageScaleFactor = minPageScaleFactor;
        this.mMaxPageScaleFactor = maxPageScaleFactor;
        this.mTopContentOffsetYPix = contentOffsetYPix;
        updateContentSizeCss(contentWidthCss, contentHeightCss);
        this.mLastFrameViewportWidthCss = viewportWidthCss;
        this.mLastFrameViewportHeightCss = viewportHeightCss;
    }

    public float getScrollX() {
        return this.mScrollXCss;
    }

    public float getScrollY() {
        return this.mScrollYCss;
    }

    public float getScrollXPix() {
        return fromLocalCssToPix(this.mScrollXCss);
    }

    public float getScrollYPix() {
        return fromLocalCssToPix(this.mScrollYCss);
    }

    public float getContentWidthCss() {
        return this.mContentWidthCss;
    }

    public float getContentHeightCss() {
        return this.mContentHeightCss;
    }

    public float getContentOffsetYPix() {
        return this.mTopContentOffsetYPix;
    }

    public float getPageScaleFactor() {
        return this.mPageScaleFactor;
    }

    public float getMinPageScaleFactor() {
        return this.mMinPageScaleFactor;
    }

    public float getMaxPageScaleFactor() {
        return this.mMaxPageScaleFactor;
    }

    public float getDeviceScaleFactor() {
        return this.mDeviceScaleFactor;
    }

    public float fromLocalCssToPix(float css) {
        return css * this.mPageScaleFactor * this.mDeviceScaleFactor;
    }

    private float getContentWidthPix() {
        return fromLocalCssToPix(this.mContentWidthCss);
    }

    private float getContentHeightPix() {
        return fromLocalCssToPix(this.mContentHeightCss);
    }

    private float getLastFrameViewportWidthPix() {
        return fromLocalCssToPix(this.mLastFrameViewportWidthCss);
    }

    private float getLastFrameViewportHeightPix() {
        return fromLocalCssToPix(this.mLastFrameViewportHeightCss);
    }

    private float getMaxHorizontalScrollPix() {
        return getContentWidthPix() - getLastFrameViewportWidthPix();
    }

    private float getMaxVerticalScrollPix() {
        return getContentHeightPix() - getLastFrameViewportHeightPix();
    }
}
