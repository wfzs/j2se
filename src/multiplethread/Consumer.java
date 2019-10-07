package multiplethread;

import generic.MyStack;

public class Consumer extends Thread{
	private MyStack<Character> list;
	public Consumer(MyStack<Character> stack,String name){
		super(name);
		this.list=stack;
	}
	public void run(){
		while(true){
			char c=list.pull();
			System.out.println(this.getName()+"µ¯³ö"+c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
