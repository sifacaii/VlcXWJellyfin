package org.chromium.ui.resources.dynamics;

import android.util.SparseArray;
import org.chromium.ui.resources.ResourceLoader;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/dynamics/DynamicResourceLoader.class */
public class DynamicResourceLoader extends ResourceLoader {
    private final SparseArray<DynamicResource> mDynamicResources;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !DynamicResourceLoader.class.desiredAssertionStatus();
    }

    public DynamicResourceLoader(int resourceType, ResourceLoader.ResourceLoaderCallback callback) {
        super(resourceType, callback);
        this.mDynamicResources = new SparseArray<>();
    }

    public void registerResource(int resId, DynamicResource resource) {
        if (!$assertionsDisabled && this.mDynamicResources.get(resId) != null) {
            throw new AssertionError();
        }
        this.mDynamicResources.put(resId, resource);
    }

    public void unregisterResource(int resId) {
        this.mDynamicResources.remove(resId);
        notifyResourceUnregistered(resId);
    }

    @Override // org.chromium.ui.resources.ResourceLoader
    public void loadResource(int resId) {
        DynamicResource resource = this.mDynamicResources.get(resId);
        if (resource != null && resource.isDirty()) {
            notifyLoadFinished(resId, resource);
        }
    }

    @Override // org.chromium.ui.resources.ResourceLoader
    public void preloadResource(int resId) {
        if (!$assertionsDisabled) {
            throw new AssertionError("Preloading dynamic resources isn't supported.");
        }
    }
}
