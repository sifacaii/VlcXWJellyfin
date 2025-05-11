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

class RendererPreferenceWatcher_Internal {
    public static final Interface.Manager<RendererPreferenceWatcher, RendererPreferenceWatcher.Proxy> MANAGER = new Interface.Manager<RendererPreferenceWatcher, RendererPreferenceWatcher.Proxy>() {
        public String getName() {
            return "blink.mojom.RendererPreferenceWatcher";
        }

        public int getVersion() {
            return 0;
        }

        public RendererPreferenceWatcher_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new RendererPreferenceWatcher_Internal.Proxy(core, messageReceiver);
        }

        public RendererPreferenceWatcher_Internal.Stub buildStub(Core core, RendererPreferenceWatcher impl) {
            return new RendererPreferenceWatcher_Internal.Stub(core, impl);
        }

        public RendererPreferenceWatcher[] buildArray(int size) {
            return new RendererPreferenceWatcher[size];
        }
    };

    private static final int NOTIFY_UPDATE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements RendererPreferenceWatcher.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void notifyUpdate(RendererPreferences newPrefs) {
            RendererPreferenceWatcher_Internal.RendererPreferenceWatcherNotifyUpdateParams _message = new RendererPreferenceWatcher_Internal.RendererPreferenceWatcherNotifyUpdateParams();
            _message.newPrefs = newPrefs;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<RendererPreferenceWatcher> {
        Stub(Core core, RendererPreferenceWatcher impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                RendererPreferenceWatcher_Internal.RendererPreferenceWatcherNotifyUpdateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(RendererPreferenceWatcher_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = RendererPreferenceWatcher_Internal.RendererPreferenceWatcherNotifyUpdateParams.deserialize(messageWithHeader.getPayload());
                        ((RendererPreferenceWatcher)getImpl()).notifyUpdate(data.newPrefs);
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
                                getCore(), RendererPreferenceWatcher_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class RendererPreferenceWatcherNotifyUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public RendererPreferences newPrefs;

        private RendererPreferenceWatcherNotifyUpdateParams(int version) {
            super(16, version);
        }

        public RendererPreferenceWatcherNotifyUpdateParams() {
            this(0);
        }

        public static RendererPreferenceWatcherNotifyUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererPreferenceWatcherNotifyUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererPreferenceWatcherNotifyUpdateParams decode(Decoder decoder0) {
            RendererPreferenceWatcherNotifyUpdateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RendererPreferenceWatcherNotifyUpdateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.newPrefs = RendererPreferences.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.newPrefs, 8, false);
        }
    }
}
