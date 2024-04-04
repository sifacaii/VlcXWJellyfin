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
import org.chromium.url.mojom.Url;

class ManifestUrlChangeObserver_Internal {
    public static final Interface.Manager<ManifestUrlChangeObserver, ManifestUrlChangeObserver.Proxy> MANAGER = new Interface.Manager<ManifestUrlChangeObserver, ManifestUrlChangeObserver.Proxy>() {
        public String getName() {
            return "blink.mojom.ManifestUrlChangeObserver";
        }

        public int getVersion() {
            return 0;
        }

        public ManifestUrlChangeObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ManifestUrlChangeObserver_Internal.Proxy(core, messageReceiver);
        }

        public ManifestUrlChangeObserver_Internal.Stub buildStub(Core core, ManifestUrlChangeObserver impl) {
            return new ManifestUrlChangeObserver_Internal.Stub(core, impl);
        }

        public ManifestUrlChangeObserver[] buildArray(int size) {
            return new ManifestUrlChangeObserver[size];
        }
    };

    private static final int MANIFEST_URL_CHANGED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ManifestUrlChangeObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void manifestUrlChanged(Url manifestUrl) {
            ManifestUrlChangeObserver_Internal.ManifestUrlChangeObserverManifestUrlChangedParams _message = new ManifestUrlChangeObserver_Internal.ManifestUrlChangeObserverManifestUrlChangedParams();
            _message.manifestUrl = manifestUrl;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ManifestUrlChangeObserver> {
        Stub(Core core, ManifestUrlChangeObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ManifestUrlChangeObserver_Internal.ManifestUrlChangeObserverManifestUrlChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ManifestUrlChangeObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ManifestUrlChangeObserver_Internal.ManifestUrlChangeObserverManifestUrlChangedParams.deserialize(messageWithHeader.getPayload());
                        ((ManifestUrlChangeObserver)getImpl()).manifestUrlChanged(data.manifestUrl);
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
                                getCore(), ManifestUrlChangeObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ManifestUrlChangeObserverManifestUrlChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url manifestUrl;

        private ManifestUrlChangeObserverManifestUrlChangedParams(int version) {
            super(16, version);
        }

        public ManifestUrlChangeObserverManifestUrlChangedParams() {
            this(0);
        }

        public static ManifestUrlChangeObserverManifestUrlChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ManifestUrlChangeObserverManifestUrlChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ManifestUrlChangeObserverManifestUrlChangedParams decode(Decoder decoder0) {
            ManifestUrlChangeObserverManifestUrlChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ManifestUrlChangeObserverManifestUrlChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.manifestUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.manifestUrl, 8, true);
        }
    }
}
