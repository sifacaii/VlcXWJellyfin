package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/TextSuggestionHost.class */
public interface TextSuggestionHost extends Interface {
    public static final Interface.Manager<TextSuggestionHost, Proxy> MANAGER = TextSuggestionHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/TextSuggestionHost$Proxy.class */
    public interface Proxy extends TextSuggestionHost, Interface.Proxy {
    }

    void startSuggestionMenuTimer();

    void showSpellCheckSuggestionMenu(double d, double d2, String str, SpellCheckSuggestion[] spellCheckSuggestionArr);

    void showTextSuggestionMenu(double d, double d2, String str, TextSuggestion[] textSuggestionArr);
}
