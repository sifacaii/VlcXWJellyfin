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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class RemoteObject_Internal {
    public static final Interface.Manager<RemoteObject, RemoteObject.Proxy> MANAGER = new Interface.Manager<RemoteObject, RemoteObject.Proxy>() {
        public String getName() {
            return "blink.mojom.RemoteObject";
        }

        public int getVersion() {
            return 0;
        }

        public RemoteObject_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new RemoteObject_Internal.Proxy(core, messageReceiver);
        }

        public RemoteObject_Internal.Stub buildStub(Core core, RemoteObject impl) {
            return new RemoteObject_Internal.Stub(core, impl);
        }

        public RemoteObject[] buildArray(int size) {
            return new RemoteObject[size];
        }
    };

    private static final int HAS_METHOD_ORDINAL = 0;

    private static final int GET_METHODS_ORDINAL = 1;

    private static final int INVOKE_METHOD_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements RemoteObject.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void hasMethod(String name, RemoteObject.HasMethodResponse callback) {
            RemoteObject_Internal.RemoteObjectHasMethodParams _message = new RemoteObject_Internal.RemoteObjectHasMethodParams();
            _message.name = name;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new RemoteObject_Internal.RemoteObjectHasMethodResponseParamsForwardToCallback(callback));
        }

        public void getMethods(RemoteObject.GetMethodsResponse callback) {
            RemoteObject_Internal.RemoteObjectGetMethodsParams _message = new RemoteObject_Internal.RemoteObjectGetMethodsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new RemoteObject_Internal.RemoteObjectGetMethodsResponseParamsForwardToCallback(callback));
        }

        public void invokeMethod(String name, RemoteInvocationArgument[] arguments, RemoteObject.InvokeMethodResponse callback) {
            RemoteObject_Internal.RemoteObjectInvokeMethodParams _message = new RemoteObject_Internal.RemoteObjectInvokeMethodParams();
            _message.name = name;
            _message.arguments = arguments;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new RemoteObject_Internal.RemoteObjectInvokeMethodResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<RemoteObject> {
        Stub(Core core, RemoteObject impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(RemoteObject_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                RemoteObject_Internal.RemoteObjectHasMethodParams remoteObjectHasMethodParams;
                RemoteObject_Internal.RemoteObjectInvokeMethodParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), RemoteObject_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        remoteObjectHasMethodParams = RemoteObject_Internal.RemoteObjectHasMethodParams.deserialize(messageWithHeader.getPayload());
                        ((RemoteObject)getImpl()).hasMethod(remoteObjectHasMethodParams.name, new RemoteObject_Internal.RemoteObjectHasMethodResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        RemoteObject_Internal.RemoteObjectGetMethodsParams.deserialize(messageWithHeader.getPayload());
                        ((RemoteObject)getImpl()).getMethods(new RemoteObject_Internal.RemoteObjectGetMethodsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = RemoteObject_Internal.RemoteObjectInvokeMethodParams.deserialize(messageWithHeader.getPayload());
                        ((RemoteObject)getImpl()).invokeMethod(data.name, data.arguments, new RemoteObject_Internal.RemoteObjectInvokeMethodResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class RemoteObjectHasMethodParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String name;

        private RemoteObjectHasMethodParams(int version) {
            super(16, version);
        }

        public RemoteObjectHasMethodParams() {
            this(0);
        }

        public static RemoteObjectHasMethodParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RemoteObjectHasMethodParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RemoteObjectHasMethodParams decode(Decoder decoder0) {
            RemoteObjectHasMethodParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RemoteObjectHasMethodParams(elementsOrVersion);
                result.name = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.name, 8, false);
        }
    }

    static final class RemoteObjectHasMethodResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean methodExists;

        private RemoteObjectHasMethodResponseParams(int version) {
            super(16, version);
        }

        public RemoteObjectHasMethodResponseParams() {
            this(0);
        }

        public static RemoteObjectHasMethodResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RemoteObjectHasMethodResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RemoteObjectHasMethodResponseParams decode(Decoder decoder0) {
            RemoteObjectHasMethodResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RemoteObjectHasMethodResponseParams(elementsOrVersion);
                result.methodExists = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.methodExists, 8, 0);
        }
    }

    static class RemoteObjectHasMethodResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final RemoteObject.HasMethodResponse mCallback;

        RemoteObjectHasMethodResponseParamsForwardToCallback(RemoteObject.HasMethodResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                RemoteObject_Internal.RemoteObjectHasMethodResponseParams response = RemoteObject_Internal.RemoteObjectHasMethodResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.methodExists));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class RemoteObjectHasMethodResponseParamsProxyToResponder implements RemoteObject.HasMethodResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        RemoteObjectHasMethodResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean methodExists) {
            RemoteObject_Internal.RemoteObjectHasMethodResponseParams _response = new RemoteObject_Internal.RemoteObjectHasMethodResponseParams();
            _response.methodExists = methodExists.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class RemoteObjectGetMethodsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private RemoteObjectGetMethodsParams(int version) {
            super(8, version);
        }

        public RemoteObjectGetMethodsParams() {
            this(0);
        }

        public static RemoteObjectGetMethodsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RemoteObjectGetMethodsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RemoteObjectGetMethodsParams decode(Decoder decoder0) {
            RemoteObjectGetMethodsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RemoteObjectGetMethodsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class RemoteObjectGetMethodsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String[] methodNames;

        private RemoteObjectGetMethodsResponseParams(int version) {
            super(16, version);
        }

        public RemoteObjectGetMethodsResponseParams() {
            this(0);
        }

        public static RemoteObjectGetMethodsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RemoteObjectGetMethodsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RemoteObjectGetMethodsResponseParams decode(Decoder decoder0) {
            RemoteObjectGetMethodsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RemoteObjectGetMethodsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.methodNames = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++)
                    result.methodNames[i1] = decoder1.readString(8 + 8 * i1, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.methodNames == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.methodNames.length, 8, -1);
                for (int i0 = 0; i0 < this.methodNames.length; i0++)
                    encoder1.encode(this.methodNames[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class RemoteObjectGetMethodsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final RemoteObject.GetMethodsResponse mCallback;

        RemoteObjectGetMethodsResponseParamsForwardToCallback(RemoteObject.GetMethodsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                RemoteObject_Internal.RemoteObjectGetMethodsResponseParams response = RemoteObject_Internal.RemoteObjectGetMethodsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.methodNames);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class RemoteObjectGetMethodsResponseParamsProxyToResponder implements RemoteObject.GetMethodsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        RemoteObjectGetMethodsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String[] methodNames) {
            RemoteObject_Internal.RemoteObjectGetMethodsResponseParams _response = new RemoteObject_Internal.RemoteObjectGetMethodsResponseParams();
            _response.methodNames = methodNames;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class RemoteObjectInvokeMethodParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String name;

        public RemoteInvocationArgument[] arguments;

        private RemoteObjectInvokeMethodParams(int version) {
            super(24, version);
        }

        public RemoteObjectInvokeMethodParams() {
            this(0);
        }

        public static RemoteObjectInvokeMethodParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RemoteObjectInvokeMethodParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RemoteObjectInvokeMethodParams decode(Decoder decoder0) {
            RemoteObjectInvokeMethodParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RemoteObjectInvokeMethodParams(elementsOrVersion);
                result.name = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.arguments = new RemoteInvocationArgument[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++)
                    result.arguments[i1] = RemoteInvocationArgument.decode(decoder1, 8 + 16 * i1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.name, 8, false);
            if (this.arguments == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodeUnionArray(this.arguments.length, 16, -1);
                for (int i0 = 0; i0 < this.arguments.length; i0++)
                    encoder1.encode(this.arguments[i0], 8 + 16 * i0, false);
            }
        }
    }

    static final class RemoteObjectInvokeMethodResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public RemoteInvocationResult result;

        private RemoteObjectInvokeMethodResponseParams(int version) {
            super(16, version);
        }

        public RemoteObjectInvokeMethodResponseParams() {
            this(0);
        }

        public static RemoteObjectInvokeMethodResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RemoteObjectInvokeMethodResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RemoteObjectInvokeMethodResponseParams decode(Decoder decoder0) {
            RemoteObjectInvokeMethodResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RemoteObjectInvokeMethodResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = RemoteInvocationResult.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class RemoteObjectInvokeMethodResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final RemoteObject.InvokeMethodResponse mCallback;

        RemoteObjectInvokeMethodResponseParamsForwardToCallback(RemoteObject.InvokeMethodResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                RemoteObject_Internal.RemoteObjectInvokeMethodResponseParams response = RemoteObject_Internal.RemoteObjectInvokeMethodResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class RemoteObjectInvokeMethodResponseParamsProxyToResponder implements RemoteObject.InvokeMethodResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        RemoteObjectInvokeMethodResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(RemoteInvocationResult result) {
            RemoteObject_Internal.RemoteObjectInvokeMethodResponseParams _response = new RemoteObject_Internal.RemoteObjectInvokeMethodResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
