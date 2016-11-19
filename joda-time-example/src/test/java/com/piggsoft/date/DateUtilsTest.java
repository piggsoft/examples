package com.piggsoft.date;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by piggs on 2016/11/18.
 */
public class DateUtilsTest {
    public static void main(String[] args) {
        Date date = new Date();

        log("本天中午时间", DateUtils.timeAtNoonOfTheDay(date));

        log("本天开始时间", DateUtils.timeAtStartOfTheDay(date));
        log("本天结束时间", DateUtils.timeAtEndOfTheDay(date));

        log("本周开始时间", DateUtils.timeAtStartOfTheWeek(date));
        log("本周结束时间", DateUtils.timeAtEndOfTheWeek(date));

        log("本月开始时间", DateUtils.timeAtStartOfTheMonth(date));
        log("本月结束时间", DateUtils.timeAtEndOfTheMonth(date));

        log("本季度开始时间", DateUtils.timeAtStartOfTheQuarter(date));
        log("本季度结束时间", DateUtils.timeAtEndOfTheQuarter(date));

        log("本年开始时间", DateUtils.timeAtStartOfTheYear(date));
        log("本年结束时间", DateUtils.timeAtEndOfTheYear(date));

    }

    public static void log(String prefix, DateTime dateTime) {
        System.out.println(prefix + " : " + dateTime.toString("yyyy-MM-dd HH:mm:ss"));
    }
}