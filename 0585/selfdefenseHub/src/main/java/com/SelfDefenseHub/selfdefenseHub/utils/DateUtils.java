package com.SelfDefenseHub.selfdefenseHub.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    
    public static String getCurrentDateTime(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
