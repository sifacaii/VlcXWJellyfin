package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CspViolationParams.class */
public final class CspViolationParams extends Struct {
    private static final int STRUCT_SIZE = 72;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(72, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String directive;
    public String effectiveDirective;
    public String consoleMessage;
    public String blockedUrl;
    public String[] reportEndpoints;
    public boolean useReportingApi;
    public String header;
    public int disposition;
    public boolean afterRedirect;
    public SourceLocation sourceLocation;

    private CspViolationParams(int version) {
        super(72, version);
    }

    public CspViolationParams() {
        this(0);
    }

    public static CspViolationParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CspViolationParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CspViolationParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CspViolationParams result = new CspViolationParams(elementsOrVersion);
            result.directive = decoder0.readString(8, false);
            result.effectiveDirective = decoder0.readString(16, false);
            result.consoleMessage = decoder0.readString(24, false);
            result.blockedUrl = decoder0.readString(32, false);
            Decoder decoder1 = decoder0.readPointer(40, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.reportEndpoints = new String[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.reportEndpoints[i1] = decoder1.readString(8 + (8 * i1), false);
            }
            result.useReportingApi = decoder0.readBoolean(48, 0);
            result.afterRedirect = decoder0.readBoolean(48, 1);
            result.disposition = decoder0.readInt(52);
            WebContentSecurityPolicyType.validate(result.disposition);
            result.header = decoder0.readString(56, false);
            result.sourceLocation = SourceLocation.decode(decoder0.readPointer(64, false));
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
        encoder0.encode(this.directive, 8, false);
        encoder0.encode(this.effectiveDirective, 16, false);
        encoder0.encode(this.consoleMessage, 24, false);
        encoder0.encode(this.blockedUrl, 32, false);
        if (this.reportEndpoints == null) {
            encoder0.encodeNullPointer(40, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.reportEndpoints.length, 40, -1);
            for (int i0 = 0; i0 < this.reportEndpoints.length; i0++) {
                encoder1.encode(this.reportEndpoints[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.useReportingApi, 48, 0);
        encoder0.encode(this.afterRedirect, 48, 1);
        encoder0.encode(this.disposition, 52);
        encoder0.encode(this.header, 56, false);
        encoder0.encode((Struct) this.sourceLocation, 64, false);
    }
}
