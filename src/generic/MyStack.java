package generic;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import collection.Hero;

public class MyStack<T> {
	LinkedList<T> values=new LinkedList<T>();
	Lock lock=new ReentrantLock();
	Condition c=lock.newCondition();
	public void push(T t){
		try {
			lock.lock();
			while(values.size()>=200){
				try {
//					this.wait();
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			this.notifyAll();
			c.signalAll();
			values.addLast(t);
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}		
	}
	public synchronized T pull(){
		try {
			lock.lock();
			while(values.isEmpty()){
				try {
//					this.wait();
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			this.notifyAll();
			c.signalAll();
			return values.removeLast();
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
	public T pell(){
		return values.getLast();
	}
	public static void main(String[] args) {
		//在声明这个Stack的时候，使用泛型<Hero>就表示该Stack只能放Hero
        MyStack<Hero> heroStack = new MyStack<>();
        heroStack.push(new Hero());
        
	}
}
