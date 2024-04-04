package org.chromium.content_public.browser;

import org.chromium.content.browser.RenderCoordinatesImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/RenderCoordinates.class */
public interface RenderCoordinates {
    int getScrollXPixInt();

    int getScrollYPixInt();

    int getContentWidthPixInt();

    int getContentHeightPixInt();

    int getLastFrameViewportWidthPixInt();

    int getLastFrameViewportHeightPixInt();

    int getMaxVerticalScrollPixInt();

    int getMaxHorizontalScrollPixInt();

    static RenderCoordinates fromWebContents(WebContents webContents) {
        return RenderCoordinatesImpl.fromWebContents(webContents);
    }
}
