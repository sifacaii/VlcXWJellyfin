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

class NonPersistentNotificationListener_Internal {
    public static final Interface.Manager<NonPersistentNotificationListener, NonPersistentNotificationListener.Proxy> MANAGER = new Interface.Manager<NonPersistentNotificationListener, NonPersistentNotificationListener.Proxy>() {
        public String getName() {
            return "blink.mojom.NonPersistentNotificationListener";
        }

        public int getVersion() {
            return 0;
        }

        public NonPersistentNotificationListener_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NonPersistentNotificationListener_Internal.Proxy(core, messageReceiver);
        }

        public NonPersistentNotificationListener_Internal.Stub buildStub(Core core, NonPersistentNotificationListener impl) {
            return new NonPersistentNotificationListener_Internal.Stub(core, impl);
        }

        public NonPersistentNotificationListener[] buildArray(int size) {
            return new NonPersistentNotificationListener[size];
        }
    };

    private static final int ON_SHOW_ORDINAL = 0;

    private static final int ON_CLICK_ORDINAL = 1;

    private static final int ON_CLOSE_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements NonPersistentNotificationListener.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onShow() {
            NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnShowParams _message = new NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnShowParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onClick(NonPersistentNotificationListener.OnClickResponse callback) {
            NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnClickParams _message = new NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnClickParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnClickResponseParamsForwardToCallback(callback));
        }

        public void onClose(NonPersistentNotificationListener.OnCloseResponse callback) {
            NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnCloseParams _message = new NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnCloseParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnCloseResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<NonPersistentNotificationListener> {
        Stub(Core core, NonPersistentNotificationListener impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NonPersistentNotificationListener_Internal.MANAGER, messageWithHeader);
                    case 0:
                        NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnShowParams.deserialize(messageWithHeader.getPayload());
                        ((NonPersistentNotificationListener)getImpl()).onShow();
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
                                getCore(), NonPersistentNotificationListener_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnClickParams.deserialize(messageWithHeader.getPayload());
                        ((NonPersistentNotificationListener)getImpl()).onClick(new NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnClickResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnCloseParams.deserialize(messageWithHeader.getPayload());
                        ((NonPersistentNotificationListener)getImpl()).onClose(new NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnCloseResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NonPersistentNotificationListenerOnShowParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NonPersistentNotificationListenerOnShowParams(int version) {
            super(8, version);
        }

        public NonPersistentNotificationListenerOnShowParams() {
            this(0);
        }

        public static NonPersistentNotificationListenerOnShowParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NonPersistentNotificationListenerOnShowParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NonPersistentNotificationListenerOnShowParams decode(Decoder decoder0) {
            NonPersistentNotificationListenerOnShowParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NonPersistentNotificationListenerOnShowParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NonPersistentNotificationListenerOnClickParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NonPersistentNotificationListenerOnClickParams(int version) {
            super(8, version);
        }

        public NonPersistentNotificationListenerOnClickParams() {
            this(0);
        }

        public static NonPersistentNotificationListenerOnClickParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NonPersistentNotificationListenerOnClickParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NonPersistentNotificationListenerOnClickParams decode(Decoder decoder0) {
            NonPersistentNotificationListenerOnClickParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NonPersistentNotificationListenerOnClickParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NonPersistentNotificationListenerOnClickResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NonPersistentNotificationListenerOnClickResponseParams(int version) {
            super(8, version);
        }

        public NonPersistentNotificationListenerOnClickResponseParams() {
            this(0);
        }

        public static NonPersistentNotificationListenerOnClickResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NonPersistentNotificationListenerOnClickResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NonPersistentNotificationListenerOnClickResponseParams decode(Decoder decoder0) {
            NonPersistentNotificationListenerOnClickResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NonPersistentNotificationListenerOnClickResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class NonPersistentNotificationListenerOnClickResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NonPersistentNotificationListener.OnClickResponse mCallback;

        NonPersistentNotificationListenerOnClickResponseParamsForwardToCallback(NonPersistentNotificationListener.OnClickResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NonPersistentNotificationListenerOnClickResponseParamsProxyToResponder implements NonPersistentNotificationListener.OnClickResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NonPersistentNotificationListenerOnClickResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnClickResponseParams _response = new NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnClickResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NonPersistentNotificationListenerOnCloseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NonPersistentNotificationListenerOnCloseParams(int version) {
            super(8, version);
        }

        public NonPersistentNotificationListenerOnCloseParams() {
            this(0);
        }

        public static NonPersistentNotificationListenerOnCloseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NonPersistentNotificationListenerOnCloseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NonPersistentNotificationListenerOnCloseParams decode(Decoder decoder0) {
            NonPersistentNotificationListenerOnCloseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NonPersistentNotificationListenerOnCloseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NonPersistentNotificationListenerOnCloseResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NonPersistentNotificationListenerOnCloseResponseParams(int version) {
            super(8, version);
        }

        public NonPersistentNotificationListenerOnCloseResponseParams() {
            this(0);
        }

        public static NonPersistentNotificationListenerOnCloseResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NonPersistentNotificationListenerOnCloseResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NonPersistentNotificationListenerOnCloseResponseParams decode(Decoder decoder0) {
            NonPersistentNotificationListenerOnCloseResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NonPersistentNotificationListenerOnCloseResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class NonPersistentNotificationListenerOnCloseResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NonPersistentNotificationListener.OnCloseResponse mCallback;

        NonPersistentNotificationListenerOnCloseResponseParamsForwardToCallback(NonPersistentNotificationListener.OnCloseResponse callback) {
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

    static class NonPersistentNotificationListenerOnCloseResponseParamsProxyToResponder implements NonPersistentNotificationListener.OnCloseResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NonPersistentNotificationListenerOnCloseResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnCloseResponseParams _response = new NonPersistentNotificationListener_Internal.NonPersistentNotificationListenerOnCloseResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
