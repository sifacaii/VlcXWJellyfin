package org.chromium.ui.modelutil;

import androidx.annotation.Nullable;
import org.chromium.ui.modelutil.ListObservable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/ListModelChangeProcessor.class */
public class ListModelChangeProcessor<M extends ListObservable, V> implements ListObservable.ListObserver<Void> {
    private final V mView;
    private final M mModel;
    private final ViewBinder<M, V> mViewBinder;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/ListModelChangeProcessor$ViewBinder.class */
    public interface ViewBinder<M, V> {
        void onItemsInserted(M m, V v, int i, int i2);

        void onItemsRemoved(M m, V v, int i, int i2);

        void onItemsChanged(M m, V v, int i, int i2);
    }

    @Override // org.chromium.ui.modelutil.ListObservable.ListObserver
    public /* bridge */ /* synthetic */ void onItemRangeChanged(ListObservable<Void> listObservable, int i, int i2, @Nullable Void r10) {
        onItemRangeChanged2((ListObservable) listObservable, i, i2, r10);
    }

    static {
        $assertionsDisabled = !ListModelChangeProcessor.class.desiredAssertionStatus();
    }

    public ListModelChangeProcessor(M model, V view, ViewBinder<M, V> viewBinder) {
        this.mModel = model;
        this.mView = view;
        this.mViewBinder = viewBinder;
    }

    @Override // org.chromium.ui.modelutil.ListObservable.ListObserver
    public void onItemRangeInserted(ListObservable source, int index, int count) {
        if (!$assertionsDisabled && source != this.mModel) {
            throw new AssertionError();
        }
        this.mViewBinder.onItemsInserted(this.mModel, this.mView, index, count);
    }

    @Override // org.chromium.ui.modelutil.ListObservable.ListObserver
    public void onItemRangeRemoved(ListObservable source, int index, int count) {
        if (!$assertionsDisabled && source != this.mModel) {
            throw new AssertionError();
        }
        this.mViewBinder.onItemsRemoved(this.mModel, this.mView, index, count);
    }

    /* renamed from: onItemRangeChanged  reason: avoid collision after fix types in other method */
    public void onItemRangeChanged2(ListObservable source, int index, int count, @Nullable Void payload) {
        if (!$assertionsDisabled && source != this.mModel) {
            throw new AssertionError();
        }
        this.mViewBinder.onItemsChanged(this.mModel, this.mView, index, count);
    }
}
