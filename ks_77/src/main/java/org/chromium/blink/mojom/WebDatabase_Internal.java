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
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Origin;

class WebDatabase_Internal {
    public static final Interface.Manager<WebDatabase, WebDatabase.Proxy> MANAGER = new Interface.Manager<WebDatabase, WebDatabase.Proxy>() {
        public String getName() {
            return "blink.mojom.WebDatabase";
        }

        public int getVersion() {
            return 0;
        }

        public WebDatabase_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WebDatabase_Internal.Proxy(core, messageReceiver);
        }

        public WebDatabase_Internal.Stub buildStub(Core core, WebDatabase impl) {
            return new WebDatabase_Internal.Stub(core, impl);
        }

        public WebDatabase[] buildArray(int size) {
            return new WebDatabase[size];
        }
    };

    private static final int UPDATE_SIZE_ORDINAL = 0;

    private static final int CLOSE_IMMEDIATELY_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements WebDatabase.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void updateSize(Origin origin, String16 name, long size) {
            WebDatabase_Internal.WebDatabaseUpdateSizeParams _message = new WebDatabase_Internal.WebDatabaseUpdateSizeParams();
            _message.origin = origin;
            _message.name = name;
            _message.size = size;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void closeImmediately(Origin origin, String16 name) {
            WebDatabase_Internal.WebDatabaseCloseImmediatelyParams _message = new WebDatabase_Internal.WebDatabaseCloseImmediatelyParams();
            _message.origin = origin;
            _message.name = name;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<WebDatabase> {
        Stub(Core core, WebDatabase impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                WebDatabase_Internal.WebDatabaseUpdateSizeParams webDatabaseUpdateSizeParams;
                WebDatabase_Internal.WebDatabaseCloseImmediatelyParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WebDatabase_Internal.MANAGER, messageWithHeader);
                    case 0:
                        webDatabaseUpdateSizeParams = WebDatabase_Internal.WebDatabaseUpdateSizeParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabase)getImpl()).updateSize(webDatabaseUpdateSizeParams.origin, webDatabaseUpdateSizeParams.name, webDatabaseUpdateSizeParams.size);
                        return true;
                    case 1:
                        data = WebDatabase_Internal.WebDatabaseCloseImmediatelyParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabase)getImpl()).closeImmediately(data.origin, data.name);
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
                                getCore(), WebDatabase_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WebDatabaseUpdateSizeParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public String16 name;

        public long size;

        private WebDatabaseUpdateSizeParams(int version) {
            super(32, version);
        }

        public WebDatabaseUpdateSizeParams() {
            this(0);
        }

        public static WebDatabaseUpdateSizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseUpdateSizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseUpdateSizeParams decode(Decoder decoder0) {
            WebDatabaseUpdateSizeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseUpdateSizeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.name = String16.decode(decoder1);
                result.size = decoder0.readLong(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode((Struct)this.name, 16, false);
            encoder0.encode(this.size, 24);
        }
    }

    static final class WebDatabaseCloseImmediatelyParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public String16 name;

        private WebDatabaseCloseImmediatelyParams(int version) {
            super(24, version);
        }

        public WebDatabaseCloseImmediatelyParams() {
            this(0);
        }

        public static WebDatabaseCloseImmediatelyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseCloseImmediatelyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseCloseImmediatelyParams decode(Decoder decoder0) {
            WebDatabaseCloseImmediatelyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseCloseImmediatelyParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.name = String16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode((Struct)this.name, 16, false);
        }
    }
}
