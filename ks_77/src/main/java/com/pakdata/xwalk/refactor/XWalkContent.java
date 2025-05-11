// Copyright 2013 The Chromium Authors. All rights reserved.
// Copyright (c) 2013-2014 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.pakdata.xwalk.refactor;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
//import com.tenta.metafs.MetaError;
import com.pakdata.xwalk.refactor.XWalkContentsClient.XWalkWebResourceRequest;

import org.chromium.base.Callback;
import org.chromium.base.LocaleUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.UserDataHost;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.components.embedder_support.view.ContentViewRenderView;
import org.chromium.components.navigation_interception.InterceptNavigationDelegate;
import org.chromium.content_public.browser.ChildProcessImportance;
import org.chromium.content_public.browser.ContentViewStatics;
import org.chromium.content_public.browser.GestureListenerManager;
import org.chromium.content_public.browser.JavaScriptCallback;
import org.chromium.content_public.browser.JavascriptInjector;
import org.chromium.content_public.browser.LoadUrlParams;
import org.chromium.content_public.browser.NavigationController;
import org.chromium.content_public.browser.NavigationEntry;
import org.chromium.content_public.browser.NavigationHistory;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.content_public.browser.SelectionPopupController;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsInternals;
import org.chromium.content_public.browser.navigation_controller.UserAgentOverrideOption;
import org.chromium.content_public.common.UseZoomForDSFPolicy;
import org.chromium.ui.base.ActivityWindowAndroid;
import org.chromium.ui.base.PageTransition;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;
import org.json.JSONArray;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

//TODO(iotto): Check and use if needed
//import org.chromium.content.browser.ActivityContentVideoViewEmbedder;
//import org.chromium.components.embedder_support.media.ActivityContentVideoViewEmbedder;

@JNINamespace("xwalk")
/**
 * This class is the implementation class for XWalkView by calling internal various classes.
 */
class XWalkContent implements XWalkPreferences.KeyValueChangeListener {
    private static String TAG = "XWalkContent";
    private static Class<? extends Annotation> javascriptInterfaceClass;

    private static String sCurrentLocales = "";

    // A holder of objects passed from WebContents and should be owned by AwContents that may
    // have direct or indirect reference back to WebView. They are used internally by
    // WebContents but all the references can create a new gc root that can keep WebView
    // instances from being freed when they are detached from view tree, hence lead to
    // memory leak. To avoid the issue, it is possible to use |WebContents.setInternalHolder|
    // to move the holder of those internal objects to AwContents. Note that they are still
    // used by WebContents, and AwContents doesn't have to know what's inside the holder.
    private WebContentsInternals mWebContentsInternals;
    private WebContentsInternalsHolder mWebContentsInternalsHolder;
    private Context mViewContext;
    private XWalkContentView mContentView;
    private ContentViewRenderView mContentViewRenderView;
    private WindowAndroid mWindow;
    private XWalkDevToolsServer mDevToolsServer;
    private XWalkView mXWalkView;
    private XWalkContentsClientBridge mContentsClientBridge;
    private XWalkContentsIoThreadClient mIoThreadClient;
    private XWalkWebContentsDelegateAdapter mXWalkContentsDelegateAdapter;
    private final XWalkContentsBackgroundThreadClient mBackgroundThreadClient;
    private XWalkSettings mSettings;
    private XWalkGeolocationPermissions mGeolocationPermissions;
    //    private XWalkLaunchScreenManager mLaunchScreenManager;
    private NavigationController mNavigationController;
    private WebContents mWebContents;
    private boolean mIsLoaded;
    private boolean mAnimated;
    private XWalkAutofillClientAndroid mXWalkAutofillClient;
    private XWalkGetBitmapCallback mXWalkGetBitmapCallback;
    private final HitTestData mPossiblyStaleHitTestData = new HitTestData();
    // Controls overscroll pull-to-refresh behavior.
    private SwipeRefreshHandler mSwipeRefreshHandler;
    private int metaFsError;
    long mNativeContent;
    private final int mAppTargetSdkVersion;
    private JavascriptInjector mJavascriptInjector;
    private ComponentCallbacks2 mComponentCallbacks;

    // TODO(iotto): Continue!
    private final UserDataHost mUserDataHost = new UserDataHost();

    // ch64
    // These come from the compositor and are updated synchronously (in contrast to the values in
    // ContentViewCore, which are updated at end of every frame).
    private float mPageScaleFactor = 1.0f;
    private float mMinPageScaleFactor = 1.0f;
    private float mMaxPageScaleFactor = 1.0f;
    private float mContentWidthDip;
    private float mContentHeightDip;

    public static class HitTestData {
        // Used in getHitTestResult
        public int hitTestResultType;
        public String hitTestResultExtraData;

        // Used in requestFocusNodeHref(all three) and requestImageRef(only
        // imageSrc)
        public String href;
        public String anchorText;
        public String imgSrc;
    }

    // TODO(hengzhi.wu): This should be in a global context, not per XWalkView.
    private double mDIPScale;

    static void setJavascriptInterfaceClass(Class<? extends Annotation> clazz) {
        assert (javascriptInterfaceClass == null);
        javascriptInterfaceClass = clazz;
    }

    private static final class DestroyRunnable implements Runnable {
        private final long mNativeContent;

        private DestroyRunnable(long nativeXWalkContent) {
            mNativeContent = nativeXWalkContent;
        }

        @Override
        public void run() {
            nativeDestroy(mNativeContent);
        }
    }

    // Reference to the active mNativeContent pointer while it is active use
    // (ie before it is destroyed).
    private XWalkCleanupReference mXWalkCleanupReference;

    private final int zoneId;
    private final int tabId;

    // orig xwalk
    public XWalkContent(Context context, XWalkView xwView) {
        this(context, xwView, 0, 0);
    }

    // Tenta tailored
    public XWalkContent(Context context, XWalkView xwView, final int zoneId, final int tabId) {
        this.zoneId = zoneId;
        this.tabId = tabId;

        mAppTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        // Initialize the WebContensDelegate.
        mXWalkView = xwView;
        mViewContext = mXWalkView.getContext();
        mContentsClientBridge = new XWalkContentsClientBridge(mXWalkView);
        mBackgroundThreadClient = new BackgroundThreadClientImpl();
        mXWalkContentsDelegateAdapter = new XWalkWebContentsDelegateAdapter(context,mContentsClientBridge,
                this);
        mIoThreadClient = new XWalkIoThreadClientImpl();

        // Initialize mWindow which is needed by content.
        if (WindowAndroid.activityFromContext(context) != null) {
            final boolean listenToActivityState = true;
            mWindow = new ActivityWindowAndroid(context, listenToActivityState);
        } else {
            mWindow = new WindowAndroid(context);
        }

        SharedPreferences sharedPreferences = new InMemorySharedPreferences();
        mGeolocationPermissions = new XWalkGeolocationPermissions(sharedPreferences);

        //TODO(iotto) : Fix if filter is needed
//        MediaPlayerBridge.setResourceLoadingFilter(new XWalkMediaPlayerResourceLoadingFilter());

        setNativeContent(nativeInit());

        XWalkPreferences.load(this);
        initCaptureBitmapAsync();
    }

    public UserDataHost getUserDataHost() {
        return mUserDataHost;
    }

