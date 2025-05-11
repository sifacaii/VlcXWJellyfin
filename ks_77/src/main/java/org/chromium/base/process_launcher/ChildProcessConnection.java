package org.chromium.base.process_launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.Log;
import org.chromium.base.MemoryPressureListener;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.memory.MemoryPressureCallback;
import org.chromium.base.process_launcher.IChildProcessService;
import org.chromium.base.process_launcher.IParentProcess;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/ChildProcessConnection.class */
public class ChildProcessConnection {
    private static final String TAG = "ChildProcessConn";
    private static final int NUM_BINDING_STATES = 4;
    private static final Object sBindingStateLock;
    @GuardedBy("sBindingStateLock")
    private static final int[] sAllBindingStateCounts;
    private final Handler mLauncherHandler;
    private final Executor mLauncherExecutor;
    private final ComponentName mServiceName;
    private final Bundle mServiceBundle;
    private final boolean mBindToCaller;
    private ServiceCallback mServiceCallback;
    private ConnectionParams mConnectionParams;
    private ConnectionCallback mConnectionCallback;
    private IChildProcessService mService;
    private boolean mDidOnServiceConnected;
    private boolean mServiceConnectComplete;
    private boolean mServiceDisconnected;
    private int mPid;
    private final ChildServiceConnection mStrongBinding;
    private final ChildServiceConnection mModerateBinding;
    private final ChildServiceConnection mWaivedBinding;
    private int mStrongBindingCount;
    private int mModerateBindingCount;
    private int mGroup;
    private int mImportanceInGroup;
    private boolean mUnbound;
    @GuardedBy("sBindingStateLock")
    private int mBindingState;
    @GuardedBy("sBindingStateLock")
    private int mBindingStateCurrentOrWhenDied;
    @GuardedBy("sBindingStateLock")
    private boolean mKilledByUs;
    @GuardedBy("sBindingStateLock")
    private int[] mAllBindingStateCountsWhenDied;
    private MemoryPressureCallback mMemoryPressureCallback;
    @GuardedBy("sBindingStateLock")
    private boolean mCleanExit;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/ChildProcessConnection$ChildServiceConnection.class */
    public interface ChildServiceConnection {
        boolean bind();

        void unbind();

        boolean isBound();

