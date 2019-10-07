package multiplethread;

import java.util.List;

public class LogThread extends Thread{
	private boolean found=false;
	private List<String> passwords;
	
	public LogThread(List<String> passwords){
		this.passwords=passwords;
		this.setDaemon(true);
	}
	
	public void run(){
		while(true){
			while(passwords.isEmpty()){
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			String s=passwords.remove(0);
			System.out.println("穷取法本次生成的密码是:"+s);
		}
	}
}
