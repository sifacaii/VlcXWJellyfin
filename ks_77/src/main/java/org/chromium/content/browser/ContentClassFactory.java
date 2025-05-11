package org.chromium.content.browser;

import android.os.Build;
import org.chromium.base.ThreadUtils;
import org.chromium.content.browser.selection.AdditionalMenuItemProvider;
import org.chromium.content.browser.selection.AdditionalMenuItemProviderImpl;
import org.chromium.content.browser.selection.MagnifierAnimator;
import org.chromium.content.browser.selection.MagnifierWrapperImpl;
import org.chromium.content.browser.selection.SelectionInsertionHandleObserver;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ContentClassFactory.class */
public class ContentClassFactory {
    private static ContentClassFactory sSingleton;

    public static void set(ContentClassFactory factory) {
        ThreadUtils.assertOnUiThread();
        sSingleton = factory;
    }

    public static ContentClassFactory get() {
        ThreadUtils.assertOnUiThread();
        if (sSingleton == null) {
            sSingleton = new ContentClassFactory();
        }
        return sSingleton;
    }

    protected ContentClassFactory() {
    }

    public SelectionInsertionHandleObserver createHandleObserver(SelectionPopupControllerImpl.ReadbackViewCallback callback) {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        return new MagnifierAnimator(new MagnifierWrapperImpl(callback));
    }

    public AdditionalMenuItemProvider createAddtionalMenuItemProvider() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        return new AdditionalMenuItemProviderImpl();
    }
}
