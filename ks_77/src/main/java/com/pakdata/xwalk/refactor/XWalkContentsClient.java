// Copyright (c) 2012 The Chromium Authors. All rights reserved.
// Copyright (c) 2013 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.pakdata.xwalk.refactor;

import java.security.PrivateKey;
import java.util.HashMap;

import org.chromium.content_public.browser.NavigationHandle;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsObserver;
import org.chromium.net.NetError;

import com.pakdata.xwalk.refactor.CustomViewCallback;
import com.pakdata.xwalk.refactor.RewriteUrlValue;
import com.pakdata.xwalk.refactor.XWalkHttpAuthHandler;

import android.R.integer;
import android.content.pm.ActivityInfo;
import android.graphics.Picture;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;

/**
 * Base-class that a XWalkViewContents embedder derives from to receive callbacks. This extends
 * ContentViewClient, as in many cases we want to pass-thru ContentViewCore callbacks right to our
 * embedder, and this setup facilities that. For any other callbacks we need to make transformations
 * of (e.g. adapt parameters or perform filtering) we can provide final overrides for methods here,
 * and then introduce new abstract methods that the our own client must implement. i.e.: all methods
 * in this class should either be final, or abstract.
 */
abstract class XWalkContentsClient {

    private static final String TAG = "XWalkContentsClient";
    private final XWalkContentsClientCallbackHelper mCallbackHelper = new XWalkContentsClientCallbackHelper(
            this);

    private XWalkWebContentsObserver mWebContentsObserver;

    private double mDIPScale;

    public class XWalkWebContentsObserver extends WebContentsObserver {
        public XWalkWebContentsObserver(WebContents webContents) {
            super(webContents);
        }

        @Override
        public void didChangeThemeColor(int color) {
            boolean themecolor = XWalkPreferences.getValue(
                    XWalkPreferences.ENABLE_THEME_COLOR);
            if (themecolor)
                onDidChangeThemeColor(color);
        }

        @Override
        public void didStopLoading(String url) {
            mCallbackHelper.postOnPageFinished(url);
        }

        @Override
        public void didFailLoad(boolean isMainFrame, int errorCode,
                                String description, String failingUrl) {
            if (errorCode == NetError.ERR_ABORTED || !isMainFrame) {
                // This error code is generated for the following reasons:
                // - XWalkViewInternal.stopLoading is called,
                // - the navigation is intercepted by the embedder via shouldOverrideNavigation.
                //
                // The XWalkViewInternal does not notify the embedder of these situations using this
                // error code with the XWalkClient.onReceivedError callback. What's more,
                // the XWalkViewInternal does not notify the embedder of sub-frame failures.
                return;
            }
            onReceivedError(ErrorCodeConversionHelper.convertErrorCode(errorCode),
                    description, failingUrl);
        }

        @Override
        public void didStartNavigation(NavigationHandle navigationHandle) {
            onNavigationStart(navigationHandle.getUrl(), navigationHandle.isInMainFrame(),
                    navigationHandle.isSameDocument(), navigationHandle.isErrorPage());
        }

        @Override
        public void didStartLoading(String url) {
            onDidStartLoading(url);
        };

        @Override
        public void didFirstVisuallyNonEmptyPaint() {
            onDidFirstVisuallyNonEmptyPaint();
        }
        /*
         * @Override public void didNavigateAnyFrame(String url, String baseUrl, boolean isReload) {
         * doUpdateVisitedHistory(url, isReload); }
         * @Override public void didNavigateMainFrame(String url, String baseUrl, boolean
         * isNavigationToDifferentPage, boolean isFragmentNavigation, int statusCode) {
         * stopSwipeRefreshHandler(); }
         */
        @Override
        public void didFinishLoad(long frameId, String validatedUrl, boolean isMainFrame) {

            // Both didStopLoading and didFinishLoad will be called once a page is finished
            // to load, but didStopLoading will also be called when user clicks "X" button
            // on browser UI to stop loading page.
            //
            // So it is safe for Crosswalk to rely on didStopLoading to ensure onPageFinished
            // can be called.
            if (isMainFrame) {
                stopSwipeRefreshHandler();
            }
        }

