package org.uiframework.com.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    private DateUtils() {
        throw new UnsupportedOperationException("This is an utility class and cannot be instantiaded");
    }

    public static String getCurrentDateString(String format) {
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        return now.format(DateTimeFormatter.ofPattern(format));
    }

    public static String getCurrentTimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String changeDateFormat(String dateString, String inputFormat, String outputFormat){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat);
        LocalDate date = LocalDate.parse(dateString, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat);
        return date.format(outputFormatter);
    }

    public static String changeDateTimeFormat(String timeString, String inputFormat, String outputFormat){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat);
        LocalDateTime date = LocalDateTime.parse(timeString, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat);
        return date.format(outputFormatter);
    }

    public static boolean isDate(String str) {
        try {
            LocalDate.parse(str);
            return true;
        } catch (DateTimeParseException _) {
            return false;
        }
    }
}
