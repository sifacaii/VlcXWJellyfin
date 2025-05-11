package org.chromium.base.process_launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.List;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/ChildProcessServiceDelegate.class */
public interface ChildProcessServiceDelegate {
    void onServiceCreated();

    void onServiceBound(Intent intent);

    void onConnectionSetup(Bundle bundle, List<IBinder> list);

    boolean loadNativeLibrary(Context context);

    void preloadNativeLibrary(Context context);

    SparseArray<String> getFileDescriptorsIdsToKeys();

    void onBeforeMain();

    void runMain();
}
