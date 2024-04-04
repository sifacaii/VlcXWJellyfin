package org.chromium.content.browser;

import android.util.Pair;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.chromium.base.UserData;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.JavascriptInjector;
import org.chromium.content_public.browser.WebContents;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/JavascriptInjectorImpl.class */
public class JavascriptInjectorImpl implements JavascriptInjector, UserData {
    private final Set<Object> mRetainedObjects = new HashSet();
    private final Map<String, Pair<Object, Class>> mInjectedObjects = new HashMap();
    private long mNativePtr;

    private native long nativeInit(WebContents webContents, Object obj);

    private native void nativeSetAllowInspection(long j, boolean z);

    private native void nativeAddInterface(long j, Object obj, String str, Class cls);

    private native void nativeRemoveInterface(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/JavascriptInjectorImpl$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<JavascriptInjectorImpl> INSTANCE = JavascriptInjectorImpl::new;

        private UserDataFactoryLazyHolder() {
        }
    }

    public static JavascriptInjector fromWebContents(WebContents webContents) {
        return (JavascriptInjector) ((WebContentsImpl) webContents).getOrSetUserData(JavascriptInjectorImpl.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    public JavascriptInjectorImpl(WebContents webContents) {
        this.mNativePtr = nativeInit(webContents, this.mRetainedObjects);
    }

    @CalledByNative
    private void onDestroy() {
        this.mNativePtr = 0L;
    }

    @Override // org.chromium.content_public.browser.JavascriptInjector
    public Map<String, Pair<Object, Class>> getInterfaces() {
        return this.mInjectedObjects;
    }

    @Override // org.chromium.content_public.browser.JavascriptInjector
    public void setAllowInspection(boolean allow) {
        if (this.mNativePtr != 0) {
            nativeSetAllowInspection(this.mNativePtr, allow);
        }
    }

    @Override // org.chromium.content_public.browser.JavascriptInjector
    public void addPossiblyUnsafeInterface(Object object, String name, Class<? extends Annotation> requiredAnnotation) {
        if (this.mNativePtr != 0 && object != null) {
            this.mInjectedObjects.put(name, new Pair<>(object, requiredAnnotation));
            nativeAddInterface(this.mNativePtr, object, name, requiredAnnotation);
        }
    }

    @Override // org.chromium.content_public.browser.JavascriptInjector
    public void removeInterface(String name) {
        this.mInjectedObjects.remove(name);
        if (this.mNativePtr != 0) {
            nativeRemoveInterface(this.mNativePtr, name);
        }
    }
}
