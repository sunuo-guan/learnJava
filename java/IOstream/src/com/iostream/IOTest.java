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
	 * read到文件末尾为-1，否则为字符char
	 * 读入时文件一定要存在
	 * 
	 */
	public static void testFileReader(){
		
		FileReader fr=null;
		
		try {
			//1.实例化file类对象，指明要操作的文件
			File file = new File("hello1.txt"); //相较于当前项目
			
			//2.提供具体流
			fr = new FileReader(file);
			//3.数据读入
			//单个字符读入方法
//			int data;
//			while ((data = fr.read()) != -1) {
//				System.out.print((char) data);
//			} 
			
			//字符数组读入方法
			char cbuf[]=new char[5];
			int len;
			while((len=fr.read(cbuf))!=-1) {
				for(int i=0;i<len;i++) {
					System.out.print(cbuf[i]);
				}
				//错误写法：
//				for(int i=0;i<cbuf.length;i++) {
//					System.out.print(cbuf[i]);
//				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//4.流的关闭
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
		//1.提供file类的对象，指明要操作的文件
		File file=new File("hello1.txt");
		
		//2.提供fileWriter对象
		FileWriter fw=new FileWriter(file);    //默认是覆盖文件
//		FileWriter fw=new FileWriter(file, false);    //false也是覆盖文件
//		FileWriter fw=new FileWriter(file, true);    //true是在文件后追加写
		
		//3.写出
		fw.write("hello world!\r\n");    
		fw.write("hello word\r\n"); 
		
		//4.关闭流
		fw.close();
	}
	
	public static void copyStreamFile(){
		//2.2提供缓冲流
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		try {
			//1.造文件
			File file1 = new File("2020-1.jpg");
			File file2 = new File("2020-2.jpg");
			//2.1 提供stream对象
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//3.复制
			byte buffer[] = new byte[10];
			int len;
			while ((len = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//4.资源关闭，只关缓冲流即可 或先关外再关里
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
