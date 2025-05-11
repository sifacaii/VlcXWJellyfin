package org.chromium.content_public.browser;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Set;
import org.chromium.content.browser.MediaSessionImpl;
import org.chromium.services.media_session.MediaImage;
import org.chromium.services.media_session.MediaMetadata;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/MediaSessionObserver.class */
public abstract class MediaSessionObserver {
    private MediaSessionImpl mMediaSession;

    protected MediaSessionObserver(MediaSession mediaSession) {
        if (mediaSession instanceof MediaSessionImpl) {
            this.mMediaSession = (MediaSessionImpl) mediaSession;
            this.mMediaSession.addObserver(this);
        }
    }

    @Nullable
    public final MediaSession getMediaSession() {
        return this.mMediaSession;
    }

    public void mediaSessionDestroyed() {
    }

    public void mediaSessionStateChanged(boolean isControllable, boolean isSuspended) {
    }

    public void mediaSessionMetadataChanged(MediaMetadata metadata) {
    }

    public void mediaSessionActionsChanged(Set<Integer> actions) {
    }

    public void mediaSessionArtworkChanged(List<MediaImage> images) {
    }

    public final void stopObserving() {
        if (this.mMediaSession == null) {
            return;
        }
        this.mMediaSession.removeObserver(this);
        this.mMediaSession = null;
    }
}
