package com.pakdata.xwalk.refactor;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager;
import java.util.HashMap;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

/* JADX INFO: Access modifiers changed from: package-private */
@JNINamespace("xwalk")
@SuppressLint({"StaticFieldLeak"})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkPresentationHost.class */
public class XWalkPresentationHost implements XWalkDisplayManager.DisplayListener {
    private static String TAG;
    private static XWalkPresentationHost sInstance;
    private Context mApplicationContext;
    private HashMap<RenderFrameHostId, PresentationSession> mExistingSessions = new HashMap<>();
    private long mNativePresentationHost;
    private XWalkDisplayManager mDisplayManager;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native long nativeInit();

    private static native void nativeDestroy(long j);

    private native void nativeSetupJavaPeer(long j);

    private native void nativeOnPresentationClosed(long j, int i, int i2);

    private native void nativeOnDisplayAdded(long j, int i);

    private native void nativeOnDisplayChanged(long j, int i);

    private native void nativeOnDisplayRemoved(long j, int i);

    static {
        $assertionsDisabled = !XWalkPresentationHost.class.desiredAssertionStatus();
        TAG = "XWalkPresentationHost";
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkPresentationHost$RenderFrameHostId.class */
    public static class RenderFrameHostId {
        public int renderProcessID;
        public int renderFrameID;

        public RenderFrameHostId(int renderProcessID, int renderFrameID) {
            this.renderProcessID = renderProcessID;
            this.renderFrameID = renderFrameID;
        }

        public int hashCode() {
            int hash = 17 + this.renderProcessID;
            return (hash * 31) + this.renderFrameID;
        }

        public boolean equals(Object obj) {
            if (obj instanceof RenderFrameHostId) {
                if (obj == this) {
                    return true;
                }
                RenderFrameHostId that = (RenderFrameHostId) obj;
                return this.renderProcessID == that.renderProcessID && this.renderFrameID == that.renderFrameID;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkPresentationHost$PresentationSession.class */
    public final class PresentationSession {
        public PresentationScreen presentationScreen = null;
        public Context context;
        public int renderProcessID;
        public int renderFrameID;

        public PresentationSession(Context context, int renderProcessID, int renderFrameID) {
            this.context = context;
            this.renderProcessID = renderProcessID;
            this.renderFrameID = renderFrameID;
        }
    }

    public static XWalkPresentationHost createInstanceOnce(Context context) {
        if (sInstance == null) {
            sInstance = new XWalkPresentationHost(context);
        }
        return sInstance;
    }

    public static XWalkPresentationHost getInstance() {
        return sInstance;
    }

    private PresentationSession createNewSession(RenderFrameHostId id) {
        PresentationSession session = new PresentationSession(this.mApplicationContext, id.renderProcessID, id.renderFrameID);
        if ($assertionsDisabled || this.mExistingSessions.get(id) == null) {
            this.mExistingSessions.put(id, session);
            return session;
        }
        throw new AssertionError();
    }

    private void removeContextActivity(int renderProcessID, int renderFrameID) {
        RenderFrameHostId id = new RenderFrameHostId(renderProcessID, renderFrameID);
        this.mExistingSessions.remove(id);
    }

    private boolean startNewSession(PresentationSession session, int displayId, String url) {
        Display[] displayArr;
        if (session != null) {
            Display[] presentationDisplays = new Display[0];
            if (Build.VERSION.SDK_INT >= 17) {
                presentationDisplays = this.mDisplayManager.getDisplays("android.hardware.display.category.PRESENTATION");
            }
            if (presentationDisplays.length > 0) {
                Display display = null;
                for (Display query : presentationDisplays) {
                    if (query.getDisplayId() == displayId) {
                        display = query;
                    }
                }
                if (display != null && Build.VERSION.SDK_INT >= 17) {
                    session.presentationScreen = new PresentationScreen(session, display);
                    session.presentationScreen.getWindow().setType(2003);
                    session.presentationScreen.show();
                    session.presentationScreen.loadUrl(url);
                    return true;
                }
                Log.e(TAG, "Can't find specified display with id " + displayId);
            }
        }
        Log.e(TAG, "startNewSession falied!");
        return false;
    }

    private void closeSession(int renderProcessID, int renderFrameID) {
        RenderFrameHostId id = new RenderFrameHostId(renderProcessID, renderFrameID);
        PresentationSession session = this.mExistingSessions.get(id);
        if (session != null && Build.VERSION.SDK_INT >= 17) {
            if (session.presentationScreen != null) {
                session.presentationScreen.dismiss();
                session.presentationScreen = null;
                nativeOnPresentationClosed(this.mNativePresentationHost, renderProcessID, renderFrameID);
            }
            removeContextActivity(renderProcessID, renderFrameID);
        }
    }

    private XWalkPresentationHost(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.mDisplayManager = XWalkDisplayManager.getInstance(this.mApplicationContext);
        setNativeObject(nativeInit());
        listenToSystemDisplayChange();
    }

    public void listenToSystemDisplayChange() {
        this.mDisplayManager.registerDisplayListener(this);
    }

    public void stopListenToSystemDisplayChange() {
        this.mDisplayManager.unregisterDisplayListener(this);
    }

    @CalledByNative
    public Display[] getAndroidDisplayInfo() {
        Display[] emptyDisplay = new Display[0];
        if (Build.VERSION.SDK_INT >= 17) {
            return this.mDisplayManager.getDisplays();
        }
        return emptyDisplay;
    }

    @CalledByNative
    public boolean showPresentation(int renderProcessID, int renderFrameID, int displayId, String url) {
        RenderFrameHostId id = new RenderFrameHostId(renderProcessID, renderFrameID);
        PresentationSession session = this.mExistingSessions.get(id);
        if (session == null) {
            session = createNewSession(id);
        }
        return startNewSession(session, displayId, url);
    }

    @CalledByNative
    public void closePresentation(int renderProcessID, int renderFrameID) {
        closeSession(renderProcessID, renderFrameID);
    }

    public static void onPresentationScreenClose(PresentationSession attachedSession) {
        RenderFrameHostId id = new RenderFrameHostId(attachedSession.renderProcessID, attachedSession.renderFrameID);
        PresentationSession querySession = getInstance().mExistingSessions.get(id);
        if (querySession != null && Build.VERSION.SDK_INT >= 17) {
            if (querySession.presentationScreen != null) {
                querySession.presentationScreen = null;
            }
            int renderProcessID = querySession.renderProcessID;
            int renderFrameID = querySession.renderFrameID;
            getInstance().nativeOnPresentationClosed(getInstance().mNativePresentationHost, renderProcessID, renderFrameID);
            getInstance().removeContextActivity(renderProcessID, renderFrameID);
        }
    }

    private void setNativeObject(long newNativePresentationAPI) {
        if (!$assertionsDisabled && this.mNativePresentationHost != 0) {
            throw new AssertionError();
        }
        this.mNativePresentationHost = newNativePresentationAPI;
        nativeSetupJavaPeer(this.mNativePresentationHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(17)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkPresentationHost$PresentationScreen.class */
    public final class PresentationScreen extends Presentation {
        private XWalkView mContentView;
        private PresentationSession mSession;
        private Display mDisplay;

        public PresentationScreen(PresentationSession session, Display display) {
            super(session.context, display);
            this.mSession = session;
            this.mDisplay = display;
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (this.mContentView == null) {
                this.mContentView = new XWalkView(getContext());
                this.mContentView.setUIClient(new XWalkUIClient(this.mContentView));
            }
            setContentView(this.mContentView);
        }

        @Override // android.app.Presentation, android.app.Dialog
        protected void onStop() {
            super.onStop();
            XWalkPresentationHost.onPresentationScreenClose(this.mSession);
        }

        public void loadUrl(String url) {
            this.mContentView.loadUrl(url);
        }
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager.DisplayListener
    public void onDisplayAdded(int displayId) {
        nativeOnDisplayAdded(this.mNativePresentationHost, displayId);
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager.DisplayListener
    public void onDisplayChanged(int displayId) {
        nativeOnDisplayChanged(this.mNativePresentationHost, displayId);
    }

    @Override // com.pakdata.xwalk.refactor.extension.api.XWalkDisplayManager.DisplayListener
    public void onDisplayRemoved(int displayId) {
        nativeOnDisplayRemoved(this.mNativePresentationHost, displayId);
    }
}
