package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/MessageHeader.class */
public class MessageHeader {
    private static final int SIMPLE_MESSAGE_SIZE = 24;
    private static final int SIMPLE_MESSAGE_VERSION = 0;
    private static final DataHeader SIMPLE_MESSAGE_STRUCT_INFO;
    private static final int MESSAGE_WITH_REQUEST_ID_SIZE = 32;
    private static final int MESSAGE_WITH_REQUEST_ID_VERSION = 1;
    private static final DataHeader MESSAGE_WITH_REQUEST_ID_STRUCT_INFO;
    private static final int INTERFACE_ID_OFFSET = 8;
    private static final int TYPE_OFFSET = 12;
    private static final int FLAGS_OFFSET = 16;
    private static final int REQUEST_ID_OFFSET = 24;
    public static final int NO_FLAG = 0;
    public static final int MESSAGE_EXPECTS_RESPONSE_FLAG = 1;
    public static final int MESSAGE_IS_RESPONSE_FLAG = 2;
    private final DataHeader mDataHeader;
    private final int mType;
    private final int mFlags;
    private long mRequestId;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !MessageHeader.class.desiredAssertionStatus();
        SIMPLE_MESSAGE_STRUCT_INFO = new DataHeader(24, 0);
        MESSAGE_WITH_REQUEST_ID_STRUCT_INFO = new DataHeader(32, 1);
    }

    public MessageHeader(int type) {
        this.mDataHeader = SIMPLE_MESSAGE_STRUCT_INFO;
        this.mType = type;
        this.mFlags = 0;
        this.mRequestId = 0L;
    }

    public MessageHeader(int type, int flags, long requestId) {
        if (!$assertionsDisabled && !mustHaveRequestId(flags)) {
            throw new AssertionError();
        }
        this.mDataHeader = MESSAGE_WITH_REQUEST_ID_STRUCT_INFO;
        this.mType = type;
        this.mFlags = flags;
        this.mRequestId = requestId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageHeader(Message message) {
        Decoder decoder = new Decoder(message);
        this.mDataHeader = decoder.readDataHeader();
        validateDataHeader(this.mDataHeader);
        int interfaceId = decoder.readInt(8);
        if (interfaceId != 0) {
            throw new DeserializationException("Non-zero interface ID, expecting zero since associated interfaces are not yet supported.");
        }
        this.mType = decoder.readInt(12);
        this.mFlags = decoder.readInt(16);
        if (mustHaveRequestId(this.mFlags)) {
            if (this.mDataHeader.size < 32) {
                throw new DeserializationException("Incorrect message size, expecting at least 32 for a message with a request identifier, but got: " + this.mDataHeader.size);
            }
            this.mRequestId = decoder.readLong(24);
            return;
        }
        this.mRequestId = 0L;
    }

    public int getSize() {
        return this.mDataHeader.size;
    }

    public int getType() {
        return this.mType;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public boolean hasFlag(int flag) {
        return (this.mFlags & flag) == flag;
    }

    public boolean hasRequestId() {
        return mustHaveRequestId(this.mFlags);
    }

    public long getRequestId() {
        if ($assertionsDisabled || hasRequestId()) {
            return this.mRequestId;
        }
        throw new AssertionError();
    }

    public void encode(Encoder encoder) {
        encoder.encode(this.mDataHeader);
        encoder.encode(0, 8);
        encoder.encode(getType(), 12);
        encoder.encode(getFlags(), 16);
        if (hasRequestId()) {
            encoder.encode(getRequestId(), 24);
        }
    }

    public boolean validateHeader(int expectedFlags) {
        int knownFlags = getFlags() & 3;
        return knownFlags == expectedFlags;
    }

    public boolean validateHeader(int expectedType, int expectedFlags) {
        return getType() == expectedType && validateHeader(expectedFlags);
    }

    public int hashCode() {
        int result = (31 * 1) + (this.mDataHeader == null ? 0 : this.mDataHeader.hashCode());
        return (31 * ((31 * ((31 * result) + this.mFlags)) + ((int) (this.mRequestId ^ (this.mRequestId >>> 32))))) + this.mType;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && getClass() == object.getClass()) {
            MessageHeader other = (MessageHeader) object;
            return BindingsHelper.equals(this.mDataHeader, other.mDataHeader) && this.mFlags == other.mFlags && this.mRequestId == other.mRequestId && this.mType == other.mType;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRequestId(ByteBuffer buffer, long requestId) {
        if (!$assertionsDisabled && !mustHaveRequestId(buffer.getInt(16))) {
            throw new AssertionError();
        }
        buffer.putLong(24, requestId);
        this.mRequestId = requestId;
    }

    private static boolean mustHaveRequestId(int flags) {
        return (flags & 3) != 0;
    }

    private static void validateDataHeader(DataHeader dataHeader) {
        if (dataHeader.elementsOrVersion < 0) {
            throw new DeserializationException("Incorrect number of fields, expecting at least 0, but got: " + dataHeader.elementsOrVersion);
        }
        if (dataHeader.size < 24) {
            throw new DeserializationException("Incorrect message size, expecting at least 24, but got: " + dataHeader.size);
        }
        if (dataHeader.elementsOrVersion == 0 && dataHeader.size != 24) {
            throw new DeserializationException("Incorrect message size for a message with 0 fields, expecting 24, but got: " + dataHeader.size);
        }
        if (dataHeader.elementsOrVersion == 1 && dataHeader.size != 32) {
            throw new DeserializationException("Incorrect message size for a message with 1 fields, expecting 32, but got: " + dataHeader.size);
        }
    }
}
