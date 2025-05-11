package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/EmbeddedWorkerInstanceHost.class */
public interface EmbeddedWorkerInstanceHost extends Interface {
    public static final Interface.Manager<EmbeddedWorkerInstanceHost, Proxy> MANAGER = EmbeddedWorkerInstanceHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/EmbeddedWorkerInstanceHost$Proxy.class */
    public interface Proxy extends EmbeddedWorkerInstanceHost, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/EmbeddedWorkerInstanceHost$RequestTerminationResponse.class */
    public interface RequestTerminationResponse extends Callbacks.Callback1<Boolean> {
    }

    void requestTermination(RequestTerminationResponse requestTerminationResponse);

    void countFeature(int i);

    void onReadyForInspection();

    void onScriptLoaded();

    void onScriptEvaluationStart();

    void onStarted(int i, int i2, EmbeddedWorkerStartTiming embeddedWorkerStartTiming);

    void onReportException(String16 string16, int i, int i2, Url url);

    void onReportConsoleMessage(int i, int i2, String16 string16, int i3, Url url);

    void onStopped();
}
