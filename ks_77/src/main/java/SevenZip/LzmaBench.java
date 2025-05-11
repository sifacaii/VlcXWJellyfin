package SevenZip;

import SevenZip.Compression.LZMA.Decoder;
import SevenZip.Compression.LZMA.Encoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaBench.class */
public class LzmaBench {
    static final int kAdditionalSize = 2097152;
    static final int kCompressedAdditionalSize = 1024;
    static final int kSubBits = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaBench$CRandomGenerator.class */
    public static class CRandomGenerator {
        int A1;
        int A2;

        public CRandomGenerator() {
            Init();
        }

        public void Init() {
            this.A1 = 362436069;
            this.A2 = 521288629;
        }

        public int GetRnd() {
            int i = (36969 * (this.A1 & 65535)) + (this.A1 >>> 16);
            this.A1 = i;
            int i2 = (18000 * (this.A2 & 65535)) + (this.A2 >>> 16);
            this.A2 = i2;
            return (i << 16) ^ i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaBench$CBitRandomGenerator.class */
    public static class CBitRandomGenerator {
        CRandomGenerator RG = new CRandomGenerator();
        int Value;
        int NumBits;

        CBitRandomGenerator() {
        }

        public void Init() {
            this.Value = 0;
            this.NumBits = 0;
        }

        public int GetRnd(int numBits) {
            if (this.NumBits > numBits) {
                int result = this.Value & ((1 << numBits) - 1);
                this.Value >>>= numBits;
                this.NumBits -= numBits;
                return result;
            }
            int numBits2 = numBits - this.NumBits;
            int result2 = this.Value << numBits2;
            this.Value = this.RG.GetRnd();
            int result3 = result2 | (this.Value & ((1 << numBits2) - 1));
            this.Value >>>= numBits2;
            this.NumBits = 32 - numBits2;
            return result3;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaBench$CBenchRandomGenerator.class */
    static class CBenchRandomGenerator {
        int Pos;
        int Rep0;
        public int BufferSize;
        CBitRandomGenerator RG = new CBitRandomGenerator();
        public byte[] Buffer = null;

        public void Set(int bufferSize) {
            this.Buffer = new byte[bufferSize];
            this.Pos = 0;
            this.BufferSize = bufferSize;
        }

        int GetRndBit() {
            return this.RG.GetRnd(1);
        }

        int GetLogRandBits(int numBits) {
            int len = this.RG.GetRnd(numBits);
            return this.RG.GetRnd(len);
        }

        int GetOffset() {
            if (GetRndBit() == 0) {
                return GetLogRandBits(4);
            }
            return (GetLogRandBits(4) << 10) | this.RG.GetRnd(10);
        }

        int GetLen1() {
            return this.RG.GetRnd(1 + this.RG.GetRnd(2));
        }

        int GetLen2() {
            return this.RG.GetRnd(2 + this.RG.GetRnd(2));
        }

        public void Generate() {
            int len;
            this.RG.Init();
            this.Rep0 = 1;
            while (this.Pos < this.BufferSize) {
                if (GetRndBit() == 0 || this.Pos < 1) {
                    byte[] bArr = this.Buffer;
                    int i = this.Pos;
                    this.Pos = i + 1;
                    bArr[i] = (byte) this.RG.GetRnd(8);
                } else {
                    if (this.RG.GetRnd(3) == 0) {
                        len = 1 + GetLen1();
                    } else {
                        do {
                            this.Rep0 = GetOffset();
                        } while (this.Rep0 >= this.Pos);
                        this.Rep0++;
                        len = 2 + GetLen2();
                    }
                    int i2 = 0;
                    while (i2 < len && this.Pos < this.BufferSize) {
                        this.Buffer[this.Pos] = this.Buffer[this.Pos - this.Rep0];
                        i2++;
                        this.Pos++;
                    }
                }
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaBench$CrcOutStream.class */
    static class CrcOutStream extends OutputStream {
        public CRC CRC = new CRC();

        CrcOutStream() {
        }

        public void Init() {
            this.CRC.Init();
        }

        public int GetDigest() {
            return this.CRC.GetDigest();
        }

        @Override // java.io.OutputStream
        public void write(byte[] b) {
            this.CRC.Update(b);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int off, int len) {
            this.CRC.Update(b, off, len);
        }

        @Override // java.io.OutputStream
        public void write(int b) {
            this.CRC.UpdateByte(b);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaBench$MyOutputStream.class */
    static class MyOutputStream extends OutputStream {
        byte[] _buffer;
        int _size;
        int _pos;

        public MyOutputStream(byte[] buffer) {
            this._buffer = buffer;
            this._size = this._buffer.length;
        }

        public void reset() {
            this._pos = 0;
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            if (this._pos >= this._size) {
                throw new IOException("Error");
            }
            byte[] bArr = this._buffer;
            int i = this._pos;
            this._pos = i + 1;
            bArr[i] = (byte) b;
        }

        public int size() {
            return this._pos;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaBench$MyInputStream.class */
    static class MyInputStream extends InputStream {
        byte[] _buffer;
        int _size;
        int _pos;

        public MyInputStream(byte[] buffer, int size) {
            this._buffer = buffer;
            this._size = size;
        }

        @Override // java.io.InputStream
        public void reset() {
            this._pos = 0;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this._pos >= this._size) {
                return -1;
            }
            byte[] bArr = this._buffer;
            int i = this._pos;
            this._pos = i + 1;
            return bArr[i] & 255;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/LzmaBench$CProgressInfo.class */
    static class CProgressInfo implements ICodeProgress {
        public long ApprovedStart;
        public long InSize;
        public long Time;

        CProgressInfo() {
        }

        public void Init() {
            this.InSize = 0L;
        }

        @Override // SevenZip.ICodeProgress
        public void SetProgress(long inSize, long outSize) {
            if (inSize >= this.ApprovedStart && this.InSize == 0) {
                this.Time = System.currentTimeMillis();
                this.InSize = inSize;
            }
        }
    }

    static int GetLogSize(int size) {
        for (int i = 8; i < 32; i++) {
            for (int j = 0; j < 256; j++) {
                if (size <= (1 << i) + (j << (i - 8))) {
                    return (i << 8) + j;
                }
            }
        }
        return 8192;
    }

    static long MyMultDiv64(long value, long elapsedTime) {
        long elTime;
        long freq = 1000;
        long j = elapsedTime;
        while (true) {
            elTime = j;
            if (freq <= 1000000) {
                break;
            }
            freq >>>= 1;
            j = elTime >>> 1;
        }
        if (elTime == 0) {
            elTime = 1;
        }
        return (value * freq) / elTime;
    }

    static long GetCompressRating(int dictionarySize, long elapsedTime, long size) {
        long t = GetLogSize(dictionarySize) - 4608;
        long numCommandsForOne = 1060 + (((t * t) * 10) >> 16);
        long numCommands = size * numCommandsForOne;
        return MyMultDiv64(numCommands, elapsedTime);
    }

    static long GetDecompressRating(long elapsedTime, long outSize, long inSize) {
        long numCommands = (inSize * 220) + (outSize * 20);
        return MyMultDiv64(numCommands, elapsedTime);
    }

    static long GetTotalRating(int dictionarySize, long elapsedTimeEn, long sizeEn, long elapsedTimeDe, long inSizeDe, long outSizeDe) {
        return (GetCompressRating(dictionarySize, elapsedTimeEn, sizeEn) + GetDecompressRating(elapsedTimeDe, inSizeDe, outSizeDe)) / 2;
    }

    static void PrintValue(long v) {
        String s = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE + v;
        for (int i = 0; i + s.length() < 6; i++) {
            System.out.print(" ");
        }
        System.out.print(s);
    }

    static void PrintRating(long rating) {
        PrintValue(rating / 1000000);
        System.out.print(" MIPS");
    }

    static void PrintResults(int dictionarySize, long elapsedTime, long size, boolean decompressMode, long secondSize) {
        long rating;
        long speed = MyMultDiv64(size, elapsedTime);
        PrintValue(speed / 1024);
        System.out.print(" KB/s  ");
        if (decompressMode) {
            rating = GetDecompressRating(elapsedTime, size, secondSize);
        } else {
            rating = GetCompressRating(dictionarySize, elapsedTime, size);
        }
        PrintRating(rating);
    }

    public static int LzmaBenchmark(int numIterations, int dictionarySize) throws Exception {
        if (numIterations <= 0) {
            return 0;
        }
        if (dictionarySize < 262144) {
            System.out.println("\nError: dictionary size for benchmark must be >= 18 (256 KB)");
            return 1;
        }
        System.out.print("\n       Compressing                Decompressing\n\n");
        Encoder encoder = new Encoder();
        Decoder decoder = new Decoder();
        if (!encoder.SetDictionarySize(dictionarySize)) {
            throw new Exception("Incorrect dictionary size");
        }
        int kBufferSize = dictionarySize + 2097152;
        int kCompressedBufferSize = (kBufferSize / 2) + 1024;
        ByteArrayOutputStream propStream = new ByteArrayOutputStream();
        encoder.WriteCoderProperties(propStream);
        byte[] propArray = propStream.toByteArray();
        decoder.SetDecoderProperties(propArray);
        CBenchRandomGenerator rg = new CBenchRandomGenerator();
        rg.Set(kBufferSize);
        rg.Generate();
        CRC crc = new CRC();
        crc.Init();
        crc.Update(rg.Buffer, 0, rg.BufferSize);
        CProgressInfo progressInfo = new CProgressInfo();
        progressInfo.ApprovedStart = dictionarySize;
        long totalBenchSize = 0;
        long totalEncodeTime = 0;
        long totalDecodeTime = 0;
        long totalCompressedSize = 0;
        MyInputStream inStream = new MyInputStream(rg.Buffer, rg.BufferSize);
        byte[] compressedBuffer = new byte[kCompressedBufferSize];
        MyOutputStream compressedStream = new MyOutputStream(compressedBuffer);
        CrcOutStream crcOutStream = new CrcOutStream();
        MyInputStream inputCompressedStream = null;
        int compressedSize = 0;
        for (int i = 0; i < numIterations; i++) {
            progressInfo.Init();
            inStream.reset();
            compressedStream.reset();
            encoder.Code(inStream, compressedStream, -1L, -1L, progressInfo);
            long encodeTime = System.currentTimeMillis() - progressInfo.Time;
            if (i == 0) {
                compressedSize = compressedStream.size();
                inputCompressedStream = new MyInputStream(compressedBuffer, compressedSize);
            } else if (compressedSize != compressedStream.size()) {
                throw new Exception("Encoding error");
            }
            if (progressInfo.InSize == 0) {
                throw new Exception("Internal ERROR 1282");
            }
            long decodeTime = 0;
            for (int j = 0; j < 2; j++) {
                inputCompressedStream.reset();
                crcOutStream.Init();
                long outSize = kBufferSize;
                long startTime = System.currentTimeMillis();
                if (!decoder.Code(inputCompressedStream, crcOutStream, outSize)) {
                    throw new Exception("Decoding Error");
                }
                decodeTime = System.currentTimeMillis() - startTime;
                if (crcOutStream.GetDigest() != crc.GetDigest()) {
                    throw new Exception("CRC Error");
                }
            }
            long benchSize = kBufferSize - progressInfo.InSize;
            PrintResults(dictionarySize, encodeTime, benchSize, false, 0L);
            System.out.print("     ");
            PrintResults(dictionarySize, decodeTime, kBufferSize, true, compressedSize);
            System.out.println();
            totalBenchSize += benchSize;
            totalEncodeTime += encodeTime;
            totalDecodeTime += decodeTime;
            totalCompressedSize += compressedSize;
        }
        System.out.println("---------------------------------------------------");
        PrintResults(dictionarySize, totalEncodeTime, totalBenchSize, false, 0L);
        System.out.print("     ");
        PrintResults(dictionarySize, totalDecodeTime, kBufferSize * numIterations, true, totalCompressedSize);
        System.out.println("    Average");
        return 0;
    }
}
