package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothDeviceInfo.class */
public final class BluetoothDeviceInfo extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public BluetoothAddress address;
    public String name;
    public int connectionState;
    public boolean isPaired;
    public int deviceType;
    public BluetoothDeviceBatteryInfo batteryInfo;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothDeviceInfo$ConnectionState.class */
    public static final class ConnectionState {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int NOT_CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNECTED = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private ConnectionState() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothDeviceInfo$DeviceType.class */
    public static final class DeviceType {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int UNKNOWN = 0;
        public static final int COMPUTER = 1;
        public static final int PHONE = 2;
        public static final int MODEM = 3;
        public static final int AUDIO = 4;
        public static final int CAR_AUDIO = 5;
        public static final int VIDEO = 6;
        public static final int PERIPHERAL = 7;
        public static final int JOYSTICK = 8;
        public static final int GAMEPAD = 9;
        public static final int KEYBOARD = 10;
        public static final int MOUSE = 11;
        public static final int TABLET = 12;
        public static final int KEYBOARD_MOUSE_COMBO = 13;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 13;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private DeviceType() {
        }
    }

    private BluetoothDeviceInfo(int version) {
        super(48, version);
    }

    public BluetoothDeviceInfo() {
        this(0);
    }

    public static BluetoothDeviceInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BluetoothDeviceInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BluetoothDeviceInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BluetoothDeviceInfo result = new BluetoothDeviceInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.address = BluetoothAddress.decode(decoder1);
            result.name = decoder0.readString(16, true);
            result.connectionState = decoder0.readInt(24);
            ConnectionState.validate(result.connectionState);
            result.isPaired = decoder0.readBoolean(28, 0);
            result.deviceType = decoder0.readInt(32);
            DeviceType.validate(result.deviceType);
            Decoder decoder12 = decoder0.readPointer(40, true);
            result.batteryInfo = BluetoothDeviceBatteryInfo.decode(decoder12);
            decoder0.decreaseStackDepth();
            return result;
        } catch (Throwable th) {
            decoder0.decreaseStackDepth();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode((Struct) this.address, 8, false);
        encoder0.encode(this.name, 16, true);
        encoder0.encode(this.connectionState, 24);
        encoder0.encode(this.isPaired, 28, 0);
        encoder0.encode(this.deviceType, 32);
        encoder0.encode((Struct) this.batteryInfo, 40, true);
    }
}
