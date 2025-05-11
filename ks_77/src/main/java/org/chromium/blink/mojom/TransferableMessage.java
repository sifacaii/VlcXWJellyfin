package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/TransferableMessage.class */
public final class TransferableMessage extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public CloneableMessage message;
    public MessagePipeHandle[] ports;
    public MessagePipeHandle[] streamChannels;
    public SerializedArrayBufferContents[] arrayBufferContentsArray;
    public Bitmap[] imageBitmapContentsArray;
    public boolean hasUserGesture;
    public UserActivationSnapshot userActivation;
    public boolean transferUserActivation;
    public boolean allowAutoplay;

    private TransferableMessage(int version) {
        super(64, version);
    }

    public TransferableMessage() {
        this(0);
    }

    public static TransferableMessage deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static TransferableMessage deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static TransferableMessage decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            TransferableMessage result = new TransferableMessage(elementsOrVersion);
            result.message = CloneableMessage.decode(decoder0.readPointer(8, false));
            result.ports = decoder0.readMessagePipeHandles(16, 0, -1);
            result.streamChannels = decoder0.readMessagePipeHandles(24, 0, -1);
            Decoder decoder1 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.arrayBufferContentsArray = new SerializedArrayBufferContents[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.arrayBufferContentsArray[i1] = SerializedArrayBufferContents.decode(decoder2);
            }
            Decoder decoder12 = decoder0.readPointer(40, false);
            DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
            result.imageBitmapContentsArray = new Bitmap[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                result.imageBitmapContentsArray[i12] = Bitmap.decode(decoder22);
            }
            result.hasUserGesture = decoder0.readBoolean(48, 0);
            result.transferUserActivation = decoder0.readBoolean(48, 1);
            result.allowAutoplay = decoder0.readBoolean(48, 2);
            result.userActivation = UserActivationSnapshot.decode(decoder0.readPointer(56, true));
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
        encoder0.encode((Struct) this.message, 8, false);
        encoder0.encode(this.ports, 16, 0, -1);
        encoder0.encode(this.streamChannels, 24, 0, -1);
        if (this.arrayBufferContentsArray == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.arrayBufferContentsArray.length, 32, -1);
            for (int i0 = 0; i0 < this.arrayBufferContentsArray.length; i0++) {
                encoder1.encode((Struct) this.arrayBufferContentsArray[i0], 8 + (8 * i0), false);
            }
        }
        if (this.imageBitmapContentsArray == null) {
            encoder0.encodeNullPointer(40, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.imageBitmapContentsArray.length, 40, -1);
            for (int i02 = 0; i02 < this.imageBitmapContentsArray.length; i02++) {
                encoder12.encode((Struct) this.imageBitmapContentsArray[i02], 8 + (8 * i02), false);
            }
        }
        encoder0.encode(this.hasUserGesture, 48, 0);
        encoder0.encode(this.transferUserActivation, 48, 1);
        encoder0.encode(this.allowAutoplay, 48, 2);
        encoder0.encode((Struct) this.userActivation, 56, true);
    }
}
