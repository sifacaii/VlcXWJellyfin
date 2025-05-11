package org.chromium.content_public.browser;

import org.chromium.base.library_loader.ProcessInitException;
import org.chromium.content.browser.BrowserStartupControllerImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/BrowserStartupController.class */
public interface BrowserStartupController {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/BrowserStartupController$StartupCallback.class */
    public interface StartupCallback {
        void onSuccess();

        void onFailure();
    }

    void startBrowserProcessesAsync(boolean z, boolean z2, StartupCallback startupCallback) throws ProcessInitException;

    void startBrowserProcessesSync(boolean z) throws ProcessInitException;

    boolean isFullBrowserStarted();

    boolean isRunningInServiceManagerMode();

    boolean isNativeStarted();

    void addStartupCompletedObserver(StartupCallback startupCallback);

    void setContentMainCallbackForTests(Runnable runnable);

    int getStartupMode(boolean z);

    static BrowserStartupController get(int libraryProcessType) {
        return BrowserStartupControllerImpl.get(libraryProcessType);
    }
}
