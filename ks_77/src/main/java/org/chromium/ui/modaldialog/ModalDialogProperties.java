package org.chromium.ui.modaldialog;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.ui.modelutil.PropertyKey;
import org.chromium.ui.modelutil.PropertyModel;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modaldialog/ModalDialogProperties.class */
public class ModalDialogProperties {
    public static final PropertyModel.ReadableObjectPropertyKey<Controller> CONTROLLER = new PropertyModel.ReadableObjectPropertyKey<>();
    public static final PropertyModel.ReadableObjectPropertyKey<String> CONTENT_DESCRIPTION = new PropertyModel.ReadableObjectPropertyKey<>();
    public static final PropertyModel.WritableObjectPropertyKey<String> TITLE = new PropertyModel.WritableObjectPropertyKey<>();
    public static final PropertyModel.WritableObjectPropertyKey<Drawable> TITLE_ICON = new PropertyModel.WritableObjectPropertyKey<>();
    public static final PropertyModel.WritableObjectPropertyKey<String> MESSAGE = new PropertyModel.WritableObjectPropertyKey<>();
    public static final PropertyModel.WritableObjectPropertyKey<View> CUSTOM_VIEW = new PropertyModel.WritableObjectPropertyKey<>();
    public static final PropertyModel.WritableObjectPropertyKey<String> POSITIVE_BUTTON_TEXT = new PropertyModel.WritableObjectPropertyKey<>();
    public static final PropertyModel.WritableBooleanPropertyKey POSITIVE_BUTTON_DISABLED = new PropertyModel.WritableBooleanPropertyKey();
    public static final PropertyModel.WritableObjectPropertyKey<String> NEGATIVE_BUTTON_TEXT = new PropertyModel.WritableObjectPropertyKey<>();
    public static final PropertyModel.WritableBooleanPropertyKey NEGATIVE_BUTTON_DISABLED = new PropertyModel.WritableBooleanPropertyKey();
    public static final PropertyModel.WritableBooleanPropertyKey CANCEL_ON_TOUCH_OUTSIDE = new PropertyModel.WritableBooleanPropertyKey();
    public static final PropertyModel.ReadableBooleanPropertyKey FILTER_TOUCH_FOR_SECURITY = new PropertyModel.ReadableBooleanPropertyKey();
    public static final PropertyModel.WritableBooleanPropertyKey TITLE_SCROLLABLE = new PropertyModel.WritableBooleanPropertyKey();
    public static final PropertyKey[] ALL_KEYS = {CONTROLLER, CONTENT_DESCRIPTION, TITLE, TITLE_ICON, MESSAGE, CUSTOM_VIEW, POSITIVE_BUTTON_TEXT, POSITIVE_BUTTON_DISABLED, NEGATIVE_BUTTON_TEXT, NEGATIVE_BUTTON_DISABLED, CANCEL_ON_TOUCH_OUTSIDE, FILTER_TOUCH_FOR_SECURITY, TITLE_SCROLLABLE};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modaldialog/ModalDialogProperties$ButtonType.class */
    public @interface ButtonType {
        public static final int POSITIVE = 0;
        public static final int NEGATIVE = 1;
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modaldialog/ModalDialogProperties$Controller.class */
    public interface Controller {
        void onClick(PropertyModel propertyModel, int i);

        void onDismiss(PropertyModel propertyModel, int i);
    }
}