    /**
     * Set current locales to native. Propagates this information to the Accept-Language header for
     * subsequent requests. Note that this will affect <b>all</b> AwContents, not just this
     * instance, as all WebViews share the same NetworkContext/UrlRequestContextGetter.
     */
    public void updateDefaultLocale() {
        String locales = LocaleUtils.getDefaultLocaleListString();
        if (!sCurrentLocales.equals(locales)) {
            sCurrentLocales = locales;

            // We cannot use the first language in sCurrentLocales for the UI language even on
            // Android N. LocaleUtils.getDefaultLocaleString() is capable for UI language but
            // it is not guaranteed to be listed at the first of sCurrentLocales. Therefore,
            // both values are passed to native.
            nativeUpdateDefaultLocale(LocaleUtils.getDefaultLocaleString(), sCurrentLocales);
            mSettings.updateAcceptLanguages();
        }
    }

    @Deprecated
    private void initCaptureBitmapAsync() {
        // TODO(iotto): Remove, not used anymore
    }

    @Deprecated
    public void captureBitmapAsync(XWalkGetBitmapCallback callback) {
        if (mNativeContent == 0)
            return;
        // TODO(iotto): Remove, Use the WithParams version
    }

    public void captureBitmapWithParams(Bitmap.Config config, float scale, Rect srcRect,
                                        final XWalkGetBitmapCallback callback) {
        if ( callback == null )
            return;
        if (mNativeContent == 0 ) {
            callback.onFinishGetBitmap(null, 0);
            return;
        }

        nativeCaptureBitmapWithParams(mNativeContent, scale, new Callback<Bitmap>() {
            @Override
            public void onResult(Bitmap result) {
                int errCode = 0;
                if ( result == null ) {
                    errCode = -1;
                }
                callback.onFinishGetBitmap(result, errCode);
            }

        });
    }

    private void setNativeContent(long newNativeContent) {
        if (mNativeContent != 0) {
            destroy();
        }

        assert mNativeContent == 0 && mXWalkCleanupReference == null;


        mContentViewRenderView = new ContentViewRenderView(mViewContext);
        mContentViewRenderView.onNativeLibraryLoaded(mWindow);

        mWindow.setAnimationPlaceholderView(mContentViewRenderView.getSurfaceView());

//        mLaunchScreenManager = new XWalkLaunchScreenManager(mViewContext, mXWalkView);
//        mContentViewRenderView.registerFirstRenderedFrameListener(mLaunchScreenManager);
        mXWalkView.addView(mContentViewRenderView,
                new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));

        mNativeContent = newNativeContent;

        // The native side object has been bound to this java instance, so now
        // is the time to
        // bind all the native->java relationships.
        mXWalkCleanupReference = new XWalkCleanupReference(this,
                new DestroyRunnable(mNativeContent));

        mWebContents = nativeGetWebContents(mNativeContent);

        // Chromium 77
        mContentView = XWalkContentView.createContentView(mViewContext, mWebContents, mXWalkView);

        mWebContentsInternalsHolder = new WebContentsInternalsHolder(this);
        mWebContents.initialize(getChromeVersion(), new ViewAndroidDelegateInternal(mContentView),
                /*ViewAndroidDelegate.createBasicDelegate(mContentView),*/ mContentView, mWindow,
                mWebContentsInternalsHolder);

        SelectionPopupController controller = SelectionPopupController.fromWebContents(mWebContents);
        controller.setActionModeCallback(new XWalkActionModeCallback(mWebContents));
        controller.setSelectionClient(SelectionClient.createSmartSelectionClient(mWebContents));

        // TODO(iotto) : implement
//        if (mAutofillProvider != null) {
//            contentViewCore.setNonSelectionActionModeCallback(
//                    new AutofillActionModeCallback(context, mAutofillProvider));
//        }

        mNavigationController = mWebContents.getNavigationController();
        mXWalkView.addView(mContentView,
                new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));
        mContentView.requestFocus();

        mContentViewRenderView.setCurrentWebContents(mWebContents);
////        mContentViewCore.setContentViewClient(mContentsClientBridge);
//        mContentViewRenderView.setCurrentContentViewCore(mContentViewCore);
//        mContentViewCore.onShow();

        // For addJavascriptInterface
        mContentsClientBridge.installWebContentsObserver(mWebContents);

