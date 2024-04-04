package org.chromium.ui.resources;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.SparseArray;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;
import org.chromium.ui.resources.ResourceLoader;
import org.chromium.ui.resources.dynamics.DynamicResourceLoader;
import org.chromium.ui.resources.statics.StaticResourceLoader;
import org.chromium.ui.resources.system.SystemResourceLoader;

@JNINamespace("ui")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/ResourceManager.class */
public class ResourceManager implements ResourceLoader.ResourceLoaderCallback {
    private final SparseArray<ResourceLoader> mResourceLoaders = new SparseArray<>();
    private final SparseArray<SparseArray<LayoutResource>> mLoadedResources = new SparseArray<>();
    private final float mPxToDp;
    private long mNativeResourceManagerPtr;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeOnResourceReady(long j, int i, int i2, Bitmap bitmap, int i3, int i4, long j2);

    private native void nativeRemoveResource(long j, int i, int i2);

    private native void nativeClearTintedResourceCache(long j);

    static {
        $assertionsDisabled = !ResourceManager.class.desiredAssertionStatus();
    }

    private ResourceManager(Resources resources, int minScreenSideLength, long staticResourceManagerPtr) {
        this.mPxToDp = 1.0f / resources.getDisplayMetrics().density;
        registerResourceLoader(new StaticResourceLoader(0, this, resources));
        registerResourceLoader(new DynamicResourceLoader(1, this));
        registerResourceLoader(new DynamicResourceLoader(2, this));
        registerResourceLoader(new SystemResourceLoader(3, this, minScreenSideLength));
        this.mNativeResourceManagerPtr = staticResourceManagerPtr;
    }

    @CalledByNative
    private static ResourceManager create(WindowAndroid windowAndroid, long staticResourceManagerPtr) {
        Context context = windowAndroid.getContext().get();
        if (context == null) {
            throw new IllegalStateException("Context should not be null during initialization.");
        }
        DisplayAndroid displayAndroid = windowAndroid.getDisplay();
        int minScreenSideLength = Math.min(displayAndroid.getDisplayWidth(), displayAndroid.getDisplayHeight());
        Resources resources = context.getResources();
        return new ResourceManager(resources, minScreenSideLength, staticResourceManagerPtr);
    }

    public DynamicResourceLoader getDynamicResourceLoader() {
        return (DynamicResourceLoader) this.mResourceLoaders.get(1);
    }

    public DynamicResourceLoader getBitmapDynamicResourceLoader() {
        return (DynamicResourceLoader) this.mResourceLoaders.get(2);
    }

    public void preloadResources(int type, int[] syncIds, int[] asyncIds) {
        ResourceLoader loader = this.mResourceLoaders.get(type);
        if (asyncIds != null) {
            for (int i : asyncIds) {
                Integer resId = Integer.valueOf(i);
                loader.preloadResource(resId.intValue());
            }
        }
        if (syncIds != null) {
            for (int i2 : syncIds) {
                Integer resId2 = Integer.valueOf(i2);
                loader.loadResource(resId2.intValue());
            }
        }
    }

    public LayoutResource getResource(int resType, int resId) {
        SparseArray<LayoutResource> bucket = this.mLoadedResources.get(resType);
        if (bucket != null) {
            return bucket.get(resId);
        }
        return null;
    }

    @Override // org.chromium.ui.resources.ResourceLoader.ResourceLoaderCallback
    public void onResourceLoaded(int resType, int resId, Resource resource) {
        Bitmap bitmap;
        if (resource == null || (bitmap = resource.getBitmap()) == null) {
            return;
        }
        saveMetadataForLoadedResource(resType, resId, resource);
        if (this.mNativeResourceManagerPtr == 0) {
            return;
        }
        nativeOnResourceReady(this.mNativeResourceManagerPtr, resType, resId, bitmap, resource.getBitmapSize().width(), resource.getBitmapSize().height(), resource.createNativeResource());
    }

    @Override // org.chromium.ui.resources.ResourceLoader.ResourceLoaderCallback
    public void onResourceUnregistered(int resType, int resId) {
        if ((resType == 2 || resType == 1) && this.mNativeResourceManagerPtr != 0) {
            nativeRemoveResource(this.mNativeResourceManagerPtr, resType, resId);
        }
    }

    public void clearTintedResourceCache() {
        if (this.mNativeResourceManagerPtr == 0) {
            return;
        }
        nativeClearTintedResourceCache(this.mNativeResourceManagerPtr);
    }

    private void saveMetadataForLoadedResource(int resType, int resId, Resource resource) {
        SparseArray<LayoutResource> bucket = this.mLoadedResources.get(resType);
        if (bucket == null) {
            bucket = new SparseArray<>();
            this.mLoadedResources.put(resType, bucket);
        }
        bucket.put(resId, new LayoutResource(this.mPxToDp, resource));
    }

    @CalledByNative
    private void destroy() {
        if (!$assertionsDisabled && this.mNativeResourceManagerPtr == 0) {
            throw new AssertionError();
        }
        this.mNativeResourceManagerPtr = 0L;
    }

    @CalledByNative
    private void resourceRequested(int resType, int resId) {
        ResourceLoader loader = this.mResourceLoaders.get(resType);
        if (loader != null) {
            loader.loadResource(resId);
        }
    }

    @CalledByNative
    private void preloadResource(int resType, int resId) {
        ResourceLoader loader = this.mResourceLoaders.get(resType);
        if (loader != null) {
            loader.preloadResource(resId);
        }
    }

    @CalledByNative
    private long getNativePtr() {
        return this.mNativeResourceManagerPtr;
    }

    private void registerResourceLoader(ResourceLoader loader) {
        this.mResourceLoaders.put(loader.getResourceType(), loader);
    }
}
