package com.lakala.bmcp.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *@author:HaxtraZ
 *@date:2014��9��25�� 22:44:01
 *@descripion:ģ������¼�
 *    ͨ������jdk��Robot���keyPress��keyRelease����ʵ��
 **/

//ʵ��Runnable�ӿڣ��Զ��̷߳�ʽȥ��Enter
public class JavaSendKey implements Runnable
{
  
    	//�Զ��̷߳�ʽģ�ⰴenter
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