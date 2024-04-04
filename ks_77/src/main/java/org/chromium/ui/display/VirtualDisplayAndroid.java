package org.chromium.ui.display;

import android.graphics.Point;
import android.view.Display;
import java.util.List;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/display/VirtualDisplayAndroid.class */
public class VirtualDisplayAndroid extends DisplayAndroid {
    private float mAndroidUiScalingFactor;

    public static VirtualDisplayAndroid createVirtualDisplay() {
        return getManager().addVirtualDisplay();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VirtualDisplayAndroid(int displayId) {
        super(displayId);
        this.mAndroidUiScalingFactor = 1.0f;
    }

    public void setTo(DisplayAndroid other) {
        update(new Point(other.getDisplayWidth(), other.getDisplayHeight()), Float.valueOf(other.getDipScale()), Integer.valueOf(other.getBitsPerPixel()), Integer.valueOf(other.getBitsPerComponent()), Integer.valueOf(other.getRotation()), Boolean.valueOf(other.mIsDisplayWideColorGamut), Boolean.valueOf(other.mIsDisplayServerWideColorGamut), Float.valueOf(other.getRefreshRate()), other.getCurrentMode(), other.getSupportedModes());
        this.mAndroidUiScalingFactor = other.getAndroidUIScaling();
    }

    public void update(Point size, Float dipScale, Float androidUiScalingFactor, Integer bitsPerPixel, Integer bitsPerComponent, Integer rotation, Boolean isDisplayWideColorGamut, Boolean isDisplayServerWideColorGamut, Float refreshRate, Display.Mode currentMode, List<Display.Mode> supportedModes) {
        super.update(size, dipScale, bitsPerPixel, bitsPerComponent, rotation, isDisplayWideColorGamut, isDisplayServerWideColorGamut, refreshRate, currentMode, supportedModes);
        if (androidUiScalingFactor != null) {
            this.mAndroidUiScalingFactor = androidUiScalingFactor.floatValue();
        }
    }

    @Override // org.chromium.ui.display.DisplayAndroid
    public float getAndroidUIScaling() {
        return this.mAndroidUiScalingFactor;
    }

    public void destroy() {
        getManager().removeVirtualDisplay(this);
    }
}
