package org.chromium.device.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/sensors/PlatformSensor.class */
public class PlatformSensor implements SensorEventListener {
    private static final double MICROSECONDS_IN_SECOND = 1000000.0d;
    private static final double SECONDS_IN_MICROSECOND = 1.0E-6d;
    private static final double SECONDS_IN_NANOSECOND = 1.0E-9d;
    private static final String TAG = "PlatformSensor";
    private static final double SENSOR_FREQUENCY_NORMAL = 5.0d;
    private long mNativePlatformSensorAndroid;
    private final Sensor mSensor;
    private final int mMinDelayUsec;
    private final int mReadingCount;
    private double mCurrentPollingFrequency;
    private final PlatformSensorProvider mProvider;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeNotifyPlatformSensorError(long j);

    private native void nativeUpdatePlatformSensorReading(long j, double d, double d2, double d3, double d4, double d5);

    static {
        $assertionsDisabled = !PlatformSensor.class.desiredAssertionStatus();
    }

    public static PlatformSensor create(int sensorType, int readingCount, PlatformSensorProvider provider) {
        List<Sensor> sensors = provider.getSensorManager().getSensorList(sensorType);
        if (sensors.isEmpty()) {
            return null;
        }
        return new PlatformSensor(sensors.get(0), readingCount, provider);
    }

    protected PlatformSensor(Sensor sensor, int readingCount, PlatformSensorProvider provider) {
        this.mReadingCount = readingCount;
        this.mProvider = provider;
        this.mSensor = sensor;
        this.mMinDelayUsec = this.mSensor.getMinDelay();
    }

    @CalledByNative
    protected void initPlatformSensorAndroid(long nativePlatformSensorAndroid) {
        if (!$assertionsDisabled && nativePlatformSensorAndroid == 0) {
            throw new AssertionError();
        }
        this.mNativePlatformSensorAndroid = nativePlatformSensorAndroid;
    }

    @CalledByNative
    protected int getReportingMode() {
        if (Build.VERSION.SDK_INT < 21 || this.mSensor.getReportingMode() == 0) {
            return 1;
        }
        return 0;
    }

    @CalledByNative
    protected double getDefaultConfiguration() {
        return SENSOR_FREQUENCY_NORMAL;
    }

    @CalledByNative
    protected double getMaximumSupportedFrequency() {
        return this.mMinDelayUsec == 0 ? getDefaultConfiguration() : 1.0d / (this.mMinDelayUsec * SECONDS_IN_MICROSECOND);
    }

    @CalledByNative
    protected boolean startSensor(double frequency) {
        boolean sensorStarted;
        if (this.mCurrentPollingFrequency == frequency) {
            return true;
        }
        unregisterListener();
        this.mProvider.sensorStarted(this);
        try {
            sensorStarted = this.mProvider.getSensorManager().registerListener(this, this.mSensor, getSamplingPeriod(frequency), this.mProvider.getHandler());
        } catch (RuntimeException e) {
            Log.w(TAG, "Failed to register sensor listener.", e);
            sensorStarted = false;
        }
        if (!sensorStarted) {
            stopSensor();
            return sensorStarted;
        }
        this.mCurrentPollingFrequency = frequency;
        return sensorStarted;
    }

    private void unregisterListener() {
        if (this.mCurrentPollingFrequency == 0.0d) {
            return;
        }
        this.mProvider.getSensorManager().unregisterListener(this, this.mSensor);
    }

    @CalledByNative
    protected void stopSensor() {
        unregisterListener();
        this.mProvider.sensorStopped(this);
        this.mCurrentPollingFrequency = 0.0d;
    }

    @CalledByNative
    protected boolean checkSensorConfiguration(double frequency) {
        return this.mMinDelayUsec <= getSamplingPeriod(frequency);
    }

    @CalledByNative
    protected void sensorDestroyed() {
        stopSensor();
        this.mNativePlatformSensorAndroid = 0L;
    }

    private int getSamplingPeriod(double frequency) {
        return (int) ((1.0d / frequency) * MICROSECONDS_IN_SECOND);
    }

    protected void sensorError() {
        nativeNotifyPlatformSensorError(this.mNativePlatformSensorAndroid);
    }

    protected void updateSensorReading(double timestamp, double value1, double value2, double value3, double value4) {
        nativeUpdatePlatformSensorReading(this.mNativePlatformSensorAndroid, timestamp, value1, value2, value3, value4);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        if (this.mNativePlatformSensorAndroid == 0) {
            Log.w(TAG, "Should not get sensor events after PlatformSensorAndroid is destroyed.", new Object[0]);
        } else if (event.values.length < this.mReadingCount) {
            sensorError();
            stopSensor();
        } else {
            double timestamp = event.timestamp * SECONDS_IN_NANOSECOND;
            switch (event.values.length) {
                case 1:
                    updateSensorReading(timestamp, event.values[0], 0.0d, 0.0d, 0.0d);
                    return;
                case 2:
                    updateSensorReading(timestamp, event.values[0], event.values[1], 0.0d, 0.0d);
                    return;
                case 3:
                    updateSensorReading(timestamp, event.values[0], event.values[1], event.values[2], 0.0d);
                    return;
                default:
                    updateSensorReading(timestamp, event.values[0], event.values[1], event.values[2], event.values[3]);
                    return;
            }
        }
    }
}
