package org.chromium.network.mojom;

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
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;
import org.chromium.network.mojom.UdpSocket;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal.class */
class UdpSocket_Internal {
    public static final Interface.Manager<UdpSocket, UdpSocket.Proxy> MANAGER = new Interface.Manager<UdpSocket, UdpSocket.Proxy>() { // from class: org.chromium.network.mojom.UdpSocket_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.UDPSocket";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public UdpSocket.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, UdpSocket impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public UdpSocket[] buildArray(int size) {
            return new UdpSocket[size];
        }
    };
    private static final int BIND_ORDINAL = 0;
    private static final int CONNECT_ORDINAL = 1;
    private static final int SET_BROADCAST_ORDINAL = 2;
    private static final int SET_SEND_BUFFER_SIZE_ORDINAL = 3;
    private static final int SET_RECEIVE_BUFFER_SIZE_ORDINAL = 4;
    private static final int JOIN_GROUP_ORDINAL = 5;
    private static final int LEAVE_GROUP_ORDINAL = 6;
    private static final int RECEIVE_MORE_ORDINAL = 7;
    private static final int RECEIVE_MORE_WITH_BUFFER_SIZE_ORDINAL = 8;
    private static final int SEND_TO_ORDINAL = 9;
    private static final int SEND_ORDINAL = 10;
    private static final int CLOSE_ORDINAL = 11;

    UdpSocket_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements UdpSocket.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void bind(IpEndPoint localAddr, UdpSocketOptions socketOptions, UdpSocket.BindResponse callback) {
            UdpSocketBindParams _message = new UdpSocketBindParams();
            _message.localAddr = localAddr;
            _message.socketOptions = socketOptions;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new UdpSocketBindResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void connect(IpEndPoint remoteAddr, UdpSocketOptions socketOptions, UdpSocket.ConnectResponse callback) {
            UdpSocketConnectParams _message = new UdpSocketConnectParams();
            _message.remoteAddr = remoteAddr;
            _message.socketOptions = socketOptions;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new UdpSocketConnectResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void setBroadcast(boolean broadcast, UdpSocket.SetBroadcastResponse callback) {
            UdpSocketSetBroadcastParams _message = new UdpSocketSetBroadcastParams();
            _message.broadcast = broadcast;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new UdpSocketSetBroadcastResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void setSendBufferSize(int sendBufferSize, UdpSocket.SetSendBufferSizeResponse callback) {
            UdpSocketSetSendBufferSizeParams _message = new UdpSocketSetSendBufferSizeParams();
            _message.sendBufferSize = sendBufferSize;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new UdpSocketSetSendBufferSizeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void setReceiveBufferSize(int receiveBufferSize, UdpSocket.SetReceiveBufferSizeResponse callback) {
            UdpSocketSetReceiveBufferSizeParams _message = new UdpSocketSetReceiveBufferSizeParams();
            _message.receiveBufferSize = receiveBufferSize;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new UdpSocketSetReceiveBufferSizeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void joinGroup(IpAddress groupAddress, UdpSocket.JoinGroupResponse callback) {
            UdpSocketJoinGroupParams _message = new UdpSocketJoinGroupParams();
            _message.groupAddress = groupAddress;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new UdpSocketJoinGroupResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void leaveGroup(IpAddress groupAddress, UdpSocket.LeaveGroupResponse callback) {
            UdpSocketLeaveGroupParams _message = new UdpSocketLeaveGroupParams();
            _message.groupAddress = groupAddress;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new UdpSocketLeaveGroupResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void receiveMore(int numAdditionalDatagrams) {
            UdpSocketReceiveMoreParams _message = new UdpSocketReceiveMoreParams();
            _message.numAdditionalDatagrams = numAdditionalDatagrams;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void receiveMoreWithBufferSize(int numAdditionalDatagrams, int bufferSize) {
            UdpSocketReceiveMoreWithBufferSizeParams _message = new UdpSocketReceiveMoreWithBufferSizeParams();
            _message.numAdditionalDatagrams = numAdditionalDatagrams;
            _message.bufferSize = bufferSize;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void sendTo(IpEndPoint destAddr, ReadOnlyBuffer data, MutableNetworkTrafficAnnotationTag trafficAnnotation, UdpSocket.SendToResponse callback) {
            UdpSocketSendToParams _message = new UdpSocketSendToParams();
            _message.destAddr = destAddr;
            _message.data = data;
            _message.trafficAnnotation = trafficAnnotation;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)), new UdpSocketSendToResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.UdpSocket
        public void send(ReadOnlyBuffer data, MutableNetworkTrafficAnnotationTag trafficAnnotation, UdpSocket.SendResponse callback) {
            UdpSocketSendParams _message = new UdpSocketSendParams();
            _message.data = data;
            _message.trafficAnnotation = trafficAnnotation;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)), new UdpSocketSendResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.mojo.bindings.Interface.AbstractProxy, org.chromium.mojo.bindings.Interface, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            UdpSocketCloseParams _message = new UdpSocketCloseParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<UdpSocket> {
        Stub(Core core, UdpSocket impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UdpSocket_Internal.MANAGER, messageWithHeader);
                    case 7:
                        getImpl().receiveMore(UdpSocketReceiveMoreParams.deserialize(messageWithHeader.getPayload()).numAdditionalDatagrams);
                        return true;
                    case 8:
                        UdpSocketReceiveMoreWithBufferSizeParams data = UdpSocketReceiveMoreWithBufferSizeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().receiveMoreWithBufferSize(data.numAdditionalDatagrams, data.bufferSize);
                        return true;
                    case 11:
                        UdpSocketCloseParams.deserialize(messageWithHeader.getPayload());
                        getImpl().close();
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), UdpSocket_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        UdpSocketBindParams data = UdpSocketBindParams.deserialize(messageWithHeader.getPayload());
                        getImpl().bind(data.localAddr, data.socketOptions, new UdpSocketBindResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        UdpSocketConnectParams data2 = UdpSocketConnectParams.deserialize(messageWithHeader.getPayload());
                        getImpl().connect(data2.remoteAddr, data2.socketOptions, new UdpSocketConnectResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        getImpl().setBroadcast(UdpSocketSetBroadcastParams.deserialize(messageWithHeader.getPayload()).broadcast, new UdpSocketSetBroadcastResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        getImpl().setSendBufferSize(UdpSocketSetSendBufferSizeParams.deserialize(messageWithHeader.getPayload()).sendBufferSize, new UdpSocketSetSendBufferSizeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        getImpl().setReceiveBufferSize(UdpSocketSetReceiveBufferSizeParams.deserialize(messageWithHeader.getPayload()).receiveBufferSize, new UdpSocketSetReceiveBufferSizeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        getImpl().joinGroup(UdpSocketJoinGroupParams.deserialize(messageWithHeader.getPayload()).groupAddress, new UdpSocketJoinGroupResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        getImpl().leaveGroup(UdpSocketLeaveGroupParams.deserialize(messageWithHeader.getPayload()).groupAddress, new UdpSocketLeaveGroupResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                    case 8:
                    default:
                        return false;
                    case 9:
                        UdpSocketSendToParams data3 = UdpSocketSendToParams.deserialize(messageWithHeader.getPayload());
                        getImpl().sendTo(data3.destAddr, data3.data, data3.trafficAnnotation, new UdpSocketSendToResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 10:
                        UdpSocketSendParams data4 = UdpSocketSendParams.deserialize(messageWithHeader.getPayload());
                        getImpl().send(data4.data, data4.trafficAnnotation, new UdpSocketSendResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketBindParams.class */
    static final class UdpSocketBindParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpEndPoint localAddr;
        public UdpSocketOptions socketOptions;

        private UdpSocketBindParams(int version) {
            super(24, version);
        }

        public UdpSocketBindParams() {
            this(0);
        }

        public static UdpSocketBindParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketBindParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketBindParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketBindParams result = new UdpSocketBindParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.localAddr = IpEndPoint.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, true);
                result.socketOptions = UdpSocketOptions.decode(decoder12);
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
            encoder0.encode((Struct) this.localAddr, 8, false);
            encoder0.encode((Struct) this.socketOptions, 16, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketBindResponseParams.class */
    public static final class UdpSocketBindResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public IpEndPoint localAddrOut;

        private UdpSocketBindResponseParams(int version) {
            super(24, version);
        }

        public UdpSocketBindResponseParams() {
            this(0);
        }

        public static UdpSocketBindResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketBindResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketBindResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketBindResponseParams result = new UdpSocketBindResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.localAddrOut = IpEndPoint.decode(decoder1);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Struct) this.localAddrOut, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketBindResponseParamsForwardToCallback.class */
    static class UdpSocketBindResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UdpSocket.BindResponse mCallback;

        UdpSocketBindResponseParamsForwardToCallback(UdpSocket.BindResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                UdpSocketBindResponseParams response = UdpSocketBindResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.localAddrOut);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketBindResponseParamsProxyToResponder.class */
    static class UdpSocketBindResponseParamsProxyToResponder implements UdpSocket.BindResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UdpSocketBindResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer result, IpEndPoint localAddrOut) {
            UdpSocketBindResponseParams _response = new UdpSocketBindResponseParams();
            _response.result = result.intValue();
            _response.localAddrOut = localAddrOut;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketConnectParams.class */
    static final class UdpSocketConnectParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpEndPoint remoteAddr;
        public UdpSocketOptions socketOptions;

        private UdpSocketConnectParams(int version) {
            super(24, version);
        }

        public UdpSocketConnectParams() {
            this(0);
        }

        public static UdpSocketConnectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketConnectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketConnectParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketConnectParams result = new UdpSocketConnectParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.remoteAddr = IpEndPoint.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, true);
                result.socketOptions = UdpSocketOptions.decode(decoder12);
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
            encoder0.encode((Struct) this.remoteAddr, 8, false);
            encoder0.encode((Struct) this.socketOptions, 16, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketConnectResponseParams.class */
    public static final class UdpSocketConnectResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public IpEndPoint localAddrOut;

        private UdpSocketConnectResponseParams(int version) {
            super(24, version);
        }

        public UdpSocketConnectResponseParams() {
            this(0);
        }

        public static UdpSocketConnectResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketConnectResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketConnectResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketConnectResponseParams result = new UdpSocketConnectResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.localAddrOut = IpEndPoint.decode(decoder1);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Struct) this.localAddrOut, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketConnectResponseParamsForwardToCallback.class */
    static class UdpSocketConnectResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UdpSocket.ConnectResponse mCallback;

        UdpSocketConnectResponseParamsForwardToCallback(UdpSocket.ConnectResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                UdpSocketConnectResponseParams response = UdpSocketConnectResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.localAddrOut);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketConnectResponseParamsProxyToResponder.class */
    static class UdpSocketConnectResponseParamsProxyToResponder implements UdpSocket.ConnectResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UdpSocketConnectResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer result, IpEndPoint localAddrOut) {
            UdpSocketConnectResponseParams _response = new UdpSocketConnectResponseParams();
            _response.result = result.intValue();
            _response.localAddrOut = localAddrOut;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetBroadcastParams.class */
    static final class UdpSocketSetBroadcastParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean broadcast;

        private UdpSocketSetBroadcastParams(int version) {
            super(16, version);
        }

        public UdpSocketSetBroadcastParams() {
            this(0);
        }

        public static UdpSocketSetBroadcastParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSetBroadcastParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSetBroadcastParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSetBroadcastParams result = new UdpSocketSetBroadcastParams(elementsOrVersion);
                result.broadcast = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.broadcast, 8, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetBroadcastResponseParams.class */
    public static final class UdpSocketSetBroadcastResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private UdpSocketSetBroadcastResponseParams(int version) {
            super(16, version);
        }

        public UdpSocketSetBroadcastResponseParams() {
            this(0);
        }

        public static UdpSocketSetBroadcastResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSetBroadcastResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSetBroadcastResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSetBroadcastResponseParams result = new UdpSocketSetBroadcastResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
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
            encoder0.encode(this.result, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetBroadcastResponseParamsForwardToCallback.class */
    static class UdpSocketSetBroadcastResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UdpSocket.SetBroadcastResponse mCallback;

        UdpSocketSetBroadcastResponseParamsForwardToCallback(UdpSocket.SetBroadcastResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2)) {
                    return false;
                }
                UdpSocketSetBroadcastResponseParams response = UdpSocketSetBroadcastResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetBroadcastResponseParamsProxyToResponder.class */
    static class UdpSocketSetBroadcastResponseParamsProxyToResponder implements UdpSocket.SetBroadcastResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UdpSocketSetBroadcastResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer result) {
            UdpSocketSetBroadcastResponseParams _response = new UdpSocketSetBroadcastResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetSendBufferSizeParams.class */
    static final class UdpSocketSetSendBufferSizeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int sendBufferSize;

        private UdpSocketSetSendBufferSizeParams(int version) {
            super(16, version);
        }

        public UdpSocketSetSendBufferSizeParams() {
            this(0);
        }

        public static UdpSocketSetSendBufferSizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSetSendBufferSizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSetSendBufferSizeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSetSendBufferSizeParams result = new UdpSocketSetSendBufferSizeParams(elementsOrVersion);
                result.sendBufferSize = decoder0.readInt(8);
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
            encoder0.encode(this.sendBufferSize, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetSendBufferSizeResponseParams.class */
    public static final class UdpSocketSetSendBufferSizeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private UdpSocketSetSendBufferSizeResponseParams(int version) {
            super(16, version);
        }

        public UdpSocketSetSendBufferSizeResponseParams() {
            this(0);
        }

        public static UdpSocketSetSendBufferSizeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSetSendBufferSizeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSetSendBufferSizeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSetSendBufferSizeResponseParams result = new UdpSocketSetSendBufferSizeResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
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
            encoder0.encode(this.result, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetSendBufferSizeResponseParamsForwardToCallback.class */
    static class UdpSocketSetSendBufferSizeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UdpSocket.SetSendBufferSizeResponse mCallback;

        UdpSocketSetSendBufferSizeResponseParamsForwardToCallback(UdpSocket.SetSendBufferSizeResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2)) {
                    return false;
                }
                UdpSocketSetSendBufferSizeResponseParams response = UdpSocketSetSendBufferSizeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetSendBufferSizeResponseParamsProxyToResponder.class */
    static class UdpSocketSetSendBufferSizeResponseParamsProxyToResponder implements UdpSocket.SetSendBufferSizeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UdpSocketSetSendBufferSizeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer result) {
            UdpSocketSetSendBufferSizeResponseParams _response = new UdpSocketSetSendBufferSizeResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetReceiveBufferSizeParams.class */
    static final class UdpSocketSetReceiveBufferSizeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int receiveBufferSize;

        private UdpSocketSetReceiveBufferSizeParams(int version) {
            super(16, version);
        }

        public UdpSocketSetReceiveBufferSizeParams() {
            this(0);
        }

        public static UdpSocketSetReceiveBufferSizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSetReceiveBufferSizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSetReceiveBufferSizeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSetReceiveBufferSizeParams result = new UdpSocketSetReceiveBufferSizeParams(elementsOrVersion);
                result.receiveBufferSize = decoder0.readInt(8);
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
            encoder0.encode(this.receiveBufferSize, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetReceiveBufferSizeResponseParams.class */
    public static final class UdpSocketSetReceiveBufferSizeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private UdpSocketSetReceiveBufferSizeResponseParams(int version) {
            super(16, version);
        }

        public UdpSocketSetReceiveBufferSizeResponseParams() {
            this(0);
        }

        public static UdpSocketSetReceiveBufferSizeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSetReceiveBufferSizeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSetReceiveBufferSizeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSetReceiveBufferSizeResponseParams result = new UdpSocketSetReceiveBufferSizeResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
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
            encoder0.encode(this.result, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetReceiveBufferSizeResponseParamsForwardToCallback.class */
    static class UdpSocketSetReceiveBufferSizeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UdpSocket.SetReceiveBufferSizeResponse mCallback;

        UdpSocketSetReceiveBufferSizeResponseParamsForwardToCallback(UdpSocket.SetReceiveBufferSizeResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2)) {
                    return false;
                }
                UdpSocketSetReceiveBufferSizeResponseParams response = UdpSocketSetReceiveBufferSizeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSetReceiveBufferSizeResponseParamsProxyToResponder.class */
    static class UdpSocketSetReceiveBufferSizeResponseParamsProxyToResponder implements UdpSocket.SetReceiveBufferSizeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UdpSocketSetReceiveBufferSizeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer result) {
            UdpSocketSetReceiveBufferSizeResponseParams _response = new UdpSocketSetReceiveBufferSizeResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketJoinGroupParams.class */
    static final class UdpSocketJoinGroupParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpAddress groupAddress;

        private UdpSocketJoinGroupParams(int version) {
            super(16, version);
        }

        public UdpSocketJoinGroupParams() {
            this(0);
        }

        public static UdpSocketJoinGroupParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketJoinGroupParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketJoinGroupParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketJoinGroupParams result = new UdpSocketJoinGroupParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.groupAddress = IpAddress.decode(decoder1);
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
            encoder0.encode((Struct) this.groupAddress, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketJoinGroupResponseParams.class */
    public static final class UdpSocketJoinGroupResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private UdpSocketJoinGroupResponseParams(int version) {
            super(16, version);
        }

        public UdpSocketJoinGroupResponseParams() {
            this(0);
        }

        public static UdpSocketJoinGroupResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketJoinGroupResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketJoinGroupResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketJoinGroupResponseParams result = new UdpSocketJoinGroupResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
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
            encoder0.encode(this.result, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketJoinGroupResponseParamsForwardToCallback.class */
    static class UdpSocketJoinGroupResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UdpSocket.JoinGroupResponse mCallback;

        UdpSocketJoinGroupResponseParamsForwardToCallback(UdpSocket.JoinGroupResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2)) {
                    return false;
                }
                UdpSocketJoinGroupResponseParams response = UdpSocketJoinGroupResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketJoinGroupResponseParamsProxyToResponder.class */
    static class UdpSocketJoinGroupResponseParamsProxyToResponder implements UdpSocket.JoinGroupResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UdpSocketJoinGroupResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer result) {
            UdpSocketJoinGroupResponseParams _response = new UdpSocketJoinGroupResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketLeaveGroupParams.class */
    static final class UdpSocketLeaveGroupParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpAddress groupAddress;

        private UdpSocketLeaveGroupParams(int version) {
            super(16, version);
        }

        public UdpSocketLeaveGroupParams() {
            this(0);
        }

        public static UdpSocketLeaveGroupParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketLeaveGroupParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketLeaveGroupParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketLeaveGroupParams result = new UdpSocketLeaveGroupParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.groupAddress = IpAddress.decode(decoder1);
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
            encoder0.encode((Struct) this.groupAddress, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketLeaveGroupResponseParams.class */
    public static final class UdpSocketLeaveGroupResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private UdpSocketLeaveGroupResponseParams(int version) {
            super(16, version);
        }

        public UdpSocketLeaveGroupResponseParams() {
            this(0);
        }

        public static UdpSocketLeaveGroupResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketLeaveGroupResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketLeaveGroupResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketLeaveGroupResponseParams result = new UdpSocketLeaveGroupResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
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
            encoder0.encode(this.result, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketLeaveGroupResponseParamsForwardToCallback.class */
    static class UdpSocketLeaveGroupResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UdpSocket.LeaveGroupResponse mCallback;

        UdpSocketLeaveGroupResponseParamsForwardToCallback(UdpSocket.LeaveGroupResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2)) {
                    return false;
                }
                UdpSocketLeaveGroupResponseParams response = UdpSocketLeaveGroupResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketLeaveGroupResponseParamsProxyToResponder.class */
    static class UdpSocketLeaveGroupResponseParamsProxyToResponder implements UdpSocket.LeaveGroupResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UdpSocketLeaveGroupResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer result) {
            UdpSocketLeaveGroupResponseParams _response = new UdpSocketLeaveGroupResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketReceiveMoreParams.class */
    static final class UdpSocketReceiveMoreParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int numAdditionalDatagrams;

        private UdpSocketReceiveMoreParams(int version) {
            super(16, version);
        }

        public UdpSocketReceiveMoreParams() {
            this(0);
        }

        public static UdpSocketReceiveMoreParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketReceiveMoreParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketReceiveMoreParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketReceiveMoreParams result = new UdpSocketReceiveMoreParams(elementsOrVersion);
                result.numAdditionalDatagrams = decoder0.readInt(8);
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
            encoder0.encode(this.numAdditionalDatagrams, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketReceiveMoreWithBufferSizeParams.class */
    static final class UdpSocketReceiveMoreWithBufferSizeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int numAdditionalDatagrams;
        public int bufferSize;

        private UdpSocketReceiveMoreWithBufferSizeParams(int version) {
            super(16, version);
        }

        public UdpSocketReceiveMoreWithBufferSizeParams() {
            this(0);
        }

        public static UdpSocketReceiveMoreWithBufferSizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketReceiveMoreWithBufferSizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketReceiveMoreWithBufferSizeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketReceiveMoreWithBufferSizeParams result = new UdpSocketReceiveMoreWithBufferSizeParams(elementsOrVersion);
                result.numAdditionalDatagrams = decoder0.readInt(8);
                result.bufferSize = decoder0.readInt(12);
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
            encoder0.encode(this.numAdditionalDatagrams, 8);
            encoder0.encode(this.bufferSize, 12);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSendToParams.class */
    static final class UdpSocketSendToParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpEndPoint destAddr;
        public ReadOnlyBuffer data;
        public MutableNetworkTrafficAnnotationTag trafficAnnotation;

        private UdpSocketSendToParams(int version) {
            super(32, version);
        }

        public UdpSocketSendToParams() {
            this(0);
        }

        public static UdpSocketSendToParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSendToParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSendToParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSendToParams result = new UdpSocketSendToParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.destAddr = IpEndPoint.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.data = ReadOnlyBuffer.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(24, false);
                result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder13);
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
            encoder0.encode((Struct) this.destAddr, 8, false);
            encoder0.encode((Struct) this.data, 16, false);
            encoder0.encode((Struct) this.trafficAnnotation, 24, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSendToResponseParams.class */
    public static final class UdpSocketSendToResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private UdpSocketSendToResponseParams(int version) {
            super(16, version);
        }

        public UdpSocketSendToResponseParams() {
            this(0);
        }

        public static UdpSocketSendToResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSendToResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSendToResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSendToResponseParams result = new UdpSocketSendToResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
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
            encoder0.encode(this.result, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSendToResponseParamsForwardToCallback.class */
    static class UdpSocketSendToResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UdpSocket.SendToResponse mCallback;

        UdpSocketSendToResponseParamsForwardToCallback(UdpSocket.SendToResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(9, 2)) {
                    return false;
                }
                UdpSocketSendToResponseParams response = UdpSocketSendToResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSendToResponseParamsProxyToResponder.class */
    static class UdpSocketSendToResponseParamsProxyToResponder implements UdpSocket.SendToResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UdpSocketSendToResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer result) {
            UdpSocketSendToResponseParams _response = new UdpSocketSendToResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSendParams.class */
    static final class UdpSocketSendParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ReadOnlyBuffer data;
        public MutableNetworkTrafficAnnotationTag trafficAnnotation;

        private UdpSocketSendParams(int version) {
            super(24, version);
        }

        public UdpSocketSendParams() {
            this(0);
        }

        public static UdpSocketSendParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSendParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSendParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSendParams result = new UdpSocketSendParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.data = ReadOnlyBuffer.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
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
            encoder0.encode((Struct) this.data, 8, false);
            encoder0.encode((Struct) this.trafficAnnotation, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSendResponseParams.class */
    public static final class UdpSocketSendResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private UdpSocketSendResponseParams(int version) {
            super(16, version);
        }

        public UdpSocketSendResponseParams() {
            this(0);
        }

        public static UdpSocketSendResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketSendResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketSendResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketSendResponseParams result = new UdpSocketSendResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
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
            encoder0.encode(this.result, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSendResponseParamsForwardToCallback.class */
    static class UdpSocketSendResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UdpSocket.SendResponse mCallback;

        UdpSocketSendResponseParamsForwardToCallback(UdpSocket.SendResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(10, 2)) {
                    return false;
                }
                UdpSocketSendResponseParams response = UdpSocketSendResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketSendResponseParamsProxyToResponder.class */
    static class UdpSocketSendResponseParamsProxyToResponder implements UdpSocket.SendResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UdpSocketSendResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer result) {
            UdpSocketSendResponseParams _response = new UdpSocketSendResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket_Internal$UdpSocketCloseParams.class */
    static final class UdpSocketCloseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UdpSocketCloseParams(int version) {
            super(8, version);
        }

        public UdpSocketCloseParams() {
            this(0);
        }

        public static UdpSocketCloseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketCloseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketCloseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketCloseParams result = new UdpSocketCloseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
