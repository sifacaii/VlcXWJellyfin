package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
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

class FindInPage_Internal {
    public static final Interface.Manager<FindInPage, FindInPage.Proxy> MANAGER = new Interface.Manager<FindInPage, FindInPage.Proxy>() {
        public String getName() {
            return "blink.mojom.FindInPage";
        }

        public int getVersion() {
            return 0;
        }

        public FindInPage_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FindInPage_Internal.Proxy(core, messageReceiver);
        }

        public FindInPage_Internal.Stub buildStub(Core core, FindInPage impl) {
            return new FindInPage_Internal.Stub(core, impl);
        }

        public FindInPage[] buildArray(int size) {
            return new FindInPage[size];
        }
    };

    private static final int FIND_ORDINAL = 0;

    private static final int STOP_FINDING_ORDINAL = 1;

    private static final int CLEAR_ACTIVE_FIND_MATCH_ORDINAL = 2;

    private static final int GET_NEAREST_FIND_RESULT_ORDINAL = 3;

    private static final int ACTIVATE_NEAREST_FIND_RESULT_ORDINAL = 4;

    private static final int SET_CLIENT_ORDINAL = 5;

    private static final int FIND_MATCH_RECTS_ORDINAL = 6;

    static final class Proxy extends Interface.AbstractProxy implements FindInPage.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void find(int requestId, String searchText, FindOptions options) {
            FindInPage_Internal.FindInPageFindParams _message = new FindInPage_Internal.FindInPageFindParams();
            _message.requestId = requestId;
            _message.searchText = searchText;
            _message.options = options;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void stopFinding(int action) {
            FindInPage_Internal.FindInPageStopFindingParams _message = new FindInPage_Internal.FindInPageStopFindingParams();
            _message.action = action;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void clearActiveFindMatch() {
            FindInPage_Internal.FindInPageClearActiveFindMatchParams _message = new FindInPage_Internal.FindInPageClearActiveFindMatchParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void getNearestFindResult(PointF point, FindInPage.GetNearestFindResultResponse callback) {
            FindInPage_Internal.FindInPageGetNearestFindResultParams _message = new FindInPage_Internal.FindInPageGetNearestFindResultParams();
            _message.point = point;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new FindInPage_Internal.FindInPageGetNearestFindResultResponseParamsForwardToCallback(callback));
        }

        public void activateNearestFindResult(int requestId, PointF point) {
            FindInPage_Internal.FindInPageActivateNearestFindResultParams _message = new FindInPage_Internal.FindInPageActivateNearestFindResultParams();
            _message.requestId = requestId;
            _message.point = point;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void setClient(FindInPageClient client) {
            FindInPage_Internal.FindInPageSetClientParams _message = new FindInPage_Internal.FindInPageSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }

        public void findMatchRects(int currentVersion, FindInPage.FindMatchRectsResponse callback) {
            FindInPage_Internal.FindInPageFindMatchRectsParams _message = new FindInPage_Internal.FindInPageFindMatchRectsParams();
            _message.currentVersion = currentVersion;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new FindInPage_Internal.FindInPageFindMatchRectsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<FindInPage> {
        Stub(Core core, FindInPage impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                FindInPage_Internal.FindInPageFindParams findInPageFindParams;
                FindInPage_Internal.FindInPageStopFindingParams findInPageStopFindingParams;
                FindInPage_Internal.FindInPageActivateNearestFindResultParams findInPageActivateNearestFindResultParams;
                FindInPage_Internal.FindInPageSetClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FindInPage_Internal.MANAGER, messageWithHeader);
                    case 0:
                        findInPageFindParams = FindInPage_Internal.FindInPageFindParams.deserialize(messageWithHeader.getPayload());
                        ((FindInPage)getImpl()).find(findInPageFindParams.requestId, findInPageFindParams.searchText, findInPageFindParams.options);
                        return true;
                    case 1:
                        findInPageStopFindingParams = FindInPage_Internal.FindInPageStopFindingParams.deserialize(messageWithHeader.getPayload());
                        ((FindInPage)getImpl()).stopFinding(findInPageStopFindingParams.action);
                        return true;
                    case 2:
                        FindInPage_Internal.FindInPageClearActiveFindMatchParams.deserialize(messageWithHeader.getPayload());
                        ((FindInPage)getImpl()).clearActiveFindMatch();
                        return true;
                    case 4:
                        findInPageActivateNearestFindResultParams = FindInPage_Internal.FindInPageActivateNearestFindResultParams.deserialize(messageWithHeader.getPayload());
                        ((FindInPage)getImpl()).activateNearestFindResult(findInPageActivateNearestFindResultParams.requestId, findInPageActivateNearestFindResultParams.point);
                        return true;
                    case 5:
                        data = FindInPage_Internal.FindInPageSetClientParams.deserialize(messageWithHeader.getPayload());
                        ((FindInPage)getImpl()).setClient(data.client);
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
                FindInPage_Internal.FindInPageGetNearestFindResultParams findInPageGetNearestFindResultParams;
                FindInPage_Internal.FindInPageFindMatchRectsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), FindInPage_Internal.MANAGER, messageWithHeader, receiver);
                    case 3:
                        findInPageGetNearestFindResultParams = FindInPage_Internal.FindInPageGetNearestFindResultParams.deserialize(messageWithHeader.getPayload());
                        ((FindInPage)getImpl()).getNearestFindResult(findInPageGetNearestFindResultParams.point, new FindInPage_Internal.FindInPageGetNearestFindResultResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        data = FindInPage_Internal.FindInPageFindMatchRectsParams.deserialize(messageWithHeader.getPayload());
                        ((FindInPage)getImpl()).findMatchRects(data.currentVersion, new FindInPage_Internal.FindInPageFindMatchRectsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FindInPageFindParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int requestId;

        public String searchText;

        public FindOptions options;

        private FindInPageFindParams(int version) {
            super(32, version);
        }

        public FindInPageFindParams() {
            this(0);
        }

        public static FindInPageFindParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageFindParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageFindParams decode(Decoder decoder0) {
            FindInPageFindParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageFindParams(elementsOrVersion);
                result.requestId = decoder0.readInt(8);
                result.searchText = decoder0.readString(16, false);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.options = FindOptions.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.requestId, 8);
            encoder0.encode(this.searchText, 16, false);
            encoder0.encode(this.options, 24, false);
        }
    }

    static final class FindInPageStopFindingParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int action;

        private FindInPageStopFindingParams(int version) {
            super(16, version);
        }

        public FindInPageStopFindingParams() {
            this(0);
        }

        public static FindInPageStopFindingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageStopFindingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageStopFindingParams decode(Decoder decoder0) {
            FindInPageStopFindingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageStopFindingParams(elementsOrVersion);
                result.action = decoder0.readInt(8);
                StopFindAction.validate(result.action);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.action, 8);
        }
    }

    static final class FindInPageClearActiveFindMatchParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FindInPageClearActiveFindMatchParams(int version) {
            super(8, version);
        }

        public FindInPageClearActiveFindMatchParams() {
            this(0);
        }

        public static FindInPageClearActiveFindMatchParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageClearActiveFindMatchParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageClearActiveFindMatchParams decode(Decoder decoder0) {
            FindInPageClearActiveFindMatchParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageClearActiveFindMatchParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FindInPageGetNearestFindResultParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PointF point;

        private FindInPageGetNearestFindResultParams(int version) {
            super(16, version);
        }

        public FindInPageGetNearestFindResultParams() {
            this(0);
        }

        public static FindInPageGetNearestFindResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageGetNearestFindResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageGetNearestFindResultParams decode(Decoder decoder0) {
            FindInPageGetNearestFindResultParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageGetNearestFindResultParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.point = PointF.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.point, 8, false);
        }
    }

    static final class FindInPageGetNearestFindResultResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public float distance;

        private FindInPageGetNearestFindResultResponseParams(int version) {
            super(16, version);
        }

        public FindInPageGetNearestFindResultResponseParams() {
            this(0);
        }

        public static FindInPageGetNearestFindResultResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageGetNearestFindResultResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageGetNearestFindResultResponseParams decode(Decoder decoder0) {
            FindInPageGetNearestFindResultResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageGetNearestFindResultResponseParams(elementsOrVersion);
                result.distance = decoder0.readFloat(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.distance, 8);
        }
    }

    static class FindInPageGetNearestFindResultResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FindInPage.GetNearestFindResultResponse mCallback;

        FindInPageGetNearestFindResultResponseParamsForwardToCallback(FindInPage.GetNearestFindResultResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                FindInPage_Internal.FindInPageGetNearestFindResultResponseParams response = FindInPage_Internal.FindInPageGetNearestFindResultResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Float.valueOf(response.distance));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FindInPageGetNearestFindResultResponseParamsProxyToResponder implements FindInPage.GetNearestFindResultResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FindInPageGetNearestFindResultResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Float distance) {
            FindInPage_Internal.FindInPageGetNearestFindResultResponseParams _response = new FindInPage_Internal.FindInPageGetNearestFindResultResponseParams();
            _response.distance = distance.floatValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FindInPageActivateNearestFindResultParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int requestId;

        public PointF point;

        private FindInPageActivateNearestFindResultParams(int version) {
            super(24, version);
        }

        public FindInPageActivateNearestFindResultParams() {
            this(0);
        }

        public static FindInPageActivateNearestFindResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageActivateNearestFindResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageActivateNearestFindResultParams decode(Decoder decoder0) {
            FindInPageActivateNearestFindResultParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageActivateNearestFindResultParams(elementsOrVersion);
                result.requestId = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.point = PointF.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.requestId, 8);
            encoder0.encode((Struct)this.point, 16, false);
        }
    }

    static final class FindInPageSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FindInPageClient client;

        private FindInPageSetClientParams(int version) {
            super(16, version);
        }

        public FindInPageSetClientParams() {
            this(0);
        }

        public static FindInPageSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageSetClientParams decode(Decoder decoder0) {
            FindInPageSetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageSetClientParams(elementsOrVersion);
                result.client = (FindInPageClient)decoder0.readServiceInterface(8, false, FindInPageClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false, FindInPageClient.MANAGER);
        }
    }

    static final class FindInPageFindMatchRectsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int currentVersion;

        private FindInPageFindMatchRectsParams(int version) {
            super(16, version);
        }

        public FindInPageFindMatchRectsParams() {
            this(0);
        }

        public static FindInPageFindMatchRectsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageFindMatchRectsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageFindMatchRectsParams decode(Decoder decoder0) {
            FindInPageFindMatchRectsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageFindMatchRectsParams(elementsOrVersion);
                result.currentVersion = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.currentVersion, 8);
        }
    }

    static final class FindInPageFindMatchRectsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int version;

        public RectF[] rects;

        public RectF activeMatchRect;

        private FindInPageFindMatchRectsResponseParams(int version) {
            super(32, version);
        }

        public FindInPageFindMatchRectsResponseParams() {
            this(0);
        }

        public static FindInPageFindMatchRectsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageFindMatchRectsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageFindMatchRectsResponseParams decode(Decoder decoder0) {
            FindInPageFindMatchRectsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageFindMatchRectsResponseParams(elementsOrVersion);
                result.version = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.rects = new RectF[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.rects[i1] = RectF.decode(decoder2);
                }
                decoder1 = decoder0.readPointer(24, false);
                result.activeMatchRect = RectF.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.version, 8);
            if (this.rects == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.rects.length, 16, -1);
                for (int i0 = 0; i0 < this.rects.length; i0++)
                    encoder1.encode((Struct)this.rects[i0], 8 + 8 * i0, false);
            }
            encoder0.encode((Struct)this.activeMatchRect, 24, false);
        }
    }

    static class FindInPageFindMatchRectsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FindInPage.FindMatchRectsResponse mCallback;

        FindInPageFindMatchRectsResponseParamsForwardToCallback(FindInPage.FindMatchRectsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                FindInPage_Internal.FindInPageFindMatchRectsResponseParams response = FindInPage_Internal.FindInPageFindMatchRectsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.version), response.rects, response.activeMatchRect);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FindInPageFindMatchRectsResponseParamsProxyToResponder implements FindInPage.FindMatchRectsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FindInPageFindMatchRectsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer version, RectF[] rects, RectF activeMatchRect) {
            FindInPage_Internal.FindInPageFindMatchRectsResponseParams _response = new FindInPage_Internal.FindInPageFindMatchRectsResponseParams();
            _response.version = version.intValue();
            _response.rects = rects;
            _response.activeMatchRect = activeMatchRect;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
