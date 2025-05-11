package org.chromium.content_public.common;

import org.chromium.content.common.ServiceManagerConnectionImpl;
import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/common/ServiceManagerConnection.class */
public class ServiceManagerConnection {
    public static MessagePipeHandle getConnectorMessagePipeHandle() {
        return ServiceManagerConnectionImpl.getConnectorMessagePipeHandle();
    }
}
