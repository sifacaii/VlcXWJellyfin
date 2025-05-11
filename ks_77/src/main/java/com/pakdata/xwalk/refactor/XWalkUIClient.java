// Copyright (c) 2014 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.pakdata.xwalk.refactor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.EditText;
import android.widget.FrameLayout;

import org.chromium.base.ApiCompatibilityUtils;
import org.xwalk.core.R;

import com.pakdata.xwalk.refactor.CustomViewCallback;

/**
 * This class notifies the embedder UI events/callbacks.
 */
//TODO(iotto) : @XWalkAPI(createExternally = true)
public class XWalkUIClient {

    private Context mContext;
    private AlertDialog mDialog;
    private EditText mPromptText;
    private int mSystemUiFlag;
    private XWalkView mXWalkView;
    private boolean mOriginalFullscreen;
    private boolean mOriginalForceNotFullscreen;
    private boolean mIsFullscreen;
    private View mCustomXWalkView;
    private static final int INVALID_ORIENTATION = -2;
    private int mPreOrientation = INVALID_ORIENTATION;
    private CustomViewCallback mCustomViewCallback;
    private XWalkContentsClient mContentsClient;

    /**
     * Initiator
     *
     * @since 4.0
     */
//TODO(iotto) :     @XWalkAPI
    public enum InitiateByInternal {
        BY_USER_GESTURE, BY_JAVASCRIPT
    }

    /**
     * Constructor.
     *
     * @param view the owner XWalkView instance.
     * @since 1.0
     */
    public XWalkUIClient(XWalkView view) {
        mIsFullscreen = false;
        mContext = view.getContext();
        if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
            mSystemUiFlag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        }
        mXWalkView = view;
    }

    /**
     * Request the host application to create a new window
     *
     * @param view The XWalkView which initiate the request for a new window
     * @param initiator How the request was initiated
     * @param callback Callback when once a new XWalkView has been created
     * @return Return true if the host application will create a new window
     * @since 4.0
     */
    public boolean onCreateWindowRequested(XWalkView view, InitiateByInternal initiator,
                                           ValueCallback<XWalkView> callback) {
        return false;
    }

    /**
     * Called when the theme color is changed. This works only on Android Lollipop+(5.0+).
     *
     * @param color the new color in RGB format.
     */
//TODO(iotto) :     @XWalkAPI
    public void onDidChangeThemeColor(XWalkView view, int color) {
        if (view == null || !(mContext instanceof Activity))
            return;
        Activity activity = (Activity) mContext;
        ApiCompatibilityUtils.setStatusBarColor(activity.getWindow(), color);
        ApiCompatibilityUtils.setTaskDescription(activity, null, null, color);
    }

    /**
     * Notify the host application that an icon is available, send the message to start the
     * downloading
     *
     * @param view The XWalkView that icon belongs to
     * @param url The icon url
     * @param startDownload Message to initiate icon download
     * @since 4.0
     */
//TODO(iotto) :     @XWalkAPI
    public void onIconAvailable(XWalkView view, String url, Message startDownload) {
    }

    /**
     * Notify the host application of a new icon has been downloaded
     *
     * @param view The XWalkView that icon belongs to
     * @param url The icon url
     * @param icon The icon image
     * @since 4.0
     */
//TODO(iotto) :     @XWalkAPI
    public void onReceivedIcon(XWalkView view, String url, Bitmap icon) {
    }

    /**
     * Request display and focus for this XWalkView.
     *
     * @param view the owner XWalkView instance.
     * @since 1.0
     */
//TODO(iotto) :     @XWalkAPI
    public void onRequestFocus(XWalkView view) {
    }

    /**
     * Notify the client to close the given XWalkView.
     *
     * @param view the owner XWalkView instance.
     * @since 1.0
     */
//TODO(iotto) :     @XWalkAPI
    public void onJavascriptCloseWindow(XWalkView view) {
        if (view == null || !(mContext instanceof Activity))
            return;
        Activity activity = (Activity) mContext;
        activity.finish();
    }

    /**
     * The type of JavaScript modal dialog.
     *
     * @since 1.0
     */
