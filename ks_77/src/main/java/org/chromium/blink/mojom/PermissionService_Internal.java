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

class PermissionService_Internal {
    public static final Interface.Manager<PermissionService, PermissionService.Proxy> MANAGER = new Interface.Manager<PermissionService, PermissionService.Proxy>() {
        public String getName() {
            return "blink.mojom.PermissionService";
        }

        public int getVersion() {
            return 0;
        }

        public PermissionService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PermissionService_Internal.Proxy(core, messageReceiver);
        }

        public PermissionService_Internal.Stub buildStub(Core core, PermissionService impl) {
            return new PermissionService_Internal.Stub(core, impl);
        }

        public PermissionService[] buildArray(int size) {
            return new PermissionService[size];
        }
    };

    private static final int HAS_PERMISSION_ORDINAL = 0;

    private static final int REQUEST_PERMISSION_ORDINAL = 1;

    private static final int REQUEST_PERMISSIONS_ORDINAL = 2;

    private static final int REVOKE_PERMISSION_ORDINAL = 3;

    private static final int ADD_PERMISSION_OBSERVER_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements PermissionService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void hasPermission(PermissionDescriptor permission, PermissionService.HasPermissionResponse callback) {
            PermissionService_Internal.PermissionServiceHasPermissionParams _message = new PermissionService_Internal.PermissionServiceHasPermissionParams();
            _message.permission = permission;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new PermissionService_Internal.PermissionServiceHasPermissionResponseParamsForwardToCallback(callback));
        }

        public void requestPermission(PermissionDescriptor permission, boolean userGesture, PermissionService.RequestPermissionResponse callback) {
            PermissionService_Internal.PermissionServiceRequestPermissionParams _message = new PermissionService_Internal.PermissionServiceRequestPermissionParams();
            _message.permission = permission;
            _message.userGesture = userGesture;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new PermissionService_Internal.PermissionServiceRequestPermissionResponseParamsForwardToCallback(callback));
        }

        public void requestPermissions(PermissionDescriptor[] permission, boolean userGesture, PermissionService.RequestPermissionsResponse callback) {
            PermissionService_Internal.PermissionServiceRequestPermissionsParams _message = new PermissionService_Internal.PermissionServiceRequestPermissionsParams();
            _message.permission = permission;
            _message.userGesture = userGesture;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new PermissionService_Internal.PermissionServiceRequestPermissionsResponseParamsForwardToCallback(callback));
        }

        public void revokePermission(PermissionDescriptor permission, PermissionService.RevokePermissionResponse callback) {
            PermissionService_Internal.PermissionServiceRevokePermissionParams _message = new PermissionService_Internal.PermissionServiceRevokePermissionParams();
            _message.permission = permission;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new PermissionService_Internal.PermissionServiceRevokePermissionResponseParamsForwardToCallback(callback));
        }

        public void addPermissionObserver(PermissionDescriptor permission, int lastKnownStatus, PermissionObserver observer) {
            PermissionService_Internal.PermissionServiceAddPermissionObserverParams _message = new PermissionService_Internal.PermissionServiceAddPermissionObserverParams();
            _message.permission = permission;
            _message.lastKnownStatus = lastKnownStatus;
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    static final class Stub extends Interface.Stub<PermissionService> {
        Stub(Core core, PermissionService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PermissionService_Internal.PermissionServiceAddPermissionObserverParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PermissionService_Internal.MANAGER, messageWithHeader);
                    case 4:
                        data = PermissionService_Internal.PermissionServiceAddPermissionObserverParams.deserialize(messageWithHeader.getPayload());
                        ((PermissionService)getImpl()).addPermissionObserver(data.permission, data.lastKnownStatus, data.observer);
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
                PermissionService_Internal.PermissionServiceHasPermissionParams permissionServiceHasPermissionParams;
                PermissionService_Internal.PermissionServiceRequestPermissionParams permissionServiceRequestPermissionParams;
                PermissionService_Internal.PermissionServiceRequestPermissionsParams permissionServiceRequestPermissionsParams;
                PermissionService_Internal.PermissionServiceRevokePermissionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), PermissionService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        permissionServiceHasPermissionParams = PermissionService_Internal.PermissionServiceHasPermissionParams.deserialize(messageWithHeader.getPayload());
                        ((PermissionService)getImpl()).hasPermission(permissionServiceHasPermissionParams.permission, new PermissionService_Internal.PermissionServiceHasPermissionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        permissionServiceRequestPermissionParams = PermissionService_Internal.PermissionServiceRequestPermissionParams.deserialize(messageWithHeader.getPayload());
                        ((PermissionService)getImpl()).requestPermission(permissionServiceRequestPermissionParams.permission, permissionServiceRequestPermissionParams.userGesture, new PermissionService_Internal.PermissionServiceRequestPermissionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        permissionServiceRequestPermissionsParams = PermissionService_Internal.PermissionServiceRequestPermissionsParams.deserialize(messageWithHeader.getPayload());
                        ((PermissionService)getImpl()).requestPermissions(permissionServiceRequestPermissionsParams.permission, permissionServiceRequestPermissionsParams.userGesture, new PermissionService_Internal.PermissionServiceRequestPermissionsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        data = PermissionService_Internal.PermissionServiceRevokePermissionParams.deserialize(messageWithHeader.getPayload());
                        ((PermissionService)getImpl()).revokePermission(data.permission, new PermissionService_Internal.PermissionServiceRevokePermissionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PermissionServiceHasPermissionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PermissionDescriptor permission;

        private PermissionServiceHasPermissionParams(int version) {
            super(16, version);
        }

        public PermissionServiceHasPermissionParams() {
            this(0);
        }

        public static PermissionServiceHasPermissionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionServiceHasPermissionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionServiceHasPermissionParams decode(Decoder decoder0) {
            PermissionServiceHasPermissionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionServiceHasPermissionParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.permission = PermissionDescriptor.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.permission, 8, false);
        }
    }

    static final class PermissionServiceHasPermissionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private PermissionServiceHasPermissionResponseParams(int version) {
            super(16, version);
        }

        public PermissionServiceHasPermissionResponseParams() {
            this(0);
        }

        public static PermissionServiceHasPermissionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionServiceHasPermissionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionServiceHasPermissionResponseParams decode(Decoder decoder0) {
            PermissionServiceHasPermissionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionServiceHasPermissionResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PermissionStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class PermissionServiceHasPermissionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PermissionService.HasPermissionResponse mCallback;

        PermissionServiceHasPermissionResponseParamsForwardToCallback(PermissionService.HasPermissionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                PermissionService_Internal.PermissionServiceHasPermissionResponseParams response = PermissionService_Internal.PermissionServiceHasPermissionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PermissionServiceHasPermissionResponseParamsProxyToResponder implements PermissionService.HasPermissionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PermissionServiceHasPermissionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            PermissionService_Internal.PermissionServiceHasPermissionResponseParams _response = new PermissionService_Internal.PermissionServiceHasPermissionResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PermissionServiceRequestPermissionParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PermissionDescriptor permission;

        public boolean userGesture;

        private PermissionServiceRequestPermissionParams(int version) {
            super(24, version);
        }

        public PermissionServiceRequestPermissionParams() {
            this(0);
        }

        public static PermissionServiceRequestPermissionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionServiceRequestPermissionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionServiceRequestPermissionParams decode(Decoder decoder0) {
            PermissionServiceRequestPermissionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionServiceRequestPermissionParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.permission = PermissionDescriptor.decode(decoder1);
                result.userGesture = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.permission, 8, false);
            encoder0.encode(this.userGesture, 16, 0);
        }
    }

    static final class PermissionServiceRequestPermissionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private PermissionServiceRequestPermissionResponseParams(int version) {
            super(16, version);
        }

        public PermissionServiceRequestPermissionResponseParams() {
            this(0);
        }

        public static PermissionServiceRequestPermissionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionServiceRequestPermissionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionServiceRequestPermissionResponseParams decode(Decoder decoder0) {
            PermissionServiceRequestPermissionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionServiceRequestPermissionResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PermissionStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class PermissionServiceRequestPermissionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PermissionService.RequestPermissionResponse mCallback;

        PermissionServiceRequestPermissionResponseParamsForwardToCallback(PermissionService.RequestPermissionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                PermissionService_Internal.PermissionServiceRequestPermissionResponseParams response = PermissionService_Internal.PermissionServiceRequestPermissionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PermissionServiceRequestPermissionResponseParamsProxyToResponder implements PermissionService.RequestPermissionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PermissionServiceRequestPermissionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            PermissionService_Internal.PermissionServiceRequestPermissionResponseParams _response = new PermissionService_Internal.PermissionServiceRequestPermissionResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PermissionServiceRequestPermissionsParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PermissionDescriptor[] permission;

        public boolean userGesture;

        private PermissionServiceRequestPermissionsParams(int version) {
            super(24, version);
        }

        public PermissionServiceRequestPermissionsParams() {
            this(0);
        }

        public static PermissionServiceRequestPermissionsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionServiceRequestPermissionsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionServiceRequestPermissionsParams decode(Decoder decoder0) {
            PermissionServiceRequestPermissionsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionServiceRequestPermissionsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.permission = new PermissionDescriptor[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.permission[i1] = PermissionDescriptor.decode(decoder2);
                }
                result.userGesture = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.permission == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.permission.length, 8, -1);
                for (int i0 = 0; i0 < this.permission.length; i0++)
                    encoder1.encode(this.permission[i0], 8 + 8 * i0, false);
            }
            encoder0.encode(this.userGesture, 16, 0);
        }
    }

    static final class PermissionServiceRequestPermissionsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int[] statuses;

        private PermissionServiceRequestPermissionsResponseParams(int version) {
            super(16, version);
        }

        public PermissionServiceRequestPermissionsResponseParams() {
            this(0);
        }

        public static PermissionServiceRequestPermissionsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionServiceRequestPermissionsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionServiceRequestPermissionsResponseParams decode(Decoder decoder0) {
            PermissionServiceRequestPermissionsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionServiceRequestPermissionsResponseParams(elementsOrVersion);
                result.statuses = decoder0.readInts(8, 0, -1);
                for (int i0 = 0; i0 < result.statuses.length; i0++)
                    PermissionStatus.validate(result.statuses[i0]);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.statuses, 8, 0, -1);
        }
    }

    static class PermissionServiceRequestPermissionsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PermissionService.RequestPermissionsResponse mCallback;

        PermissionServiceRequestPermissionsResponseParamsForwardToCallback(PermissionService.RequestPermissionsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                PermissionService_Internal.PermissionServiceRequestPermissionsResponseParams response = PermissionService_Internal.PermissionServiceRequestPermissionsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.statuses);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PermissionServiceRequestPermissionsResponseParamsProxyToResponder implements PermissionService.RequestPermissionsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PermissionServiceRequestPermissionsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(int[] statuses) {
            PermissionService_Internal.PermissionServiceRequestPermissionsResponseParams _response = new PermissionService_Internal.PermissionServiceRequestPermissionsResponseParams();
            _response.statuses = statuses;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PermissionServiceRevokePermissionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PermissionDescriptor permission;

        private PermissionServiceRevokePermissionParams(int version) {
            super(16, version);
        }

        public PermissionServiceRevokePermissionParams() {
            this(0);
        }

        public static PermissionServiceRevokePermissionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionServiceRevokePermissionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionServiceRevokePermissionParams decode(Decoder decoder0) {
            PermissionServiceRevokePermissionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionServiceRevokePermissionParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.permission = PermissionDescriptor.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.permission, 8, false);
        }
    }

    static final class PermissionServiceRevokePermissionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private PermissionServiceRevokePermissionResponseParams(int version) {
            super(16, version);
        }

        public PermissionServiceRevokePermissionResponseParams() {
            this(0);
        }

        public static PermissionServiceRevokePermissionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionServiceRevokePermissionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionServiceRevokePermissionResponseParams decode(Decoder decoder0) {
            PermissionServiceRevokePermissionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionServiceRevokePermissionResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PermissionStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class PermissionServiceRevokePermissionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PermissionService.RevokePermissionResponse mCallback;

        PermissionServiceRevokePermissionResponseParamsForwardToCallback(PermissionService.RevokePermissionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                PermissionService_Internal.PermissionServiceRevokePermissionResponseParams response = PermissionService_Internal.PermissionServiceRevokePermissionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PermissionServiceRevokePermissionResponseParamsProxyToResponder implements PermissionService.RevokePermissionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PermissionServiceRevokePermissionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            PermissionService_Internal.PermissionServiceRevokePermissionResponseParams _response = new PermissionService_Internal.PermissionServiceRevokePermissionResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PermissionServiceAddPermissionObserverParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PermissionDescriptor permission;

        public int lastKnownStatus;

        public PermissionObserver observer;

        private PermissionServiceAddPermissionObserverParams(int version) {
            super(32, version);
        }

        public PermissionServiceAddPermissionObserverParams() {
            this(0);
        }

        public static PermissionServiceAddPermissionObserverParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionServiceAddPermissionObserverParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionServiceAddPermissionObserverParams decode(Decoder decoder0) {
            PermissionServiceAddPermissionObserverParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionServiceAddPermissionObserverParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.permission = PermissionDescriptor.decode(decoder1);
                result.lastKnownStatus = decoder0.readInt(16);
                PermissionStatus.validate(result.lastKnownStatus);
                result.observer = (PermissionObserver)decoder0.readServiceInterface(20, false, PermissionObserver.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.permission, 8, false);
            encoder0.encode(this.lastKnownStatus, 16);
            encoder0.encode(this.observer, 20, false, PermissionObserver.MANAGER);
        }
    }
}
