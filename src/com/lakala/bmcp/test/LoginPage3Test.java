package com.lakala.bmcp.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.lakala.bmcp.page.LoginPage3;

public class LoginPage3Test {

	private final String BMCP3ADRESS = "http://10.7.111.161:8088";
	
	@Test
	public void LoginPage3() throws Exception {
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
			
		WebDriver driver = new FirefoxDriver(profile);
	
		driver.get(BMCP3ADRESS);
			
		LoginPage3 lp3=LoginPage3.getInstance(driver);
		Assert.assertEquals("收单商户管理系统",lp3);
	}
  
}