//TODO(iotto) :     @XWalkAPI
    public enum JavascriptMessageTypeInternal {
        /** JavaScript alert dialog. */
        JAVASCRIPT_ALERT,
        /** JavaScript confirm dialog. */
        JAVASCRIPT_CONFIRM,
        /** JavaScript prompt dialog. */
        JAVASCRIPT_PROMPT,
        /** JavaScript dialog for a window-before-unload notification. */
        JAVASCRIPT_BEFOREUNLOAD
    }

    /**
     * Tell the client to display a prompt dialog to the user.
     *
     * @param view the owner XWalkView instance.
     * @param type the type of JavaScript modal dialog.
     * @param url the url of the web page which wants to show this dialog.
     * @param message the message to be shown.
     * @param defaultValue the default value string. Only valid for Prompt dialog.
     * @param result the callback to handle the result from caller.
     * @return true if the client will handle the dialog
     * @since 1.0
     */
//TODO(iotto) :     @XWalkAPI
    public boolean onJavascriptModalDialog(XWalkView view,
                                           JavascriptMessageTypeInternal type,
                                           String url, String message, String defaultValue, XWalkJavascriptResult result) {
        switch (type) {
            case JAVASCRIPT_ALERT:
                return onJsAlert(view, url, message, result);
            case JAVASCRIPT_CONFIRM:
                return onJsConfirm(view, url, message, result);
            case JAVASCRIPT_PROMPT:
                return onJsPrompt(view, url, message, defaultValue, result);
            case JAVASCRIPT_BEFOREUNLOAD:
                // Reuse onJsConfirm to show the dialog.
                return onJsConfirm(view, url, message, result);
            default:
                break;
        }
        assert (false);
        return false;
    }

    /**
     * Tell the client to toggle fullscreen mode.
     *
     * @param view the owner XWalkView instance.
     * @param enterFullscreen true if it has entered fullscreen mode.
     * @since 1.0
     */
//TODO(iotto) :     @XWalkAPI
    public void onFullscreenToggled(XWalkView view, boolean enterFullscreen) {
        if (!(mContext instanceof Activity))
            return;

        Activity activity = (Activity) mContext;
        if (enterFullscreen) {
            if ((activity.getWindow().getAttributes().flags &
                    WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN) != 0) {
                mOriginalForceNotFullscreen = true;
                activity.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            } else {
                mOriginalForceNotFullscreen = false;
            }
            if (!mIsFullscreen) {
                if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
                    View decorView = activity.getWindow().getDecorView();
                    mSystemUiFlag = decorView.getSystemUiVisibility();
                    decorView.setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                } else {
                    if ((activity.getWindow().getAttributes().flags &
                            WindowManager.LayoutParams.FLAG_FULLSCREEN) != 0) {
                        mOriginalFullscreen = true;
                    } else {
                        mOriginalFullscreen = false;
                        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    }
                }
                mIsFullscreen = true;
            }
        } else {
            if (mOriginalForceNotFullscreen) {
                activity.getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            }
            if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
                activity.getWindow().getDecorView().setSystemUiVisibility(mSystemUiFlag);
            } else {
                // Clear the activity fullscreen flag.
                if (!mOriginalFullscreen) {
                    activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                }
            }
            mIsFullscreen = false;
        }
    }

    /**
     * Tell the client to open a file chooser.
     *
     * @param view the owner XWalkView instance.
     * @param uploadFile the callback class to handle the result from caller. It MUST be invoked in
     *            all cases. Leave it not invoked will block all following requests to open file
     *            chooser.
     * @param acceptType comma separated value(s) of the 'accept' attribute of the input tag associated with this file
     *            picker.
     * @param capture If true, the data should be obtained using the device's camera/mic/etc.
     * @param modeFlags flags of android.webkit.WebChromeClient.FileChooserParams
     *
     * @since 1.0
     */
    public void openFileChooser(XWalkView view, ValueCallback<String[]> uploadFile,
                                String acceptType, String title, String defaultFilename, boolean capture,
                                int modeFlags) {
        uploadFile.onReceiveValue(null);
    }

    /**
     * Notify the client that the scale applied to the XWalkView has changed.
     *
     * @param view the owner XWalkView instance.
     * @param oldScale the old scale before scaling.
     * @param newScale the current scale factor after scaling.
     * @since 1.0
     */
