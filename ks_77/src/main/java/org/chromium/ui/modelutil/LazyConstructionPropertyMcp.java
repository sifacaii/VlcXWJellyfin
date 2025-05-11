package org.chromium.ui.modelutil;

import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import org.chromium.ui.ViewProvider;
import org.chromium.ui.modelutil.PropertyModel;
import org.chromium.ui.modelutil.PropertyModelChangeProcessor;
import org.chromium.ui.modelutil.PropertyObservable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/LazyConstructionPropertyMcp.class */
public class LazyConstructionPropertyMcp<M extends PropertyObservable<P>, V, P> implements PropertyObservable.PropertyObserver<P> {
    private final M mModel;
    private final P mVisibilityProperty;
    private final VisibilityPredicate<M> mVisibilityPredicate;
    private final ViewProvider<V> mViewProvider;
    private final PropertyModelChangeProcessor.ViewBinder<M, V, P> mViewBinder;
    private boolean mPendingViewCreation;
    @Nullable
    private V mView;
    private final Set<P> mPendingProperties = new HashSet();
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/LazyConstructionPropertyMcp$VisibilityPredicate.class */
    public interface VisibilityPredicate<T> {
        boolean isVisible(T t);
    }

    static {
        $assertionsDisabled = !LazyConstructionPropertyMcp.class.desiredAssertionStatus();
    }

    public LazyConstructionPropertyMcp(M model, P visibilityProperty, VisibilityPredicate<M> visibilityPredicate, ViewProvider<V> viewProvider, PropertyModelChangeProcessor.ViewBinder<M, V, P> viewBinder) {
        if (!$assertionsDisabled && visibilityProperty == null) {
            throw new AssertionError();
        }
        this.mModel = model;
        this.mVisibilityProperty = visibilityProperty;
        this.mVisibilityPredicate = visibilityPredicate;
        this.mViewProvider = viewProvider;
        this.mViewBinder = viewBinder;
        this.mPendingProperties.addAll(this.mModel.getAllSetProperties());
        this.mViewProvider.whenLoaded(this::onViewCreated);
        if (!$assertionsDisabled && this.mVisibilityPredicate.isVisible(this.mModel)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !this.mPendingProperties.contains(this.mVisibilityProperty)) {
            throw new AssertionError();
        }
        this.mModel.addObserver(this);
    }

    public static <M extends PropertyModel, V> LazyConstructionPropertyMcp<M, V, PropertyKey> create(M model, PropertyModel.WritableBooleanPropertyKey visibilityProperty, ViewProvider<V> viewFactory, PropertyModelChangeProcessor.ViewBinder<M, V, PropertyKey> viewBinder) {
        return new LazyConstructionPropertyMcp<>(model, visibilityProperty, item -> {
            return item.get(visibilityProperty);
        }, viewFactory, viewBinder);
    }

    private void flushPendingUpdates() {
        boolean pendingVisibilityUpdate = false;
        for (P property : this.mPendingProperties) {
            if (property == this.mVisibilityProperty) {
                pendingVisibilityUpdate = true;
            } else {
                this.mViewBinder.bind(this.mModel, this.mView, property);
            }
        }
        if (pendingVisibilityUpdate) {
            this.mViewBinder.bind(this.mModel, this.mView, this.mVisibilityProperty);
        }
        this.mPendingProperties.clear();
    }

    @Override // org.chromium.ui.modelutil.PropertyObservable.PropertyObserver
    public void onPropertyChanged(PropertyObservable<P> source, @Nullable P propertyKey) {
        if (!$assertionsDisabled && source != this.mModel) {
            throw new AssertionError();
        }
        this.mPendingProperties.add(propertyKey);
        if (!this.mVisibilityPredicate.isVisible(this.mModel) && propertyKey != this.mVisibilityProperty) {
            return;
        }
        if (this.mView == null) {
            if (this.mPendingViewCreation) {
                return;
            }
            this.mPendingViewCreation = true;
            this.mViewProvider.inflate();
            return;
        }
        flushPendingUpdates();
    }

    private void onViewCreated(V v) {
        this.mView = v;
        this.mPendingViewCreation = false;
        flushPendingUpdates();
    }
}
