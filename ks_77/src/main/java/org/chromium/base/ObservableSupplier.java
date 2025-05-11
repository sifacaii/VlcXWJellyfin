package org.chromium.base;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/ObservableSupplier.class */
public interface ObservableSupplier<E> extends Supplier<E> {
    E addObserver(Callback<E> callback);

    void removeObserver(Callback<E> callback);
}
