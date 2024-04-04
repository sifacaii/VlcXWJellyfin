package org.chromium.ui.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("ui")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/display/DisplayAndroidManager.class */
public class DisplayAndroidManager {
    private static DisplayAndroidManager sDisplayAndroidManager;
    private static final int VIRTUAL_DISPLAY_ID_BEGIN = 1073741823;
    private long mNativePointer;
    private int mMainSdkDisplayId;
    private final SparseArray<DisplayAndroid> mIdMap = new SparseArray<>();
    private DisplayListenerBackend mBackend = new DisplayListenerBackend();
    private int mNextVirtualDisplayId = VIRTUAL_DISPLAY_ID_BEGIN;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeUpdateDisplay(long j, int i, int i2, int i3, float f, int i4, int i5, int i6, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeRemoveDisplay(long j, int i);

    private native void nativeSetPrimaryDisplayId(long j, int i);

    static {
        $assertionsDisabled = !DisplayAndroidManager.class.desiredAssertionStatus();
    }

    static /* synthetic */ DisplayManager access$000() {
        return getDisplayManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/display/DisplayAndroidManager$DisplayListenerBackend.class */
    public class DisplayListenerBackend implements DisplayManager.DisplayListener {
        private DisplayListenerBackend() {
        }

        public void startListening() {
            DisplayAndroidManager.access$000().registerDisplayListener(this, null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int sdkDisplayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int sdkDisplayId) {
            if (sdkDisplayId == DisplayAndroidManager.this.mMainSdkDisplayId) {
                return;
            }
            DisplayAndroid displayAndroid = (DisplayAndroid) DisplayAndroidManager.this.mIdMap.get(sdkDisplayId);
            if (displayAndroid == null) {
                return;
            }
            if (DisplayAndroidManager.this.mNativePointer != 0) {
                DisplayAndroidManager.this.nativeRemoveDisplay(DisplayAndroidManager.this.mNativePointer, sdkDisplayId);
            }
            DisplayAndroidManager.this.mIdMap.remove(sdkDisplayId);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int sdkDisplayId) {
            PhysicalDisplayAndroid displayAndroid = (PhysicalDisplayAndroid) DisplayAndroidManager.this.mIdMap.get(sdkDisplayId);
            Display display = DisplayAndroidManager.access$000().getDisplay(sdkDisplayId);
            if (displayAndroid != null && display != null) {
                displayAndroid.updateFromDisplay(display);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayAndroidManager getInstance() {
        ThreadUtils.assertOnUiThread();
        if (sDisplayAndroidManager == null) {
            sDisplayAndroidManager = new DisplayAndroidManager();
            sDisplayAndroidManager.initialize();
        }
        return sDisplayAndroidManager;
    }

    public static Display getDefaultDisplayForContext(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        return windowManager.getDefaultDisplay();
    }

    private static Context getContext() {
        return ContextUtils.getApplicationContext();
    }

    @SuppressLint({"NewApi"})
    private static DisplayManager getDisplayManager() {
        return (DisplayManager) getContext().getSystemService("display");
    }

    @CalledByNative
    private static void onNativeSideCreated(long nativePointer) {
        DisplayAndroidManager singleton = getInstance();
        singleton.setNativePointer(nativePointer);
    }

    private DisplayAndroidManager() {
    }

    private void initialize() {
        Display display = getDisplayManager().getDisplay(0);
        if (display == null) {
            display = getDefaultDisplayForContext(getContext());
        }
        this.mMainSdkDisplayId = display.getDisplayId();
        addDisplay(display);
        this.mBackend.startListening();
    }

    private void setNativePointer(long nativePointer) {
        this.mNativePointer = nativePointer;
        nativeSetPrimaryDisplayId(this.mNativePointer, this.mMainSdkDisplayId);
        for (int i = 0; i < this.mIdMap.size(); i++) {
            updateDisplayOnNativeSide(this.mIdMap.valueAt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisplayAndroid getDisplayAndroid(Display display) {
        int sdkDisplayId = display.getDisplayId();
        DisplayAndroid displayAndroid = this.mIdMap.get(sdkDisplayId);
        if (displayAndroid == null) {
            displayAndroid = addDisplay(display);
        }
        return displayAndroid;
    }

    private DisplayAndroid addDisplay(Display display) {
        int sdkDisplayId = display.getDisplayId();
        PhysicalDisplayAndroid displayAndroid = new PhysicalDisplayAndroid(display);
        if ($assertionsDisabled || this.mIdMap.get(sdkDisplayId) == null) {
            this.mIdMap.put(sdkDisplayId, displayAndroid);
            displayAndroid.updateFromDisplay(display);
            return displayAndroid;
        }
        throw new AssertionError();
    }

    private int getNextVirtualDisplayId() {
        int i = this.mNextVirtualDisplayId;
        this.mNextVirtualDisplayId = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VirtualDisplayAndroid addVirtualDisplay() {
        VirtualDisplayAndroid display = new VirtualDisplayAndroid(getNextVirtualDisplayId());
        if ($assertionsDisabled || this.mIdMap.get(display.getDisplayId()) == null) {
            this.mIdMap.put(display.getDisplayId(), display);
            updateDisplayOnNativeSide(display);
            return display;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeVirtualDisplay(VirtualDisplayAndroid display) {
        DisplayAndroid displayAndroid = this.mIdMap.get(display.getDisplayId());
        if (!$assertionsDisabled && displayAndroid != display) {
            throw new AssertionError();
        }
        if (this.mNativePointer != 0) {
            nativeRemoveDisplay(this.mNativePointer, display.getDisplayId());
        }
        this.mIdMap.remove(display.getDisplayId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateDisplayOnNativeSide(DisplayAndroid displayAndroid) {
        if (this.mNativePointer == 0) {
            return;
        }
        nativeUpdateDisplay(this.mNativePointer, displayAndroid.getDisplayId(), displayAndroid.getDisplayWidth(), displayAndroid.getDisplayHeight(), displayAndroid.getDipScale(), displayAndroid.getRotationDegrees(), displayAndroid.getBitsPerPixel(), displayAndroid.getBitsPerComponent(), displayAndroid.getIsWideColorGamut());
    }
}
