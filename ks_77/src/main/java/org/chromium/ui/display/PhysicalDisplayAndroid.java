package org.chromium.ui.display;

import android.annotation.TargetApi;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import java.util.Arrays;
import java.util.List;
import org.chromium.base.CommandLine;
import org.chromium.base.Log;
import org.chromium.base.compat.ApiHelperForO;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/display/PhysicalDisplayAndroid.class */
public class PhysicalDisplayAndroid extends DisplayAndroid {
    private static final String TAG = "DisplayAndroid";
    private static Float sForcedDIPScale;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PhysicalDisplayAndroid.class.desiredAssertionStatus();
    }

    private static boolean hasForcedDIPScale() {
        if (sForcedDIPScale == null) {
            String forcedScaleAsString = CommandLine.getInstance().getSwitchValue(DisplaySwitches.FORCE_DEVICE_SCALE_FACTOR);
            if (forcedScaleAsString == null) {
                sForcedDIPScale = Float.valueOf(0.0f);
            } else {
                boolean isInvalid = false;
                try {
                    sForcedDIPScale = Float.valueOf(forcedScaleAsString);
                    if (sForcedDIPScale.floatValue() <= 0.0f) {
                        isInvalid = true;
                    }
                } catch (NumberFormatException e) {
                    isInvalid = true;
                }
                if (isInvalid) {
                    Log.w(TAG, "Ignoring invalid forced DIP scale '" + forcedScaleAsString + "'", new Object[0]);
                    sForcedDIPScale = Float.valueOf(0.0f);
                }
            }
        }
        return sForcedDIPScale.floatValue() > 0.0f;
    }

    private static int bitsPerPixel(int pixelFormatId) {
        if (pixelFormatId == 1) {
            return 24;
        }
        PixelFormat pixelFormat = new PixelFormat();
        PixelFormat.getPixelFormatInfo(pixelFormatId, pixelFormat);
        if (PixelFormat.formatHasAlpha(pixelFormatId)) {
            switch (pixelFormatId) {
                case 1:
                    if ($assertionsDisabled) {
                        return 24;
                    }
                    throw new AssertionError();
                case 2:
                case 3:
                default:
                    return 24;
                case 6:
                    return 15;
                case 7:
                    return 12;
                case 43:
                    return 30;
            }
        }
        return pixelFormat.bitsPerPixel;
    }

    private static int bitsPerComponent(int pixelFormatId) {
        switch (pixelFormatId) {
            case 1:
            case 2:
            case 3:
                return 8;
            case 4:
                return 5;
            case 5:
            default:
                return 8;
            case 6:
                return 5;
            case 7:
                return 4;
            case 8:
            case 9:
            case 10:
                return 0;
            case 11:
                return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhysicalDisplayAndroid(Display display) {
        super(display.getDisplayId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(17)
    public void updateFromDisplay(Display display) {
        int i;
        Point size = new Point();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(size);
            display.getRealMetrics(displayMetrics);
        } else {
            display.getSize(size);
            display.getMetrics(displayMetrics);
        }
        if (hasForcedDIPScale()) {
            displayMetrics.density = sForcedDIPScale.floatValue();
        }
        boolean isWideColorGamut = false;
        if (Build.VERSION.SDK_INT >= 26) {
            isWideColorGamut = ApiHelperForO.isWideColorGamut(display);
        }
        if (Build.VERSION.SDK_INT < 17) {
            i = display.getPixelFormat();
        } else {
            i = 1;
        }
        int pixelFormatId = i;
        Display.Mode currentMode = null;
        List<Display.Mode> supportedModes = null;
        if (Build.VERSION.SDK_INT >= 23) {
            currentMode = display.getMode();
            supportedModes = Arrays.asList(display.getSupportedModes());
            if (!$assertionsDisabled && currentMode == null) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && supportedModes == null) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && supportedModes.size() <= 0) {
                throw new AssertionError();
            }
        }
        super.update(size, Float.valueOf(displayMetrics.density), Integer.valueOf(bitsPerPixel(pixelFormatId)), Integer.valueOf(bitsPerComponent(pixelFormatId)), Integer.valueOf(display.getRotation()), Boolean.valueOf(isWideColorGamut), null, Float.valueOf(display.getRefreshRate()), currentMode, supportedModes);
    }
}
