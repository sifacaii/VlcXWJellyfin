package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NotificationService.class */
public interface NotificationService extends Interface {
    public static final Interface.Manager<NotificationService, Proxy> MANAGER = NotificationService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NotificationService$DisplayPersistentNotificationResponse.class */
    public interface DisplayPersistentNotificationResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NotificationService$GetNotificationsResponse.class */
    public interface GetNotificationsResponse extends Callbacks.Callback2<String[], NotificationData[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NotificationService$GetPermissionStatusResponse.class */
    public interface GetPermissionStatusResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NotificationService$Proxy.class */
    public interface Proxy extends NotificationService, Interface.Proxy {
    }

    void getPermissionStatus(GetPermissionStatusResponse getPermissionStatusResponse);

    void displayNonPersistentNotification(String str, NotificationData notificationData, NotificationResources notificationResources, NonPersistentNotificationListener nonPersistentNotificationListener);

    void closeNonPersistentNotification(String str);

    void displayPersistentNotification(long j, NotificationData notificationData, NotificationResources notificationResources, DisplayPersistentNotificationResponse displayPersistentNotificationResponse);

    void closePersistentNotification(String str);

    void getNotifications(long j, String str, boolean z, GetNotificationsResponse getNotificationsResponse);
}