//TODO(iotto) :     @XWalkAPI
    public void onScaleChanged(XWalkView view, float oldScale, float newScale) {
    }

    /**
     * Give the host application a chance to handle the key event synchronously. e.g. menu shortcut
     * key events need to be filtered this way. If return true, XWalkView will not handle
     * the key event. If return false, XWalkView will always handle the key event, so none
     * of the super in the view chain will see the key event. The default behavior returns false.
     *
     * @param view The XWalkView that is initiating the callback.
     * @param event The key event.
     * @return True if the host application wants to handle the key event itself, otherwise return
     *         false
     * @since 2.1
     */
//TODO(iotto) :     @XWalkAPI
    public boolean shouldOverrideKeyEvent(XWalkView view, KeyEvent event) {
        return false;
    }

    /**
     * Notify the host application that a key was not handled by the XWalkView. Except
     * system keys, XWalkView always consumes the keys in the normal flow or if
     * shouldOverrideKeyEvent returns true. This is called asynchronously from where the key is
     * dispatched. It gives the host application a chance to handle the unhandled key events.
     *
     * @param view The XWalkView that is initiating the callback.
     * @param event The key event.
     * @since 2.1
     */
//TODO(iotto) :     @XWalkAPI
    public void onUnhandledKeyEvent(XWalkView view, KeyEvent event) {
    }

    /**
     * Initiator
     *
     * @since 5.0
     */
//TODO(iotto) :     @XWalkAPI
    public enum ConsoleMessageType {
        DEBUG, ERROR, LOG, INFO, WARNING
    }

    /**
     * Notify the host application of console message.
     *
     * @param view The XWalkView that initiated the callback.
     * @param message A String containing the console message.
     * @param lineNumber The line number of JavaScript.
     * @param sourceId The link which print log.
     * @param messageType The type of console message.
     * @return Not applicable here. For future use.
     * @since 5.0
     */
//TODO(iotto) :     @XWalkAPI
    public boolean onConsoleMessage(XWalkView view, String message,
                                    int lineNumber, String sourceId, ConsoleMessageType messageType) {
        return false;
    }

    /**
     * Notify the host application of a change in the document title.
     *
     * @param view The XWalkView that initiated the callback.
     * @param title A String containing the new title of the document.
     * @since 2.1
     */
//TODO(iotto) :     @XWalkAPI
    public void onReceivedTitle(XWalkView view, String title) {
    }

    /**
     * The status when a page stopped loading
     *
     * @since 2.1
     */
//TODO(iotto) :     @XWalkAPI
    public enum LoadStatusInternal {
        /** Loading finished. */
        FINISHED,
        /** Loading failed. */
        FAILED,
        /** Loading cancelled by user. */
        CANCELLED
    }

    /**
     * @param view
     * @param url
     */
//TODO(iotto) :     @XWalkAPI
    public void onNavigationStarted(XWalkView view, String url, boolean isInMainFrame,
                                    boolean isSameDocument,
                                    boolean isErrorPage) {

    }

    //TODO(iotto) :     @XWalkAPI
    public void onNavigationStateChanged(int flags, final String url) {

    }

    //TODO(iotto) :     @XWalkAPI
    public void onDidStartLoading(XWalkView view, String url) {

    }

    //TODO(iotto) :     @XWalkAPI
    public void onDidFirstVisuallyNonEmptyPaint() {

    }

    //TODO(iotto) :     @XWalkAPI
    public void onDidFinishNavigation(String url, boolean isInMainFrame, boolean isErrorPage,
                                      boolean hasCommitted, boolean isSameDocument, boolean isFragmentNavigation, Integer pageTransition,
                                      int errorCode, String errorDescription, int httpStatusCode) {

    }

    /**
     * Notify the host application that a page has started loading. This method is called once for
     * each main frame load so a page with iframes or framesets will call onPageLoadStarted one time
     * for the main frame. This also means that onPageLoadStarted will not be called when the
     * contents of an embedded frame changes, i.e. clicking a link whose target is an iframe.
     *
     * @param view The XWalkView that is initiating the callback.
     * @param url The url to be loaded.
     * @since 2.1
     */
