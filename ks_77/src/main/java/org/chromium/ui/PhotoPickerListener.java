package org.chromium.ui;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/PhotoPickerListener.class */
public interface PhotoPickerListener {
    public static final int TAKE_PHOTO_REQUEST = 1;
    public static final int SHOW_GALLERY = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/PhotoPickerListener$PhotoPickerAction.class */
    public @interface PhotoPickerAction {
        public static final int CANCEL = 0;
        public static final int PHOTOS_SELECTED = 1;
        public static final int LAUNCH_CAMERA = 2;
        public static final int LAUNCH_GALLERY = 3;
        public static final int NUM_ENTRIES = 4;
    }

    void onPhotoPickerUserAction(int i, Uri[] uriArr);
}
