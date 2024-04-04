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

class NotificationService_Internal {
    public static final Interface.Manager<NotificationService, NotificationService.Proxy> MANAGER = new Interface.Manager<NotificationService, NotificationService.Proxy>() {
        public String getName() {
            return "blink.mojom.NotificationService";
        }

        public int getVersion() {
            return 0;
        }

        public NotificationService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NotificationService_Internal.Proxy(core, messageReceiver);
        }

        public NotificationService_Internal.Stub buildStub(Core core, NotificationService impl) {
            return new NotificationService_Internal.Stub(core, impl);
        }

        public NotificationService[] buildArray(int size) {
            return new NotificationService[size];
        }
    };

    private static final int GET_PERMISSION_STATUS_ORDINAL = 0;

    private static final int DISPLAY_NON_PERSISTENT_NOTIFICATION_ORDINAL = 1;

    private static final int CLOSE_NON_PERSISTENT_NOTIFICATION_ORDINAL = 2;

    private static final int DISPLAY_PERSISTENT_NOTIFICATION_ORDINAL = 3;

    private static final int CLOSE_PERSISTENT_NOTIFICATION_ORDINAL = 4;

    private static final int GET_NOTIFICATIONS_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements NotificationService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getPermissionStatus(NotificationService.GetPermissionStatusResponse callback) {
            NotificationService_Internal.NotificationServiceGetPermissionStatusParams _message = new NotificationService_Internal.NotificationServiceGetPermissionStatusParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new NotificationService_Internal.NotificationServiceGetPermissionStatusResponseParamsForwardToCallback(callback));
        }

        public void displayNonPersistentNotification(String token, NotificationData notificationData, NotificationResources notificationResources, NonPersistentNotificationListener eventListener) {
            NotificationService_Internal.NotificationServiceDisplayNonPersistentNotificationParams _message = new NotificationService_Internal.NotificationServiceDisplayNonPersistentNotificationParams();
            _message.token = token;
            _message.notificationData = notificationData;
            _message.notificationResources = notificationResources;
            _message.eventListener = eventListener;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void closeNonPersistentNotification(String token) {
            NotificationService_Internal.NotificationServiceCloseNonPersistentNotificationParams _message = new NotificationService_Internal.NotificationServiceCloseNonPersistentNotificationParams();
            _message.token = token;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void displayPersistentNotification(long serviceWorkerRegistrationId, NotificationData notificationData, NotificationResources notificationResources, NotificationService.DisplayPersistentNotificationResponse callback) {
            NotificationService_Internal.NotificationServiceDisplayPersistentNotificationParams _message = new NotificationService_Internal.NotificationServiceDisplayPersistentNotificationParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            _message.notificationData = notificationData;
            _message.notificationResources = notificationResources;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new NotificationService_Internal.NotificationServiceDisplayPersistentNotificationResponseParamsForwardToCallback(callback));
        }

        public void closePersistentNotification(String notificationId) {
            NotificationService_Internal.NotificationServiceClosePersistentNotificationParams _message = new NotificationService_Internal.NotificationServiceClosePersistentNotificationParams();
            _message.notificationId = notificationId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void getNotifications(long serviceWorkerRegistrationId, String filterTag, boolean includeTriggered, NotificationService.GetNotificationsResponse callback) {
            NotificationService_Internal.NotificationServiceGetNotificationsParams _message = new NotificationService_Internal.NotificationServiceGetNotificationsParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            _message.filterTag = filterTag;
            _message.includeTriggered = includeTriggered;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new NotificationService_Internal.NotificationServiceGetNotificationsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<NotificationService> {
        Stub(Core core, NotificationService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                NotificationService_Internal.NotificationServiceDisplayNonPersistentNotificationParams notificationServiceDisplayNonPersistentNotificationParams;
                NotificationService_Internal.NotificationServiceCloseNonPersistentNotificationParams notificationServiceCloseNonPersistentNotificationParams;
                NotificationService_Internal.NotificationServiceClosePersistentNotificationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NotificationService_Internal.MANAGER, messageWithHeader);
                    case 1:
                        notificationServiceDisplayNonPersistentNotificationParams = NotificationService_Internal.NotificationServiceDisplayNonPersistentNotificationParams.deserialize(messageWithHeader.getPayload());
                        ((NotificationService)getImpl()).displayNonPersistentNotification(notificationServiceDisplayNonPersistentNotificationParams.token, notificationServiceDisplayNonPersistentNotificationParams.notificationData, notificationServiceDisplayNonPersistentNotificationParams.notificationResources, notificationServiceDisplayNonPersistentNotificationParams.eventListener);
                        return true;
                    case 2:
                        notificationServiceCloseNonPersistentNotificationParams = NotificationService_Internal.NotificationServiceCloseNonPersistentNotificationParams.deserialize(messageWithHeader.getPayload());
                        ((NotificationService)getImpl()).closeNonPersistentNotification(notificationServiceCloseNonPersistentNotificationParams.token);
                        return true;
                    case 4:
                        data = NotificationService_Internal.NotificationServiceClosePersistentNotificationParams.deserialize(messageWithHeader.getPayload());
                        ((NotificationService)getImpl()).closePersistentNotification(data.notificationId);
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
                NotificationService_Internal.NotificationServiceDisplayPersistentNotificationParams notificationServiceDisplayPersistentNotificationParams;
                NotificationService_Internal.NotificationServiceGetNotificationsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), NotificationService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        NotificationService_Internal.NotificationServiceGetPermissionStatusParams.deserialize(messageWithHeader.getPayload());
                        ((NotificationService)getImpl()).getPermissionStatus(new NotificationService_Internal.NotificationServiceGetPermissionStatusResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        notificationServiceDisplayPersistentNotificationParams = NotificationService_Internal.NotificationServiceDisplayPersistentNotificationParams.deserialize(messageWithHeader.getPayload());
                        ((NotificationService)getImpl()).displayPersistentNotification(notificationServiceDisplayPersistentNotificationParams.serviceWorkerRegistrationId, notificationServiceDisplayPersistentNotificationParams.notificationData, notificationServiceDisplayPersistentNotificationParams.notificationResources, new NotificationService_Internal.NotificationServiceDisplayPersistentNotificationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        data = NotificationService_Internal.NotificationServiceGetNotificationsParams.deserialize(messageWithHeader.getPayload());
                        ((NotificationService)getImpl()).getNotifications(data.serviceWorkerRegistrationId, data.filterTag, data.includeTriggered, new NotificationService_Internal.NotificationServiceGetNotificationsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NotificationServiceGetPermissionStatusParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NotificationServiceGetPermissionStatusParams(int version) {
            super(8, version);
        }

        public NotificationServiceGetPermissionStatusParams() {
            this(0);
        }

        public static NotificationServiceGetPermissionStatusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NotificationServiceGetPermissionStatusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NotificationServiceGetPermissionStatusParams decode(Decoder decoder0) {
            NotificationServiceGetPermissionStatusParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NotificationServiceGetPermissionStatusParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NotificationServiceGetPermissionStatusResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private NotificationServiceGetPermissionStatusResponseParams(int version) {
            super(16, version);
        }

        public NotificationServiceGetPermissionStatusResponseParams() {
            this(0);
        }

        public static NotificationServiceGetPermissionStatusResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NotificationServiceGetPermissionStatusResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NotificationServiceGetPermissionStatusResponseParams decode(Decoder decoder0) {
            NotificationServiceGetPermissionStatusResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NotificationServiceGetPermissionStatusResponseParams(elementsOrVersion);
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

    static class NotificationServiceGetPermissionStatusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NotificationService.GetPermissionStatusResponse mCallback;

        NotificationServiceGetPermissionStatusResponseParamsForwardToCallback(NotificationService.GetPermissionStatusResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                NotificationService_Internal.NotificationServiceGetPermissionStatusResponseParams response = NotificationService_Internal.NotificationServiceGetPermissionStatusResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NotificationServiceGetPermissionStatusResponseParamsProxyToResponder implements NotificationService.GetPermissionStatusResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NotificationServiceGetPermissionStatusResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            NotificationService_Internal.NotificationServiceGetPermissionStatusResponseParams _response = new NotificationService_Internal.NotificationServiceGetPermissionStatusResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NotificationServiceDisplayNonPersistentNotificationParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String token;

        public NotificationData notificationData;

        public NotificationResources notificationResources;

        public NonPersistentNotificationListener eventListener;

        private NotificationServiceDisplayNonPersistentNotificationParams(int version) {
            super(40, version);
        }

        public NotificationServiceDisplayNonPersistentNotificationParams() {
            this(0);
        }

        public static NotificationServiceDisplayNonPersistentNotificationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NotificationServiceDisplayNonPersistentNotificationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NotificationServiceDisplayNonPersistentNotificationParams decode(Decoder decoder0) {
            NotificationServiceDisplayNonPersistentNotificationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NotificationServiceDisplayNonPersistentNotificationParams(elementsOrVersion);
                result.token = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.notificationData = NotificationData.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.notificationResources = NotificationResources.decode(decoder1);
                result.eventListener = (NonPersistentNotificationListener)decoder0.readServiceInterface(32, false, NonPersistentNotificationListener.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.token, 8, false);
            encoder0.encode(this.notificationData, 16, false);
            encoder0.encode(this.notificationResources, 24, false);
            encoder0.encode(this.eventListener, 32, false, NonPersistentNotificationListener.MANAGER);
        }
    }

    static final class NotificationServiceCloseNonPersistentNotificationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String token;

        private NotificationServiceCloseNonPersistentNotificationParams(int version) {
            super(16, version);
        }

        public NotificationServiceCloseNonPersistentNotificationParams() {
            this(0);
        }

        public static NotificationServiceCloseNonPersistentNotificationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NotificationServiceCloseNonPersistentNotificationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NotificationServiceCloseNonPersistentNotificationParams decode(Decoder decoder0) {
            NotificationServiceCloseNonPersistentNotificationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NotificationServiceCloseNonPersistentNotificationParams(elementsOrVersion);
                result.token = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.token, 8, false);
        }
    }

    static final class NotificationServiceDisplayPersistentNotificationParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        public NotificationData notificationData;

        public NotificationResources notificationResources;

        private NotificationServiceDisplayPersistentNotificationParams(int version) {
            super(32, version);
        }

        public NotificationServiceDisplayPersistentNotificationParams() {
            this(0);
        }

        public static NotificationServiceDisplayPersistentNotificationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NotificationServiceDisplayPersistentNotificationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NotificationServiceDisplayPersistentNotificationParams decode(Decoder decoder0) {
            NotificationServiceDisplayPersistentNotificationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NotificationServiceDisplayPersistentNotificationParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.notificationData = NotificationData.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.notificationResources = NotificationResources.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
            encoder0.encode(this.notificationData, 16, false);
            encoder0.encode(this.notificationResources, 24, false);
        }
    }

    static final class NotificationServiceDisplayPersistentNotificationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        private NotificationServiceDisplayPersistentNotificationResponseParams(int version) {
            super(16, version);
        }

        public NotificationServiceDisplayPersistentNotificationResponseParams() {
            this(0);
        }

        public static NotificationServiceDisplayPersistentNotificationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NotificationServiceDisplayPersistentNotificationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NotificationServiceDisplayPersistentNotificationResponseParams decode(Decoder decoder0) {
            NotificationServiceDisplayPersistentNotificationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NotificationServiceDisplayPersistentNotificationResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                PersistentNotificationError.validate(result.error);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    static class NotificationServiceDisplayPersistentNotificationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NotificationService.DisplayPersistentNotificationResponse mCallback;

        NotificationServiceDisplayPersistentNotificationResponseParamsForwardToCallback(NotificationService.DisplayPersistentNotificationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                NotificationService_Internal.NotificationServiceDisplayPersistentNotificationResponseParams response = NotificationService_Internal.NotificationServiceDisplayPersistentNotificationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NotificationServiceDisplayPersistentNotificationResponseParamsProxyToResponder implements NotificationService.DisplayPersistentNotificationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NotificationServiceDisplayPersistentNotificationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error) {
            NotificationService_Internal.NotificationServiceDisplayPersistentNotificationResponseParams _response = new NotificationService_Internal.NotificationServiceDisplayPersistentNotificationResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NotificationServiceClosePersistentNotificationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String notificationId;

        private NotificationServiceClosePersistentNotificationParams(int version) {
            super(16, version);
        }

        public NotificationServiceClosePersistentNotificationParams() {
            this(0);
        }

        public static NotificationServiceClosePersistentNotificationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NotificationServiceClosePersistentNotificationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NotificationServiceClosePersistentNotificationParams decode(Decoder decoder0) {
            NotificationServiceClosePersistentNotificationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NotificationServiceClosePersistentNotificationParams(elementsOrVersion);
                result.notificationId = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.notificationId, 8, false);
        }
    }

    static final class NotificationServiceGetNotificationsParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        public String filterTag;

        public boolean includeTriggered;

        private NotificationServiceGetNotificationsParams(int version) {
            super(32, version);
        }

        public NotificationServiceGetNotificationsParams() {
            this(0);
        }

        public static NotificationServiceGetNotificationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NotificationServiceGetNotificationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NotificationServiceGetNotificationsParams decode(Decoder decoder0) {
            NotificationServiceGetNotificationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NotificationServiceGetNotificationsParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
                result.filterTag = decoder0.readString(16, false);
                result.includeTriggered = decoder0.readBoolean(24, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
            encoder0.encode(this.filterTag, 16, false);
            encoder0.encode(this.includeTriggered, 24, 0);
        }
    }

    static final class NotificationServiceGetNotificationsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String[] notificationIds;

        public NotificationData[] notificationDatas;

        private NotificationServiceGetNotificationsResponseParams(int version) {
            super(24, version);
        }

        public NotificationServiceGetNotificationsResponseParams() {
            this(0);
        }

        public static NotificationServiceGetNotificationsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NotificationServiceGetNotificationsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NotificationServiceGetNotificationsResponseParams decode(Decoder decoder0) {
            NotificationServiceGetNotificationsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NotificationServiceGetNotificationsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.notificationIds = new String[si1.elementsOrVersion];
                int i1;
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++)
                    result.notificationIds[i1] = decoder1.readString(8 + 8 * i1, false);
                decoder1 = decoder0.readPointer(16, false);
                si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.notificationDatas = new NotificationData[si1.elementsOrVersion];
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.notificationDatas[i1] = NotificationData.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.notificationIds == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.notificationIds.length, 8, -1);
                for (int i0 = 0; i0 < this.notificationIds.length; i0++)
                    encoder1.encode(this.notificationIds[i0], 8 + 8 * i0, false);
            }
            if (this.notificationDatas == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.notificationDatas.length, 16, -1);
                for (int i0 = 0; i0 < this.notificationDatas.length; i0++)
                    encoder1.encode(this.notificationDatas[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class NotificationServiceGetNotificationsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NotificationService.GetNotificationsResponse mCallback;

        NotificationServiceGetNotificationsResponseParamsForwardToCallback(NotificationService.GetNotificationsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                NotificationService_Internal.NotificationServiceGetNotificationsResponseParams response = NotificationService_Internal.NotificationServiceGetNotificationsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.notificationIds, response.notificationDatas);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NotificationServiceGetNotificationsResponseParamsProxyToResponder implements NotificationService.GetNotificationsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NotificationServiceGetNotificationsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String[] notificationIds, NotificationData[] notificationDatas) {
            NotificationService_Internal.NotificationServiceGetNotificationsResponseParams _response = new NotificationService_Internal.NotificationServiceGetNotificationsResponseParams();
            _response.notificationIds = notificationIds;
            _response.notificationDatas = notificationDatas;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
