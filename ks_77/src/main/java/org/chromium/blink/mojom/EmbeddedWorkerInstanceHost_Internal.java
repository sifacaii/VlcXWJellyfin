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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

class EmbeddedWorkerInstanceHost_Internal {
    public static final Interface.Manager<EmbeddedWorkerInstanceHost, EmbeddedWorkerInstanceHost.Proxy> MANAGER = new Interface.Manager<EmbeddedWorkerInstanceHost, EmbeddedWorkerInstanceHost.Proxy>() {
        public String getName() {
            return "blink.mojom.EmbeddedWorkerInstanceHost";
        }

        public int getVersion() {
            return 0;
        }

        public EmbeddedWorkerInstanceHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new EmbeddedWorkerInstanceHost_Internal.Proxy(core, messageReceiver);
        }

        public EmbeddedWorkerInstanceHost_Internal.Stub buildStub(Core core, EmbeddedWorkerInstanceHost impl) {
            return new EmbeddedWorkerInstanceHost_Internal.Stub(core, impl);
        }

        public EmbeddedWorkerInstanceHost[] buildArray(int size) {
            return new EmbeddedWorkerInstanceHost[size];
        }
    };

    private static final int REQUEST_TERMINATION_ORDINAL = 0;

    private static final int COUNT_FEATURE_ORDINAL = 1;

    private static final int ON_READY_FOR_INSPECTION_ORDINAL = 2;

    private static final int ON_SCRIPT_LOADED_ORDINAL = 3;

    private static final int ON_SCRIPT_EVALUATION_START_ORDINAL = 4;

    private static final int ON_STARTED_ORDINAL = 5;

    private static final int ON_REPORT_EXCEPTION_ORDINAL = 6;

    private static final int ON_REPORT_CONSOLE_MESSAGE_ORDINAL = 7;

    private static final int ON_STOPPED_ORDINAL = 8;

    static final class Proxy extends Interface.AbstractProxy implements EmbeddedWorkerInstanceHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void requestTermination(EmbeddedWorkerInstanceHost.RequestTerminationResponse callback) {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostRequestTerminationParams _message = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostRequestTerminationParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostRequestTerminationResponseParamsForwardToCallback(callback));
        }

        public void countFeature(int feature) {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostCountFeatureParams _message = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostCountFeatureParams();
            _message.feature = feature;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onReadyForInspection() {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReadyForInspectionParams _message = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReadyForInspectionParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void onScriptLoaded() {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnScriptLoadedParams _message = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnScriptLoadedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void onScriptEvaluationStart() {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams _message = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void onStarted(int status, int threadId, EmbeddedWorkerStartTiming startTiming) {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnStartedParams _message = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnStartedParams();
            _message.status = status;
            _message.threadId = threadId;
            _message.startTiming = startTiming;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }

        public void onReportException(String16 errorMessage, int lineNumber, int columnNumber, Url sourceUrl) {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReportExceptionParams _message = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReportExceptionParams();
            _message.errorMessage = errorMessage;
            _message.lineNumber = lineNumber;
            _message.columnNumber = columnNumber;
            _message.sourceUrl = sourceUrl;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }

        public void onReportConsoleMessage(int source, int messageLevel, String16 message, int lineNumber, Url sourceUrl) {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReportConsoleMessageParams _message = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReportConsoleMessageParams();
            _message.source = source;
            _message.messageLevel = messageLevel;
            _message.message = message;
            _message.lineNumber = lineNumber;
            _message.sourceUrl = sourceUrl;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7)));
        }

        public void onStopped() {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnStoppedParams _message = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnStoppedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8)));
        }
    }

    static final class Stub extends Interface.Stub<EmbeddedWorkerInstanceHost> {
        Stub(Core core, EmbeddedWorkerInstanceHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostCountFeatureParams embeddedWorkerInstanceHostCountFeatureParams;
                EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnStartedParams embeddedWorkerInstanceHostOnStartedParams;
                EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReportExceptionParams embeddedWorkerInstanceHostOnReportExceptionParams;
                EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReportConsoleMessageParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(EmbeddedWorkerInstanceHost_Internal.MANAGER, messageWithHeader);
                    case 1:
                        embeddedWorkerInstanceHostCountFeatureParams = EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostCountFeatureParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceHost)getImpl()).countFeature(embeddedWorkerInstanceHostCountFeatureParams.feature);
                        return true;
                    case 2:
                        EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReadyForInspectionParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceHost)getImpl()).onReadyForInspection();
                        return true;
                    case 3:
                        EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnScriptLoadedParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceHost)getImpl()).onScriptLoaded();
                        return true;
                    case 4:
                        EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceHost)getImpl()).onScriptEvaluationStart();
                        return true;
                    case 5:
                        embeddedWorkerInstanceHostOnStartedParams = EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnStartedParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceHost)getImpl()).onStarted(embeddedWorkerInstanceHostOnStartedParams.status, embeddedWorkerInstanceHostOnStartedParams.threadId, embeddedWorkerInstanceHostOnStartedParams.startTiming);
                        return true;
                    case 6:
                        embeddedWorkerInstanceHostOnReportExceptionParams = EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReportExceptionParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceHost)getImpl()).onReportException(embeddedWorkerInstanceHostOnReportExceptionParams.errorMessage, embeddedWorkerInstanceHostOnReportExceptionParams.lineNumber, embeddedWorkerInstanceHostOnReportExceptionParams.columnNumber, embeddedWorkerInstanceHostOnReportExceptionParams.sourceUrl);
                        return true;
                    case 7:
                        data = EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnReportConsoleMessageParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceHost)getImpl()).onReportConsoleMessage(data.source, data.messageLevel, data.message, data.lineNumber, data.sourceUrl);
                        return true;
                    case 8:
                        EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostOnStoppedParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceHost)getImpl()).onStopped();
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
                                getCore(), EmbeddedWorkerInstanceHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostRequestTerminationParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceHost)getImpl()).requestTermination(new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostRequestTerminationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class EmbeddedWorkerInstanceHostRequestTerminationParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private EmbeddedWorkerInstanceHostRequestTerminationParams(int version) {
            super(8, version);
        }

        public EmbeddedWorkerInstanceHostRequestTerminationParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostRequestTerminationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostRequestTerminationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostRequestTerminationParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostRequestTerminationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostRequestTerminationParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class EmbeddedWorkerInstanceHostRequestTerminationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean willBeTerminated;

        private EmbeddedWorkerInstanceHostRequestTerminationResponseParams(int version) {
            super(16, version);
        }

        public EmbeddedWorkerInstanceHostRequestTerminationResponseParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostRequestTerminationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostRequestTerminationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostRequestTerminationResponseParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostRequestTerminationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostRequestTerminationResponseParams(elementsOrVersion);
                result.willBeTerminated = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.willBeTerminated, 8, 0);
        }
    }

    static class EmbeddedWorkerInstanceHostRequestTerminationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final EmbeddedWorkerInstanceHost.RequestTerminationResponse mCallback;

        EmbeddedWorkerInstanceHostRequestTerminationResponseParamsForwardToCallback(EmbeddedWorkerInstanceHost.RequestTerminationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostRequestTerminationResponseParams response = EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostRequestTerminationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.willBeTerminated));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class EmbeddedWorkerInstanceHostRequestTerminationResponseParamsProxyToResponder implements EmbeddedWorkerInstanceHost.RequestTerminationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        EmbeddedWorkerInstanceHostRequestTerminationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean willBeTerminated) {
            EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostRequestTerminationResponseParams _response = new EmbeddedWorkerInstanceHost_Internal.EmbeddedWorkerInstanceHostRequestTerminationResponseParams();
            _response.willBeTerminated = willBeTerminated.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class EmbeddedWorkerInstanceHostCountFeatureParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int feature;

        private EmbeddedWorkerInstanceHostCountFeatureParams(int version) {
            super(16, version);
        }

        public EmbeddedWorkerInstanceHostCountFeatureParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostCountFeatureParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostCountFeatureParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostCountFeatureParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostCountFeatureParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostCountFeatureParams(elementsOrVersion);
                result.feature = decoder0.readInt(8);
                WebFeature.validate(result.feature);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.feature, 8);
        }
    }

    static final class EmbeddedWorkerInstanceHostOnReadyForInspectionParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private EmbeddedWorkerInstanceHostOnReadyForInspectionParams(int version) {
            super(8, version);
        }

        public EmbeddedWorkerInstanceHostOnReadyForInspectionParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostOnReadyForInspectionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostOnReadyForInspectionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostOnReadyForInspectionParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostOnReadyForInspectionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostOnReadyForInspectionParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class EmbeddedWorkerInstanceHostOnScriptLoadedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private EmbeddedWorkerInstanceHostOnScriptLoadedParams(int version) {
            super(8, version);
        }

        public EmbeddedWorkerInstanceHostOnScriptLoadedParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostOnScriptLoadedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostOnScriptLoadedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostOnScriptLoadedParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostOnScriptLoadedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostOnScriptLoadedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams(int version) {
            super(8, version);
        }

        public EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostOnScriptEvaluationStartParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class EmbeddedWorkerInstanceHostOnStartedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public int threadId;

        public EmbeddedWorkerStartTiming startTiming;

        private EmbeddedWorkerInstanceHostOnStartedParams(int version) {
            super(24, version);
        }

        public EmbeddedWorkerInstanceHostOnStartedParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostOnStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostOnStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostOnStartedParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostOnStartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostOnStartedParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerStartStatus.validate(result.status);
                result.threadId = decoder0.readInt(12);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.startTiming = EmbeddedWorkerStartTiming.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.threadId, 12);
            encoder0.encode(this.startTiming, 16, false);
        }
    }

    static final class EmbeddedWorkerInstanceHostOnReportExceptionParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16 errorMessage;

        public int lineNumber;

        public int columnNumber;

        public Url sourceUrl;

        private EmbeddedWorkerInstanceHostOnReportExceptionParams(int version) {
            super(32, version);
        }

        public EmbeddedWorkerInstanceHostOnReportExceptionParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostOnReportExceptionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostOnReportExceptionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostOnReportExceptionParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostOnReportExceptionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostOnReportExceptionParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.errorMessage = String16.decode(decoder1);
                result.lineNumber = decoder0.readInt(16);
                result.columnNumber = decoder0.readInt(20);
                decoder1 = decoder0.readPointer(24, false);
                result.sourceUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.errorMessage, 8, false);
            encoder0.encode(this.lineNumber, 16);
            encoder0.encode(this.columnNumber, 20);
            encoder0.encode((Struct)this.sourceUrl, 24, false);
        }
    }

    static final class EmbeddedWorkerInstanceHostOnReportConsoleMessageParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int source;

        public int messageLevel;

        public String16 message;

        public int lineNumber;

        public Url sourceUrl;

        private EmbeddedWorkerInstanceHostOnReportConsoleMessageParams(int version) {
            super(40, version);
        }

        public EmbeddedWorkerInstanceHostOnReportConsoleMessageParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostOnReportConsoleMessageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostOnReportConsoleMessageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostOnReportConsoleMessageParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostOnReportConsoleMessageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostOnReportConsoleMessageParams(elementsOrVersion);
                result.source = decoder0.readInt(8);
                ConsoleMessageSource.validate(result.source);
                result.messageLevel = decoder0.readInt(12);
                ConsoleMessageLevel.validate(result.messageLevel);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.message = String16.decode(decoder1);
                result.lineNumber = decoder0.readInt(24);
                decoder1 = decoder0.readPointer(32, false);
                result.sourceUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.source, 8);
            encoder0.encode(this.messageLevel, 12);
            encoder0.encode((Struct)this.message, 16, false);
            encoder0.encode(this.lineNumber, 24);
            encoder0.encode((Struct)this.sourceUrl, 32, false);
        }
    }

    static final class EmbeddedWorkerInstanceHostOnStoppedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private EmbeddedWorkerInstanceHostOnStoppedParams(int version) {
            super(8, version);
        }

        public EmbeddedWorkerInstanceHostOnStoppedParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceHostOnStoppedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceHostOnStoppedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceHostOnStoppedParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceHostOnStoppedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceHostOnStoppedParams(elementsOrVersion);
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
