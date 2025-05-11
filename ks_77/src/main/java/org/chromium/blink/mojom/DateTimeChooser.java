package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DateTimeChooser.class */
public interface DateTimeChooser extends Interface {
    public static final Interface.Manager<DateTimeChooser, Proxy> MANAGER = DateTimeChooser_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DateTimeChooser$OpenDateTimeDialogResponse.class */
    public interface OpenDateTimeDialogResponse extends Callbacks.Callback2<Boolean, Double> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DateTimeChooser$Proxy.class */
    public interface Proxy extends DateTimeChooser, Interface.Proxy {
    }

    void openDateTimeDialog(DateTimeDialogValue dateTimeDialogValue, OpenDateTimeDialogResponse openDateTimeDialogResponse);
}
