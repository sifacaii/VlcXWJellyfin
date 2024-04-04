package org.chromium.base;

import androidx.annotation.Nullable;
import android.text.TextUtils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.chromium.base.annotations.MainDex;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/CommandLine.class */
public abstract class CommandLine {
    private static final AtomicReference<CommandLine> sCommandLine;
    private static final String TAG = "CommandLine";
    private static final String SWITCH_PREFIX = "--";
    private static final String SWITCH_TERMINATOR = "--";
    private static final String SWITCH_VALUE_SEPARATOR = "=";
    static final /* synthetic */ boolean $assertionsDisabled;

    @VisibleForTesting
    public abstract boolean hasSwitch(String str);

    public abstract String getSwitchValue(String str);

    @VisibleForTesting
    public abstract void appendSwitch(String str);

    public abstract void appendSwitchWithValue(String str, String str2);

    public abstract void appendSwitchesAndArguments(String[] strArr);

    protected abstract String[] getCommandLineArguments();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInit(String[] strArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeHasSwitch(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String nativeGetSwitchValue(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppendSwitch(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppendSwitchWithValue(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppendSwitchesAndArguments(String[] strArr);

    static {
        $assertionsDisabled = !CommandLine.class.desiredAssertionStatus();
        sCommandLine = new AtomicReference<>();
    }

    public String getSwitchValue(String switchString, String defaultValue) {
        String value = getSwitchValue(switchString);
        return TextUtils.isEmpty(value) ? defaultValue : value;
    }

    public boolean isNativeImplementation() {
        return false;
    }

    protected void destroy() {
    }

    public static boolean isInitialized() {
        return sCommandLine.get() != null;
    }

    @VisibleForTesting
    public static CommandLine getInstance() {
        CommandLine commandLine = sCommandLine.get();
        if ($assertionsDisabled || commandLine != null) {
            return commandLine;
        }
        throw new AssertionError();
    }

    public static void init(@Nullable String[] args) {
        setInstance(new JavaCommandLine(args));
    }

    public static void initFromFile(String file) {
        char[] buffer = readFileAsUtf8(file);
        init(buffer == null ? null : tokenizeQuotedArguments(buffer));
    }

    @VisibleForTesting
    public static void reset() {
        setInstance(null);
    }

    @VisibleForTesting
    public static String[] tokenizeQuotedArguments(char[] buffer) {
        if (buffer.length > 65536) {
            throw new RuntimeException("Flags file too big: " + buffer.length);
        }
        ArrayList<String> args = new ArrayList<>();
        StringBuilder arg = null;
        char currentQuote = 0;
        for (char c : buffer) {
            if ((currentQuote == 0 && (c == '\'' || c == '\"')) || c == currentQuote) {
                if (arg != null && arg.length() > 0 && arg.charAt(arg.length() - 1) == '\\') {
                    arg.setCharAt(arg.length() - 1, c);
                } else {
                    currentQuote = currentQuote == 0 ? c : (char) 0;
                }
            } else if (currentQuote == 0 && Character.isWhitespace(c)) {
                if (arg != null) {
                    args.add(arg.toString());
                    arg = null;
                }
            } else {
                if (arg == null) {
                    arg = new StringBuilder();
                }
                arg.append(c);
            }
        }
        if (arg != null) {
            if (currentQuote != 0) {
                android.util.Log.w(TAG, "Unterminated quoted string: " + ((Object) arg));
            }
            args.add(arg.toString());
        }
        return (String[]) args.toArray(new String[args.size()]);
    }

    public static void enableNativeProxy() {
        sCommandLine.set(new NativeCommandLine(getJavaSwitchesOrNull()));
    }

    @Nullable
    public static String[] getJavaSwitchesOrNull() {
        CommandLine commandLine = sCommandLine.get();
        if (commandLine != null) {
            return commandLine.getCommandLineArguments();
        }
        return null;
    }

    private static void setInstance(CommandLine commandLine) {
        CommandLine oldCommandLine = sCommandLine.getAndSet(commandLine);
        if (oldCommandLine != null) {
            oldCommandLine.destroy();
        }
    }

    private static char[] readFileAsUtf8(String fileName) {
        File f = new File(fileName);
        try {
            FileReader reader = new FileReader(f);
            char[] buffer = new char[(int) f.length()];
            int charsRead = reader.read(buffer);
            char[] copyOfRange = Arrays.copyOfRange(buffer, 0, charsRead);
            if (0 != 0) {
                reader.close();
            } else {
                reader.close();
            }
            return copyOfRange;
        } catch (IOException e) {
            return null;
        }
    }

    private CommandLine() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/CommandLine$JavaCommandLine.class */
    public static class JavaCommandLine extends CommandLine {
        private HashMap<String, String> mSwitches;
        private ArrayList<String> mArgs;
        private int mArgsBegin;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !CommandLine.class.desiredAssertionStatus();
        }

        JavaCommandLine(@Nullable String[] args) {
            super();
            this.mSwitches = new HashMap<>();
            this.mArgs = new ArrayList<>();
            this.mArgsBegin = 1;
            if (args == null || args.length == 0 || args[0] == null) {
                this.mArgs.add(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE);
            } else {
                this.mArgs.add(args[0]);
                appendSwitchesInternal(args, 1);
            }
            if (!$assertionsDisabled && this.mArgs.size() <= 0) {
                throw new AssertionError();
            }
        }

        @Override // org.chromium.base.CommandLine
        protected String[] getCommandLineArguments() {
            return (String[]) this.mArgs.toArray(new String[this.mArgs.size()]);
        }

        @Override // org.chromium.base.CommandLine
        public boolean hasSwitch(String switchString) {
            return this.mSwitches.containsKey(switchString);
        }

        @Override // org.chromium.base.CommandLine
        public String getSwitchValue(String switchString) {
            String value = this.mSwitches.get(switchString);
            if (value == null || value.isEmpty()) {
                return null;
            }
            return value;
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitch(String switchString) {
            appendSwitchWithValue(switchString, null);
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitchWithValue(String switchString, String value) {
            this.mSwitches.put(switchString, value == null ? CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE : value);
            String combinedSwitchString = "--" + switchString;
            if (value != null && !value.isEmpty()) {
                combinedSwitchString = combinedSwitchString + CommandLine.SWITCH_VALUE_SEPARATOR + value;
            }
            ArrayList<String> arrayList = this.mArgs;
            int i = this.mArgsBegin;
            this.mArgsBegin = i + 1;
            arrayList.add(i, combinedSwitchString);
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] array) {
            appendSwitchesInternal(array, 0);
        }

        private void appendSwitchesInternal(String[] array, int skipCount) {
            boolean parseSwitches = true;
            for (String arg : array) {
                if (skipCount > 0) {
                    skipCount--;
                } else {
                    if (arg.equals("--")) {
                        parseSwitches = false;
                    }
                    if (parseSwitches && arg.startsWith("--")) {
                        String[] parts = arg.split(CommandLine.SWITCH_VALUE_SEPARATOR, 2);
                        String value = parts.length > 1 ? parts[1] : null;
                        appendSwitchWithValue(parts[0].substring("--".length()), value);
                    } else {
                        this.mArgs.add(arg);
                    }
                }
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/CommandLine$NativeCommandLine.class */
    private static class NativeCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !CommandLine.class.desiredAssertionStatus();
        }

        public NativeCommandLine(@Nullable String[] args) {
            super();
            CommandLine.nativeInit(args);
        }

        @Override // org.chromium.base.CommandLine
        public boolean hasSwitch(String switchString) {
            return CommandLine.nativeHasSwitch(switchString);
        }

        @Override // org.chromium.base.CommandLine
        public String getSwitchValue(String switchString) {
            return CommandLine.nativeGetSwitchValue(switchString);
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitch(String switchString) {
            CommandLine.nativeAppendSwitch(switchString);
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitchWithValue(String switchString, String value) {
            CommandLine.nativeAppendSwitchWithValue(switchString, value);
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] array) {
            CommandLine.nativeAppendSwitchesAndArguments(array);
        }

        @Override // org.chromium.base.CommandLine
        public boolean isNativeImplementation() {
            return true;
        }

        @Override // org.chromium.base.CommandLine
        protected String[] getCommandLineArguments() {
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError();
        }

        @Override // org.chromium.base.CommandLine
        protected void destroy() {
            throw new IllegalStateException("Can't destroy native command line after startup");
        }
    }
}
