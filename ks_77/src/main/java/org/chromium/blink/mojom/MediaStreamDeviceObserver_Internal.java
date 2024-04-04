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

class MediaStreamDeviceObserver_Internal {
    public static final Interface.Manager<MediaStreamDeviceObserver, MediaStreamDeviceObserver.Proxy> MANAGER = new Interface.Manager<MediaStreamDeviceObserver, MediaStreamDeviceObserver.Proxy>() {
        public String getName() {
            return "blink.mojom.MediaStreamDeviceObserver";
        }

        public int getVersion() {
            return 0;
        }

        public MediaStreamDeviceObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new MediaStreamDeviceObserver_Internal.Proxy(core, messageReceiver);
        }

        public MediaStreamDeviceObserver_Internal.Stub buildStub(Core core, MediaStreamDeviceObserver impl) {
            return new MediaStreamDeviceObserver_Internal.Stub(core, impl);
        }

        public MediaStreamDeviceObserver[] buildArray(int size) {
            return new MediaStreamDeviceObserver[size];
        }
    };

    private static final int ON_DEVICE_STOPPED_ORDINAL = 0;

    private static final int ON_DEVICE_CHANGED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements MediaStreamDeviceObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onDeviceStopped(String label, MediaStreamDevice device) {
            MediaStreamDeviceObserver_Internal.MediaStreamDeviceObserverOnDeviceStoppedParams _message = new MediaStreamDeviceObserver_Internal.MediaStreamDeviceObserverOnDeviceStoppedParams();
            _message.label = label;
            _message.device = device;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onDeviceChanged(String label, MediaStreamDevice oldDevice, MediaStreamDevice newDevice) {
            MediaStreamDeviceObserver_Internal.MediaStreamDeviceObserverOnDeviceChangedParams _message = new MediaStreamDeviceObserver_Internal.MediaStreamDeviceObserverOnDeviceChangedParams();
            _message.label = label;
            _message.oldDevice = oldDevice;
            _message.newDevice = newDevice;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<MediaStreamDeviceObserver> {
        Stub(Core core, MediaStreamDeviceObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                MediaStreamDeviceObserver_Internal.MediaStreamDeviceObserverOnDeviceStoppedParams mediaStreamDeviceObserverOnDeviceStoppedParams;
                MediaStreamDeviceObserver_Internal.MediaStreamDeviceObserverOnDeviceChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaStreamDeviceObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        mediaStreamDeviceObserverOnDeviceStoppedParams = MediaStreamDeviceObserver_Internal.MediaStreamDeviceObserverOnDeviceStoppedParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamDeviceObserver)getImpl()).onDeviceStopped(mediaStreamDeviceObserverOnDeviceStoppedParams.label, mediaStreamDeviceObserverOnDeviceStoppedParams.device);
                        return true;
                    case 1:
                        data = MediaStreamDeviceObserver_Internal.MediaStreamDeviceObserverOnDeviceChangedParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamDeviceObserver)getImpl()).onDeviceChanged(data.label, data.oldDevice, data.newDevice);
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
                                getCore(), MediaStreamDeviceObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class MediaStreamDeviceObserverOnDeviceStoppedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String label;

        public MediaStreamDevice device;

        private MediaStreamDeviceObserverOnDeviceStoppedParams(int version) {
            super(24, version);
        }

        public MediaStreamDeviceObserverOnDeviceStoppedParams() {
            this(0);
        }

        public static MediaStreamDeviceObserverOnDeviceStoppedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDeviceObserverOnDeviceStoppedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDeviceObserverOnDeviceStoppedParams decode(Decoder decoder0) {
            MediaStreamDeviceObserverOnDeviceStoppedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDeviceObserverOnDeviceStoppedParams(elementsOrVersion);
                result.label = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.device = MediaStreamDevice.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.label, 8, false);
            encoder0.encode(this.device, 16, false);
        }
    }

    static final class MediaStreamDeviceObserverOnDeviceChangedParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String label;

        public MediaStreamDevice oldDevice;

        public MediaStreamDevice newDevice;

        private MediaStreamDeviceObserverOnDeviceChangedParams(int version) {
            super(32, version);
        }

        public MediaStreamDeviceObserverOnDeviceChangedParams() {
            this(0);
        }

        public static MediaStreamDeviceObserverOnDeviceChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDeviceObserverOnDeviceChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDeviceObserverOnDeviceChangedParams decode(Decoder decoder0) {
            MediaStreamDeviceObserverOnDeviceChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDeviceObserverOnDeviceChangedParams(elementsOrVersion);
                result.label = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.oldDevice = MediaStreamDevice.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.newDevice = MediaStreamDevice.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.label, 8, false);
            encoder0.encode(this.oldDevice, 16, false);
            encoder0.encode(this.newDevice, 24, false);
        }
    }
}
