package com.pakdata.xwalk.refactor;

import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkDevToolsServer.class */
class XWalkDevToolsServer {
    private static final String DEBUG_PERMISSION_SIFFIX = ".permission.DEBUG";
    private long mNativeDevToolsServer;
    private String mSocketName;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkDevToolsServer$Security.class */
    public enum Security {
        DEFAULT,
        ALLOW_DEBUG_PERMISSION,
        ALLOW_SOCKET_ACCESS
    }

    private native long nativeInitRemoteDebugging(String str);

    private native void nativeDestroyRemoteDebugging(long j);

    private native boolean nativeIsRemoteDebuggingEnabled(long j);

    private native void nativeSetRemoteDebuggingEnabled(long j, boolean z, boolean z2, boolean z3);

    public XWalkDevToolsServer(String socketName) {
        this.mNativeDevToolsServer = nativeInitRemoteDebugging(socketName);
        this.mSocketName = socketName;
    }

    public void destroy() {
        nativeDestroyRemoteDebugging(this.mNativeDevToolsServer);
        this.mNativeDevToolsServer = 0L;
    }

    public boolean isRemoteDebuggingEnabled() {
        return nativeIsRemoteDebuggingEnabled(this.mNativeDevToolsServer);
    }

    public void setRemoteDebuggingEnabled(boolean enabled, Security security) {
        boolean allowDebugPermission = security == Security.ALLOW_DEBUG_PERMISSION;
        boolean allowSocketAccess = security == Security.ALLOW_SOCKET_ACCESS;
        nativeSetRemoteDebuggingEnabled(this.mNativeDevToolsServer, enabled, allowDebugPermission, allowSocketAccess);
    }

    public void setRemoteDebuggingEnabled(boolean enabled) {
        setRemoteDebuggingEnabled(enabled, Security.DEFAULT);
    }

    public String getSocketName() {
        return this.mSocketName;
    }

    @CalledByNative
    private static boolean checkDebugPermission(int pid, int uid) {
        String debugPermissionName = ContextUtils.getApplicationContext().getPackageName() + DEBUG_PERMISSION_SIFFIX;
        return ContextUtils.getApplicationContext().checkPermission(debugPermissionName, pid, uid) == 0;
    }
}
