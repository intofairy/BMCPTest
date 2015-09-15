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

//截图类
public class ScreenShot {

	//默认保存地址
	private static final String DEFAULTSAVEDPATH = "D://SeleniumCaptcha/";
	//int abc = Calendar.get(Calendar.SECOND);
	//static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd-HHmmssSSS");
	//判断目录是否存在
	private static void createDirectory(String savedPath){
	    if (!(new File(savedPath).isDirectory()))   // 判断是否存在该目录
	        new File(savedPath).mkdir();  // 如果不存在则新建一个目录
    }
	
	//取得当前页面的截图 
	private static byte[] takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		return takesScreenshot.getScreenshotAs(OutputType.BYTES);
	}
	
	/**
	 * 
	 * @param webElement webelement=findlement(by.xxx)返回的元素
	 * @param driver webdriver
	 * @return 
	 * @throws IOException
	 */
	//页面上指定元素的截图
	public static File createElementImage(WebElement webElement,WebDriver driver) {
		createDirectory(DEFAULTSAVEDPATH);
		
		File loginCaptcha = new File(DEFAULTSAVEDPATH+"WebElement-"+new SimpleDateFormat("YYYYMMdd-HHmmssSSS").format(new Date()).toString() +".png");
		// 获得webElement的位置和大小。
		Point location = webElement.getLocation();
		Dimension size = webElement.getSize();
		// 创建全屏截图。
		try
		{
			BufferedImage originalImage =ImageIO.read(new ByteArrayInputStream(takeScreenshot(driver)));
		  // 截取webElement所在位置的子图。
			BufferedImage croppedImage = originalImage.getSubimage(location.getX(),				
											    				   location.getY(),
											    				   size.getWidth(),
											    				   size.getHeight());
			ImageIO.write(croppedImage, "png",loginCaptcha);
			
		}
		catch(IOException e)
		{
			System.out.print("截图失败");
			e.printStackTrace();
		}
		return loginCaptcha;
	}
//	/**
//	 * 截屏
//	 * 
//	 * @author longhaibin,zhangna
//	 * @param driver
//	 *            当前浏览器
//	 * @return 返回截图文件所在路径
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