        @Override
        public void didFinishNavigation(NavigationHandle navigationHandle) {
            final String url = navigationHandle.getUrl();
            final boolean isInMainFrame = navigationHandle.isInMainFrame();
            final boolean isErrorPage = navigationHandle.isErrorPage();
            final int errorCode = navigationHandle.errorCode();
            final String errorDescription = navigationHandle.errorDescription();
            final boolean hasCommitted = navigationHandle.hasCommitted();
            final boolean isSameDocument = navigationHandle.isSameDocument();
            final Integer pageTransition = navigationHandle.pageTransition();
            final int httpStatusCode = navigationHandle.httpStatusCode();
            final boolean isFragmentNavigation = navigationHandle.isFragmentNavigation();

            if (errorCode != 0) {
                didFailLoad(isInMainFrame, errorCode, errorDescription, url);
            }

            onDidFinishNavigation(url, isInMainFrame, isErrorPage, hasCommitted, isSameDocument, isFragmentNavigation,
                    pageTransition, errorCode, errorDescription, httpStatusCode);

            // TODO(iotto) : Implement the following!!
//            if (!hasCommitted) return;
//
//            mCommittedNavigation = true;
//
//            AwContentsClient client = mAwContentsClient.get();
//            if (hasCommitted && client != null) {
//                boolean isReload = pageTransition != null
//                        && ((pageTransition & PageTransition.CORE_MASK) == PageTransition.RELOAD);
//                client.getCallbackHelper().postDoUpdateVisitedHistory(url, isReload);
//            }
//
//            if (!isInMainFrame) return;
//
//            // Only invoke the onPageCommitVisible callback when navigating to a different document,
//            // but not when navigating to a different fragment within the same document.
//            if (!isSameDocument) {
//                ThreadUtils.postOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        AwContents awContents = mAwContents.get();
//                        if (awContents != null) {
//                            awContents.insertVisualStateCallbackIfNotDestroyed(
//                                    0, new VisualStateCallback() {
//                                        @Override
//                                        public void onComplete(long requestId) {
//                                            AwContentsClient client = mAwContentsClient.get();
//                                            if (client == null) return;
//                                            client.onPageCommitVisible(url);
//                                        }
//                                    });
//                        }
//                    }
//                });
//            }
//
//            if (client != null && isFragmentNavigation) {
//                client.getCallbackHelper().postOnPageFinished(url);
//            }
        }

        @Override
        public void documentLoadedInFrame(long frameId, boolean isMainFrame) {
            onDocumentLoadedInFrame(frameId);
        }

        @Override
        public void titleWasSet(String title) {
            onTitleChanged(title, true);
        }
    }

    void installWebContentsObserver(WebContents webContents) {
        if (mWebContentsObserver != null) {
            mWebContentsObserver.destroy();
        }
        mWebContentsObserver = new XWalkWebContentsObserver(webContents);
    }

    void setDIPScale(double dipScale) {
        mDIPScale = dipScale;
    }

    final XWalkContentsClientCallbackHelper getCallbackHelper() {
        return mCallbackHelper;
    }

    // --------------------------------------------------------------------------------------------
    // XWalkViewInternal specific methods that map directly to XWalkViewClient/XWalkWebChromeClient
    // --------------------------------------------------------------------------------------------

    /**
     * Parameters for the {@link XWalkContentsClient#shouldInterceptRequest} method.
     */
    public static class XWalkWebResourceRequest {
        // Prefer using other constructors over this one.
        public XWalkWebResourceRequest() {
        }

        public XWalkWebResourceRequest(String url, boolean isMainFrame, boolean hasUserGesture,
                                       String method, HashMap<String, String> requestHeaders) {
            this.url = url;
            this.isMainFrame = isMainFrame;
            this.hasUserGesture = hasUserGesture;
            // Note: we intentionally let isRedirect default initialize to false. This is because we
            // don't always know if this request is associated with a redirect or not.
            this.method = method;
            this.requestHeaders = requestHeaders;
        }

        public XWalkWebResourceRequest(String url, boolean isMainFrame, boolean hasUserGesture,
                                       String method, String[] requestHeaderNames,
                                       String[] requestHeaderValues) {
            this(url, isMainFrame, hasUserGesture, method,
                    new HashMap<String, String>(requestHeaderValues.length));
            for (int i = 0; i < requestHeaderNames.length; ++i) {
                this.requestHeaders.put(requestHeaderNames[i], requestHeaderValues[i]);
            }
        }

        // Url of the request.
        public String url;
        // Is this for the main frame or a child iframe?
        public boolean isMainFrame;
        // Was a gesture associated with the request? Don't trust can easily be spoofed.
        public boolean hasUserGesture;
        // Was it a result of a server-side redirect?
        public boolean isRedirect;
        // Method used (GET/POST/OPTIONS)
        public String method;
        // Headers that would have been sent to server.
        public HashMap<String, String> requestHeaders;
    }

    public abstract void getVisitedHistory(ValueCallback<String[]> callback);

