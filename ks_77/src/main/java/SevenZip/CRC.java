package SevenZip;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:SevenZip/CRC.class */
public class CRC {
    public static int[] Table = new int[256];
    int _value = -1;

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
            Table[i2] = r;
        }
    }

    public void Init() {
        this._value = -1;
    }

    public void Update(byte[] data, int offset, int size) {
        for (int i = 0; i < size; i++) {
            this._value = Table[(this._value ^ data[offset + i]) & 255] ^ (this._value >>> 8);
        }
    }

    public void Update(byte[] data) {
        for (byte b : data) {
            this._value = Table[(this._value ^ b) & 255] ^ (this._value >>> 8);
        }
    }

    public void UpdateByte(int b) {
        this._value = Table[(this._value ^ b) & 255] ^ (this._value >>> 8);
    }

    public int GetDigest() {
        return this._value ^ (-1);
    }
}
