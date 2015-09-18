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
	//˽�л����캯��
	protected LoginPage3(){
	}
	//ʵ��
	private static LoginPage3 loginPage = new LoginPage3(); 
	//���ظ�ͬһ��ʵ��
	public static LoginPage3 getInstance(WebDriver dr){
		driver = dr;
	    ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,120);
	    PageFactory.initElements(finder, loginPage);
		return loginPage;
	}
	
	//�û������
	@FindBy(id="username$text")
	private WebElement usernameInputBox;
	
	//���������
	@FindBy(id="pwd$text")
	private WebElement passwordInputBox;
	
	//��֤�������
	@FindBy(id="authCode$text")
	private WebElement captchaInputBox;
	
	//������ʾ
	@FindBy(id="errMsg")
	private WebElement errorMsg;
	
	//��֤��ͼƬ
//	@FindBy(how = How.ID,using ="vercode")
	@FindBy(id="img_code")
	private WebElement captchaDisplay;
	
	//��¼��ť
	@FindBy(linkText="��¼")
	private WebElement loginButton;
	
	//���ð�ť
	@FindBy(linkText="����")
	private WebElement resetButton;
	
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
	
	public void loginButton(){
		loginButton.click();
		resetButton.click();
	}

	
}