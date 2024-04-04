package org.chromium.components.location;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/location/LocationSettingsDialogOutcome.class */
public @interface LocationSettingsDialogOutcome {
    public static final int GRANTED = 1;
    public static final int DENIED = 2;
    public static final int NO_PROMPT = 3;
}
