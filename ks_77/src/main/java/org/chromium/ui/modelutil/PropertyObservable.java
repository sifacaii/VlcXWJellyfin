package org.chromium.ui.modelutil;

import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import org.chromium.base.ObserverList;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/PropertyObservable.class */
public abstract class PropertyObservable<T> {
    private final ObserverList<PropertyObserver<T>> mObservers = new ObserverList<>();

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/PropertyObservable$PropertyObserver.class */
    public interface PropertyObserver<T> {
        void onPropertyChanged(PropertyObservable<T> propertyObservable, @Nullable T t);
    }

    public abstract Collection<T> getAllSetProperties();

    public abstract Collection<T> getAllProperties();

    public void addObserver(PropertyObserver<T> observer) {
        this.mObservers.addObserver(observer);
    }

    public void removeObserver(PropertyObserver<T> observer) {
        this.mObservers.removeObserver(observer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyPropertyChanged(T propertyKey) {
        Iterator<PropertyObserver<T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            PropertyObserver<T> observer = it.next();
            observer.onPropertyChanged(this, propertyKey);
        }
    }
}
