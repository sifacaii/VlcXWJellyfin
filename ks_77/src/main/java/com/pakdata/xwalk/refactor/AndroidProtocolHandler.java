package com.pakdata.xwalk.refactor;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.List;
import java.util.Locale;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/AndroidProtocolHandler.class */
public class AndroidProtocolHandler {
    private static final String TAG = "AndroidProtocolHandler";
    public static final String FILE_SCHEME = "file";
    private static final String CONTENT_SCHEME = "content";
    public static final String APP_SCHEME = "app";
    private static final String APP_SRC = "www";
    private static final String SCHEME_SEPARATOR = "//";
    static final /* synthetic */ boolean $assertionsDisabled;

    private static native void nativeSetResourceContextForTesting(Context context);

    private static native String nativeGetAndroidAssetPath();

    private static native String nativeGetAndroidResourcePath();

    static {
        $assertionsDisabled = !AndroidProtocolHandler.class.desiredAssertionStatus();
    }

    @CalledByNative
    public static InputStream open(String url) {
        Uri uri = verifyUrl(url);
        if (uri == null) {
            return null;
        }
        try {
            Context context = ContextUtils.getApplicationContext();
            String path = uri.getPath();
            if (uri.getScheme().equals(FILE_SCHEME)) {
                if (path.startsWith(nativeGetAndroidAssetPath())) {
                    return openAsset(context, uri);
                }
                if (path.startsWith(nativeGetAndroidResourcePath())) {
                    return openResource(context, uri);
                }
                return null;
            } else if (uri.getScheme().equals(CONTENT_SCHEME)) {
                return openContent(context, uri);
            } else {
                if (uri.getScheme().equals(APP_SCHEME) && uri.getHost().equals(context.getPackageName().toLowerCase(Locale.getDefault())) && path.length() > 1) {
                    return openAsset(context, appUriToFileUri(uri));
                }
                return null;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error opening inputstream: " + url);
            return null;
        }
    }

    public static String getAssetPath(Uri uri) {
        if ($assertionsDisabled || uri.getScheme().equals(FILE_SCHEME)) {
            if ($assertionsDisabled || uri.getPath() != null) {
                if ($assertionsDisabled || uri.getPath().startsWith(nativeGetAndroidAssetPath())) {
                    String path = uri.getPath();
                    return new File(path).getAbsolutePath().replaceFirst(nativeGetAndroidAssetPath(), CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE);
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Uri appUriToFileUri(Uri uri) {
        if ($assertionsDisabled || uri.getScheme().equals(APP_SCHEME)) {
            if ($assertionsDisabled || uri.getPath() != null) {
                try {
                    URI fileUri = new URI(FILE_SCHEME, SCHEME_SEPARATOR + nativeGetAndroidAssetPath() + APP_SRC + uri.getPath(), null);
                    return Uri.parse(fileUri.normalize().toString());
                } catch (URISyntaxException e) {
                    Log.e(TAG, "Unable to convert app URI to file URI: " + uri, e);
                    return null;
                }
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static String getUrlContent(Context context, String url) throws IOException {
        InputStream stream = open(url);
        if (stream == null) {
            throw new RuntimeException("Failed to open the url: " + url);
        }
        String content = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
        try {
            byte[] buffer = new byte[1024];
            while (true) {
                int actualSize = stream.read(buffer, 0, 1024);
                if (actualSize > 0) {
                    content = content + new String(buffer, 0, actualSize);
                } else {
                    return content;
                }
            }
        } finally {
            stream.close();
        }
    }

    private static int getFieldId(Context context, String assetType, String assetName) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> d = context.getClassLoader().loadClass(context.getPackageName() + ".R$" + assetType);
        Field field = d.getField(assetName);
        int id = field.getInt(null);
        return id;
    }

    private static int getValueType(Context context, int fieldId) {
        TypedValue value = new TypedValue();
        context.getResources().getValue(fieldId, value, true);
        return value.type;
    }

    private static InputStream openResource(Context context, Uri uri) {
        if ($assertionsDisabled || uri.getScheme().equals(FILE_SCHEME)) {
            if ($assertionsDisabled || uri.getPath() != null) {
                if ($assertionsDisabled || uri.getPath().startsWith(nativeGetAndroidResourcePath())) {
                    List<String> pathSegments = uri.getPathSegments();
                    if (pathSegments.size() != 3) {
                        Log.e(TAG, "Incorrect resource path: " + uri);
                        return null;
                    }
                    String assetPath = pathSegments.get(0);
                    String assetType = pathSegments.get(1);
                    String assetName = pathSegments.get(2);
                    if (!("/" + assetPath + "/").equals(nativeGetAndroidResourcePath())) {
                        Log.e(TAG, "Resource path does not start with " + nativeGetAndroidResourcePath() + ": " + uri);
                        return null;
                    }
                    String assetName2 = assetName.split("\\.")[0];
                    try {
                        if (context.getApplicationContext() != null) {
                            context = context.getApplicationContext();
                        }
                        int fieldId = getFieldId(context, assetType, assetName2);
                        int valueType = getValueType(context, fieldId);
                        if (valueType == 3) {
                            return context.getResources().openRawResource(fieldId);
                        }
                        Log.e(TAG, "Asset not of type string: " + uri);
                        return null;
                    } catch (ClassNotFoundException e) {
                        Log.e(TAG, "Unable to open resource URL: " + uri, e);
                        return null;
                    } catch (IllegalAccessException e2) {
                        Log.e(TAG, "Unable to open resource URL: " + uri, e2);
                        return null;
                    } catch (NoSuchFieldException e3) {
                        Log.e(TAG, "Unable to open resource URL: " + uri, e3);
                        return null;
                    }
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static InputStream openAsset(Context context, Uri uri) {
        if ($assertionsDisabled || uri.getScheme().equals(FILE_SCHEME)) {
            if ($assertionsDisabled || uri.getPath() != null) {
                if ($assertionsDisabled || uri.getPath().startsWith(nativeGetAndroidAssetPath())) {
                    try {
                        AssetManager assets = context.getAssets();
                        return assets.open(getAssetPath(uri), 2);
                    } catch (IOException e) {
                        Log.e(TAG, "Unable to open asset URL: " + uri);
                        return null;
                    }
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static InputStream openContent(Context context, Uri uri) {
        if ($assertionsDisabled || uri.getScheme().equals(CONTENT_SCHEME)) {
            try {
                Uri baseUri = stripQueryParameters(uri);
                return context.getContentResolver().openInputStream(baseUri);
            } catch (Exception e) {
                Log.e(TAG, "Unable to open content URL: " + uri);
                return null;
            }
        }
        throw new AssertionError();
    }

    @CalledByNative
    public static String getMimeType(InputStream stream, String url) {
        String mimeType;
        Uri uri = verifyUrl(url);
        if (uri == null) {
            return null;
        }
        try {
            Context context = ContextUtils.getApplicationContext();
            String path = uri.getPath();
            if (uri.getScheme().equals(CONTENT_SCHEME)) {
                return context.getContentResolver().getType(uri);
            }
            if ((uri.getScheme().equals(APP_SCHEME) || (uri.getScheme().equals(FILE_SCHEME) && path.startsWith(nativeGetAndroidAssetPath()))) && (mimeType = URLConnection.guessContentTypeFromName(path)) != null) {
                return mimeType;
            }
            try {
                return URLConnection.guessContentTypeFromStream(stream);
            } catch (IOException e) {
                return null;
            }
        } catch (Exception e2) {
            Log.e(TAG, "Unable to get mime type" + url);
            return null;
        }
    }

    @CalledByNative
    public static String getPackageName() {
        try {
            return ContextUtils.getApplicationContext().getPackageName();
        } catch (Exception e) {
            Log.e(TAG, "Unable to get package name");
            return null;
        }
    }

    private static Uri verifyUrl(String url) {
        if (url == null) {
            return null;
        }
        Uri uri = Uri.parse(url);
        if (uri == null) {
            Log.e(TAG, "Malformed URL: " + url);
            return null;
        }
        String path = uri.getPath();
        if (path == null || path.length() == 0) {
            Log.e(TAG, "URL does not have a path: " + url);
            return null;
        }
        return uri;
    }

    private static Uri stripQueryParameters(Uri uri) {
        if ($assertionsDisabled || uri.getAuthority() != null) {
            if ($assertionsDisabled || uri.getPath() != null) {
                Uri.Builder builder = new Uri.Builder();
                builder.scheme(uri.getScheme());
                builder.encodedAuthority(uri.getAuthority());
                builder.encodedPath(uri.getPath());
                return builder.build();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static void setResourceContextForTesting(Context context) {
        nativeSetResourceContextForTesting(context);
    }
}
