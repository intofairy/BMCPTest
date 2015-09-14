package com.lakala.bmcp.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *@author:HaxtraZ
 *@date:2014年9月25日 22:44:01
 *@descripion:模拟键盘事件
 *    通过调用jdk的Robot类的keyPress和keyRelease方法实现
 **/

//实现Runnable接口，以多线程方式去按Enter
public class JavaSendKey implements Runnable
{
  
    	//以多线程方式模拟按enter
    	public void run(){
    		try
    		{
    			Robot robot = new Robot();
    			Thread.sleep(1000);
    			robot.keyPress(KeyEvent.VK_ENTER);
    			robot.delay(5);
    			robot.keyRelease(KeyEvent.VK_ENTER);
    		}
    		catch(AWTException e){
    			e.printStackTrace();
    		}
    		catch(InterruptedException e){
    			e.printStackTrace();
    		}
    		
    		
    }
}