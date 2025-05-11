package org.chromium.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/MimeTypeFilter.class */
public class MimeTypeFilter implements FileFilter {
    private HashSet<String> mExtensions = new HashSet<>();
    private HashSet<String> mMimeTypes = new HashSet<>();
    private HashSet<String> mMimeSupertypes = new HashSet<>();
    private MimeTypeMap mMimeTypeMap;
    private boolean mAcceptAllMimeTypes;
    private boolean mAcceptDirectory;

    public MimeTypeFilter(@NonNull List<String> mimeTypes, boolean acceptDirectory) {
        for (String field : mimeTypes) {
            String field2 = field.trim().toLowerCase(Locale.US);
            if (field2.startsWith(".")) {
                this.mExtensions.add(field2.substring(1));
            } else if (field2.equals("*/*")) {
                this.mAcceptAllMimeTypes = true;
            } else if (field2.endsWith("/*")) {
                this.mMimeSupertypes.add(field2.substring(0, field2.length() - 2));
            } else if (field2.contains("/")) {
                this.mMimeTypes.add(field2);
            }
        }
        this.mMimeTypeMap = MimeTypeMap.getSingleton();
        this.mAcceptDirectory = acceptDirectory;
    }

    public boolean accept(Uri uri, String mimeType) {
        if (uri != null) {
            String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase(Locale.US);
            if (this.mExtensions.contains(fileExtension)) {
                return true;
            }
            if (mimeType == null) {
                mimeType = getMimeTypeFromExtension(fileExtension);
            }
        }
        if (mimeType != null) {
            if (this.mAcceptAllMimeTypes || this.mMimeTypes.contains(mimeType) || this.mMimeSupertypes.contains(getMimeSupertype(mimeType))) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // java.io.FileFilter
    public boolean accept(@NonNull File file) {
        if (file.isDirectory()) {
            return this.mAcceptDirectory;
        }
        return accept(Uri.fromFile(file), null);
    }

    private String getMimeTypeFromExtension(@NonNull String ext) {
        String mimeType = this.mMimeTypeMap.getMimeTypeFromExtension(ext);
        if (mimeType != null) {
            return mimeType.toLowerCase(Locale.US);
        }
        return null;
    }

    @NonNull
    private static String getMimeSupertype(@NonNull String mimeType) {
        return mimeType.split("/", 2)[0];
    }
}
