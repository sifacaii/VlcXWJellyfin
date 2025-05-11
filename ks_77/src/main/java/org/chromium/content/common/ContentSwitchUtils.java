package org.chromium.content.common;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/common/ContentSwitchUtils.class */
public final class ContentSwitchUtils {
    private ContentSwitchUtils() {
    }

    public static String getSwitchValue(String[] commandLine, String switchKey) {
        if (commandLine == null || switchKey == null) {
            return null;
        }
        String switchKeyPrefix = "--" + switchKey + "=";
        for (String command : commandLine) {
            if (command != null && command.startsWith(switchKeyPrefix)) {
                return command.substring(switchKeyPrefix.length());
            }
        }
        return null;
    }
}
