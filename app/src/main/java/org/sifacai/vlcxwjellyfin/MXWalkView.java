package org.sifacai.vlcxwjellyfin;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

import com.pakdata.xwalk.refactor.XWalkView;

public class MXWalkView extends XWalkView {
    public MXWalkView(Context context) {
        super(context);
    }

    public MXWalkView(Context context, int zoneId, int tabId) {
        super(context, zoneId, tabId);
    }

    public MXWalkView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MXWalkView(Context context, Activity activity) {
        super(context, activity);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            // If there's navigation happens when app is fullscreen,
            // the content will still be fullscreen after navigation.
            // In such case, the back key will exit fullscreen first.
            if (hasEnteredFullscreen()) {
                leaveFullscreen();
                return true;
            } else if (canGoBack()) {
                goBack();
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