//        // For swipe-to-refresh
        mSwipeRefreshHandler = new SwipeRefreshHandler(mViewContext);
        mSwipeRefreshHandler.initForWebContents(mWebContents, mContentView);

        // Set the third argument isAccessFromFileURLsGrantedByDefault to false,
        // so that
        // the members mAllowUniversalAccessFromFileURLs and
        // mAllowFileAccessFromFileURLs
        // won't be changed from false to true at the same time in the
        // constructor of
        // XWalkSettings class.
        mSettings = new XWalkSettings(mViewContext, mWebContents, false);
        // Enable AllowFileAccessFromFileURLs, so that files under file:// path
        // could be
        // loaded by XMLHttpRequest.
        mSettings.setAllowFileAccessFromFileURLs(true);

        // Set DIP scale.
        mDIPScale = mWindow.getDisplay().getDipScale();
        // DeviceDisplayInfo.create(mViewContext).getDIPScale();

        mContentsClientBridge.setDIPScale(mDIPScale);
        mSettings.setDIPScale(mDIPScale);

        updateDefaultLocale();

        String language = Locale.getDefault().toString().replaceAll("_", "-")
                .toLowerCase(Locale.getDefault());
        if (language.isEmpty())
            language = "en";
        mSettings.setAcceptLanguages(language);

        XWalkSettings.ZoomSupportChangeListener zoomListener = new XWalkSettings.ZoomSupportChangeListener() {
            @Override
            public void onGestureZoomSupportChanged(boolean supportsDoubleTapZoom,
                                                    boolean supportsMultiTouchZoom) {
                GestureListenerManager gestureManager =
                        GestureListenerManager.fromWebContents(mWebContents);
                gestureManager.updateDoubleTapSupport(supportsDoubleTapZoom);
                gestureManager.updateMultiTouchZoomSupport(supportsMultiTouchZoom);
            }
        };
        mSettings.setZoomListener(zoomListener);

        nativeSetJavaPeers(mNativeContent, this, mXWalkContentsDelegateAdapter,
                mContentsClientBridge, mIoThreadClient,
                mContentsClientBridge.getInterceptNavigationDelegate());

        mComponentCallbacks = new XWalkComponentCallbacks();
        mViewContext.registerComponentCallbacks(mComponentCallbacks);

        if (mAppTargetSdkVersion < Build.VERSION_CODES.LOLLIPOP) {
            // Prior to Lollipop, JavaScript objects injected via addJavascriptInterface
            // were not inspectable.
            getJavascriptInjector().setAllowInspection(false);
        }
    }

    /**
     *
     * @author iotto
     *
     */
    private class ViewAndroidDelegateInternal extends ViewAndroidDelegate {

        protected ViewAndroidDelegateInternal(ViewGroup containerView) {
            super(containerView);
        }

        @Override
        public View acquireView() {
            final View retVal = super.acquireView();
            return retVal;
        }
    }

    /**
     *
     * @author iotto
     *
     */
    private class XWalkComponentCallbacks implements ComponentCallbacks2 {
        @Override
        public void onTrimMemory(final int level) {
            Log.w(TAG, "TrimMemoryLevel=%d", level);
//            boolean visibleRectEmpty = getGlobalVisibleRect().isEmpty();
//            final boolean visible = mIsViewVisible && mIsWindowVisible && !visibleRectEmpty;
//            ThreadUtils.runOnUiThreadBlocking(() -> {
//                if (isDestroyed(NO_WARN)) return;
//                if (level >= TRIM_MEMORY_MODERATE) {
//                    if (mDrawFunctor != null) {
//                        mDrawFunctor.trimMemory();
//                    }
//                }
//                nativeTrimMemory(mNativeAwContents, level, visible);
//            });
        }

        @Override
        public void onLowMemory() {}

        @Override
        public void onConfigurationChanged(Configuration configuration) {
            updateDefaultLocale();
        }
    };

    // TODO(iotto): Fix popup support!
    public void supplyContentsForPopup(XWalkContent newContents) {
        Log.e("iotto", "Fix: supplyContentsForPopup");
//        if (mNativeContent == 0)
//            return;
//
//        long popupNativeXWalkContent = nativeReleasePopupXWalkContent(mNativeContent);
//        if (popupNativeXWalkContent == 0) {
//            Log.w(TAG, "Popup XWalkView bind failed: no pending content.");
//            if (newContents != null)
//                newContents.destroy();
//            return;
//        }
//        if (newContents == null) {
//            nativeDestroy(popupNativeXWalkContent);
//            return;
//        }
//
//        newContents.receivePopupContents(popupNativeXWalkContent);
//    }
//
//    private void receivePopupContents(long popupNativeXWalkContents) {
//        setNativeContent(popupNativeXWalkContents);
//
//        mContentViewCore.onShow();
    }

    private void doLoadUrl(LoadUrlParams params) {
        params.setOverrideUserAgent(UserAgentOverrideOption.TRUE);
        mNavigationController.loadUrl(params);
        mContentView.clearFocus();
        mContentView.requestFocus();
        mIsLoaded = true;
    }

    private static String fixupBase(String url) {
        return TextUtils.isEmpty(url) ? "about:blank" : url;
    }

    private static String fixupData(String data) {
        return TextUtils.isEmpty(data) ? "" : data;
    }

    private static String fixupHistory(String url) {
        return TextUtils.isEmpty(url) ? "about:blank" : url;
    }

    private static String fixupMimeType(String mimeType) {
        return TextUtils.isEmpty(mimeType) ? "text/html" : mimeType;
    }

    private static boolean isBase64Encoded(String encoding) {
        return "base64".equals(encoding);
    }

    public void loadData(String data, String mimeType, String encoding) {
        if (mNativeContent == 0)
            return;

        data = TextUtils.isEmpty(data) ? "" : data;
        mimeType = TextUtils.isEmpty(mimeType) ? "text/html" : mimeType;
        doLoadUrl(LoadUrlParams.createLoadDataParams(fixupData(data), fixupMimeType(mimeType),
                isBase64Encoded(encoding)));
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding,
                                    String historyUrl) {
        if (mNativeContent == 0)
            return;

        data = fixupData(data);
        mimeType = fixupMimeType(mimeType);
        LoadUrlParams loadUrlParams;
        baseUrl = fixupBase(baseUrl);
        historyUrl = fixupHistory(historyUrl);

        // When loading data with a non-data: base URL, the classic WebView
        // would effectively
        // "dump" that string of data into the WebView without going through
        // regular URL
        // loading steps such as decoding URL-encoded entities. We achieve this
        // same behavior by
        // base64 encoding the data that is passed here and then loading that as
        // a data: URL.
        try {
            loadUrlParams = LoadUrlParams.createLoadDataParamsWithBaseUrl(
                    Base64.encodeToString(data.getBytes("utf-8"), Base64.DEFAULT), mimeType, true,
                    baseUrl, historyUrl,
                    "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            Log.w(TAG, "Unable to load data string " + data, e);
            return;
        }
        doLoadUrl(loadUrlParams);
    }

    public void loadUrl(String url) {
        // Early out to match the old classic Android WebView's implementation.
        if (url == null) {
            return;
        }
        loadUrl(url, null);
    }

    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        if (mNativeContent == 0)
            return;
        LoadUrlParams params = new LoadUrlParams(url);
        if (additionalHttpHeaders != null)
            params.setExtraHeaders(additionalHttpHeaders);

        // If we are reloading the same url, then set transition type as reload.
        if (params.getUrl() != null
                && params.getUrl().equals(mWebContents.getLastCommittedUrl())
                && params.getTransitionType() == PageTransition.LINK) {
            params.setTransitionType(PageTransition.RELOAD);
        }
        params.setTransitionType(
                params.getTransitionType() | PageTransition.FROM_API);
        doLoadUrl(params);
    }

    public void reload(int mode) {
        if (mNativeContent == 0)
            return;

        switch (mode) {
            // TODO(iotto) remove duplicate mode
            case XWalkView.RELOAD_TO_REFRESH:
                mNavigationController.reload(true);
                break;
            case XWalkView.RELOAD_IGNORE_CACHE:
                mNavigationController.reloadBypassingCache(true);
                break;
            case XWalkView.RELOAD_NORMAL:
            default:
                mNavigationController.loadIfNecessary();
        }
        mIsLoaded = true;
    }

    public String getUrl() {
        if (mNativeContent == 0)
            return null;
        String url = mWebContents.getVisibleUrl();
        if (url == null || url.trim().isEmpty())
            return null;
        return url;
    }

    public String getTitle() {
        if (mNativeContent == 0)
            return null;
        String title = mWebContents.getTitle().trim();
        if (title == null)
            title = "";
        return title;
    }

    public void addJavascriptInterface(Object object, String name) {
        if (mNativeContent == 0)
            return;

        Class<? extends Annotation> requiredAnnotation = javascriptInterfaceClass;
        if (mAppTargetSdkVersion >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            requiredAnnotation = JavascriptInterface.class;
        }

        getJavascriptInjector().addPossiblyUnsafeInterface(object, name, requiredAnnotation);
    }

    public void removeJavascriptInterface(String interfaceName) {
        if (mNativeContent == 0)
            return;
        getJavascriptInjector().removeInterface(interfaceName);
    }

    private JavascriptInjector getJavascriptInjector() {
        if (mJavascriptInjector == null) {
            mJavascriptInjector = JavascriptInjector.fromWebContents(mWebContents);
        }
        return mJavascriptInjector;
    }

    public void evaluateJavascript(String script, ValueCallback<String> callback) {
        if (mNativeContent == 0)
            return;
        final ValueCallback<String> fCallback = callback;
        JavaScriptCallback coreCallback = null;
        if (fCallback != null) {
            coreCallback = new JavaScriptCallback() {
                @Override
                public void handleJavaScriptResult(String jsonResult) {
                    fCallback.onReceiveValue(jsonResult);
                }
            };
        }
        mWebContents.evaluateJavaScript(script, coreCallback);
    }

    public void setUIClient(XWalkUIClient client) {
        if (mNativeContent == 0)
            return;
        mContentsClientBridge.setUIClient(client);
    }

    public void setResourceClient(XWalkResourceClient client) {
        if (mNativeContent == 0)
            return;
        mContentsClientBridge.setResourceClient(client);
    }

    public void setXWalkWebChromeClient(XWalkWebChromeClient client) {
        if (mNativeContent == 0)
            return;
        mContentsClientBridge.setXWalkWebChromeClient(client);
    }

    public XWalkWebChromeClient getXWalkWebChromeClient() {
        if (mNativeContent == 0)
            return null;
        return mContentsClientBridge.getXWalkWebChromeClient();
    }

    public int getContentHeight() {
        return mContentView.getHeight();
        // TODO(iotto): "analyse and implement GetVisibleViewportSize
//        gfx::Size GuestViewBase::GetDefaultSize() const {
//            if (!is_full_page_plugin())
//              return gfx::Size(kDefaultWidth, kDefaultHeight);
//
//            // Full page plugins default to the size of the owner's viewport.
//            return owner_web_contents()
//                ->GetRenderWidgetHostView()
//                ->GetVisibleViewportSize();
//          }
//        
//        return (int) Math.ceil(mContentViewCore.getViewportHeightPix());
////        return (int) Math.ceil(mContentViewCore.getContentHeightCss());
    }

    public void setXWalkClient(XWalkClient client) {
        if (mNativeContent == 0)
            return;
        mContentsClientBridge.setXWalkClient(client);
    }

    public void setDownloadListener(XWalkDownloadListener listener) {
        if (mNativeContent == 0)
            return;
        mContentsClientBridge.setDownloadListener(listener);
    }

    public void setNavigationHandler(XWalkNavigationHandler handler) {
        if (mNativeContent == 0)
            return;
        mContentsClientBridge.setNavigationHandler(handler);
    }

    public void setNotificationService(XWalkNotificationService service) {
        if (mNativeContent == 0)
            return;
        mContentsClientBridge.setNotificationService(service);
    }

    public boolean onNewIntent(Intent intent) {
        if (mNativeContent == 0)
            return false;
        return mContentsClientBridge.onNewIntent(intent);
    }

    public void clearCache(boolean includeDiskFiles) {
        if (mNativeContent == 0)
            return;
        nativeClearCache(mNativeContent, includeDiskFiles);
    }

    public void clearCacheForSingleFile(final String url) {
        if (mNativeContent == 0)
            return;
        if (mIsLoaded == false) {
            mXWalkView.post(new Runnable() {
                @Override
                public void run() {
                    clearCacheForSingleFile(url);
                }
            });
            return;
        }
        nativeClearCacheForSingleFile(mNativeContent, url);
    }

    public void clearHistory() {
        if (mNativeContent == 0)
            return;
        mNavigationController.clearHistory();
    }

    public boolean removeHistoryEntryAt(int index) {
        return (mNativeContent == 0) ? false : mNavigationController.removeEntryAtIndex(index);
    }

    public boolean canGoBack() {
        return (mNativeContent == 0) ? false : mNavigationController.canGoBack();
    }

    public void goBack() {
        if (mNativeContent == 0)
            return;
        mNavigationController.goBack();
    }

    public boolean canGoForward() {
        return (mNativeContent == 0) ? false : mNavigationController.canGoForward();
    }

    public void goForward() {
        if (mNativeContent == 0)
            return;
        mNavigationController.goForward();
    }

    void navigateTo(int offset) {
        mNavigationController.goToOffset(offset);
    }

    public void stopLoading() {
        Log.d("iotto", "stopLoading nativeContent=%s webContents=%s", mNativeContent, mWebContents);
        if (mNativeContent == 0)
            return;
        mWebContents.stop();
        mContentsClientBridge.onStopLoading();
    }

