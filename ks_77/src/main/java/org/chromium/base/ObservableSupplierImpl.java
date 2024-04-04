package org.chromium.base;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/ObservableSupplierImpl.class */
public class ObservableSupplierImpl<E> implements ObservableSupplier<E> {
    private E mObject;
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Thread mThread = Thread.currentThread();
    private final Handler mHandler = new Handler();
    private final ObserverList<Callback<E>> mObservers = new ObserverList<>();

    static {
        $assertionsDisabled = !ObservableSupplierImpl.class.desiredAssertionStatus();
    }

    @Override // org.chromium.base.ObservableSupplier
    public E addObserver(Callback<E> obs) {
        checkThread();
        this.mObservers.addObserver(obs);
        if (this.mObject != null) {
            E currentObject = this.mObject;
            this.mHandler.post(() -> {
                if (this.mObject == currentObject && this.mObservers.hasObserver(obs)) {
                    obs.onResult(this.mObject);
                }
            });
        }
        return this.mObject;
    }

    @Override // org.chromium.base.ObservableSupplier
    public void removeObserver(Callback<E> obs) {
        checkThread();
        this.mObservers.removeObserver(obs);
    }

    public void set(E object) {
        checkThread();
        if (object == this.mObject) {
            return;
        }
        this.mObject = object;
        Iterator<Callback<E>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            Callback<E> observer = it.next();
            observer.onResult(this.mObject);
        }
    }

    @Override // org.chromium.base.Supplier
    @Nullable
    public E get() {
        checkThread();
        return this.mObject;
    }

    private void checkThread() {
        if (!$assertionsDisabled && this.mThread != Thread.currentThread()) {
            throw new AssertionError("ObservableSupplierImpl must only be used on a single Thread.");
        }
    }
}
