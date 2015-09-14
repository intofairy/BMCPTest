package com.lakala.bmcp.test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.lakala.bmcp.util.ClearImageHelper;
import com.lakala.bmcp.util.OcrContent;
import com.lakala.bmcp.util.ScreenShot;

public class login  {
	private final static String BMCPURL = "https://10.7.111.153:9443/";
	
	public static void main(String args[]) throws Exception {

		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		JavaSendKey jsk = new JavaSendKey();
		Thread t1 = new Thread(jsk);
		
		WebDriver driver = new FirefoxDriver(profile);
		t1.start();
		
		driver.get(BMCPURL);
		
		WebElement webelement = driver.findElement(By.id("authCode"));
		
		String captchaTmpFile = ClearImageHelper.cleanImage(ScreenShot.createElementImage(webelement, driver),"D://SeleniumCaptcha/");
		System.out.println(captchaTmpFile+".txt");
		OcrContent.runTesseract(captchaTmpFile, captchaTmpFile);
		 //Actions action = new Actions(driver); 
		 //try{Thread.sleep(3000);}catch(Exception e){}
		System.out.println(captchaTmpFile+".txt");
		String captcha = OcrContent.readOCRFile(captchaTmpFile+".txt");
		
		driver.findElement(By.id("username")).sendKeys("deping");
		driver.findElement(By.id("password")).sendKeys("11111111abc");
		System.out.println(captcha);
		driver.findElement(By.id("authCode")).sendKeys(captcha); 
		
		driver.findElement(By.id("loginButton")).click();
		 //driver.quit();
		

	}
	

	
}
