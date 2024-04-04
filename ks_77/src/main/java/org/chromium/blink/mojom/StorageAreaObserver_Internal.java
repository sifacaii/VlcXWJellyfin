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

class StorageAreaObserver_Internal {
    public static final Interface.Manager<StorageAreaObserver, StorageAreaObserver.Proxy> MANAGER = new Interface.Manager<StorageAreaObserver, StorageAreaObserver.Proxy>() {
        public String getName() {
            return "blink.mojom.StorageAreaObserver";
        }

        public int getVersion() {
            return 0;
        }

        public StorageAreaObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new StorageAreaObserver_Internal.Proxy(core, messageReceiver);
        }

        public StorageAreaObserver_Internal.Stub buildStub(Core core, StorageAreaObserver impl) {
            return new StorageAreaObserver_Internal.Stub(core, impl);
        }

        public StorageAreaObserver[] buildArray(int size) {
            return new StorageAreaObserver[size];
        }
    };

    private static final int KEY_ADDED_ORDINAL = 0;

    private static final int KEY_CHANGED_ORDINAL = 1;

    private static final int KEY_DELETED_ORDINAL = 2;

    private static final int ALL_DELETED_ORDINAL = 3;

    private static final int SHOULD_SEND_OLD_VALUE_ON_MUTATIONS_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements StorageAreaObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void keyAdded(byte[] key, byte[] value, String source) {
            StorageAreaObserver_Internal.StorageAreaObserverKeyAddedParams _message = new StorageAreaObserver_Internal.StorageAreaObserverKeyAddedParams();
            _message.key = key;
            _message.value = value;
            _message.source = source;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void keyChanged(byte[] key, byte[] newValue, byte[] oldValue, String source) {
            StorageAreaObserver_Internal.StorageAreaObserverKeyChangedParams _message = new StorageAreaObserver_Internal.StorageAreaObserverKeyChangedParams();
            _message.key = key;
            _message.newValue = newValue;
            _message.oldValue = oldValue;
            _message.source = source;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void keyDeleted(byte[] key, byte[] oldValue, String source) {
            StorageAreaObserver_Internal.StorageAreaObserverKeyDeletedParams _message = new StorageAreaObserver_Internal.StorageAreaObserverKeyDeletedParams();
            _message.key = key;
            _message.oldValue = oldValue;
            _message.source = source;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void allDeleted(String source) {
            StorageAreaObserver_Internal.StorageAreaObserverAllDeletedParams _message = new StorageAreaObserver_Internal.StorageAreaObserverAllDeletedParams();
            _message.source = source;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void shouldSendOldValueOnMutations(boolean value) {
            StorageAreaObserver_Internal.StorageAreaObserverShouldSendOldValueOnMutationsParams _message = new StorageAreaObserver_Internal.StorageAreaObserverShouldSendOldValueOnMutationsParams();
            _message.value = value;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    static final class Stub extends Interface.Stub<StorageAreaObserver> {
        Stub(Core core, StorageAreaObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                StorageAreaObserver_Internal.StorageAreaObserverKeyAddedParams storageAreaObserverKeyAddedParams;
                StorageAreaObserver_Internal.StorageAreaObserverKeyChangedParams storageAreaObserverKeyChangedParams;
                StorageAreaObserver_Internal.StorageAreaObserverKeyDeletedParams storageAreaObserverKeyDeletedParams;
                StorageAreaObserver_Internal.StorageAreaObserverAllDeletedParams storageAreaObserverAllDeletedParams;
                StorageAreaObserver_Internal.StorageAreaObserverShouldSendOldValueOnMutationsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(StorageAreaObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        storageAreaObserverKeyAddedParams = StorageAreaObserver_Internal.StorageAreaObserverKeyAddedParams.deserialize(messageWithHeader.getPayload());
                        ((StorageAreaObserver)getImpl()).keyAdded(storageAreaObserverKeyAddedParams.key, storageAreaObserverKeyAddedParams.value, storageAreaObserverKeyAddedParams.source);
                        return true;
                    case 1:
                        storageAreaObserverKeyChangedParams = StorageAreaObserver_Internal.StorageAreaObserverKeyChangedParams.deserialize(messageWithHeader.getPayload());
                        ((StorageAreaObserver)getImpl()).keyChanged(storageAreaObserverKeyChangedParams.key, storageAreaObserverKeyChangedParams.newValue, storageAreaObserverKeyChangedParams.oldValue, storageAreaObserverKeyChangedParams.source);
                        return true;
                    case 2:
                        storageAreaObserverKeyDeletedParams = StorageAreaObserver_Internal.StorageAreaObserverKeyDeletedParams.deserialize(messageWithHeader.getPayload());
                        ((StorageAreaObserver)getImpl()).keyDeleted(storageAreaObserverKeyDeletedParams.key, storageAreaObserverKeyDeletedParams.oldValue, storageAreaObserverKeyDeletedParams.source);
                        return true;
                    case 3:
                        storageAreaObserverAllDeletedParams = StorageAreaObserver_Internal.StorageAreaObserverAllDeletedParams.deserialize(messageWithHeader.getPayload());
                        ((StorageAreaObserver)getImpl()).allDeleted(storageAreaObserverAllDeletedParams.source);
                        return true;
                    case 4:
                        data = StorageAreaObserver_Internal.StorageAreaObserverShouldSendOldValueOnMutationsParams.deserialize(messageWithHeader.getPayload());
                        ((StorageAreaObserver)getImpl()).shouldSendOldValueOnMutations(data.value);
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
                                getCore(), StorageAreaObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class StorageAreaObserverKeyAddedParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] key;

        public byte[] value;

        public String source;

        private StorageAreaObserverKeyAddedParams(int version) {
            super(32, version);
        }

        public StorageAreaObserverKeyAddedParams() {
            this(0);
        }

        public static StorageAreaObserverKeyAddedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaObserverKeyAddedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaObserverKeyAddedParams decode(Decoder decoder0) {
            StorageAreaObserverKeyAddedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverKeyAddedParams(elementsOrVersion);
                result.key = decoder0.readBytes(8, 0, -1);
                result.value = decoder0.readBytes(16, 0, -1);
                result.source = decoder0.readString(24, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.key, 8, 0, -1);
            encoder0.encode(this.value, 16, 0, -1);
            encoder0.encode(this.source, 24, false);
        }
    }

    static final class StorageAreaObserverKeyChangedParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] key;

        public byte[] newValue;

        public byte[] oldValue;

        public String source;

        private StorageAreaObserverKeyChangedParams(int version) {
            super(40, version);
        }

        public StorageAreaObserverKeyChangedParams() {
            this(0);
        }

        public static StorageAreaObserverKeyChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaObserverKeyChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaObserverKeyChangedParams decode(Decoder decoder0) {
            StorageAreaObserverKeyChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverKeyChangedParams(elementsOrVersion);
                result.key = decoder0.readBytes(8, 0, -1);
                result.newValue = decoder0.readBytes(16, 0, -1);
                result.oldValue = decoder0.readBytes(24, 0, -1);
                result.source = decoder0.readString(32, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.key, 8, 0, -1);
            encoder0.encode(this.newValue, 16, 0, -1);
            encoder0.encode(this.oldValue, 24, 0, -1);
            encoder0.encode(this.source, 32, false);
        }
    }

    static final class StorageAreaObserverKeyDeletedParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] key;

        public byte[] oldValue;

        public String source;

        private StorageAreaObserverKeyDeletedParams(int version) {
            super(32, version);
        }

        public StorageAreaObserverKeyDeletedParams() {
            this(0);
        }

        public static StorageAreaObserverKeyDeletedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaObserverKeyDeletedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaObserverKeyDeletedParams decode(Decoder decoder0) {
            StorageAreaObserverKeyDeletedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverKeyDeletedParams(elementsOrVersion);
                result.key = decoder0.readBytes(8, 0, -1);
                result.oldValue = decoder0.readBytes(16, 0, -1);
                result.source = decoder0.readString(24, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.key, 8, 0, -1);
            encoder0.encode(this.oldValue, 16, 0, -1);
            encoder0.encode(this.source, 24, false);
        }
    }

    static final class StorageAreaObserverAllDeletedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String source;

        private StorageAreaObserverAllDeletedParams(int version) {
            super(16, version);
        }

        public StorageAreaObserverAllDeletedParams() {
            this(0);
        }

        public static StorageAreaObserverAllDeletedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaObserverAllDeletedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaObserverAllDeletedParams decode(Decoder decoder0) {
            StorageAreaObserverAllDeletedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverAllDeletedParams(elementsOrVersion);
                result.source = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.source, 8, false);
        }
    }

    static final class StorageAreaObserverShouldSendOldValueOnMutationsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean value;

        private StorageAreaObserverShouldSendOldValueOnMutationsParams(int version) {
            super(16, version);
        }

        public StorageAreaObserverShouldSendOldValueOnMutationsParams() {
            this(0);
        }

        public static StorageAreaObserverShouldSendOldValueOnMutationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaObserverShouldSendOldValueOnMutationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaObserverShouldSendOldValueOnMutationsParams decode(Decoder decoder0) {
            StorageAreaObserverShouldSendOldValueOnMutationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverShouldSendOldValueOnMutationsParams(elementsOrVersion);
                result.value = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.value, 8, 0);
        }
    }
}
