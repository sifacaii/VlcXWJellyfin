package org.chromium.content.browser.picker;

import android.os.Build;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/picker/DateDialogNormalizer.class */
public class DateDialogNormalizer {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/picker/DateDialogNormalizer$DateAndMillis.class */
    private static class DateAndMillis {
        public final long millisForPicker;
        public final int year;
        public final int month;
        public final int day;

        DateAndMillis(long millisForPicker, int year, int month, int day) {
            this.millisForPicker = millisForPicker;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        static DateAndMillis create(long millisUtc) {
            GregorianCalendar utcCal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
            utcCal.setGregorianChange(new Date(Long.MIN_VALUE));
            utcCal.setTimeInMillis(millisUtc);
            int year = utcCal.get(1);
            int month = utcCal.get(2);
            int day = utcCal.get(5);
            return create(year, month, day);
        }

        static DateAndMillis create(int year, int month, int day) {
            Calendar defaultTimeZoneCal = Calendar.getInstance(TimeZone.getDefault());
            defaultTimeZoneCal.clear();
            defaultTimeZoneCal.set(year, month, day);
            long millisForPicker = defaultTimeZoneCal.getTimeInMillis();
            return new DateAndMillis(millisForPicker, year, month, day);
        }
    }

    private static void setLimits(DatePicker picker, long currentMillisForPicker, long minMillisForPicker, long maxMillisForPicker) {
        if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) {
            minMillisForPicker = Math.max(minMillisForPicker, currentMillisForPicker - 157680000000000L);
            maxMillisForPicker = Math.min(maxMillisForPicker, currentMillisForPicker + 157680000000000L);
        }
        if (minMillisForPicker > picker.getMaxDate()) {
            picker.setMaxDate(maxMillisForPicker);
            picker.setMinDate(minMillisForPicker);
            return;
        }
        picker.setMinDate(minMillisForPicker);
        picker.setMaxDate(maxMillisForPicker);
    }

    public static void normalize(DatePicker picker, DatePicker.OnDateChangedListener listener, int year, int month, int day, long minMillisUtc, long maxMillisUtc) {
        DateAndMillis currentDate = DateAndMillis.create(year, month, day);
        DateAndMillis minDate = DateAndMillis.create(minMillisUtc);
        DateAndMillis maxDate = DateAndMillis.create(maxMillisUtc);
        if (maxDate.millisForPicker < minDate.millisForPicker) {
            maxDate = minDate;
        }
        if (currentDate.millisForPicker < minDate.millisForPicker) {
            currentDate = minDate;
        } else if (currentDate.millisForPicker > maxDate.millisForPicker) {
            currentDate = maxDate;
        }
        setLimits(picker, currentDate.millisForPicker, minDate.millisForPicker, maxDate.millisForPicker);
        picker.init(currentDate.year, currentDate.month, currentDate.day, listener);
    }
}
