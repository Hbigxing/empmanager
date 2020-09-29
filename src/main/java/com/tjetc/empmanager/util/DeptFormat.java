package com.tjetc.empmanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeptFormat {
    public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    public static String dateToString(Date d){return sdf.format(d);}
    public static Date stringToDate(String s){
        try{
            return sdf.parse(s);
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }

}
