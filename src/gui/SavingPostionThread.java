package gui;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFrame;

public class SavingPostionThread extends Thread{
	private JFrame f;
	File file=new File("D:\\project\\j2se\\location.txt");
	
	public SavingPostionThread(JFrame f){
		this.f=f;
	}
	public void run(){
		while(true){
			int x=f.getX();
			int y=f.getY();
			
			try(FileOutputStream fos=new FileOutputStream(file);
					DataOutputStream dos=new DataOutputStream(fos)) {
				dos.writeInt(x);
				dos.writeInt(y);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
