package it.mystic.chat.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date subtractHours(Date date, Integer hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -hours);
        return calendar.getTime();
    }

    public static Date subtractMonth(Date data, Integer months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MONTH, -months);
        return cal.getTime();
    }

    public static Date subtractYear(Date data, Integer years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.YEAR, -years);
        return cal.getTime();
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.of("Europe/Rome")).toInstant());
    }
}
