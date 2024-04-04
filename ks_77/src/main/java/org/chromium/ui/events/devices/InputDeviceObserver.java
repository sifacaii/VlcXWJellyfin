package org.chromium.ui.events.devices;

import android.content.Context;
import android.hardware.input.InputManager;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("ui")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/events/devices/InputDeviceObserver.class */
public class InputDeviceObserver implements InputManager.InputDeviceListener {
    private static final InputDeviceObserver INSTANCE;
    private InputManager mInputManager;
    private InputManager.InputDeviceListener mInputDeviceListener;
    private int mObserversCounter;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeInputConfigurationChanged();

    static {
        $assertionsDisabled = !InputDeviceObserver.class.desiredAssertionStatus();
        INSTANCE = new InputDeviceObserver();
    }

    @CalledByNative
    public static void addObserver() {
        if (!$assertionsDisabled && !ThreadUtils.runningOnUiThread()) {
            throw new AssertionError();
        }
        INSTANCE.attachObserver();
    }

    @CalledByNative
    public static void removeObserver() {
        if (!$assertionsDisabled && !ThreadUtils.runningOnUiThread()) {
            throw new AssertionError();
        }
        INSTANCE.detachObserver();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int deviceId) {
        nativeInputConfigurationChanged();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int deviceId) {
        nativeInputConfigurationChanged();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int deviceId) {
        nativeInputConfigurationChanged();
    }

    private void attachObserver() {
        int i = this.mObserversCounter;
        this.mObserversCounter = i + 1;
        if (i == 0) {
            Context context = ContextUtils.getApplicationContext();
            this.mInputManager = (InputManager) context.getSystemService("input");
            this.mInputManager.registerInputDeviceListener(this, null);
        }
    }

    private void detachObserver() {
        if (!$assertionsDisabled && this.mObserversCounter <= 0) {
            throw new AssertionError();
        }
        int i = this.mObserversCounter - 1;
        this.mObserversCounter = i;
        if (i == 0) {
            this.mInputManager.unregisterInputDeviceListener(this);
            this.mInputManager = null;
        }
    }
}
