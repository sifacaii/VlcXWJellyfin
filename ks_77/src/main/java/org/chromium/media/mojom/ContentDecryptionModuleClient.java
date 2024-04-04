package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModuleClient.class */
public interface ContentDecryptionModuleClient extends Interface {
    public static final Interface.Manager<ContentDecryptionModuleClient, Proxy> MANAGER = ContentDecryptionModuleClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModuleClient$Proxy.class */
    public interface Proxy extends ContentDecryptionModuleClient, Interface.Proxy {
    }

    void onSessionMessage(String str, int i, byte[] bArr);

    void onSessionClosed(String str);

    void onSessionKeysChange(String str, boolean z, CdmKeyInformation[] cdmKeyInformationArr);

    void onSessionExpirationUpdate(String str, double d);
}
