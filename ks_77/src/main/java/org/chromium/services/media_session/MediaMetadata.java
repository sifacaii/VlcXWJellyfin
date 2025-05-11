package org.chromium.services.media_session;

import androidx.annotation.NonNull;
import android.text.TextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.media_session.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/services/media_session/MediaMetadata.class */
public final class MediaMetadata {
    @NonNull
    private String mTitle;
    @NonNull
    private String mArtist;
    @NonNull
    private String mAlbum;

    public String getTitle() {
        return this.mTitle;
    }

    public String getArtist() {
        return this.mArtist;
    }

    public String getAlbum() {
        return this.mAlbum;
    }

    public void setTitle(@NonNull String title) {
        this.mTitle = title;
    }

    public void setArtist(@NonNull String artist) {
        this.mArtist = artist;
    }

    public void setAlbum(@NonNull String album) {
        this.mAlbum = album;
    }

    @CalledByNative
    private static MediaMetadata create(String title, String artist, String album) {
        return new MediaMetadata(title, artist, album);
    }

    public MediaMetadata(@NonNull String title, @NonNull String artist, @NonNull String album) {
        this.mTitle = title;
        this.mArtist = artist;
        this.mAlbum = album;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MediaMetadata) {
            MediaMetadata other = (MediaMetadata) obj;
            return TextUtils.equals(this.mTitle, other.mTitle) && TextUtils.equals(this.mArtist, other.mArtist) && TextUtils.equals(this.mAlbum, other.mAlbum);
        }
        return false;
    }

    public int hashCode() {
        int result = this.mTitle.hashCode();
        return (31 * ((31 * result) + this.mArtist.hashCode())) + this.mAlbum.hashCode();
    }
}
