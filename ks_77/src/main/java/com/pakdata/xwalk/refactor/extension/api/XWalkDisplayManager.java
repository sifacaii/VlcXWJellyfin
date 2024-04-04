package com.pakdata.xwalk.refactor.extension.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.Display;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"StaticFieldLeak"})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/extension/api/XWalkDisplayManager.class */
public abstract class XWalkDisplayManager {
    protected final ArrayList<DisplayListener> mListeners = new ArrayList<>();
    private static XWalkDisplayManager mInstance;
    private static Context mContext;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/extension/api/XWalkDisplayManager$DisplayListener.class */
    public interface DisplayListener {
        void onDisplayAdded(int i);

        void onDisplayRemoved(int i);

        void onDisplayChanged(int i);
    }

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String str);

    public abstract Display[] getPresentationDisplays();

    static {
        $assertionsDisabled = !XWalkDisplayManager.class.desiredAssertionStatus();
    }

    public static XWalkDisplayManager getInstance(Context context) {
        if (mContext != null) {
            if (!$assertionsDisabled && context.getApplicationContext() != mContext) {
                throw new AssertionError();
            }
        } else {
            mContext = context.getApplicationContext();
        }
        if (mInstance == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                mInstance = new DisplayManagerJBMR1(mContext);
            } else {
                mInstance = new DisplayManagerNull();
            }
        }
        return mInstance;
    }

    public void registerDisplayListener(DisplayListener listener) {
        this.mListeners.add(listener);
    }

    public void unregisterDisplayListener(DisplayListener listener) {
        this.mListeners.remove(listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDisplayAdded(int displayId) {
        Iterator<DisplayListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            DisplayListener listener = it.next();
            listener.onDisplayAdded(displayId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDisplayRemoved(int displayId) {
        Iterator<DisplayListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            DisplayListener listener = it.next();
            listener.onDisplayRemoved(displayId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDisplayChanged(int displayId) {
        Iterator<DisplayListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            DisplayListener listener = it.next();
            listener.onDisplayChanged(displayId);
        }
    }
}
