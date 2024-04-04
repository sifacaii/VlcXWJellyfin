package org.chromium.ui;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/ContactsPickerListener.class */
public interface ContactsPickerListener {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/ContactsPickerListener$ContactsPickerAction.class */
    public @interface ContactsPickerAction {
        public static final int CANCEL = 0;
        public static final int CONTACTS_SELECTED = 1;
        public static final int SELECT_ALL = 2;
        public static final int UNDO_SELECT_ALL = 3;
        public static final int NUM_ENTRIES = 4;
    }

    void onContactsPickerUserAction(int i, List<Contact> list);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/ContactsPickerListener$Contact.class */
    public static class Contact {
        public final List<String> names;
        public final List<String> emails;
        public final List<String> tel;

        public Contact(List<String> contactNames, List<String> contactEmails, List<String> contactTel) {
            this.names = contactNames;
            this.emails = contactEmails;
            this.tel = contactTel;
        }
    }
}