        void updateGroupImportance(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/ChildProcessConnection$ChildServiceConnectionDelegate.class */
    public interface ChildServiceConnectionDelegate {
        void onServiceConnected(IBinder iBinder);

        void onServiceDisconnected();
    }

    @VisibleForTesting
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/ChildProcessConnection$ChildServiceConnectionFactory.class */
    protected interface ChildServiceConnectionFactory {
        ChildServiceConnection createConnection(Intent intent, int i, ChildServiceConnectionDelegate childServiceConnectionDelegate, String str);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/ChildProcessConnection$ConnectionCallback.class */
    public interface ConnectionCallback {
        void onConnected(ChildProcessConnection childProcessConnection);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/ChildProcessConnection$ServiceCallback.class */
    public interface ServiceCallback {
        void onChildStarted();

        void onChildStartFailed(ChildProcessConnection childProcessConnection);

        void onChildProcessDied(ChildProcessConnection childProcessConnection);
    }

    static {
        $assertionsDisabled = !ChildProcessConnection.class.desiredAssertionStatus();
        sBindingStateLock = new Object();
        sAllBindingStateCounts = new int[4];
    }

    public static boolean supportVariableConnections() {
        return BindService.supportVariableConnections();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/ChildProcessConnection$ChildServiceConnectionImpl.class */
    private static class ChildServiceConnectionImpl implements ChildServiceConnection, ServiceConnection {
        private final Context mContext;
        private final Intent mBindIntent;
        private final int mBindFlags;
        private final Handler mHandler;
        private final Executor mExecutor;
        private final ChildServiceConnectionDelegate mDelegate;
        private final String mInstanceName;
        private boolean mBound;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ChildProcessConnection.class.desiredAssertionStatus();
        }

        private ChildServiceConnectionImpl(Context context, Intent bindIntent, int bindFlags, Handler handler, Executor executor, ChildServiceConnectionDelegate delegate, String instanceName) {
            this.mContext = context;
            this.mBindIntent = bindIntent;
            this.mBindFlags = bindFlags;
            this.mHandler = handler;
            this.mExecutor = executor;
            this.mDelegate = delegate;
            this.mInstanceName = instanceName;
        }

        @Override // org.chromium.base.process_launcher.ChildProcessConnection.ChildServiceConnection
        public boolean bind() {
            try {
                TraceEvent.begin("ChildProcessConnection.ChildServiceConnectionImpl.bind");
                this.mBound = BindService.doBindService(this.mContext, this.mBindIntent, this, this.mBindFlags, this.mHandler, this.mExecutor, this.mInstanceName);
                TraceEvent.end("ChildProcessConnection.ChildServiceConnectionImpl.bind");
                return this.mBound;
            } catch (Throwable th) {
                TraceEvent.end("ChildProcessConnection.ChildServiceConnectionImpl.bind");
                throw th;
            }
        }

        @Override // org.chromium.base.process_launcher.ChildProcessConnection.ChildServiceConnection
        public void unbind() {
            if (this.mBound) {
                this.mContext.unbindService(this);
                this.mBound = false;
            }
        }

        @Override // org.chromium.base.process_launcher.ChildProcessConnection.ChildServiceConnection
        public boolean isBound() {
            return this.mBound;
        }

        @Override // org.chromium.base.process_launcher.ChildProcessConnection.ChildServiceConnection
        public void updateGroupImportance(int group, int importanceInGroup) {
            if (!$assertionsDisabled && !isBound()) {
                throw new AssertionError();
            }
            if (BindService.supportVariableConnections()) {
                BindService.updateServiceGroup(this.mContext, this, group, importanceInGroup);
                BindService.doBindService(this.mContext, this.mBindIntent, this, this.mBindFlags, this.mHandler, this.mExecutor, this.mInstanceName);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder service) {
            this.mDelegate.onServiceConnected(service);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName className) {
            this.mDelegate.onServiceDisconnected();
        }
    }

    @VisibleForTesting
    static void resetBindingStateCountsForTesting() {
        synchronized (sBindingStateLock) {
            for (int i = 0; i < 4; i++) {
                sAllBindingStateCounts[i] = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/ChildProcessConnection$ConnectionParams.class */
    public static class ConnectionParams {
        final Bundle mConnectionBundle;
        final List<IBinder> mClientInterfaces;

        ConnectionParams(Bundle connectionBundle, List<IBinder> clientInterfaces) {
            this.mConnectionBundle = connectionBundle;
            this.mClientInterfaces = clientInterfaces;
        }
    }

    public ChildProcessConnection(Context context, ComponentName serviceName, boolean bindToCaller, boolean bindAsExternalService, Bundle serviceBundle, String instanceName) {
        this(context, serviceName, bindToCaller, bindAsExternalService, serviceBundle, null, instanceName);
    }

    @VisibleForTesting
    public ChildProcessConnection(final Context context, ComponentName serviceName, boolean bindToCaller, boolean bindAsExternalService, Bundle serviceBundle, ChildServiceConnectionFactory connectionFactory, String instanceName) {
        this.mLauncherHandler = new Handler();
        this.mLauncherExecutor = runnable -> {
            this.mLauncherHandler.post(runnable);
        };
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        this.mServiceName = serviceName;
        this.mServiceBundle = serviceBundle != null ? serviceBundle : new Bundle();
        this.mServiceBundle.putBoolean(ChildProcessConstants.EXTRA_BIND_TO_CALLER, bindToCaller);
        this.mBindToCaller = bindToCaller;
        connectionFactory = connectionFactory == null ? new ChildServiceConnectionFactory() { // from class: org.chromium.base.process_launcher.ChildProcessConnection.1
            @Override // org.chromium.base.process_launcher.ChildProcessConnection.ChildServiceConnectionFactory
            public ChildServiceConnection createConnection(Intent bindIntent, int bindFlags, ChildServiceConnectionDelegate delegate, String instanceName2) {
                return new ChildServiceConnectionImpl(context, bindIntent, bindFlags, ChildProcessConnection.this.mLauncherHandler, ChildProcessConnection.this.mLauncherExecutor, delegate, instanceName2);
            }
        } : connectionFactory;
        ChildServiceConnectionDelegate delegate = new ChildServiceConnectionDelegate() { // from class: org.chromium.base.process_launcher.ChildProcessConnection.2
            @Override // org.chromium.base.process_launcher.ChildProcessConnection.ChildServiceConnectionDelegate
            public void onServiceConnected(IBinder service) {
                if (ChildProcessConnection.this.mLauncherHandler.getLooper() != Looper.myLooper()) {
                    ChildProcessConnection.this.mLauncherHandler.post(() -> {
                        ChildProcessConnection.this.onServiceConnectedOnLauncherThread(service);
                    });
                } else {
                    ChildProcessConnection.this.onServiceConnectedOnLauncherThread(service);
                }
            }

            @Override // org.chromium.base.process_launcher.ChildProcessConnection.ChildServiceConnectionDelegate
            public void onServiceDisconnected() {
                if (ChildProcessConnection.this.mLauncherHandler.getLooper() != Looper.myLooper()) {
                    ChildProcessConnection.this.mLauncherHandler.post(() -> {
                        ChildProcessConnection.this.onServiceDisconnectedOnLauncherThread();
                    });
                } else {
                    ChildProcessConnection.this.onServiceDisconnectedOnLauncherThread();
                }
            }
        };
        Intent intent = new Intent();
        intent.setComponent(serviceName);
        if (serviceBundle != null) {
            intent.putExtras(serviceBundle);
        }
        int defaultFlags = 1 | (bindAsExternalService ? Integer.MIN_VALUE : 0);
        this.mModerateBinding = connectionFactory.createConnection(intent, defaultFlags, delegate, instanceName);
        this.mStrongBinding = connectionFactory.createConnection(intent, defaultFlags | 64, delegate, instanceName);
        this.mWaivedBinding = connectionFactory.createConnection(intent, defaultFlags | 32, delegate, instanceName);
    }

    public final IChildProcessService getService() {
        if ($assertionsDisabled || isRunningOnLauncherThread()) {
            return this.mService;
        }
        throw new AssertionError();
    }

    public final ComponentName getServiceName() {
        if ($assertionsDisabled || isRunningOnLauncherThread()) {
            return this.mServiceName;
        }
        throw new AssertionError();
    }

    public boolean isConnected() {
        return this.mService != null;
    }

    public int getPid() {
        if ($assertionsDisabled || isRunningOnLauncherThread()) {
            return this.mPid;
        }
        throw new AssertionError();
    }

    public void start(boolean useStrongBinding, ServiceCallback serviceCallback) {
        try {
            TraceEvent.begin("ChildProcessConnection.start");
            if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && this.mConnectionParams != null) {
                throw new AssertionError("setupConnection() called before start() in ChildProcessConnection.");
            }
            this.mServiceCallback = serviceCallback;
            if (!bind(useStrongBinding)) {
                Log.e(TAG, "Failed to establish the service connection.", new Object[0]);
                notifyChildProcessDied();
            }
            TraceEvent.end("ChildProcessConnection.start");
        } catch (Throwable th) {
            TraceEvent.end("ChildProcessConnection.start");
            throw th;
        }
    }

    public void rebind() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !this.mWaivedBinding.isBound()) {
            throw new AssertionError();
        }
        this.mWaivedBinding.bind();
    }

    public void setupConnection(Bundle connectionBundle, @Nullable List<IBinder> clientInterfaces, ConnectionCallback connectionCallback) {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mConnectionParams != null) {
            throw new AssertionError();
        }
        if (this.mServiceDisconnected) {
            Log.w(TAG, "Tried to setup a connection that already disconnected.", new Object[0]);
            connectionCallback.onConnected(null);
            return;
        }
        try {
            TraceEvent.begin("ChildProcessConnection.setupConnection");
            this.mConnectionCallback = connectionCallback;
            this.mConnectionParams = new ConnectionParams(connectionBundle, clientInterfaces);
            if (this.mServiceConnectComplete) {
                doConnectionSetup();
            }
        } finally {
            TraceEvent.end("ChildProcessConnection.setupConnection");
        }
    }

    public void stop() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        unbind();
        notifyChildProcessDied();
    }

    public void kill() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        IChildProcessService service = this.mService;
        unbind();
        if (service != null) {
            try {
                service.forceKill();
            } catch (RemoteException e) {
            }
        }
        synchronized (sBindingStateLock) {
            this.mKilledByUs = true;
        }
        notifyChildProcessDied();
    }

    public void dumpProcessStack() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        IChildProcessService service = this.mService;
        if (service != null) {
            try {
                service.dumpProcessStack();
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to dump process stack.", e);
            }
        }
    }

