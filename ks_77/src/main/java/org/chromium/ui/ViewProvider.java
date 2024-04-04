package org.chromium.ui;

import org.chromium.base.Callback;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/ViewProvider.class */
public interface ViewProvider<T> {
    void inflate();

    void whenLoaded(Callback<T> callback);
}