//TODO(iotto) :     @XWalkAPI
    public void onPageLoadStarted(XWalkView view, String url) {
    }

    /**
     * Notify the host application that a page has stopped loading. This method is called only for
     * main frame. When onPageLoadStopped() is called, the rendering picture may not be updated yet.
     *
     * @param view The XWalkView that is initiating the callback.
     * @param url The url of the page.
     * @param status The status when the page stopped loading.
     * @since 2.1
     */
//TODO(iotto) :     @XWalkAPI
    public void onPageLoadStopped(XWalkView view, String url, LoadStatusInternal status) {
    }

    /**
     * Tell the client to display an alert dialog to the user. WARN: Please DO NOT override this API
     * and onJavascriptModalDialog API in the same subclass to avoid unexpected behavior.
     *
     * @param view the owner XWalkView instance.
     * @param url the url of the web page which wants to show this dialog.
     * @param message the message to be shown.
     * @param result the callback to handle the result from caller.
     * @return Whether the client will handle the alert dialog.
     * @since 6.0
     */
//TODO(iotto) :     @XWalkAPI
    public boolean onJsAlert(XWalkView view, String url, String message,
                             XWalkJavascriptResult result) {
        final XWalkJavascriptResult fResult = result;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(mContext.getString(R.string.js_alert_title))
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(mContext.getString(android.R.string.ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                fResult.confirm();
                                dialog.dismiss();
                            }
                        })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        fResult.cancel();
                    }
                });
        mDialog = dialogBuilder.create();
        mDialog.show();
        return false;
    }

    /**
     * Tell the client to display a confirm dialog to the user. WARN: Please DO NOT override this
     * API and onJavascriptModalDialog API in the same subclass to avoid unexpected behavior.
     *
     * @param view the owner XWalkView instance.
     * @param url the url of the web page which wants to show this dialog.
     * @param message the message to be shown.
     * @param result the callback to handle the result from caller.
     * @return Whether the client will handle the confirm dialog.
     * @since 6.0
     */
//TODO(iotto) :     @XWalkAPI
    public boolean onJsConfirm(XWalkView view, String url, String message,
                               XWalkJavascriptResult result) {
        final XWalkJavascriptResult fResult = result;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(mContext.getString(R.string.js_confirm_title))
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(mContext.getString(android.R.string.ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                fResult.confirm();
                                dialog.dismiss();
                            }
                        })
                // Need to implement 'onClick' and call the dialog.cancel. Otherwise, the
                // UI will be locked.
                .setNegativeButton(mContext.getString(android.R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // This will call OnCancelLisitener.onCancel().
                                dialog.cancel();
                            }
                        })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        fResult.cancel();
                    }
                });
        mDialog = dialogBuilder.create();
        mDialog.show();
        return false;
    }

    /**
     * Tell the client to display a prompt dialog to the user. WARN: Please DO NOT override this API
     * and onJavascriptModalDialog API in the same subclass to avoid unexpected behavior.
     *
     * @param view the owner XWalkView instance.
     * @param url the url of the web page which wants to show this dialog.
     * @param message the message to be shown.
     * @param defaultValue the default value string. Only valid for Prompt dialog.
     * @param result the callback to handle the result from caller.
     * @return Whether the client will handle the prompt dialog.
     * @since 6.0
     */
