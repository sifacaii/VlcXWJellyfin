package org.chromium.base;

import android.annotation.SuppressLint;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;

@SuppressLint({"SecureRandom"})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/SecureRandomInitializer.class */
public class SecureRandomInitializer {
    private static final int NUM_RANDOM_BYTES = 16;

    public static void initialize(SecureRandom generator) throws IOException {
        FileInputStream fis = new FileInputStream("/dev/urandom");
        Throwable th = null;
        try {
            byte[] seedBytes = new byte[16];
            if (fis.read(seedBytes) != seedBytes.length) {
                throw new IOException("Failed to get enough random data.");
            }
            generator.setSeed(seedBytes);
            if (0 != 0) {
                try {
                    fis.close();
                    return;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    return;
                }
            }
            fis.close();
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                if (th3 != null) {
                    try {
                        fis.close();
                    } catch (Throwable th5) {
                        th3.addSuppressed(th5);
                    }
                } else {
                    fis.close();
                }
                throw th4;
            }
        }
    }
}
