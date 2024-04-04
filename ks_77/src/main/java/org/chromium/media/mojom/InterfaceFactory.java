package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.Token;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory.class */
public interface InterfaceFactory extends Interface {
    public static final Interface.Manager<InterfaceFactory, Proxy> MANAGER = InterfaceFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory$Proxy.class */
    public interface Proxy extends InterfaceFactory, Interface.Proxy {
    }

    void createAudioDecoder(InterfaceRequest<AudioDecoder> interfaceRequest);

    void createVideoDecoder(InterfaceRequest<VideoDecoder> interfaceRequest);

    void createDefaultRenderer(String str, InterfaceRequest<Renderer> interfaceRequest);

    void createMediaPlayerRenderer(MediaPlayerRendererClientExtension mediaPlayerRendererClientExtension, InterfaceRequest<Renderer> interfaceRequest, InterfaceRequest<MediaPlayerRendererExtension> interfaceRequest2);

    void createFlingingRenderer(String str, FlingingRendererClientExtension flingingRendererClientExtension, InterfaceRequest<Renderer> interfaceRequest);

    void createCdm(String str, InterfaceRequest<ContentDecryptionModule> interfaceRequest);

    void createDecryptor(int i, InterfaceRequest<Decryptor> interfaceRequest);

    void createCdmProxy(Token token, InterfaceRequest<CdmProxy> interfaceRequest);
}
