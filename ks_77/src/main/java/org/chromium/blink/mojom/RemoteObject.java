package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteObject.class */
public interface RemoteObject extends Interface {
    public static final Interface.Manager<RemoteObject, Proxy> MANAGER = RemoteObject_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteObject$GetMethodsResponse.class */
    public interface GetMethodsResponse extends Callbacks.Callback1<String[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteObject$HasMethodResponse.class */
    public interface HasMethodResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteObject$InvokeMethodResponse.class */
    public interface InvokeMethodResponse extends Callbacks.Callback1<RemoteInvocationResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteObject$Proxy.class */
    public interface Proxy extends RemoteObject, Interface.Proxy {
    }

    void hasMethod(String str, HasMethodResponse hasMethodResponse);

    void getMethods(GetMethodsResponse getMethodsResponse);

    void invokeMethod(String str, RemoteInvocationArgument[] remoteInvocationArgumentArr, InvokeMethodResponse invokeMethodResponse);
}
