package com.cognizant.truyum.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateUtil {
public static Date convertToDate(String date) {
	SimpleDateFormat s=new SimpleDateFormat("dd/mm/yyy");
	Date date1;
	try {
		date1=s.parse(date);
		return date1;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
}
