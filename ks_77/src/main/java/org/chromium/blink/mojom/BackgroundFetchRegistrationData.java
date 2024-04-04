package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundFetchRegistrationData.class */
public final class BackgroundFetchRegistrationData extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String developerId;
    public long uploadTotal;
    public long uploaded;
    public long downloadTotal;
    public long downloaded;
    public int result;
    public int failureReason;

    private BackgroundFetchRegistrationData(int version) {
        super(56, version);
        this.result = 0;
        this.failureReason = 0;
    }

    public BackgroundFetchRegistrationData() {
        this(0);
    }

    public static BackgroundFetchRegistrationData deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BackgroundFetchRegistrationData deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundFetchRegistrationData decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BackgroundFetchRegistrationData result = new BackgroundFetchRegistrationData(elementsOrVersion);
            result.developerId = decoder0.readString(8, false);
            result.uploadTotal = decoder0.readLong(16);
            result.uploaded = decoder0.readLong(24);
            result.downloadTotal = decoder0.readLong(32);
            result.downloaded = decoder0.readLong(40);
            result.result = decoder0.readInt(48);
            BackgroundFetchResult.validate(result.result);
            result.failureReason = decoder0.readInt(52);
            BackgroundFetchFailureReason.validate(result.failureReason);
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
        encoder0.encode(this.developerId, 8, false);
        encoder0.encode(this.uploadTotal, 16);
        encoder0.encode(this.uploaded, 24);
        encoder0.encode(this.downloadTotal, 32);
        encoder0.encode(this.downloaded, 40);
        encoder0.encode(this.result, 48);
        encoder0.encode(this.failureReason, 52);
    }
}
