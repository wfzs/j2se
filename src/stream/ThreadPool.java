package stream;

import java.util.LinkedList;

public class ThreadPool {
	private int threadPoolSize;
	private LinkedList<Runnable> tasks=new LinkedList<Runnable>();
	
	public ThreadPool(){
		threadPoolSize=10;
		synchronized(tasks){
			for(int i=0;i<threadPoolSize;i++){
				new ThreadConusmer("�����������߳�"+i).start();
			}
		}
	}
	public void add(Runnable r){
		synchronized(tasks){
			tasks.add(r);
			tasks.notifyAll();
		}
	}
	class ThreadConusmer extends Thread{
		public ThreadConusmer(String name){
			super(name);
		}
		Runnable task;
		public void run(){
			System.out.println("�����߳�"+this.getName());
			synchronized(tasks){
				while(tasks.isEmpty()){
					try {
						tasks.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				task=tasks.removeLast();
				tasks.notifyAll();
			}
			task.run();
		}
	}
}
