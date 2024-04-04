package org.chromium.ui.modelutil;

import androidx.annotation.Nullable;
import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.ui.modelutil.ListObservable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/ListObservableImpl.class */
public abstract class ListObservableImpl<P> implements ListObservable<P> {
    private final ObserverList<ListObservable.ListObserver<P>> mObservers = new ObserverList<>();
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ListObservableImpl.class.desiredAssertionStatus();
    }

    @Override // org.chromium.ui.modelutil.ListObservable
    public void addObserver(ListObservable.ListObserver<P> observer) {
        boolean success = this.mObservers.addObserver(observer);
        if (!$assertionsDisabled && !success) {
            throw new AssertionError();
        }
    }

    @Override // org.chromium.ui.modelutil.ListObservable
    public void removeObserver(ListObservable.ListObserver<P> observer) {
        boolean success = this.mObservers.removeObserver(observer);
        if (!$assertionsDisabled && !success) {
            throw new AssertionError();
        }
    }

    protected final void notifyItemChanged(int index) {
        notifyItemRangeChanged(index, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyItemRangeChanged(int index, int count) {
        notifyItemRangeChanged(index, count, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyItemChanged(int index, @Nullable P payload) {
        notifyItemRangeChanged(index, 1, payload);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyItemInserted(int index) {
        notifyItemRangeInserted(index, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyItemRemoved(int index) {
        notifyItemRangeRemoved(index, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyItemRangeInserted(int index, int count) {
        if (!$assertionsDisabled && count <= 0) {
            throw new AssertionError();
        }
        Iterator<ListObservable.ListObserver<P>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            ListObservable.ListObserver observer = it.next();
            observer.onItemRangeInserted(this, index, count);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyItemRangeRemoved(int index, int count) {
        if (!$assertionsDisabled && count <= 0) {
            throw new AssertionError();
        }
        Iterator<ListObservable.ListObserver<P>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            ListObservable.ListObserver observer = it.next();
            observer.onItemRangeRemoved(this, index, count);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyItemRangeChanged(int index, int count, @Nullable P payload) {
        if (!$assertionsDisabled && count <= 0) {
            throw new AssertionError();
        }
        Iterator<ListObservable.ListObserver<P>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            ListObservable.ListObserver<P> observer = it.next();
            observer.onItemRangeChanged(this, index, count, payload);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyItemMoved(int curIndex, int newIndex) {
        Iterator<ListObservable.ListObserver<P>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            ListObservable.ListObserver observer = it.next();
            observer.onItemMoved(this, curIndex, newIndex);
        }
    }
}
