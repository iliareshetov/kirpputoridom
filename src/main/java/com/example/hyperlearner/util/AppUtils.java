package com.example.hyperlearner.util;

import java.sql.Date;
import java.sql.Timestamp;

public class AppUtils {

    public static Timestamp getServerTime(){
        return  new Timestamp(System.currentTimeMillis());
    }
}
