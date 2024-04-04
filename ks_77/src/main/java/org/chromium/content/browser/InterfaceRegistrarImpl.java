package org.chromium.content.browser;

import android.content.Context;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.androidoverlay.AndroidOverlayProviderImpl;
import org.chromium.content_public.browser.InterfaceRegistrar;
import org.chromium.content_public.browser.RenderFrameHost;
import org.chromium.content_public.browser.WebContents;
import org.chromium.media.mojom.AndroidOverlayProvider;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.services.service_manager.InterfaceRegistry;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/InterfaceRegistrarImpl.class */
class InterfaceRegistrarImpl {
    private static boolean sHasRegisteredRegistrars;

    InterfaceRegistrarImpl() {
    }

    @CalledByNative
    static void createInterfaceRegistryForContext(int nativeHandle) {
        ensureContentRegistrarsAreRegistered();
        InterfaceRegistry registry = InterfaceRegistry.create(CoreImpl.getInstance().acquireNativeHandle(nativeHandle).toMessagePipeHandle());
        InterfaceRegistrar.Registry.applyContextRegistrars(registry);
    }

    @CalledByNative
    static void createInterfaceRegistryForWebContents(int nativeHandle, WebContents webContents) {
        ensureContentRegistrarsAreRegistered();
        InterfaceRegistry registry = InterfaceRegistry.create(CoreImpl.getInstance().acquireNativeHandle(nativeHandle).toMessagePipeHandle());
        InterfaceRegistrar.Registry.applyWebContentsRegistrars(registry, webContents);
    }

    @CalledByNative
    static void createInterfaceRegistryForRenderFrameHost(int nativeHandle, RenderFrameHost renderFrameHost) {
        ensureContentRegistrarsAreRegistered();
        InterfaceRegistry registry = InterfaceRegistry.create(CoreImpl.getInstance().acquireNativeHandle(nativeHandle).toMessagePipeHandle());
        InterfaceRegistrar.Registry.applyRenderFrameHostRegistrars(registry, renderFrameHost);
    }

    private static void ensureContentRegistrarsAreRegistered() {
        if (sHasRegisteredRegistrars) {
            return;
        }
        sHasRegisteredRegistrars = true;
        InterfaceRegistrar.Registry.addContextRegistrar(new ContentContextInterfaceRegistrar());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/InterfaceRegistrarImpl$ContentContextInterfaceRegistrar.class */
    public static class ContentContextInterfaceRegistrar implements InterfaceRegistrar<Context> {
        private ContentContextInterfaceRegistrar() {
        }

        @Override // org.chromium.content_public.browser.InterfaceRegistrar
        public void registerInterfaces(InterfaceRegistry registry, Context applicationContext) {
            registry.addInterface(AndroidOverlayProvider.MANAGER, new AndroidOverlayProviderImpl.Factory(applicationContext));
        }
    }
}
