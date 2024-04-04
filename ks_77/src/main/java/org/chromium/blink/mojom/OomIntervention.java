package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OomIntervention.class */
public interface OomIntervention extends Interface {
    public static final Interface.Manager<OomIntervention, Proxy> MANAGER = OomIntervention_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OomIntervention$Proxy.class */
    public interface Proxy extends OomIntervention, Interface.Proxy {
    }

    void startDetection(OomInterventionHost oomInterventionHost, DetectionArgs detectionArgs, boolean z, boolean z2, boolean z3);
}
