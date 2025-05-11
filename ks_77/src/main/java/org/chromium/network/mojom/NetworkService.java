package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService.class */
public interface NetworkService extends Interface {
    public static final Interface.Manager<NetworkService, Proxy> MANAGER = NetworkService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService$GetNetworkListResponse.class */
    public interface GetNetworkListResponse extends Callbacks.Callback1<NetworkInterface[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService$GetTotalNetworkUsagesResponse.class */
    public interface GetTotalNetworkUsagesResponse extends Callbacks.Callback1<NetworkUsage[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService$Proxy.class */
    public interface Proxy extends NetworkService, Interface.Proxy {
    }

    void setClient(NetworkServiceClient networkServiceClient, NetworkServiceParams networkServiceParams);

    void startNetLog(File file, int i, DictionaryValue dictionaryValue);

    void setSslKeyLogFile(FilePath filePath);

    void createNetworkContext(InterfaceRequest<NetworkContext> interfaceRequest, NetworkContextParams networkContextParams);

    void configureStubHostResolver(boolean z, DnsOverHttpsServer[] dnsOverHttpsServerArr);

    void disableQuic();

    void setUpHttpAuth(HttpAuthStaticParams httpAuthStaticParams);

    void configureHttpAuthPrefs(HttpAuthDynamicParams httpAuthDynamicParams);

    void setRawHeadersAccess(int i, Origin[] originArr);

    void setMaxConnectionsPerProxy(int i);

    void getNetworkChangeManager(InterfaceRequest<NetworkChangeManager> interfaceRequest);

    void getNetworkQualityEstimatorManager(InterfaceRequest<NetworkQualityEstimatorManager> interfaceRequest);

    void getDnsConfigChangeManager(InterfaceRequest<DnsConfigChangeManager> interfaceRequest);

    void getTotalNetworkUsages(GetTotalNetworkUsagesResponse getTotalNetworkUsagesResponse);

    void getNetworkList(int i, GetNetworkListResponse getNetworkListResponse);

    void updateCrlSet(ReadOnlyBuffer readOnlyBuffer);

    void onCertDbChanged();

    void addCorbExceptionForPlugin(int i);

    void removeCorbExceptionForPlugin(int i);

    void addExtraMimeTypesForCorb(String[] strArr);

    void onMemoryPressure(int i);

    void onPeerToPeerConnectionsCountChange(int i);

    void onApplicationStateChange(int i);

    void setEnvironment(EnvironmentVariable[] environmentVariableArr);

    void dumpWithoutCrashing(Time time);
}
