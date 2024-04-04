package org.chromium.device.gamepad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadList.class */
public class GamepadList {
    private static final int MAX_GAMEPADS = 4;
    private final Object mLock;
    private final GamepadDevice[] mGamepadDevices;
    private InputManager mInputManager;
    private int mAttachedToWindowCounter;
    private boolean mIsGamepadAPIActive;
    private InputManager.InputDeviceListener mInputDeviceListener;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeSetGamepadData(long j, int i, boolean z, boolean z2, String str, long j2, float[] fArr, float[] fArr2);

    static {
        $assertionsDisabled = !GamepadList.class.desiredAssertionStatus();
    }

    private GamepadList() {
        this.mLock = new Object();
        this.mGamepadDevices = new GamepadDevice[4];
        this.mInputDeviceListener = new InputManager.InputDeviceListener() { // from class: org.chromium.device.gamepad.GamepadList.1
            @Override // android.hardware.input.InputManager.InputDeviceListener
            public void onInputDeviceChanged(int deviceId) {
                GamepadList.this.onInputDeviceChangedImpl(deviceId);
            }

            @Override // android.hardware.input.InputManager.InputDeviceListener
            public void onInputDeviceRemoved(int deviceId) {
                GamepadList.this.onInputDeviceRemovedImpl(deviceId);
            }

            @Override // android.hardware.input.InputManager.InputDeviceListener
            public void onInputDeviceAdded(int deviceId) {
                GamepadList.this.onInputDeviceAddedImpl(deviceId);
            }
        };
    }

    private void initializeDevices() {
        int[] deviceIds = this.mInputManager.getInputDeviceIds();
        for (int i : deviceIds) {
            InputDevice inputDevice = InputDevice.getDevice(i);
            if (isGamepadDevice(inputDevice)) {
                registerGamepad(inputDevice);
            }
        }
    }

    public static void onAttachedToWindow(Context context) {
        if (!$assertionsDisabled && !ThreadUtils.runningOnUiThread()) {
            throw new AssertionError();
        }
        getInstance().attachedToWindow(context);
    }

