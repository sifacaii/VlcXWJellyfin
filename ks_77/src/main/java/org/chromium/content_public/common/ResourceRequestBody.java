package org.chromium.content_public.common;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/common/ResourceRequestBody.class */
public final class ResourceRequestBody {
    private byte[] mEncodedNativeForm;

    private static native byte[] nativeCreateResourceRequestBodyFromBytes(byte[] bArr);

    private ResourceRequestBody(byte[] encodedNativeForm) {
        this.mEncodedNativeForm = encodedNativeForm;
    }

    @CalledByNative
    private static ResourceRequestBody createFromEncodedNativeForm(byte[] encodedNativeForm) {
        return new ResourceRequestBody(encodedNativeForm);
    }

    @CalledByNative
    private byte[] getEncodedNativeForm() {
        return this.mEncodedNativeForm;
    }

    public static ResourceRequestBody createFromBytes(byte[] httpBody) {
        byte[] encodedNativeForm = nativeCreateResourceRequestBodyFromBytes(httpBody);
        return createFromEncodedNativeForm(encodedNativeForm);
    }
}
