package org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/ProxyBroadcastReceiver.class */
public final class ProxyBroadcastReceiver extends BroadcastReceiver {
    private final ProxyChangeListener mListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProxyBroadcastReceiver(ProxyChangeListener listener) {
        this.mListener = listener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
            this.mListener.updateProxyConfigFromConnectivityManager();
        }
    }
}
