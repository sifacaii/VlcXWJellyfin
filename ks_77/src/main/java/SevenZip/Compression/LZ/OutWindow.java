package SevenZip.Compression.LZ;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/Compression/LZ/OutWindow.class */
public class OutWindow {
    byte[] _buffer;
    int _pos;
    int _windowSize = 0;
    int _streamPos;
    OutputStream _stream;

    public void Create(int windowSize) {
        if (this._buffer == null || this._windowSize != windowSize) {
            this._buffer = new byte[windowSize];
        }
        this._windowSize = windowSize;
        this._pos = 0;
        this._streamPos = 0;
    }

    public void SetStream(OutputStream stream) throws IOException {
        ReleaseStream();
        this._stream = stream;
    }

    public void ReleaseStream() throws IOException {
        Flush();
        this._stream = null;
    }

    public void Init(boolean solid) {
        if (!solid) {
            this._streamPos = 0;
            this._pos = 0;
        }
    }

    public void Flush() throws IOException {
        int size = this._pos - this._streamPos;
        if (size == 0) {
            return;
        }
        this._stream.write(this._buffer, this._streamPos, size);
        if (this._pos >= this._windowSize) {
            this._pos = 0;
        }
        this._streamPos = this._pos;
    }

    public void CopyBlock(int distance, int len) throws IOException {
        int pos = (this._pos - distance) - 1;
        if (pos < 0) {
            pos += this._windowSize;
        }
        while (len != 0) {
            if (pos >= this._windowSize) {
                pos = 0;
            }
            byte[] bArr = this._buffer;
            int i = this._pos;
            this._pos = i + 1;
            int i2 = pos;
            pos++;
            bArr[i] = this._buffer[i2];
            if (this._pos >= this._windowSize) {
                Flush();
            }
            len--;
        }
    }

    public void PutByte(byte b) throws IOException {
        byte[] bArr = this._buffer;
        int i = this._pos;
        this._pos = i + 1;
        bArr[i] = b;
        if (this._pos >= this._windowSize) {
            Flush();
        }
    }

    public byte GetByte(int distance) {
        int pos = (this._pos - distance) - 1;
        if (pos < 0) {
            pos += this._windowSize;
        }
        return this._buffer[pos];
    }
}
