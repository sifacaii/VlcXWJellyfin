package org.chromium.net;

import org.chromium.net.NetworkChangeNotifierAutoDetect;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/RegistrationPolicyAlwaysRegister.class */
public class RegistrationPolicyAlwaysRegister extends NetworkChangeNotifierAutoDetect.RegistrationPolicy {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect notifier) {
        super.init(notifier);
        register();
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    protected void destroy() {
    }
}
