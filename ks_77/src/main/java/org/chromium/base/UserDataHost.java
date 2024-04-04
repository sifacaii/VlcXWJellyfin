package org.chromium.base;

import android.os.Process;
import java.util.HashMap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/UserDataHost.class */
public final class UserDataHost {
    private final long mThreadId = Process.myTid();
    private HashMap<Class<? extends UserData>, UserData> mUserDataMap = new HashMap<>();
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !UserDataHost.class.desiredAssertionStatus();
    }

    private void checkThreadAndState() {
        if (!$assertionsDisabled && this.mThreadId != Process.myTid()) {
            throw new AssertionError("UserData must only be used on a single thread.");
        }
        if (!$assertionsDisabled && this.mUserDataMap == null) {
            throw new AssertionError("Operation is not allowed after destroy()");
        }
    }

    public <T extends UserData> T setUserData(Class<T> key, T object) {
        checkThreadAndState();
        if ($assertionsDisabled || !(key == null || object == null)) {
            this.mUserDataMap.put(key, object);
            return (T) getUserData(key);
        }
        throw new AssertionError("Neither key nor object of UserDataHost can be null");
    }

    public <T extends UserData> T getUserData(Class<T> key) {
        checkThreadAndState();
        if ($assertionsDisabled || key != null) {
            return key.cast(this.mUserDataMap.get(key));
        }
        throw new AssertionError("UserDataHost key cannot be null");
    }

    public <T extends UserData> T removeUserData(Class<T> key) {
        checkThreadAndState();
        if ($assertionsDisabled || key != null) {
            if ($assertionsDisabled || this.mUserDataMap.containsKey(key)) {
                return key.cast(this.mUserDataMap.remove(key));
            }
            throw new AssertionError("UserData for the key is not present");
        }
        throw new AssertionError("UserDataHost key cannot be null");
    }

    public void destroy() {
        checkThreadAndState();
        HashMap<Class<? extends UserData>, UserData> map = this.mUserDataMap;
        this.mUserDataMap = null;
        for (UserData userData : map.values()) {
            userData.destroy();
        }
    }
}
