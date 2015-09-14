package com.lakala.bmcp.page;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.FindBy;


import com.lakala.bmcp.util.ClearImageHelper;
import com.lakala.bmcp.util.OcrContent;
import com.lakala.bmcp.util.ScreenShot;

public class LoginPage  {
	
	//˽�л����캯��
	private LoginPage(){
	}
	//ʵ��
	private static LoginPage loginPage = new LoginPage(); 
	//���ظ�ͬһ��ʵ��
	public static LoginPage getInstance(){
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
    
	
	
	public void login(){
		usernameInputBox.sendKeys(USERNAME_DEPING);
		passwordInputBox.sendKeys(PASSWORD_DEPING);
		
	}
	
	//���������֤��
	public void updatecaptcha(){
		captchaDisplay.click();
	}
	
	//
	
}
