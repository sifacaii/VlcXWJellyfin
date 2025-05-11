package com.pakdata.xwalk.refactor;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AndroidRuntimeException;
import android.util.Log;
import java.util.HashMap;
import org.chromium.ui.base.PageTransition;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkNotificationServiceImpl.class */
public class XWalkNotificationServiceImpl implements XWalkNotificationService {
    private static final String TAG = "XWalkNotificationServiceImpl";
    private static final String XWALK_ACTION_CLICK_NOTIFICATION_SUFFIX = ".notification.click";
    private static final String XWALK_ACTION_CLOSE_NOTIFICATION_SUFFIX = ".notification.close";
    private static final String XWALK_INTENT_EXTRA_KEY_NOTIFICATION_ID = "xwalk.NOTIFICATION_ID";
    private static final String XWALK_INTENT_CATEGORY_NOTIFICATION_PREFIX = "notification_";
    private Context mContext;
    private XWalkContentsClientBridge mBridge;
    private XWalkView mView;
    private NotificationManager mNotificationManager;
    private BroadcastReceiver mNotificationCloseReceiver = new BroadcastReceiver() { // from class: com.pakdata.xwalk.refactor.XWalkNotificationServiceImpl.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XWalkNotificationServiceImpl.this.mView.onNewIntent(intent);
        }
    };
    private HashMap<Integer, WebNotification> mExistNotificationIds = new HashMap<>();
    private HashMap<String, WebNotification> mExistReplaceIds = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkNotificationServiceImpl$WebNotification.class */
    public class WebNotification {
        public Integer mNotificationId;
        public String mReplaceId;
        public Notification.Builder mBuilder;
        public Integer mMessageNum = 1;

        WebNotification() {
        }
    }

    public XWalkNotificationServiceImpl(Context context, XWalkView view) {
        this.mContext = context;
        this.mView = view;
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService("notification");
    }

    private static String getCategoryFromNotificationId(int id) {
        return XWALK_INTENT_CATEGORY_NOTIFICATION_PREFIX + id;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkNotificationService
    public void setBridge(XWalkContentsClientBridge bridge) {
        this.mBridge = bridge;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkNotificationService
    public void shutdown() {
        if (!this.mExistNotificationIds.isEmpty()) {
            unregisterReceiver();
        }
        this.mBridge = null;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkNotificationService
    public boolean maybeHandleIntent(Intent intent) {
        int notificationId;
        if (intent.getAction() != null && (notificationId = intent.getIntExtra(XWALK_INTENT_EXTRA_KEY_NOTIFICATION_ID, -1)) > 0) {
            if (intent.getAction().equals(this.mView.getContext().getPackageName() + XWALK_ACTION_CLOSE_NOTIFICATION_SUFFIX)) {
                onNotificationClose(notificationId, true);
                return true;
            } else if (intent.getAction().equals(this.mView.getContext().getPackageName() + XWALK_ACTION_CLICK_NOTIFICATION_SUFFIX)) {
                onNotificationClick(notificationId);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Bitmap getNotificationIcon(Bitmap icon) {
        if (icon == null) {
            return null;
        }
        int originalWidth = icon.getWidth();
        int originalHeight = icon.getHeight();
        if (originalWidth == 0 || originalHeight == 0) {
            return icon;
        }
        int targetWidth = this.mContext.getResources().getDimensionPixelSize(17104901);
        int targetHeight = this.mContext.getResources().getDimensionPixelSize(17104902);
        if (originalWidth > targetWidth && originalHeight > targetHeight) {
            if (originalWidth * targetHeight > originalHeight * targetWidth) {
                targetHeight = (originalHeight * targetWidth) / originalWidth;
            } else {
                targetWidth = (originalWidth * targetHeight) / originalHeight;
            }
        }
        return Bitmap.createScaledBitmap(icon, targetWidth, targetHeight, true);
    }

    @Override // com.pakdata.xwalk.refactor.XWalkNotificationService
    public void showNotification(String title, String message, String replaceId, Bitmap icon, int notificationId) {
        Notification.Builder builder;
        if (!replaceId.isEmpty() && this.mExistReplaceIds.containsKey(replaceId)) {
            WebNotification webNotification = this.mExistReplaceIds.get(replaceId);
            notificationId = webNotification.mNotificationId.intValue();
            builder = webNotification.mBuilder;
            Integer valueOf = Integer.valueOf(webNotification.mMessageNum.intValue() + 1);
            webNotification.mMessageNum = valueOf;
            builder.setNumber(valueOf.intValue());
        } else {
            builder = new Notification.Builder(this.mContext.getApplicationContext()).setAutoCancel(true);
            WebNotification webNotification2 = new WebNotification();
            webNotification2.mNotificationId = Integer.valueOf(notificationId);
            webNotification2.mReplaceId = replaceId;
            webNotification2.mBuilder = builder;
            this.mExistNotificationIds.put(Integer.valueOf(notificationId), webNotification2);
            if (!replaceId.isEmpty()) {
                this.mExistReplaceIds.put(replaceId, webNotification2);
            }
        }
        builder.setContentTitle(title);
        builder.setContentText(message);
        int iconRes = this.mContext.getApplicationInfo().icon;
        if (iconRes == 0) {
            iconRes = 17301651;
        }
        builder.setSmallIcon(iconRes);
        Bitmap bigIcon = getNotificationIcon(icon);
        if (bigIcon != null) {
            builder.setLargeIcon(bigIcon);
        }
        Context context = this.mView.getContext();
        String category = getCategoryFromNotificationId(notificationId);
        Intent clickIntent = new Intent(context, context.getClass()).setAction(context.getPackageName() + XWALK_ACTION_CLICK_NOTIFICATION_SUFFIX).putExtra(XWALK_INTENT_EXTRA_KEY_NOTIFICATION_ID, notificationId).setFlags(537919488).addCategory(category);
        Intent closeIntent = new Intent(context.getPackageName() + XWALK_ACTION_CLOSE_NOTIFICATION_SUFFIX).putExtra(XWALK_INTENT_EXTRA_KEY_NOTIFICATION_ID, notificationId).addCategory(category);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, clickIntent, PageTransition.FROM_API));
        builder.setDeleteIntent(PendingIntent.getBroadcast(context, 0, closeIntent, PageTransition.FROM_API));
        doShowNotification(notificationId, Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification());
        notificationChanged();
        onNotificationShown(notificationId);
    }

    @Override // com.pakdata.xwalk.refactor.XWalkNotificationService
    public void cancelNotification(int notificationId) {
        this.mNotificationManager.cancel(notificationId);
        onNotificationClose(notificationId, false);
    }

    public void doShowNotification(int notificationId, Notification notification) {
        this.mNotificationManager.notify(notificationId, notification);
    }

    public void onNotificationShown(int notificationId) {
        WebNotification webNotification = this.mExistNotificationIds.get(Integer.valueOf(notificationId));
        if (webNotification != null && this.mBridge != null) {
            this.mBridge.notificationDisplayed(notificationId);
        }
    }

    public void onNotificationClick(int notificationId) {
        WebNotification webNotification = this.mExistNotificationIds.get(Integer.valueOf(notificationId));
        if (webNotification == null) {
            return;
        }
        this.mExistNotificationIds.remove(Integer.valueOf(notificationId));
        this.mExistReplaceIds.remove(webNotification.mReplaceId);
        notificationChanged();
        if (this.mBridge != null) {
            this.mBridge.notificationClicked(notificationId);
        }
    }

    public void onNotificationClose(int notificationId, boolean byUser) {
        WebNotification webNotification = this.mExistNotificationIds.get(Integer.valueOf(notificationId));
        if (webNotification == null) {
            return;
        }
        this.mExistNotificationIds.remove(Integer.valueOf(notificationId));
        this.mExistReplaceIds.remove(webNotification.mReplaceId);
        notificationChanged();
        if (this.mBridge != null) {
            this.mBridge.notificationClosed(notificationId, byUser);
        }
    }

    private void notificationChanged() {
        if (this.mExistNotificationIds.isEmpty()) {
            Log.i(TAG, "notifications are all cleared,unregister broadcast receiver for close pending intent");
            unregisterReceiver();
            return;
        }
        registerReceiver();
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter(this.mView.getContext().getPackageName() + XWALK_ACTION_CLOSE_NOTIFICATION_SUFFIX);
        for (Integer id : this.mExistNotificationIds.keySet()) {
            filter.addCategory(getCategoryFromNotificationId(id.intValue()));
        }
        try {
            this.mView.getContext().registerReceiver(this.mNotificationCloseReceiver, filter);
        } catch (AndroidRuntimeException e) {
            Log.w(TAG, e.getLocalizedMessage());
        }
    }

    private void unregisterReceiver() {
        this.mView.getContext().unregisterReceiver(this.mNotificationCloseReceiver);
    }
}
