package com.tstcore.easybank.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DAY_PATTERN = "E";
    private static final DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("E");
    private static final DateTimeFormatter  dateFormatter= DateTimeFormatter.ofPattern(DATE_PATTERN, Locale.ENGLISH);
    private static final DateTimeFormatter  timeFormatter= DateTimeFormatter.ofPattern(TIME_PATTERN,Locale.ENGLISH);

    public static String getDateFormat() {
        return dateFormatter.format(LocalDateTime.now());
    }
    public static String getTimeFormat() { return timeFormatter.format(LocalDateTime.now()); }
    public static String getDayFormat() { return dayFormatter.format(LocalDateTime.now()); }
    public static LocalDateTime getDate(String date) {
        CharSequence charSequence = new StringBuffer(date);
        CharSequence charSequence1 = new StringBuilder(date);
        return LocalDateTime.parse(charSequence); }
    public static LocalDateTime geTime(String time) { return LocalDateTime.parse(time); }
}
