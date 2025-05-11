package org.chromium.ui.modelutil;

import androidx.annotation.Nullable;
import org.chromium.ui.modelutil.ListObservable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/ForwardingListObservable.class */
public class ForwardingListObservable<P> extends ListObservableImpl<P> implements ListObservable.ListObserver<P> {
    @Override // org.chromium.ui.modelutil.ListObservable.ListObserver
    public void onItemRangeInserted(ListObservable source, int index, int count) {
        notifyItemRangeInserted(index, count);
    }

    @Override // org.chromium.ui.modelutil.ListObservable.ListObserver
    public void onItemRangeRemoved(ListObservable source, int index, int count) {
        notifyItemRangeRemoved(index, count);
    }

    @Override // org.chromium.ui.modelutil.ListObservable.ListObserver
    public void onItemRangeChanged(ListObservable<P> source, int index, int count, @Nullable P payload) {
        notifyItemRangeChanged(index, count, payload);
    }

    @Override // org.chromium.ui.modelutil.ListObservable.ListObserver
    public void onItemMoved(ListObservable source, int fromIndex, int toIndex) {
        notifyItemMoved(fromIndex, toIndex);
    }
}
