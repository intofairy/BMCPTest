package com.lakala.bmcp.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.lakala.bmcp.page.LoginPage2;


public class LoginPage2Test {

  @Test
  public void login() throws Exception {
	  FirefoxProfile profile = new ProfilesIni().getProfile("default");
		JavaSendKey jsk = new JavaSendKey();
		Thread t1 = new Thread(jsk);
		
		WebDriver driver = new FirefoxDriver(profile);
		t1.start();
		driver.get("https://10.7.111.153:9443/");
		
		LoginPage2 lp=LoginPage2.getInstance(driver);
		lp.login();
		//String yanzhengma=lp.getCaptcha();
//		System.out.println(yanzhengma);
		driver.quit();
  }
}
