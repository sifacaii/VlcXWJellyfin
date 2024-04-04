package org.chromium.ui.base;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/AndroidPermissionDelegate.class */
public interface AndroidPermissionDelegate {
    boolean hasPermission(String str);

    boolean canRequestPermission(String str);

    boolean isPermissionRevokedByPolicy(String str);

    void requestPermissions(String[] strArr, PermissionCallback permissionCallback);

    boolean handlePermissionResult(int i, String[] strArr, int[] iArr);
}
