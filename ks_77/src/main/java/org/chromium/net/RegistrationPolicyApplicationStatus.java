package org.chromium.net;

import org.chromium.base.ApplicationStatus;
import org.chromium.base.VisibleForTesting;
import org.chromium.net.NetworkChangeNotifierAutoDetect;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/RegistrationPolicyApplicationStatus.class */
public class RegistrationPolicyApplicationStatus extends NetworkChangeNotifierAutoDetect.RegistrationPolicy implements ApplicationStatus.ApplicationStateListener {
    private boolean mDestroyed;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect notifier) {
        super.init(notifier);
        ApplicationStatus.registerApplicationStateListener(this);
        onApplicationStateChange(getApplicationState());
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    protected void destroy() {
        if (this.mDestroyed) {
            return;
        }
        ApplicationStatus.unregisterApplicationStateListener(this);
        this.mDestroyed = true;
    }

    @Override // org.chromium.base.ApplicationStatus.ApplicationStateListener
    public void onApplicationStateChange(int newState) {
        if (newState == 1) {
            register();
        } else if (newState == 2) {
            unregister();
        }
    }

    @VisibleForTesting
    int getApplicationState() {
        return ApplicationStatus.getStateForApplication();
    }
}
