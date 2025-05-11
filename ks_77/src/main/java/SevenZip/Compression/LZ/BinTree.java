package SevenZip.Compression.LZ;

import java.io.IOException;
import org.chromium.blink.mojom.WebFeature;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/Compression/LZ/BinTree.class */
public class BinTree extends InWindow {
    int _cyclicBufferPos;
    int _matchMaxLen;
    int[] _son;
    int[] _hash;
    int _hashMask;
    static final int kHash2Size = 1024;
    static final int kHash3Size = 65536;
    static final int kBT2HashSize = 65536;
    static final int kStartMaxLen = 1;
    static final int kHash3Offset = 1024;
    static final int kEmptyHashValue = 0;
    static final int kMaxValForNormalize = 1073741823;
    private static final int[] CrcTable = new int[256];
    int _cyclicBufferSize = 0;
    int _cutValue = 255;
    int _hashSizeSum = 0;
    boolean HASH_ARRAY = true;
    int kNumHashDirectBytes = 0;
    int kMinMatchCheck = 4;
    int kFixHashSize = 66560;

    public void SetType(int numHashBytes) {
        this.HASH_ARRAY = numHashBytes > 2;
        if (this.HASH_ARRAY) {
            this.kNumHashDirectBytes = 0;
            this.kMinMatchCheck = 4;
            this.kFixHashSize = 66560;
            return;
        }
        this.kNumHashDirectBytes = 2;
        this.kMinMatchCheck = 3;
        this.kFixHashSize = 0;
    }

    @Override // SevenZip.Compression.LZ.InWindow
    public void Init() throws IOException {
        super.Init();
        for (int i = 0; i < this._hashSizeSum; i++) {
            this._hash[i] = 0;
        }
        this._cyclicBufferPos = 0;
        ReduceOffsets(-1);
    }

    @Override // SevenZip.Compression.LZ.InWindow
    public void MovePos() throws IOException {
        int i = this._cyclicBufferPos + 1;
        this._cyclicBufferPos = i;
        if (i >= this._cyclicBufferSize) {
            this._cyclicBufferPos = 0;
        }
        super.MovePos();
        if (this._pos == kMaxValForNormalize) {
            Normalize();
        }
    }

    public boolean Create(int historySize, int keepAddBufferBefore, int matchMaxLen, int keepAddBufferAfter) {
        if (historySize > 1073741567) {
            return false;
        }
        this._cutValue = 16 + (matchMaxLen >> 1);
        int windowReservSize = ((((historySize + keepAddBufferBefore) + matchMaxLen) + keepAddBufferAfter) / 2) + 256;
        super.Create(historySize + keepAddBufferBefore, matchMaxLen + keepAddBufferAfter, windowReservSize);
        this._matchMaxLen = matchMaxLen;
        int cyclicBufferSize = historySize + 1;
        if (this._cyclicBufferSize != cyclicBufferSize) {
            this._cyclicBufferSize = cyclicBufferSize;
            this._son = new int[cyclicBufferSize * 2];
        }
        int hs = 65536;
        if (this.HASH_ARRAY) {
            int hs2 = historySize - 1;
            int hs3 = hs2 | (hs2 >> 1);
            int hs4 = hs3 | (hs3 >> 2);
            int hs5 = hs4 | (hs4 >> 4);
            int hs6 = ((hs5 | (hs5 >> 8)) >> 1) | 65535;
            if (hs6 > 16777216) {
                hs6 >>= 1;
            }
            this._hashMask = hs6;
            hs = hs6 + 1 + this.kFixHashSize;
        }
        if (hs != this._hashSizeSum) {
            int i = hs;
            this._hashSizeSum = i;
            this._hash = new int[i];
            return true;
        }
        return true;
    }

