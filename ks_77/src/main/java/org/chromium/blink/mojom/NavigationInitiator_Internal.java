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

class NavigationInitiator_Internal {
    public static final Interface.Manager<NavigationInitiator, NavigationInitiator.Proxy> MANAGER = new Interface.Manager<NavigationInitiator, NavigationInitiator.Proxy>() {
        public String getName() {
            return "blink.mojom.NavigationInitiator";
        }

        public int getVersion() {
            return 0;
        }

        public NavigationInitiator_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NavigationInitiator_Internal.Proxy(core, messageReceiver);
        }

        public NavigationInitiator_Internal.Stub buildStub(Core core, NavigationInitiator impl) {
            return new NavigationInitiator_Internal.Stub(core, impl);
        }

        public NavigationInitiator[] buildArray(int size) {
            return new NavigationInitiator[size];
        }
    };

    private static final int SEND_VIOLATION_REPORT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements NavigationInitiator.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void sendViolationReport(CspViolationParams violationParams) {
            NavigationInitiator_Internal.NavigationInitiatorSendViolationReportParams _message = new NavigationInitiator_Internal.NavigationInitiatorSendViolationReportParams();
            _message.violationParams = violationParams;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<NavigationInitiator> {
        Stub(Core core, NavigationInitiator impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                NavigationInitiator_Internal.NavigationInitiatorSendViolationReportParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NavigationInitiator_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = NavigationInitiator_Internal.NavigationInitiatorSendViolationReportParams.deserialize(messageWithHeader.getPayload());
                        ((NavigationInitiator)getImpl()).sendViolationReport(data.violationParams);
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
                                getCore(), NavigationInitiator_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NavigationInitiatorSendViolationReportParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CspViolationParams violationParams;

        private NavigationInitiatorSendViolationReportParams(int version) {
            super(16, version);
        }

        public NavigationInitiatorSendViolationReportParams() {
            this(0);
        }

        public static NavigationInitiatorSendViolationReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NavigationInitiatorSendViolationReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NavigationInitiatorSendViolationReportParams decode(Decoder decoder0) {
            NavigationInitiatorSendViolationReportParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NavigationInitiatorSendViolationReportParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.violationParams = CspViolationParams.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.violationParams, 8, false);
        }
    }
}
