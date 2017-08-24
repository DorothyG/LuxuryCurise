/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pupu
 */
public class DateUtil {

    public static String stringDateFormat(String str) throws ParseException{
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf1.parse(str);
        return sdf2.format(d);
    }
    public static String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String d = sdf.format(date);
        System.out.println(d);
        return d;
    }
    
    public static Date stringToDate(String datetime) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(datetime);
    }
//    public static void main(String[] args) {
//        System.out.println(DateUtil.dateFormat("2016-09-29 12:22:57.000"));
//    }
}
