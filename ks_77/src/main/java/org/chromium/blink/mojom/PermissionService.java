package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PermissionService.class */
public interface PermissionService extends Interface {
    public static final Interface.Manager<PermissionService, Proxy> MANAGER = PermissionService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PermissionService$HasPermissionResponse.class */
    public interface HasPermissionResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PermissionService$Proxy.class */
    public interface Proxy extends PermissionService, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PermissionService$RequestPermissionResponse.class */
    public interface RequestPermissionResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PermissionService$RequestPermissionsResponse.class */
    public interface RequestPermissionsResponse extends Callbacks.Callback1<int[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PermissionService$RevokePermissionResponse.class */
    public interface RevokePermissionResponse extends Callbacks.Callback1<Integer> {
    }

    void hasPermission(PermissionDescriptor permissionDescriptor, HasPermissionResponse hasPermissionResponse);

    void requestPermission(PermissionDescriptor permissionDescriptor, boolean z, RequestPermissionResponse requestPermissionResponse);

    void requestPermissions(PermissionDescriptor[] permissionDescriptorArr, boolean z, RequestPermissionsResponse requestPermissionsResponse);

    void revokePermission(PermissionDescriptor permissionDescriptor, RevokePermissionResponse revokePermissionResponse);

    void addPermissionObserver(PermissionDescriptor permissionDescriptor, int i, PermissionObserver permissionObserver);
}
