package com.pakdata.xwalk.refactor;

import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkContentLifecycleNotifier.class */
public class XWalkContentLifecycleNotifier {
    private static final ObserverList<Observer> sLifecycleObservers;
    private static int sNumXWalkViews;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkContentLifecycleNotifier$Observer.class */
    public interface Observer {
        void onFirstXWalkViewCreated();

        void onLastXWalkViewDestroyed();
    }

    static {
        $assertionsDisabled = !XWalkContentLifecycleNotifier.class.desiredAssertionStatus();
        sLifecycleObservers = new ObserverList<>();
    }

    private XWalkContentLifecycleNotifier() {
    }

    public static void addObserver(Observer observer) {
        sLifecycleObservers.addObserver(observer);
    }

    public static void removeObserver(Observer observer) {
        sLifecycleObservers.removeObserver(observer);
    }

    public static boolean hasXWalkViewInstances() {
        return sNumXWalkViews > 0;
    }

    @CalledByNative
    private static void onXWalkViewCreated() {
        ThreadUtils.assertOnUiThread();
        if (!$assertionsDisabled && sNumXWalkViews < 0) {
            throw new AssertionError();
        }
        sNumXWalkViews++;
        if (sNumXWalkViews == 1) {
            Iterator<Observer> it = sLifecycleObservers.iterator();
            while (it.hasNext()) {
                Observer observer = it.next();
                observer.onFirstXWalkViewCreated();
            }
        }
    }

    @CalledByNative
    private static void onXWalkViewDestroyed() {
        ThreadUtils.assertOnUiThread();
        if (!$assertionsDisabled && sNumXWalkViews <= 0) {
            throw new AssertionError();
        }
        sNumXWalkViews--;
        if (sNumXWalkViews == 0) {
            Iterator<Observer> it = sLifecycleObservers.iterator();
            while (it.hasNext()) {
                Observer observer = it.next();
                observer.onLastXWalkViewDestroyed();
            }
        }
    }
}
