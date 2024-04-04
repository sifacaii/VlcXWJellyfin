package org.chromium.ui.resources.async;

import android.util.SparseArray;
import java.util.concurrent.ExecutionException;
import org.chromium.base.TraceEvent;
import org.chromium.base.task.AsyncTask;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.ResourceLoader;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/async/AsyncPreloadResourceLoader.class */
public class AsyncPreloadResourceLoader extends ResourceLoader {
    private final SparseArray<AsyncLoadTask> mOutstandingLoads;
    private final ResourceCreator mCreator;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/async/AsyncPreloadResourceLoader$ResourceCreator.class */
    public interface ResourceCreator {
        Resource create(int i);
    }

    public AsyncPreloadResourceLoader(int resourceType, ResourceLoader.ResourceLoaderCallback callback, ResourceCreator creator) {
        super(resourceType, callback);
        this.mOutstandingLoads = new SparseArray<>();
        this.mCreator = creator;
    }

    @Override // org.chromium.ui.resources.ResourceLoader
    public void loadResource(int resId) {
        AsyncLoadTask task = this.mOutstandingLoads.get(resId);
        if (task != null && !task.cancel(false)) {
            try {
                registerResource(task.get(), resId);
                return;
            } catch (InterruptedException e) {
                notifyLoadFinished(resId, null);
                return;
            } catch (ExecutionException e2) {
                notifyLoadFinished(resId, null);
                return;
            }
        }
        registerResource(createResource(resId), resId);
    }

    @Override // org.chromium.ui.resources.ResourceLoader
    public void preloadResource(int resId) {
        if (this.mOutstandingLoads.get(resId) != null) {
            return;
        }
        AsyncLoadTask task = new AsyncLoadTask(resId);
        task.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
        this.mOutstandingLoads.put(resId, task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Resource createResource(int resId) {
        try {
            TraceEvent.begin("AsyncPreloadResourceLoader.createResource");
            Resource create = this.mCreator.create(resId);
            TraceEvent.end("AsyncPreloadResourceLoader.createResource");
            return create;
        } catch (Throwable th) {
            TraceEvent.end("AsyncPreloadResourceLoader.createResource");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerResource(Resource resource, int resourceId) {
        notifyLoadFinished(resourceId, resource);
        this.mOutstandingLoads.remove(resourceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/async/AsyncPreloadResourceLoader$AsyncLoadTask.class */
    public class AsyncLoadTask extends AsyncTask<Resource> {
        private final int mResourceId;

        public AsyncLoadTask(int resourceId) {
            this.mResourceId = resourceId;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.base.task.AsyncTask
        public Resource doInBackground() {
            return AsyncPreloadResourceLoader.this.createResource(this.mResourceId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.base.task.AsyncTask
        public void onPostExecute(Resource resource) {
            if (AsyncPreloadResourceLoader.this.mOutstandingLoads.get(this.mResourceId) == null) {
                return;
            }
            AsyncPreloadResourceLoader.this.registerResource(resource, this.mResourceId);
        }
    }
}