//    public Bitmap getFavicon() {
//        if (mNativeContent == 0)
//            return null;
//        return mContentsClientBridge.getFavicon();
//    }

    // Currently, timer pause/resume is actually
    // a global setting. And multiple pause will fail the
    // DCHECK in content (content_view_statics.cc:57).
    // Here uses a static boolean to avoid this issue.
    private static boolean timerPaused;

    // TODO(Guangzhen): ContentViewStatics will be removed in upstream,
    // details in content_view_statics.cc.
    // We need follow up after upstream updates that.
    public void pauseTimers() {
        Log.d("iotto", "pauseTimers nativeContent=%s webContents=%s", mNativeContent, mWebContents);
        if (timerPaused || (mNativeContent == 0))
            return;
        ContentViewStatics.setWebKitSharedTimersSuspended(true);
        timerPaused = true;
    }

    public void resumeTimers() {
        Log.d("iotto", "resumeTimers nativeContent=%s webContents=%s", mNativeContent, mWebContents);
        if (!timerPaused || (mNativeContent == 0))
            return;
        ContentViewStatics.setWebKitSharedTimersSuspended(false);
        timerPaused = false;
    }

    private boolean mIsPaused;
    // Visiblity state of |mWebContents|.
    private boolean mIsContentVisible;
    private boolean mRendererPriorityWaivedWhenNotVisible = true;
