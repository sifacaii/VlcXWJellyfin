package org.chromium.blink.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.skia.mojom.Bitmap;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost.class */
public interface ClipboardHost extends Interface {
    public static final Interface.Manager<ClipboardHost, Proxy> MANAGER = ClipboardHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost$GetSequenceNumberResponse.class */
    public interface GetSequenceNumberResponse extends Callbacks.Callback1<Long> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost$IsFormatAvailableResponse.class */
    public interface IsFormatAvailableResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost$Proxy.class */
    public interface Proxy extends ClipboardHost, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost$ReadAvailableTypesResponse.class */
    public interface ReadAvailableTypesResponse extends Callbacks.Callback2<String16[], Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost$ReadCustomDataResponse.class */
    public interface ReadCustomDataResponse extends Callbacks.Callback1<BigString16> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost$ReadHtmlResponse.class */
    public interface ReadHtmlResponse extends Callbacks.Callback4<BigString16, Url, Integer, Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost$ReadImageResponse.class */
    public interface ReadImageResponse extends Callbacks.Callback1<Bitmap> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost$ReadRtfResponse.class */
    public interface ReadRtfResponse extends Callbacks.Callback1<String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ClipboardHost$ReadTextResponse.class */
    public interface ReadTextResponse extends Callbacks.Callback1<BigString16> {
    }

    void getSequenceNumber(int i, GetSequenceNumberResponse getSequenceNumberResponse);

    void isFormatAvailable(int i, int i2, IsFormatAvailableResponse isFormatAvailableResponse);

    void readAvailableTypes(int i, ReadAvailableTypesResponse readAvailableTypesResponse);

    void readText(int i, ReadTextResponse readTextResponse);

    void readHtml(int i, ReadHtmlResponse readHtmlResponse);

    void readRtf(int i, ReadRtfResponse readRtfResponse);

    void readImage(int i, ReadImageResponse readImageResponse);

    void readCustomData(int i, String16 string16, ReadCustomDataResponse readCustomDataResponse);

    void writeText(BigString16 bigString16);

    void writeHtml(BigString16 bigString16, Url url);

    void writeSmartPasteMarker();

    void writeCustomData(Map<String16, BigString16> map);

    void writeBookmark(String str, String16 string16);

    void writeImage(Bitmap bitmap);

    void commitWrite();
}
