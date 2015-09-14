package com.lakala.bmcp.page;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lakala.bmcp.util.ClearImageHelper;
import com.lakala.bmcp.util.OcrContent;
import com.lakala.bmcp.util.ScreenShot;

public class LoginPage  {
	
	//私有化构造函数
	private static WebDriver driver = null;
	
	private LoginPage(){
	}
	//实例
	private static LoginPage loginPage = new LoginPage(); 
	//返回该同一个实例
	public static LoginPage getInstance(WebDriver dr){
		driver = dr;
		return loginPage;
	}
	
	//用户输入框
	@FindBy(id="username")
	private WebElement usernameInputBox;
	
	//密码输入框
	@FindBy(id="password")
	private WebElement passwordInputBox;
	
	//验证码输入框
	@FindBy(id="authCode")
	private WebElement captchaInputBox;
	
	//错误提示
	@FindBy(id="errMsg")
	private WebElement errorMsg;
	
	//验证码图片
	@FindBy(id="vercode")
	private WebElement captchaDisplay;
	
	//找回密码link
	@FindBy(linkText="找回密码")
	private WebElement findPasswordBack;

	private final String USERNAME_DEPING = "deping";
	private final String PASSWORD_DEPING = "11111111abc";
    
	
	//登录
	public void login() throws IOException{
		usernameInputBox.sendKeys(USERNAME_DEPING);
		passwordInputBox.sendKeys(PASSWORD_DEPING);
		String captchaTmpFile = ClearImageHelper.cleanImage(ScreenShot.createElementImage(captchaDisplay, driver),"D://SeleniumCaptcha/");
		
	}
	
	//点击更新验证码
	public void updateCaptcha(){
		captchaDisplay.click();
	}
	
	//找回密码跳转
	public void forgotPassword(){
		findPasswordBack.click();
	}
}
