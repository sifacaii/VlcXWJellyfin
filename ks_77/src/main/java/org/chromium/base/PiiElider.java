package org.chromium.base;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.chromium.base.annotations.UsedByReflection;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/PiiElider.class */
public class PiiElider {
    private static final String EMAIL_ELISION = "XXX@EMAIL.ELIDED";
    private static final String URL_ELISION = "HTTP://WEBADDRESS.ELIDED";
    private static final String IRI = "[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}";
    private static final String GOOD_GTLD_CHAR = "a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef";
    private static final String GTLD = "[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";
    private static final String HOST_NAME = "([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";
    private static final String IP_ELISION = "1.2.3.4";
    private static final String MAC_ELISION = "01:23:45:67:89:AB";
    private static final String CONSOLE_ELISION = "[ELIDED:CONSOLE(0)] ELIDED CONSOLE MESSAGE";
    private static final Pattern IP_ADDRESS = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
    private static final Pattern DOMAIN_NAME = Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|" + IP_ADDRESS + ")");
    private static final Pattern LIKELY_EXCEPTION_LOG = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.");
    private static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";
    private static final Pattern WEB_URL = Pattern.compile("(?:\\b|^)((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + DOMAIN_NAME + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[" + GOOD_IRI_CHAR + "\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
    private static final Pattern MAC_ADDRESS = Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
    private static final Pattern CONSOLE_MSG = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
    private static final String[] APP_NAMESPACE = {"org.chromium.", "com.google."};
    private static final String[] SYSTEM_NAMESPACE = {"android.accessibilityservice", "android.accounts", "android.animation", "android.annotation", "android.app", "android.appwidget", "android.bluetooth", "android.content", "android.database", "android.databinding", "android.drm", "android.gesture", "android.graphics", "android.hardware", "android.inputmethodservice", "android.location", "android.media", "android.mtp", "android.net", "android.nfc", "android.opengl", "android.os", "android.preference", "android.print", "android.printservice", "android.provider", "android.renderscript", "android.sax", "android.security", "android.service", "android.speech", "android.support", "android.system", "android.telecom", "android.telephony", "android.test", "android.text", "android.transition", "android.util", "android.view", "android.webkit", "android.widget", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};

    public static String elideEmail(String original) {
        return Patterns.EMAIL_ADDRESS.matcher(original).replaceAll(EMAIL_ELISION);
    }

    public static String elideUrl(String original) {
        if (LIKELY_EXCEPTION_LOG.matcher(original).find()) {
            return original;
        }
        StringBuilder buffer = new StringBuilder(original);
        Matcher matcher = WEB_URL.matcher(buffer);
        int start = 0;
        while (matcher.find(start)) {
            int start2 = matcher.start();
            int end = matcher.end();
            String url = buffer.substring(start2, end);
            if (!likelyToBeAppNamespace(url) && !likelyToBeSystemNamespace(url)) {
                buffer.replace(start2, end, URL_ELISION);
                end = start2 + URL_ELISION.length();
                matcher = WEB_URL.matcher(buffer);
            }
            start = end;
        }
        return buffer.toString();
    }

    private static boolean likelyToBeAppNamespace(String url) {
        String[] strArr;
        for (String ns : APP_NAMESPACE) {
            if (url.startsWith(ns)) {
                return true;
            }
        }
        return false;
    }

    private static boolean likelyToBeSystemNamespace(String url) {
        String[] strArr;
        for (String ns : SYSTEM_NAMESPACE) {
            if (url.startsWith(ns)) {
                return true;
            }
        }
        return false;
    }

    public static String elideIp(String original) {
        return Patterns.IP_ADDRESS.matcher(original).replaceAll(IP_ELISION);
    }

    public static String elideMac(String original) {
        return MAC_ADDRESS.matcher(original).replaceAll(MAC_ELISION);
    }

    public static String elideConsole(String original) {
        return CONSOLE_MSG.matcher(original).replaceAll(CONSOLE_ELISION);
    }

    @UsedByReflection("jni_android.cc")
    public static String sanitizeStacktrace(String stacktrace) {
        String[] frames = stacktrace.split("\\n");
        frames[0] = elideUrl(frames[0]);
        for (int i = 1; i < frames.length; i++) {
            if (frames[i].startsWith("Caused by:")) {
                frames[i] = elideUrl(frames[i]);
            }
        }
        return TextUtils.join("\n", frames);
    }
}
