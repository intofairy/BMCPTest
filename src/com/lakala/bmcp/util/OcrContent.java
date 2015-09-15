package com.lakala.bmcp.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class OcrContent {
	
	//��ͼƬִ��OCR
	public static String runTesseract(String CaptchaPicFile,String outputTxtFile) throws Exception{
	Runtime rt = Runtime.getRuntime();
	rt.exec("cmd.exe /C \"C://Program Files (x86)/Tesseract-OCR/tesseract.exe\" "+ CaptchaPicFile+" "+ outputTxtFile + " digits");
    return outputTxtFile;
	}
	
	
	//��ȡOCR��ɺ���ı��ļ�
	public static String readOCRFile(String filePath) {
		
		
		BufferedReader bufr = null;
		String captcha = null;
		try
		{
			Thread.sleep(1000); //�ȴ�1s�ļ����ɵ��ļ�
			bufr = new BufferedReader(new FileReader(filePath));
			
			char[] buf = new char[1024];
			
			int lenth = 0;
			while((lenth = bufr.read(buf))!=-1)
			{
				return new String(buf,0,lenth);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			throw new RuntimeException("�xȡOCR�ļ�ʧ��");
			
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		finally{
			
			try
			{
				if(bufr!=null)
					bufr.close();
				
			}
			catch(IOException e)
			{
				throw new RuntimeException("�xȡOCR�ļ��YԴ�P�]ʧ��");
			}
			
		}
		return captcha;
		
	}
		
}