    public abstract void doUpdateVisitedHistory(String url, boolean isReload);

    public abstract void onProgressChanged(int progress);

    public abstract XWalkWebResourceResponse shouldInterceptRequest(
            XWalkWebResourceRequest request);

    public abstract void onResourceLoadStarted(String url);

    public abstract void onResourceLoadFinished(String url);

    public abstract void onLoadResource(String url);

    public abstract boolean shouldOverrideUrlLoading(String url);

    public abstract boolean onRewriteUrlIfNeeded(RewriteUrlValue toRewrite);

    public abstract void onUnhandledKeyEvent(KeyEvent event);

    public abstract boolean onConsoleMessage(ConsoleMessage consoleMessage);

    public abstract void onReceivedHttpAuthRequest(XWalkHttpAuthHandler handler,
                                                   String host, String realm);

    public abstract void onReceivedSslError(ValueCallback<Boolean> callback, SslError error);

    public abstract void onReceivedClientCertRequest(ClientCertRequest handler);

    public abstract void onReceivedResponseHeaders(XWalkWebResourceRequest request,
                                                   XWalkWebResourceResponse response);

    public abstract void onFormResubmission(Message dontResend, Message resend);

    public abstract void onGeolocationPermissionsShowPrompt(String origin,
                                                            XWalkGeolocationPermissions.Callback callback);

    public abstract void onGeolocationPermissionsHidePrompt();

    public final void onScaleChanged(float oldScaleFactor, float newScaleFactor) {
        onScaleChangedScaled((float) (oldScaleFactor * mDIPScale),
                (float) (newScaleFactor * mDIPScale));
    }

    public abstract void onScaleChangedScaled(float oldScale, float newScale);

    protected abstract boolean onCreateWindow(boolean isDialog, boolean isUserGesture);

    protected abstract void onCloseWindow();

    public abstract void onDidChangeThemeColor(int color);

    public abstract void onDocumentLoadedInFrame(long frameId);

    protected abstract void onRequestFocus();

    public abstract void onNavigationStateChanged(int flags, final String url);

    public abstract void onNavigationStart(final String url, boolean isInMainFrame,
                                           boolean isSameDocument,
                                           boolean isErrorPage);
    public abstract void onDidStartLoading(String url);
    public abstract void onDidFirstVisuallyNonEmptyPaint();

    public abstract void onDidFinishNavigation(String url, boolean isInMainFrame, boolean isErrorPage,
                                               boolean hasCommitted, boolean isSameDocument, boolean isFragmentNavigation, Integer pageTransition,
                                               int errorCode, String errorDescription, int httpStatusCode);

    public abstract void onPageStarted(String url);

    public abstract void onPageFinished(String url);

    protected abstract void onStopLoading();

    public abstract void onReceivedError(int errorCode, String description, String failingUrl);

    public abstract void onRendererUnresponsive();

    public abstract void onRendererResponsive();

    public abstract void onTitleChanged(String title, boolean forceNotification);

    public abstract void onToggleFullscreen(boolean enterFullscreen);

    public abstract boolean hasEnteredFullscreen();

    public abstract boolean shouldOverrideRunFileChooser(
            int processId, int renderId, int mode, String acceptTypes, String title,
            String defaultFilename, boolean capture);

    // TODO (michaelbai): Remove this method once the same method remove from
    // XWalkContentsClientAdapter.
    public abstract void onShowCustomView(View view,
                                          int requestedOrientation, CustomViewCallback callback);

    // TODO (michaelbai): This method should be abstract, having empty body here
    // makes the merge to the Android easy.
    public void onShowCustomView(View view, CustomViewCallback callback) {
        onShowCustomView(view, ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED, callback);
    }

    public abstract void onHideCustomView();

    public abstract void didFinishLoad(String url);

    public abstract void provideClientCertificateResponse(int id, byte[][] certChain,
                                                          PrivateKey privateKey);

    // --------------------------------------------------------------------------------------------
    // Other XWalkViewInternal-specific methods
    // --------------------------------------------------------------------------------------------
    //
    public abstract void onFindResultReceived(int activeMatchOrdinal, int numberOfMatches,
                                              boolean isDoneCounting);

    /**
     * For Tenta
     */
    public abstract void onOpenDnsSettings(final String failedUrl);

    /**
     * Called whenever there is a new content picture available.
     *
     * @param picture New picture.
     */
    public abstract void onNewPicture(Picture picture);

    public abstract boolean shouldCreateWebContents(String contentUrl);

    public abstract void resetSwipeRefreshHandler();

    public abstract void stopSwipeRefreshHandler();
}