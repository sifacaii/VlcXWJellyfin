package org.chromium.mojo.bindings;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/DataHeader.class */
public final class DataHeader {
    public static final int HEADER_SIZE = 8;
    public static final int SIZE_OFFSET = 0;
    public static final int ELEMENTS_OR_VERSION_OFFSET = 4;
    public final int size;
    public final int elementsOrVersion;

    public DataHeader(int size, int elementsOrVersion) {
        this.size = size;
        this.elementsOrVersion = elementsOrVersion;
    }

    public int hashCode() {
        int result = (31 * 1) + this.elementsOrVersion;
        return (31 * result) + this.size;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && getClass() == object.getClass()) {
            DataHeader other = (DataHeader) object;
            return this.elementsOrVersion == other.elementsOrVersion && this.size == other.size;
        }
        return false;
    }
}