//    private @RendererPriority int mRendererPriority = RendererPriority.INITIAL;

    public void onPause() {
        Log.d("iotto", "onPause nativeContent=%s webContents=%s", mNativeContent, mWebContents);
        if (mNativeContent == 0)
            return;
        // TODO(iotto): Implement the isDestroyed
        if (mIsPaused /*|| isDestroyed(NO_WARN)*/) return;
        mIsPaused = true;
//        nativeSetIsPaused(mNativeContent, mIsPaused);

        // Geolocation is paused/resumed via the page visibility mechanism.
        updateWebContentsVisibility();

//        mWebContents.onHide();
    }

    public void onResume() {
        Log.d("iotto", "onResume nativeContent=%s webContents=%s", mNativeContent, mWebContents);
        if (mNativeContent == 0)
            return;
        // TODO(iotto): Implement the isDestroyed
        if (!mIsPaused /*|| isDestroyed(NO_WARN)*/) return;
        mIsPaused = false;
//        nativeSetIsPaused(mNativeAwContents, mIsPaused);
        updateWebContentsVisibility();
//        mWebContents.onShow();
    }

    private void updateWebContentsVisibility() {
//        mIsUpdateVisibilityTaskPending = false;
//        if (isDestroyed(NO_WARN)) return;
        boolean contentVisible = !mIsPaused;
        //nativeIsVisible(mNativeAwContents);

        if (contentVisible && !mIsContentVisible) {
            mWebContents.onShow();
        } else if (!contentVisible && mIsContentVisible) {
            mWebContents.onHide();
        }
        mIsContentVisible = contentVisible;
        updateChildProcessImportance();
    }

    private void updateChildProcessImportance() {
        @ChildProcessImportance
        int effectiveImportance = ChildProcessImportance.IMPORTANT;
        if (mRendererPriorityWaivedWhenNotVisible && !mIsContentVisible) {
            effectiveImportance = ChildProcessImportance.NORMAL;
        }
//        } else {
//            switch (mRendererPriority) {
//                case RendererPriority.INITIAL:
//                case RendererPriority.HIGH:
//                    effectiveImportance = ChildProcessImportance.IMPORTANT;
//                    break;
//                case RendererPriority.LOW:
//                    effectiveImportance = ChildProcessImportance.MODERATE;
//                    break;
//                case RendererPriority.WAIVED:
//                    effectiveImportance = ChildProcessImportance.NORMAL;
//                    break;
//                default:
//                    assert false;
//            }
//        }
        mWebContents.setImportance(effectiveImportance);
    }

    public String getOriginalUrl() {
        if (mNativeContent == 0)
            return null;
        NavigationHistory history = mNavigationController.getNavigationHistory();
        int currentIndex = history.getCurrentEntryIndex();
        if (currentIndex >= 0 && currentIndex < history.getEntryCount()) {
            return history.getEntryAtIndex(currentIndex).getOriginalUrl();
        }
        return null;
    }

    public HitTestData getLastHitTestResult() {
        if (mNativeContent == 0)
            return null;
        nativeUpdateLastHitTestData(mNativeContent);
        return mPossiblyStaleHitTestData;
    }

    @CalledByNative
    private void updateHitTestData(int type, String extra, String href, String anchorText,
                                   String imgSrc) {
        mPossiblyStaleHitTestData.hitTestResultType = type;
        mPossiblyStaleHitTestData.hitTestResultExtraData = extra;
        mPossiblyStaleHitTestData.href = href;
        mPossiblyStaleHitTestData.anchorText = anchorText;
        mPossiblyStaleHitTestData.imgSrc = imgSrc;
    }

    public String getXWalkVersion() {
        if (mNativeContent == 0)
            return "";
        return nativeGetVersion(mNativeContent);
    }

    public static String getChromeVersion() {
        return nativeGetChromeVersion();
    }

    private boolean isOpaque(int color) {
        return ((color >> 24) & 0xFF) == 0xFF;
    }

    //    @CalledByNative
    public void setBackgroundColor(final int color) {
        if (mNativeContent == 0)
            return;
        if (!mIsLoaded) {
            mXWalkView.post(new Runnable() {
                @Override
                public void run() {
                    setBackgroundColor(color);
                }
            });
            return;
        }
        // This was removed completely: https://github.com/chromium/chromium/commit/845a437179fe0a1180b507029acf1272fde27558
        //   mContentViewCore.setBackgroundOpaque(isOpaque(color));
        setOverlayVideoMode(isOpaque(color));
        mContentViewRenderView.setSurfaceViewBackgroundColor(color);
        nativeSetBackgroundColor(mNativeContent, color);
    }

    public void setNetworkAvailable(boolean networkUp) {
        if (mNativeContent == 0)
            return;
        nativeSetJsOnlineProperty(mNativeContent, networkUp);
    }

    // For instrumentation test.
    public void installWebContentsObserverForTest(XWalkContentsClient contentClient) {
        if (mNativeContent == 0)
            return;
        contentClient.installWebContentsObserver(mWebContents);
    }

    public String devToolsAgentId() {
        if (mNativeContent == 0)
            return "";
        return nativeDevToolsAgentId(mNativeContent);
    }

    public XWalkSettings getSettings() {
        return mSettings;
    }

    public void loadAppFromManifest(String url, String data) {
        if (mNativeContent == 0
                || ((url == null || url.isEmpty()) && (data == null || data.isEmpty()))) {
            return;
        }

        String content = data;
        // If the data of manifest.json is not set, try to load it.
        if (data == null || data.isEmpty()) {
            try {
                content = AndroidProtocolHandler.getUrlContent(mXWalkView.getContext(), url);
            } catch (IOException e) {
                throw new RuntimeException("Failed to read the manifest: " + url);
            }
        }

        // Calculate the base url of manifestUrl. Used by native side.
        // TODO(yongsheng): It's from runtime side. Need to find a better way
        // to get base url.
        String baseUrl = url;
        int position = url.lastIndexOf("/");
        if (position != -1) {
            baseUrl = url.substring(0, position + 1);
        } else {
            Log.w(TAG, "The url of manifest.json is probably not set correctly.");
        }

        if (!nativeSetManifest(mNativeContent, baseUrl, content)) {
            throw new RuntimeException("Failed to parse the manifest file: " + url);
        }
        mIsLoaded = true;
    }

    public void setOriginAccessWhitelist(String url, String[] patterns) {
        if (mNativeContent == 0 || TextUtils.isEmpty(url))
            return;

        // Reset origin access whitelists if pattern is null.
        String matchPatterns = "";
        if (patterns != null) {
            JSONArray arrays = new JSONArray(Arrays.asList(patterns));
            matchPatterns = arrays.toString();
        }

        nativeSetOriginAccessWhitelist(mNativeContent, url, matchPatterns);
    }

    public XWalkNavigationHistory getNavigationHistory() {
        if (mNativeContent == 0)
            return null;

        return new XWalkNavigationHistory(mXWalkView,
                mNavigationController.getNavigationHistory());
    }

    /**
     * Gets the last committed URL. It represents the current page that is displayed in WebContents.
     * It represents the current security context.
     *
     * @return The URL of the current page or null if it's empty.
     */
    public String getLastCommittedUrl() {
        if (mNativeContent == 0)
            return null;
        String url = mWebContents.getLastCommittedUrl();
        if (url == null || url.trim().isEmpty())
            return null;
        return url;
    }

    public int getLastCommittedEntryIndex() {
        if (mNativeContent == 0)
            return -1;

        return mNavigationController.getLastCommittedEntryIndex();
    }

    public int getPendingEntryIndex() {
        if (mNativeContent == 0)
            return -1;

        NavigationEntry pending = mNavigationController.getPendingEntry();
        if (pending == null) {
            return -1;
        }

        return pending.getIndex();

    }

    public static final String SAVE_RESTORE_STATE_KEY = "XWALKVIEW_STATE";

    /**
     * @param outState
     * @return
     */
    public XWalkNavigationHistory saveState(Bundle outState) {
        if (mNativeContent == 0 || outState == null)
            return null;

        byte[] state = nativeGetState(mNativeContent);
        if (state == null)
            return null;

        // final String key = SAVE_RESTORE_STATE_KEY +
        // String.valueOf(getRoutingID());

        outState.putByteArray(getSaveRestoreBundleKey(), state);
        return getNavigationHistory();
    }

    public XWalkNavigationHistory restoreState(Bundle inState) {
        if (mNativeContent == 0 || inState == null)
            return null;

        byte[] state = inState.getByteArray(getSaveRestoreBundleKey());
        if (state == null)
            return null;

        boolean result = nativeSetState(mNativeContent, state);

        // The onUpdateTitle callback normally happens when a page is loaded,
        // but is optimized out in the restoreState case because the title is
        // already restored. See WebContentsImpl::UpdateTitleForEntry. So we
        // call the callback explicitly here.
        if (result)
            mContentsClientBridge.onTitleChanged(mWebContents.getTitle(), true);

        return result ? getNavigationHistory() : null;
    }

    /**
     * Returns last metafs error
     *
     * @return
     */
    public int getMetaFsError() {
        return metaFsError;
    }

    /**
     * Save current history in native db, using id and encryption key
     *
     * @param id
     * @param encKey
     * @return
     */
    public int saveHistory(final String id, final String encKey) {
        if (mNativeContent == 0) {
            //return metaFsError = MetaError.INVALID_POINTER; // ERR_INVALID_POINTER
        }

        int result = nativeSaveHistory(mNativeContent, id, encKey);
        return metaFsError = result;
    }

    /**
     * Restore history from native db using id and encryption key
     *
     * @param id
     * @param encKey
     * @return
     */
    public int restoreHistory(final String id, final String encKey) {
        if (mNativeContent == 0) {
            // return metaFsError = MetaError.INVALID_POINTER; // ERR_INVALID_POINTER
        }

        int result = nativeRestoreHistory(mNativeContent, id, encKey);
        //if (result == MetaError.FS_OK) {
        //     mContentsClientBridge.onTitleChanged(mWebContents.getTitle(), true);
        // }
        return metaFsError = result;
    }

    /**
     * Save old state to new db structure
     *
     * @param state
     * @param id
     * @param encKey
     * @return
     */
    public int saveOldHistory(byte[] state, final String id,
                              final String encKey) {

        if (mNativeContent == 0) {
            // return metaFsError = MetaError.INVALID_POINTER;
        }

        int result = nativeSaveOldHistory(mNativeContent, state, id, encKey);

        //if (metaFsError == MetaError.FS_OK) {
        mContentsClientBridge.onTitleChanged(mWebContents.getTitle(), true);
        // }

        return metaFsError = result;
    }

    /**
     * Clear current history
     *
     * @param id
     * @param encKey
     * @return
     */
    public int nukeHistory(final String id, final String encKey) {
        if (mNativeContent == 0) {
            // return metaFsError = MetaError.INVALID_POINTER;
        }

        int result = nativeNukeHistory(mNativeContent, id, encKey);
        return metaFsError = result;

    }

    /**
     * Bundle key for save/restore state
     *
     * @return SAVE_RESTORE_STATE_KEY
     */
    private String getSaveRestoreBundleKey() {
        return SAVE_RESTORE_STATE_KEY;
    }

    boolean hasEnteredFullscreen() {
        return mContentsClientBridge.hasEnteredFullscreen();
    }

    void exitFullscreen() {
        if (hasEnteredFullscreen()) {
            mWebContents.exitFullscreen();
        }
    }

