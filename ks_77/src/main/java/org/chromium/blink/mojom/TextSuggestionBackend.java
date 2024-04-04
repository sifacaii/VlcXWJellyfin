package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/TextSuggestionBackend.class */
public interface TextSuggestionBackend extends Interface {
    public static final Interface.Manager<TextSuggestionBackend, Proxy> MANAGER = TextSuggestionBackend_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/TextSuggestionBackend$Proxy.class */
    public interface Proxy extends TextSuggestionBackend, Interface.Proxy {
    }

    void applySpellCheckSuggestion(String str);

    void applyTextSuggestion(int i, int i2);

    void deleteActiveSuggestionRange();

    void onNewWordAddedToDictionary(String str);

    void onSuggestionMenuClosed();

    void suggestionMenuTimeoutCallback(int i);
}
