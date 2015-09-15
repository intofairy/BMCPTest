package com.lakala.bmcp.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;

//��ͼ��
public class ScreenShot {

	//Ĭ�ϱ����ַ
	private static final String DEFAULTSAVEDPATH = "D://SeleniumCaptcha/";
	//int abc = Calendar.get(Calendar.SECOND);
	//static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd-HHmmssSSS");
	//�ж�Ŀ¼�Ƿ����
	private static void createDirectory(String savedPath){
	    if (!(new File(savedPath).isDirectory()))   // �ж��Ƿ���ڸ�Ŀ¼
	        new File(savedPath).mkdir();  // ������������½�һ��Ŀ¼
    }
	
	//ȡ�õ�ǰҳ��Ľ�ͼ 
	private static byte[] takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		return takesScreenshot.getScreenshotAs(OutputType.BYTES);
	}
	
	/**
	 * 
	 * @param webElement webelement=findlement(by.xxx)���ص�Ԫ��
	 * @param driver webdriver
	 * @return 
	 * @throws IOException
	 */
	//ҳ����ָ��Ԫ�صĽ�ͼ
	public static File createElementImage(WebElement webElement,WebDriver driver) {
		createDirectory(DEFAULTSAVEDPATH);
		
		File loginCaptcha = new File(DEFAULTSAVEDPATH+"WebElement-"+new SimpleDateFormat("YYYYMMdd-HHmmssSSS").format(new Date()).toString() +".png");
		// ���webElement��λ�úʹ�С��
		Point location = webElement.getLocation();
		Dimension size = webElement.getSize();
		// ����ȫ����ͼ��
		try
		{
			BufferedImage originalImage =ImageIO.read(new ByteArrayInputStream(takeScreenshot(driver)));
		  // ��ȡwebElement����λ�õ���ͼ��
			BufferedImage croppedImage = originalImage.getSubimage(location.getX(),				
											    				   location.getY(),
											    				   size.getWidth(),
											    				   size.getHeight());
			ImageIO.write(croppedImage, "png",loginCaptcha);
			
		}
		catch(IOException e)
		{
			System.out.print("��ͼʧ��");
			e.printStackTrace();
		}
		return loginCaptcha;
	}
//	/**
//	 * ����
//	 * 
//	 * @author longhaibin,zhangna
//	 * @param driver
//	 *            ��ǰ�����
//	 * @return ���ؽ�ͼ�ļ�����·��
//	 */
//	public static String screenCapture(WebDriver driver) {
//		String imagePath = "";
//		try {
//			if (driver != null) {
//				imagePath = "target" + File.separator + "snapshot" + File.separator + Dates.getTime() + ".png";
//				FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(imagePath));
//			}
//		} catch (Exception e) {
//			
//		}
//		return imagePath;
//	}
	
    
    
	
}

