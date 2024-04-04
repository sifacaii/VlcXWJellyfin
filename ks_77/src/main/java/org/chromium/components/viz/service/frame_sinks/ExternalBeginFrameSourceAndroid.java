package org.chromium.components.viz.service.frame_sinks;

import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
import org.chromium.ui.VSyncMonitor;

@JNINamespace("viz")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/viz/service/frame_sinks/ExternalBeginFrameSourceAndroid.class */
public class ExternalBeginFrameSourceAndroid {
    private final long mNativeExternalBeginFrameSourceAndroid;
    private boolean mVSyncNotificationsEnabled;
    private final VSyncMonitor mVSyncMonitor;
    private final VSyncMonitor.Listener mVSyncListener = new VSyncMonitor.Listener() { // from class: org.chromium.components.viz.service.frame_sinks.ExternalBeginFrameSourceAndroid.1
        @Override // org.chromium.ui.VSyncMonitor.Listener
        public void onVSync(VSyncMonitor monitor, long vsyncTimeMicros) {
            if (ExternalBeginFrameSourceAndroid.this.mVSyncNotificationsEnabled) {
                ExternalBeginFrameSourceAndroid.this.nativeOnVSync(ExternalBeginFrameSourceAndroid.this.mNativeExternalBeginFrameSourceAndroid, vsyncTimeMicros, ExternalBeginFrameSourceAndroid.this.mVSyncMonitor.getVSyncPeriodInMicroseconds());
                ExternalBeginFrameSourceAndroid.this.mVSyncMonitor.requestUpdate();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnVSync(long j, long j2, long j3);

    @CalledByNative
    private ExternalBeginFrameSourceAndroid(long nativeExternalBeginFrameSourceAndroid, float refreshRate) {
        this.mNativeExternalBeginFrameSourceAndroid = nativeExternalBeginFrameSourceAndroid;
        this.mVSyncMonitor = new VSyncMonitor(ContextUtils.getApplicationContext(), this.mVSyncListener, refreshRate);
    }

    @CalledByNative
    private void setEnabled(boolean enabled) {
        if (this.mVSyncNotificationsEnabled == enabled) {
            return;
        }
        this.mVSyncNotificationsEnabled = enabled;
        if (this.mVSyncNotificationsEnabled) {
            this.mVSyncMonitor.requestUpdate();
        }
    }

    @CalledByNative
    private void updateRefreshRate(float refreshRate) {
        this.mVSyncMonitor.updateRefreshRate(refreshRate);
    }
}
