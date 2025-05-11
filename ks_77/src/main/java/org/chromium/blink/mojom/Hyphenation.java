package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.File;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Hyphenation.class */
public interface Hyphenation extends Interface {
    public static final Interface.Manager<Hyphenation, Proxy> MANAGER = Hyphenation_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Hyphenation$OpenDictionaryResponse.class */
    public interface OpenDictionaryResponse extends Callbacks.Callback1<File> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Hyphenation$Proxy.class */
    public interface Proxy extends Hyphenation, Interface.Proxy {
    }

    void openDictionary(String str, OpenDictionaryResponse openDictionaryResponse);
}
