package com.fsn.twitter.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CommonFunc {
	
	//현재시간 구하기 
	public static String now_date(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA ); 
    	Date currentTime = new Date ( ); 
    	String dTime = formatter.format ( currentTime ); 
    	
    	return dTime;
	}
}
