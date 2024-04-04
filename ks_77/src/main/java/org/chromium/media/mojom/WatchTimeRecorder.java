package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder.class */
public interface WatchTimeRecorder extends Interface {
    public static final Interface.Manager<WatchTimeRecorder, Proxy> MANAGER = WatchTimeRecorder_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/WatchTimeRecorder$Proxy.class */
    public interface Proxy extends WatchTimeRecorder, Interface.Proxy {
    }

    void recordWatchTime(int i, TimeDelta timeDelta);

    void finalizeWatchTime(int[] iArr);

    void onError(int i);

    void updateSecondaryProperties(SecondaryPlaybackProperties secondaryPlaybackProperties);

    void setAutoplayInitiated(boolean z);

    void onDurationChanged(TimeDelta timeDelta);

    void updateUnderflowCount(int i);
}
