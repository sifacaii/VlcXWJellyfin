package org.chromium.media;

import android.annotation.TargetApi;
import org.chromium.base.Callback;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("media")
@MainDex
@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/MediaDrmStorageBridge.class */
class MediaDrmStorageBridge {
    private static final long INVALID_NATIVE_MEDIA_DRM_STORAGE_BRIDGE = -1;
    private long mNativeMediaDrmStorageBridge;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeOnProvisioned(long j, Callback<Boolean> callback);

    private native void nativeOnLoadInfo(long j, byte[] bArr, Callback<PersistentInfo> callback);

    private native void nativeOnSaveInfo(long j, PersistentInfo persistentInfo, Callback<Boolean> callback);

    private native void nativeOnClearInfo(long j, byte[] bArr, Callback<Boolean> callback);

    static {
        $assertionsDisabled = !MediaDrmStorageBridge.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainDex
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/MediaDrmStorageBridge$PersistentInfo.class */
    public static class PersistentInfo {
        private final byte[] mEmeId;
        private final byte[] mKeySetId;
        private final String mMimeType;
        private final int mKeyType;

        @CalledByNative("PersistentInfo")
        private static PersistentInfo create(byte[] emeId, byte[] keySetId, String mime, int keyType) {
            return new PersistentInfo(emeId, keySetId, mime, keyType);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PersistentInfo(byte[] emeId, byte[] keySetId, String mime, int keyType) {
            this.mEmeId = emeId;
            this.mKeySetId = keySetId;
            this.mMimeType = mime;
            this.mKeyType = keyType;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @CalledByNative("PersistentInfo")
        public byte[] emeId() {
            return this.mEmeId;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @CalledByNative("PersistentInfo")
        public byte[] keySetId() {
            return this.mKeySetId;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @CalledByNative("PersistentInfo")
        public String mimeType() {
            return this.mMimeType;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @CalledByNative("PersistentInfo")
        public int keyType() {
            return this.mKeyType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaDrmStorageBridge(long nativeMediaDrmStorageBridge) {
        this.mNativeMediaDrmStorageBridge = nativeMediaDrmStorageBridge;
        if (!$assertionsDisabled && !isNativeMediaDrmStorageValid()) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onProvisioned(Callback<Boolean> cb) {
        if (isNativeMediaDrmStorageValid()) {
            nativeOnProvisioned(this.mNativeMediaDrmStorageBridge, cb);
        } else {
            cb.onResult(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadInfo(byte[] emeId, Callback<PersistentInfo> cb) {
        if (isNativeMediaDrmStorageValid()) {
            nativeOnLoadInfo(this.mNativeMediaDrmStorageBridge, emeId, cb);
        } else {
            cb.onResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveInfo(PersistentInfo info, Callback<Boolean> cb) {
        if (isNativeMediaDrmStorageValid()) {
            nativeOnSaveInfo(this.mNativeMediaDrmStorageBridge, info, cb);
        } else {
            cb.onResult(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearInfo(byte[] emeId, Callback<Boolean> cb) {
        if (isNativeMediaDrmStorageValid()) {
            nativeOnClearInfo(this.mNativeMediaDrmStorageBridge, emeId, cb);
        } else {
            cb.onResult(true);
        }
    }

    private boolean isNativeMediaDrmStorageValid() {
        return this.mNativeMediaDrmStorageBridge != -1;
    }
}
