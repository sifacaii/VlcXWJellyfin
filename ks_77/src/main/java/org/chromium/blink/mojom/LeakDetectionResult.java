package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/LeakDetectionResult.class */
public final class LeakDetectionResult extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int numberOfLiveAudioNodes;
    public int numberOfLiveDocuments;
    public int numberOfLiveNodes;
    public int numberOfLiveLayoutObjects;
    public int numberOfLiveResources;
    public int numberOfLiveContextLifecycleStateObservers;
    public int numberOfLiveScriptPromises;
    public int numberOfLiveFrames;
    public int numberOfLiveV8PerContextData;
    public int numberOfWorkerGlobalScopes;
    public int numberOfLiveUaCssResources;
    public int numberOfLiveResourceFetchers;

    private LeakDetectionResult(int version) {
        super(56, version);
    }

    public LeakDetectionResult() {
        this(0);
    }

    public static LeakDetectionResult deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static LeakDetectionResult deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static LeakDetectionResult decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            LeakDetectionResult result = new LeakDetectionResult(elementsOrVersion);
            result.numberOfLiveAudioNodes = decoder0.readInt(8);
            result.numberOfLiveDocuments = decoder0.readInt(12);
            result.numberOfLiveNodes = decoder0.readInt(16);
            result.numberOfLiveLayoutObjects = decoder0.readInt(20);
            result.numberOfLiveResources = decoder0.readInt(24);
            result.numberOfLiveContextLifecycleStateObservers = decoder0.readInt(28);
            result.numberOfLiveScriptPromises = decoder0.readInt(32);
            result.numberOfLiveFrames = decoder0.readInt(36);
            result.numberOfLiveV8PerContextData = decoder0.readInt(40);
            result.numberOfWorkerGlobalScopes = decoder0.readInt(44);
            result.numberOfLiveUaCssResources = decoder0.readInt(48);
            result.numberOfLiveResourceFetchers = decoder0.readInt(52);
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
        encoder0.encode(this.numberOfLiveAudioNodes, 8);
        encoder0.encode(this.numberOfLiveDocuments, 12);
        encoder0.encode(this.numberOfLiveNodes, 16);
        encoder0.encode(this.numberOfLiveLayoutObjects, 20);
        encoder0.encode(this.numberOfLiveResources, 24);
        encoder0.encode(this.numberOfLiveContextLifecycleStateObservers, 28);
        encoder0.encode(this.numberOfLiveScriptPromises, 32);
        encoder0.encode(this.numberOfLiveFrames, 36);
        encoder0.encode(this.numberOfLiveV8PerContextData, 40);
        encoder0.encode(this.numberOfWorkerGlobalScopes, 44);
        encoder0.encode(this.numberOfLiveUaCssResources, 48);
        encoder0.encode(this.numberOfLiveResourceFetchers, 52);
    }
}
