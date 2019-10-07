package multiplethread;

import generic.MyStack;

public class ProductThread extends Thread{
	private MyStack<Character> list;
	public ProductThread(MyStack<Character> stack,String name){
		super(name);
		this.list=stack;
	}
	public void run(){
		while(true){
			char c=randomChar();
			System.out.println(this.getName()+"—π»Î"+c);
			list.push(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public char randomChar(){
		return (char)(Math.random()*('Z'+1-'A')+'A');
	}
}
