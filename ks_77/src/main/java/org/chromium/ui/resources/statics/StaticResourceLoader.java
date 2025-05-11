package org.chromium.ui.resources.statics;

import android.content.res.Resources;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.ResourceLoader;
import org.chromium.ui.resources.async.AsyncPreloadResourceLoader;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/statics/StaticResourceLoader.class */
public class StaticResourceLoader extends AsyncPreloadResourceLoader {
    public StaticResourceLoader(int resourceType, ResourceLoader.ResourceLoaderCallback callback, final Resources resources) {
        super(resourceType, callback, new AsyncPreloadResourceLoader.ResourceCreator() { // from class: org.chromium.ui.resources.statics.StaticResourceLoader.1
            @Override // org.chromium.ui.resources.async.AsyncPreloadResourceLoader.ResourceCreator
            public Resource create(int resId) {
                return StaticResource.create(resources, resId, 0, 0);
            }
        });
    }
}