//    @CalledByNative
//    public void onGetUrlFromManifest(String url) {
//        if (url != null && !url.isEmpty()) {
//            loadUrl(url);
//        }
//    }

//    @CalledByNative
//    public void onGetUrlAndLaunchScreenFromManifest(String url, String readyWhen,
//            String imageBorder) {
//        Log.e("iotto", "Fix or remove displayLaunchScreen ... we're not using launchscreen!");
////        if (url == null || url.isEmpty())
////            return;
////        mLaunchScreenManager.displayLaunchScreen(readyWhen, imageBorder);
////        mContentsClientBridge.registerPageLoadListener(mLaunchScreenManager);
////        loadUrl(url);
//    }

//    @CalledByNative
//    public void onGetFullscreenFlagFromManifest(boolean enterFullscreen) {
//        if (!(mXWalkView.getContext() instanceof Activity))
//            return;
//
//        Activity activity = (Activity) mXWalkView.getContext();
//        if (enterFullscreen) {
//            if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
//                View decorView = activity.getWindow().getDecorView();
//                decorView.setSystemUiVisibility(
//                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//            } else {
//                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            }
//        }
//    }

    /**
     * Reset swipe-to-refresh handler.
     */
    void resetSwipeRefreshHandler() {
        // When the dialog is visible, keeping the refresh animation active
        // in the background is distracting and unnecessary (and likely to
        // jank when the dialog is shown).
        if (mSwipeRefreshHandler != null) {
            mSwipeRefreshHandler.reset();
        }
    }

    /**
     * Stop swipe-to-refresh animation.
     */
    void stopSwipeRefreshHandler() {
        if (mSwipeRefreshHandler != null) {
            mSwipeRefreshHandler.didStopRefreshing();
        }
    }

    void enableSwipeRefresh(boolean enable) {
        if (mSwipeRefreshHandler != null) {
            mSwipeRefreshHandler.setEnabled(enable);
        }
    }

    public void destroy() {
        if (mNativeContent == 0)
            return;

        XWalkPreferences.unload(this);
        // Reset existing notification service in order to destruct it.
        setNotificationService(null);
        // Remove its children used for page rendering from view hierarchy.
        mXWalkView.removeView(mContentView);
        mXWalkView.removeView(mContentViewRenderView);
        mContentViewRenderView.setCurrentWebContents(null);

        if (mSwipeRefreshHandler != null) {
            mSwipeRefreshHandler.cleanupForWebContents(mWebContents);
            mSwipeRefreshHandler = null;
        }

        // Destroy the native resources.
        mXWalkCleanupReference.cleanupNow();
        mContentViewRenderView.destroy();
        mWebContents.destroy();
        mXWalkCleanupReference = null;
        mNativeContent = 0;
    }

    public int getRoutingID() {
        return nativeGetRoutingID(mNativeContent);
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return mContentView.onCreateInputConnectionSuper(outAttrs);
    }

    public boolean onTouchEvent(MotionEvent event) {
//        if (isDestroyed(NO_WARN)) return false;
//        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
//            mSettings.setSpatialNavigationEnabled(false);
//        }
//
//        mScrollOffsetManager.setProcessingTouchEvent(true);
//        boolean rv = mWebContents.getEventForwarder().onTouchEvent(event);
//        mScrollOffsetManager.setProcessingTouchEvent(false);

        boolean retVal = mWebContents.getEventForwarder().onTouchEvent(event);

        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            // Note this will trigger IPC back to browser even if nothing is
            // hit.
            float eventX = event.getX();
            float eventY = event.getY();
            float touchMajor = Math.max(event.getTouchMajor(), event.getTouchMinor());
            if (!UseZoomForDSFPolicy.isUseZoomForDSFEnabled()) {
                float dipScale = getDeviceScaleFactor();
                eventX /= dipScale;
                eventY /= dipScale;
                touchMajor /= dipScale;
            }
            nativeRequestNewHitTestDataAt(mNativeContent, eventX, eventY, touchMajor);
        }

