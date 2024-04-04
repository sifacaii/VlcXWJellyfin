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
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

class ReportingServiceProxy_Internal {
    public static final Interface.Manager<ReportingServiceProxy, ReportingServiceProxy.Proxy> MANAGER = new Interface.Manager<ReportingServiceProxy, ReportingServiceProxy.Proxy>() {
        public String getName() {
            return "blink.mojom.ReportingServiceProxy";
        }

        public int getVersion() {
            return 0;
        }

        public ReportingServiceProxy_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ReportingServiceProxy_Internal.Proxy(core, messageReceiver);
        }

        public ReportingServiceProxy_Internal.Stub buildStub(Core core, ReportingServiceProxy impl) {
            return new ReportingServiceProxy_Internal.Stub(core, impl);
        }

        public ReportingServiceProxy[] buildArray(int size) {
            return new ReportingServiceProxy[size];
        }
    };

    private static final int QUEUE_INTERVENTION_REPORT_ORDINAL = 0;

    private static final int QUEUE_DEPRECATION_REPORT_ORDINAL = 1;

    private static final int QUEUE_CSP_VIOLATION_REPORT_ORDINAL = 2;

    private static final int QUEUE_FEATURE_POLICY_VIOLATION_REPORT_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements ReportingServiceProxy.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void queueInterventionReport(Url url, String id, String message, String sourceFile, int lineNumber, int columnNumber) {
            ReportingServiceProxy_Internal.ReportingServiceProxyQueueInterventionReportParams _message = new ReportingServiceProxy_Internal.ReportingServiceProxyQueueInterventionReportParams();
            _message.url = url;
            _message.id = id;
            _message.message = message;
            _message.sourceFile = sourceFile;
            _message.lineNumber = lineNumber;
            _message.columnNumber = columnNumber;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void queueDeprecationReport(Url url, String id, Time anticipatedRemoval, String message, String sourceFile, int lineNumber, int columnNumber) {
            ReportingServiceProxy_Internal.ReportingServiceProxyQueueDeprecationReportParams _message = new ReportingServiceProxy_Internal.ReportingServiceProxyQueueDeprecationReportParams();
            _message.url = url;
            _message.id = id;
            _message.anticipatedRemoval = anticipatedRemoval;
            _message.message = message;
            _message.sourceFile = sourceFile;
            _message.lineNumber = lineNumber;
            _message.columnNumber = columnNumber;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void queueCspViolationReport(Url url, String group, String documentUrl, String referrer, String blockedUrl, String effectiveDirective, String originalPolicy, String sourceFile, String scriptSample, String disposition, short statusCode, int lineNumber, int columnNumber) {
            ReportingServiceProxy_Internal.ReportingServiceProxyQueueCspViolationReportParams _message = new ReportingServiceProxy_Internal.ReportingServiceProxyQueueCspViolationReportParams();
            _message.url = url;
            _message.group = group;
            _message.documentUrl = documentUrl;
            _message.referrer = referrer;
            _message.blockedUrl = blockedUrl;
            _message.effectiveDirective = effectiveDirective;
            _message.originalPolicy = originalPolicy;
            _message.sourceFile = sourceFile;
            _message.scriptSample = scriptSample;
            _message.disposition = disposition;
            _message.statusCode = statusCode;
            _message.lineNumber = lineNumber;
            _message.columnNumber = columnNumber;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void queueFeaturePolicyViolationReport(Url url, String policyId, String disposition, String message, String sourceFile, int lineNumber, int columnNumber) {
            ReportingServiceProxy_Internal.ReportingServiceProxyQueueFeaturePolicyViolationReportParams _message = new ReportingServiceProxy_Internal.ReportingServiceProxyQueueFeaturePolicyViolationReportParams();
            _message.url = url;
            _message.policyId = policyId;
            _message.disposition = disposition;
            _message.message = message;
            _message.sourceFile = sourceFile;
            _message.lineNumber = lineNumber;
            _message.columnNumber = columnNumber;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<ReportingServiceProxy> {
        Stub(Core core, ReportingServiceProxy impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ReportingServiceProxy_Internal.ReportingServiceProxyQueueInterventionReportParams reportingServiceProxyQueueInterventionReportParams;
                ReportingServiceProxy_Internal.ReportingServiceProxyQueueDeprecationReportParams reportingServiceProxyQueueDeprecationReportParams;
                ReportingServiceProxy_Internal.ReportingServiceProxyQueueCspViolationReportParams reportingServiceProxyQueueCspViolationReportParams;
                ReportingServiceProxy_Internal.ReportingServiceProxyQueueFeaturePolicyViolationReportParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ReportingServiceProxy_Internal.MANAGER, messageWithHeader);
                    case 0:
                        reportingServiceProxyQueueInterventionReportParams = ReportingServiceProxy_Internal.ReportingServiceProxyQueueInterventionReportParams.deserialize(messageWithHeader.getPayload());
                        ((ReportingServiceProxy)getImpl()).queueInterventionReport(reportingServiceProxyQueueInterventionReportParams.url, reportingServiceProxyQueueInterventionReportParams.id, reportingServiceProxyQueueInterventionReportParams.message, reportingServiceProxyQueueInterventionReportParams.sourceFile, reportingServiceProxyQueueInterventionReportParams.lineNumber, reportingServiceProxyQueueInterventionReportParams.columnNumber);
                        return true;
                    case 1:
                        reportingServiceProxyQueueDeprecationReportParams = ReportingServiceProxy_Internal.ReportingServiceProxyQueueDeprecationReportParams.deserialize(messageWithHeader.getPayload());
                        ((ReportingServiceProxy)getImpl()).queueDeprecationReport(reportingServiceProxyQueueDeprecationReportParams.url, reportingServiceProxyQueueDeprecationReportParams.id, reportingServiceProxyQueueDeprecationReportParams.anticipatedRemoval, reportingServiceProxyQueueDeprecationReportParams.message, reportingServiceProxyQueueDeprecationReportParams.sourceFile, reportingServiceProxyQueueDeprecationReportParams.lineNumber, reportingServiceProxyQueueDeprecationReportParams.columnNumber);
                        return true;
                    case 2:
                        reportingServiceProxyQueueCspViolationReportParams = ReportingServiceProxy_Internal.ReportingServiceProxyQueueCspViolationReportParams.deserialize(messageWithHeader.getPayload());
                        ((ReportingServiceProxy)getImpl()).queueCspViolationReport(reportingServiceProxyQueueCspViolationReportParams.url, reportingServiceProxyQueueCspViolationReportParams.group, reportingServiceProxyQueueCspViolationReportParams.documentUrl, reportingServiceProxyQueueCspViolationReportParams.referrer, reportingServiceProxyQueueCspViolationReportParams.blockedUrl, reportingServiceProxyQueueCspViolationReportParams.effectiveDirective, reportingServiceProxyQueueCspViolationReportParams.originalPolicy, reportingServiceProxyQueueCspViolationReportParams.sourceFile, reportingServiceProxyQueueCspViolationReportParams.scriptSample, reportingServiceProxyQueueCspViolationReportParams.disposition, reportingServiceProxyQueueCspViolationReportParams.statusCode, reportingServiceProxyQueueCspViolationReportParams.lineNumber, reportingServiceProxyQueueCspViolationReportParams.columnNumber);
                        return true;
                    case 3:
                        data = ReportingServiceProxy_Internal.ReportingServiceProxyQueueFeaturePolicyViolationReportParams.deserialize(messageWithHeader.getPayload());
                        ((ReportingServiceProxy)getImpl()).queueFeaturePolicyViolationReport(data.url, data.policyId, data.disposition, data.message, data.sourceFile, data.lineNumber, data.columnNumber);
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
                                getCore(), ReportingServiceProxy_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ReportingServiceProxyQueueInterventionReportParams extends Struct {
        private static final int STRUCT_SIZE = 48;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(48, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public String id;

        public String message;

        public String sourceFile;

        public int lineNumber;

        public int columnNumber;

        private ReportingServiceProxyQueueInterventionReportParams(int version) {
            super(48, version);
        }

        public ReportingServiceProxyQueueInterventionReportParams() {
            this(0);
        }

        public static ReportingServiceProxyQueueInterventionReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ReportingServiceProxyQueueInterventionReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ReportingServiceProxyQueueInterventionReportParams decode(Decoder decoder0) {
            ReportingServiceProxyQueueInterventionReportParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ReportingServiceProxyQueueInterventionReportParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.id = decoder0.readString(16, false);
                result.message = decoder0.readString(24, false);
                result.sourceFile = decoder0.readString(32, true);
                result.lineNumber = decoder0.readInt(40);
                result.columnNumber = decoder0.readInt(44);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.id, 16, false);
            encoder0.encode(this.message, 24, false);
            encoder0.encode(this.sourceFile, 32, true);
            encoder0.encode(this.lineNumber, 40);
            encoder0.encode(this.columnNumber, 44);
        }
    }

    static final class ReportingServiceProxyQueueDeprecationReportParams extends Struct {
        private static final int STRUCT_SIZE = 56;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(56, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public String id;

        public Time anticipatedRemoval;

        public String message;

        public String sourceFile;

        public int lineNumber;

        public int columnNumber;

        private ReportingServiceProxyQueueDeprecationReportParams(int version) {
            super(56, version);
        }

        public ReportingServiceProxyQueueDeprecationReportParams() {
            this(0);
        }

        public static ReportingServiceProxyQueueDeprecationReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ReportingServiceProxyQueueDeprecationReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ReportingServiceProxyQueueDeprecationReportParams decode(Decoder decoder0) {
            ReportingServiceProxyQueueDeprecationReportParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ReportingServiceProxyQueueDeprecationReportParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.id = decoder0.readString(16, false);
                decoder1 = decoder0.readPointer(24, true);
                result.anticipatedRemoval = Time.decode(decoder1);
                result.message = decoder0.readString(32, false);
                result.sourceFile = decoder0.readString(40, true);
                result.lineNumber = decoder0.readInt(48);
                result.columnNumber = decoder0.readInt(52);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.id, 16, false);
            encoder0.encode((Struct)this.anticipatedRemoval, 24, true);
            encoder0.encode(this.message, 32, false);
            encoder0.encode(this.sourceFile, 40, true);
            encoder0.encode(this.lineNumber, 48);
            encoder0.encode(this.columnNumber, 52);
        }
    }

    static final class ReportingServiceProxyQueueCspViolationReportParams extends Struct {
        private static final int STRUCT_SIZE = 104;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(104, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public String group;

        public String documentUrl;

        public String referrer;

        public String blockedUrl;

        public String effectiveDirective;

        public String originalPolicy;

        public String sourceFile;

        public String scriptSample;

        public String disposition;

        public short statusCode;

        public int lineNumber;

        public int columnNumber;

        private ReportingServiceProxyQueueCspViolationReportParams(int version) {
            super(104, version);
        }

        public ReportingServiceProxyQueueCspViolationReportParams() {
            this(0);
        }

        public static ReportingServiceProxyQueueCspViolationReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ReportingServiceProxyQueueCspViolationReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ReportingServiceProxyQueueCspViolationReportParams decode(Decoder decoder0) {
            ReportingServiceProxyQueueCspViolationReportParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ReportingServiceProxyQueueCspViolationReportParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.group = decoder0.readString(16, false);
                result.documentUrl = decoder0.readString(24, false);
                result.referrer = decoder0.readString(32, true);
                result.blockedUrl = decoder0.readString(40, true);
                result.effectiveDirective = decoder0.readString(48, false);
                result.originalPolicy = decoder0.readString(56, false);
                result.sourceFile = decoder0.readString(64, true);
                result.scriptSample = decoder0.readString(72, true);
                result.disposition = decoder0.readString(80, false);
                result.statusCode = decoder0.readShort(88);
                result.lineNumber = decoder0.readInt(92);
                result.columnNumber = decoder0.readInt(96);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.group, 16, false);
            encoder0.encode(this.documentUrl, 24, false);
            encoder0.encode(this.referrer, 32, true);
            encoder0.encode(this.blockedUrl, 40, true);
            encoder0.encode(this.effectiveDirective, 48, false);
            encoder0.encode(this.originalPolicy, 56, false);
            encoder0.encode(this.sourceFile, 64, true);
            encoder0.encode(this.scriptSample, 72, true);
            encoder0.encode(this.disposition, 80, false);
            encoder0.encode(this.statusCode, 88);
            encoder0.encode(this.lineNumber, 92);
            encoder0.encode(this.columnNumber, 96);
        }
    }

    static final class ReportingServiceProxyQueueFeaturePolicyViolationReportParams extends Struct {
        private static final int STRUCT_SIZE = 56;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(56, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public String policyId;

        public String disposition;

        public String message;

        public String sourceFile;

        public int lineNumber;

        public int columnNumber;

        private ReportingServiceProxyQueueFeaturePolicyViolationReportParams(int version) {
            super(56, version);
        }

        public ReportingServiceProxyQueueFeaturePolicyViolationReportParams() {
            this(0);
        }

        public static ReportingServiceProxyQueueFeaturePolicyViolationReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ReportingServiceProxyQueueFeaturePolicyViolationReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ReportingServiceProxyQueueFeaturePolicyViolationReportParams decode(Decoder decoder0) {
            ReportingServiceProxyQueueFeaturePolicyViolationReportParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ReportingServiceProxyQueueFeaturePolicyViolationReportParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.policyId = decoder0.readString(16, false);
                result.disposition = decoder0.readString(24, false);
                result.message = decoder0.readString(32, true);
                result.sourceFile = decoder0.readString(40, true);
                result.lineNumber = decoder0.readInt(48);
                result.columnNumber = decoder0.readInt(52);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.policyId, 16, false);
            encoder0.encode(this.disposition, 24, false);
            encoder0.encode(this.message, 32, true);
            encoder0.encode(this.sourceFile, 40, true);
            encoder0.encode(this.lineNumber, 48);
            encoder0.encode(this.columnNumber, 52);
        }
    }
}
