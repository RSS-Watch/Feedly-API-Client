package org.feedlyapi.help;

import java.util.Calendar;

public class FormatHelper {

    public static String formatDateTime(Calendar calendar) {
        return leadingZero(calendar.get(Calendar.DAY_OF_MONTH)) + "."
                + leadingZero(calendar.get(Calendar.MONTH)) + "."
                + leadingZero(calendar.get(Calendar.YEAR)) + " "
                + leadingZero(calendar.get(Calendar.HOUR_OF_DAY)) + ":"
                + leadingZero(calendar.get(Calendar.MINUTE));
    }

    private static String leadingZero(int number) {
        if (number > 9)
            return String.valueOf(number);
        else
            return "" + number;
    }
}
