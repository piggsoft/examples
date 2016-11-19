package com.piggsoft.date;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by piggs on 2016/11/18.
 */
public class DateUtils {

    /**
     * 本天的中午时间
     * @param date
     * @return
     */
    public static DateTime timeAtNoonOfTheDay(Date date) {
        return new DateTime(date).withTime(12, 0, 0, 0);
    }

  /**
     * 本天的开始时间
     * @param date
     * @return
     */
    public static DateTime timeAtStartOfTheDay(Date date) {
        return new DateTime(date).withTimeAtStartOfDay();
    }

    /**
     * 本天的结束时间
     * @param date
     * @return
     */
    public static DateTime timeAtEndOfTheDay(Date date) {
        return new DateTime(date).millisOfDay().withMaximumValue();
    }

    /**
     * 本周的开始时间
     * @param date
     * @return
     */
    public static DateTime timeAtStartOfTheWeek(Date date) {
       return new DateTime(date).dayOfWeek().withMinimumValue().withTimeAtStartOfDay();
    }

    /**
     * 本周的结束时间
     * @param date
     * @return
     */
    public static DateTime timeAtEndOfTheWeek(Date date) {
        return new DateTime(date).dayOfWeek().withMaximumValue().millisOfDay().withMaximumValue();
    }

    /**
     * 本月的开始时间
     * @param date
     * @return
     */
    public static DateTime timeAtStartOfTheMonth(Date date) {
        return new DateTime(date).dayOfMonth().withMinimumValue().withTimeAtStartOfDay();
    }

    /**
     * 本月的结束时间
     * @param date
     * @return
     */
    public static DateTime timeAtEndOfTheMonth(Date date) {
        return new DateTime(date).dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue();
    }

    /**
     * 本季度的开始时间
     * @param date
     * @return
     */
    public static DateTime timeAtStartOfTheQuarter(Date date) {
        return quarterStartFor(new DateTime(date)).withTimeAtStartOfDay();
    }

    /**
     * 本季度的结束时间
     * @param date
     * @return
     */
    public static DateTime timeAtEndOfTheQuarter(Date date) {
        return quarterEndFor(new DateTime(date)).millisOfDay().withMaximumValue();
    }

    private static DateTime quarterStartFor(DateTime date) {
        return date.withDayOfMonth(1).withMonthOfYear((((date.getMonthOfYear() - 1) / 3) * 3) + 1);
    }

    private static DateTime quarterEndFor(DateTime date) {
        return quarterStartFor(date).plusMonths(3).minusDays(1);
    }

    /**
     * 本年的开始时间
     * @param date
     * @return
     */
    public static DateTime timeAtStartOfTheYear(Date date) {
        return new DateTime(date).dayOfYear().withMinimumValue().withTimeAtStartOfDay();
    }

    /**
     * 本年的结束时间
     * @param date
     * @return
     */
    public static DateTime timeAtEndOfTheYear(Date date) {
        return new DateTime(date).dayOfYear().withMaximumValue().millisOfDay().withMaximumValue();
    }
}
