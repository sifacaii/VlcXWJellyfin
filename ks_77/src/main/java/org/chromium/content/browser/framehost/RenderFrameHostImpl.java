package org.chromium.content.browser.framehost;

import org.chromium.base.Callback;
import org.chromium.base.UnguessableToken;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content_public.browser.RenderFrameHost;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.services.service_manager.InterfaceProvider;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/framehost/RenderFrameHostImpl.class */
public class RenderFrameHostImpl implements RenderFrameHost {
    private long mNativeRenderFrameHostAndroid;
    private final RenderFrameHostDelegate mDelegate;
    private final boolean mIncognito;
    private final InterfaceProvider mInterfaceProvider;

    private native String nativeGetLastCommittedURL(long j);

    private native void nativeGetCanonicalUrlForSharing(long j, Callback<String> callback);

    private native UnguessableToken nativeGetAndroidOverlayRoutingToken(long j);

    private native void nativeNotifyUserActivation(long j);

    private native boolean nativeIsRenderFrameCreated(long j);

    private RenderFrameHostImpl(long nativeRenderFrameHostAndroid, RenderFrameHostDelegate delegate, boolean isIncognito, int nativeInterfaceProviderHandle) {
        this.mNativeRenderFrameHostAndroid = nativeRenderFrameHostAndroid;
        this.mDelegate = delegate;
        this.mIncognito = isIncognito;
        this.mInterfaceProvider = new InterfaceProvider(CoreImpl.getInstance().acquireNativeHandle(nativeInterfaceProviderHandle).toMessagePipeHandle());
        this.mDelegate.renderFrameCreated(this);
    }

    @CalledByNative
    private static RenderFrameHostImpl create(long nativeRenderFrameHostAndroid, RenderFrameHostDelegate delegate, boolean isIncognito, int nativeInterfaceProviderHandle) {
        return new RenderFrameHostImpl(nativeRenderFrameHostAndroid, delegate, isIncognito, nativeInterfaceProviderHandle);
    }

    @CalledByNative
    private void clearNativePtr() {
        this.mNativeRenderFrameHostAndroid = 0L;
        this.mDelegate.renderFrameDeleted(this);
    }

    public RenderFrameHostDelegate getRenderFrameHostDelegate() {
        return this.mDelegate;
    }

    public long getNativePtr() {
        return this.mNativeRenderFrameHostAndroid;
    }

    @Override // org.chromium.content_public.browser.RenderFrameHost
    public String getLastCommittedURL() {
        if (this.mNativeRenderFrameHostAndroid == 0) {
            return null;
        }
        return nativeGetLastCommittedURL(this.mNativeRenderFrameHostAndroid);
    }

    @Override // org.chromium.content_public.browser.RenderFrameHost
    public void getCanonicalUrlForSharing(Callback<String> callback) {
        if (this.mNativeRenderFrameHostAndroid == 0) {
            callback.onResult(null);
        } else {
            nativeGetCanonicalUrlForSharing(this.mNativeRenderFrameHostAndroid, callback);
        }
    }

    @Override // org.chromium.content_public.browser.RenderFrameHost
    public InterfaceProvider getRemoteInterfaces() {
        return this.mInterfaceProvider;
    }

    @Override // org.chromium.content_public.browser.RenderFrameHost
    public boolean isIncognito() {
        return this.mIncognito;
    }

    @Override // org.chromium.content_public.browser.RenderFrameHost
    public void notifyUserActivation() {
        nativeNotifyUserActivation(this.mNativeRenderFrameHostAndroid);
    }

    @Override // org.chromium.content_public.browser.RenderFrameHost
    public boolean isRenderFrameCreated() {
        return nativeIsRenderFrameCreated(this.mNativeRenderFrameHostAndroid);
    }

    public UnguessableToken getAndroidOverlayRoutingToken() {
        if (this.mNativeRenderFrameHostAndroid == 0) {
            return null;
        }
        return nativeGetAndroidOverlayRoutingToken(this.mNativeRenderFrameHostAndroid);
    }
}
