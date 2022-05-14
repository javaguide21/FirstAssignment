package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonDate {
	public static Date getDate(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date1=null;
		try {
			date1=sdf.parse(date);
		}catch (Exception e) {
			e.printStackTrace();		}

		return date1;
	}}
