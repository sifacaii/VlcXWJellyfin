package org.chromium.service_manager.mojom;

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
import org.chromium.service_manager.mojom.ServiceManagerListener;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener_Internal.class */
class ServiceManagerListener_Internal {
    public static final Interface.Manager<ServiceManagerListener, ServiceManagerListener.Proxy> MANAGER = new Interface.Manager<ServiceManagerListener, ServiceManagerListener.Proxy>() { // from class: org.chromium.service_manager.mojom.ServiceManagerListener_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "service_manager.mojom.ServiceManagerListener";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ServiceManagerListener.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ServiceManagerListener impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ServiceManagerListener[] buildArray(int size) {
            return new ServiceManagerListener[size];
        }
    };
    private static final int ON_INIT_ORDINAL = 0;
    private static final int ON_SERVICE_CREATED_ORDINAL = 1;
    private static final int ON_SERVICE_STARTED_ORDINAL = 2;
    private static final int ON_SERVICE_PID_RECEIVED_ORDINAL = 3;
    private static final int ON_SERVICE_FAILED_TO_START_ORDINAL = 4;
    private static final int ON_SERVICE_STOPPED_ORDINAL = 5;

    ServiceManagerListener_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ServiceManagerListener.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.service_manager.mojom.ServiceManagerListener
        public void onInit(RunningServiceInfo[] runningServices) {
            ServiceManagerListenerOnInitParams _message = new ServiceManagerListenerOnInitParams();
            _message.runningServices = runningServices;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.service_manager.mojom.ServiceManagerListener
        public void onServiceCreated(RunningServiceInfo service) {
            ServiceManagerListenerOnServiceCreatedParams _message = new ServiceManagerListenerOnServiceCreatedParams();
            _message.service = service;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.service_manager.mojom.ServiceManagerListener
        public void onServiceStarted(Identity identity, int pidDeprecated) {
            ServiceManagerListenerOnServiceStartedParams _message = new ServiceManagerListenerOnServiceStartedParams();
            _message.identity = identity;
            _message.pidDeprecated = pidDeprecated;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.service_manager.mojom.ServiceManagerListener
        public void onServicePidReceived(Identity identity, int pid) {
            ServiceManagerListenerOnServicePidReceivedParams _message = new ServiceManagerListenerOnServicePidReceivedParams();
            _message.identity = identity;
            _message.pid = pid;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.service_manager.mojom.ServiceManagerListener
        public void onServiceFailedToStart(Identity identity) {
            ServiceManagerListenerOnServiceFailedToStartParams _message = new ServiceManagerListenerOnServiceFailedToStartParams();
            _message.identity = identity;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.service_manager.mojom.ServiceManagerListener
        public void onServiceStopped(Identity identity) {
            ServiceManagerListenerOnServiceStoppedParams _message = new ServiceManagerListenerOnServiceStoppedParams();
            _message.identity = identity;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ServiceManagerListener> {
        Stub(Core core, ServiceManagerListener impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceManagerListener_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        ServiceManagerListenerOnInitParams data = ServiceManagerListenerOnInitParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onInit(data.runningServices);
                        return true;
                    case 1:
                        ServiceManagerListenerOnServiceCreatedParams data2 = ServiceManagerListenerOnServiceCreatedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onServiceCreated(data2.service);
                        return true;
                    case 2:
                        ServiceManagerListenerOnServiceStartedParams data3 = ServiceManagerListenerOnServiceStartedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onServiceStarted(data3.identity, data3.pidDeprecated);
                        return true;
                    case 3:
                        ServiceManagerListenerOnServicePidReceivedParams data4 = ServiceManagerListenerOnServicePidReceivedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onServicePidReceived(data4.identity, data4.pid);
                        return true;
                    case 4:
                        ServiceManagerListenerOnServiceFailedToStartParams data5 = ServiceManagerListenerOnServiceFailedToStartParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onServiceFailedToStart(data5.identity);
                        return true;
                    case 5:
                        ServiceManagerListenerOnServiceStoppedParams data6 = ServiceManagerListenerOnServiceStoppedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onServiceStopped(data6.identity);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ServiceManagerListener_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener_Internal$ServiceManagerListenerOnInitParams.class */
    static final class ServiceManagerListenerOnInitParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public RunningServiceInfo[] runningServices;

        private ServiceManagerListenerOnInitParams(int version) {
            super(16, version);
        }

        public ServiceManagerListenerOnInitParams() {
            this(0);
        }

        public static ServiceManagerListenerOnInitParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceManagerListenerOnInitParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceManagerListenerOnInitParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceManagerListenerOnInitParams result = new ServiceManagerListenerOnInitParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.runningServices = new RunningServiceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.runningServices[i1] = RunningServiceInfo.decode(decoder2);
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
            if (this.runningServices == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.runningServices.length, 8, -1);
            for (int i0 = 0; i0 < this.runningServices.length; i0++) {
                encoder1.encode((Struct) this.runningServices[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener_Internal$ServiceManagerListenerOnServiceCreatedParams.class */
    static final class ServiceManagerListenerOnServiceCreatedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public RunningServiceInfo service;

        private ServiceManagerListenerOnServiceCreatedParams(int version) {
            super(16, version);
        }

        public ServiceManagerListenerOnServiceCreatedParams() {
            this(0);
        }

        public static ServiceManagerListenerOnServiceCreatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceManagerListenerOnServiceCreatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceManagerListenerOnServiceCreatedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceManagerListenerOnServiceCreatedParams result = new ServiceManagerListenerOnServiceCreatedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.service = RunningServiceInfo.decode(decoder1);
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
            encoder0.encode((Struct) this.service, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener_Internal$ServiceManagerListenerOnServiceStartedParams.class */
    static final class ServiceManagerListenerOnServiceStartedParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Identity identity;
        public int pidDeprecated;

        private ServiceManagerListenerOnServiceStartedParams(int version) {
            super(24, version);
        }

        public ServiceManagerListenerOnServiceStartedParams() {
            this(0);
        }

        public static ServiceManagerListenerOnServiceStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceManagerListenerOnServiceStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceManagerListenerOnServiceStartedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceManagerListenerOnServiceStartedParams result = new ServiceManagerListenerOnServiceStartedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.identity = Identity.decode(decoder1);
                result.pidDeprecated = decoder0.readInt(16);
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
            encoder0.encode((Struct) this.identity, 8, false);
            encoder0.encode(this.pidDeprecated, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener_Internal$ServiceManagerListenerOnServicePidReceivedParams.class */
    static final class ServiceManagerListenerOnServicePidReceivedParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Identity identity;
        public int pid;

        private ServiceManagerListenerOnServicePidReceivedParams(int version) {
            super(24, version);
        }

        public ServiceManagerListenerOnServicePidReceivedParams() {
            this(0);
        }

        public static ServiceManagerListenerOnServicePidReceivedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceManagerListenerOnServicePidReceivedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceManagerListenerOnServicePidReceivedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceManagerListenerOnServicePidReceivedParams result = new ServiceManagerListenerOnServicePidReceivedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.identity = Identity.decode(decoder1);
                result.pid = decoder0.readInt(16);
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
            encoder0.encode((Struct) this.identity, 8, false);
            encoder0.encode(this.pid, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener_Internal$ServiceManagerListenerOnServiceFailedToStartParams.class */
    static final class ServiceManagerListenerOnServiceFailedToStartParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Identity identity;

        private ServiceManagerListenerOnServiceFailedToStartParams(int version) {
            super(16, version);
        }

        public ServiceManagerListenerOnServiceFailedToStartParams() {
            this(0);
        }

        public static ServiceManagerListenerOnServiceFailedToStartParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceManagerListenerOnServiceFailedToStartParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceManagerListenerOnServiceFailedToStartParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceManagerListenerOnServiceFailedToStartParams result = new ServiceManagerListenerOnServiceFailedToStartParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.identity = Identity.decode(decoder1);
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
            encoder0.encode((Struct) this.identity, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener_Internal$ServiceManagerListenerOnServiceStoppedParams.class */
    static final class ServiceManagerListenerOnServiceStoppedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Identity identity;

        private ServiceManagerListenerOnServiceStoppedParams(int version) {
            super(16, version);
        }

        public ServiceManagerListenerOnServiceStoppedParams() {
            this(0);
        }

        public static ServiceManagerListenerOnServiceStoppedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceManagerListenerOnServiceStoppedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceManagerListenerOnServiceStoppedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceManagerListenerOnServiceStoppedParams result = new ServiceManagerListenerOnServiceStoppedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.identity = Identity.decode(decoder1);
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
            encoder0.encode((Struct) this.identity, 8, false);
        }
    }
}
