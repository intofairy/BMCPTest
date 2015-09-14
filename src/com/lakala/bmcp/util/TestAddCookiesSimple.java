package com.lakala.bmcp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.Date;

public class TestAddCookiesSimple {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		driver.get("https://10.7.111.50:9443/index.htm");
		Date date = getTomorrowDate();
		Cookie cookie1 = new Cookie("BMCP2_1410877","b4a0e5e3-ec75-4efe-9a73-0a109daa33c5","10.7.111.50","/",date,false);
		//Cookie cookie2 = new Cookie("JSESSIONID","3D2F059B8C28A4FD90E93ED4448C4C3C","10.7.111.50","/",null,true);
		
		driver.manage().addCookie(cookie1);
		//driver.manage().addCookie(cookie2);
					
		System.out.println(cookie1.toString());
		//System.out.println(cookie2.toString());
		driver.get("https://10.7.111.50:9443/main.htm");
				
	}
		

	public static Date getTomorrowDate(){
		    Date date = new Date();
		   
		    Calendar calendar = new GregorianCalendar();
		 
		    calendar.setTime(date); 
		 
		    calendar.add(Calendar.DATE, 1);//
		 
		    //把日期往后增加一天.整数往后推,负数往前移动 
		 
		    date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		    
		    return date;
	}
	
}


