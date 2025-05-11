package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.MediaSessionAction;
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

class MediaSessionClient_Internal {
    public static final Interface.Manager<MediaSessionClient, MediaSessionClient.Proxy> MANAGER = new Interface.Manager<MediaSessionClient, MediaSessionClient.Proxy>() {
        public String getName() {
            return "blink.mojom.MediaSessionClient";
        }

        public int getVersion() {
            return 0;
        }

        public MediaSessionClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new MediaSessionClient_Internal.Proxy(core, messageReceiver);
        }

        public MediaSessionClient_Internal.Stub buildStub(Core core, MediaSessionClient impl) {
            return new MediaSessionClient_Internal.Stub(core, impl);
        }

        public MediaSessionClient[] buildArray(int size) {
            return new MediaSessionClient[size];
        }
    };

    private static final int DID_RECEIVE_ACTION_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements MediaSessionClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void didReceiveAction(int action, MediaSessionActionDetails details) {
            MediaSessionClient_Internal.MediaSessionClientDidReceiveActionParams _message = new MediaSessionClient_Internal.MediaSessionClientDidReceiveActionParams();
            _message.action = action;
            _message.details = details;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<MediaSessionClient> {
        Stub(Core core, MediaSessionClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                MediaSessionClient_Internal.MediaSessionClientDidReceiveActionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaSessionClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = MediaSessionClient_Internal.MediaSessionClientDidReceiveActionParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionClient)getImpl()).didReceiveAction(data.action, data.details);
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
                                getCore(), MediaSessionClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class MediaSessionClientDidReceiveActionParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int action;

        public MediaSessionActionDetails details;

        private MediaSessionClientDidReceiveActionParams(int version) {
            super(32, version);
        }

        public MediaSessionClientDidReceiveActionParams() {
            this(0);
        }

        public static MediaSessionClientDidReceiveActionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionClientDidReceiveActionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionClientDidReceiveActionParams decode(Decoder decoder0) {
            MediaSessionClientDidReceiveActionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionClientDidReceiveActionParams(elementsOrVersion);
                result.action = decoder0.readInt(8);
                MediaSessionAction.validate(result.action);
                result.details = MediaSessionActionDetails.decode(decoder0, 16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.action, 8);
            encoder0.encode(this.details, 16, true);
        }
    }
}
