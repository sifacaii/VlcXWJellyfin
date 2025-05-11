package com.pakdata.xwalk.refactor;

import android.content.Intent;
import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkNotificationService.class */
public interface XWalkNotificationService {
    void setBridge(XWalkContentsClientBridge xWalkContentsClientBridge);

    void showNotification(String str, String str2, String str3, Bitmap bitmap, int i);

    void cancelNotification(int i);

    void shutdown();

    boolean maybeHandleIntent(Intent intent);
}
