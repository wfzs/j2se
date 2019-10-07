package multiplethread;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import generic.MyStack;

public class TestThread {
	public static void main(String[] args) {
		final Hero gareen = new Hero();
		gareen.name = "盖伦";
		gareen.hp = 616;
		gareen.damage = 50;

		Hero teemo = new Hero();
		teemo.name = "提莫";
		teemo.hp = 300;
		teemo.damage = 30;

		Hero bh = new Hero();
		bh.name = "赏金猎人";
		bh.hp = 500;
		bh.damage = 65;

		Hero lessin = new Hero();
		lessin.name = "盲僧";
		lessin.hp = 455;
		lessin.damage = 80;

		// while(!teemo.isDead()){
		// gareen.attack(teemo);
		// }
		//
		// while(!lessin.isDead()){
		// bh.attack(lessin);
		// }

		// 第一种方式：继承Thread类
		// KillThread k1=new KillThread(gareen,teemo);
		// k1.start();
		// KillThread k2=new KillThread(bh,lessin);
		// k2.start();

		// 第二种方式实现Runnable接口
		// Battle battle1=new Battle(gareen,teemo);
		// new Thread(battle1).start();
		// Battle battle2=new Battle(bh,lessin);
		// new Thread(battle2).start();

		// 第三种方式匿名类继承Thread
		// new Thread(){
		// public void run(){
		// while(!teemo.isDead()){
		// gareen.attack(teemo);
		// }
		// }
		// }.start();
		// new Thread(){
		// public void run(){
		// while(!lessin.isDead()){
		// bh.attack(lessin);
		// }
		// }
		// }.start();

		// 当一个进程里只有守护线程时，结束当前进程，线程可以sleep()，yield()临时暂停，腾出cpu，
		// 设置线程优先级，setDaemon(true)设置线程为守护线程,jion()加入主线程中，主线程会等待这个加进来的线程结束完毕才会往下运行

		// Thread.sleep(1000) 当前线程暂停1000秒，其他线程不受影响
		// Thread t1=new Thread(){
		// public void run(){
		// int second=0;
		// while(true){
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(second++);
		// }
		// }
		// };
		// t1.start();

		// join() 将线程加到主线程中，只有等他执行完了 才可以继续往下走
		// Thread t1=new Thread(){
		// public void run(){
		// while(!teemo.isDead()){
		// gareen.attack(teemo);
		// }
		// }
		// };
		// t1.start();
		//
		// try {
		// t1.join();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// Thread t2=new Thread(){
		// public void run(){
		// while(!lessin.isDead()){
		// bh.attack(lessin);
		// }
		// }
		// };
		// t2.start();

		// 线程优先级
		// Thread t1=new Thread(){
		// public void run(){
		// while(!teemo.isDead()){
		// gareen.attack(teemo);
		// }
		// }
		// };
		// t1.setPriority(Thread.MAX_PRIORITY);

		// 将线程变为守护线程，当一个进程里只剩下守护线程时，这个进程也就结束了
		// t1.setDaemon(true);

		// yield() 临时暂停，使其它线程可以有更多的机会占用cpu

		// 同步问题
		// int n=10000;
		// Thread[] add=new Thread[n];
		// Thread[] reduce=new Thread[n];
		// 加血
		// for(int i=0;i<n;i++){
		// Thread t=new Thread(){
		// public void run(){
		// gareen.recover();
		// try {
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// };
		// t.start();
		// add[i]=t;
		// }
		// 减血
		// for(int i=0;i<n;i++){
		// Thread t=new Thread(){
		// public void run(){
		// gareen.hurt();
		// try {
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// };
		// t.start();
		// reduce[i]=t;
		// }

		// for (Thread t : add) {
		// try {
		// t.join();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

		// for (Thread t : reduce) {
		// try {
		// t.join();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

		// System.out.printf("经过%d的加血线程和%d的见血线程后%n盖伦的血量是%.0f%n",n,n,gareen.hp);

		// 解决同步问题用关键字synchronized
		// final Object someObject=new Object();
		//
		// Thread t1=new Thread(){
		// public void run(){
		// try {
		// System.out.println(now()+"t1线程已经运行");
		// System.out.println(now()+this.getName()+"试图占用对象：someOBbject");
		// synchronized(someObject){
		// System.out.println(now()+this.getName()+"占有对象：someOBbject");
		// Thread.sleep(5000);
		// System.out.println(now()+this.getName()+"释放对象：someOBbject");
		// }
		// System.out.println(now()+"t1线程结束");
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// };
		// t1.setName("t1");
		// t1.start();
		//
		// Thread t2=new Thread(){
		// public void run(){
		// try {
		// System.out.println(now()+"t2线程已经运行");
		// System.out.println(now()+this.getName()+"试图占用对象：someOBbject");
		// synchronized(someObject){
		// System.out.println(now()+this.getName()+"占有对象：someOBbject");
		// Thread.sleep(5000);
		// System.out.println(now()+this.getName()+"释放对象：someOBbject");
		// }
		// System.out.println(now()+"t1线程结束");
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// };
		// t2.setName("t2");
		// t2.start();

		// 死锁
		// final Hero anni=new Hero();
		// anni.name="安妮";
		// final Hero ahri=new Hero();
		// ahri.name="九尾狐";
		//
		// Thread t1=new Thread(){
		// public void run(){
		// synchronized(ahri){
		// System.out.println("t1已经占有九尾狐");
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("t1 试图占有安妮");
		// System.out.println("等待中。。。。");
		// synchronized(anni){
		// System.out.println("do somenthing");
		// }
		// }
		// }
		// };
		// t1.start();
		//
		// Thread t2=new Thread(){
		// public void run(){
		// synchronized(anni){
		// System.out.println("t2已经占有安妮");
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("t2试图占有九尾狐");
		// System.out.println("等待中");
		// synchronized(ahri){
		// System.out.println("do something");
		// }
		// }
		// }
		// };
		// t2.start();

		// 交互
		// Thread t1=new Thread(){
		// public void run(){
		// while(true){
		// while(gareen.hp==1){
		//
		// }
		// gareen.hurt();
		// try {
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }
		// };
		// t1.start();

