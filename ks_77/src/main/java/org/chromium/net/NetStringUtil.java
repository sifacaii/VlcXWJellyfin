package org.chromium.net;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.text.Normalizer;
import java.util.Locale;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("net::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/NetStringUtil.class */
public class NetStringUtil {
    @CalledByNative
    private static String convertToUnicode(ByteBuffer text, String charsetName) {
        try {
            Charset charset = Charset.forName(charsetName);
            CharsetDecoder decoder = charset.newDecoder();
            return decoder.decode(text).toString();
        } catch (Exception e) {
            return null;
        }
    }

    @CalledByNative
    private static String convertToUnicodeAndNormalize(ByteBuffer text, String charsetName) {
        String unicodeString = convertToUnicode(text, charsetName);
        if (unicodeString == null) {
            return null;
        }
        return Normalizer.normalize(unicodeString, Normalizer.Form.NFC);
    }

    @CalledByNative
    private static String convertToUnicodeWithSubstitutions(ByteBuffer text, String charsetName) {
        try {
            Charset charset = Charset.forName(charsetName);
            CharsetDecoder decoder = charset.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.REPLACE);
            decoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
            decoder.replaceWith("�");
            return decoder.decode(text).toString();
        } catch (Exception e) {
            return null;
        }
    }

    @CalledByNative
    private static String toUpperCase(String str) {
        try {
            return str.toUpperCase(Locale.getDefault());
        } catch (Exception e) {
            return null;
        }
    }
}
