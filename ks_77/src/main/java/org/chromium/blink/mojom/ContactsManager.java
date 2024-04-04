package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContactsManager.class */
public interface ContactsManager extends Interface {
    public static final Interface.Manager<ContactsManager, Proxy> MANAGER = ContactsManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContactsManager$Proxy.class */
    public interface Proxy extends ContactsManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContactsManager$SelectResponse.class */
    public interface SelectResponse extends Callbacks.Callback1<ContactInfo[]> {
    }

    void select(boolean z, boolean z2, boolean z3, boolean z4, SelectResponse selectResponse);
}