    public int GetMatches(int[] distances) throws IOException {
        int lenLimit;
        int hashValue;
        int i;
        if (this._pos + this._matchMaxLen <= this._streamPos) {
            lenLimit = this._matchMaxLen;
        } else {
            lenLimit = this._streamPos - this._pos;
            if (lenLimit < this.kMinMatchCheck) {
                MovePos();
                return 0;
            }
        }
        int offset = 0;
        int matchMinPos = this._pos > this._cyclicBufferSize ? this._pos - this._cyclicBufferSize : 0;
        int cur = this._bufferOffset + this._pos;
        int maxLen = 1;
        int hash2Value = 0;
        int hash3Value = 0;
        if (this.HASH_ARRAY) {
            int temp = CrcTable[this._bufferBase[cur] & 255] ^ (this._bufferBase[cur + 1] & 255);
            hash2Value = temp & WebFeature.CSS_FILTER_BLUR;
            int temp2 = temp ^ ((this._bufferBase[cur + 2] & 255) << 8);
            hash3Value = temp2 & 65535;
            hashValue = (temp2 ^ (CrcTable[this._bufferBase[cur + 3] & 255] << 5)) & this._hashMask;
        } else {
            hashValue = (this._bufferBase[cur] & 255) ^ ((this._bufferBase[cur + 1] & 255) << 8);
        }
        int curMatch = this._hash[this.kFixHashSize + hashValue];
        if (this.HASH_ARRAY) {
            int curMatch2 = this._hash[hash2Value];
            int curMatch3 = this._hash[1024 + hash3Value];
            this._hash[hash2Value] = this._pos;
            this._hash[1024 + hash3Value] = this._pos;
            if (curMatch2 > matchMinPos && this._bufferBase[this._bufferOffset + curMatch2] == this._bufferBase[cur]) {
                int offset2 = 0 + 1;
                maxLen = 2;
                distances[0] = 2;
                offset = offset2 + 1;
                distances[offset2] = (this._pos - curMatch2) - 1;
            }
            if (curMatch3 > matchMinPos && this._bufferBase[this._bufferOffset + curMatch3] == this._bufferBase[cur]) {
                if (curMatch3 == curMatch2) {
                    offset -= 2;
                }
                int i2 = offset;
                int offset3 = offset + 1;
                maxLen = 3;
                distances[i2] = 3;
                offset = offset3 + 1;
                distances[offset3] = (this._pos - curMatch3) - 1;
                curMatch2 = curMatch3;
            }
            if (offset != 0 && curMatch2 == curMatch) {
                offset -= 2;
                maxLen = 1;
            }
        }
        this._hash[this.kFixHashSize + hashValue] = this._pos;
        int ptr0 = (this._cyclicBufferPos << 1) + 1;
        int ptr1 = this._cyclicBufferPos << 1;
        int i3 = this.kNumHashDirectBytes;
        int len1 = i3;
        int len0 = i3;
        if (this.kNumHashDirectBytes != 0 && curMatch > matchMinPos && this._bufferBase[this._bufferOffset + curMatch + this.kNumHashDirectBytes] != this._bufferBase[cur + this.kNumHashDirectBytes]) {
            int i4 = offset;
            int offset4 = offset + 1;
            int i5 = this.kNumHashDirectBytes;
            maxLen = i5;
            distances[i4] = i5;
            offset = offset4 + 1;
            distances[offset4] = (this._pos - curMatch) - 1;
        }
        int count = this._cutValue;
        while (curMatch > matchMinPos) {
            int i6 = count;
            count--;
            if (i6 == 0) {
                break;
            }
            int delta = this._pos - curMatch;
            if (delta <= this._cyclicBufferPos) {
                i = this._cyclicBufferPos - delta;
            } else {
                i = (this._cyclicBufferPos - delta) + this._cyclicBufferSize;
            }
            int cyclicPos = i << 1;
            int pby1 = this._bufferOffset + curMatch;
            int len = Math.min(len0, len1);
            if (this._bufferBase[pby1 + len] == this._bufferBase[cur + len]) {
                do {
                    len++;
                    if (len == lenLimit) {
                        break;
                    }
                } while (this._bufferBase[pby1 + len] == this._bufferBase[cur + len]);
                if (maxLen < len) {
                    int i7 = offset;
                    int offset5 = offset + 1;
                    maxLen = len;
                    distances[i7] = len;
                    offset = offset5 + 1;
                    distances[offset5] = delta - 1;
                    if (len == lenLimit) {
                        this._son[ptr1] = this._son[cyclicPos];
                        this._son[ptr0] = this._son[cyclicPos + 1];
                        break;
                    }
                }
            }
            if ((this._bufferBase[pby1 + len] & 255) < (this._bufferBase[cur + len] & 255)) {
                this._son[ptr1] = curMatch;
                ptr1 = cyclicPos + 1;
                curMatch = this._son[ptr1];
                len1 = len;
            } else {
                this._son[ptr0] = curMatch;
                ptr0 = cyclicPos;
                curMatch = this._son[ptr0];
                len0 = len;
            }
        }
        this._son[ptr1] = 0;
        this._son[ptr0] = 0;
        MovePos();
        return offset;
    }

