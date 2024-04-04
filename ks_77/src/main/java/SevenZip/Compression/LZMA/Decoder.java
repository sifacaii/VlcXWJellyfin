package SevenZip.Compression.LZMA;

import SevenZip.Compression.LZ.OutWindow;
import SevenZip.Compression.RangeCoder.BitTreeDecoder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.chromium.blink.mojom.WebFeature;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/Compression/LZMA/Decoder.class */
public class Decoder {
    OutWindow m_OutWindow = new OutWindow();
    SevenZip.Compression.RangeCoder.Decoder m_RangeDecoder = new SevenZip.Compression.RangeCoder.Decoder();
    short[] m_IsMatchDecoders = new short[WebFeature.INPUT_TYPE_PASSWORD];
    short[] m_IsRepDecoders = new short[12];
    short[] m_IsRepG0Decoders = new short[12];
    short[] m_IsRepG1Decoders = new short[12];
    short[] m_IsRepG2Decoders = new short[12];
    short[] m_IsRep0LongDecoders = new short[WebFeature.INPUT_TYPE_PASSWORD];
    BitTreeDecoder[] m_PosSlotDecoder = new BitTreeDecoder[4];
    short[] m_PosDecoders = new short[114];
    BitTreeDecoder m_PosAlignDecoder = new BitTreeDecoder(4);
    LenDecoder m_LenDecoder = new LenDecoder();
    LenDecoder m_RepLenDecoder = new LenDecoder();
    LiteralDecoder m_LiteralDecoder = new LiteralDecoder();
    int m_DictionarySize = -1;
    int m_DictionarySizeCheck = -1;
    int m_PosStateMask;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/Compression/LZMA/Decoder$LenDecoder.class */
    public class LenDecoder {
        short[] m_Choice = new short[2];
        BitTreeDecoder[] m_LowCoder = new BitTreeDecoder[16];
        BitTreeDecoder[] m_MidCoder = new BitTreeDecoder[16];
        BitTreeDecoder m_HighCoder = new BitTreeDecoder(8);
        int m_NumPosStates = 0;

        LenDecoder() {
        }

        public void Create(int numPosStates) {
            while (this.m_NumPosStates < numPosStates) {
                this.m_LowCoder[this.m_NumPosStates] = new BitTreeDecoder(3);
                this.m_MidCoder[this.m_NumPosStates] = new BitTreeDecoder(3);
                this.m_NumPosStates++;
            }
        }

        public void Init() {
            SevenZip.Compression.RangeCoder.Decoder.InitBitModels(this.m_Choice);
            for (int posState = 0; posState < this.m_NumPosStates; posState++) {
                this.m_LowCoder[posState].Init();
                this.m_MidCoder[posState].Init();
            }
            this.m_HighCoder.Init();
        }

