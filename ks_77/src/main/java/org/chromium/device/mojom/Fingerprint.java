package org.chromium.device.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint.class */
public interface Fingerprint extends Interface {
    public static final Interface.Manager<Fingerprint, Proxy> MANAGER = Fingerprint_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint$CancelCurrentEnrollSessionResponse.class */
    public interface CancelCurrentEnrollSessionResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint$DestroyAllRecordsResponse.class */
    public interface DestroyAllRecordsResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint$EndCurrentAuthSessionResponse.class */
    public interface EndCurrentAuthSessionResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint$GetRecordsForUserResponse.class */
    public interface GetRecordsForUserResponse extends Callbacks.Callback1<Map<String, String>> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint$Proxy.class */
    public interface Proxy extends Fingerprint, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint$RemoveRecordResponse.class */
    public interface RemoveRecordResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint$RequestRecordLabelResponse.class */
    public interface RequestRecordLabelResponse extends Callbacks.Callback1<String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint$RequestTypeResponse.class */
    public interface RequestTypeResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Fingerprint$SetRecordLabelResponse.class */
    public interface SetRecordLabelResponse extends Callbacks.Callback1<Boolean> {
    }

    void getRecordsForUser(String str, GetRecordsForUserResponse getRecordsForUserResponse);

    void startEnrollSession(String str, String str2);

    void cancelCurrentEnrollSession(CancelCurrentEnrollSessionResponse cancelCurrentEnrollSessionResponse);

    void requestRecordLabel(String str, RequestRecordLabelResponse requestRecordLabelResponse);

    void setRecordLabel(String str, String str2, SetRecordLabelResponse setRecordLabelResponse);

    void removeRecord(String str, RemoveRecordResponse removeRecordResponse);

    void startAuthSession();

    void endCurrentAuthSession(EndCurrentAuthSessionResponse endCurrentAuthSessionResponse);

    void destroyAllRecords(DestroyAllRecordsResponse destroyAllRecordsResponse);

    void addFingerprintObserver(FingerprintObserver fingerprintObserver);

    void requestType(RequestTypeResponse requestTypeResponse);
}
