package org.chromium.device.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

/* JADX INFO: Access modifiers changed from: package-private */
@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/sensors/PlatformSensorProvider.class */
public class PlatformSensorProvider {
    private SensorManager mSensorManager;
    private HandlerThread mSensorsThread;
    private Handler mHandler;
    private final Set<PlatformSensor> mActiveSensors = new HashSet();

    public Handler getHandler() {
        return this.mHandler;
    }

    public SensorManager getSensorManager() {
        return this.mSensorManager;
    }

    public void sensorStarted(PlatformSensor sensor) {
        synchronized (this.mActiveSensors) {
            if (this.mActiveSensors.isEmpty()) {
                startSensorThread();
            }
            this.mActiveSensors.add(sensor);
        }
    }

    public void sensorStopped(PlatformSensor sensor) {
        synchronized (this.mActiveSensors) {
            this.mActiveSensors.remove(sensor);
            if (this.mActiveSensors.isEmpty()) {
                stopSensorThread();
            }
        }
    }

    protected void startSensorThread() {
        if (this.mSensorsThread == null) {
            this.mSensorsThread = new HandlerThread("SensorsHandlerThread");
            this.mSensorsThread.start();
            this.mHandler = new Handler(this.mSensorsThread.getLooper());
        }
    }

    protected void stopSensorThread() {
        if (this.mSensorsThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.mSensorsThread.quitSafely();
            } else {
                this.mSensorsThread.quit();
            }
            this.mSensorsThread = null;
            this.mHandler = null;
        }
    }

    protected PlatformSensorProvider(Context context) {
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
    }

    protected static PlatformSensorProvider createForTest(Context context) {
        return new PlatformSensorProvider(context);
    }

    @CalledByNative
    protected static PlatformSensorProvider create() {
        return new PlatformSensorProvider(ContextUtils.getApplicationContext());
    }

    @CalledByNative
    protected void setSensorManagerToNullForTesting() {
        this.mSensorManager = null;
    }

    @CalledByNative
    protected boolean hasSensorType(int type) {
        int sensorType;
        if (this.mSensorManager == null) {
            return false;
        }
        switch (type) {
            case 0:
                sensorType = 5;
                break;
            case 1:
            case 6:
            case 7:
            case 9:
            default:
                return false;
            case 2:
                sensorType = 1;
                break;
            case 3:
                sensorType = 10;
                break;
            case 4:
                sensorType = 4;
                break;
            case 5:
                sensorType = 2;
                break;
            case 8:
                sensorType = 11;
                break;
            case 10:
                sensorType = 15;
                break;
        }
        List<Sensor> sensors = this.mSensorManager.getSensorList(sensorType);
        return !sensors.isEmpty();
    }

    @CalledByNative
    protected PlatformSensor createSensor(int type) {
        if (this.mSensorManager == null) {
            return null;
        }
        switch (type) {
            case 0:
                return PlatformSensor.create(5, 1, this);
            case 1:
            case 6:
            case 7:
            case 9:
            default:
                return null;
            case 2:
                return PlatformSensor.create(1, 3, this);
            case 3:
                return PlatformSensor.create(10, 3, this);
            case 4:
                return PlatformSensor.create(4, 3, this);
            case 5:
                return PlatformSensor.create(2, 3, this);
            case 8:
                return PlatformSensor.create(11, 4, this);
            case 10:
                return PlatformSensor.create(15, 4, this);
        }
    }
}