    @VisibleForTesting
    protected void onServiceConnectedOnLauncherThread(IBinder service) {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        if (this.mDidOnServiceConnected) {
            return;
        }
        try {
            TraceEvent.begin("ChildProcessConnection.ChildServiceConnection.onServiceConnected");
            this.mDidOnServiceConnected = true;
            this.mService = IChildProcessService.Stub.asInterface(service);
            if (this.mBindToCaller) {
                try {
                    if (!this.mService.bindToCaller()) {
                        if (this.mServiceCallback != null) {
                            this.mServiceCallback.onChildStartFailed(this);
                        }
                        unbind();
                        TraceEvent.end("ChildProcessConnection.ChildServiceConnection.onServiceConnected");
                        return;
                    }
                } catch (RemoteException ex) {
                    Log.e(TAG, "Failed to bind service to connection.", ex);
                    TraceEvent.end("ChildProcessConnection.ChildServiceConnection.onServiceConnected");
                    return;
                }
            }
            if (this.mServiceCallback != null) {
                this.mServiceCallback.onChildStarted();
            }
            this.mServiceConnectComplete = true;
            if (this.mMemoryPressureCallback == null) {
                MemoryPressureCallback callback = this::onMemoryPressure;
                ThreadUtils.postOnUiThread(() -> {
                    MemoryPressureListener.addCallback(callback);
                });
                this.mMemoryPressureCallback = callback;
            }
            if (this.mConnectionParams != null) {
                doConnectionSetup();
            }
            TraceEvent.end("ChildProcessConnection.ChildServiceConnection.onServiceConnected");
        } catch (Throwable th) {
            TraceEvent.end("ChildProcessConnection.ChildServiceConnection.onServiceConnected");
            throw th;
        }
    }