//TODO(iotto) :     @XWalkAPI
    public boolean onJsPrompt(XWalkView view, String url, String message,
                              String defaultValue, XWalkJavascriptResult result) {
        final XWalkJavascriptResult fResult = result;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(mContext.getString(R.string.js_prompt_title))
                .setMessage(message)
                .setPositiveButton(mContext.getString(android.R.string.ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                fResult.confirmWithResult(mPromptText.getText().toString());
                                dialog.dismiss();
                            }
                        })
                // Need to implement 'onClick' and call the dialog.cancel. Otherwise, the
                // UI will be locked.
                .setNegativeButton(mContext.getString(android.R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // This will call OnCancelLisitener.onCancel().
                                dialog.cancel();
                            }
                        })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        fResult.cancel();
                    }
                });
        mPromptText = new EditText(mContext);
        mPromptText.setVisibility(View.VISIBLE);
        mPromptText.setText(defaultValue);
        mPromptText.selectAll();

        dialogBuilder.setView(mPromptText);
        mDialog = dialogBuilder.create();
        mDialog.show();
        return false;
    }

    void setContentsClient(XWalkContentsClient client) {
        mContentsClient = client;
    }

    private Activity addContentView(View view, CustomViewCallback callback) {
        Activity activity = null;
        try {
            Context context = mXWalkView.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
        } catch (ClassCastException e) {
        }

        if (mCustomXWalkView != null || activity == null) {
            if (callback != null)
                callback.onCustomViewHidden();
            return null;
        }

        mCustomXWalkView = view;
        mCustomViewCallback = callback;
        if (mContentsClient != null) {
            mContentsClient.onToggleFullscreen(true);
        }

        // Add the video view to the activity's DecorView.
        FrameLayout decor = (FrameLayout) activity.getWindow().getDecorView();
        decor.addView(mCustomXWalkView, 0,
                new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        Gravity.CENTER));
        return activity;
    }

    /**
     * Notify the host application that the current page would like to show a custom View.
     *
     * @param view is the View object to be shown.
     * @param callback is the callback to be invoked if and when the view is dismissed.
     * @since 7.0
     */
//TODO(iotto) :     @XWalkAPI
    public void onShowCustomView(View view,
                                 CustomViewCallback callback) {
        addContentView(view, callback);
    }

    /**
     * Notify the host application that the current page would like to show a custom View in a
     * particular orientation.
     *
     * @param view is the View object to be shown.
     * @param requestedOrientation An orientation constant as used in
     *            {@link ActivityInfo#screenOrientation ActivityInfo.screenOrientation}.
     * @param callback is the callback to be invoked if and when the view is dismissed.
     * @since 7.0
     */
//TODO(iotto) :     @XWalkAPI
    public void onShowCustomView(View view,
                                 int requestedOrientation, CustomViewCallback callback) {
        Activity activity = addContentView(view, callback);
        if (activity == null)
            return;

        final int orientation = activity.getResources().getConfiguration().orientation;

        if (requestedOrientation != orientation &&
                requestedOrientation >= ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED &&
                requestedOrientation <= ActivityInfo.SCREEN_ORIENTATION_LOCKED) {
            mPreOrientation = orientation;
            activity.setRequestedOrientation(requestedOrientation);
        }
    }

    /**
     * For Tenta
     *
     * @param failedUrl Loading url that failed DNS
     */
//TODO(iotto) :     @XWalkAPI
    public void onOpenDnsSettings(final String failedUrl) {
    }

    /**
     * Notify the host application that the current page would like to hide its custom view.
     *
     * @since 7.0
     */
    @SuppressLint("WrongConstant")
    public void onHideCustomView() {
        if (mCustomXWalkView == null || !(mXWalkView.getContext() instanceof Activity))
            return;

        if (mContentsClient != null) {
            mContentsClient.onToggleFullscreen(false);
        }

        Activity activity = (Activity) mXWalkView.getContext();
        // Remove video view from activity's ContentView.
        FrameLayout decor = (FrameLayout) activity.getWindow().getDecorView();
        decor.removeView(mCustomXWalkView);
        if (mCustomViewCallback != null)
            mCustomViewCallback.onCustomViewHidden();

        if (mPreOrientation != INVALID_ORIENTATION &&
                mPreOrientation >= ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED &&
                mPreOrientation <= ActivityInfo.SCREEN_ORIENTATION_LOCKED) {
            activity.setRequestedOrientation(mPreOrientation);
            mPreOrientation = INVALID_ORIENTATION;
        }

        mCustomXWalkView = null;
        mCustomViewCallback = null;
    }

}