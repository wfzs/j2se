package stream;

import java.io.File;
import java.io.FileReader;

public class FildFileThread extends Thread{
	public File f;
	public String s;
	public FildFileThread(File f,String s){
		this.f=f;
		this.s=s;
	}
	public void run(){
		String findContent=search(f);
		if(findContent.contains(s)){
			System.out.printf("�ҵ���Ŀ���ַ���%s,���ļ�%s%n��",s,f);
		}
	}
	private String search(File f) {
		// TODO Auto-generated method stub
		try(FileReader fr=new FileReader(f)) {
			char[] all=new char[(int)f.length()];
			fr.read(all);
			return new String(all);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
