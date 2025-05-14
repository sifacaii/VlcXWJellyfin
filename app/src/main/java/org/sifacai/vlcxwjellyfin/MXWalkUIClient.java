package org.sifacai.vlcxwjellyfin;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.pakdata.xwalk.refactor.XWalkUIClient;
import com.pakdata.xwalk.refactor.XWalkView;

public class MXWalkUIClient extends XWalkUIClient {
    /**
     * Constructor.
     *
     * @param view the owner XWalkView instance.
     * @since 1.0
     */
    public MXWalkUIClient(XWalkView view) {
        super(view);
    }

    @Override
    public void onFullscreenToggled(XWalkView view, boolean enterFullscreen) {
        super.onFullscreenToggled(view, enterFullscreen);

        Context mContext = view.getContext();
        if (!(mContext instanceof Activity))
            return;

        Activity activity = (Activity) mContext;
        if (enterFullscreen) {
            if(activity.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                return;

            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            if(activity.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                return;

            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    public boolean onConsoleMessage(XWalkView view, String message, int lineNumber, String sourceId, ConsoleMessageType messageType) {
        //Log.d("浏览器console：", message);
        return super.onConsoleMessage(view, message, lineNumber, sourceId, messageType);
    }
}
