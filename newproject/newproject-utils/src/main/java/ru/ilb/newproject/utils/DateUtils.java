package ru.ilb.newproject.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ru.ilb.newproject.utils.Coalesce.coalesce;

/**
 *
 * @author AndrewSych
 */
public class DateUtils {

    /**
     * Конвертер LocalDate ? Date
     *
     * @param localDate
     * @return Date
     */
    public static Date asDate(LocalDate localDate) {
        return localDate != null ? Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()) : null;
    }

    /**
     * Конвертер LocalDateTime ? Date
     *
     * @param localDateTime
     * @return Date
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return localDateTime != null ? Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()) : null;
    }

    /**
     * Конвертер Date ? LocalDate
     *
     * @param date
     * @return LocalDate
     */
    public static LocalDate asLocalDate(Date date) {
        return date != null ? Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate() : null;
    }

    /**
     * Конвертер Date ? LocalDateTime
     *
     * @param date
     * @return LocalDateTime
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        return date != null ? Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
    }

    /**
     * Конвертер Date в String (По умолчанию формат yyyy-MM-dd HH:mm:ss)
     *
     * @param date
     * @param format
     * @return String
     */
    public static String toString(Date date, String format) {
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * Конвертер Date в String в формате yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return String
     */
    public static String toStringDateTime(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    /**
     * Конвертер Date в String в формате yyyy-MM-dd
     *
     * @param date
     * @return String
     */
    public static String toStringDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    /**
     * Конвертер Date в String в формате HH:mm:ss
     *
     * @param date
     * @return String
     */
    public static String toStringTime(Date date) {
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }

    /**
     * Конвертер LocalDate в String (по умолчанию формат yyyy-MM-dd)
     *
     * @param date
     * @param format формате?: yyyy-MM-dd
     * @return String
     */
    public static String toString(LocalDate date, String format) {
        if (format == null) {
            format = "yyyy-MM-dd";
        }
        return DateTimeFormatter.ofPattern(format).format(date);
    }

    /**
     * Конвертер LocalDateTime в String (по умолчанию формат yyyy-MM-dd)
     * HH:mm:ss)
     *
     * @param date
     * @param format Например: yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String toString(LocalDateTime date, String format) {
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        return DateTimeFormatter.ofPattern(format).format(date);
    }

    /**
     * Конвертер String в LocalDate
     *
     * @param date
     * @param format
     * @return LocalDate
     */
    public static LocalDate asLocalDate(String date, String format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * Конвертер String в Date
     *
     * @param date
     * @param format
     * @return Date
     */
    public static Date asDate(String date, String format) {

        Date res = null;
        if (date != null && !date.isEmpty()) {
            try {
                DateFormat dateFormat = new SimpleDateFormat(coalesce(format, "yyyy-MM-dd"));
                res = dateFormat.parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

        return res;
    }

}
