package org.xwalk.core;

import android.app.Application;
import android.content.res.Resources;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkApplication.class */
public class XWalkApplication extends Application {
    private static XWalkApplication gApp;
    private Resources mRes;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        gApp = this;
    }

    void addResource(Resources res) {
        if (this.mRes != null) {
            return;
        }
        this.mRes = new XWalkMixedResources(super.getResources(), res);
    }

    static XWalkApplication getApplication() {
        return gApp;
    }
}
