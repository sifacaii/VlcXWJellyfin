package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigOverrides.class */
public final class DnsConfigOverrides extends Struct {
    private static final int STRUCT_SIZE = 80;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(80, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public IpEndPoint[] nameservers;
    public String[] search;
    public DnsHost[] hosts;
    public int appendToMultiLabelName;
    public int randomizePorts;
    public byte ndots;
    public TimeDelta timeout;
    public int attempts;
    public int rotate;
    public int useLocalIpv6;
    public DnsOverHttpsServer[] dnsOverHttpsServers;
    public int secureDnsMode;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigOverrides$Tristate.class */
    public static final class Tristate {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int NO_OVERRIDE = 0;
        public static final int TRISTATE_TRUE = 1;
        public static final int TRISTATE_FALSE = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Tristate() {
        }
    }

    private DnsConfigOverrides(int version) {
        super(80, version);
        this.appendToMultiLabelName = 0;
        this.randomizePorts = 0;
        this.ndots = (byte) -1;
        this.attempts = -1;
        this.rotate = 0;
        this.useLocalIpv6 = 0;
        this.secureDnsMode = 0;
    }

    public DnsConfigOverrides() {
        this(0);
    }

    public static DnsConfigOverrides deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DnsConfigOverrides deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DnsConfigOverrides decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DnsConfigOverrides result = new DnsConfigOverrides(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, true);
            if (decoder1 == null) {
                result.nameservers = null;
            } else {
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.nameservers = new IpEndPoint[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.nameservers[i1] = IpEndPoint.decode(decoder2);
                }
            }
            Decoder decoder12 = decoder0.readPointer(16, true);
            if (decoder12 == null) {
                result.search = null;
            } else {
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.search = new String[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    result.search[i12] = decoder12.readString(8 + (8 * i12), false);
                }
            }
            Decoder decoder13 = decoder0.readPointer(24, true);
            if (decoder13 == null) {
                result.hosts = null;
            } else {
                DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
                result.hosts = new DnsHost[si13.elementsOrVersion];
                for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                    Decoder decoder22 = decoder13.readPointer(8 + (8 * i13), false);
                    result.hosts[i13] = DnsHost.decode(decoder22);
                }
            }
            result.appendToMultiLabelName = decoder0.readInt(32);
            Tristate.validate(result.appendToMultiLabelName);
            result.randomizePorts = decoder0.readInt(36);
            Tristate.validate(result.randomizePorts);
            result.ndots = decoder0.readByte(40);
            result.attempts = decoder0.readInt(44);
            result.timeout = TimeDelta.decode(decoder0.readPointer(48, true));
            result.rotate = decoder0.readInt(56);
            Tristate.validate(result.rotate);
            result.useLocalIpv6 = decoder0.readInt(60);
            Tristate.validate(result.useLocalIpv6);
            Decoder decoder14 = decoder0.readPointer(64, true);
            if (decoder14 == null) {
                result.dnsOverHttpsServers = null;
            } else {
                DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
                result.dnsOverHttpsServers = new DnsOverHttpsServer[si14.elementsOrVersion];
                for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
                    Decoder decoder23 = decoder14.readPointer(8 + (8 * i14), false);
                    result.dnsOverHttpsServers[i14] = DnsOverHttpsServer.decode(decoder23);
                }
            }
            result.secureDnsMode = decoder0.readInt(72);
            OptionalSecureDnsMode.validate(result.secureDnsMode);
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
        if (this.nameservers == null) {
            encoder0.encodeNullPointer(8, true);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.nameservers.length, 8, -1);
            for (int i0 = 0; i0 < this.nameservers.length; i0++) {
                encoder1.encode((Struct) this.nameservers[i0], 8 + (8 * i0), false);
            }
        }
        if (this.search == null) {
            encoder0.encodeNullPointer(16, true);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.search.length, 16, -1);
            for (int i02 = 0; i02 < this.search.length; i02++) {
                encoder12.encode(this.search[i02], 8 + (8 * i02), false);
            }
        }
        if (this.hosts == null) {
            encoder0.encodeNullPointer(24, true);
        } else {
            Encoder encoder13 = encoder0.encodePointerArray(this.hosts.length, 24, -1);
            for (int i03 = 0; i03 < this.hosts.length; i03++) {
                encoder13.encode((Struct) this.hosts[i03], 8 + (8 * i03), false);
            }
        }
        encoder0.encode(this.appendToMultiLabelName, 32);
        encoder0.encode(this.randomizePorts, 36);
        encoder0.encode(this.ndots, 40);
        encoder0.encode(this.attempts, 44);
        encoder0.encode((Struct) this.timeout, 48, true);
        encoder0.encode(this.rotate, 56);
        encoder0.encode(this.useLocalIpv6, 60);
        if (this.dnsOverHttpsServers == null) {
            encoder0.encodeNullPointer(64, true);
        } else {
            Encoder encoder14 = encoder0.encodePointerArray(this.dnsOverHttpsServers.length, 64, -1);
            for (int i04 = 0; i04 < this.dnsOverHttpsServers.length; i04++) {
                encoder14.encode((Struct) this.dnsOverHttpsServers[i04], 8 + (8 * i04), false);
            }
        }
        encoder0.encode(this.secureDnsMode, 72);
    }
}
