package org.chromium.ui.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/display/DisplayAndroid.class */
public class DisplayAndroid {
    private static final DisplayAndroidObserver[] EMPTY_OBSERVER_ARRAY;
    private final int mDisplayId;
    private float mDipScale;
    private int mBitsPerPixel;
    private int mBitsPerComponent;
    private int mRotation;
    private float mRefreshRate;
    private Display.Mode mCurrentDisplayMode;
    private List<Display.Mode> mDisplayModes;
    protected boolean mIsDisplayWideColorGamut;
    protected boolean mIsDisplayServerWideColorGamut;
    static final /* synthetic */ boolean $assertionsDisabled;
    private final WeakHashMap<DisplayAndroidObserver, Object> mObservers = new WeakHashMap<>();
    private Point mSize = new Point();

    static {
        $assertionsDisabled = !DisplayAndroid.class.desiredAssertionStatus();
        EMPTY_OBSERVER_ARRAY = new DisplayAndroidObserver[0];
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/display/DisplayAndroid$DisplayAndroidObserver.class */
    public interface DisplayAndroidObserver {
        default void onRotationChanged(int rotation) {
        }

        default void onDIPScaleChanged(float dipScale) {
        }

        default void onRefreshRateChanged(float refreshRate) {
        }

        default void onDisplayModesChanged(List<Display.Mode> supportedModes) {
        }

        default void onCurrentModeChanged(Display.Mode currentMode) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static DisplayAndroidManager getManager() {
        return DisplayAndroidManager.getInstance();
    }

    public static DisplayAndroid getNonMultiDisplay(Context context) {
        Display display = DisplayAndroidManager.getDefaultDisplayForContext(context);
        return getManager().getDisplayAndroid(display);
    }

    public int getDisplayId() {
        return this.mDisplayId;
    }

    public int getDisplayHeight() {
        return this.mSize.y;
    }

    public int getDisplayWidth() {
        return this.mSize.x;
    }

    public int getRotation() {
        return this.mRotation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRotationDegrees() {
        switch (getRotation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                if ($assertionsDisabled) {
                    return 0;
                }
                throw new AssertionError();
        }
    }

    public float getDipScale() {
        return this.mDipScale;
    }

    public float getAndroidUIScaling() {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBitsPerPixel() {
        return this.mBitsPerPixel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBitsPerComponent() {
        return this.mBitsPerComponent;
    }

    public boolean getIsWideColorGamut() {
        return this.mIsDisplayWideColorGamut && this.mIsDisplayServerWideColorGamut;
    }

    public float getRefreshRate() {
        return this.mRefreshRate;
    }

    public List<Display.Mode> getSupportedModes() {
        return this.mDisplayModes;
    }

    public Display.Mode getCurrentMode() {
        return this.mCurrentDisplayMode;
    }

    public void addObserver(DisplayAndroidObserver observer) {
        this.mObservers.put(observer, null);
    }

    public void removeObserver(DisplayAndroidObserver observer) {
        this.mObservers.remove(observer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DisplayAndroid(int displayId) {
        this.mDisplayId = displayId;
    }

    private DisplayAndroidObserver[] getObservers() {
        return (DisplayAndroidObserver[]) this.mObservers.keySet().toArray(EMPTY_OBSERVER_ARRAY);
    }

    public void updateIsDisplayServerWideColorGamut(Boolean isDisplayServerWideColorGamut) {
        update(null, null, null, null, null, null, isDisplayServerWideColorGamut, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void update(Point size, Float dipScale, Integer bitsPerPixel, Integer bitsPerComponent, Integer rotation, Boolean isDisplayWideColorGamut, Boolean isDisplayServerWideColorGamut, Float refreshRate, Display.Mode currentMode, List<Display.Mode> supportedModes) {
        boolean sizeChanged = (size == null || this.mSize.equals(size)) ? false : true;
        boolean dipScaleChanged = (dipScale == null || this.mDipScale == dipScale.floatValue()) ? false : true;
        boolean bitsPerPixelChanged = (bitsPerPixel == null || this.mBitsPerPixel == bitsPerPixel.intValue()) ? false : true;
        boolean bitsPerComponentChanged = (bitsPerComponent == null || this.mBitsPerComponent == bitsPerComponent.intValue()) ? false : true;
        boolean rotationChanged = (rotation == null || this.mRotation == rotation.intValue()) ? false : true;
        boolean isDisplayWideColorGamutChanged = (isDisplayWideColorGamut == null || this.mIsDisplayWideColorGamut == isDisplayWideColorGamut.booleanValue()) ? false : true;
        boolean isDisplayServerWideColorGamutChanged = (isDisplayServerWideColorGamut == null || this.mIsDisplayServerWideColorGamut == isDisplayServerWideColorGamut.booleanValue()) ? false : true;
        boolean isRefreshRateChanged = (refreshRate == null || this.mRefreshRate == refreshRate.floatValue()) ? false : true;
        boolean displayModesChanged = supportedModes != null && (this.mDisplayModes == null || this.mDisplayModes.equals(supportedModes));
        boolean currentModeChanged = (currentMode == null || currentMode.equals(this.mCurrentDisplayMode)) ? false : true;
        boolean changed = sizeChanged || dipScaleChanged || bitsPerPixelChanged || bitsPerComponentChanged || rotationChanged || isDisplayWideColorGamutChanged || isDisplayServerWideColorGamutChanged || isRefreshRateChanged || displayModesChanged || currentModeChanged;
        if (changed) {
            if (sizeChanged) {
                this.mSize = size;
            }
            if (dipScaleChanged) {
                this.mDipScale = dipScale.floatValue();
            }
            if (bitsPerPixelChanged) {
                this.mBitsPerPixel = bitsPerPixel.intValue();
            }
            if (bitsPerComponentChanged) {
                this.mBitsPerComponent = bitsPerComponent.intValue();
            }
            if (rotationChanged) {
                this.mRotation = rotation.intValue();
            }
            if (isDisplayWideColorGamutChanged) {
                this.mIsDisplayWideColorGamut = isDisplayWideColorGamut.booleanValue();
            }
            if (isDisplayServerWideColorGamutChanged) {
                this.mIsDisplayServerWideColorGamut = isDisplayServerWideColorGamut.booleanValue();
            }
            if (isRefreshRateChanged) {
                this.mRefreshRate = refreshRate.floatValue();
            }
            if (displayModesChanged) {
                this.mDisplayModes = supportedModes;
            }
            if (currentModeChanged) {
                this.mCurrentDisplayMode = currentMode;
            }
            getManager().updateDisplayOnNativeSide(this);
            if (rotationChanged) {
                DisplayAndroidObserver[] observers = getObservers();
                for (DisplayAndroidObserver o : observers) {
                    o.onRotationChanged(this.mRotation);
                }
            }
            if (dipScaleChanged) {
                DisplayAndroidObserver[] observers2 = getObservers();
                for (DisplayAndroidObserver o2 : observers2) {
                    o2.onDIPScaleChanged(this.mDipScale);
                }
            }
            if (isRefreshRateChanged) {
                DisplayAndroidObserver[] observers3 = getObservers();
                for (DisplayAndroidObserver o3 : observers3) {
                    o3.onRefreshRateChanged(this.mRefreshRate);
                }
            }
            if (displayModesChanged) {
                DisplayAndroidObserver[] observers4 = getObservers();
                for (DisplayAndroidObserver o4 : observers4) {
                    o4.onDisplayModesChanged(this.mDisplayModes);
                }
            }
            if (currentModeChanged) {
                DisplayAndroidObserver[] observers5 = getObservers();
                for (DisplayAndroidObserver o5 : observers5) {
                    o5.onCurrentModeChanged(this.mCurrentDisplayMode);
                }
            }
        }
    }
}
