package org.xwalk.core;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkActivity.class */
public abstract class XWalkActivity extends Activity {
    private XWalkActivityDelegate mActivityDelegate;

    protected abstract void onXWalkReady();

    protected void onXWalkFailed() {
        finish();
    }

    protected XWalkDialogManager getDialogManager() {
        return this.mActivityDelegate.getDialogManager();
    }

    public boolean isXWalkReady() {
        return this.mActivityDelegate.isXWalkReady();
    }

    public boolean isSharedMode() {
        return this.mActivityDelegate.isSharedMode();
    }

    public boolean isDownloadMode() {
        return this.mActivityDelegate.isDownloadMode();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Runnable cancelCommand = new Runnable() { // from class: org.xwalk.core.XWalkActivity.1
            @Override // java.lang.Runnable
            public void run() {
                XWalkActivity.this.onXWalkFailed();
            }
        };
        Runnable completeCommand = new Runnable() { // from class: org.xwalk.core.XWalkActivity.2
            @Override // java.lang.Runnable
            public void run() {
                XWalkActivity.this.onXWalkReady();
            }
        };
        this.mActivityDelegate = new XWalkActivityDelegate(this, cancelCommand, completeCommand);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mActivityDelegate.onResume();
    }
}
