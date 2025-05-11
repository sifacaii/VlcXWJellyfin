package org.chromium.installedapp.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/installedapp/mojom/InstalledAppProvider.class */
public interface InstalledAppProvider extends Interface {
    public static final Interface.Manager<InstalledAppProvider, Proxy> MANAGER = InstalledAppProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/installedapp/mojom/InstalledAppProvider$FilterInstalledAppsResponse.class */
    public interface FilterInstalledAppsResponse extends Callbacks.Callback1<RelatedApplication[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/installedapp/mojom/InstalledAppProvider$Proxy.class */
    public interface Proxy extends InstalledAppProvider, Interface.Proxy {
    }

    void filterInstalledApps(RelatedApplication[] relatedApplicationArr, FilterInstalledAppsResponse filterInstalledAppsResponse);
}
