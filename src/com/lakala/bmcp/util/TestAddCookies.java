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

import java.util.StringTokenizer;
import java.util.Date;

public class TestAddCookies {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		driver.get("https://10.7.111.50:9443/index.htm");
		
		try{
			File cookieFile = new File("C:/outman/bmcp.txt");
			FileReader filereader = new FileReader(cookieFile);
			BufferedReader bufferedreader = new BufferedReader(filereader);
			String line;
			while((line = bufferedreader.readLine()) != null)
			{
				StringTokenizer stringtokenizer = new StringTokenizer(line,";");
				while( stringtokenizer.hasMoreTokens()){
					String name = stringtokenizer.nextToken();
					String value = stringtokenizer.nextToken();
					String domain = stringtokenizer.nextToken();
					String path = stringtokenizer.nextToken();
					Date expiry = null;
					String dt;
					if(!(dt = stringtokenizer.nextToken()).equals("null"))
					{
						expiry = new Date(dt);
					}
					boolean isSecure = new Boolean(stringtokenizer.nextToken()).booleanValue();
					Cookie cookie = new Cookie(name,value,domain,path,new Date(),false);
					driver.manage().addCookie(cookie);
					
					System.out.println(cookie.toString());
					
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		finally{
			
		}
		//System.out.println(cookie.toString());
		driver.get("https://10.7.111.50:9443/main.htm");
	}

}
