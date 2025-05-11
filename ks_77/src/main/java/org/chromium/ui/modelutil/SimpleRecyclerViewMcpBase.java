package org.chromium.ui.modelutil;

import androidx.annotation.Nullable;
import org.chromium.ui.modelutil.RecyclerViewAdapter;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/SimpleRecyclerViewMcpBase.class */
public class SimpleRecyclerViewMcpBase<T, VH, P> extends ForwardingListObservable<P> implements RecyclerViewAdapter.Delegate<VH, P> {
    private final SimpleList<T> mModel;
    private final ItemViewTypeCallback<T> mItemViewTypeCallback;
    private final ViewBinder<T, VH, P> mViewBinder;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/SimpleRecyclerViewMcpBase$ItemViewTypeCallback.class */
    public interface ItemViewTypeCallback<T> {
        int getItemViewType(T t);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/SimpleRecyclerViewMcpBase$ViewBinder.class */
    public interface ViewBinder<T, VH, P> {
        void onBindViewHolder(VH vh, T t, @Nullable P p);
    }

    public SimpleRecyclerViewMcpBase(@Nullable ItemViewTypeCallback<T> itemViewTypeCallback, ViewBinder<T, VH, P> viewBinder, ListModelBase<T, P> model) {
        this.mItemViewTypeCallback = itemViewTypeCallback;
        this.mViewBinder = viewBinder;
        this.mModel = model;
        model.addObserver(this);
    }

    @Override // org.chromium.ui.modelutil.RecyclerViewAdapter.Delegate
    public int getItemCount() {
        return this.mModel.size();
    }

    @Override // org.chromium.ui.modelutil.RecyclerViewAdapter.Delegate
    public int getItemViewType(int position) {
        if (this.mItemViewTypeCallback == null) {
            return 0;
        }
        return this.mItemViewTypeCallback.getItemViewType(this.mModel.get(position));
    }

    @Override // org.chromium.ui.modelutil.RecyclerViewAdapter.Delegate
    public void onBindViewHolder(VH holder, int position, @Nullable P payload) {
        this.mViewBinder.onBindViewHolder(holder, this.mModel.get(position), payload);
    }
}
