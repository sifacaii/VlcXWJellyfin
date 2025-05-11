// Copyright (c) 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.pakdata.xwalk.refactor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import android.webkit.WebSettings;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.ThreadUtils;
import org.chromium.content_public.browser.WebContents;

/**
 * Settings for single XWalkView object
 */
@JNINamespace("xwalk")
public class XWalkSettings {
    /**
     * This enum corresponds to WebSettings.LayoutAlgorithm.
     *
     * @since 6.0
     */
    public enum LayoutAlgorithmInternal {
        NORMAL, SINGLE_COLUMN, NARROW_COLUMNS, TEXT_AUTOSIZING
    }

    /**
     * Default cache usage mode. If the navigation type doesn't impose any specific behavior, use
     * cached resources when they are available and not expired, otherwise load resources from the
     * network. Use with {@link #setCacheMode}.
     *
     * @since 7.0
     */
    public static final int LOAD_DEFAULT = -1;

    /**
     * Use cached resources when they are available, even if they have expired. Otherwise load
     * resources from the network. Use with {@link #setCacheMode}.
     *
     * @since 7.0
     */
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;

    /**
     * Don't use the cache, load from the network. Use with {@link #setCacheMode}.
     *
     * @since 7.0
     */
    public static final int LOAD_NO_CACHE = 2;

    /**
     * Don't use the network, load from the cache. Use with {@link #setCacheMode}.
     *
     * @since 7.0
     */
    public static final int LOAD_CACHE_ONLY = 3;

    private static final String TAG = "XWalkSettings";

    // This class must be created on the UI thread. Afterwards, it can be
    // used from any thread. Internally, the class uses a message queue
    // to call native code on the UI thread only.

    // Lock to protect all settings.
    private final Object mXWalkSettingsLock = new Object();

    private final Context mContext;

    private boolean mViewPortMetaEnabled = true;
    private boolean mAllowScriptsToCloseWindows = true;
    private boolean mLoadsImagesAutomatically = true;
    private boolean mImagesEnabled = true;
    private boolean mJavaScriptEnabled = true;
    private boolean mAllowUniversalAccessFromFileURLs;// = false;
    private boolean mAllowFileAccessFromFileURLs;// = false;
    private boolean mJavaScriptCanOpenWindowsAutomatically = true;
    private int mCacheMode = WebSettings.LOAD_DEFAULT;
    private boolean mSupportMultipleWindows;// = false;
    private boolean mAppCacheEnabled;// = false;
    private boolean mDomStorageEnabled = true;
    private boolean mDatabaseEnabled = true;
    private boolean mUseWideViewport;// = false;
    private boolean mZeroLayoutHeightDisablesViewportQuirk;
    private boolean mForceZeroLayoutHeight;
    private boolean mLoadWithOverviewMode;// = false;
    private boolean mMediaPlaybackRequiresUserGesture = true;
    private String mDefaultVideoPosterURL;
    private final boolean mPasswordEchoEnabled;
    // Although this bit is stored on AwSettings it is actually controlled via the CookieManager.
    private boolean mAcceptThirdPartyCookies;

    // Not accessed by the native side.
    private boolean mBlockNetworkLoads; // Default depends on permission of embedding APK.
    private boolean mAllowContentUrlAccess = true;
    private boolean mAllowFileUrlAccess = true;
    private boolean mShouldFocusFirstNode = true;
    private boolean mGeolocationEnabled = true;
    private String mUserAgent;
    private String mAcceptLanguages;

    private final boolean mSupportLegacyQuirks;
    private final boolean mAllowEmptyDocumentPersistence;
    private final boolean mAllowGeolocationOnInsecureOrigins;
    private final boolean mDoNotUpdateSelectionOnMutatingSelectionRange;

    // Protects access to settings global fields.
    private static final Object sGlobalContentSettingsLock = new Object();
    // For compatibility with the legacy WebView, we can only enable AppCache when the path is
    // provided. However, we don't use the path, so we just check if we have received it from the
    // client.
    private static boolean sAppCachePathIsSet;// = false;

    // The native side of this object.
    private long mNativeXWalkSettings;// = 0;

    // A flag to avoid sending superfluous synchronization messages.
    private boolean mIsUpdateWebkitPrefsMessagePending;// = false;
    // Custom handler that queues messages to call native code on the UI thread.
    private final EventHandler mEventHandler;

    private static final int MINIMUM_FONT_SIZE = 1;
    private static final int MAXIMUM_FONT_SIZE = 72;
    private int mDefaultFontSize = 16;
    private int mDefaultFixedFontSize = 13;

    private boolean mAutoCompleteEnabled = true;

    private float mInitialPageScalePercent;// = 0;
    private double mDIPScale = 1.0;
    private int mTextSizePercent = 100;
    private ZoomSupportChangeListener mZoomChangeListener;
    private boolean mSupportZoom = true;
    private boolean mBuiltInZoomControls;// = false;
    private boolean mDisplayZoomControls = true;

    private boolean mSpatialNavigationEnabled;
    private boolean mEnableSupportedHardwareAcceleratedFeatures = true; // TODO(iotto): check and set
    private boolean mFullscreenSupported = true;
    private boolean mQuirksModeEnabled;// = false;

    private LayoutAlgorithmInternal mLayoutAlgorithm = LayoutAlgorithmInternal.NARROW_COLUMNS;

    static class LazyDefaultUserAgent {
        private static final String sInstance = nativeGetDefaultUserAgent();
    }

    // Class to handle messages to be processed on the UI thread.
    @SuppressLint("HandlerLeak")
    private class EventHandler {
        // Message id for running a Runnable with mXWalkSettingsLock held.
        private static final int RUN_RUNNABLE_BLOCKING = 0;

        // Actual UI thread handler
        private Handler mHandler;

        // Synchronization flag.
        private boolean mSynchronizationPending;

        EventHandler() {
        }

