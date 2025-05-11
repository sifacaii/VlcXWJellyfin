package com.pakdata.xwalk.refactor.extension.api;

import android.view.Display;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/extension/api/DisplayManagerNull.class */
public class DisplayManagerNull extends XWalkDisplayManager {
    private static final Display[] NO_DISPLAYS = new Display[0];

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public Display getDisplay(int displayId) {
        return null;
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public Display[] getDisplays() {
        return NO_DISPLAYS;
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public Display[] getDisplays(String category) {
        return NO_DISPLAYS;
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public Display[] getPresentationDisplays() {
        return NO_DISPLAYS;
    }
}
