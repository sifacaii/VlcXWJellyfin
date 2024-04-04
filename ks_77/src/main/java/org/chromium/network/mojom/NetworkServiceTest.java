package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest.class */
public interface NetworkServiceTest extends Interface {
    public static final Interface.Manager<NetworkServiceTest, Proxy> MANAGER = NetworkServiceTest_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$AddRulesResponse.class */
    public interface AddRulesResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$GetEnvironmentVariableValueResponse.class */
    public interface GetEnvironmentVariableValueResponse extends Callbacks.Callback1<String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$GetLatestMemoryPressureLevelResponse.class */
    public interface GetLatestMemoryPressureLevelResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$GetPeerToPeerConnectionsCountChangeResponse.class */
    public interface GetPeerToPeerConnectionsCountChangeResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$MockCertVerifierAddResultForCertAndHostResponse.class */
    public interface MockCertVerifierAddResultForCertAndHostResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$MockCertVerifierSetDefaultResultResponse.class */
    public interface MockCertVerifierSetDefaultResultResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$Proxy.class */
    public interface Proxy extends NetworkServiceTest, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$SetShouldRequireCtResponse.class */
    public interface SetShouldRequireCtResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$SetTransportSecurityStateSourceResponse.class */
    public interface SetTransportSecurityStateSourceResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$SimulateNetworkChangeResponse.class */
    public interface SimulateNetworkChangeResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$SimulateNetworkQualityChangeResponse.class */
    public interface SimulateNetworkQualityChangeResponse extends Callbacks.Callback0 {
    }

    void addRules(Rule[] ruleArr, AddRulesResponse addRulesResponse);

    void simulateNetworkChange(int i, SimulateNetworkChangeResponse simulateNetworkChangeResponse);

    void simulateNetworkQualityChange(int i, SimulateNetworkQualityChangeResponse simulateNetworkQualityChangeResponse);

    void simulateCrash();

    void mockCertVerifierSetDefaultResult(int i, MockCertVerifierSetDefaultResultResponse mockCertVerifierSetDefaultResultResponse);

    void mockCertVerifierAddResultForCertAndHost(X509Certificate x509Certificate, String str, CertVerifyResult certVerifyResult, int i, MockCertVerifierAddResultForCertAndHostResponse mockCertVerifierAddResultForCertAndHostResponse);

    void setShouldRequireCt(int i, SetShouldRequireCtResponse setShouldRequireCtResponse);

    void setTransportSecurityStateSource(short s, SetTransportSecurityStateSourceResponse setTransportSecurityStateSourceResponse);

    void crashOnResolveHost(String str);

    void crashOnGetCookieList();

    void getLatestMemoryPressureLevel(GetLatestMemoryPressureLevelResponse getLatestMemoryPressureLevelResponse);

    void getPeerToPeerConnectionsCountChange(GetPeerToPeerConnectionsCountChangeResponse getPeerToPeerConnectionsCountChangeResponse);

    void getEnvironmentVariableValue(String str, GetEnvironmentVariableValueResponse getEnvironmentVariableValueResponse);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest$ShouldRequireCt.class */
    public static final class ShouldRequireCt {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int RESET = 0;
        public static final int REQUIRE = 1;
        public static final int DONT_REQUIRE = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private ShouldRequireCt() {
        }
    }
}
