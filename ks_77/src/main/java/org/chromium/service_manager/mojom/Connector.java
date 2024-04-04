package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector.class */
public interface Connector extends Interface {
    public static final Interface.Manager<Connector, Proxy> MANAGER = Connector_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector$BindInterfaceResponse.class */
    public interface BindInterfaceResponse extends Callbacks.Callback2<Integer, Identity> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector$Proxy.class */
    public interface Proxy extends Connector, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector$QueryServiceResponse.class */
    public interface QueryServiceResponse extends Callbacks.Callback1<ServiceInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector$RegisterServiceInstanceResponse.class */
    public interface RegisterServiceInstanceResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector$WarmServiceResponse.class */
    public interface WarmServiceResponse extends Callbacks.Callback2<Integer, Identity> {
    }

    void bindInterface(ServiceFilter serviceFilter, String str, MessagePipeHandle messagePipeHandle, int i, BindInterfaceResponse bindInterfaceResponse);

    void queryService(String str, QueryServiceResponse queryServiceResponse);

    void warmService(ServiceFilter serviceFilter, WarmServiceResponse warmServiceResponse);

    void registerServiceInstance(Identity identity, MessagePipeHandle messagePipeHandle, InterfaceRequest<ProcessMetadata> interfaceRequest, RegisterServiceInstanceResponse registerServiceInstanceResponse);

    void clone(InterfaceRequest<Connector> interfaceRequest);

    void filterInterfaces(String str, Identity identity, InterfaceRequest<InterfaceProvider> interfaceRequest, InterfaceProvider interfaceProvider);
}
