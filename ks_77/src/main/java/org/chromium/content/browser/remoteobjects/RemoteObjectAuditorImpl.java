package org.chromium.content.browser.remoteobjects;

import android.os.Process;
import android.util.EventLog;
import org.chromium.content.browser.remoteobjects.RemoteObjectImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/remoteobjects/RemoteObjectAuditorImpl.class */
final class RemoteObjectAuditorImpl implements RemoteObjectImpl.Auditor {
    private static final int sObjectGetClassInvocationAttemptLogTag = 70151;

    RemoteObjectAuditorImpl() {
    }

    @Override // org.chromium.content.browser.remoteobjects.RemoteObjectImpl.Auditor
    public void onObjectGetClassInvocationAttempt() {
        EventLog.writeEvent((int) sObjectGetClassInvocationAttemptLogTag, Process.myUid());
    }
}
