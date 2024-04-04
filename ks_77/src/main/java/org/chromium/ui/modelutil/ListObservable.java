package org.chromium.ui.modelutil;

import androidx.annotation.Nullable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/ListObservable.class */
public interface ListObservable<P> {
    void addObserver(ListObserver<P> listObserver);

    void removeObserver(ListObserver<P> listObserver);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/ListObservable$ListObserver.class */
    public interface ListObserver<P> {
        default void onItemRangeInserted(ListObservable source, int index, int count) {
        }

        default void onItemRangeRemoved(ListObservable source, int index, int count) {
        }

        default void onItemRangeChanged(ListObservable<P> source, int index, int count, @Nullable P payload) {
        }

        default void onItemMoved(ListObservable source, int curIndex, int newIndex) {
        }
    }
}
