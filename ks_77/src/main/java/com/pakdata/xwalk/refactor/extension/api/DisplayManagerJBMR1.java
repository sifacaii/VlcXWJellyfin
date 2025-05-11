package com.pakdata.xwalk.refactor.extension.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager;

@SuppressLint({"NewApi"})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/extension/api/DisplayManagerJBMR1.class */
public class DisplayManagerJBMR1 extends XWalkDisplayManager implements DisplayManager.DisplayListener {
    private DisplayManager mDisplayManager;

    public DisplayManagerJBMR1(Context context) {
        this.mDisplayManager = (DisplayManager) context.getSystemService("display");
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public Display getDisplay(int displayId) {
        return this.mDisplayManager.getDisplay(displayId);
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public Display[] getDisplays() {
        return this.mDisplayManager.getDisplays();
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public Display[] getDisplays(String category) {
        return this.mDisplayManager.getDisplays(category);
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public Display[] getPresentationDisplays() {
        return this.mDisplayManager.getDisplays("android.hardware.display.category.PRESENTATION");
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public void registerDisplayListener(XWalkDisplayManager.DisplayListener listener) {
        super.registerDisplayListener(listener);
        if (this.mListeners.size() == 1) {
            this.mDisplayManager.registerDisplayListener(this, null);
        }
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager
    public void unregisterDisplayListener(XWalkDisplayManager.DisplayListener listener) {
        super.unregisterDisplayListener(listener);
        if (this.mListeners.size() == 0) {
            this.mDisplayManager.unregisterDisplayListener(this);
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int displayId) {
        notifyDisplayAdded(displayId);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int displayId) {
        notifyDisplayRemoved(displayId);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int displayId) {
        notifyDisplayChanged(displayId);
    }
}
