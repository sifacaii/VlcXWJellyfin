package org.chromium.net;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("net::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/AndroidKeyStore.class */
public class AndroidKeyStore {
    private static final String TAG = "AndroidKeyStore";

    @CalledByNative
    private static String getPrivateKeyClassName(PrivateKey privateKey) {
        return privateKey.getClass().getName();
    }

    @CalledByNative
    private static boolean privateKeySupportsSignature(PrivateKey privateKey, String algorithm) {
        try {
            Signature signature = Signature.getInstance(algorithm);
            signature.initSign(privateKey);
            return true;
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            return false;
        } catch (Exception e2) {
            Log.e(TAG, "Exception while checking support for " + algorithm + ": " + e2, new Object[0]);
            return false;
        }
    }

    @CalledByNative
    private static boolean privateKeySupportsCipher(PrivateKey privateKey, String algorithm) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(1, privateKey);
            return true;
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            return false;
        } catch (Exception e2) {
            Log.e(TAG, "Exception while checking support for " + algorithm + ": " + e2, new Object[0]);
            return false;
        }
    }

    @CalledByNative
    private static byte[] signWithPrivateKey(PrivateKey privateKey, String algorithm, byte[] message) {
        try {
            Signature signature = Signature.getInstance(algorithm);
            try {
                signature.initSign(privateKey);
                signature.update(message);
                return signature.sign();
            } catch (Exception e) {
                Log.e(TAG, "Exception while signing message with " + algorithm + " and " + privateKey.getAlgorithm() + " private key (" + privateKey.getClass().getName() + "): " + e, new Object[0]);
                return null;
            }
        } catch (NoSuchAlgorithmException e2) {
            Log.e(TAG, "Signature algorithm " + algorithm + " not supported: " + e2, new Object[0]);
            return null;
        }
    }

    @CalledByNative
    private static byte[] encryptWithPrivateKey(PrivateKey privateKey, String algorithm, byte[] message) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            try {
                cipher.init(1, privateKey);
                return cipher.doFinal(message);
            } catch (Exception e) {
                Log.e(TAG, "Exception while encrypting input with " + algorithm + " and " + privateKey.getAlgorithm() + " private key (" + privateKey.getClass().getName() + "): " + e, new Object[0]);
                return null;
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            Log.e(TAG, "Cipher " + algorithm + " not supported: " + e2, new Object[0]);
            return null;
        }
    }
}
