package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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
import org.chromium.url.mojom.Origin;

class SessionStorageNamespace_Internal {
    public static final Interface.Manager<SessionStorageNamespace, SessionStorageNamespace.Proxy> MANAGER = new Interface.Manager<SessionStorageNamespace, SessionStorageNamespace.Proxy>() {
        public String getName() {
            return "blink.mojom.SessionStorageNamespace";
        }

        public int getVersion() {
            return 0;
        }

        public SessionStorageNamespace_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SessionStorageNamespace_Internal.Proxy(core, messageReceiver);
        }

        public SessionStorageNamespace_Internal.Stub buildStub(Core core, SessionStorageNamespace impl) {
            return new SessionStorageNamespace_Internal.Stub(core, impl);
        }

        public SessionStorageNamespace[] buildArray(int size) {
            return new SessionStorageNamespace[size];
        }
    };

    private static final int OPEN_AREA_ORDINAL = 0;

    private static final int CLONE_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements SessionStorageNamespace.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void openArea(Origin origin, AssociatedInterfaceRequestNotSupported area) {
            SessionStorageNamespace_Internal.SessionStorageNamespaceOpenAreaParams _message = new SessionStorageNamespace_Internal.SessionStorageNamespaceOpenAreaParams();
            _message.origin = origin;
            _message.area = area;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void clone(String cloneToNamespace) {
            SessionStorageNamespace_Internal.SessionStorageNamespaceCloneParams _message = new SessionStorageNamespace_Internal.SessionStorageNamespaceCloneParams();
            _message.cloneToNamespace = cloneToNamespace;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<SessionStorageNamespace> {
        Stub(Core core, SessionStorageNamespace impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SessionStorageNamespace_Internal.SessionStorageNamespaceOpenAreaParams sessionStorageNamespaceOpenAreaParams;
                SessionStorageNamespace_Internal.SessionStorageNamespaceCloneParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SessionStorageNamespace_Internal.MANAGER, messageWithHeader);
                    case 0:
                        sessionStorageNamespaceOpenAreaParams = SessionStorageNamespace_Internal.SessionStorageNamespaceOpenAreaParams.deserialize(messageWithHeader.getPayload());
                        ((SessionStorageNamespace)getImpl()).openArea(sessionStorageNamespaceOpenAreaParams.origin, sessionStorageNamespaceOpenAreaParams.area);
                        return true;
                    case 1:
                        data = SessionStorageNamespace_Internal.SessionStorageNamespaceCloneParams.deserialize(messageWithHeader.getPayload());
                        ((SessionStorageNamespace)getImpl()).clone(data.cloneToNamespace);
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
                                getCore(), SessionStorageNamespace_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SessionStorageNamespaceOpenAreaParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public AssociatedInterfaceRequestNotSupported area;

        private SessionStorageNamespaceOpenAreaParams(int version) {
            super(24, version);
        }

        public SessionStorageNamespaceOpenAreaParams() {
            this(0);
        }

        public static SessionStorageNamespaceOpenAreaParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SessionStorageNamespaceOpenAreaParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SessionStorageNamespaceOpenAreaParams decode(Decoder decoder0) {
            SessionStorageNamespaceOpenAreaParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SessionStorageNamespaceOpenAreaParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                result.area = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode(this.area, 16, false);
        }
    }

    static final class SessionStorageNamespaceCloneParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String cloneToNamespace;

        private SessionStorageNamespaceCloneParams(int version) {
            super(16, version);
        }

        public SessionStorageNamespaceCloneParams() {
            this(0);
        }

        public static SessionStorageNamespaceCloneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SessionStorageNamespaceCloneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SessionStorageNamespaceCloneParams decode(Decoder decoder0) {
            SessionStorageNamespaceCloneParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SessionStorageNamespaceCloneParams(elementsOrVersion);
                result.cloneToNamespace = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.cloneToNamespace, 8, false);
        }
    }
}
