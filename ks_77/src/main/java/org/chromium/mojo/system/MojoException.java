package org.chromium.mojo.system;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/MojoException.class */
public class MojoException extends RuntimeException {
    private final int mCode;

    public MojoException(int code) {
        this.mCode = code;
    }

    public MojoException(Throwable cause) {
        super(cause);
        this.mCode = 2;
    }

    public int getMojoResult() {
        return this.mCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "MojoResult(" + this.mCode + "): " + MojoResult.describe(this.mCode);
    }
}
