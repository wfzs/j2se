package multiplethread;

import java.util.List;

public class PasswordThread extends Thread{
	private boolean found=false;
	private String password;
	private List<String> passwords;
	
	public PasswordThread(String password,List<String> passwords){
		this.password=password;
		this.passwords=passwords;
	}
	public void run(){
		char[] guesspassword=new char[password.length()];
		genratePassword(guesspassword,password);
	}
	public void genratePassword(char[] guesspassword,String password){
		genratePassword(guesspassword,0,password);
	}
	public void genratePassword(char[] guesspassword,int index,String password){
		if(found)
			return;
		for(char c='0';c<='z';c++){
			if(!Character.isLetterOrDigit(c))
				continue;
			guesspassword[index]=c;
			if(guesspassword.length-1!=index)
				genratePassword(guesspassword,index+1,password);
			else{
				String s=new String(guesspassword);
				passwords.add(s);
				if(password.equals(s)){
					System.out.println("ÕÒµ½ÁË£¬ÃÜÂëÊÇ£º"+s);
					found=true;
					return;
				}
			}
		}
	}
}
