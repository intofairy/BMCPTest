package com.lakala.bmcp.page;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lakala.bmcp.util.ClearImageHelper;
import com.lakala.bmcp.util.OcrContent;
import com.lakala.bmcp.util.ScreenShot;

public class LoginPage  {
	
	//˽�л����캯��
	private static WebDriver driver = null;
	
	private LoginPage(){
	}
	//ʵ��
	private static LoginPage loginPage = new LoginPage(); 
	//���ظ�ͬһ��ʵ��
	public static LoginPage getInstance(WebDriver dr){
		driver = dr;
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
	@FindBy(id="vercode")
	private WebElement captchaDisplay;
	
	//�һ�����link
	@FindBy(linkText="�һ�����")
	private WebElement findPasswordBack;

	private final String USERNAME_DEPING = "deping";
	private final String PASSWORD_DEPING = "11111111abc";
    
	
	//��¼
	public void login() throws IOException{
		usernameInputBox.sendKeys(USERNAME_DEPING);
		passwordInputBox.sendKeys(PASSWORD_DEPING);
		String captchaTmpFile = ClearImageHelper.cleanImage(ScreenShot.createElementImage(captchaDisplay, driver),"D://SeleniumCaptcha/");
		
	}
	
	//���������֤��
	public void updateCaptcha(){
		captchaDisplay.click();
	}
	
	//�һ�������ת
	public void forgotPassword(){
		findPasswordBack.click();
	}
}
