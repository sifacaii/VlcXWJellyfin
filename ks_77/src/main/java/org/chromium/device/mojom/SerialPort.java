package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort.class */
public interface SerialPort extends Interface {
    public static final Interface.Manager<SerialPort, Proxy> MANAGER = SerialPort_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$ClearBreakResponse.class */
    public interface ClearBreakResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$CloseResponse.class */
    public interface CloseResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$ConfigurePortResponse.class */
    public interface ConfigurePortResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$FlushResponse.class */
    public interface FlushResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$GetControlSignalsResponse.class */
    public interface GetControlSignalsResponse extends Callbacks.Callback1<SerialPortControlSignals> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$GetPortInfoResponse.class */
    public interface GetPortInfoResponse extends Callbacks.Callback1<SerialConnectionInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$OpenResponse.class */
    public interface OpenResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$Proxy.class */
    public interface Proxy extends SerialPort, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$SetBreakResponse.class */
    public interface SetBreakResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPort$SetControlSignalsResponse.class */
    public interface SetControlSignalsResponse extends Callbacks.Callback1<Boolean> {
    }

    void open(SerialConnectionOptions serialConnectionOptions, DataPipe.ConsumerHandle consumerHandle, DataPipe.ProducerHandle producerHandle, SerialPortClient serialPortClient, OpenResponse openResponse);

    void clearSendError(DataPipe.ConsumerHandle consumerHandle);

    void clearReadError(DataPipe.ProducerHandle producerHandle);

    void flush(FlushResponse flushResponse);

    void getControlSignals(GetControlSignalsResponse getControlSignalsResponse);

    void setControlSignals(SerialHostControlSignals serialHostControlSignals, SetControlSignalsResponse setControlSignalsResponse);

    void configurePort(SerialConnectionOptions serialConnectionOptions, ConfigurePortResponse configurePortResponse);

    void getPortInfo(GetPortInfoResponse getPortInfoResponse);

    void setBreak(SetBreakResponse setBreakResponse);

    void clearBreak(ClearBreakResponse clearBreakResponse);

    void close(CloseResponse closeResponse);
}
