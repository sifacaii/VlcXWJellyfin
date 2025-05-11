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

class WebLaunchService_Internal {
    public static final Interface.Manager<WebLaunchService, WebLaunchService.Proxy> MANAGER = new Interface.Manager<WebLaunchService, WebLaunchService.Proxy>() {
        public String getName() {
            return "blink.mojom.WebLaunchService";
        }

        public int getVersion() {
            return 0;
        }

        public WebLaunchService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WebLaunchService_Internal.Proxy(core, messageReceiver);
        }

        public WebLaunchService_Internal.Stub buildStub(Core core, WebLaunchService impl) {
            return new WebLaunchService_Internal.Stub(core, impl);
        }

        public WebLaunchService[] buildArray(int size) {
            return new WebLaunchService[size];
        }
    };

    private static final int SET_LAUNCH_FILES_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements WebLaunchService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setLaunchFiles(NativeFileSystemEntry[] files) {
            WebLaunchService_Internal.WebLaunchServiceSetLaunchFilesParams _message = new WebLaunchService_Internal.WebLaunchServiceSetLaunchFilesParams();
            _message.files = files;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<WebLaunchService> {
        Stub(Core core, WebLaunchService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                WebLaunchService_Internal.WebLaunchServiceSetLaunchFilesParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WebLaunchService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = WebLaunchService_Internal.WebLaunchServiceSetLaunchFilesParams.deserialize(messageWithHeader.getPayload());
                        ((WebLaunchService)getImpl()).setLaunchFiles(data.files);
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
                                getCore(), WebLaunchService_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WebLaunchServiceSetLaunchFilesParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemEntry[] files;

        private WebLaunchServiceSetLaunchFilesParams(int version) {
            super(16, version);
        }

        public WebLaunchServiceSetLaunchFilesParams() {
            this(0);
        }

        public static WebLaunchServiceSetLaunchFilesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebLaunchServiceSetLaunchFilesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebLaunchServiceSetLaunchFilesParams decode(Decoder decoder0) {
            WebLaunchServiceSetLaunchFilesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebLaunchServiceSetLaunchFilesParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.files = new NativeFileSystemEntry[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.files[i1] = NativeFileSystemEntry.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.files == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.files.length, 8, -1);
                for (int i0 = 0; i0 < this.files.length; i0++)
                    encoder1.encode(this.files[i0], 8 + 8 * i0, false);
            }
        }
    }
}
