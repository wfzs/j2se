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
		gareen.name = "����";
		gareen.hp = 616;
		gareen.damage = 50;

		Hero teemo = new Hero();
		teemo.name = "��Ī";
		teemo.hp = 300;
		teemo.damage = 30;

		Hero bh = new Hero();
		bh.name = "�ͽ�����";
		bh.hp = 500;
		bh.damage = 65;

		Hero lessin = new Hero();
		lessin.name = "äɮ";
		lessin.hp = 455;
		lessin.damage = 80;

		// while(!teemo.isDead()){
		// gareen.attack(teemo);
		// }
		//
		// while(!lessin.isDead()){
		// bh.attack(lessin);
		// }

		// ��һ�ַ�ʽ���̳�Thread��
		// KillThread k1=new KillThread(gareen,teemo);
		// k1.start();
		// KillThread k2=new KillThread(bh,lessin);
		// k2.start();

		// �ڶ��ַ�ʽʵ��Runnable�ӿ�
		// Battle battle1=new Battle(gareen,teemo);
		// new Thread(battle1).start();
		// Battle battle2=new Battle(bh,lessin);
		// new Thread(battle2).start();

		// �����ַ�ʽ������̳�Thread
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

		// ��һ��������ֻ���ػ��߳�ʱ��������ǰ���̣��߳̿���sleep()��yield()��ʱ��ͣ���ڳ�cpu��
		// �����߳����ȼ���setDaemon(true)�����߳�Ϊ�ػ��߳�,jion()�������߳��У����̻߳�ȴ�����ӽ������߳̽�����ϲŻ���������

		// Thread.sleep(1000) ��ǰ�߳���ͣ1000�룬�����̲߳���Ӱ��
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

		// join() ���̼߳ӵ����߳��У�ֻ�е���ִ������ �ſ��Լ���������
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

		// �߳����ȼ�
		// Thread t1=new Thread(){
		// public void run(){
		// while(!teemo.isDead()){
		// gareen.attack(teemo);
		// }
		// }
		// };
		// t1.setPriority(Thread.MAX_PRIORITY);

		// ���̱߳�Ϊ�ػ��̣߳���һ��������ֻʣ���ػ��߳�ʱ���������Ҳ�ͽ�����
		// t1.setDaemon(true);

		// yield() ��ʱ��ͣ��ʹ�����߳̿����и���Ļ���ռ��cpu

		// ͬ������
		// int n=10000;
		// Thread[] add=new Thread[n];
		// Thread[] reduce=new Thread[n];
		// ��Ѫ
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
		// ��Ѫ
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

		// System.out.printf("����%d�ļ�Ѫ�̺߳�%d�ļ�Ѫ�̺߳�%n���׵�Ѫ����%.0f%n",n,n,gareen.hp);

		// ���ͬ�������ùؼ���synchronized
		// final Object someObject=new Object();
		//
		// Thread t1=new Thread(){
		// public void run(){
		// try {
		// System.out.println(now()+"t1�߳��Ѿ�����");
		// System.out.println(now()+this.getName()+"��ͼռ�ö���someOBbject");
		// synchronized(someObject){
		// System.out.println(now()+this.getName()+"ռ�ж���someOBbject");
		// Thread.sleep(5000);
		// System.out.println(now()+this.getName()+"�ͷŶ���someOBbject");
		// }
		// System.out.println(now()+"t1�߳̽���");
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
		// System.out.println(now()+"t2�߳��Ѿ�����");
		// System.out.println(now()+this.getName()+"��ͼռ�ö���someOBbject");
		// synchronized(someObject){
		// System.out.println(now()+this.getName()+"ռ�ж���someOBbject");
		// Thread.sleep(5000);
		// System.out.println(now()+this.getName()+"�ͷŶ���someOBbject");
		// }
		// System.out.println(now()+"t1�߳̽���");
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// };
		// t2.setName("t2");
		// t2.start();

		// ����
		// final Hero anni=new Hero();
		// anni.name="����";
		// final Hero ahri=new Hero();
		// ahri.name="��β��";
		//
		// Thread t1=new Thread(){
		// public void run(){
		// synchronized(ahri){
		// System.out.println("t1�Ѿ�ռ�о�β��");
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("t1 ��ͼռ�а���");
		// System.out.println("�ȴ��С�������");
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
		// System.out.println("t2�Ѿ�ռ�а���");
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("t2��ͼռ�о�β��");
		// System.out.println("�ȴ���");
		// synchronized(ahri){
		// System.out.println("do something");
		// }
		// }
		// }
		// };
		// t2.start();

		// ����
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

		// ����������������
		// MyStack<Character> stack=new MyStack<Character>();
		// new ProductThread(stack,"Product1").start();
		// new ProductThread(stack,"Product2").start();
		// new ProductThread(stack,"Product3").start();
		// new Consumer(stack,"Consumer1").start();
		// new Consumer(stack,"Consumer2").start();

		// �̳߳�
		// ThreadPool pool=new ThreadPool();
		//
		// for(int i=0;i<5;i++){
		// Runnable task=new Thread(){
		// public void run(){
		// System.out.println("��������");
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
		// log("�߳�����");
		// log("��ͼռ�ö���lock");
		//// locked=lock.tryLock(1, TimeUnit.SECONDS);
		// lock.lock();
		// log("ռ�ж���lock");
		// log("����5��ҵ�����");
		// Thread.sleep(5000);
		// log("��ʱ�ͷŶ���lock�����ȴ�");
		// c.await();
		// log("����ռ�ж���lock,������5���ҵ�����");
		//
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }finally{
		// if(locked){
		// log("�ͷŶ���lock");
		// lock.unlock();
		// }
		// }
		// log("�߳̽���");
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
		// log("�߳��Ѿ�����");
		// log("��ͼռ�ö���lock");
		// lock.lock();
		// log("ռ�ж���lock");
		// log("����5��ҵ�����");
		// Thread.sleep(5000);
		// log("���ѵȴ����߳�");
		// c.signal();
		//// locked=lock.tryLock(1, TimeUnit.SECONDS);
		//// if(locked){
		//// log("ռ�ж���lock");
		//// log("����5��ҵ�����");
		//// Thread.sleep(5000);
		//// }
		//// else{
		//// log("����1���Ŭ������ûռ�ж��󣬷���ռ��");
		//// }
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }finally{
		//// if(locked){
		//// log("�ͷŶ���lock");
		//// lock.unlock();
		//// }
		// log("�ͷŶ���lock");
		// lock.unlock();
		// }
		// log("�߳̽���");
		// }
		// };
		// t2.setName("t2");
		// t2.start();

		// ��ϰlock
		Lock lock_anni=new ReentrantLock();
		Lock lock_ahri=new ReentrantLock();
		final Hero anni = new Hero();
		anni.name = "����";
		final Hero ahri = new Hero();
		ahri.name = "��β��";

		Thread t1 = new Thread() {
			public void run() {
				boolean anlock=false;
				boolean ahlock=false;
				try {
					ahlock=lock_ahri.tryLock(10, TimeUnit.SECONDS);
					if(ahlock){
						System.out.println("t1�Ѿ�ռ�о�β��");
						Thread.sleep(1000);
						System.out.println("t1 ��ͼռ�а���");
						try {
							anlock=lock_anni.tryLock(10,TimeUnit.SECONDS);
							if(anlock){
								System.out.println("�ɹ�ռ�а��ݣ���ð�");
							}
							else{
								System.out.println("���Ǳ������ӵ���������");
							}
						} finally {
							// TODO: handle finally clause
							if(anlock){
								lock_anni.unlock();
								System.out.println("t1 �ͷ��˰���");
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					if(ahlock){
						lock_ahri.unlock();
						System.out.println("t1 �ͷ��˾�β��");
					}
				}
//				synchronized (ahri) {
//					System.out.println("t1�Ѿ�ռ�о�β��");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("t1 ��ͼռ�а���");
//					System.out.println("�ȴ��С�������");
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
						System.out.println("t2�Ѿ�ռ�а���");
						Thread.sleep(1000);
						System.out.println("t2��ͼռ�о�β��");
						try {
							ahlock=lock_ahri.tryLock(10, TimeUnit.SECONDS);
							if(ahlock){
								System.out.println("�ɹ�ռ�о�β������ð�");
							}
							else{
								System.out.println("���Ǳ���β���ӵ���������");
							}
						} finally {
							// TODO: handle finally clause
							if(ahlock){
								lock_ahri.unlock();
								System.out.println("t2 �ͷ��˾�β��");
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					if(anlock){
						lock_anni.unlock();
						System.out.println("t2 �ͷ��˰���");
					}
				}
//				synchronized (anni) {
//					System.out.println("t2�Ѿ�ռ�а���");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("t2��ͼռ�о�β��");
//					System.out.println("�ȴ���");
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
