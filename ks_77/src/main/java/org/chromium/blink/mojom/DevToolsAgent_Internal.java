package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class DevToolsAgent_Internal {
    public static final Interface.Manager<DevToolsAgent, DevToolsAgent.Proxy> MANAGER = new Interface.Manager<DevToolsAgent, DevToolsAgent.Proxy>() {
        public String getName() {
            return "blink.mojom.DevToolsAgent";
        }

        public int getVersion() {
            return 0;
        }

        public DevToolsAgent_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DevToolsAgent_Internal.Proxy(core, messageReceiver);
        }

        public DevToolsAgent_Internal.Stub buildStub(Core core, DevToolsAgent impl) {
            return new DevToolsAgent_Internal.Stub(core, impl);
        }

        public DevToolsAgent[] buildArray(int size) {
            return new DevToolsAgent[size];
        }
    };

    private static final int ATTACH_DEV_TOOLS_SESSION_ORDINAL = 0;

    private static final int INSPECT_ELEMENT_ORDINAL = 1;

    private static final int REPORT_CHILD_WORKERS_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements DevToolsAgent.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void attachDevToolsSession(AssociatedInterfaceNotSupported host, AssociatedInterfaceRequestNotSupported session, InterfaceRequest<DevToolsSession> ioSession, DevToolsSessionState reattachSessionState, boolean clientExpectsBinaryResponses) {
            DevToolsAgent_Internal.DevToolsAgentAttachDevToolsSessionParams _message = new DevToolsAgent_Internal.DevToolsAgentAttachDevToolsSessionParams();
            _message.host = host;
            _message.session = session;
            _message.ioSession = ioSession;
            _message.reattachSessionState = reattachSessionState;
            _message.clientExpectsBinaryResponses = clientExpectsBinaryResponses;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void inspectElement(Point point) {
            DevToolsAgent_Internal.DevToolsAgentInspectElementParams _message = new DevToolsAgent_Internal.DevToolsAgentInspectElementParams();
            _message.point = point;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void reportChildWorkers(boolean report, boolean waitForDebugger, DevToolsAgent.ReportChildWorkersResponse callback) {
            DevToolsAgent_Internal.DevToolsAgentReportChildWorkersParams _message = new DevToolsAgent_Internal.DevToolsAgentReportChildWorkersParams();
            _message.report = report;
            _message.waitForDebugger = waitForDebugger;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new DevToolsAgent_Internal.DevToolsAgentReportChildWorkersResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<DevToolsAgent> {
        Stub(Core core, DevToolsAgent impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DevToolsAgent_Internal.DevToolsAgentAttachDevToolsSessionParams devToolsAgentAttachDevToolsSessionParams;
                DevToolsAgent_Internal.DevToolsAgentInspectElementParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DevToolsAgent_Internal.MANAGER, messageWithHeader);
                    case 0:
                        devToolsAgentAttachDevToolsSessionParams = DevToolsAgent_Internal.DevToolsAgentAttachDevToolsSessionParams.deserialize(messageWithHeader.getPayload());
                        ((DevToolsAgent)getImpl()).attachDevToolsSession(devToolsAgentAttachDevToolsSessionParams.host, devToolsAgentAttachDevToolsSessionParams.session, devToolsAgentAttachDevToolsSessionParams.ioSession, devToolsAgentAttachDevToolsSessionParams.reattachSessionState, devToolsAgentAttachDevToolsSessionParams.clientExpectsBinaryResponses);
                        return true;
                    case 1:
                        data = DevToolsAgent_Internal.DevToolsAgentInspectElementParams.deserialize(messageWithHeader.getPayload());
                        ((DevToolsAgent)getImpl()).inspectElement(data.point);
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
                DevToolsAgent_Internal.DevToolsAgentReportChildWorkersParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), DevToolsAgent_Internal.MANAGER, messageWithHeader, receiver);
                    case 2:
                        data = DevToolsAgent_Internal.DevToolsAgentReportChildWorkersParams.deserialize(messageWithHeader.getPayload());
                        ((DevToolsAgent)getImpl()).reportChildWorkers(data.report, data.waitForDebugger, new DevToolsAgent_Internal.DevToolsAgentReportChildWorkersResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DevToolsAgentAttachDevToolsSessionParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported host;

        public AssociatedInterfaceRequestNotSupported session;

        public InterfaceRequest<DevToolsSession> ioSession;

        public DevToolsSessionState reattachSessionState;

        public boolean clientExpectsBinaryResponses;

        private DevToolsAgentAttachDevToolsSessionParams(int version) {
            super(40, version);
        }

        public DevToolsAgentAttachDevToolsSessionParams() {
            this(0);
        }

        public static DevToolsAgentAttachDevToolsSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsAgentAttachDevToolsSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsAgentAttachDevToolsSessionParams decode(Decoder decoder0) {
            DevToolsAgentAttachDevToolsSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DevToolsAgentAttachDevToolsSessionParams(elementsOrVersion);
                result.host = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
                result.session = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
                result.ioSession = decoder0.readInterfaceRequest(20, false);
                Decoder decoder1 = decoder0.readPointer(24, true);
                result.reattachSessionState = DevToolsSessionState.decode(decoder1);
                result.clientExpectsBinaryResponses = decoder0.readBoolean(32, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.host, 8, false);
            encoder0.encode(this.session, 16, false);
            encoder0.encode(this.ioSession, 20, false);
            encoder0.encode(this.reattachSessionState, 24, true);
            encoder0.encode(this.clientExpectsBinaryResponses, 32, 0);
        }
    }

    static final class DevToolsAgentInspectElementParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Point point;

        private DevToolsAgentInspectElementParams(int version) {
            super(16, version);
        }

        public DevToolsAgentInspectElementParams() {
            this(0);
        }

        public static DevToolsAgentInspectElementParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsAgentInspectElementParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsAgentInspectElementParams decode(Decoder decoder0) {
            DevToolsAgentInspectElementParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DevToolsAgentInspectElementParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.point = Point.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.point, 8, false);
        }
    }

    static final class DevToolsAgentReportChildWorkersParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean report;

        public boolean waitForDebugger;

        private DevToolsAgentReportChildWorkersParams(int version) {
            super(16, version);
        }

        public DevToolsAgentReportChildWorkersParams() {
            this(0);
        }

        public static DevToolsAgentReportChildWorkersParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsAgentReportChildWorkersParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsAgentReportChildWorkersParams decode(Decoder decoder0) {
            DevToolsAgentReportChildWorkersParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DevToolsAgentReportChildWorkersParams(elementsOrVersion);
                result.report = decoder0.readBoolean(8, 0);
                result.waitForDebugger = decoder0.readBoolean(8, 1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.report, 8, 0);
            encoder0.encode(this.waitForDebugger, 8, 1);
        }
    }

    static final class DevToolsAgentReportChildWorkersResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DevToolsAgentReportChildWorkersResponseParams(int version) {
            super(8, version);
        }

        public DevToolsAgentReportChildWorkersResponseParams() {
            this(0);
        }

        public static DevToolsAgentReportChildWorkersResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsAgentReportChildWorkersResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsAgentReportChildWorkersResponseParams decode(Decoder decoder0) {
            DevToolsAgentReportChildWorkersResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DevToolsAgentReportChildWorkersResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class DevToolsAgentReportChildWorkersResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final DevToolsAgent.ReportChildWorkersResponse mCallback;

        DevToolsAgentReportChildWorkersResponseParamsForwardToCallback(DevToolsAgent.ReportChildWorkersResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class DevToolsAgentReportChildWorkersResponseParamsProxyToResponder implements DevToolsAgent.ReportChildWorkersResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        DevToolsAgentReportChildWorkersResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            DevToolsAgent_Internal.DevToolsAgentReportChildWorkersResponseParams _response = new DevToolsAgent_Internal.DevToolsAgentReportChildWorkersResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
