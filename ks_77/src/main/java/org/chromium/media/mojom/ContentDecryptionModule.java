package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule.class */
public interface ContentDecryptionModule extends Interface {
    public static final Interface.Manager<ContentDecryptionModule, Proxy> MANAGER = ContentDecryptionModule_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule$CloseSessionResponse.class */
    public interface CloseSessionResponse extends Callbacks.Callback1<CdmPromiseResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule$CreateSessionAndGenerateRequestResponse.class */
    public interface CreateSessionAndGenerateRequestResponse extends Callbacks.Callback2<CdmPromiseResult, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule$GetStatusForPolicyResponse.class */
    public interface GetStatusForPolicyResponse extends Callbacks.Callback2<CdmPromiseResult, Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule$InitializeResponse.class */
    public interface InitializeResponse extends Callbacks.Callback3<CdmPromiseResult, Integer, Decryptor> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule$LoadSessionResponse.class */
    public interface LoadSessionResponse extends Callbacks.Callback2<CdmPromiseResult, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule$Proxy.class */
    public interface Proxy extends ContentDecryptionModule, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule$RemoveSessionResponse.class */
    public interface RemoveSessionResponse extends Callbacks.Callback1<CdmPromiseResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule$SetServerCertificateResponse.class */
    public interface SetServerCertificateResponse extends Callbacks.Callback1<CdmPromiseResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ContentDecryptionModule$UpdateSessionResponse.class */
    public interface UpdateSessionResponse extends Callbacks.Callback1<CdmPromiseResult> {
    }

    void setClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);

    void initialize(String str, Origin origin, CdmConfig cdmConfig, InitializeResponse initializeResponse);

    void setServerCertificate(byte[] bArr, SetServerCertificateResponse setServerCertificateResponse);

    void getStatusForPolicy(int i, GetStatusForPolicyResponse getStatusForPolicyResponse);

    void createSessionAndGenerateRequest(int i, int i2, byte[] bArr, CreateSessionAndGenerateRequestResponse createSessionAndGenerateRequestResponse);

    void loadSession(int i, String str, LoadSessionResponse loadSessionResponse);

    void updateSession(String str, byte[] bArr, UpdateSessionResponse updateSessionResponse);

    void closeSession(String str, CloseSessionResponse closeSessionResponse);

    void removeSession(String str, RemoveSessionResponse removeSessionResponse);
}
