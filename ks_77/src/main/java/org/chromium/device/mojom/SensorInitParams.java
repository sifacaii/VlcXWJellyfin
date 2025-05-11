package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.SharedBufferHandle;

public final class SensorInitParams extends Struct {
    private static final int STRUCT_SIZE = 64;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(64, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public static final long READ_BUFFER_SIZE_FOR_TESTS = 48L;

    public Sensor sensor;

    public InterfaceRequest<SensorClient> clientRequest;

    public SharedBufferHandle memory;

    public long bufferOffset;

    public int mode;

    public SensorConfiguration defaultConfiguration;

    public double maximumFrequency;

    public double minimumFrequency;

    private SensorInitParams(int version) {
        super(64, version);
        this.memory = (SharedBufferHandle)InvalidHandle.INSTANCE;
    }

    public SensorInitParams() {
        this(0);
    }

    public static SensorInitParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SensorInitParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SensorInitParams decode(Decoder decoder0) {
        SensorInitParams result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new SensorInitParams(elementsOrVersion);
            result.sensor = (Sensor)decoder0.readServiceInterface(8, false, Sensor.MANAGER);
            result.clientRequest = decoder0.readInterfaceRequest(16, false);
            result.memory = decoder0.readSharedBufferHandle(20, false);
            result.bufferOffset = decoder0.readLong(24);
            result.mode = decoder0.readInt(32);
            ReportingMode.validate(result.mode);
            Decoder decoder1 = decoder0.readPointer(40, false);
            result.defaultConfiguration = SensorConfiguration.decode(decoder1);
            result.maximumFrequency = decoder0.readDouble(48);
            result.minimumFrequency = decoder0.readDouble(56);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.sensor, 8, false, Sensor.MANAGER);
        encoder0.encode(this.clientRequest, 16, false);
        encoder0.encode((Handle)this.memory, 20, false);
        encoder0.encode(this.bufferOffset, 24);
        encoder0.encode(this.mode, 32);
        encoder0.encode(this.defaultConfiguration, 40, false);
        encoder0.encode(this.maximumFrequency, 48);
        encoder0.encode(this.minimumFrequency, 56);
    }
}
