package com.lakala.bmcp.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.lakala.bmcp.util.ClearImageHelper;
import com.lakala.bmcp.util.OcrContent;
import com.lakala.bmcp.util.ScreenShot;

public class LoginPage3 extends LoginPage2{
	
	
	protected static WebDriver driver = null;
	//私有化构造函数
	protected LoginPage3(){
	}
	//实例
	private static LoginPage3 loginPage = new LoginPage3(); 
	//返回该同一个实例
	public static LoginPage3 getInstance(WebDriver dr){
		driver = dr;
	    ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,120);
	    PageFactory.initElements(finder, loginPage);
		return loginPage;
	}
	
	//用户输入框
	@FindBy(id="username$text")
	private WebElement usernameInputBox;
	
	//密码输入框
	@FindBy(id="pwd$text")
	private WebElement passwordInputBox;
	
	//验证码输入框
	@FindBy(id="authCode$text")
	private WebElement captchaInputBox;
	
	//错误提示
	@FindBy(id="errMsg")
	private WebElement errorMsg;
	
	//验证码图片
//	@FindBy(how = How.ID,using ="vercode")
	@FindBy(id="img_code")
	private WebElement captchaDisplay;
	
	//登录按钮
	@FindBy(linkText="登录")
	private WebElement loginButton;
	
	//重置按钮
	@FindBy(linkText="重置")
	private WebElement resetButton;
	
	//找回密码link
	@FindBy(linkText="找回密码")
	private WebElement findPasswordBack;

	private final String USERNAME_DEPING = "deping";
	private final String PASSWORD_DEPING = "11111111abc";

	//登录
	public void login() throws Exception{
		usernameInputBox.sendKeys(USERNAME_DEPING);
		passwordInputBox.sendKeys(PASSWORD_DEPING);
		captchaInputBox.sendKeys(this.getCaptcha());
		loginButton.click();
		return;
	}
	
	//读取验证码
	private String getCaptcha() throws Exception{
		//createElementImage把验证码取出，cleanImage去噪点
		String captchaTmpFile = ClearImageHelper.cleanImage(ScreenShot.createElementImage(captchaDisplay, driver),"D://SeleniumCaptcha/");
		System.out.println(captchaTmpFile+".txt");
		OcrContent.runTesseract(captchaTmpFile, captchaTmpFile);
		String Captcha = OcrContent.readOCRFile(captchaTmpFile+".txt");
		System.out.println(Captcha);
		return Captcha;
	}
	
	
	//点击更新验证码
	public void updateCaptcha(){
		captchaDisplay.click();
	}
	
	//找回密码跳转
	public void forgotPassword(){
		findPasswordBack.click();
	}
	
	public void loginButton(){
		loginButton.click();
		resetButton.click();
	}

	
}