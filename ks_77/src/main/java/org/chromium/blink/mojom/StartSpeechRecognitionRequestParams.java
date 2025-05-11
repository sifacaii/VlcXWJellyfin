package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Origin;

public final class StartSpeechRecognitionRequestParams extends Struct {
    private static final int STRUCT_SIZE = 56;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(56, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public InterfaceRequest<SpeechRecognitionSession> sessionRequest;

    public SpeechRecognitionSessionClient client;

    public String language;

    public SpeechRecognitionGrammar[] grammars;

    public Origin origin;

    public int maxHypotheses;

    public boolean continuous;

    public boolean interimResults;

    private StartSpeechRecognitionRequestParams(int version) {
        super(56, version);
    }

    public StartSpeechRecognitionRequestParams() {
        this(0);
    }

    public static StartSpeechRecognitionRequestParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static StartSpeechRecognitionRequestParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static StartSpeechRecognitionRequestParams decode(Decoder decoder0) {
        StartSpeechRecognitionRequestParams result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new StartSpeechRecognitionRequestParams(elementsOrVersion);
            result.sessionRequest = decoder0.readInterfaceRequest(8, false);
            result.client = (SpeechRecognitionSessionClient)decoder0.readServiceInterface(12, false, SpeechRecognitionSessionClient.MANAGER);
            result.maxHypotheses = decoder0.readInt(20);
            result.language = decoder0.readString(24, false);
            Decoder decoder1 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.grammars = new SpeechRecognitionGrammar[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                result.grammars[i1] = SpeechRecognitionGrammar.decode(decoder2);
            }
            decoder1 = decoder0.readPointer(40, false);
            result.origin = Origin.decode(decoder1);
            result.continuous = decoder0.readBoolean(48, 0);
            result.interimResults = decoder0.readBoolean(48, 1);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.sessionRequest, 8, false);
        encoder0.encode(this.client, 12, false, SpeechRecognitionSessionClient.MANAGER);
        encoder0.encode(this.maxHypotheses, 20);
        encoder0.encode(this.language, 24, false);
        if (this.grammars == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.grammars.length, 32, -1);
            for (int i0 = 0; i0 < this.grammars.length; i0++)
                encoder1.encode(this.grammars[i0], 8 + 8 * i0, false);
        }
        encoder0.encode((Struct)this.origin, 40, false);
        encoder0.encode(this.continuous, 48, 0);
        encoder0.encode(this.interimResults, 48, 1);
    }
}
