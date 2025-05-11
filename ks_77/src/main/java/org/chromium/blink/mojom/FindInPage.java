package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FindInPage.class */
public interface FindInPage extends Interface {
    public static final Interface.Manager<FindInPage, Proxy> MANAGER = FindInPage_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FindInPage$FindMatchRectsResponse.class */
    public interface FindMatchRectsResponse extends Callbacks.Callback3<Integer, RectF[], RectF> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FindInPage$GetNearestFindResultResponse.class */
    public interface GetNearestFindResultResponse extends Callbacks.Callback1<Float> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FindInPage$Proxy.class */
    public interface Proxy extends FindInPage, Interface.Proxy {
    }

    void find(int i, String str, FindOptions findOptions);

    void stopFinding(int i);

    void clearActiveFindMatch();

    void getNearestFindResult(PointF pointF, GetNearestFindResultResponse getNearestFindResultResponse);

    void activateNearestFindResult(int i, PointF pointF);

    void setClient(FindInPageClient findInPageClient);

    void findMatchRects(int i, FindMatchRectsResponse findMatchRectsResponse);
}
