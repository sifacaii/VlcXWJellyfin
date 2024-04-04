package org.chromium.device.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class HidConnection_Internal {
    public static final Interface.Manager<HidConnection, HidConnection.Proxy> MANAGER = new Interface.Manager<HidConnection, HidConnection.Proxy>() {
        public String getName() {
            return "device.mojom.HidConnection";
        }

        public int getVersion() {
            return 0;
        }

        public HidConnection_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new HidConnection_Internal.Proxy(core, messageReceiver);
        }

        public HidConnection_Internal.Stub buildStub(Core core, HidConnection impl) {
            return new HidConnection_Internal.Stub(core, impl);
        }

        public HidConnection[] buildArray(int size) {
            return new HidConnection[size];
        }
    };

    private static final int READ_ORDINAL = 0;

    private static final int WRITE_ORDINAL = 1;

    private static final int GET_FEATURE_REPORT_ORDINAL = 2;

    private static final int SEND_FEATURE_REPORT_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements HidConnection.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void read(HidConnection.ReadResponse callback) {
            HidConnection_Internal.HidConnectionReadParams _message = new HidConnection_Internal.HidConnectionReadParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new HidConnection_Internal.HidConnectionReadResponseParamsForwardToCallback(callback));
        }

        public void write(byte reportId, byte[] buffer, HidConnection.WriteResponse callback) {
            HidConnection_Internal.HidConnectionWriteParams _message = new HidConnection_Internal.HidConnectionWriteParams();
            _message.reportId = reportId;
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new HidConnection_Internal.HidConnectionWriteResponseParamsForwardToCallback(callback));
        }

        public void getFeatureReport(byte reportId, HidConnection.GetFeatureReportResponse callback) {
            HidConnection_Internal.HidConnectionGetFeatureReportParams _message = new HidConnection_Internal.HidConnectionGetFeatureReportParams();
            _message.reportId = reportId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new HidConnection_Internal.HidConnectionGetFeatureReportResponseParamsForwardToCallback(callback));
        }

        public void sendFeatureReport(byte reportId, byte[] buffer, HidConnection.SendFeatureReportResponse callback) {
            HidConnection_Internal.HidConnectionSendFeatureReportParams _message = new HidConnection_Internal.HidConnectionSendFeatureReportParams();
            _message.reportId = reportId;
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new HidConnection_Internal.HidConnectionSendFeatureReportResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<HidConnection> {
        Stub(Core core, HidConnection impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(HidConnection_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                HidConnection_Internal.HidConnectionWriteParams hidConnectionWriteParams;
                HidConnection_Internal.HidConnectionGetFeatureReportParams hidConnectionGetFeatureReportParams;
                HidConnection_Internal.HidConnectionSendFeatureReportParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), HidConnection_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        HidConnection_Internal.HidConnectionReadParams.deserialize(messageWithHeader.getPayload());
                        ((HidConnection)getImpl()).read(new HidConnection_Internal.HidConnectionReadResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        hidConnectionWriteParams = HidConnection_Internal.HidConnectionWriteParams.deserialize(messageWithHeader.getPayload());
                        ((HidConnection)getImpl()).write(hidConnectionWriteParams.reportId, hidConnectionWriteParams.buffer, new HidConnection_Internal.HidConnectionWriteResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        hidConnectionGetFeatureReportParams = HidConnection_Internal.HidConnectionGetFeatureReportParams.deserialize(messageWithHeader.getPayload());
                        ((HidConnection)getImpl()).getFeatureReport(hidConnectionGetFeatureReportParams.reportId, new HidConnection_Internal.HidConnectionGetFeatureReportResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        data = HidConnection_Internal.HidConnectionSendFeatureReportParams.deserialize(messageWithHeader.getPayload());
                        ((HidConnection)getImpl()).sendFeatureReport(data.reportId, data.buffer, new HidConnection_Internal.HidConnectionSendFeatureReportResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class HidConnectionReadParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private HidConnectionReadParams(int version) {
            super(8, version);
        }

        public HidConnectionReadParams() {
            this(0);
        }

        public static HidConnectionReadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidConnectionReadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidConnectionReadParams decode(Decoder decoder0) {
            HidConnectionReadParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidConnectionReadParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class HidConnectionReadResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public byte reportId;

        public byte[] buffer;

        private HidConnectionReadResponseParams(int version) {
            super(24, version);
        }

        public HidConnectionReadResponseParams() {
            this(0);
        }

        public static HidConnectionReadResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidConnectionReadResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidConnectionReadResponseParams decode(Decoder decoder0) {
            HidConnectionReadResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidConnectionReadResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                result.reportId = decoder0.readByte(9);
                result.buffer = decoder0.readBytes(16, 1, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.reportId, 9);
            encoder0.encode(this.buffer, 16, 1, -1);
        }
    }

    static class HidConnectionReadResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidConnection.ReadResponse mCallback;

        HidConnectionReadResponseParamsForwardToCallback(HidConnection.ReadResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                HidConnection_Internal.HidConnectionReadResponseParams response = HidConnection_Internal.HidConnectionReadResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), Byte.valueOf(response.reportId), response.buffer);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidConnectionReadResponseParamsProxyToResponder implements HidConnection.ReadResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidConnectionReadResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, Byte reportId, byte[] buffer) {
            HidConnection_Internal.HidConnectionReadResponseParams _response = new HidConnection_Internal.HidConnectionReadResponseParams();
            _response.success = success.booleanValue();
            _response.reportId = reportId.byteValue();
            _response.buffer = buffer;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class HidConnectionWriteParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte reportId;

        public byte[] buffer;

        private HidConnectionWriteParams(int version) {
            super(24, version);
        }

        public HidConnectionWriteParams() {
            this(0);
        }

        public static HidConnectionWriteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidConnectionWriteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidConnectionWriteParams decode(Decoder decoder0) {
            HidConnectionWriteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidConnectionWriteParams(elementsOrVersion);
                result.reportId = decoder0.readByte(8);
                result.buffer = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.reportId, 8);
            encoder0.encode(this.buffer, 16, 0, -1);
        }
    }

    static final class HidConnectionWriteResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private HidConnectionWriteResponseParams(int version) {
            super(16, version);
        }

        public HidConnectionWriteResponseParams() {
            this(0);
        }

        public static HidConnectionWriteResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidConnectionWriteResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidConnectionWriteResponseParams decode(Decoder decoder0) {
            HidConnectionWriteResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidConnectionWriteResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class HidConnectionWriteResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidConnection.WriteResponse mCallback;

        HidConnectionWriteResponseParamsForwardToCallback(HidConnection.WriteResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                HidConnection_Internal.HidConnectionWriteResponseParams response = HidConnection_Internal.HidConnectionWriteResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidConnectionWriteResponseParamsProxyToResponder implements HidConnection.WriteResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidConnectionWriteResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            HidConnection_Internal.HidConnectionWriteResponseParams _response = new HidConnection_Internal.HidConnectionWriteResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class HidConnectionGetFeatureReportParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte reportId;

        private HidConnectionGetFeatureReportParams(int version) {
            super(16, version);
        }

        public HidConnectionGetFeatureReportParams() {
            this(0);
        }

        public static HidConnectionGetFeatureReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidConnectionGetFeatureReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidConnectionGetFeatureReportParams decode(Decoder decoder0) {
            HidConnectionGetFeatureReportParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidConnectionGetFeatureReportParams(elementsOrVersion);
                result.reportId = decoder0.readByte(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.reportId, 8);
        }
    }

    static final class HidConnectionGetFeatureReportResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public byte[] buffer;

        private HidConnectionGetFeatureReportResponseParams(int version) {
            super(24, version);
        }

        public HidConnectionGetFeatureReportResponseParams() {
            this(0);
        }

        public static HidConnectionGetFeatureReportResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidConnectionGetFeatureReportResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidConnectionGetFeatureReportResponseParams decode(Decoder decoder0) {
            HidConnectionGetFeatureReportResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidConnectionGetFeatureReportResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                result.buffer = decoder0.readBytes(16, 1, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.buffer, 16, 1, -1);
        }
    }

    static class HidConnectionGetFeatureReportResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidConnection.GetFeatureReportResponse mCallback;

        HidConnectionGetFeatureReportResponseParamsForwardToCallback(HidConnection.GetFeatureReportResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                HidConnection_Internal.HidConnectionGetFeatureReportResponseParams response = HidConnection_Internal.HidConnectionGetFeatureReportResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), response.buffer);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidConnectionGetFeatureReportResponseParamsProxyToResponder implements HidConnection.GetFeatureReportResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidConnectionGetFeatureReportResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, byte[] buffer) {
            HidConnection_Internal.HidConnectionGetFeatureReportResponseParams _response = new HidConnection_Internal.HidConnectionGetFeatureReportResponseParams();
            _response.success = success.booleanValue();
            _response.buffer = buffer;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class HidConnectionSendFeatureReportParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte reportId;

        public byte[] buffer;

        private HidConnectionSendFeatureReportParams(int version) {
            super(24, version);
        }

        public HidConnectionSendFeatureReportParams() {
            this(0);
        }

        public static HidConnectionSendFeatureReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidConnectionSendFeatureReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidConnectionSendFeatureReportParams decode(Decoder decoder0) {
            HidConnectionSendFeatureReportParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidConnectionSendFeatureReportParams(elementsOrVersion);
                result.reportId = decoder0.readByte(8);
                result.buffer = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.reportId, 8);
            encoder0.encode(this.buffer, 16, 0, -1);
        }
    }

    static final class HidConnectionSendFeatureReportResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private HidConnectionSendFeatureReportResponseParams(int version) {
            super(16, version);
        }

        public HidConnectionSendFeatureReportResponseParams() {
            this(0);
        }

        public static HidConnectionSendFeatureReportResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidConnectionSendFeatureReportResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidConnectionSendFeatureReportResponseParams decode(Decoder decoder0) {
            HidConnectionSendFeatureReportResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidConnectionSendFeatureReportResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class HidConnectionSendFeatureReportResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidConnection.SendFeatureReportResponse mCallback;

        HidConnectionSendFeatureReportResponseParamsForwardToCallback(HidConnection.SendFeatureReportResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                HidConnection_Internal.HidConnectionSendFeatureReportResponseParams response = HidConnection_Internal.HidConnectionSendFeatureReportResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidConnectionSendFeatureReportResponseParamsProxyToResponder implements HidConnection.SendFeatureReportResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidConnectionSendFeatureReportResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            HidConnection_Internal.HidConnectionSendFeatureReportResponseParams _response = new HidConnection_Internal.HidConnectionSendFeatureReportResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
