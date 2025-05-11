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

class MediaDevicesListener_Internal {
    public static final Interface.Manager<MediaDevicesListener, MediaDevicesListener.Proxy> MANAGER = new Interface.Manager<MediaDevicesListener, MediaDevicesListener.Proxy>() {
        public String getName() {
            return "blink.mojom.MediaDevicesListener";
        }

        public int getVersion() {
            return 0;
        }

        public MediaDevicesListener_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new MediaDevicesListener_Internal.Proxy(core, messageReceiver);
        }

        public MediaDevicesListener_Internal.Stub buildStub(Core core, MediaDevicesListener impl) {
            return new MediaDevicesListener_Internal.Stub(core, impl);
        }

        public MediaDevicesListener[] buildArray(int size) {
            return new MediaDevicesListener[size];
        }
    };

    private static final int ON_DEVICES_CHANGED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements MediaDevicesListener.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onDevicesChanged(int type, MediaDeviceInfo[] deviceInfos) {
            MediaDevicesListener_Internal.MediaDevicesListenerOnDevicesChangedParams _message = new MediaDevicesListener_Internal.MediaDevicesListenerOnDevicesChangedParams();
            _message.type = type;
            _message.deviceInfos = deviceInfos;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<MediaDevicesListener> {
        Stub(Core core, MediaDevicesListener impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                MediaDevicesListener_Internal.MediaDevicesListenerOnDevicesChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaDevicesListener_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = MediaDevicesListener_Internal.MediaDevicesListenerOnDevicesChangedParams.deserialize(messageWithHeader.getPayload());
                        ((MediaDevicesListener)getImpl()).onDevicesChanged(data.type, data.deviceInfos);
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
                                getCore(), MediaDevicesListener_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class MediaDevicesListenerOnDevicesChangedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        public MediaDeviceInfo[] deviceInfos;

        private MediaDevicesListenerOnDevicesChangedParams(int version) {
            super(24, version);
        }

        public MediaDevicesListenerOnDevicesChangedParams() {
            this(0);
        }

        public static MediaDevicesListenerOnDevicesChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesListenerOnDevicesChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesListenerOnDevicesChangedParams decode(Decoder decoder0) {
            MediaDevicesListenerOnDevicesChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesListenerOnDevicesChangedParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                MediaDeviceType.validate(result.type);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.deviceInfos = new MediaDeviceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.deviceInfos[i1] = MediaDeviceInfo.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.type, 8);
            if (this.deviceInfos == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.deviceInfos.length, 16, -1);
                for (int i0 = 0; i0 < this.deviceInfos.length; i0++)
                    encoder1.encode(this.deviceInfos[i0], 8 + 8 * i0, false);
            }
        }
    }
}
