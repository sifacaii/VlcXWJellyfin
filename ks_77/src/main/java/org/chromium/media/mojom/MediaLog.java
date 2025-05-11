package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaLog.class */
public interface MediaLog extends Interface {
    public static final Interface.Manager<MediaLog, Proxy> MANAGER = MediaLog_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaLog$Proxy.class */
    public interface Proxy extends MediaLog, Interface.Proxy {
    }

    void addEvent(MediaLogEvent mediaLogEvent);
}
