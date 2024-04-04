package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NotificationAction.class */
public final class NotificationAction extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int type;
    public String action;
    public String16 title;
    public Url icon;
    public String16 placeholder;

    private NotificationAction(int version) {
        super(48, version);
    }

    public NotificationAction() {
        this(0);
    }

    public static NotificationAction deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NotificationAction deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationAction decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NotificationAction result = new NotificationAction(elementsOrVersion);
            result.type = decoder0.readInt(8);
            NotificationActionType.validate(result.type);
            result.action = decoder0.readString(16, false);
            Decoder decoder1 = decoder0.readPointer(24, false);
            result.title = String16.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(32, false);
            result.icon = Url.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(40, true);
            result.placeholder = String16.decode(decoder13);
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
        encoder0.encode(this.type, 8);
        encoder0.encode(this.action, 16, false);
        encoder0.encode((Struct) this.title, 24, false);
        encoder0.encode((Struct) this.icon, 32, false);
        encoder0.encode((Struct) this.placeholder, 40, true);
    }
}
