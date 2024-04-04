package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

class FingerprintObserver_Internal {
    public static final Interface.Manager<FingerprintObserver, FingerprintObserver.Proxy> MANAGER = new Interface.Manager<FingerprintObserver, FingerprintObserver.Proxy>() {
        public String getName() {
            return "device.mojom.FingerprintObserver";
        }

        public int getVersion() {
            return 0;
        }

        public FingerprintObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FingerprintObserver_Internal.Proxy(core, messageReceiver);
        }

        public FingerprintObserver_Internal.Stub buildStub(Core core, FingerprintObserver impl) {
            return new FingerprintObserver_Internal.Stub(core, impl);
        }

        public FingerprintObserver[] buildArray(int size) {
            return new FingerprintObserver[size];
        }
    };

    private static final int ON_RESTARTED_ORDINAL = 0;

    private static final int ON_ENROLL_SCAN_DONE_ORDINAL = 1;

    private static final int ON_AUTH_SCAN_DONE_ORDINAL = 2;

    private static final int ON_SESSION_FAILED_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements FingerprintObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onRestarted() {
            FingerprintObserver_Internal.FingerprintObserverOnRestartedParams _message = new FingerprintObserver_Internal.FingerprintObserverOnRestartedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onEnrollScanDone(int scanResult, boolean isComplete, int percentComplete) {
            FingerprintObserver_Internal.FingerprintObserverOnEnrollScanDoneParams _message = new FingerprintObserver_Internal.FingerprintObserverOnEnrollScanDoneParams();
            _message.scanResult = scanResult;
            _message.isComplete = isComplete;
            _message.percentComplete = percentComplete;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onAuthScanDone(int scanResult, Map<String, String[]> matches) {
            FingerprintObserver_Internal.FingerprintObserverOnAuthScanDoneParams _message = new FingerprintObserver_Internal.FingerprintObserverOnAuthScanDoneParams();
            _message.scanResult = scanResult;
            _message.matches = matches;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void onSessionFailed() {
            FingerprintObserver_Internal.FingerprintObserverOnSessionFailedParams _message = new FingerprintObserver_Internal.FingerprintObserverOnSessionFailedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<FingerprintObserver> {
        Stub(Core core, FingerprintObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                FingerprintObserver_Internal.FingerprintObserverOnEnrollScanDoneParams fingerprintObserverOnEnrollScanDoneParams;
                FingerprintObserver_Internal.FingerprintObserverOnAuthScanDoneParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FingerprintObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        FingerprintObserver_Internal.FingerprintObserverOnRestartedParams.deserialize(messageWithHeader.getPayload());
                        ((FingerprintObserver)getImpl()).onRestarted();
                        return true;
                    case 1:
                        fingerprintObserverOnEnrollScanDoneParams = FingerprintObserver_Internal.FingerprintObserverOnEnrollScanDoneParams.deserialize(messageWithHeader.getPayload());
                        ((FingerprintObserver)getImpl()).onEnrollScanDone(fingerprintObserverOnEnrollScanDoneParams.scanResult, fingerprintObserverOnEnrollScanDoneParams.isComplete, fingerprintObserverOnEnrollScanDoneParams.percentComplete);
                        return true;
                    case 2:
                        data = FingerprintObserver_Internal.FingerprintObserverOnAuthScanDoneParams.deserialize(messageWithHeader.getPayload());
                        ((FingerprintObserver)getImpl()).onAuthScanDone(data.scanResult, data.matches);
                        return true;
                    case 3:
                        FingerprintObserver_Internal.FingerprintObserverOnSessionFailedParams.deserialize(messageWithHeader.getPayload());
                        ((FingerprintObserver)getImpl()).onSessionFailed();
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
                                getCore(), FingerprintObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FingerprintObserverOnRestartedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FingerprintObserverOnRestartedParams(int version) {
            super(8, version);
        }

        public FingerprintObserverOnRestartedParams() {
            this(0);
        }

        public static FingerprintObserverOnRestartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintObserverOnRestartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintObserverOnRestartedParams decode(Decoder decoder0) {
            FingerprintObserverOnRestartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintObserverOnRestartedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FingerprintObserverOnEnrollScanDoneParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int scanResult;

        public boolean isComplete;

        public int percentComplete;

        private FingerprintObserverOnEnrollScanDoneParams(int version) {
            super(24, version);
        }

        public FingerprintObserverOnEnrollScanDoneParams() {
            this(0);
        }

        public static FingerprintObserverOnEnrollScanDoneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintObserverOnEnrollScanDoneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintObserverOnEnrollScanDoneParams decode(Decoder decoder0) {
            FingerprintObserverOnEnrollScanDoneParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintObserverOnEnrollScanDoneParams(elementsOrVersion);
                result.scanResult = decoder0.readInt(8);
                ScanResult.validate(result.scanResult);
                result.isComplete = decoder0.readBoolean(12, 0);
                result.percentComplete = decoder0.readInt(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.scanResult, 8);
            encoder0.encode(this.isComplete, 12, 0);
            encoder0.encode(this.percentComplete, 16);
        }
    }

    static final class FingerprintObserverOnAuthScanDoneParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int scanResult;

        public Map<String, String[]> matches;

        private FingerprintObserverOnAuthScanDoneParams(int version) {
            super(24, version);
        }

        public FingerprintObserverOnAuthScanDoneParams() {
            this(0);
        }

        public static FingerprintObserverOnAuthScanDoneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintObserverOnAuthScanDoneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintObserverOnAuthScanDoneParams decode(Decoder decoder0) {
            FingerprintObserverOnAuthScanDoneParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintObserverOnAuthScanDoneParams(elementsOrVersion);
                result.scanResult = decoder0.readInt(8);
                ScanResult.validate(result.scanResult);
                Decoder decoder1 = decoder0.readPointer(16, false);
                decoder1.readDataHeaderForMap();
                Decoder decoder2 = decoder1.readPointer(8, false);
                DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
                String[] keys0 = new String[si2.elementsOrVersion];
                int i2;
                for (i2 = 0; i2 < si2.elementsOrVersion; i2++)
                    keys0[i2] = decoder2.readString(8 + 8 * i2, false);
                decoder2 = decoder1.readPointer(16, false);
                si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
                String[][] values0 = new String[si2.elementsOrVersion][];
                for (i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                    Decoder decoder3 = decoder2.readPointer(8 + 8 * i2, false);
                    DataHeader si3 = decoder3.readDataHeaderForPointerArray(-1);
                    values0[i2] = new String[si3.elementsOrVersion];
                    for (int i3 = 0; i3 < si3.elementsOrVersion; i3++)
                        values0[i2][i3] = decoder3.readString(8 + 8 * i3, false);
                }
                result.matches = (Map)new HashMap<>();
                for (int index0 = 0; index0 < keys0.length; index0++)
                    result.matches.put(keys0[index0], values0[index0]);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.scanResult, 8);
            if (this.matches == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encoderForMap(16);
                int size0 = this.matches.size();
                String[] keys0 = new String[size0];
                String[][] values0 = new String[size0][];
                int index0 = 0;
                for (Map.Entry<String, String[]> entry0 : this.matches.entrySet()) {
                    keys0[index0] = entry0.getKey();
                    values0[index0] = entry0.getValue();
                    index0++;
                }
                Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
                int i1;
                for (i1 = 0; i1 < keys0.length; i1++)
                    encoder2.encode(keys0[i1], 8 + 8 * i1, false);
                encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
                for (i1 = 0; i1 < values0.length; i1++) {
                    if (values0[i1] == null) {
                        encoder2.encodeNullPointer(8 + 8 * i1, false);
                    } else {
                        Encoder encoder3 = encoder2.encodePointerArray((values0[i1]).length, 8 + 8 * i1, -1);
                        for (int i2 = 0; i2 < (values0[i1]).length; i2++)
                            encoder3.encode(values0[i1][i2], 8 + 8 * i2, false);
                    }
                }
            }
        }
    }

    static final class FingerprintObserverOnSessionFailedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FingerprintObserverOnSessionFailedParams(int version) {
            super(8, version);
        }

        public FingerprintObserverOnSessionFailedParams() {
            this(0);
        }

        public static FingerprintObserverOnSessionFailedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintObserverOnSessionFailedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintObserverOnSessionFailedParams decode(Decoder decoder0) {
            FingerprintObserverOnSessionFailedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintObserverOnSessionFailedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
