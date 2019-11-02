package com.example.hyperlearner.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtils  {
    public static final String UI_DATE_FORMAT = "MM/dd/yyyy";
    public static final String DB_DATE_FORMAT = "yyyy-MM-dd";




    public static String getCurrentDateInDBFormat(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DB_DATE_FORMAT);
        return dateFormat.format(date);

    }


    public static Date getDateFromString(String dateString , String format){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertDateFormats(Date date,String targetFormat){
        SimpleDateFormat dateFormat = new SimpleDateFormat(targetFormat);
        return dateFormat.format(date);

    }

}
