package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.WatchTimeRecorder;
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
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal.class */
class WatchTimeRecorder_Internal {
    public static final Interface.Manager<WatchTimeRecorder, WatchTimeRecorder.Proxy> MANAGER = new Interface.Manager<WatchTimeRecorder, WatchTimeRecorder.Proxy>() { // from class: org.chromium.media.mojom.WatchTimeRecorder_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.WatchTimeRecorder";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public WatchTimeRecorder.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, WatchTimeRecorder impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public WatchTimeRecorder[] buildArray(int size) {
            return new WatchTimeRecorder[size];
        }
    };
    private static final int RECORD_WATCH_TIME_ORDINAL = 0;
    private static final int FINALIZE_WATCH_TIME_ORDINAL = 1;
    private static final int ON_ERROR_ORDINAL = 2;
    private static final int UPDATE_SECONDARY_PROPERTIES_ORDINAL = 3;
    private static final int SET_AUTOPLAY_INITIATED_ORDINAL = 4;
    private static final int ON_DURATION_CHANGED_ORDINAL = 5;
    private static final int UPDATE_UNDERFLOW_COUNT_ORDINAL = 6;

    WatchTimeRecorder_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements WatchTimeRecorder.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.WatchTimeRecorder
        public void recordWatchTime(int key, TimeDelta watchTime) {
            WatchTimeRecorderRecordWatchTimeParams _message = new WatchTimeRecorderRecordWatchTimeParams();
            _message.key = key;
            _message.watchTime = watchTime;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media.mojom.WatchTimeRecorder
        public void finalizeWatchTime(int[] watchTimeKeys) {
            WatchTimeRecorderFinalizeWatchTimeParams _message = new WatchTimeRecorderFinalizeWatchTimeParams();
            _message.watchTimeKeys = watchTimeKeys;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.media.mojom.WatchTimeRecorder
        public void onError(int status) {
            WatchTimeRecorderOnErrorParams _message = new WatchTimeRecorderOnErrorParams();
            _message.status = status;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media.mojom.WatchTimeRecorder
        public void updateSecondaryProperties(SecondaryPlaybackProperties secondaryProperties) {
            WatchTimeRecorderUpdateSecondaryPropertiesParams _message = new WatchTimeRecorderUpdateSecondaryPropertiesParams();
            _message.secondaryProperties = secondaryProperties;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.media.mojom.WatchTimeRecorder
        public void setAutoplayInitiated(boolean value) {
            WatchTimeRecorderSetAutoplayInitiatedParams _message = new WatchTimeRecorderSetAutoplayInitiatedParams();
            _message.value = value;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.media.mojom.WatchTimeRecorder
        public void onDurationChanged(TimeDelta duration) {
            WatchTimeRecorderOnDurationChangedParams _message = new WatchTimeRecorderOnDurationChangedParams();
            _message.duration = duration;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.media.mojom.WatchTimeRecorder
        public void updateUnderflowCount(int count) {
            WatchTimeRecorderUpdateUnderflowCountParams _message = new WatchTimeRecorderUpdateUnderflowCountParams();
            _message.count = count;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<WatchTimeRecorder> {
        Stub(Core core, WatchTimeRecorder impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WatchTimeRecorder_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        WatchTimeRecorderRecordWatchTimeParams data = WatchTimeRecorderRecordWatchTimeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().recordWatchTime(data.key, data.watchTime);
                        return true;
                    case 1:
                        WatchTimeRecorderFinalizeWatchTimeParams data2 = WatchTimeRecorderFinalizeWatchTimeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().finalizeWatchTime(data2.watchTimeKeys);
                        return true;
                    case 2:
                        WatchTimeRecorderOnErrorParams data3 = WatchTimeRecorderOnErrorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onError(data3.status);
                        return true;
                    case 3:
                        WatchTimeRecorderUpdateSecondaryPropertiesParams data4 = WatchTimeRecorderUpdateSecondaryPropertiesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().updateSecondaryProperties(data4.secondaryProperties);
                        return true;
                    case 4:
                        WatchTimeRecorderSetAutoplayInitiatedParams data5 = WatchTimeRecorderSetAutoplayInitiatedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setAutoplayInitiated(data5.value);
                        return true;
                    case 5:
                        WatchTimeRecorderOnDurationChangedParams data6 = WatchTimeRecorderOnDurationChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onDurationChanged(data6.duration);
                        return true;
                    case 6:
                        WatchTimeRecorderUpdateUnderflowCountParams data7 = WatchTimeRecorderUpdateUnderflowCountParams.deserialize(messageWithHeader.getPayload());
                        getImpl().updateUnderflowCount(data7.count);
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), WatchTimeRecorder_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal$WatchTimeRecorderRecordWatchTimeParams.class */
    static final class WatchTimeRecorderRecordWatchTimeParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int key;
        public TimeDelta watchTime;

        private WatchTimeRecorderRecordWatchTimeParams(int version) {
            super(24, version);
        }

        public WatchTimeRecorderRecordWatchTimeParams() {
            this(0);
        }

        public static WatchTimeRecorderRecordWatchTimeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WatchTimeRecorderRecordWatchTimeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WatchTimeRecorderRecordWatchTimeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WatchTimeRecorderRecordWatchTimeParams result = new WatchTimeRecorderRecordWatchTimeParams(elementsOrVersion);
                result.key = decoder0.readInt(8);
                WatchTimeKey.validate(result.key);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.watchTime = TimeDelta.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.key, 8);
            encoder0.encode((Struct) this.watchTime, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal$WatchTimeRecorderFinalizeWatchTimeParams.class */
    static final class WatchTimeRecorderFinalizeWatchTimeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int[] watchTimeKeys;

        private WatchTimeRecorderFinalizeWatchTimeParams(int version) {
            super(16, version);
        }

        public WatchTimeRecorderFinalizeWatchTimeParams() {
            this(0);
        }

        public static WatchTimeRecorderFinalizeWatchTimeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WatchTimeRecorderFinalizeWatchTimeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WatchTimeRecorderFinalizeWatchTimeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WatchTimeRecorderFinalizeWatchTimeParams result = new WatchTimeRecorderFinalizeWatchTimeParams(elementsOrVersion);
                result.watchTimeKeys = decoder0.readInts(8, 0, -1);
                for (int i0 = 0; i0 < result.watchTimeKeys.length; i0++) {
                    WatchTimeKey.validate(result.watchTimeKeys[i0]);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.watchTimeKeys, 8, 0, -1);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal$WatchTimeRecorderOnErrorParams.class */
    static final class WatchTimeRecorderOnErrorParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private WatchTimeRecorderOnErrorParams(int version) {
            super(16, version);
        }

        public WatchTimeRecorderOnErrorParams() {
            this(0);
        }

        public static WatchTimeRecorderOnErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WatchTimeRecorderOnErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WatchTimeRecorderOnErrorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WatchTimeRecorderOnErrorParams result = new WatchTimeRecorderOnErrorParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PipelineStatus.validate(result.status);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal$WatchTimeRecorderUpdateSecondaryPropertiesParams.class */
    static final class WatchTimeRecorderUpdateSecondaryPropertiesParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SecondaryPlaybackProperties secondaryProperties;

        private WatchTimeRecorderUpdateSecondaryPropertiesParams(int version) {
            super(16, version);
        }

        public WatchTimeRecorderUpdateSecondaryPropertiesParams() {
            this(0);
        }

        public static WatchTimeRecorderUpdateSecondaryPropertiesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WatchTimeRecorderUpdateSecondaryPropertiesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WatchTimeRecorderUpdateSecondaryPropertiesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WatchTimeRecorderUpdateSecondaryPropertiesParams result = new WatchTimeRecorderUpdateSecondaryPropertiesParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.secondaryProperties = SecondaryPlaybackProperties.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.secondaryProperties, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal$WatchTimeRecorderSetAutoplayInitiatedParams.class */
    static final class WatchTimeRecorderSetAutoplayInitiatedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean value;

        private WatchTimeRecorderSetAutoplayInitiatedParams(int version) {
            super(16, version);
        }

        public WatchTimeRecorderSetAutoplayInitiatedParams() {
            this(0);
        }

        public static WatchTimeRecorderSetAutoplayInitiatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WatchTimeRecorderSetAutoplayInitiatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WatchTimeRecorderSetAutoplayInitiatedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WatchTimeRecorderSetAutoplayInitiatedParams result = new WatchTimeRecorderSetAutoplayInitiatedParams(elementsOrVersion);
                result.value = decoder0.readBoolean(8, 0);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.value, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal$WatchTimeRecorderOnDurationChangedParams.class */
    static final class WatchTimeRecorderOnDurationChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta duration;

        private WatchTimeRecorderOnDurationChangedParams(int version) {
            super(16, version);
        }

        public WatchTimeRecorderOnDurationChangedParams() {
            this(0);
        }

        public static WatchTimeRecorderOnDurationChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WatchTimeRecorderOnDurationChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WatchTimeRecorderOnDurationChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WatchTimeRecorderOnDurationChangedParams result = new WatchTimeRecorderOnDurationChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.duration = TimeDelta.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.duration, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder_Internal$WatchTimeRecorderUpdateUnderflowCountParams.class */
    static final class WatchTimeRecorderUpdateUnderflowCountParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int count;

        private WatchTimeRecorderUpdateUnderflowCountParams(int version) {
            super(16, version);
        }

        public WatchTimeRecorderUpdateUnderflowCountParams() {
            this(0);
        }

        public static WatchTimeRecorderUpdateUnderflowCountParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WatchTimeRecorderUpdateUnderflowCountParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WatchTimeRecorderUpdateUnderflowCountParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WatchTimeRecorderUpdateUnderflowCountParams result = new WatchTimeRecorderUpdateUnderflowCountParams(elementsOrVersion);
                result.count = decoder0.readInt(8);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.count, 8);
        }
    }
}
