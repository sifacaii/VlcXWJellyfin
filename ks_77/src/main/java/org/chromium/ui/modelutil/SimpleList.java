package org.chromium.ui.modelutil;

import androidx.annotation.NonNull;
import java.util.Iterator;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modelutil/SimpleList.class */
public interface SimpleList<T> extends Iterable<T> {
    int size();

    T get(int i);

    @Override // java.lang.Iterable
    @NonNull
    default Iterator<T> iterator() {
        return new Iterator<T>() { // from class: org.chromium.ui.modelutil.SimpleList.1
            private int mI;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.mI < SimpleList.this.size();
            }

            @Override // java.util.Iterator
            public T next() {
                SimpleList simpleList = SimpleList.this;
                int i = this.mI;
                this.mI = i + 1;
                return (T) simpleList.get(i);
            }
        };
    }
}
