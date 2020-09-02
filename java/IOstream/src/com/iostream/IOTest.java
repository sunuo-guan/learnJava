package com.iostream;

import java.io.*;

public class IOTest {
	public static void main(String[] args) {

			testFileReader();

		
		try {
			fileWriterTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		copyStreamFile();
	}
	
	/*
	 * read���ļ�ĩβΪ-1������Ϊ�ַ�char
	 * ����ʱ�ļ�һ��Ҫ����
	 * 
	 */
	public static void testFileReader(){
		
		FileReader fr=null;
		
		try {
			//1.ʵ����file�����ָ��Ҫ�������ļ�
			File file = new File("hello1.txt"); //����ڵ�ǰ��Ŀ
			
			//2.�ṩ������
			fr = new FileReader(file);
			//3.���ݶ���
			//�����ַ����뷽��
//			int data;
//			while ((data = fr.read()) != -1) {
//				System.out.print((char) data);
//			} 
			
			//�ַ�������뷽��
			char cbuf[]=new char[5];
			int len;
			while((len=fr.read(cbuf))!=-1) {
				for(int i=0;i<len;i++) {
					System.out.print(cbuf[i]);
				}
				//����д����
//				for(int i=0;i<cbuf.length;i++) {
//					System.out.print(cbuf[i]);
//				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//4.���Ĺر�
			if(fr!=null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
	}
	
	public static void fileWriterTest() throws IOException {
		//1.�ṩfile��Ķ���ָ��Ҫ�������ļ�
		File file=new File("hello1.txt");
		
		//2.�ṩfileWriter����
		FileWriter fw=new FileWriter(file);    //Ĭ���Ǹ����ļ�
//		FileWriter fw=new FileWriter(file, false);    //falseҲ�Ǹ����ļ�
//		FileWriter fw=new FileWriter(file, true);    //true�����ļ���׷��д
		
		//3.д��
		fw.write("hello world!\r\n");    
		fw.write("hello word\r\n"); 
		
		//4.�ر���
		fw.close();
	}
	
	public static void copyStreamFile(){
		//2.2�ṩ������
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		try {
			//1.���ļ�
			File file1 = new File("2020-1.jpg");
			File file2 = new File("2020-2.jpg");
			//2.1 �ṩstream����
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//3.����
			byte buffer[] = new byte[10];
			int len;
			while ((len = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//4.��Դ�رգ�ֻ�ػ��������� ���ȹ����ٹ���
			if(bos!=null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bis!=null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
