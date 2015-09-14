package com.lakala.bmcp.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class testGetCookies {
	public static void main(String[] args){
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		driver.get("https://10.7.111.50:9443/index.htm");
		
		driver.findElement(By.id("username")).sendKeys("deping");
		driver.findElement(By.id("password")).sendKeys("11111111abc");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		driver.findElement(By.id("loginButton")).click();
		
		File cookieFile = new File("C:/outman/bmcp.txt");
		try
		{
			cookieFile.delete();
			cookieFile.createNewFile();
			FileWriter filewriter = new FileWriter(cookieFile);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			
			for (Cookie cookie : driver.manage().getCookies()){
				System.out.println(cookie.toString());
				bufferedwriter.write(cookie.getName()+";"
									+cookie.getValue()+";"
									+cookie.getDomain()+";"
									+cookie.getPath()+";"
									+cookie.getExpiry()+";"
									+cookie.isSecure());
				bufferedwriter.newLine();
			}
			bufferedwriter.flush();
			bufferedwriter.close();
			filewriter.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		driver.quit();
	}
}
