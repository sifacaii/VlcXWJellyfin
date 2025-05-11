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

class KeyboardLockService_Internal {
    public static final Interface.Manager<KeyboardLockService, KeyboardLockService.Proxy> MANAGER = new Interface.Manager<KeyboardLockService, KeyboardLockService.Proxy>() {
        public String getName() {
            return "blink.mojom.KeyboardLockService";
        }

        public int getVersion() {
            return 0;
        }

        public KeyboardLockService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new KeyboardLockService_Internal.Proxy(core, messageReceiver);
        }

        public KeyboardLockService_Internal.Stub buildStub(Core core, KeyboardLockService impl) {
            return new KeyboardLockService_Internal.Stub(core, impl);
        }

        public KeyboardLockService[] buildArray(int size) {
            return new KeyboardLockService[size];
        }
    };

    private static final int REQUEST_KEYBOARD_LOCK_ORDINAL = 0;

    private static final int CANCEL_KEYBOARD_LOCK_ORDINAL = 1;

    private static final int GET_KEYBOARD_LAYOUT_MAP_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements KeyboardLockService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void requestKeyboardLock(String[] keyCodes, KeyboardLockService.RequestKeyboardLockResponse callback) {
            KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockParams _message = new KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockParams();
            _message.keyCodes = keyCodes;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockResponseParamsForwardToCallback(callback));
        }

        public void cancelKeyboardLock() {
            KeyboardLockService_Internal.KeyboardLockServiceCancelKeyboardLockParams _message = new KeyboardLockService_Internal.KeyboardLockServiceCancelKeyboardLockParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void getKeyboardLayoutMap(KeyboardLockService.GetKeyboardLayoutMapResponse callback) {
            KeyboardLockService_Internal.KeyboardLockServiceGetKeyboardLayoutMapParams _message = new KeyboardLockService_Internal.KeyboardLockServiceGetKeyboardLayoutMapParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new KeyboardLockService_Internal.KeyboardLockServiceGetKeyboardLayoutMapResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<KeyboardLockService> {
        Stub(Core core, KeyboardLockService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(KeyboardLockService_Internal.MANAGER, messageWithHeader);
                    case 1:
                        KeyboardLockService_Internal.KeyboardLockServiceCancelKeyboardLockParams.deserialize(messageWithHeader.getPayload());
                        ((KeyboardLockService)getImpl()).cancelKeyboardLock();
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
                KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), KeyboardLockService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockParams.deserialize(messageWithHeader.getPayload());
                        ((KeyboardLockService)getImpl()).requestKeyboardLock(data.keyCodes, new KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        KeyboardLockService_Internal.KeyboardLockServiceGetKeyboardLayoutMapParams.deserialize(messageWithHeader.getPayload());
                        ((KeyboardLockService)getImpl()).getKeyboardLayoutMap(new KeyboardLockService_Internal.KeyboardLockServiceGetKeyboardLayoutMapResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class KeyboardLockServiceRequestKeyboardLockParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String[] keyCodes;

        private KeyboardLockServiceRequestKeyboardLockParams(int version) {
            super(16, version);
        }

        public KeyboardLockServiceRequestKeyboardLockParams() {
            this(0);
        }

        public static KeyboardLockServiceRequestKeyboardLockParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static KeyboardLockServiceRequestKeyboardLockParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static KeyboardLockServiceRequestKeyboardLockParams decode(Decoder decoder0) {
            KeyboardLockServiceRequestKeyboardLockParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new KeyboardLockServiceRequestKeyboardLockParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.keyCodes = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++)
                    result.keyCodes[i1] = decoder1.readString(8 + 8 * i1, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.keyCodes == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.keyCodes.length, 8, -1);
                for (int i0 = 0; i0 < this.keyCodes.length; i0++)
                    encoder1.encode(this.keyCodes[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class KeyboardLockServiceRequestKeyboardLockResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        private KeyboardLockServiceRequestKeyboardLockResponseParams(int version) {
            super(16, version);
        }

        public KeyboardLockServiceRequestKeyboardLockResponseParams() {
            this(0);
        }

        public static KeyboardLockServiceRequestKeyboardLockResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static KeyboardLockServiceRequestKeyboardLockResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static KeyboardLockServiceRequestKeyboardLockResponseParams decode(Decoder decoder0) {
            KeyboardLockServiceRequestKeyboardLockResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new KeyboardLockServiceRequestKeyboardLockResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                KeyboardLockRequestResult.validate(result.result);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8);
        }
    }

    static class KeyboardLockServiceRequestKeyboardLockResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final KeyboardLockService.RequestKeyboardLockResponse mCallback;

        KeyboardLockServiceRequestKeyboardLockResponseParamsForwardToCallback(KeyboardLockService.RequestKeyboardLockResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockResponseParams response = KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class KeyboardLockServiceRequestKeyboardLockResponseParamsProxyToResponder implements KeyboardLockService.RequestKeyboardLockResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        KeyboardLockServiceRequestKeyboardLockResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result) {
            KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockResponseParams _response = new KeyboardLockService_Internal.KeyboardLockServiceRequestKeyboardLockResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class KeyboardLockServiceCancelKeyboardLockParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private KeyboardLockServiceCancelKeyboardLockParams(int version) {
            super(8, version);
        }

        public KeyboardLockServiceCancelKeyboardLockParams() {
            this(0);
        }

        public static KeyboardLockServiceCancelKeyboardLockParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static KeyboardLockServiceCancelKeyboardLockParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static KeyboardLockServiceCancelKeyboardLockParams decode(Decoder decoder0) {
            KeyboardLockServiceCancelKeyboardLockParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new KeyboardLockServiceCancelKeyboardLockParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class KeyboardLockServiceGetKeyboardLayoutMapParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private KeyboardLockServiceGetKeyboardLayoutMapParams(int version) {
            super(8, version);
        }

        public KeyboardLockServiceGetKeyboardLayoutMapParams() {
            this(0);
        }

        public static KeyboardLockServiceGetKeyboardLayoutMapParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static KeyboardLockServiceGetKeyboardLayoutMapParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static KeyboardLockServiceGetKeyboardLayoutMapParams decode(Decoder decoder0) {
            KeyboardLockServiceGetKeyboardLayoutMapParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new KeyboardLockServiceGetKeyboardLayoutMapParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class KeyboardLockServiceGetKeyboardLayoutMapResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public GetKeyboardLayoutMapResult result;

        private KeyboardLockServiceGetKeyboardLayoutMapResponseParams(int version) {
            super(16, version);
        }

        public KeyboardLockServiceGetKeyboardLayoutMapResponseParams() {
            this(0);
        }

        public static KeyboardLockServiceGetKeyboardLayoutMapResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static KeyboardLockServiceGetKeyboardLayoutMapResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static KeyboardLockServiceGetKeyboardLayoutMapResponseParams decode(Decoder decoder0) {
            KeyboardLockServiceGetKeyboardLayoutMapResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new KeyboardLockServiceGetKeyboardLayoutMapResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = GetKeyboardLayoutMapResult.decode(decoder1);
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

    static class KeyboardLockServiceGetKeyboardLayoutMapResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final KeyboardLockService.GetKeyboardLayoutMapResponse mCallback;

        KeyboardLockServiceGetKeyboardLayoutMapResponseParamsForwardToCallback(KeyboardLockService.GetKeyboardLayoutMapResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                KeyboardLockService_Internal.KeyboardLockServiceGetKeyboardLayoutMapResponseParams response = KeyboardLockService_Internal.KeyboardLockServiceGetKeyboardLayoutMapResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class KeyboardLockServiceGetKeyboardLayoutMapResponseParamsProxyToResponder implements KeyboardLockService.GetKeyboardLayoutMapResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        KeyboardLockServiceGetKeyboardLayoutMapResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(GetKeyboardLayoutMapResult result) {
            KeyboardLockService_Internal.KeyboardLockServiceGetKeyboardLayoutMapResponseParams _response = new KeyboardLockService_Internal.KeyboardLockServiceGetKeyboardLayoutMapResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
