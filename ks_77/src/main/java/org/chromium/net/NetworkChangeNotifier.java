package org.chromium.net;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.base.ContextUtils;
import org.chromium.base.ObserverList;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeClassQualifiedName;
import org.chromium.base.compat.ApiHelperForM;
import org.chromium.net.NetworkChangeNotifierAutoDetect;

@JNINamespace("net")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/NetworkChangeNotifier.class */
public class NetworkChangeNotifier {
    private NetworkChangeNotifierAutoDetect mAutoDetector;
    @SuppressLint({"StaticFieldLeak"})
    private static NetworkChangeNotifier sInstance;
    static final /* synthetic */ boolean $assertionsDisabled;
    private int mCurrentConnectionType = 0;
    private final ArrayList<Long> mNativeChangeNotifiers = new ArrayList<>();
    private final ObserverList<ConnectionTypeObserver> mConnectionTypeObservers = new ObserverList<>();
    private final ConnectivityManager mConnectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/NetworkChangeNotifier$ConnectionTypeObserver.class */
    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int i);
    }

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyConnectionTypeChanged(long j, int i, long j2);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyMaxBandwidthChanged(long j, int i);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyOfNetworkConnect(long j, long j2, int i);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyOfNetworkSoonToDisconnect(long j, long j2);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyOfNetworkDisconnect(long j, long j2);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyPurgeActiveNetworkList(long j, long[] jArr);

    static {
        $assertionsDisabled = !NetworkChangeNotifier.class.desiredAssertionStatus();
    }

    @VisibleForTesting
    protected NetworkChangeNotifier() {
    }

    @CalledByNative
    public static NetworkChangeNotifier init() {
        if (sInstance == null) {
            sInstance = new NetworkChangeNotifier();
        }
        return sInstance;
    }

    public static boolean isInitialized() {
        return sInstance != null;
    }

    static void resetInstanceForTests(NetworkChangeNotifier notifier) {
        sInstance = notifier;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.mAutoDetector == null) {
            return 0;
        }
        return this.mAutoDetector.getCurrentNetworkState().getConnectionSubtype();
    }

    @CalledByNative
    public long getCurrentDefaultNetId() {
        if (this.mAutoDetector == null) {
            return -1L;
        }
        return this.mAutoDetector.getDefaultNetId();
    }

    @CalledByNative
    public long[] getCurrentNetworksAndTypes() {
        return this.mAutoDetector == null ? new long[0] : this.mAutoDetector.getNetworksAndTypes();
    }

    @CalledByNative
    public void addNativeObserver(long nativeChangeNotifier) {
        this.mNativeChangeNotifiers.add(Long.valueOf(nativeChangeNotifier));
    }

    @CalledByNative
    public void removeNativeObserver(long nativeChangeNotifier) {
        this.mNativeChangeNotifiers.remove(Long.valueOf(nativeChangeNotifier));
    }

    @CalledByNative
    public boolean registerNetworkCallbackFailed() {
        if (this.mAutoDetector == null) {
            return false;
        }
        return this.mAutoDetector.registerNetworkCallbackFailed();
    }

    public static NetworkChangeNotifier getInstance() {
        if ($assertionsDisabled || sInstance != null) {
            return sInstance;
        }
        throw new AssertionError();
    }

    public static void setAutoDetectConnectivityState(boolean shouldAutoDetect) {
        getInstance().setAutoDetectConnectivityStateInternal(shouldAutoDetect, new RegistrationPolicyApplicationStatus());
    }

    public static void registerToReceiveNotificationsAlways() {
        getInstance().setAutoDetectConnectivityStateInternal(true, new RegistrationPolicyAlwaysRegister());
    }

    public static void setAutoDetectConnectivityState(NetworkChangeNotifierAutoDetect.RegistrationPolicy policy) {
        getInstance().setAutoDetectConnectivityStateInternal(true, policy);
    }

    private void destroyAutoDetector() {
        if (this.mAutoDetector != null) {
            this.mAutoDetector.destroy();
            this.mAutoDetector = null;
        }
    }

    private void setAutoDetectConnectivityStateInternal(boolean shouldAutoDetect, NetworkChangeNotifierAutoDetect.RegistrationPolicy policy) {
        if (shouldAutoDetect) {
            if (this.mAutoDetector == null) {
                this.mAutoDetector = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: org.chromium.net.NetworkChangeNotifier.1
                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onConnectionTypeChanged(int newConnectionType) {
                        NetworkChangeNotifier.this.updateCurrentConnectionType(newConnectionType);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onConnectionSubtypeChanged(int newConnectionSubtype) {
                        NetworkChangeNotifier.this.notifyObserversOfConnectionSubtypeChange(newConnectionSubtype);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onNetworkConnect(long netId, int connectionType) {
                        NetworkChangeNotifier.this.notifyObserversOfNetworkConnect(netId, connectionType);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onNetworkSoonToDisconnect(long netId) {
                        NetworkChangeNotifier.this.notifyObserversOfNetworkSoonToDisconnect(netId);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onNetworkDisconnect(long netId) {
                        NetworkChangeNotifier.this.notifyObserversOfNetworkDisconnect(netId);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void purgeActiveNetworkList(long[] activeNetIds) {
                        NetworkChangeNotifier.this.notifyObserversToPurgeActiveNetworkList(activeNetIds);
                    }
                }, policy);
                NetworkChangeNotifierAutoDetect.NetworkState networkState = this.mAutoDetector.getCurrentNetworkState();
                updateCurrentConnectionType(networkState.getConnectionType());
                notifyObserversOfConnectionSubtypeChange(networkState.getConnectionSubtype());
                return;
            }
            return;
        }
        destroyAutoDetector();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean networkAvailable) {
        setAutoDetectConnectivityState(false);
        getInstance().forceConnectivityStateInternal(networkAvailable);
    }

    private void forceConnectivityStateInternal(boolean forceOnline) {
        boolean connectionCurrentlyExists = this.mCurrentConnectionType != 6;
        if (connectionCurrentlyExists != forceOnline) {
            updateCurrentConnectionType(forceOnline ? 0 : 6);
            notifyObserversOfConnectionSubtypeChange(forceOnline ? 0 : 1);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(long netId, int connectionType) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkConnect(netId, connectionType);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(long netId) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkSoonToDisconnect(netId);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(long netId) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkDisconnect(netId);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(long[] activeNetIds) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversToPurgeActiveNetworkList(activeNetIds);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(long netId, int connectionType) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionTypeChange(connectionType, netId);
    }

    @CalledByNative
    public static void fakeConnectionSubtypeChanged(int connectionSubtype) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionSubtypeChange(connectionSubtype);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConnectionType(int newConnectionType) {
        this.mCurrentConnectionType = newConnectionType;
        notifyObserversOfConnectionTypeChange(newConnectionType);
    }

    void notifyObserversOfConnectionTypeChange(int newConnectionType) {
        notifyObserversOfConnectionTypeChange(newConnectionType, getCurrentDefaultNetId());
    }

    private void notifyObserversOfConnectionTypeChange(int newConnectionType, long defaultNetId) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            Long nativeChangeNotifier = it.next();
            nativeNotifyConnectionTypeChanged(nativeChangeNotifier.longValue(), newConnectionType, defaultNetId);
        }
        Iterator<ConnectionTypeObserver> it2 = this.mConnectionTypeObservers.iterator();
        while (it2.hasNext()) {
            ConnectionTypeObserver observer = it2.next();
            observer.onConnectionTypeChanged(newConnectionType);
        }
    }

    void notifyObserversOfConnectionSubtypeChange(int connectionSubtype) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            Long nativeChangeNotifier = it.next();
            nativeNotifyMaxBandwidthChanged(nativeChangeNotifier.longValue(), connectionSubtype);
        }
    }

    void notifyObserversOfNetworkConnect(long netId, int connectionType) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            Long nativeChangeNotifier = it.next();
            nativeNotifyOfNetworkConnect(nativeChangeNotifier.longValue(), netId, connectionType);
        }
    }

    void notifyObserversOfNetworkSoonToDisconnect(long netId) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            Long nativeChangeNotifier = it.next();
            nativeNotifyOfNetworkSoonToDisconnect(nativeChangeNotifier.longValue(), netId);
        }
    }

    void notifyObserversOfNetworkDisconnect(long netId) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            Long nativeChangeNotifier = it.next();
            nativeNotifyOfNetworkDisconnect(nativeChangeNotifier.longValue(), netId);
        }
    }

    void notifyObserversToPurgeActiveNetworkList(long[] activeNetIds) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            Long nativeChangeNotifier = it.next();
            nativeNotifyPurgeActiveNetworkList(nativeChangeNotifier.longValue(), activeNetIds);
        }
    }

    public static void addConnectionTypeObserver(ConnectionTypeObserver observer) {
        getInstance().addConnectionTypeObserverInternal(observer);
    }

    private void addConnectionTypeObserverInternal(ConnectionTypeObserver observer) {
        this.mConnectionTypeObservers.addObserver(observer);
    }

    public static void removeConnectionTypeObserver(ConnectionTypeObserver observer) {
        getInstance().removeConnectionTypeObserverInternal(observer);
    }

    private void removeConnectionTypeObserverInternal(ConnectionTypeObserver observer) {
        this.mConnectionTypeObservers.removeObserver(observer);
    }

    private boolean isProcessBoundToNetworkInternal() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return ApiHelperForM.getBoundNetworkForProcess(this.mConnectivityManager) != null;
        }
        boolean returnValue = ConnectivityManager.getProcessDefaultNetwork() != null;
        return returnValue;
    }

    @CalledByNative
    public static boolean isProcessBoundToNetwork() {
        return getInstance().isProcessBoundToNetworkInternal();
    }

    public static NetworkChangeNotifierAutoDetect getAutoDetectorForTest() {
        return getInstance().mAutoDetector;
    }

    public static boolean isOnline() {
        int connectionType = getInstance().getCurrentConnectionType();
        return connectionType != 6;
    }
}