        @SuppressLint("HandlerLeak")
        void bindUiThread() {
            if (mHandler != null) return;
            mHandler = new Handler(ThreadUtils.getUiThreadLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case RUN_RUNNABLE_BLOCKING:
                            synchronized (mXWalkSettingsLock) {
                                if (mNativeXWalkSettings != 0) {
                                    ((Runnable) msg.obj).run();
                                }
                                mSynchronizationPending = false;
                                mXWalkSettingsLock.notifyAll();
                            }
                            break;
                    }
                }
            };
        }

        void runOnUiThreadBlockingAndLocked(Runnable r) {
            assert Thread.holdsLock(mXWalkSettingsLock);
            if (mHandler == null)
                return;
            if (ThreadUtils.runningOnUiThread()) {
                r.run();
            } else {
                assert !mSynchronizationPending;
                mSynchronizationPending = true;
                mHandler.sendMessage(Message.obtain(null, RUN_RUNNABLE_BLOCKING, r));
                try {
                    while (mSynchronizationPending) {
                        mXWalkSettingsLock.wait();
                    }
                } catch (InterruptedException e) {
                    Log.e(TAG, "Interrupted waiting a Runnable to complete", e);
                    mSynchronizationPending = false;
                }
            }
        }

        void maybePostOnUiThread(Runnable r) {
            if (mHandler != null) {
                mHandler.post(r);
            }
        }

        void updateWebkitPreferencesLocked() {
            runOnUiThreadBlockingAndLocked(() -> updateWebkitPreferencesOnUiThreadLocked());
        }

        void updateCookiePolicyLocked() {
            runOnUiThreadBlockingAndLocked(() -> updateCookiePolicyOnUiThreadLocked());
        }
    }

    public interface ZoomSupportChangeListener {
        public void onGestureZoomSupportChanged(
                boolean supportsDoubleTapZoom, boolean supportsMultiTouchZoom);
    }

    public XWalkSettings(Context context, WebContents webContents,
                         boolean isAccessFromFileURLsGrantedByDefault) {
        ThreadUtils.assertOnUiThread();
        mContext = context;
        synchronized (mXWalkSettingsLock) {
            mBlockNetworkLoads = mContext.checkPermission(
                    android.Manifest.permission.INTERNET,
                    Process.myPid(),
                    Process.myUid()) != PackageManager.PERMISSION_GRANTED;

            if (isAccessFromFileURLsGrantedByDefault) {
                mAllowUniversalAccessFromFileURLs = true;
                mAllowFileAccessFromFileURLs = true;
            }

            mUserAgent = LazyDefaultUserAgent.sInstance;

            // Respect the system setting for password echoing.
            mPasswordEchoEnabled = Settings.System.getInt(context.getContentResolver(),
                    Settings.System.TEXT_SHOW_PASSWORD, 1) == 1;

            mEventHandler = new EventHandler();

            final int appTargetSdkVersion = mContext.getApplicationInfo().targetSdkVersion;

            mSupportLegacyQuirks = appTargetSdkVersion < Build.VERSION_CODES.KITKAT;
            mAllowEmptyDocumentPersistence = appTargetSdkVersion <= Build.VERSION_CODES.M;
            mAllowGeolocationOnInsecureOrigins = appTargetSdkVersion <= Build.VERSION_CODES.M;
            mDoNotUpdateSelectionOnMutatingSelectionRange = appTargetSdkVersion <= Build.VERSION_CODES.M;

            // Best-guess a sensible initial value based on the features supported on the device.
            mSpatialNavigationEnabled = !context.getPackageManager().hasSystemFeature(
                    PackageManager.FEATURE_TOUCHSCREEN);
        }
        setWebContents(webContents);
    }

    void setWebContents(WebContents webContents) {
        synchronized (mXWalkSettingsLock) {
            if (mNativeXWalkSettings != 0) {
                nativeDestroy(mNativeXWalkSettings);
                assert mNativeXWalkSettings == 0;
            }
            if (webContents != null) {
                mEventHandler.bindUiThread();
                mNativeXWalkSettings = nativeInit(webContents);
                nativeUpdateEverythingLocked(mNativeXWalkSettings);
            }
        }
    }

    @CalledByNative
    private void nativeXWalkSettingsGone(long nativeXWalkSettings) {
        assert mNativeXWalkSettings != 0 && mNativeXWalkSettings == nativeXWalkSettings;
        mNativeXWalkSettings = 0;
    }

    public void setAllowScriptsToCloseWindows(boolean allow) {
        synchronized (mXWalkSettingsLock) {
            if (mAllowScriptsToCloseWindows != allow) {
                mAllowScriptsToCloseWindows = allow;
            }
        }
    }

    public boolean getAllowScriptsToCloseWindows() {
        synchronized (mXWalkSettingsLock) {
            return mAllowScriptsToCloseWindows;
        }
    }

    /**
     * Overrides the way the cache is used. The way the cache is used is based on the navigation
     * type. For a normal page load, the cache is checked and content is re-validated as needed.
     * When navigating back, content is not revalidated, instead the content is just retrieved from
     * the cache. This method allows the client to override this behavior by specifying one of
     * {@link #LOAD_DEFAULT}, {@link #LOAD_CACHE_ELSE_NETWORK}, {@link #LOAD_NO_CACHE} or
     * {@link #LOAD_CACHE_ONLY}. The default value is {@link #LOAD_DEFAULT}.
     *
     * @param mode the mode to use
     * @since 7.0
     */
    public void setCacheMode(int mode) {
        synchronized (mXWalkSettingsLock) {
            if (mCacheMode != mode) {
                mCacheMode = mode;
            }
        }
    }

    /**
     * Gets the current setting for overriding the cache mode.
     *
     * @return the current setting for overriding the cache mode
     * @see #setCacheMode
     * @since 7.0
     */
    public int getCacheMode() {
        synchronized (mXWalkSettingsLock) {
            return mCacheMode;
        }
    }

    /**
     * Sets whether the XWalkView should not load resources from the network. Use
     * {@link #setBlockNetworkImage} to only avoid loading image resources. Note that if the value
     * of this setting is changed from true to false, network resources referenced by content
     * currently displayed by the XWalkView are not fetched until
     * {@link org.xwalk.core.XWalkView#reload} is called. If the application does not have the
     * {@link android.Manifest.permission#INTERNET} permission, attempts to set a value of false
     * will cause a {@link java.lang.SecurityException} to be thrown. The default value is false if
     * the application has the {@link android.Manifest.permission#INTERNET} permission, otherwise it
     * is true.
     *
     * @param flag whether the XWalkView should not load any resources from the network
     * @see org.xwalk.core.XWalkView#reload
     * @since 7.0
     */
    public void setBlockNetworkLoads(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (!flag && mContext.checkPermission(
                    android.Manifest.permission.INTERNET,
                    Process.myPid(),
                    Process.myUid()) != PackageManager.PERMISSION_GRANTED) {
                throw new SecurityException("Permission denied - " +
                        "application missing INTERNET permission");
            }
            mBlockNetworkLoads = flag;
        }
    }

    /**
     * Gets whether the XWalkView does not load any resources from the network.
     *
     * @return true if the XWalkView does not load any resources from the network
     * @see #setBlockNetworkLoads
     * @since 7.0
     */
    public boolean getBlockNetworkLoads() {
        synchronized (mXWalkSettingsLock) {
            return mBlockNetworkLoads;
        }
    }

    /**
     * Enable/disable third party cookies for an AwContents
     * @param accept true if we should accept third party cookies
     */
    public void setAcceptThirdPartyCookies(boolean accept) {
        synchronized (mXWalkSettingsLock) {
            mAcceptThirdPartyCookies = accept;
            mEventHandler.updateCookiePolicyLocked();
        }
    }

    /**
     * Return whether third party cookies are enabled for an AwContents
     * @return true if accept third party cookies
     */
    public boolean getAcceptThirdPartyCookies() {
        synchronized (mXWalkSettingsLock) {
            return mAcceptThirdPartyCookies;
        }
    }

    @CalledByNative
    private boolean getAcceptThirdPartyCookiesLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mAcceptThirdPartyCookies;
    }

    /**
     * Enables or disables file access within XWalkView. File access is enabled by default. Note
     * that this enables or disables file system access only. Assets and resources are still
     * accessible using file:///android_asset and file:///android_res.
     *
     * @param allow whether file access is allowed
     * @since 7.0
     */
    public void setAllowFileAccess(boolean allow) {
        synchronized (mXWalkSettingsLock) {
            if (mAllowFileUrlAccess != allow) {
                mAllowFileUrlAccess = allow;
            }
        }
    }

    /**
     * Gets whether this XWalkView supports file access.
     *
     * @see #setAllowFileAccess
     * @return true if this XWalkView supports file access.
     * @since 7.0
     */
    @CalledByNative
    public boolean getAllowFileAccess() {
        synchronized (mXWalkSettingsLock) {
            return mAllowFileUrlAccess;
        }
    }

    /**
     * Enables or disables content URL access within XWalkView. Content URL access allows XWalkView
     * to load content from a content provider installed in the system. The default is enabled.
     *
     * @param allow whether content URL access is allowed
     * @since 7.0
     */
    public void setAllowContentAccess(boolean allow) {
        synchronized (mXWalkSettingsLock) {
            if (mAllowContentUrlAccess != allow) {
                mAllowContentUrlAccess = allow;
            }
        }
    }

    /**
     * Gets whether this XWalkView supports content URL access.
     *
     * @see #setAllowContentAccess
     * @return true if this XWalkView supports content URL access.
     * @since 7.0
     */
    public boolean getAllowContentAccess() {
        synchronized (mXWalkSettingsLock) {
            return mAllowContentUrlAccess;
        }
    }

    /**
     * See {@link android.webkit.WebSettings#setGeolocationEnabled}.
     */
    public void setGeolocationEnabled(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mGeolocationEnabled != flag) {
                mGeolocationEnabled = flag;
            }
        }
    }

    /**
     * @return Returns if geolocation is currently enabled.
     */
    public boolean getGeolocationEnabled() {
        synchronized (mXWalkSettingsLock) {
            return mGeolocationEnabled;
        }
    }

    /**
     * Tells the XWalkView to enable JavaScript execution. <b>The default is true.</b> Note that the
     * default value of this setting is different with WebView.
     *
     * @param flag true if the XWalkView should execute JavaScript
     * @since 7.0
     */
    public void setJavaScriptEnabled(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mJavaScriptEnabled != flag) {
                mJavaScriptEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Sets whether JavaScript running in the context of a file scheme URL should be allowed to
     * access content from any origin. This includes access to content from other file scheme URLs.
     * See {@link #setAllowFileAccessFromFileURLs}. To enable the most restrictive, and therefore
     * secure policy, this setting should be disabled. Note that this setting affects only
     * JavaScript access to file scheme resources. Other access to such resources, for example, from
     * image HTML elements, is unaffected. The default value is false.
     *
     * @param flag whether JavaScript running in the context of a file scheme URL should be allowed
     *            to access content from any origin
     * @since 7.0
     */
    public void setAllowUniversalAccessFromFileURLs(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mAllowUniversalAccessFromFileURLs != flag) {
                mAllowUniversalAccessFromFileURLs = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Sets whether JavaScript running in the context of a file scheme URL should be allowed to
     * access content from other file scheme URLs. To enable the most restrictive, and therefore
     * secure policy, this setting should be disabled. Note that the value of this setting is
     * ignored if the value of {@link #getAllowUniversalAccessFromFileURLs} is true. Note too, that
     * this setting affects only JavaScript access to file scheme resources. Other access to such
     * resources, for example, from image HTML elements, is unaffected. The default value is false.
     *
     * @param flag whether JavaScript running in the context of a file scheme URL should be allowed
     *            to access content from other file scheme URLs
     * @since 7.0
     */
    public void setAllowFileAccessFromFileURLs(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mAllowFileAccessFromFileURLs != flag) {
                mAllowFileAccessFromFileURLs = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Sets whether the XWalkView should load image resources. Note that this method controls
     * loading of all images, including those embedded using the data URI scheme. Use
     * {@link #setBlockNetworkImage} to control loading only of images specified using network URI
     * schemes. Note that if the value of this setting is changed from false to true, all images
     * resources referenced by content currently displayed by the XWalkView are loaded
     * automatically. The default is true.
     *
     * @param flag whether the XWalkView should load image resources
     * @since 7.0
     */
    public void setLoadsImagesAutomatically(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mLoadsImagesAutomatically != flag) {
                mLoadsImagesAutomatically = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether the XWalkView loads image resources. This includes images embedded using the
     * data URI scheme.
     *
     * @return true if the XWalkView loads image resources
     * @see #setLoadsImagesAutomatically
     * @since 7.0
     */
    public boolean getLoadsImagesAutomatically() {
        synchronized (mXWalkSettingsLock) {
            return mLoadsImagesAutomatically;
        }
    }

    @CalledByNative
    private boolean getLoadsImagesAutomaticallyLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mLoadsImagesAutomatically;
    }

    /**
     * Sets whether the XWalkView should not load image resources from the network (resources
     * accessed via http and https URI schemes). Note that this method has no effect unless
     * {@link #getLoadsImagesAutomatically} returns true. Also note that disabling all network loads
     * using {@link #setBlockNetworkLoads} will also prevent network images from loading, even if
     * this flag is set to false. When the value of this setting is changed from true to false,
     * network images resources referenced by content currently displayed by the XWalkView are
     * fetched automatically. The default is false.
     *
     * @param flag whether the XWalkView should not load image resources from the network
     * @see #setBlockNetworkLoads
     * @since 7.0
     */
    public void setBlockNetworkImage(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mImagesEnabled == flag) {
                mImagesEnabled = !flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether the XWalkView does not load image resources from the network.
     *
     * @return true if the XWalkView does not load image resources from the network
     * @see #setBlockNetworkImage
     * @since 7.0
     */
    public boolean getBlockNetworkImage() {
        synchronized (mXWalkSettingsLock) {
            return !mImagesEnabled;
        }
    }

    @CalledByNative
    private boolean getImagesEnabledLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mImagesEnabled;
    }

    /**
     * Gets whether JavaScript is enabled.
     *
     * @return true if JavaScript is enabled
     * @see #setJavaScriptEnabled
     * @since 7.0
     */
    public boolean getJavaScriptEnabled() {
        synchronized (mXWalkSettingsLock) {
            return mJavaScriptEnabled;
        }
    }

    @CalledByNative
    private boolean getJavaScriptEnabledLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mJavaScriptEnabled;
    }
    /**
     * Gets whether JavaScript running in the context of a file scheme URL can access content from
     * any origin. This includes access to content from other file scheme URLs.
     *
     * @return whether JavaScript running in the context of a file scheme URL can access content
     *         from any origin
     * @see #setAllowUniversalAccessFromFileURLs
     * @since 7.0
     */
    public boolean getAllowUniversalAccessFromFileURLs() {
        synchronized (mXWalkSettingsLock) {
            return mAllowUniversalAccessFromFileURLs;
        }
    }

    @CalledByNative
    private boolean getAllowUniversalAccessFromFileURLsLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mAllowUniversalAccessFromFileURLs;
    }

    /**
     * Gets whether JavaScript running in the context of a file scheme URL can access content from
     * other file scheme URLs.
     *
     * @return whether JavaScript running in the context of a file scheme URL can access content
     *         from other file scheme URLs
     * @see #setAllowFileAccessFromFileURLs
     * @since 7.0
     */
    public boolean getAllowFileAccessFromFileURLs() {
        synchronized (mXWalkSettingsLock) {
            return mAllowFileAccessFromFileURLs;
        }
    }

    @CalledByNative
    private boolean getAllowFileAccessFromFileURLsLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mAllowFileAccessFromFileURLs;
    }

    /**
     * Tells JavaScript to open windows automatically. This applies to the JavaScript function
     * window.open(). The default is true.
     *
     * @param flag true if JavaScript can open windows automatically
     * @since 7.0
     */
    public void setJavaScriptCanOpenWindowsAutomatically(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mJavaScriptCanOpenWindowsAutomatically != flag) {
                mJavaScriptCanOpenWindowsAutomatically = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether JavaScript can open windows automatically.
     *
     * @return true if JavaScript can open windows automatically during window.open()
     * @see #setJavaScriptCanOpenWindowsAutomatically
     * @since 7.0
     */
    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        synchronized (mXWalkSettingsLock) {
            return mJavaScriptCanOpenWindowsAutomatically;
        }
    }

    @CalledByNative
    private boolean getJavaScriptCanOpenWindowsAutomaticallyLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mJavaScriptCanOpenWindowsAutomatically;
    }

    /**
     * Sets whether the XWalkView supports multiple windows. If set to true,
     * {@link XWalkUIClient#onCreateWindowRequested} must be implemented by the host application.
     * The default is false.
     *
     * @param support whether to suport multiple windows
     * @since 7.0
     */
    public void setSupportMultipleWindows(boolean support) {
        synchronized (mXWalkSettingsLock) {
            if (mSupportMultipleWindows != support) {
                mSupportMultipleWindows = support;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether the XWalkView supports multiple windows.
     *
     * @return true if the XWalkView supports multiple windows
     * @see #setSupportMultipleWindows
     * @since 7.0
     */
    public boolean supportMultipleWindows() {
        synchronized (mXWalkSettingsLock) {
            return mSupportMultipleWindows;
        }
    }

    @CalledByNative
    private boolean getSupportMultipleWindowsLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mSupportMultipleWindows;
    }

    @CalledByNative
    private boolean getSupportLegacyQuirksLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mSupportLegacyQuirks;
    }

    @CalledByNative
    private boolean getAllowEmptyDocumentPersistenceLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mAllowEmptyDocumentPersistence;
    }

    @CalledByNative
    private boolean getAllowGeolocationOnInsecureOrigins() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mAllowGeolocationOnInsecureOrigins;
    }

    @CalledByNative
    private boolean getDoNotUpdateSelectionOnMutatingSelectionRange() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mDoNotUpdateSelectionOnMutatingSelectionRange;
    }

    /**
     * Sets whether the XWalkView should enable support for the "viewport" HTML meta tag or should
     * use a wide viewport. When the value of the setting is false, the layout width is always set
     * to the width of the XWalkView control in device-independent (CSS) pixels. When the value is
     * true and the page contains the viewport meta tag, the value of the width specified in the tag
     * is used. If the page does not contain the tag or does not provide a width, then a wide
     * viewport will be used.
     *
     * @param use whether to enable support for the viewport meta tag.
     * @since 6.0
     */
    public void setUseWideViewPort(boolean use) {
        synchronized (mXWalkSettingsLock) {
            if (mUseWideViewport != use) {
                mUseWideViewport = use;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether the XWalkView supports the "viewport" HTML meta tag or will use a wide viewport.
     *
     * @return true if the XWalkView supports the viewport meta tag.
     * @since 6.0
     */
    public boolean getUseWideViewPort() {
        synchronized (mXWalkSettingsLock) {
            return getUseWideViewportLocked();
        }
    }

    @CalledByNative
    private boolean getUseWideViewportLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mUseWideViewport;
    }

    /**
     * New in Tenta
     * @param enabled
     */
    public void setZeroLayoutHeightDisablesViewportQuirk(boolean enabled) {
        synchronized (mXWalkSettingsLock) {
            if (mZeroLayoutHeightDisablesViewportQuirk != enabled) {
                mZeroLayoutHeightDisablesViewportQuirk = enabled;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    public boolean getZeroLayoutHeightDisablesViewportQuirk() {
        synchronized (mXWalkSettingsLock) {
            return getZeroLayoutHeightDisablesViewportQuirkLocked();
        }
    }

    @CalledByNative
    private boolean getZeroLayoutHeightDisablesViewportQuirkLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mZeroLayoutHeightDisablesViewportQuirk;
    }

    /**
     * New in Tenta
     * @param enabled
     */
    public void setForceZeroLayoutHeight(boolean enabled) {
        synchronized (mXWalkSettingsLock) {
            if (mForceZeroLayoutHeight != enabled) {
                mForceZeroLayoutHeight = enabled;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    public boolean getForceZeroLayoutHeight() {
        synchronized (mXWalkSettingsLock) {
            return getForceZeroLayoutHeightLocked();
        }
    }

    @CalledByNative
    private boolean getForceZeroLayoutHeightLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mForceZeroLayoutHeight;
    }

    /**
     * See {@link android.webkit.WebSettings#setAppCacheEnabled}.
     */
    public void setAppCacheEnabled(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mAppCacheEnabled != flag) {
                mAppCacheEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link android.webkit.WebSettings#setAppCachePath}.
     */
    public void setAppCachePath(String path) {
        boolean needToSync = false;
        synchronized (sGlobalContentSettingsLock) {
            // AppCachePath can only be set once.
            if (!sAppCachePathIsSet && path != null && !path.isEmpty()) {
                sAppCachePathIsSet = true;
                needToSync = true;
            }
        }
        // The obvious problem here is that other XWalkViews will not be updated,
        // until they execute synchronization from Java to the native side.
        // But this is the same behaviour as it was in the legacy XWalkView.
        if (needToSync) {
            synchronized (mXWalkSettingsLock) {
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether Application Cache is enabled.
     *
     * @return true if Application Cache is enabled
     * @hide
     */
    @CalledByNative
    private boolean getAppCacheEnabledLocked() {
        // When no app cache path is set, use chromium default cache path.
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mAppCacheEnabled;

        // TODO(iotto): From AwSettings
//        assert Thread.holdsLock(mXWalkSettingsLock);
//        if (!mAppCacheEnabled) {
//            return false;
//        }
//        synchronized (sGlobalContentSettingsLock) {
//            return sAppCachePathIsSet;
//        }
    }

    /**
     * Sets whether the DOM storage API is enabled. The default value is true. Note that the default
     * value of this setting is different with WebView.
     *
     * @param flag true if the XWalkView should use the DOM storage API
     * @since 7.0
     */
    public void setDomStorageEnabled(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mDomStorageEnabled != flag) {
                mDomStorageEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether the DOM Storage APIs are enabled.
     *
     * @return true if the DOM Storage APIs are enabled
     * @see #setDomStorageEnabled
     * @since 7.0
     */
    public boolean getDomStorageEnabled() {
        synchronized (mXWalkSettingsLock) {
            return mDomStorageEnabled;
        }
    }

    @CalledByNative
    private boolean getDomStorageEnabledLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mDomStorageEnabled;
    }

    /**
     * Sets whether the database storage API is enabled. The default value is true, which is
     * different with WebView. This setting is global in effect, across all XWalkView instances in a
     * process. Note you should only modify this setting prior to making <b>any</b> XWalkView page
     * load within a given process, as the XWalkView implementation may ignore changes to this
     * setting after that point.
     *
     * @param flag true if the XWalkView should use the database storage API
     * @since 7.0
     */
    public void setDatabaseEnabled(boolean flag) {
        synchronized (mXWalkSettingsLock) {
            if (mDatabaseEnabled != flag) {
                mDatabaseEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether the database storage API is enabled.
     *
     * @return true if the database storage API is enabled
     * @since 7.0
     */
    public boolean getDatabaseEnabled() {
        synchronized (mXWalkSettingsLock) {
            return mDatabaseEnabled;
        }
    }

    @CalledByNative
    private boolean getDatabaseEnabledLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mDatabaseEnabled;
    }

    /**
     * Sets whether the XWalkView requires a user gesture to play media. The default is false, which
     * is different with WebView.
     *
     * @param require whether the XWalkView requires a user gesture to play media
     * @since 7.0
     */
    public void setMediaPlaybackRequiresUserGesture(boolean require) {
        synchronized (mXWalkSettingsLock) {
            if (mMediaPlaybackRequiresUserGesture != require) {
                mMediaPlaybackRequiresUserGesture = require;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether the XWalkView requires a user gesture to play media.
     *
     * @return true if the XWalkView requires a user gesture to play media
     * @see #setMediaPlaybackRequiresUserGesture
     * @since 7.0
     */
    public boolean getMediaPlaybackRequiresUserGesture() {
        synchronized (mXWalkSettingsLock) {
            return getMediaPlaybackRequiresUserGestureLocked();
        }
    }

    @CalledByNative
    private boolean getMediaPlaybackRequiresUserGestureLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mMediaPlaybackRequiresUserGesture;
    }

    /**
     * See {@link android.webkit.WebSettings#setDefaultVideoPosterURL}.
     */
    public void setDefaultVideoPosterURL(String url) {
        synchronized (mXWalkSettingsLock) {
            if (mDefaultVideoPosterURL != null && !mDefaultVideoPosterURL.equals(url) ||
                    mDefaultVideoPosterURL == null && url != null) {
                mDefaultVideoPosterURL = url;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link android.webkit.WebSettings#getDefaultVideoPosterURL}.
     */
    public String getDefaultVideoPosterURL() {
        synchronized (mXWalkSettingsLock) {
            return getDefaultVideoPosterURLLocked();
        }
    }

    @CalledByNative
    private String getDefaultVideoPosterURLLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mDefaultVideoPosterURL;
    }

    /**
     * @return returns the default User-Agent used by each ContentViewCore instance, i.e. unless
     *         overridden by {@link #setUserAgentString()}
     */
    public static String getDefaultUserAgent() {
        return LazyDefaultUserAgent.sInstance;
    }

    /**
     * Set the user agent of web page/app.
     *
     * @param userAgent the user agent string passed from client.
     * @since 6.0
     */
    public void setUserAgentString(String userAgent) {
        synchronized (mXWalkSettingsLock) {
            final String oldUserAgent = mUserAgent;
            if (userAgent == null || userAgent.length() == 0) {
                mUserAgent = LazyDefaultUserAgent.sInstance;
            } else {
                mUserAgent = userAgent;
            }
            if (!oldUserAgent.equals(mUserAgent)) {
                mEventHandler.runOnUiThreadBlockingAndLocked(new Runnable() {
                    @Override
                    public void run() {
                        if (mNativeXWalkSettings != 0) {
                            nativeUpdateUserAgent(mNativeXWalkSettings);
                        }
                    }
                });
            }
        }
    }

    public void setUserAgentMobile(boolean isMobile) {
        mViewPortMetaEnabled = isMobile;
    }

    /**
     * Get the user agent of web page/app.
     *
     * @return the XWalkView's user-agent string.
     * @since 6.0
     */
    public String getUserAgentString() {
        synchronized (mXWalkSettingsLock) {
            return mUserAgent;
        }
    }

    @CalledByNative
    private String getUserAgentLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mUserAgent;
    }

    @CalledByNative
    private void updateEverything() {
        synchronized (mXWalkSettingsLock) {
            nativeUpdateEverythingLocked(mNativeXWalkSettings);
        }
    }

    private void updateWebkitPreferencesOnUiThreadLocked() {
        assert mEventHandler.mHandler != null;
        ThreadUtils.assertOnUiThread();
        if (mNativeXWalkSettings != 0) {
            nativeUpdateWebkitPreferencesLocked(mNativeXWalkSettings);
        }
    }

    private void updateCookiePolicyOnUiThreadLocked() {
        assert mEventHandler.mHandler != null;
        ThreadUtils.assertOnUiThread();
        if (mNativeXWalkSettings != 0) {
            nativeUpdateCookiePolicyLocked(mNativeXWalkSettings);
        }
    }

    /**
     * Set the accept languages of XWalkView.
     *
     * @param acceptLanguages the accept languages string passed from client.
     * @since 6.0
     */
    public void setAcceptLanguages(final String acceptLanguages) {
        synchronized (mXWalkSettingsLock) {
            if (mAcceptLanguages != null && mAcceptLanguages.equals(acceptLanguages))
                return;
            mAcceptLanguages = acceptLanguages;
            mEventHandler.runOnUiThreadBlockingAndLocked(new Runnable() {
                @Override
                public void run() {
                    if (mNativeXWalkSettings != 0) {
                        nativeUpdateAcceptLanguages(mNativeXWalkSettings);
                    }
                }
            });
        }
    }

    public void updateAcceptLanguages() {
        synchronized (mXWalkSettingsLock) {
            mEventHandler.runOnUiThreadBlockingAndLocked(() -> {
                if (mNativeXWalkSettings != 0) {
                    nativeUpdateRendererPreferencesLocked(mNativeXWalkSettings);
                }
            });
        }
    }

    /**
     * Get the accept languages of XWalkView.
     *
     * @return the accept languages
     * @since 6.0
     */
    public String getAcceptLanguages() {
        synchronized (mXWalkSettingsLock) {
            return mAcceptLanguages;
        }
    }

    /**
     * Sets whether the XWalkView should save form data. The default is true.
     *
     * @param enable whether the XWalkView should save form data
     * @since 7.0
     */
    public void setSaveFormData(final boolean enable) {
        synchronized (mXWalkSettingsLock) {
            if (mAutoCompleteEnabled == enable)
                return;
            mAutoCompleteEnabled = enable;
            mEventHandler.runOnUiThreadBlockingAndLocked(new Runnable() {
                @Override
                public void run() {
                    if (mNativeXWalkSettings != 0) {
                        nativeUpdateFormDataPreferences(mNativeXWalkSettings);
                    }
                }
            });
        }
    }

    /**
     * Gets whether the XWalkView saves form data.
     *
     * @return whether the XWalkView saves form data
     * @see #setSaveFormData
     * @since 7.0
     */
    public boolean getSaveFormData() {
        synchronized (mXWalkSettingsLock) {
            return getSaveFormDataLocked();
        }
    }

    @CalledByNative
    private String getAcceptLanguagesLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mAcceptLanguages;
    }

    @CalledByNative
    private boolean getSaveFormDataLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mAutoCompleteEnabled;
    }

    public void setDIPScale(double dipScale) {
        synchronized (mXWalkSettingsLock) {
            mDIPScale = dipScale;
            // TODO(hengzhi.wu): This should also be synced over to native side, but right now
            // the setDIPScale call is always followed by a setWebContents() which covers this.
        }
    }

    /**
     * Sets the initial scale for this XWalkView.
     *
     * @param scaleInPercent the initial scale in percent.
     * @since 6.0
     */
    public void setInitialPageScale(final float scaleInPercent) {
        synchronized (mXWalkSettingsLock) {
            if (mInitialPageScalePercent == scaleInPercent)
                return;
            mInitialPageScalePercent = scaleInPercent;
            mEventHandler.runOnUiThreadBlockingAndLocked(new Runnable() {
                @Override
                public void run() {
                    if (mNativeXWalkSettings != 0) {
                        nativeUpdateInitialPageScale(mNativeXWalkSettings);
                    }
                }
            });
        }
    }

    @CalledByNative
    private float getInitialPageScalePercentLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mInitialPageScalePercent;
    }

    @CalledByNative
    private double getDIPScaleLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mDIPScale;
    }

    @CalledByNative
    private boolean getPasswordEchoEnabledLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mPasswordEchoEnabled;
    }

    /**
     * Sets the text zoom of the page in percent. The default is 100.
     *
     * @param textZoom the text zoom in percent.
     * @since 6.0
     */
    public void setTextZoom(final int textZoom) {
        synchronized (mXWalkSettingsLock) {
            if (mTextSizePercent == textZoom)
                return;
            mTextSizePercent = textZoom;
            mEventHandler.updateWebkitPreferencesLocked();
        }
    }

    /**
     * Gets the text zoom of the page in percent.
     *
     * @return the text zoom of the page in percent.
     * @since 6.0
     */
    public int getTextZoom() {
        synchronized (mXWalkSettingsLock) {
            return getTextSizePercentLocked();
        }
    }

    @CalledByNative
    private int getTextSizePercentLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mTextSizePercent;
    }

    private int clipFontSize(int size) {
        if (size < MINIMUM_FONT_SIZE) {
            return MINIMUM_FONT_SIZE;
        } else if (size > MAXIMUM_FONT_SIZE) {
            return MAXIMUM_FONT_SIZE;
        }
        return size;
    }

    /**
     * Sets the default font size. The default is 16.
     *
     * @param size non-negative integer between 1 and 72. Any number outside the specified range
     *            will be pinned.
     * @since 6.0
     */
    public void setDefaultFontSize(int size) {
        synchronized (mXWalkSettingsLock) {
            size = clipFontSize(size);
            if (mDefaultFontSize == size)
                return;
            mDefaultFontSize = size;
            mEventHandler.updateWebkitPreferencesLocked();
        }
    }

    /**
     * Gets the default font size.
     *
     * @return a non-negative integer between 1 and 72.
     * @since 6.0
     */
    public int getDefaultFontSize() {
        synchronized (mXWalkSettingsLock) {
            return mDefaultFontSize;
        }
    }

    /**
     * Sets the default fixed font size. The default is 16.
     *
     * @param size a non-negative integer between 1 and 72. Any number outside the specified range
     *            will be pinned.
     * @since 6.0
     */
    public void setDefaultFixedFontSize(int size) {
        synchronized (mXWalkSettingsLock) {
            size = clipFontSize(size);
            if (mDefaultFixedFontSize == size)
                return;
            mDefaultFixedFontSize = size;
            mEventHandler.updateWebkitPreferencesLocked();
        }
    }

    /**
     * Gets the default fixed font size.
     *
     * @return a non-negative integer between 1 and 72.
     * @since 6.0
     */
    public int getDefaultFixedFontSize() {
        synchronized (mXWalkSettingsLock) {
            return mDefaultFixedFontSize;
        }
    }

    public void setZoomListener(ZoomSupportChangeListener zoomChangeListener) {
        synchronized (mXWalkSettingsLock) {
            mZoomChangeListener = zoomChangeListener;
        }
    }

    private void onGestureZoomSupportChanged(
            final boolean supportsDoubleTapZoom, final boolean supportsMultiTouchZoom) {
        // Always post asynchronously here, to avoid doubling back onto the caller.
        mEventHandler.maybePostOnUiThread(new Runnable() {
            @Override
            public void run() {
                synchronized (mXWalkSettingsLock) {
                    if (mZoomChangeListener == null)
                        return;
                    mZoomChangeListener.onGestureZoomSupportChanged(
                            supportsDoubleTapZoom, supportsMultiTouchZoom);
                }
            }
        });
    }

    @CalledByNative
    private boolean supportsDoubleTapZoomLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mSupportZoom && mBuiltInZoomControls && mUseWideViewport;
    }

    private boolean supportsMultiTouchZoomLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mSupportZoom && mBuiltInZoomControls;
    }

    /**
     * Sets whether the XWalkView should support zooming using its on-screen zoom controls and
     * gestures. The particular zoom mechanisms that should be used can be set with
     * setBuiltInZoomControls(boolean). This setting does not affect zooming performed using the
     * zoomIn() and zoomOut() methods. The default is true.
     *
     * @param support whether the XWalkView should support zoom.
     * @since 6.0
     */
    public void setSupportZoom(boolean support) {
        synchronized (mXWalkSettingsLock) {
            if (mSupportZoom == support)
                return;
            mSupportZoom = support;
            onGestureZoomSupportChanged(
                    supportsDoubleTapZoomLocked(), supportsMultiTouchZoomLocked());
        }
    }

    /**
     * Gets whether the XWalkView supports zoom.
     *
     * @return true if the XWalkView supports zoom.
     * @since 6.0
     */
    public boolean supportZoom() {
        synchronized (mXWalkSettingsLock) {
            return mSupportZoom;
        }
    }

    /**
     * Sets whether the XWalkView should use its built-in zoom mechanisms. The built-in zoom
     * mechanisms comprise on-screen zoom controls, which are displayed over the XWalkView's
     * content, and the use of a pinch gesture to control zooming. Whether or not these on-screen
     * controls are displayed can be set with setDisplayZoomControls(boolean). The default is false.
     *
     * @param enabled whether the XWalkView should use its built-in zoom mechanisms.
     * @since 6.0
     */
    public void setBuiltInZoomControls(boolean enabled) {
        synchronized (mXWalkSettingsLock) {
            if (mBuiltInZoomControls == enabled)
                return;
            mBuiltInZoomControls = enabled;
            onGestureZoomSupportChanged(
                    supportsDoubleTapZoomLocked(), supportsMultiTouchZoomLocked());
        }
    }

    /**
     * Gets whether the zoom mechanisms built into XWalkView are being used.
     *
     * @return true if the zoom mechanisms built into XWalkView are being used.
     * @since 6.0
     */
    public boolean getBuiltInZoomControls() {
        synchronized (mXWalkSettingsLock) {
            return mBuiltInZoomControls;
        }
    }

    /**
     * Note: Just for test case. Gets whether the XWalkView supports multi touch zoom.
     *
     * @return true if the XWalkView supports multi touch zoom.
     */
    public boolean supportsMultiTouchZoomForTest() {
        synchronized (mXWalkSettingsLock) {
            return supportsMultiTouchZoomLocked();
        }
    }

    /**
     * Sets whether the XWalkView should support the spatial navigation, like a TV remote control.
     *
     * @param enable whether the XWalkView should support the spatial navigation.
     * @since 6.0
     */
    public void setSupportSpatialNavigation(boolean enable) {
        synchronized (mXWalkSettingsLock) {
            if (mSpatialNavigationEnabled == enable)
                return;
            mSpatialNavigationEnabled = enable;
            mEventHandler.updateWebkitPreferencesLocked();
        }
    }

    /**
     * Gets whether the XWalkView should support the spatial navigation.
     *
     * @return true if XWalkView support the spatial navigation.
     * @since 6.0
     */
    public boolean getSupportSpatialNavigation() {
        synchronized (mXWalkSettingsLock) {
            return mSpatialNavigationEnabled;
        }
    }

    @CalledByNative
    private boolean getSpatialNavigationLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mSpatialNavigationEnabled;
    }

    void setEnableSupportedHardwareAcceleratedFeatures(boolean enable) {
        synchronized (mXWalkSettingsLock) {
            if (mEnableSupportedHardwareAcceleratedFeatures != enable) {
                mEnableSupportedHardwareAcceleratedFeatures = enable;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    @CalledByNative
    private boolean getEnableSupportedHardwareAcceleratedFeaturesLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mEnableSupportedHardwareAcceleratedFeatures;
    }

    public void setFullscreenSupported(boolean supported) {
        synchronized (mXWalkSettingsLock) {
            if (mFullscreenSupported != supported) {
                mFullscreenSupported = supported;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    @CalledByNative
    private boolean getFullscreenSupportedLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mFullscreenSupported;
    }
    /**
     * Sets whether the XWalkView should support the quirks mode.
     *
     * @param enable whether the XWalkView should support the quirks mode.
     * @since 6.0
     */
    public void setSupportQuirksMode(boolean enable) {
        synchronized (mXWalkSettingsLock) {
            if (mQuirksModeEnabled == enable)
                return;
            mQuirksModeEnabled = enable;
            mEventHandler.updateWebkitPreferencesLocked();
        }
    }

    /**
     * Gets whether the XWalkView should support the quirks mode.
     *
     * @return true if XWalkView supports the quirks mode.
     * @since 6.0
     */
    public boolean getSupportQuirksMode() {
        synchronized (mXWalkSettingsLock) {
            return mQuirksModeEnabled;
        }
    }

    /**
     * Sets the underlying layout algorithm. This will cause a relayout of the XWalkView. The
     * default is NARROW_COLUMNS.
     *
     * @param la the layout algorithm to use.
     * @since 6.0
     */
    public void setLayoutAlgorithm(LayoutAlgorithmInternal la) {
        synchronized (mXWalkSettingsLock) {
            if (mLayoutAlgorithm == la)
                return;
            mLayoutAlgorithm = la;
            mEventHandler.updateWebkitPreferencesLocked();
        }
    }

    /**
     * Gets the current layout algorithm.
     *
     * @return the layout algorithm in use.
     * @since 6.0
     */
    public LayoutAlgorithmInternal getLayoutAlgorithm() {
        synchronized (mXWalkSettingsLock) {
            return mLayoutAlgorithm;
        }
    }

    @CalledByNative
    private boolean getTextAutosizingEnabledLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mLayoutAlgorithm == LayoutAlgorithmInternal.TEXT_AUTOSIZING;
    }

    /**
     * Sets whether the XWalkView loads pages in overview mode, that is, zooms out the content to
     * fit on screen by width. This setting is taken into account when the content width is greater
     * than the width of the XWalkView control, for example, when getUseWideViewPort() is enabled.
     * The default is false.
     *
     * @param overview whether this XWalkView loads pages in overview mode.
     * @since 7.0
     */
    public void setLoadWithOverviewMode(boolean overview) {
        synchronized (mXWalkSettingsLock) {
            if (mLoadWithOverviewMode == overview)
                return;
            mLoadWithOverviewMode = overview;
            mEventHandler.runOnUiThreadBlockingAndLocked(new Runnable() {
                @Override
                public void run() {
                    if (mNativeXWalkSettings != 0) {
                        mEventHandler.updateWebkitPreferencesLocked();
                        nativeResetScrollAndScaleState(mNativeXWalkSettings);
                    }
                }
            });
        }
    }

    /**
     * Gets whether this XWalkView loads pages in overview mode.
     *
     * @return whether this XWalkView loads pages in overview mode.
     * @since 7.0
     */
    public boolean getLoadWithOverviewMode() {
        synchronized (mXWalkSettingsLock) {
            return getLoadWithOverviewModeLocked();
        }
    }

    @CalledByNative
    private boolean getLoadWithOverviewModeLocked() {
        assert Thread.holdsLock(mXWalkSettingsLock);
        return mLoadWithOverviewMode;
    }

    @CalledByNative
    private void populateWebPreferences(long webPrefsPtr) {
        synchronized (mXWalkSettingsLock) {
            assert mNativeXWalkSettings != 0;
            nativePopulateWebPreferencesLocked(mNativeXWalkSettings, webPrefsPtr);
        }
    }

    private native long nativeInit(WebContents webContents);

    private native void nativeDestroy(long nativeXWalkSettings);

    private static native String nativeGetDefaultUserAgent();

    private native void nativePopulateWebPreferencesLocked(long nativeXWalkSettings, long webPrefsPtr);

    private native void nativeUpdateEverythingLocked(long nativeXWalkSettings);

    private native void nativeUpdateUserAgent(long nativeXWalkSettings);

    private native void nativeUpdateWebkitPreferencesLocked(long nativeXWalkSettings);

    private native void nativeUpdateRendererPreferencesLocked(long nativeXWalkSettings);

    private native void nativeUpdateCookiePolicyLocked(long nativeXWalkSettings);

    private native void nativeUpdateAcceptLanguages(long nativeXWalkSettings);

    private native void nativeUpdateFormDataPreferences(long nativeXWalkSettings);

    private native void nativeUpdateInitialPageScale(long nativeXWalkSettings);

    private native void nativeResetScrollAndScaleState(long nativeXWalkSettings);
}