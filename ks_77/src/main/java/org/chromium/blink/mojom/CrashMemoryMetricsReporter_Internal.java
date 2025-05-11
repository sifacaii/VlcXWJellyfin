package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

class CrashMemoryMetricsReporter_Internal {
    public static final Interface.Manager<CrashMemoryMetricsReporter, CrashMemoryMetricsReporter.Proxy> MANAGER = new Interface.Manager<CrashMemoryMetricsReporter, CrashMemoryMetricsReporter.Proxy>() {
        public String getName() {
            return "blink.mojom.CrashMemoryMetricsReporter";
        }

        public int getVersion() {
            return 0;
        }

        public CrashMemoryMetricsReporter_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CrashMemoryMetricsReporter_Internal.Proxy(core, messageReceiver);
        }

        public CrashMemoryMetricsReporter_Internal.Stub buildStub(Core core, CrashMemoryMetricsReporter impl) {
            return new CrashMemoryMetricsReporter_Internal.Stub(core, impl);
        }

        public CrashMemoryMetricsReporter[] buildArray(int size) {
            return new CrashMemoryMetricsReporter[size];
        }
    };

    private static final int SET_SHARED_MEMORY_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements CrashMemoryMetricsReporter.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setSharedMemory(UnsafeSharedMemoryRegion sharedMetricsBuffer) {
            CrashMemoryMetricsReporter_Internal.CrashMemoryMetricsReporterSetSharedMemoryParams _message = new CrashMemoryMetricsReporter_Internal.CrashMemoryMetricsReporterSetSharedMemoryParams();
            _message.sharedMetricsBuffer = sharedMetricsBuffer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<CrashMemoryMetricsReporter> {
        Stub(Core core, CrashMemoryMetricsReporter impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                CrashMemoryMetricsReporter_Internal.CrashMemoryMetricsReporterSetSharedMemoryParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CrashMemoryMetricsReporter_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = CrashMemoryMetricsReporter_Internal.CrashMemoryMetricsReporterSetSharedMemoryParams.deserialize(messageWithHeader.getPayload());
                        ((CrashMemoryMetricsReporter)getImpl()).setSharedMemory(data.sharedMetricsBuffer);
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), CrashMemoryMetricsReporter_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CrashMemoryMetricsReporterSetSharedMemoryParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UnsafeSharedMemoryRegion sharedMetricsBuffer;

        private CrashMemoryMetricsReporterSetSharedMemoryParams(int version) {
            super(16, version);
        }

        public CrashMemoryMetricsReporterSetSharedMemoryParams() {
            this(0);
        }

        public static CrashMemoryMetricsReporterSetSharedMemoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CrashMemoryMetricsReporterSetSharedMemoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CrashMemoryMetricsReporterSetSharedMemoryParams decode(Decoder decoder0) {
            CrashMemoryMetricsReporterSetSharedMemoryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CrashMemoryMetricsReporterSetSharedMemoryParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.sharedMetricsBuffer = UnsafeSharedMemoryRegion.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.sharedMetricsBuffer, 8, false);
        }
    }
}
