package org.chromium.blink.mojom;

import org.chromium.blink.test.mojom.VirtualAuthenticatorManager;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DocumentInterfaceBroker.class */
public interface DocumentInterfaceBroker extends Interface {
    public static final Interface.Manager<DocumentInterfaceBroker, Proxy> MANAGER = DocumentInterfaceBroker_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DocumentInterfaceBroker$Proxy.class */
    public interface Proxy extends DocumentInterfaceBroker, Interface.Proxy {
    }

    void getAudioContextManager(InterfaceRequest<AudioContextManager> interfaceRequest);

    void getAuthenticator(InterfaceRequest<Authenticator> interfaceRequest);

    void getCredentialManager(InterfaceRequest<CredentialManager> interfaceRequest);

    void getFrameHostTestInterface(InterfaceRequest<FrameHostTestInterface> interfaceRequest);

    void getPushMessaging(InterfaceRequest<PushMessaging> interfaceRequest);

    void getVirtualAuthenticatorManager(InterfaceRequest<VirtualAuthenticatorManager> interfaceRequest);

    void registerAppCacheHost(InterfaceRequest<AppCacheHost> interfaceRequest, AppCacheFrontend appCacheFrontend, UnguessableToken unguessableToken);
}
