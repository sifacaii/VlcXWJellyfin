// Copyright (c) 2013 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.pakdata.xwalk.refactor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ConsoleMessage;

import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.InvalidateTypes;
import org.chromium.content_public.common.ContentUrlConstants;

class XWalkWebContentsDelegateAdapter extends XWalkWebContentsDelegate {
    private static final String TAG = XWalkWebContentsDelegateAdapter.class.getName();

    private XWalkContentsClient mXWalkContentsClient;
    private XWalkContent mXwalkContent;
    private Context mContext;

    public XWalkWebContentsDelegateAdapter(Context context, XWalkContentsClient client, XWalkContent content) {
        mContext = context;
        mXWalkContentsClient = client;
        mXwalkContent = content;
    }

    @Override
    public boolean shouldCreateWebContents(String contentUrl) {
        if (mXWalkContentsClient != null) {
            return mXWalkContentsClient.shouldCreateWebContents(contentUrl);
        }
        return super.shouldCreateWebContents(contentUrl);
    }

    @Override
    public void loadingStateChanged(boolean toDifferentDocument) {
        // TODO fix this; doesn't get called
        if (mXWalkContentsClient != null) {
            mXWalkContentsClient.onTitleChanged(mXwalkContent.getTitle(), false);
        }
    }

    @Override
    public void navigationStateChanged(int flags) {

        if (mXWalkContentsClient != null && (flags & InvalidateTypes.URL) != 0) {
            // TODO (iotto): continue implementation if needed
            String url = mXwalkContent.getLastCommittedUrl();
            url = TextUtils.isEmpty(url) ? ContentUrlConstants.ABOUT_BLANK_DISPLAY_URL : url;
            mXWalkContentsClient.onNavigationStateChanged(flags, url);
        }
        // if ((flags & InvalidateTypes.URL) != 0
        // && mAwContents.isPopupWindow()
        // && mXwalkContent.hasAccessedInitialDocument()) {
        // // Hint the client to show the last committed url, as it may be unsafe to
        // show
        // // the pending entry.
        // String url = mXwalkContent.getLastCommittedUrl();
        // url = TextUtils.isEmpty(url) ? ContentUrlConstants.ABOUT_BLANK_DISPLAY_URL :
        // url;
        // if (mXWalkContentsClient != null) {
        // mXWalkContentsClient.getCallbackHelper().postSynthesizedPageLoadingForUrlBarUpdate(url);
        // }
        // }
    }

    @Override
    public void onLoadProgressChanged(int progress) {
        if (mXWalkContentsClient != null) mXWalkContentsClient.onProgressChanged(progress);
    }

    @Override
    public boolean addNewContents(boolean isDialog, boolean isUserGesture) {
        return mXWalkContentsClient.onCreateWindow(isDialog, isUserGesture);
    }

    @Override
    public void closeContents() {
        if (mXWalkContentsClient != null) mXWalkContentsClient.onCloseWindow();
    }

    @Override
    public void activateContents() {
        if (mXWalkContentsClient != null) mXWalkContentsClient.onRequestFocus();
    }

    @Override
    public void rendererUnresponsive() {
        org.chromium.base.Log.d("iotto", "rendererUnresponsive");
        if (mXWalkContentsClient != null) mXWalkContentsClient.onRendererUnresponsive();
    }

    @Override
    public void rendererResponsive() {
        org.chromium.base.Log.d("iotto", "rendererUnresponsive");
        if (mXWalkContentsClient != null) mXWalkContentsClient.onRendererResponsive();
    }

    @Override
    public void handleKeyboardEvent(KeyEvent event) {
        handleMediaKey(event);
        // Handle the event here when necessary and return if so.
        if (mXWalkContentsClient != null) mXWalkContentsClient.onUnhandledKeyEvent(event);
    }

    /**
     * Redispatches unhandled media keys. This allows bluetooth headphones with play/pause or
     * other buttons to function correctly.
     */
    private void handleMediaKey(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.KEYCODE_MUTE:
            case KeyEvent.KEYCODE_HEADSETHOOK:
            case KeyEvent.KEYCODE_MEDIA_PLAY:
            case KeyEvent.KEYCODE_MEDIA_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_STOP:
            case KeyEvent.KEYCODE_MEDIA_NEXT:
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
            case KeyEvent.KEYCODE_MEDIA_REWIND:
            case KeyEvent.KEYCODE_MEDIA_RECORD:
            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
            case KeyEvent.KEYCODE_MEDIA_CLOSE:
            case KeyEvent.KEYCODE_MEDIA_EJECT:
            case KeyEvent.KEYCODE_MEDIA_AUDIO_TRACK:
                AudioManager am = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
                am.dispatchMediaKeyEvent(e);
                break;
            default:
                break;
        }
    }
    @Override
    public boolean addMessageToConsole(int level, String message, int lineNumber,
                                       String sourceId) {
//        org.chromium.base.Log.d("iotto", "addMessageToConsole line=%d, message=%s, source=%s", lineNumber, message, sourceId);
        if (mXWalkContentsClient == null) return false;
        ConsoleMessage.MessageLevel messageLevel = ConsoleMessage.MessageLevel.DEBUG;
        switch(level) {
            case LOG_LEVEL_TIP:
                messageLevel = ConsoleMessage.MessageLevel.TIP;
                break;
            case LOG_LEVEL_LOG:
                messageLevel = ConsoleMessage.MessageLevel.LOG;
                break;
            case LOG_LEVEL_WARNING:
                messageLevel = ConsoleMessage.MessageLevel.WARNING;
                break;
            case LOG_LEVEL_ERROR:
                messageLevel = ConsoleMessage.MessageLevel.ERROR;
                break;
            default:
                Log.w(TAG, "Unknown message level, defaulting to DEBUG");
                break;
        }
        return mXWalkContentsClient.onConsoleMessage(
                new ConsoleMessage(message, sourceId, lineNumber, messageLevel));
    }

    @Override
    public void showRepostFormWarningDialog() {
        if (mXWalkContentsClient == null) return;
        mXWalkContentsClient.resetSwipeRefreshHandler();
    }

    @Override
    public boolean shouldOverrideRunFileChooser(int processId, int renderId, int mode,
                                                String acceptTypes, String title, String defaultFilename, boolean capture) {
        if (mXWalkContentsClient != null) {
            return mXWalkContentsClient.shouldOverrideRunFileChooser(processId, renderId, mode,
                    acceptTypes, title, defaultFilename, capture);
        }
        return false;
    }

    @Override
    public void setOverlayMode(boolean useOverlayMode) {
        mXwalkContent.setOverlayVideoMode(useOverlayMode);
    }

    @Override
    public boolean isFullscreen() {
        if (mXWalkContentsClient != null) return mXWalkContentsClient.hasEnteredFullscreen();

        return false;
    }

    @Override
    public void enterFullscreenModeForTab(boolean prefersNavigationBar) {
        super.enterFullscreenModeForTab(prefersNavigationBar);
        if (mXWalkContentsClient != null) mXWalkContentsClient.onToggleFullscreen(true);
    }

    @Override
    public void exitFullscreenModeForTab() {
        super.exitFullscreenModeForTab();
        if (mXWalkContentsClient != null) mXWalkContentsClient.onToggleFullscreen(false);
    }
}