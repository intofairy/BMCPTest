package com.lakala.bmcp.page;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.lakala.bmcp.test.JavaSendKey;
import com.lakala.bmcp.util.ClearImageHelper;
import com.lakala.bmcp.util.OcrContent;
import com.lakala.bmcp.util.ScreenShot;

public class LoginPage  {
	
	
	private static WebDriver driver = null;
	//˽�л����캯��
	private LoginPage(){
	}
	//ʵ��
	private static LoginPage loginPage = new LoginPage(); 
	//���ظ�ͬһ��ʵ��
	public static LoginPage getInstance(WebDriver dr){
		driver = dr;
	    ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,120);
	    PageFactory.initElements(finder, loginPage);
		return loginPage;
	}
	
	//�û������
	@FindBy(id="username")
	private WebElement usernameInputBox;
	
	//���������
	@FindBy(id="password")
	private WebElement passwordInputBox;
	
	//��֤�������
	@FindBy(id="authCode")
	private WebElement captchaInputBox;
	
	//������ʾ
	@FindBy(id="errMsg")
	private WebElement errorMsg;
	
	//��֤��ͼƬ
//	@FindBy(how = How.ID,using ="vercode")
	@FindBy(id="vercode")
	private WebElement captchaDisplay;
	
	//��¼��ť
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	//�һ�����link
	@FindBy(linkText="�һ�����")
	private WebElement findPasswordBack;

	private final String USERNAME_DEPING = "deping";
	private final String PASSWORD_DEPING = "11111111abc";

	//��¼
	public void login() throws Exception{
		usernameInputBox.sendKeys(USERNAME_DEPING);
		passwordInputBox.sendKeys(PASSWORD_DEPING);
		captchaInputBox.sendKeys(this.getCaptcha());
		loginButton.click();
		return;
	}
	
	//��ȡ��֤��
	private String getCaptcha() throws Exception{
		//createElementImage����֤��ȡ����cleanImageȥ���
		String captchaTmpFile = ClearImageHelper.cleanImage(ScreenShot.createElementImage(captchaDisplay, driver),"D://SeleniumCaptcha/");
		System.out.println(captchaTmpFile+".txt");
		OcrContent.runTesseract(captchaTmpFile, captchaTmpFile);
		String Captcha = OcrContent.readOCRFile(captchaTmpFile+".txt");
		System.out.println(Captcha);
		return Captcha;
	}
	
	
	//���������֤��
	public void updateCaptcha(){
		captchaDisplay.click();
	}
	
	//�һ�������ת
	public void forgotPassword(){
		findPasswordBack.click();
	}
	
	
	
	public static void main(String args[]) throws Exception {
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		JavaSendKey jsk = new JavaSendKey();
		Thread t1 = new Thread(jsk);
		
		WebDriver driver = new FirefoxDriver(profile);
		t1.start();
		driver.get("https://10.7.111.153:9443/");
		
		LoginPage lp=LoginPage.getInstance(driver);
		lp.getCaptcha();
		//String yanzhengma=lp.getCaptcha();
//		System.out.println(yanzhengma);
		driver.quit();
		return;
	}
}
