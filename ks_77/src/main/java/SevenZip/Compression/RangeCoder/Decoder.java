package SevenZip.Compression.RangeCoder;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/Compression/RangeCoder/Decoder.class */
public class Decoder {
    static final int kTopMask = -16777216;
    static final int kNumBitModelTotalBits = 11;
    static final int kBitModelTotal = 2048;
    static final int kNumMoveBits = 5;
    int Range;
    int Code;
    InputStream Stream;

    public final void SetStream(InputStream stream) {
        this.Stream = stream;
    }

    public final void ReleaseStream() {
        this.Stream = null;
    }

    public final void Init() throws IOException {
        this.Code = 0;
        this.Range = -1;
        for (int i = 0; i < 5; i++) {
            this.Code = (this.Code << 8) | this.Stream.read();
        }
    }

    public final int DecodeDirectBits(int numTotalBits) throws IOException {
        int result = 0;
        for (int i = numTotalBits; i != 0; i--) {
            this.Range >>>= 1;
            int t = (this.Code - this.Range) >>> 31;
            this.Code -= this.Range & (t - 1);
            result = (result << 1) | (1 - t);
            if ((this.Range & kTopMask) == 0) {
                this.Code = (this.Code << 8) | this.Stream.read();
                this.Range <<= 8;
            }
        }
        return result;
    }

    public int DecodeBit(short[] probs, int index) throws IOException {
        short s = probs[index];
        int newBound = (this.Range >>> 11) * s;
        if ((this.Code ^ Integer.MIN_VALUE) < (newBound ^ Integer.MIN_VALUE)) {
            this.Range = newBound;
            probs[index] = (short) (s + ((2048 - s) >>> 5));
            if ((this.Range & kTopMask) == 0) {
                this.Code = (this.Code << 8) | this.Stream.read();
                this.Range <<= 8;
                return 0;
            }
            return 0;
        }
        this.Range -= newBound;
        this.Code -= newBound;
        probs[index] = (short) (s - (s >>> 5));
        if ((this.Range & kTopMask) == 0) {
            this.Code = (this.Code << 8) | this.Stream.read();
            this.Range <<= 8;
            return 1;
        }
        return 1;
    }

    public static void InitBitModels(short[] probs) {
        for (int i = 0; i < probs.length; i++) {
            probs[i] = 1024;
        }
    }
}
