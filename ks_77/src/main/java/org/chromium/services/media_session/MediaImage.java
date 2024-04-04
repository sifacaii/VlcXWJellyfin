package org.chromium.services.media_session;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.media_session.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/services/media_session/MediaImage.class */
public final class MediaImage {
    @NonNull
    private String mSrc;
    private String mType;
    @NonNull
    private List<Rect> mSizes;

    public MediaImage(@NonNull String src, @NonNull String type, @NonNull List<Rect> sizes) {
        this.mSizes = new ArrayList();
        this.mSrc = src;
        this.mType = type;
        this.mSizes = sizes;
    }

    @NonNull
    public String getSrc() {
        return this.mSrc;
    }

    public String getType() {
        return this.mType;
    }

    public List<Rect> getSizes() {
        return this.mSizes;
    }

    public void setSrc(@NonNull String src) {
        this.mSrc = src;
    }

    public void setType(@NonNull String type) {
        this.mType = type;
    }

    public void setSizes(@NonNull List<Rect> sizes) {
        this.mSizes = sizes;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MediaImage) {
            MediaImage other = (MediaImage) obj;
            return TextUtils.equals(this.mSrc, other.mSrc) && TextUtils.equals(this.mType, other.mType) && this.mSizes.equals(other.mSizes);
        }
        return false;
    }

    public int hashCode() {
        int result = this.mSrc.hashCode();
        return (31 * ((31 * result) + this.mType.hashCode())) + this.mSizes.hashCode();
    }

    @CalledByNative
    private static MediaImage create(String src, String type, Rect[] sizes) {
        return new MediaImage(src, type, Arrays.asList(sizes));
    }

    @CalledByNative
    private static Rect createRect(int width, int height) {
        return new Rect(0, 0, width, height);
    }
}
