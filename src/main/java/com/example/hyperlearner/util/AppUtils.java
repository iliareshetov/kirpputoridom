package com.example.hyperlearner.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppUtils {
    public static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";

    public static Timestamp getServerTime() {
        return new Timestamp(System.currentTimeMillis());

    }

    public static Date parseDateWithoutTimeStamp(String dateString,String dateFormat) {
        SimpleDateFormat sdf1 = new SimpleDateFormat(dateFormat);
        java.util.Date date = null;
        try {
            date = sdf1.parse(dateString);
        } catch (ParseException e) {
            e.getMessage();
        }
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        return sqlStartDate;
    }

    public static Date parseDateWithoutTimeStamp(String dateString) {
        return parseDateWithoutTimeStamp(dateString,DEFAULT_DATE_FORMAT);
    }
}