    private void attachedToWindow(Context context) {
        int i = this.mAttachedToWindowCounter;
        this.mAttachedToWindowCounter = i + 1;
        if (i == 0) {
            this.mInputManager = (InputManager) context.getSystemService("input");
            synchronized (this.mLock) {
                initializeDevices();
            }
            this.mInputManager.registerInputDeviceListener(this.mInputDeviceListener, null);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public static void onDetachedFromWindow() {
        if (!$assertionsDisabled && !ThreadUtils.runningOnUiThread()) {
            throw new AssertionError();
        }
        getInstance().detachedFromWindow();
    }

    private void detachedFromWindow() {
        int i = this.mAttachedToWindowCounter - 1;
        this.mAttachedToWindowCounter = i;
        if (i == 0) {
            synchronized (this.mLock) {
                for (int i2 = 0; i2 < 4; i2++) {
                    this.mGamepadDevices[i2] = null;
                }
            }
            this.mInputManager.unregisterInputDeviceListener(this.mInputDeviceListener);
            this.mInputManager = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInputDeviceChangedImpl(int deviceId) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInputDeviceRemovedImpl(int deviceId) {
        synchronized (this.mLock) {
            unregisterGamepad(deviceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInputDeviceAddedImpl(int deviceId) {
        InputDevice inputDevice = InputDevice.getDevice(deviceId);
        if (isGamepadDevice(inputDevice)) {
            synchronized (this.mLock) {
                registerGamepad(inputDevice);
            }
        }
    }

    private static GamepadList getInstance() {
        return LazyHolder.INSTANCE;
    }

    private int getDeviceCount() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (getDevice(i) != null) {
                count++;
            }
        }
        return count;
    }

    private boolean isDeviceConnected(int index) {
        if (index < 4 && getDevice(index) != null) {
            return true;
        }
        return false;
    }

    private GamepadDevice getDeviceById(int deviceId) {
        for (int i = 0; i < 4; i++) {
            GamepadDevice gamepad = this.mGamepadDevices[i];
            if (gamepad != null && gamepad.getId() == deviceId) {
                return gamepad;
            }
        }
        return null;
    }

    private GamepadDevice getDevice(int index) {
        if ($assertionsDisabled || (index >= 0 && index < 4)) {
            return this.mGamepadDevices[index];
        }
        throw new AssertionError();
    }

    public static boolean dispatchKeyEvent(KeyEvent event) {
        if (isGamepadEvent(event)) {
            return getInstance().handleKeyEvent(event);
        }
        return false;
    }

    private boolean handleKeyEvent(KeyEvent event) {
        synchronized (this.mLock) {
            if (this.mIsGamepadAPIActive) {
                GamepadDevice gamepad = getGamepadForEvent(event);
                if (gamepad == null) {
                    return false;
                }
                return gamepad.handleKeyEvent(event);
            }
            return false;
        }
    }

    public static boolean onGenericMotionEvent(MotionEvent event) {
        if (isGamepadEvent(event)) {
            return getInstance().handleMotionEvent(event);
        }
        return false;
    }

    private boolean handleMotionEvent(MotionEvent event) {
        synchronized (this.mLock) {
            if (this.mIsGamepadAPIActive) {
                GamepadDevice gamepad = getGamepadForEvent(event);
                if (gamepad == null) {
                    return false;
                }
                return gamepad.handleMotionEvent(event);
            }
            return false;
        }
    }

    private int getNextAvailableIndex() {
        for (int i = 0; i < 4; i++) {
            if (getDevice(i) == null) {
                return i;
            }
        }
        return -1;
    }

    private boolean registerGamepad(InputDevice inputDevice) {
        int index = getNextAvailableIndex();
        if (index == -1) {
            return false;
        }
        GamepadDevice gamepad = new GamepadDevice(index, inputDevice);
        this.mGamepadDevices[index] = gamepad;
        return true;
    }

    private void unregisterGamepad(int deviceId) {
        GamepadDevice gamepadDevice = getDeviceById(deviceId);
        if (gamepadDevice == null) {
            return;
        }
        int index = gamepadDevice.getIndex();
        this.mGamepadDevices[index] = null;
    }

    private static boolean isGamepadDevice(InputDevice inputDevice) {
        return inputDevice != null && (inputDevice.getSources() & 16777232) == 16777232;
    }

    private GamepadDevice getGamepadForEvent(InputEvent event) {
        return getDeviceById(event.getDeviceId());
    }

    public static boolean isGamepadAPIActive() {
        return getInstance().mIsGamepadAPIActive;
    }

    public static boolean isGamepadEvent(MotionEvent event) {
        return (event.getSource() & 16777232) == 16777232;
    }

    public static boolean isGamepadEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case 19:
            case 20:
            case 21:
            case 22:
                return true;
            default:
                return KeyEvent.isGamepadButton(keyCode);
        }
    }

    @CalledByNative
    static void updateGamepadData(long webGamepadsPtr) {
        getInstance().grabGamepadData(webGamepadsPtr);
    }

    private void grabGamepadData(long webGamepadsPtr) {
        synchronized (this.mLock) {
            for (int i = 0; i < 4; i++) {
                GamepadDevice device = getDevice(i);
                if (device != null) {
                    device.updateButtonsAndAxesMapping();
                    nativeSetGamepadData(webGamepadsPtr, i, device.isStandardGamepad(), true, device.getName(), device.getTimestamp(), device.getAxes(), device.getButtons());
                } else {
                    nativeSetGamepadData(webGamepadsPtr, i, false, false, null, 0L, null, null);
                }
            }
        }
    }

    @CalledByNative
    static void setGamepadAPIActive(boolean isActive) {
        getInstance().setIsGamepadActive(isActive);
    }

    private void setIsGamepadActive(boolean isGamepadActive) {
        synchronized (this.mLock) {
            this.mIsGamepadAPIActive = isGamepadActive;
            if (isGamepadActive) {
                for (int i = 0; i < 4; i++) {
                    GamepadDevice gamepadDevice = getDevice(i);
                    if (gamepadDevice != null) {
                        gamepadDevice.clearData();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadList$LazyHolder.class */
    public static class LazyHolder {
        private static final GamepadList INSTANCE = new GamepadList();

        private LazyHolder() {
        }
    }
}
