package org.chromium.ui.resources;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/ResourceLoader.class */
public abstract class ResourceLoader {
    private final int mResourceType;
    private final ResourceLoaderCallback mCallback;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/ResourceLoader$ResourceLoaderCallback.class */
    public interface ResourceLoaderCallback {
        void onResourceLoaded(int i, int i2, Resource resource);

        void onResourceUnregistered(int i, int i2);
    }

    public abstract void loadResource(int i);

    public abstract void preloadResource(int i);

    public ResourceLoader(int resourceType, ResourceLoaderCallback callback) {
        this.mResourceType = resourceType;
        this.mCallback = callback;
    }

    public int getResourceType() {
        return this.mResourceType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyLoadFinished(int resId, Resource resource) {
        if (this.mCallback != null) {
            this.mCallback.onResourceLoaded(getResourceType(), resId, resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyResourceUnregistered(int resId) {
        if (this.mCallback != null) {
            this.mCallback.onResourceUnregistered(getResourceType(), resId);
        }
    }
}