//        if (mOverScrollGlow != null) {
//            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
//                mOverScrollGlow.setShouldPull(true);
//            } else if (event.getActionMasked() == MotionEvent.ACTION_UP
//                    || event.getActionMasked() == MotionEvent.ACTION_CANCEL) {
//                mOverScrollGlow.setShouldPull(false);
//                mOverScrollGlow.releaseAll();
//            }
//        }
        return retVal;
        // return mContentViewCore.onTouchEvent(event);
    }

    private float getDeviceScaleFactor() {
        return mWindow.getDisplay().getDipScale();
    }

    public void setOnTouchListener(OnTouchListener l) {
        mContentView.setOnTouchListener(l);
    }

    public void scrollTo(int x, int y) {
        mContentView.scrollTo(x, y);
    }

    public void scrollBy(int x, int y) {
        mContentView.scrollBy(x, y);
    }

    public int computeHorizontalScrollRange() {
        if (mContentView != null) {
            return mContentView.computeHorizontalScrollRangeDelegate();
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        if (mContentView != null) {
            return mContentView.computeHorizontalScrollOffsetDelegate();
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (mContentView != null) {
            return mContentView.computeVerticalScrollRangeDelegate();
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (mContentView != null) {
            return mContentView.computeVerticalScrollOffsetDelegate();
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (mContentView != null) {
            return mContentView.computeVerticalScrollExtentDelegate();
        }
        return 0;
    }

    // --------------------------------------------------------------------------------------------
    private class XWalkIoThreadClientImpl extends XWalkContentsIoThreadClient {
        // All methods are called on the IO thread.

        @Override
        public int getCacheMode() {
            return mSettings.getCacheMode();
        }

        @Override
        public boolean shouldBlockContentUrls() {
            return !mSettings.getAllowContentAccess();
        }

        @Override
        public boolean shouldBlockFileUrls() {
            return !mSettings.getAllowFileAccess();
        }

        @Override
        public boolean shouldBlockNetworkLoads() {
            return mSettings.getBlockNetworkLoads();
        }

        @Override
        public boolean shouldAcceptThirdPartyCookies() {
            return mSettings.getAcceptThirdPartyCookies();
        }

        @Override
        public XWalkContentsBackgroundThreadClient getBackgroundThreadClient() {
            return mBackgroundThreadClient;
        }
    }

    private class BackgroundThreadClientImpl extends XWalkContentsBackgroundThreadClient {
        // All methods are called on the background thread.

        @Override
        public XWalkWebResourceResponse shouldInterceptRequest(
                XWalkContentsClient.XWalkWebResourceRequest request) {
            String url = request.url;
            XWalkWebResourceResponse webResourceResponse = null;
//            // Return the response directly if the url is default video poster url.
//            webResourceResponse = mDefaultVideoPosterRequestHandler.shouldInterceptRequest(url);
//            if (webResourceResponse != null) return webResourceResponse;
//            
            webResourceResponse = mContentsClientBridge.shouldInterceptRequest(request);

            if (webResourceResponse == null) {
                mContentsClientBridge.getCallbackHelper().postOnLoadResource(url);
            }
//
            if (webResourceResponse != null && webResourceResponse.getData() == null) {
                // In this case the intercepted URLRequest job will simulate an empty response
                // which doesn't trigger the onReceivedError callback. For WebViewClassic
                // compatibility we synthesize that callback.  http://crbug.com/180950
                // TODO(iotto): Fix postOnReceiveError
//                mContentsClientBridge.getCallbackHelper().postOnReceivedError(
//                        request,
//                        /* error description filled in by the glue layer */
//                        new AwContentsClient.AwWebResourceError());
                mContentsClientBridge.getCallbackHelper().postOnReceivedError(XWalkResourceClient.ERROR_UNKNOWN, null,
                        request.url);

            }
            return webResourceResponse;
        }
    }

    private class XWalkGeolocationCallback implements XWalkGeolocationPermissions.Callback {
        @Override
        public void invoke(final String origin, final boolean allow, final boolean retain) {
            ThreadUtils.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (retain) {
                        if (allow) {
                            mGeolocationPermissions.allow(origin);
                        } else {
                            mGeolocationPermissions.deny(origin);
                        }
                    }
                    nativeInvokeGeolocationCallback(mNativeContent, allow, origin);
                }
            });
        }
    }

    @CalledByNative
    private void onGeolocationPermissionsShowPrompt(String origin) {
        if (mNativeContent == 0)
            return;
        // Reject if geolocation is disabled, or the origin has a retained deny.
        if (!mSettings.getGeolocationEnabled()) {
            nativeInvokeGeolocationCallback(mNativeContent, false, origin);
            return;
        }
        // Allow if the origin has a retained allow.
        if (mGeolocationPermissions.hasOrigin(origin)) {
            nativeInvokeGeolocationCallback(mNativeContent,
                    mGeolocationPermissions.isOriginAllowed(origin), origin);
            return;
        }
        mContentsClientBridge.onGeolocationPermissionsShowPrompt(origin,
                new XWalkGeolocationCallback());
    }

    @CalledByNative
    public void onGeolocationPermissionsHidePrompt() {
        mContentsClientBridge.onGeolocationPermissionsHidePrompt();
    }

    public void enableRemoteDebugging() {
        // Chrome looks for "devtools_remote" pattern in the name of a unix
        // domain socket
        // to identify a debugging page
        final String socketName = mViewContext.getApplicationContext().getPackageName()
                + "_devtools_remote";
        if (mDevToolsServer == null) {
            mDevToolsServer = new XWalkDevToolsServer(socketName);
            mDevToolsServer.setRemoteDebuggingEnabled(true,
                    XWalkDevToolsServer.Security.ALLOW_SOCKET_ACCESS);
        }
    }

    void disableRemoteDebugging() {
        if (mDevToolsServer == null)
            return;

        if (mDevToolsServer.isRemoteDebuggingEnabled()) {
            mDevToolsServer.setRemoteDebuggingEnabled(false);
        }
        mDevToolsServer.destroy();
        mDevToolsServer = null;
    }

    public String getRemoteDebuggingUrl() {
        if (mDevToolsServer == null)
            return "";
        // devtools/page is hardcoded in devtools_http_handler_impl.cc
        // (kPageUrlPrefix)
        return "ws://" + mDevToolsServer.getSocketName() + "/devtools/page/" + devToolsAgentId();
    }

    @Override
    public void onKeyValueChanged(String key, XWalkPreferences.PreferenceValue value) {
        if (key == null)
            return;
        if (key.equals(XWalkPreferences.REMOTE_DEBUGGING)) {
            if (value.getBooleanValue())
                enableRemoteDebugging();
            else
                disableRemoteDebugging();
        } else if (key.equals(XWalkPreferences.ENABLE_JAVASCRIPT)) {
            if (mSettings != null) {
                mSettings.setJavaScriptEnabled(value.getBooleanValue());
            }
        } else if (key.equals(XWalkPreferences.JAVASCRIPT_CAN_OPEN_WINDOW)) {
            if (mSettings != null) {
                mSettings.setJavaScriptCanOpenWindowsAutomatically(value.getBooleanValue());
            }
        } else if (key.equals(XWalkPreferences.ALLOW_UNIVERSAL_ACCESS_FROM_FILE)) {
            if (mSettings != null) {
                mSettings.setAllowUniversalAccessFromFileURLs(value.getBooleanValue());
            }
        } else if (key.equals(XWalkPreferences.SUPPORT_MULTIPLE_WINDOWS)) {
            if (mSettings != null) {
                mSettings.setSupportMultipleWindows(value.getBooleanValue());
            }
        } else if (key.equals(XWalkPreferences.SPATIAL_NAVIGATION)) {
            if (mSettings != null) {
                mSettings.setSupportSpatialNavigation(value.getBooleanValue());
            }
        }
    }

/*    public void setZOrderOnTop(boolean onTop) {
        if (mContentViewRenderView == null)
            return;
        mContentViewRenderView.setZOrderOnTop(onTop);
    }
*/

    // TODO(iotto) : Fix the Zoom
    public boolean zoomIn() {
        if (mNativeContent == 0)
            return false;
//        return mContentViewCore.zoomIn();
        return false;
    }

    public boolean zoomOut() {
        if (mNativeContent == 0)
            return false;
//        return mContentViewCore.zoomOut();
        return false;
    }

    public void zoomBy(float delta) {
        if (mNativeContent == 0)
            return;
        if (delta < 0.01f || delta > 100.0f) {
            throw new IllegalStateException("zoom delta value outside [0.01, 100] range.");
        }
//        mContentViewCore.pinchByDelta(delta);
    }

    public boolean canZoomIn() {
        if (mNativeContent == 0)
            return false;
//        return mContentViewCore.canZoomIn();
        return false;
    }

    public boolean canZoomOut() {
        if (mNativeContent == 0)
            return false;
//        return mContentViewCore.canZoomOut();
        return false;
    }
    // ****** End of ZOOM ***************

    /**
     * @see android.webkit.WebView#clearFormData()
     */
    public void hideAutofillPopup() {
        if (mNativeContent == 0)
            return;
        if (mIsLoaded == false) {
            mXWalkView.post(new Runnable() {
                @Override
                public void run() {
                    hideAutofillPopup();
                }
            });
            return;
        }

        if (mXWalkAutofillClient != null) {
            mXWalkAutofillClient.hideAutofillPopup();
        }
    }

    // It is only used for SurfaceView.
    public void setVisibility(int visibility) {
        SurfaceView surfaceView = mContentViewRenderView.getSurfaceView();
        if (surfaceView == null)
            return;
        surfaceView.setVisibility(visibility);
    }

    @CalledByNative
    private void setXWalkAutofillClient(XWalkAutofillClientAndroid client) {
        mXWalkAutofillClient = client;
        client.init(mViewContext);
    }

    public void clearSslPreferences() {
        if (mNativeContent == 0)
            return;
        mNavigationController.clearSslPreferences();
    }

    public void clearClientCertPreferences(Runnable callback) {
        if (mNativeContent == 0)
            return;
        mContentsClientBridge.clearClientCertPreferences(callback);
    }

    public SslCertificate getCertificate() {
        if (mNativeContent == 0)
            return null;
        return SslUtil.getCertificateFromDerBytes(nativeGetCertificate(mNativeContent));
    }

    /**
     * @return
     */
    public SslCertificate[] getCertificateChain() {
        if (mNativeContent == 0)
            return null;
        // TODO implement
        byte[][] d = nativeGetCertificateChain(mNativeContent);
        if (d == null || d.length == 0) {
            return null;
        }

        SslCertificate[] retVal = new SslCertificate[d.length];

        for (int i = 0; i < d.length; i++) {
            retVal[i] = SslUtil.getCertificateFromDerBytes(d[i]);
        }

        return retVal;
    }

    public boolean hasPermission(final String permission) {
        if (mNativeContent == 0)
            return false;
        return mWindow.hasPermission(permission);
    }

    public void setFindListener(XWalkFindListener listener) {
        if (mNativeContent == 0)
            return;
        mContentsClientBridge.setFindListener(listener);
    }

    public void findAllAsync(String searchString) {
        if (mNativeContent == 0)
            return;
        nativeFindAllAsync(mNativeContent, searchString);
    }

    public void findNext(boolean forward) {
        if (mNativeContent == 0)
            return;
        nativeFindNext(mNativeContent, forward);
    }

    public void clearMatches() {
        if (mNativeContent == 0)
            return;
        nativeClearMatches(mNativeContent);
    }

    public String getCompositingSurfaceType() {
        if (mNativeContent == 0)
            return null;
        return mAnimated ? "TextureView" : "SurfaceView";
    }

    @CalledByNative
    public void onFindResultReceived(int activeMatchOrdinal, int numberOfMatches,
                                     boolean isDoneCounting) {
        mContentsClientBridge.onFindResultReceived(activeMatchOrdinal, numberOfMatches,
                isDoneCounting);
    }

    @CalledByNative
    public void onOpenDnsSettings(final String failedUrl) {
        mContentsClientBridge.onOpenDnsSettings(failedUrl);
    }

    public void setOverlayVideoMode(boolean enabled) {
        if (mContentViewRenderView != null) {
            mContentViewRenderView.setOverlayVideoMode(enabled);
        }
    }

    //TODO(iotto): removed; checkout ActivityContentVideoViewEmbedder
//    public ContentVideoViewEmbedder getContentVideoViewEmbedder() {
//        return new ActivityContentVideoViewEmbedder((Activity) mViewContext) {
//            @Override
//            public void enterFullscreenVideo(View view, boolean isVideoLoaded) {
//                super.enterFullscreenVideo(view, isVideoLoaded);
//                if (mContentViewRenderView != null) {
//                    mContentViewRenderView.setOverlayVideoMode(true);
//                }
//            }
//
//            @Override
//            public void exitFullscreenVideo() {
//                super.exitFullscreenVideo();
//                if (mContentViewRenderView != null) {
//                    mContentViewRenderView.setOverlayVideoMode(false);
//                }
//            }
//        };
//
//    }

    @CalledByNative
    public int getZoneId() {
        return zoneId;
    }

    @CalledByNative
    public int getTabId() {
        return tabId;
    }

    private native long nativeInit();
    private static native void nativeUpdateDefaultLocale(String locale, String localeList);
    private static native void nativeDestroy(long nativeXWalkContent);

    private native WebContents nativeGetWebContents(long nativeXWalkContent);

    private native long nativeReleasePopupXWalkContent(long nativeXWalkContent);

    private native void nativeSetJavaPeers(long nativeXWalkContent, XWalkContent xwalkContent,
                                           XWalkWebContentsDelegateAdapter xwalkContentsDelegate,
                                           XWalkContentsClientBridge contentsClientBridge,
                                           XWalkContentsIoThreadClient ioThreadClient,
                                           InterceptNavigationDelegate navigationInterceptionDelegate);

    private native void nativeClearCache(long nativeXWalkContent, boolean includeDiskFiles);

    private native void nativeClearCacheForSingleFile(long nativeXWalkContent, String url);

    private native String nativeDevToolsAgentId(long nativeXWalkContent);

    private native String nativeGetVersion(long nativeXWalkContent);

    private static native String nativeGetChromeVersion();

    private native void nativeSetJsOnlineProperty(long nativeXWalkContent, boolean networkUp);

    private native boolean nativeSetManifest(long nativeXWalkContent, String path, String manifest);

    private native int nativeGetRoutingID(long nativeXWalkContent);

    private native void nativeInvokeGeolocationCallback(long nativeXWalkContent, boolean value,
                                                        String requestingFrame);

    /****** MetaFS ********/
    private native int nativeSaveOldHistory(long nativeXWalkContent, byte[] state, final String id,
                                            final String key);

    private native int nativeSaveHistory(long nativeXWalkContent, String id, String key);

    private native int nativeRestoreHistory(long nativeXWalkContent, String id,
                                            String key);

    private native int nativeNukeHistory(long nativeXWalkContent, String id, String key);

    /******* end MetaFs **********/

    private native byte[] nativeGetState(long nativeXWalkContent);

    private native boolean nativeSetState(long nativeXWalkContent, byte[] state);

    private native void nativeSetBackgroundColor(long nativeXWalkContent, int color);

    private native void nativeSetOriginAccessWhitelist(long nativeXWalkContent, String url,
                                                       String patterns);

    private native void nativeRequestNewHitTestDataAt(long nativeXWalkContent, float x, float y,
                                                      float touchMajor);

    private native void nativeUpdateLastHitTestData(long nativeXWalkContent);

    private native byte[] nativeGetCertificate(long nativeXWalkContent);

    private native byte[][] nativeGetCertificateChain(long nativeXWalkContent);

    private native void nativeFindAllAsync(long nativeXWalkContent, String searchString);

    private native void nativeFindNext(long nativeXWalkContent, boolean forward);

    private native void nativeClearMatches(long nativeXWalkContent);

    private native void nativeCaptureBitmapWithParams(long nativeXWalkContent, float scale, Callback<Bitmap> callback);

    // inner classes
    private static class WebContentsInternalsHolder implements WebContents.InternalsHolder {
        private final WeakReference<XWalkContent> mXwalkContentsRef;

        private WebContentsInternalsHolder(XWalkContent xwalkContents) {
            mXwalkContentsRef = new WeakReference<>(xwalkContents);
        }

        @Override
        public void set(WebContentsInternals internals) {
            XWalkContent awContents = mXwalkContentsRef.get();
            if (awContents == null) {
                throw new IllegalStateException("AwContents should be available at this time");
            }
            awContents.mWebContentsInternals = internals;
        }

        @Override
        public WebContentsInternals get() {
            XWalkContent awContents = mXwalkContentsRef.get();
            return awContents == null ? null : awContents.mWebContentsInternals;
        }

        public boolean weakRefCleared() {
            return mXwalkContentsRef.get() == null;
        }
    }

    //--------------------------------------------------------------------------------------------
    // TODO(iotto): Implement or use the on in android_webview
//    private class XWalkGestureStateListener implements GestureStateListener {
//        @Override
//        public void onPinchStarted() {
//            // While it's possible to re-layout the view during a pinch gesture, the effect is very
//            // janky (especially that the page scale update notification comes from the renderer
//            // main thread, not from the impl thread, so it's usually out of sync with what's on
//            // screen). It's also quite expensive to do a re-layout, so we simply postpone
//            // re-layout for the duration of the gesture. This is compatible with what
//            // WebViewClassic does.
//            mLayoutSizer.freezeLayoutRequests();
//        }
//
//        @Override
//        public void onPinchEnded() {
//            mLayoutSizer.unfreezeLayoutRequests();
//        }
//
//        @Override
//        public void onScrollUpdateGestureConsumed() {
//            mScrollAccessibilityHelper.postViewScrolledAccessibilityEventCallback();
//            mZoomControls.invokeZoomPicker();
//        }
//
//        @Override
//        public void onScrollStarted(int scrollOffsetY, int scrollExtentY) {
//            mZoomControls.invokeZoomPicker();
//        }
//
//        @Override
//        public void onScaleLimitsChanged(float minPageScaleFactor, float maxPageScaleFactor) {
//            mZoomControls.updateZoomControls();
//        }
//
//        @Override
//        public void onScrollOffsetOrExtentChanged(int scrollOffsetY, int scrollExtentY) {
//            mZoomControls.updateZoomControls();
//        }
//    }
}