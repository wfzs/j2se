package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FindFile {
	public static void copyFile(String srcFile,String destFile){
		File f1=new File(srcFile);
		File f2=new File(destFile);
		byte buffer[]=new byte[1024];
		try(FileInputStream fis=new FileInputStream(f1);
				FileOutputStream fos=new FileOutputStream(f2)){
			while(true){
				int num=fis.read(buffer);
				if(num==-1)
					break;
				fos.write(buffer, 0, num);
				fos.flush();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void copyDirectory(String srcFloder,String destFloder){
		File srcF=new File(srcFloder);
		File destF=new File(destFloder);
		if(!srcF.exists())
			return;
		if(!srcF.isDirectory())
			return;
		if(destF.isFile())
			return;
		if(!destF.exists())
			destF.mkdirs();
		
		File[] file=srcF.listFiles();
		for (File srcFile : file) {
			if(srcFile.isFile()){
				File newDestFile=new File(destF,srcFile.getName());
				copyFile(srcFile.getAbsolutePath(),newDestFile.getAbsolutePath());
			}
			if(srcFile.isDirectory()){
				File newDestFile=new File(destF,srcFile.getName());
				copyDirectory(srcFile.getAbsolutePath(),newDestFile.getAbsolutePath());
			}
		}
	}
	static ThreadPool pool=new ThreadPool();
	public static void search(File folder,String search){
		if(folder.isFile()){
			if(folder.getName().endsWith(".java")){
				Runnable r=new FildFileThread(folder,search);
				pool.add(r);
//				String filecontent=fildFile(folder);
//				if(filecontent.contains(search)){
//					System.out.printf("找到子目标字符串%s,在文件%s%n中",search,folder);
//				}
			}
		}
		if(folder.isDirectory()){
			File[] f=folder.listFiles();
			for (File file : f) {
				search(file,search);
			}
		}
	}
	private static String fildFile(File folder) {
		// TODO Auto-generated method stub
		try (FileReader fr=new FileReader(folder)){
			char[] all=new char[(int)folder.length()];
			fr.read(all);
			return new String(all);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		String s1="F:/盗墓笔记";
		String s2="F:/盗墓笔记2";
		copyFile(s1,s2);
		System.out.println("success");
	}
}
