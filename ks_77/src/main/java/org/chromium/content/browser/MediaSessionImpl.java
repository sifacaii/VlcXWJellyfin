package org.chromium.content.browser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.chromium.base.ObserverList;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content_public.browser.MediaSession;
import org.chromium.content_public.browser.MediaSessionObserver;
import org.chromium.content_public.browser.WebContents;
import org.chromium.services.media_session.MediaImage;
import org.chromium.services.media_session.MediaMetadata;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/MediaSessionImpl.class */
public class MediaSessionImpl extends MediaSession {
    private long mNativeMediaSessionAndroid;
    private ObserverList<MediaSessionObserver> mObservers = new ObserverList<>();
    private ObserverList.RewindableIterator<MediaSessionObserver> mObserversIterator = this.mObservers.rewindableIterator();
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeResume(long j);

    private native void nativeSuspend(long j);

    private native void nativeStop(long j);

    private native void nativeSeek(long j, long j2);

    private native void nativeDidReceiveAction(long j, int i);

    private native void nativeRequestSystemAudioFocus(long j);

    private static native MediaSessionImpl nativeGetMediaSessionFromWebContents(WebContents webContents);

    static {
        $assertionsDisabled = !MediaSessionImpl.class.desiredAssertionStatus();
    }

    public static MediaSessionImpl fromWebContents(WebContents webContents) {
        return nativeGetMediaSessionFromWebContents(webContents);
    }

    public void addObserver(MediaSessionObserver observer) {
        this.mObservers.addObserver(observer);
    }

    public void removeObserver(MediaSessionObserver observer) {
        this.mObservers.removeObserver(observer);
    }

    @Override // org.chromium.content_public.browser.MediaSession
    public ObserverList.RewindableIterator<MediaSessionObserver> getObserversForTesting() {
        return this.mObservers.rewindableIterator();
    }

    @Override // org.chromium.content_public.browser.MediaSession
    public void resume() {
        nativeResume(this.mNativeMediaSessionAndroid);
    }

    @Override // org.chromium.content_public.browser.MediaSession
    public void suspend() {
        nativeSuspend(this.mNativeMediaSessionAndroid);
    }

    @Override // org.chromium.content_public.browser.MediaSession
    public void stop() {
        nativeStop(this.mNativeMediaSessionAndroid);
    }

    @Override // org.chromium.content_public.browser.MediaSession
    public void seek(long millis) {
        if (!$assertionsDisabled && millis != 0) {
            throw new AssertionError("Attempted to seek by an unspecified number of milliseconds");
        }
        nativeSeek(this.mNativeMediaSessionAndroid, millis);
    }

    @Override // org.chromium.content_public.browser.MediaSession
    public void didReceiveAction(int action) {
        nativeDidReceiveAction(this.mNativeMediaSessionAndroid, action);
    }

    @Override // org.chromium.content_public.browser.MediaSession
    public void requestSystemAudioFocus() {
        nativeRequestSystemAudioFocus(this.mNativeMediaSessionAndroid);
    }

    @CalledByNative
    private boolean hasObservers() {
        return !this.mObservers.isEmpty();
    }

    @CalledByNative
    private void mediaSessionDestroyed() {
        this.mObserversIterator.rewind();
        while (this.mObserversIterator.hasNext()) {
            this.mObserversIterator.next().mediaSessionDestroyed();
        }
        this.mObserversIterator.rewind();
        while (this.mObserversIterator.hasNext()) {
            this.mObserversIterator.next().stopObserving();
        }
        this.mObservers.clear();
        this.mNativeMediaSessionAndroid = 0L;
    }

    @CalledByNative
    private void mediaSessionStateChanged(boolean isControllable, boolean isSuspended) {
        this.mObserversIterator.rewind();
        while (this.mObserversIterator.hasNext()) {
            this.mObserversIterator.next().mediaSessionStateChanged(isControllable, isSuspended);
        }
    }

    @CalledByNative
    private void mediaSessionMetadataChanged(MediaMetadata metadata) {
        this.mObserversIterator.rewind();
        while (this.mObserversIterator.hasNext()) {
            this.mObserversIterator.next().mediaSessionMetadataChanged(metadata);
        }
    }

    @CalledByNative
    private void mediaSessionActionsChanged(int[] actions) {
        HashSet<Integer> actionSet = new HashSet<>();
        for (int action : actions) {
            actionSet.add(Integer.valueOf(action));
        }
        this.mObserversIterator.rewind();
        while (this.mObserversIterator.hasNext()) {
            this.mObserversIterator.next().mediaSessionActionsChanged(actionSet);
        }
    }

    @CalledByNative
    private void mediaSessionArtworkChanged(MediaImage[] images) {
        List<MediaImage> imagesList = Arrays.asList(images);
        this.mObserversIterator.rewind();
        while (this.mObserversIterator.hasNext()) {
            this.mObserversIterator.next().mediaSessionArtworkChanged(imagesList);
        }
    }

    @CalledByNative
    private static MediaSessionImpl create(long nativeMediaSession) {
        return new MediaSessionImpl(nativeMediaSession);
    }

    private MediaSessionImpl(long nativeMediaSession) {
        this.mNativeMediaSessionAndroid = nativeMediaSession;
    }
}
