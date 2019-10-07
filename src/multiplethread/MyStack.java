package multiplethread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyStack implements Stack{
	List<Hero> list=(List<Hero>)Collections.synchronizedList(new LinkedList<Hero>());
	Lock lock=new ReentrantLock();
	@Override
	public void push(Hero h) {
		// TODO Auto-generated method stub
		try {
			lock.lock();
			list.add(h);
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
	}

	@Override
	public Hero pull() {
		// TODO Auto-generated method stub
		try {
			lock.lock();
			return list.remove(list.size()-1);
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
	}

	@Override
	public Hero peek() {
		// TODO Auto-generated method stub
		return list.get(list.size()-1);
	}

}
