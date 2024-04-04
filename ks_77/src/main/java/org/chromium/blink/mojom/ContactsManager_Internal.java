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

class ContactsManager_Internal {
    public static final Interface.Manager<ContactsManager, ContactsManager.Proxy> MANAGER = new Interface.Manager<ContactsManager, ContactsManager.Proxy>() {
        public String getName() {
            return "blink.mojom.ContactsManager";
        }

        public int getVersion() {
            return 0;
        }

        public ContactsManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ContactsManager_Internal.Proxy(core, messageReceiver);
        }

        public ContactsManager_Internal.Stub buildStub(Core core, ContactsManager impl) {
            return new ContactsManager_Internal.Stub(core, impl);
        }

        public ContactsManager[] buildArray(int size) {
            return new ContactsManager[size];
        }
    };

    private static final int SELECT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ContactsManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void select(boolean multiple, boolean includeNames, boolean includeEmails, boolean includeTel, ContactsManager.SelectResponse callback) {
            ContactsManager_Internal.ContactsManagerSelectParams _message = new ContactsManager_Internal.ContactsManagerSelectParams();
            _message.multiple = multiple;
            _message.includeNames = includeNames;
            _message.includeEmails = includeEmails;
            _message.includeTel = includeTel;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ContactsManager_Internal.ContactsManagerSelectResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<ContactsManager> {
        Stub(Core core, ContactsManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ContactsManager_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ContactsManager_Internal.ContactsManagerSelectParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ContactsManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = ContactsManager_Internal.ContactsManagerSelectParams.deserialize(messageWithHeader.getPayload());
                        ((ContactsManager)getImpl()).select(data.multiple, data.includeNames, data.includeEmails, data.includeTel, new ContactsManager_Internal.ContactsManagerSelectResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ContactsManagerSelectParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean multiple;

        public boolean includeNames;

        public boolean includeEmails;

        public boolean includeTel;

        private ContactsManagerSelectParams(int version) {
            super(16, version);
        }

        public ContactsManagerSelectParams() {
            this(0);
        }

        public static ContactsManagerSelectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContactsManagerSelectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContactsManagerSelectParams decode(Decoder decoder0) {
            ContactsManagerSelectParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContactsManagerSelectParams(elementsOrVersion);
                result.multiple = decoder0.readBoolean(8, 0);
                result.includeNames = decoder0.readBoolean(8, 1);
                result.includeEmails = decoder0.readBoolean(8, 2);
                result.includeTel = decoder0.readBoolean(8, 3);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.multiple, 8, 0);
            encoder0.encode(this.includeNames, 8, 1);
            encoder0.encode(this.includeEmails, 8, 2);
            encoder0.encode(this.includeTel, 8, 3);
        }
    }

    static final class ContactsManagerSelectResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ContactInfo[] contacts;

        private ContactsManagerSelectResponseParams(int version) {
            super(16, version);
        }

        public ContactsManagerSelectResponseParams() {
            this(0);
        }

        public static ContactsManagerSelectResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContactsManagerSelectResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContactsManagerSelectResponseParams decode(Decoder decoder0) {
            ContactsManagerSelectResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContactsManagerSelectResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                if (decoder1 == null) {
                    result.contacts = null;
                } else {
                    DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                    result.contacts = new ContactInfo[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                        Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                        result.contacts[i1] = ContactInfo.decode(decoder2);
                    }
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.contacts == null) {
                encoder0.encodeNullPointer(8, true);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.contacts.length, 8, -1);
                for (int i0 = 0; i0 < this.contacts.length; i0++)
                    encoder1.encode(this.contacts[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class ContactsManagerSelectResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContactsManager.SelectResponse mCallback;

        ContactsManagerSelectResponseParamsForwardToCallback(ContactsManager.SelectResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ContactsManager_Internal.ContactsManagerSelectResponseParams response = ContactsManager_Internal.ContactsManagerSelectResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.contacts);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContactsManagerSelectResponseParamsProxyToResponder implements ContactsManager.SelectResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContactsManagerSelectResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(ContactInfo[] contacts) {
            ContactsManager_Internal.ContactsManagerSelectResponseParams _response = new ContactsManager_Internal.ContactsManagerSelectResponseParams();
            _response.contacts = contacts;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