    @VisibleForTesting
    protected void onServiceDisconnectedOnLauncherThread() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        if (this.mServiceDisconnected) {
            return;
        }
        this.mServiceDisconnected = true;
        Log.w(TAG, "onServiceDisconnected (crash or killed by oom): pid=%d", Integer.valueOf(this.mPid));
        stop();
        if (this.mConnectionCallback != null) {
            this.mConnectionCallback.onConnected(null);
            this.mConnectionCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetupConnectionResult(int pid) {
        if (this.mPid != 0) {
            Log.e(TAG, "sendPid was called more than once: pid=%d", Integer.valueOf(this.mPid));
            return;
        }
        this.mPid = pid;
        if (!$assertionsDisabled && this.mPid == 0) {
            throw new AssertionError("Child service claims to be run by a process of pid=0.");
        }
        if (this.mConnectionCallback != null) {
            this.mConnectionCallback.onConnected(this);
        }
        this.mConnectionCallback = null;
    }

    private void doConnectionSetup() {
        try {
            TraceEvent.begin("ChildProcessConnection.doConnectionSetup");
            if (!$assertionsDisabled && (!this.mServiceConnectComplete || this.mService == null)) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && this.mConnectionParams == null) {
                throw new AssertionError();
            }
            IParentProcess parentProcess = new IParentProcess.Stub() { // from class: org.chromium.base.process_launcher.ChildProcessConnection.3
                @Override // org.chromium.base.process_launcher.IParentProcess
                public void sendPid(final int pid) {
                    ChildProcessConnection.this.mLauncherHandler.post(new Runnable() { // from class: org.chromium.base.process_launcher.ChildProcessConnection.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ChildProcessConnection.this.onSetupConnectionResult(pid);
                        }
                    });
                }

                @Override // org.chromium.base.process_launcher.IParentProcess
                public void reportCleanExit() {
                    synchronized (ChildProcessConnection.sBindingStateLock) {
                        ChildProcessConnection.this.mCleanExit = true;
                    }
                    ChildProcessConnection.this.mLauncherHandler.post(new Runnable() { // from class: org.chromium.base.process_launcher.ChildProcessConnection.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ChildProcessConnection.this.unbind();
                        }
                    });
                }
            };
            try {
                this.mService.setupConnection(this.mConnectionParams.mConnectionBundle, parentProcess, this.mConnectionParams.mClientInterfaces);
            } catch (RemoteException re) {
                Log.e(TAG, "Failed to setup connection.", re);
            }
            this.mConnectionParams = null;
            TraceEvent.end("ChildProcessConnection.doConnectionSetup");
        } catch (Throwable th) {
            TraceEvent.end("ChildProcessConnection.doConnectionSetup");
            throw th;
        }
    }

    private boolean bind(boolean useStrongBinding) {
        boolean success;
        if ($assertionsDisabled || isRunningOnLauncherThread()) {
            if ($assertionsDisabled || !this.mUnbound) {
                if (useStrongBinding) {
                    success = this.mStrongBinding.bind();
                } else {
                    this.mModerateBindingCount++;
                    success = this.mModerateBinding.bind();
                }
                if (success) {
                    this.mWaivedBinding.bind();
                    updateBindingState();
                    return true;
                }
                return false;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    @VisibleForTesting
    protected void unbind() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        this.mService = null;
        this.mConnectionParams = null;
        this.mUnbound = true;
        this.mStrongBinding.unbind();
        this.mWaivedBinding.unbind();
        this.mModerateBinding.unbind();
        updateBindingState();
        synchronized (sBindingStateLock) {
            this.mAllBindingStateCountsWhenDied = Arrays.copyOf(sAllBindingStateCounts, 4);
        }
        if (this.mMemoryPressureCallback != null) {
            MemoryPressureCallback callback = this.mMemoryPressureCallback;
            ThreadUtils.postOnUiThread(() -> {
                MemoryPressureListener.removeCallback(callback);
            });
            this.mMemoryPressureCallback = null;
        }
    }

    public void updateGroupImportance(int group, int importanceInGroup) {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mUnbound) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !this.mWaivedBinding.isBound()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && group == 0 && importanceInGroup != 0) {
            throw new AssertionError();
        }
        if (this.mGroup != group || this.mImportanceInGroup != importanceInGroup) {
            this.mGroup = group;
            this.mImportanceInGroup = importanceInGroup;
            this.mWaivedBinding.updateGroupImportance(group, importanceInGroup);
        }
    }

    public int getGroup() {
        if ($assertionsDisabled || isRunningOnLauncherThread()) {
            return this.mGroup;
        }
        throw new AssertionError();
    }

    public int getImportanceInGroup() {
        if ($assertionsDisabled || isRunningOnLauncherThread()) {
            return this.mImportanceInGroup;
        }
        throw new AssertionError();
    }

    public boolean isStrongBindingBound() {
        if ($assertionsDisabled || isRunningOnLauncherThread()) {
            return this.mStrongBinding.isBound();
        }
        throw new AssertionError();
    }

    public void addStrongBinding() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        if (!isConnected()) {
            Log.w(TAG, "The connection is not bound for %d", Integer.valueOf(getPid()));
            return;
        }
        if (this.mStrongBindingCount == 0) {
            this.mStrongBinding.bind();
            updateBindingState();
        }
        this.mStrongBindingCount++;
    }

    public void removeStrongBinding() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        if (!isConnected()) {
            Log.w(TAG, "The connection is not bound for %d", Integer.valueOf(getPid()));
        } else if (!$assertionsDisabled && this.mStrongBindingCount <= 0) {
            throw new AssertionError();
        } else {
            this.mStrongBindingCount--;
            if (this.mStrongBindingCount == 0) {
                this.mStrongBinding.unbind();
                updateBindingState();
            }
        }
    }

    public boolean isModerateBindingBound() {
        if ($assertionsDisabled || isRunningOnLauncherThread()) {
            return this.mModerateBinding.isBound();
        }
        throw new AssertionError();
    }

    public void addModerateBinding() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        if (!isConnected()) {
            Log.w(TAG, "The connection is not bound for %d", Integer.valueOf(getPid()));
            return;
        }
        if (this.mModerateBindingCount == 0) {
            this.mModerateBinding.bind();
            updateBindingState();
        }
        this.mModerateBindingCount++;
    }

    public void removeModerateBinding() {
        if (!$assertionsDisabled && !isRunningOnLauncherThread()) {
            throw new AssertionError();
        }
        if (!isConnected()) {
            Log.w(TAG, "The connection is not bound for %d", Integer.valueOf(getPid()));
        } else if (!$assertionsDisabled && this.mModerateBindingCount <= 0) {
            throw new AssertionError();
        } else {
            this.mModerateBindingCount--;
            if (this.mModerateBindingCount == 0) {
                this.mModerateBinding.unbind();
                updateBindingState();
            }
        }
    }

    public int bindingStateCurrentOrWhenDied() {
        int i;
        synchronized (sBindingStateLock) {
            i = this.mBindingStateCurrentOrWhenDied;
        }
        return i;
    }

    public boolean isKilledByUs() {
        boolean z;
        synchronized (sBindingStateLock) {
            z = this.mKilledByUs;
        }
        return z;
    }

    public boolean hasCleanExit() {
        boolean z;
        synchronized (sBindingStateLock) {
            z = this.mCleanExit;
        }
        return z;
    }

    public int[] remainingBindingStateCountsCurrentOrWhenDied() {
        synchronized (sBindingStateLock) {
            if (this.mAllBindingStateCountsWhenDied != null) {
                return Arrays.copyOf(this.mAllBindingStateCountsWhenDied, 4);
            }
            int[] counts = Arrays.copyOf(sAllBindingStateCounts, 4);
            if (this.mBindingState != 0) {
                if (!$assertionsDisabled && counts[this.mBindingState] <= 0) {
                    throw new AssertionError();
                }
                int i = this.mBindingState;
                counts[i] = counts[i] - 1;
            }
            return counts;
        }
    }

    private void updateBindingState() {
        int newBindingState;
        if (this.mUnbound) {
            newBindingState = 0;
        } else if (this.mStrongBinding.isBound()) {
            newBindingState = 3;
        } else if (this.mModerateBinding.isBound()) {
            newBindingState = 2;
        } else if (!$assertionsDisabled && !this.mWaivedBinding.isBound()) {
            throw new AssertionError();
        } else {
            newBindingState = 1;
        }
        synchronized (sBindingStateLock) {
            if (newBindingState != this.mBindingState) {
                if (this.mBindingState != 0) {
                    if (!$assertionsDisabled && sAllBindingStateCounts[this.mBindingState] <= 0) {
                        throw new AssertionError();
                    }
                    int[] iArr = sAllBindingStateCounts;
                    int i = this.mBindingState;
                    iArr[i] = iArr[i] - 1;
                }
                if (newBindingState != 0) {
                    int[] iArr2 = sAllBindingStateCounts;
                    int i2 = newBindingState;
                    iArr2[i2] = iArr2[i2] + 1;
                }
            }
            this.mBindingState = newBindingState;
            if (!this.mUnbound) {
                this.mBindingStateCurrentOrWhenDied = this.mBindingState;
            }
        }
    }

    private void notifyChildProcessDied() {
        if (this.mServiceCallback != null) {
            ServiceCallback serviceCallback = this.mServiceCallback;
            this.mServiceCallback = null;
            serviceCallback.onChildProcessDied(this);
        }
    }

    private boolean isRunningOnLauncherThread() {
        return this.mLauncherHandler.getLooper() == Looper.myLooper();
    }

    @VisibleForTesting
    public void crashServiceForTesting() {
        try {
            this.mService.forceKill();
        } catch (RemoteException e) {
        }
    }

    @VisibleForTesting
    public boolean didOnServiceConnectedForTesting() {
        return this.mDidOnServiceConnected;
    }

    @VisibleForTesting
    protected Handler getLauncherHandler() {
        return this.mLauncherHandler;
    }

    private void onMemoryPressure(int pressure) {
        this.mLauncherHandler.post(() -> {
            onMemoryPressureOnLauncherThread(pressure);
        });
    }

    private void onMemoryPressureOnLauncherThread(int pressure) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.onMemoryPressure(pressure);
        } catch (RemoteException e) {
        }
    }
}