    public void Skip(int num) throws IOException {
        int lenLimit;
        int hashValue;
        int i;
        do {
            if (this._pos + this._matchMaxLen <= this._streamPos) {
                lenLimit = this._matchMaxLen;
            } else {
                lenLimit = this._streamPos - this._pos;
                if (lenLimit < this.kMinMatchCheck) {
                    MovePos();
                    num--;
                }
            }
            int matchMinPos = this._pos > this._cyclicBufferSize ? this._pos - this._cyclicBufferSize : 0;
            int cur = this._bufferOffset + this._pos;
            if (this.HASH_ARRAY) {
                int temp = CrcTable[this._bufferBase[cur] & 255] ^ (this._bufferBase[cur + 1] & 255);
                int hash2Value = temp & WebFeature.CSS_FILTER_BLUR;
                this._hash[hash2Value] = this._pos;
                int temp2 = temp ^ ((this._bufferBase[cur + 2] & 255) << 8);
                int hash3Value = temp2 & 65535;
                this._hash[1024 + hash3Value] = this._pos;
                hashValue = (temp2 ^ (CrcTable[this._bufferBase[cur + 3] & 255] << 5)) & this._hashMask;
            } else {
                hashValue = (this._bufferBase[cur] & 255) ^ ((this._bufferBase[cur + 1] & 255) << 8);
            }
            int curMatch = this._hash[this.kFixHashSize + hashValue];
            this._hash[this.kFixHashSize + hashValue] = this._pos;
            int ptr0 = (this._cyclicBufferPos << 1) + 1;
            int ptr1 = this._cyclicBufferPos << 1;
            int i2 = this.kNumHashDirectBytes;
            int len1 = i2;
            int len0 = i2;
            int count = this._cutValue;
            while (curMatch > matchMinPos) {
                int i3 = count;
                count--;
                if (i3 == 0) {
                    break;
                }
                int delta = this._pos - curMatch;
                if (delta <= this._cyclicBufferPos) {
                    i = this._cyclicBufferPos - delta;
                } else {
                    i = (this._cyclicBufferPos - delta) + this._cyclicBufferSize;
                }
                int cyclicPos = i << 1;
                int pby1 = this._bufferOffset + curMatch;
                int len = Math.min(len0, len1);
                if (this._bufferBase[pby1 + len] == this._bufferBase[cur + len]) {
                    do {
                        len++;
                        if (len == lenLimit) {
                            break;
                        }
                    } while (this._bufferBase[pby1 + len] == this._bufferBase[cur + len]);
                    if (len == lenLimit) {
                        this._son[ptr1] = this._son[cyclicPos];
                        this._son[ptr0] = this._son[cyclicPos + 1];
                        break;
                    }
                }
                if ((this._bufferBase[pby1 + len] & 255) < (this._bufferBase[cur + len] & 255)) {
                    this._son[ptr1] = curMatch;
                    ptr1 = cyclicPos + 1;
                    curMatch = this._son[ptr1];
                    len1 = len;
                } else {
                    this._son[ptr0] = curMatch;
                    ptr0 = cyclicPos;
                    curMatch = this._son[ptr0];
                    len0 = len;
                }
            }
            this._son[ptr1] = 0;
            this._son[ptr0] = 0;
            MovePos();
            num--;
        } while (num != 0);
    }

    void NormalizeLinks(int[] items, int numItems, int subValue) {
        int value;
        for (int i = 0; i < numItems; i++) {
            int value2 = items[i];
            if (value2 <= subValue) {
                value = 0;
            } else {
                value = value2 - subValue;
            }
            items[i] = value;
        }
    }

    void Normalize() {
        int subValue = this._pos - this._cyclicBufferSize;
        NormalizeLinks(this._son, this._cyclicBufferSize * 2, subValue);
        NormalizeLinks(this._hash, this._hashSizeSum, subValue);
        ReduceOffsets(subValue);
    }

    public void SetCutValue(int cutValue) {
        this._cutValue = cutValue;
    }

    static {
        int i;
        for (int i2 = 0; i2 < 256; i2++) {
            int r = i2;
            for (int j = 0; j < 8; j++) {
                if ((r & 1) != 0) {
                    i = (r >>> 1) ^ (-306674912);
                } else {
                    i = r >>> 1;
                }
                r = i;
            }
            CrcTable[i2] = r;
        }
    }
}
