package org.chromium.content.browser;

import android.annotation.SuppressLint;
import android.os.Process;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeClassQualifiedName;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.net.NetworkChangeNotifierAutoDetect;
import org.chromium.net.RegistrationPolicyAlwaysRegister;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/BackgroundSyncNetworkObserver.class */
class BackgroundSyncNetworkObserver implements NetworkChangeNotifierAutoDetect.Observer {
    private static final String TAG = "cr_BgSyncNetObserver";
    private NetworkChangeNotifierAutoDetect mNotifier;
    @SuppressLint({"StaticFieldLeak"})
    private static BackgroundSyncNetworkObserver sInstance;
    private List<Long> mNativePtrs;
    private int mLastBroadcastConnectionType;
    private boolean mHasBroadcastConnectionType;

    @NativeClassQualifiedName("BackgroundSyncNetworkObserverAndroid::Observer")
    private native void nativeNotifyConnectionTypeChanged(long j, int i);

    private BackgroundSyncNetworkObserver() {
        ThreadUtils.assertOnUiThread();
        this.mNativePtrs = new ArrayList();
    }

    private static boolean canCreateObserver() {
        return ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0;
    }

    @CalledByNative
    private static BackgroundSyncNetworkObserver createObserver(long nativePtr) {
        ThreadUtils.assertOnUiThread();
        if (sInstance == null) {
            sInstance = new BackgroundSyncNetworkObserver();
        }
        sInstance.registerObserver(nativePtr);
        return sInstance;
    }

    private void registerObserver(long nativePtr) {
        ThreadUtils.assertOnUiThread();
        if (!canCreateObserver()) {
            RecordHistogram.recordBooleanHistogram("BackgroundSync.NetworkObserver.HasPermission", false);
            return;
        }
        if (this.mNotifier == null) {
            this.mNotifier = new NetworkChangeNotifierAutoDetect(this, new RegistrationPolicyAlwaysRegister());
            RecordHistogram.recordBooleanHistogram("BackgroundSync.NetworkObserver.HasPermission", true);
        }
        this.mNativePtrs.add(Long.valueOf(nativePtr));
        nativeNotifyConnectionTypeChanged(nativePtr, this.mNotifier.getCurrentNetworkState().getConnectionType());
    }

    @CalledByNative
    private void removeObserver(long nativePtr) {
        ThreadUtils.assertOnUiThread();
        this.mNativePtrs.remove(Long.valueOf(nativePtr));
        if (this.mNativePtrs.size() == 0 && this.mNotifier != null) {
            this.mNotifier.destroy();
            this.mNotifier = null;
        }
    }

    private void broadcastNetworkChangeIfNecessary(int newConnectionType) {
        if (this.mHasBroadcastConnectionType && newConnectionType == this.mLastBroadcastConnectionType) {
            return;
        }
        this.mHasBroadcastConnectionType = true;
        this.mLastBroadcastConnectionType = newConnectionType;
        for (Long nativePtr : this.mNativePtrs) {
            nativeNotifyConnectionTypeChanged(nativePtr.longValue(), newConnectionType);
        }
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
    public void onConnectionTypeChanged(int newConnectionType) {
        ThreadUtils.assertOnUiThread();
        broadcastNetworkChangeIfNecessary(newConnectionType);
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
    public void onConnectionSubtypeChanged(int newConnectionSubtype) {
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
    public void onNetworkConnect(long netId, int connectionType) {
        ThreadUtils.assertOnUiThread();
        broadcastNetworkChangeIfNecessary(this.mNotifier.getCurrentNetworkState().getConnectionType());
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
    public void onNetworkSoonToDisconnect(long netId) {
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
    public void onNetworkDisconnect(long netId) {
        ThreadUtils.assertOnUiThread();
        broadcastNetworkChangeIfNecessary(this.mNotifier.getCurrentNetworkState().getConnectionType());
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
    public void purgeActiveNetworkList(long[] activeNetIds) {
    }
}
