package org.chromium.device.gamepad;

import android.os.SystemClock;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.List;
import org.chromium.base.VisibleForTesting;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadDevice.class */
class GamepadDevice {
    @VisibleForTesting
    static final int MAX_RAW_AXIS_VALUES = 256;
    @VisibleForTesting
    static final int MAX_RAW_BUTTON_VALUES = 256;
    private int mDeviceId;
    private int mDeviceIndex;
    private String mDeviceName;
    private int[] mAxes;
    private GamepadMappings mMappings;
    static final /* synthetic */ boolean $assertionsDisabled;
    private final float[] mAxisValues = new float[4];
    private final float[] mButtonsValues = new float[17];
    private final float[] mRawButtons = new float[256];
    private final float[] mRawAxes = new float[256];
    private long mTimestamp = SystemClock.uptimeMillis();

    static {
        $assertionsDisabled = !GamepadDevice.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamepadDevice(int index, InputDevice inputDevice) {
        this.mDeviceIndex = index;
        this.mDeviceId = inputDevice.getId();
        this.mDeviceName = inputDevice.getName();
        List<InputDevice.MotionRange> ranges = inputDevice.getMotionRanges();
        this.mAxes = new int[ranges.size()];
        int i = 0;
        for (InputDevice.MotionRange range : ranges) {
            if ((range.getSource() & 16) != 0) {
                int axis = range.getAxis();
                if (!$assertionsDisabled && axis >= 256) {
                    throw new AssertionError();
                }
                int i2 = i;
                i++;
                this.mAxes[i2] = axis;
            }
        }
        this.mMappings = GamepadMappings.getMappings(inputDevice, this.mAxes);
    }

    public void updateButtonsAndAxesMapping() {
        this.mMappings.mapToStandardGamepad(this.mAxisValues, this.mButtonsValues, this.mRawAxes, this.mRawButtons);
    }

    public int getId() {
        return this.mDeviceId;
    }

    public boolean isStandardGamepad() {
        return this.mMappings.isStandard();
    }

    public String getName() {
        return this.mDeviceName;
    }

    public int getIndex() {
        return this.mDeviceIndex;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public float[] getAxes() {
        return this.mAxisValues;
    }

    public float[] getButtons() {
        return this.mButtonsValues;
    }

    public void clearData() {
        Arrays.fill(this.mAxisValues, 0.0f);
        Arrays.fill(this.mRawAxes, 0.0f);
        Arrays.fill(this.mButtonsValues, 0.0f);
        Arrays.fill(this.mRawButtons, 0.0f);
    }

    public boolean handleKeyEvent(KeyEvent event) {
        if (GamepadList.isGamepadEvent(event)) {
            int keyCode = event.getKeyCode();
            if ($assertionsDisabled || keyCode < 256) {
                if (event.getAction() == 0) {
                    this.mRawButtons[keyCode] = 1.0f;
                } else if (event.getAction() == 1) {
                    this.mRawButtons[keyCode] = 0.0f;
                }
                this.mTimestamp = event.getEventTime();
                return true;
            }
            throw new AssertionError();
        }
        return false;
    }

    public boolean handleMotionEvent(MotionEvent event) {
        if (GamepadList.isGamepadEvent(event)) {
            for (int i = 0; i < this.mAxes.length; i++) {
                int axis = this.mAxes[i];
                this.mRawAxes[axis] = event.getAxisValue(axis);
            }
            this.mTimestamp = event.getEventTime();
            return true;
        }
        return false;
    }
}
