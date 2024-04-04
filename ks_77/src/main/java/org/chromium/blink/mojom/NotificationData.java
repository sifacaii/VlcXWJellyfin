package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NotificationData.class */
public final class NotificationData extends Struct {
    private static final int STRUCT_SIZE = 112;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(112, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public static final long MAXIMUM_DEVELOPER_DATA_SIZE = 1048576;
    public String16 title;
    public int direction;
    public String lang;
    public String16 body;
    public String tag;
    public Url image;
    public Url icon;
    public Url badge;
    public int[] vibrationPattern;
    public double timestamp;
    public boolean renotify;
    public boolean silent;
    public boolean requireInteraction;
    public byte[] data;
    public NotificationAction[] actions;
    public Time showTriggerTimestamp;

    private NotificationData(int version) {
        super(112, version);
        this.direction = 0;
        this.timestamp = 0.0d;
        this.renotify = false;
        this.silent = false;
        this.requireInteraction = false;
    }

    public NotificationData() {
        this(0);
    }

    public static NotificationData deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NotificationData deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationData decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NotificationData result = new NotificationData(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.title = String16.decode(decoder1);
            result.direction = decoder0.readInt(16);
            NotificationDirection.validate(result.direction);
            result.renotify = decoder0.readBoolean(20, 0);
            result.silent = decoder0.readBoolean(20, 1);
            result.requireInteraction = decoder0.readBoolean(20, 2);
            result.lang = decoder0.readString(24, true);
            Decoder decoder12 = decoder0.readPointer(32, false);
            result.body = String16.decode(decoder12);
            result.tag = decoder0.readString(40, false);
            Decoder decoder13 = decoder0.readPointer(48, false);
            result.image = Url.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(56, false);
            result.icon = Url.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(64, false);
            result.badge = Url.decode(decoder15);
            result.vibrationPattern = decoder0.readInts(72, 1, -1);
            result.timestamp = decoder0.readDouble(80);
            result.data = decoder0.readBytes(88, 1, -1);
            Decoder decoder16 = decoder0.readPointer(96, true);
            if (decoder16 == null) {
                result.actions = null;
            } else {
                DataHeader si1 = decoder16.readDataHeaderForPointerArray(-1);
                result.actions = new NotificationAction[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder16.readPointer(8 + (8 * i1), false);
                    result.actions[i1] = NotificationAction.decode(decoder2);
                }
            }
            Decoder decoder17 = decoder0.readPointer(104, true);
            result.showTriggerTimestamp = Time.decode(decoder17);
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
        encoder0.encode((Struct) this.title, 8, false);
        encoder0.encode(this.direction, 16);
        encoder0.encode(this.renotify, 20, 0);
        encoder0.encode(this.silent, 20, 1);
        encoder0.encode(this.requireInteraction, 20, 2);
        encoder0.encode(this.lang, 24, true);
        encoder0.encode((Struct) this.body, 32, false);
        encoder0.encode(this.tag, 40, false);
        encoder0.encode((Struct) this.image, 48, false);
        encoder0.encode((Struct) this.icon, 56, false);
        encoder0.encode((Struct) this.badge, 64, false);
        encoder0.encode(this.vibrationPattern, 72, 1, -1);
        encoder0.encode(this.timestamp, 80);
        encoder0.encode(this.data, 88, 1, -1);
        if (this.actions == null) {
            encoder0.encodeNullPointer(96, true);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.actions.length, 96, -1);
            for (int i0 = 0; i0 < this.actions.length; i0++) {
                encoder1.encode((Struct) this.actions[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode((Struct) this.showTriggerTimestamp, 104, true);
    }
}
