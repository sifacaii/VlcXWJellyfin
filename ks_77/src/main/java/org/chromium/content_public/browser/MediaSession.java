package org.chromium.content_public.browser;

import androidx.annotation.Nullable;
import org.chromium.base.ObserverList;
import org.chromium.base.VisibleForTesting;
import org.chromium.content.browser.MediaSessionImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/MediaSession.class */
public abstract class MediaSession {
    @VisibleForTesting
    public abstract ObserverList.RewindableIterator<MediaSessionObserver> getObserversForTesting();

    public abstract void resume();

    public abstract void suspend();

    public abstract void stop();

    public abstract void seek(long j);

    public abstract void didReceiveAction(int i);

    public abstract void requestSystemAudioFocus();

    @Nullable
    public static MediaSession fromWebContents(WebContents contents) {
        return MediaSessionImpl.fromWebContents(contents);
    }
}
