package org.chromium.content.common;

import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.impl.CoreImpl;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/common/ServiceManagerConnectionImpl.class */
public class ServiceManagerConnectionImpl {
    private static native int nativeGetConnectorMessagePipeHandle();

    public static MessagePipeHandle getConnectorMessagePipeHandle() {
        ThreadUtils.assertOnUiThread();
        int handle = nativeGetConnectorMessagePipeHandle();
        Core core = CoreImpl.getInstance();
        return core.acquireNativeHandle(handle).toMessagePipeHandle();
    }
}
