package org.chromium.content.browser.picker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.widget.DatePicker;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/picker/DatePickerDialogCompat.class */
class DatePickerDialogCompat extends DatePickerDialog {
    private final DatePickerDialog.OnDateSetListener mCallBack;

    public DatePickerDialogCompat(Context context, DatePickerDialog.OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
        super(context, callBack, year, monthOfYear, dayOfMonth);
        this.mCallBack = callBack;
    }

    @Override // android.app.DatePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        if (which == -1 && this.mCallBack != null) {
            DatePicker datePicker = getDatePicker();
            datePicker.clearFocus();
            this.mCallBack.onDateSet(datePicker, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void setTitle(CharSequence title) {
        if (Build.VERSION.SDK_INT >= 21) {
            title = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
        }
        super.setTitle(title);
    }
}
