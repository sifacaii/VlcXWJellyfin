package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ParsedFeaturePolicyDeclaration.class */
public final class ParsedFeaturePolicyDeclaration extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int feature;
    public Map<Origin, PolicyValue> values;
    public PolicyValue fallbackValue;
    public PolicyValue opaqueValue;

    private ParsedFeaturePolicyDeclaration(int version) {
        super(40, version);
    }

    public ParsedFeaturePolicyDeclaration() {
        this(0);
    }

    public static ParsedFeaturePolicyDeclaration deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ParsedFeaturePolicyDeclaration deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ParsedFeaturePolicyDeclaration decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ParsedFeaturePolicyDeclaration result = new ParsedFeaturePolicyDeclaration(elementsOrVersion);
            result.feature = decoder0.readInt(8);
            FeaturePolicyFeature.validate(result.feature);
            Decoder decoder1 = decoder0.readPointer(16, false);
            decoder1.readDataHeaderForMap();
            Decoder decoder2 = decoder1.readPointer(8, false);
            DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
            Origin[] keys0 = new Origin[si2.elementsOrVersion];
            for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                Decoder decoder3 = decoder2.readPointer(8 + (8 * i2), false);
                keys0[i2] = Origin.decode(decoder3);
            }
            Decoder decoder22 = decoder1.readPointer(16, false);
            DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
            PolicyValue[] values0 = new PolicyValue[si22.elementsOrVersion];
            for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
                Decoder decoder32 = decoder22.readPointer(8 + (8 * i22), false);
                values0[i22] = PolicyValue.decode(decoder32);
            }
            result.values = new HashMap();
            for (int index0 = 0; index0 < keys0.length; index0++) {
                result.values.put(keys0[index0], values0[index0]);
            }
            result.fallbackValue = PolicyValue.decode(decoder0.readPointer(24, false));
            result.opaqueValue = PolicyValue.decode(decoder0.readPointer(32, false));
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
        encoder0.encode(this.feature, 8);
        if (this.values == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder1 = encoder0.encoderForMap(16);
            int size0 = this.values.size();
            Origin[] keys0 = new Origin[size0];
            PolicyValue[] values0 = new PolicyValue[size0];
            int index0 = 0;
            for (Map.Entry<Origin, PolicyValue> entry0 : this.values.entrySet()) {
                keys0[index0] = entry0.getKey();
                values0[index0] = entry0.getValue();
                index0++;
            }
            Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
            for (int i1 = 0; i1 < keys0.length; i1++) {
                encoder2.encode((Struct) keys0[i1], 8 + (8 * i1), false);
            }
            Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
            for (int i12 = 0; i12 < values0.length; i12++) {
                encoder22.encode((Struct) values0[i12], 8 + (8 * i12), false);
            }
        }
        encoder0.encode((Struct) this.fallbackValue, 24, false);
        encoder0.encode((Struct) this.opaqueValue, 32, false);
    }
}
