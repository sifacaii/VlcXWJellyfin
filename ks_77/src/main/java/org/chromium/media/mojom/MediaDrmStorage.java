package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage.class */
public interface MediaDrmStorage extends Interface {
    public static final Interface.Manager<MediaDrmStorage, Proxy> MANAGER = MediaDrmStorage_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage$InitializeResponse.class */
    public interface InitializeResponse extends Callbacks.Callback2<Boolean, UnguessableToken> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage$LoadPersistentSessionResponse.class */
    public interface LoadPersistentSessionResponse extends Callbacks.Callback1<SessionData> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage$OnProvisionedResponse.class */
    public interface OnProvisionedResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage$Proxy.class */
    public interface Proxy extends MediaDrmStorage, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage$RemovePersistentSessionResponse.class */
    public interface RemovePersistentSessionResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage$SavePersistentSessionResponse.class */
    public interface SavePersistentSessionResponse extends Callbacks.Callback1<Boolean> {
    }

    void initialize(InitializeResponse initializeResponse);

    void onProvisioned(OnProvisionedResponse onProvisionedResponse);

    void savePersistentSession(String str, SessionData sessionData, SavePersistentSessionResponse savePersistentSessionResponse);

    void loadPersistentSession(String str, LoadPersistentSessionResponse loadPersistentSessionResponse);

    void removePersistentSession(String str, RemovePersistentSessionResponse removePersistentSessionResponse);
}