		// Thread t2 = new Thread() {
		// public void run() {
		// while (true) {
		// gareen.recover();
		// try {
		// Thread.sleep(10);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }
		// };
		// t2.start();

		// for(int i=0;i<5;i++){
		// new HurtThread(gareen).start();
		// }
		// for(int i=0;i<2;i++){
		// new RecoverThread(gareen).start();
		// }

		// 生产者消费者问题
		// MyStack<Character> stack=new MyStack<Character>();
		// new ProductThread(stack,"Product1").start();
		// new ProductThread(stack,"Product2").start();
		// new ProductThread(stack,"Product3").start();
		// new Consumer(stack,"Consumer1").start();
		// new Consumer(stack,"Consumer2").start();

		// 线程池
		// ThreadPool pool=new ThreadPool();
		//
		// for(int i=0;i<5;i++){
		// Runnable task=new Thread(){
		// public void run(){
		// System.out.println("我是任务");
		// }
		// };
		// pool.add(task);
		//
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

		// lock()
		// final Object someObject = new Object();
		// Lock lock=new ReentrantLock();
		// Condition c=lock.newCondition();
		//
		// Thread t1 = new Thread() {
		// public void run() {
		// boolean locked=false;
		// try {
		// log("线程启动");
		// log("试图占用对象：lock");
		//// locked=lock.tryLock(1, TimeUnit.SECONDS);
		// lock.lock();
		// log("占有对象：lock");
		// log("进行5秒业务操作");
		// Thread.sleep(5000);
		// log("临时释放对象lock，并等待");
		// c.await();
		// log("重新占有对象lock,并进行5秒的业务操作");
		//
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }finally{
		// if(locked){
		// log("释放对象：lock");
		// lock.unlock();
		// }
		// }
		// log("线程结束");
		// }
		// };
		// t1.setName("t1");
		// t1.start();
		//
		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// Thread t2 = new Thread() {
		// public void run() {
		// boolean locked=false;
		// try {
		// log("线程已经运行");
		// log("试图占用对象：lock");
		// lock.lock();
		// log("占有对象：lock");
		// log("进行5秒业务操作");
		// Thread.sleep(5000);
		// log("唤醒等待的线程");
		// c.signal();
		//// locked=lock.tryLock(1, TimeUnit.SECONDS);
		//// if(locked){
		//// log("占有对象：lock");
		//// log("进行5秒业务操作");
		//// Thread.sleep(5000);
		//// }
		//// else{
		//// log("经过1秒的努力，还没占有对象，放弃占有");
		//// }
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }finally{
		//// if(locked){
		//// log("释放对象：lock");
		//// lock.unlock();
		//// }
		// log("释放对象：lock");
		// lock.unlock();
		// }
		// log("线程结束");
		// }
		// };
		// t2.setName("t2");
		// t2.start();

		// 练习lock
		Lock lock_anni=new ReentrantLock();
		Lock lock_ahri=new ReentrantLock();
		final Hero anni = new Hero();
		anni.name = "安妮";
		final Hero ahri = new Hero();
		ahri.name = "九尾狐";

		Thread t1 = new Thread() {
			public void run() {
				boolean anlock=false;
				boolean ahlock=false;
				try {
					ahlock=lock_ahri.tryLock(10, TimeUnit.SECONDS);
					if(ahlock){
						System.out.println("t1已经占有九尾狐");
						Thread.sleep(1000);
						System.out.println("t1 试图占有安妮");
						try {
							anlock=lock_anni.tryLock(10,TimeUnit.SECONDS);
							if(anlock){
								System.out.println("成功占有安妮，你好啊");
							}
							else{
								System.out.println("老是被安妮逃掉，放弃了");
							}
						} finally {
							// TODO: handle finally clause
							if(anlock){
								lock_anni.unlock();
								System.out.println("t1 释放了安妮");
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					if(ahlock){
						lock_ahri.unlock();
						System.out.println("t1 释放了九尾狐");
					}
				}
//				synchronized (ahri) {
//					System.out.println("t1已经占有九尾狐");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("t1 试图占有安妮");
//					System.out.println("等待中。。。。");
//					synchronized (anni) {
//						System.out.println("do somenthing");
//					}
//				}
			}
		};
		t1.start();
			
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Thread t2 = new Thread() {
			public void run() {
				boolean anlock=false;
				boolean ahlock=false;
				try {
					anlock=lock_anni.tryLock(10,TimeUnit.SECONDS);
					if(anlock){
						System.out.println("t2已经占有安妮");
						Thread.sleep(1000);
						System.out.println("t2试图占有九尾狐");
						try {
							ahlock=lock_ahri.tryLock(10, TimeUnit.SECONDS);
							if(ahlock){
								System.out.println("成功占有九尾狐，你好啊");
							}
							else{
								System.out.println("老是被九尾狐逃掉，放弃了");
							}
						} finally {
							// TODO: handle finally clause
							if(ahlock){
								lock_ahri.unlock();
								System.out.println("t2 释放了九尾狐");
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					if(anlock){
						lock_anni.unlock();
						System.out.println("t2 释放了安妮");
					}
				}
//				synchronized (anni) {
//					System.out.println("t2已经占有安妮");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("t2试图占有九尾狐");
//					System.out.println("等待中");
//					synchronized (ahri) {
//						System.out.println("do something");
//					}
//				}
			}
		};
		t2.start();
	}

	static class HurtThread extends Thread {
		private Hero h;

		public HurtThread(Hero h) {
			this.h = h;
		}

		public void run() {
			while (true) {
				while (h.hp == 1) {

				}
				h.hurt();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	static class RecoverThread extends Thread {
		private Hero h;

		public RecoverThread(Hero h) {
			this.h = h;
		}

		public void run() {
			while (true) {
				h.recover();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void log(String msg) {
		System.out.printf("%s %s %s %n", now(), Thread.currentThread().getName(), msg);
	}

	public static String now() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
}