        public int Decode(SevenZip.Compression.RangeCoder.Decoder rangeDecoder, int posState) throws IOException {
            int symbol;
            if (rangeDecoder.DecodeBit(this.m_Choice, 0) == 0) {
                return this.m_LowCoder[posState].Decode(rangeDecoder);
            }
            if (rangeDecoder.DecodeBit(this.m_Choice, 1) == 0) {
                symbol = 8 + this.m_MidCoder[posState].Decode(rangeDecoder);
            } else {
                symbol = 8 + 8 + this.m_HighCoder.Decode(rangeDecoder);
            }
            return symbol;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/Compression/LZMA/Decoder$LiteralDecoder.class */
    public class LiteralDecoder {
        Decoder2[] m_Coders;
        int m_NumPrevBits;
        int m_NumPosBits;
        int m_PosMask;

        LiteralDecoder() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/Compression/LZMA/Decoder$LiteralDecoder$Decoder2.class */
        public class Decoder2 {
            short[] m_Decoders = new short[WebFeature.SVGSMIL_ANIMATION_IN_IMAGE_REGARDLESS_OF_CACHE];

            Decoder2() {
            }

            public void Init() {
                SevenZip.Compression.RangeCoder.Decoder.InitBitModels(this.m_Decoders);
            }

            public byte DecodeNormal(SevenZip.Compression.RangeCoder.Decoder rangeDecoder) throws IOException {
                int symbol = 1;
                do {
                    symbol = (symbol << 1) | rangeDecoder.DecodeBit(this.m_Decoders, symbol);
                } while (symbol < 256);
                return (byte) symbol;
            }

            public byte DecodeWithMatchByte(SevenZip.Compression.RangeCoder.Decoder rangeDecoder, byte matchByte) throws IOException {
                int symbol = 1;
                while (true) {
                    int matchBit = (matchByte >> 7) & 1;
                    matchByte = (byte) (matchByte << 1);
                    int bit = rangeDecoder.DecodeBit(this.m_Decoders, ((1 + matchBit) << 8) + symbol);
                    symbol = (symbol << 1) | bit;
                    if (matchBit != bit) {
                        while (symbol < 256) {
                            symbol = (symbol << 1) | rangeDecoder.DecodeBit(this.m_Decoders, symbol);
                        }
                    } else if (symbol >= 256) {
                        break;
                    }
                }
                return (byte) symbol;
            }
        }

        public void Create(int numPosBits, int numPrevBits) {
            if (this.m_Coders != null && this.m_NumPrevBits == numPrevBits && this.m_NumPosBits == numPosBits) {
                return;
            }
            this.m_NumPosBits = numPosBits;
            this.m_PosMask = (1 << numPosBits) - 1;
            this.m_NumPrevBits = numPrevBits;
            int numStates = 1 << (this.m_NumPrevBits + this.m_NumPosBits);
            this.m_Coders = new Decoder2[numStates];
            for (int i = 0; i < numStates; i++) {
                this.m_Coders[i] = new Decoder2();
            }
        }

        public void Init() {
            int numStates = 1 << (this.m_NumPrevBits + this.m_NumPosBits);
            for (int i = 0; i < numStates; i++) {
                this.m_Coders[i].Init();
            }
        }

        Decoder2 GetDecoder(int pos, byte prevByte) {
            return this.m_Coders[((pos & this.m_PosMask) << this.m_NumPrevBits) + ((prevByte & 255) >>> (8 - this.m_NumPrevBits))];
        }
    }

    public Decoder() {
        for (int i = 0; i < 4; i++) {
            this.m_PosSlotDecoder[i] = new BitTreeDecoder(6);
        }
    }

    boolean SetDictionarySize(int dictionarySize) {
        if (dictionarySize < 0) {
            return false;
        }
        if (this.m_DictionarySize != dictionarySize) {
            this.m_DictionarySize = dictionarySize;
            this.m_DictionarySizeCheck = Math.max(this.m_DictionarySize, 1);
            this.m_OutWindow.Create(Math.max(this.m_DictionarySizeCheck, 4096));
            return true;
        }
        return true;
    }

    boolean SetLcLpPb(int lc, int lp, int pb) {
        if (lc > 8 || lp > 4 || pb > 4) {
            return false;
        }
        this.m_LiteralDecoder.Create(lp, lc);
        int numPosStates = 1 << pb;
        this.m_LenDecoder.Create(numPosStates);
        this.m_RepLenDecoder.Create(numPosStates);
        this.m_PosStateMask = numPosStates - 1;
        return true;
    }

    void Init() throws IOException {
        this.m_OutWindow.Init(false);
        SevenZip.Compression.RangeCoder.Decoder.InitBitModels(this.m_IsMatchDecoders);
        SevenZip.Compression.RangeCoder.Decoder.InitBitModels(this.m_IsRep0LongDecoders);
        SevenZip.Compression.RangeCoder.Decoder.InitBitModels(this.m_IsRepDecoders);
        SevenZip.Compression.RangeCoder.Decoder.InitBitModels(this.m_IsRepG0Decoders);
        SevenZip.Compression.RangeCoder.Decoder.InitBitModels(this.m_IsRepG1Decoders);
        SevenZip.Compression.RangeCoder.Decoder.InitBitModels(this.m_IsRepG2Decoders);
        SevenZip.Compression.RangeCoder.Decoder.InitBitModels(this.m_PosDecoders);
        this.m_LiteralDecoder.Init();
        for (int i = 0; i < 4; i++) {
            this.m_PosSlotDecoder[i].Init();
        }
        this.m_LenDecoder.Init();
        this.m_RepLenDecoder.Init();
        this.m_PosAlignDecoder.Init();
        this.m_RangeDecoder.Init();
    }

    public boolean Code(InputStream inStream, OutputStream outStream, long outSize) throws IOException {
        byte DecodeNormal;
        int len;
        int distance;
        this.m_RangeDecoder.SetStream(inStream);
        this.m_OutWindow.SetStream(outStream);
        Init();
        int state = Base.StateInit();
        int rep0 = 0;
        int rep1 = 0;
        int rep2 = 0;
        int rep3 = 0;
        long nowPos64 = 0;
        byte prevByte = 0;
        while (true) {
            if (outSize >= 0 && nowPos64 >= outSize) {
                break;
            }
            int posState = ((int) nowPos64) & this.m_PosStateMask;
            if (this.m_RangeDecoder.DecodeBit(this.m_IsMatchDecoders, (state << 4) + posState) == 0) {
                LiteralDecoder.Decoder2 decoder2 = this.m_LiteralDecoder.GetDecoder((int) nowPos64, prevByte);
                if (!Base.StateIsCharState(state)) {
                    DecodeNormal = decoder2.DecodeWithMatchByte(this.m_RangeDecoder, this.m_OutWindow.GetByte(rep0));
                } else {
                    DecodeNormal = decoder2.DecodeNormal(this.m_RangeDecoder);
                }
                prevByte = DecodeNormal;
                this.m_OutWindow.PutByte(prevByte);
                state = Base.StateUpdateChar(state);
                nowPos64++;
            } else {
                if (this.m_RangeDecoder.DecodeBit(this.m_IsRepDecoders, state) == 1) {
                    len = 0;
                    if (this.m_RangeDecoder.DecodeBit(this.m_IsRepG0Decoders, state) == 0) {
                        if (this.m_RangeDecoder.DecodeBit(this.m_IsRep0LongDecoders, (state << 4) + posState) == 0) {
                            state = Base.StateUpdateShortRep(state);
                            len = 1;
                        }
                    } else {
                        if (this.m_RangeDecoder.DecodeBit(this.m_IsRepG1Decoders, state) == 0) {
                            distance = rep1;
                        } else {
                            if (this.m_RangeDecoder.DecodeBit(this.m_IsRepG2Decoders, state) == 0) {
                                distance = rep2;
                            } else {
                                distance = rep3;
                                rep3 = rep2;
                            }
                            rep2 = rep1;
                        }
                        rep1 = rep0;
                        rep0 = distance;
                    }
                    if (len == 0) {
                        len = this.m_RepLenDecoder.Decode(this.m_RangeDecoder, posState) + 2;
                        state = Base.StateUpdateRep(state);
                    }
                } else {
                    rep3 = rep2;
                    rep2 = rep1;
                    rep1 = rep0;
                    len = 2 + this.m_LenDecoder.Decode(this.m_RangeDecoder, posState);
                    state = Base.StateUpdateMatch(state);
                    int posSlot = this.m_PosSlotDecoder[Base.GetLenToPosState(len)].Decode(this.m_RangeDecoder);
                    if (posSlot >= 4) {
                        int numDirectBits = (posSlot >> 1) - 1;
                        int rep02 = (2 | (posSlot & 1)) << numDirectBits;
                        if (posSlot < 14) {
                            rep0 = rep02 + BitTreeDecoder.ReverseDecode(this.m_PosDecoders, (rep02 - posSlot) - 1, this.m_RangeDecoder, numDirectBits);
                        } else {
                            rep0 = rep02 + (this.m_RangeDecoder.DecodeDirectBits(numDirectBits - 4) << 4) + this.m_PosAlignDecoder.ReverseDecode(this.m_RangeDecoder);
                            if (rep0 < 0) {
                                if (rep0 != -1) {
                                    return false;
                                }
                            }
                        }
                    } else {
                        rep0 = posSlot;
                    }
                }
                if (rep0 >= nowPos64 || rep0 >= this.m_DictionarySizeCheck) {
                    return false;
                }
                this.m_OutWindow.CopyBlock(rep0, len);
                nowPos64 += len;
                prevByte = this.m_OutWindow.GetByte(0);
            }
        }
        this.m_OutWindow.Flush();
        this.m_OutWindow.ReleaseStream();
        this.m_RangeDecoder.ReleaseStream();
        return true;
    }

    public boolean SetDecoderProperties(byte[] properties) {
        if (properties.length < 5) {
            return false;
        }
        int val = properties[0] & 255;
        int lc = val % 9;
        int remainder = val / 9;
        int lp = remainder % 5;
        int pb = remainder / 5;
        int dictionarySize = 0;
        for (int i = 0; i < 4; i++) {
            dictionarySize += (properties[1 + i] & 255) << (i * 8);
        }
        if (!SetLcLpPb(lc, lp, pb)) {
            return false;
        }
        return SetDictionarySize(dictionarySize);
    }
}
