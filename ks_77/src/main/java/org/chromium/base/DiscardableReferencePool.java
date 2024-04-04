package org.chromium.base;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/DiscardableReferencePool.class */
public class DiscardableReferencePool {
    private final Set<DiscardableReference<?>> mPool;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !DiscardableReferencePool.class.desiredAssertionStatus();
    }

    public DiscardableReferencePool() {
        WeakHashMap<DiscardableReference<?>, Boolean> map = new WeakHashMap<>();
        this.mPool = Collections.newSetFromMap(map);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/DiscardableReferencePool$DiscardableReference.class */
    public static class DiscardableReference<T> {
        @Nullable
        private T mPayload;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !DiscardableReferencePool.class.desiredAssertionStatus();
        }

        private DiscardableReference(T payload) {
            if (!$assertionsDisabled && payload == null) {
                throw new AssertionError();
            }
            this.mPayload = payload;
        }

        @Nullable
        public T get() {
            return this.mPayload;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void discard() {
            if (!$assertionsDisabled && this.mPayload == null) {
                throw new AssertionError();
            }
            this.mPayload = null;
        }
    }

    public <T> DiscardableReference<T> put(T payload) {
        if ($assertionsDisabled || payload != null) {
            DiscardableReference<T> reference = new DiscardableReference<>(payload);
            this.mPool.add(reference);
            return reference;
        }
        throw new AssertionError();
    }

    public void remove(DiscardableReference<?> ref) {
        if (!$assertionsDisabled && ref == null) {
            throw new AssertionError();
        }
        if (this.mPool.contains(ref)) {
            if (!$assertionsDisabled && ref.get() == null) {
                throw new AssertionError();
            }
            ref.discard();
            this.mPool.remove(ref);
        }
    }

    public void drain() {
        for (DiscardableReference<?> ref : this.mPool) {
            ref.discard();
        }
        this.mPool.clear();
    }
}
