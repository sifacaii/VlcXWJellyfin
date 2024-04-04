package SevenZip.Compression.LZ;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/Compression/LZ/InWindow.class */
public class InWindow {
    public byte[] _bufferBase;
    InputStream _stream;
    int _posLimit;
    boolean _streamEndWasReached;
    int _pointerToLastSafePosition;
    public int _bufferOffset;
    public int _blockSize;
    public int _pos;
    int _keepSizeBefore;
    int _keepSizeAfter;
    public int _streamPos;

    public void MoveBlock() {
        int offset = (this._bufferOffset + this._pos) - this._keepSizeBefore;
        if (offset > 0) {
            offset--;
        }
        int numBytes = (this._bufferOffset + this._streamPos) - offset;
        for (int i = 0; i < numBytes; i++) {
            this._bufferBase[i] = this._bufferBase[offset + i];
        }
        this._bufferOffset -= offset;
    }

    public void ReadBlock() throws IOException {
        if (this._streamEndWasReached) {
            return;
        }
        while (true) {
            int size = ((0 - this._bufferOffset) + this._blockSize) - this._streamPos;
            if (size == 0) {
                return;
            }
            int numReadBytes = this._stream.read(this._bufferBase, this._bufferOffset + this._streamPos, size);
            if (numReadBytes == -1) {
                this._posLimit = this._streamPos;
                int pointerToPostion = this._bufferOffset + this._posLimit;
                if (pointerToPostion > this._pointerToLastSafePosition) {
                    this._posLimit = this._pointerToLastSafePosition - this._bufferOffset;
                }
                this._streamEndWasReached = true;
                return;
            }
            this._streamPos += numReadBytes;
            if (this._streamPos >= this._pos + this._keepSizeAfter) {
                this._posLimit = this._streamPos - this._keepSizeAfter;
            }
        }
    }

    void Free() {
        this._bufferBase = null;
    }

    public void Create(int keepSizeBefore, int keepSizeAfter, int keepSizeReserv) {
        this._keepSizeBefore = keepSizeBefore;
        this._keepSizeAfter = keepSizeAfter;
        int blockSize = keepSizeBefore + keepSizeAfter + keepSizeReserv;
        if (this._bufferBase == null || this._blockSize != blockSize) {
            Free();
            this._blockSize = blockSize;
            this._bufferBase = new byte[this._blockSize];
        }
        this._pointerToLastSafePosition = this._blockSize - keepSizeAfter;
    }

    public void SetStream(InputStream stream) {
        this._stream = stream;
    }

    public void ReleaseStream() {
        this._stream = null;
    }

    public void Init() throws IOException {
        this._bufferOffset = 0;
        this._pos = 0;
        this._streamPos = 0;
        this._streamEndWasReached = false;
        ReadBlock();
    }

    public void MovePos() throws IOException {
        this._pos++;
        if (this._pos > this._posLimit) {
            int pointerToPostion = this._bufferOffset + this._pos;
            if (pointerToPostion > this._pointerToLastSafePosition) {
                MoveBlock();
            }
            ReadBlock();
        }
    }

    public byte GetIndexByte(int index) {
        return this._bufferBase[this._bufferOffset + this._pos + index];
    }

    public int GetMatchLen(int index, int distance, int limit) {
        if (this._streamEndWasReached && this._pos + index + limit > this._streamPos) {
            limit = this._streamPos - (this._pos + index);
        }
        int distance2 = distance + 1;
        int pby = this._bufferOffset + this._pos + index;
        int i = 0;
        while (i < limit && this._bufferBase[pby + i] == this._bufferBase[(pby + i) - distance2]) {
            i++;
        }
        return i;
    }

    public int GetNumAvailableBytes() {
        return this._streamPos - this._pos;
    }

    public void ReduceOffsets(int subValue) {
        this._bufferOffset += subValue;
        this._posLimit -= subValue;
        this._pos -= subValue;
        this._streamPos -= subValue;
    }
}
