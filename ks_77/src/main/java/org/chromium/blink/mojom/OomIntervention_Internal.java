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

class OomIntervention_Internal {
    public static final Interface.Manager<OomIntervention, OomIntervention.Proxy> MANAGER = new Interface.Manager<OomIntervention, OomIntervention.Proxy>() {
        public String getName() {
            return "blink.mojom.OomIntervention";
        }

        public int getVersion() {
            return 0;
        }

        public OomIntervention_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new OomIntervention_Internal.Proxy(core, messageReceiver);
        }

        public OomIntervention_Internal.Stub buildStub(Core core, OomIntervention impl) {
            return new OomIntervention_Internal.Stub(core, impl);
        }

        public OomIntervention[] buildArray(int size) {
            return new OomIntervention[size];
        }
    };

    private static final int START_DETECTION_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements OomIntervention.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void startDetection(OomInterventionHost host, DetectionArgs detectionArgs, boolean rendererPauseEnabled, boolean navigateAdsEnabled, boolean purgeV8MemoryEnabled) {
            OomIntervention_Internal.OomInterventionStartDetectionParams _message = new OomIntervention_Internal.OomInterventionStartDetectionParams();
            _message.host = host;
            _message.detectionArgs = detectionArgs;
            _message.rendererPauseEnabled = rendererPauseEnabled;
            _message.navigateAdsEnabled = navigateAdsEnabled;
            _message.purgeV8MemoryEnabled = purgeV8MemoryEnabled;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<OomIntervention> {
        Stub(Core core, OomIntervention impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                OomIntervention_Internal.OomInterventionStartDetectionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(OomIntervention_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = OomIntervention_Internal.OomInterventionStartDetectionParams.deserialize(messageWithHeader.getPayload());
                        ((OomIntervention)getImpl()).startDetection(data.host, data.detectionArgs, data.rendererPauseEnabled, data.navigateAdsEnabled, data.purgeV8MemoryEnabled);
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
                                getCore(), OomIntervention_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class OomInterventionStartDetectionParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public OomInterventionHost host;

        public DetectionArgs detectionArgs;

        public boolean rendererPauseEnabled;

        public boolean navigateAdsEnabled;

        public boolean purgeV8MemoryEnabled;

        private OomInterventionStartDetectionParams(int version) {
            super(32, version);
        }

        public OomInterventionStartDetectionParams() {
            this(0);
        }

        public static OomInterventionStartDetectionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OomInterventionStartDetectionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OomInterventionStartDetectionParams decode(Decoder decoder0) {
            OomInterventionStartDetectionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new OomInterventionStartDetectionParams(elementsOrVersion);
                result.host = (OomInterventionHost)decoder0.readServiceInterface(8, false, OomInterventionHost.MANAGER);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.detectionArgs = DetectionArgs.decode(decoder1);
                result.rendererPauseEnabled = decoder0.readBoolean(24, 0);
                result.navigateAdsEnabled = decoder0.readBoolean(24, 1);
                result.purgeV8MemoryEnabled = decoder0.readBoolean(24, 2);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.host, 8, false, OomInterventionHost.MANAGER);
            encoder0.encode(this.detectionArgs, 16, false);
            encoder0.encode(this.rendererPauseEnabled, 24, 0);
            encoder0.encode(this.navigateAdsEnabled, 24, 1);
            encoder0.encode(this.purgeV8MemoryEnabled, 24, 2);
        }
    }
}
