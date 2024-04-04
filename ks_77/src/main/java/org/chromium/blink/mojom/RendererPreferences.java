package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Hinting;
import org.chromium.gfx.mojom.SubpixelRendering;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RendererPreferences.class */
public final class RendererPreferences extends Struct {
    private static final int STRUCT_SIZE = 88;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(88, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean canAcceptLoadDrops;
    public boolean shouldAntialiasText;
    public int hinting;
    public boolean useAutohinter;
    public boolean useBitmaps;
    public int subpixelRendering;
    public boolean useSubpixelPositioning;
    public int focusRingColor;
    public int activeSelectionBgColor;
    public int activeSelectionFgColor;
    public int inactiveSelectionBgColor;
    public int inactiveSelectionFgColor;
    public boolean browserHandlesAllTopLevelRequests;
    public TimeDelta caretBlinkInterval;
    public boolean useCustomColors;
    public boolean enableReferrers;
    public boolean allowCrossOriginAuthPrompt;
    public boolean enableDoNotTrack;
    public boolean enableEncryptedMedia;
    public String webrtcIpHandlingPolicy;
    public short webrtcUdpMinPort;
    public short webrtcUdpMaxPort;
    public String userAgentOverride;
    public String acceptLanguages;
    public boolean disableClientBlockedErrorPage;
    public boolean pluginFullscreenAllowed;
    public String networkContryIso;

    private RendererPreferences(int version) {
        super(88, version);
        this.canAcceptLoadDrops = true;
        this.shouldAntialiasText = true;
        this.hinting = 2;
        this.useAutohinter = false;
        this.useBitmaps = false;
        this.subpixelRendering = 0;
        this.useSubpixelPositioning = false;
        this.focusRingColor = -1730816;
        this.activeSelectionBgColor = -14774017;
        this.activeSelectionFgColor = -1;
        this.inactiveSelectionBgColor = -3618616;
        this.inactiveSelectionFgColor = -13487566;
        this.browserHandlesAllTopLevelRequests = false;
        this.useCustomColors = true;
        this.enableReferrers = true;
        this.allowCrossOriginAuthPrompt = false;
        this.enableDoNotTrack = false;
        this.enableEncryptedMedia = true;
        this.webrtcUdpMinPort = (short) 0;
        this.webrtcUdpMaxPort = (short) 0;
        this.disableClientBlockedErrorPage = false;
        this.pluginFullscreenAllowed = true;
    }

    public RendererPreferences() {
        this(0);
    }

    public static RendererPreferences deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static RendererPreferences deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static RendererPreferences decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            RendererPreferences result = new RendererPreferences(elementsOrVersion);
            result.canAcceptLoadDrops = decoder0.readBoolean(8, 0);
            result.shouldAntialiasText = decoder0.readBoolean(8, 1);
            result.useAutohinter = decoder0.readBoolean(8, 2);
            result.useBitmaps = decoder0.readBoolean(8, 3);
            result.useSubpixelPositioning = decoder0.readBoolean(8, 4);
            result.browserHandlesAllTopLevelRequests = decoder0.readBoolean(8, 5);
            result.useCustomColors = decoder0.readBoolean(8, 6);
            result.enableReferrers = decoder0.readBoolean(8, 7);
            result.allowCrossOriginAuthPrompt = decoder0.readBoolean(9, 0);
            result.enableDoNotTrack = decoder0.readBoolean(9, 1);
            result.enableEncryptedMedia = decoder0.readBoolean(9, 2);
            result.disableClientBlockedErrorPage = decoder0.readBoolean(9, 3);
            result.pluginFullscreenAllowed = decoder0.readBoolean(9, 4);
            result.webrtcUdpMinPort = decoder0.readShort(10);
            result.hinting = decoder0.readInt(12);
            Hinting.validate(result.hinting);
            result.subpixelRendering = decoder0.readInt(16);
            SubpixelRendering.validate(result.subpixelRendering);
            result.focusRingColor = decoder0.readInt(20);
            result.activeSelectionBgColor = decoder0.readInt(24);
            result.activeSelectionFgColor = decoder0.readInt(28);
            result.inactiveSelectionBgColor = decoder0.readInt(32);
            result.inactiveSelectionFgColor = decoder0.readInt(36);
            Decoder decoder1 = decoder0.readPointer(40, true);
            result.caretBlinkInterval = TimeDelta.decode(decoder1);
            result.webrtcIpHandlingPolicy = decoder0.readString(48, false);
            result.webrtcUdpMaxPort = decoder0.readShort(56);
            result.userAgentOverride = decoder0.readString(64, false);
            result.acceptLanguages = decoder0.readString(72, false);
            result.networkContryIso = decoder0.readString(80, false);
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
        encoder0.encode(this.canAcceptLoadDrops, 8, 0);
        encoder0.encode(this.shouldAntialiasText, 8, 1);
        encoder0.encode(this.useAutohinter, 8, 2);
        encoder0.encode(this.useBitmaps, 8, 3);
        encoder0.encode(this.useSubpixelPositioning, 8, 4);
        encoder0.encode(this.browserHandlesAllTopLevelRequests, 8, 5);
        encoder0.encode(this.useCustomColors, 8, 6);
        encoder0.encode(this.enableReferrers, 8, 7);
        encoder0.encode(this.allowCrossOriginAuthPrompt, 9, 0);
        encoder0.encode(this.enableDoNotTrack, 9, 1);
        encoder0.encode(this.enableEncryptedMedia, 9, 2);
        encoder0.encode(this.disableClientBlockedErrorPage, 9, 3);
        encoder0.encode(this.pluginFullscreenAllowed, 9, 4);
        encoder0.encode(this.webrtcUdpMinPort, 10);
        encoder0.encode(this.hinting, 12);
        encoder0.encode(this.subpixelRendering, 16);
        encoder0.encode(this.focusRingColor, 20);
        encoder0.encode(this.activeSelectionBgColor, 24);
        encoder0.encode(this.activeSelectionFgColor, 28);
        encoder0.encode(this.inactiveSelectionBgColor, 32);
        encoder0.encode(this.inactiveSelectionFgColor, 36);
        encoder0.encode((Struct) this.caretBlinkInterval, 40, true);
        encoder0.encode(this.webrtcIpHandlingPolicy, 48, false);
        encoder0.encode(this.webrtcUdpMaxPort, 56);
        encoder0.encode(this.userAgentOverride, 64, false);
        encoder0.encode(this.acceptLanguages, 72, false);
        encoder0.encode(this.networkContryIso, 80, false);
    }
}
