package multiplethread;

public class Hero {
	public String name;
	public float hp;
	public int damage;
	
	public synchronized void recover(){
		while(hp==1000){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.hp+=1;
		System.out.printf("t2 Ϊ%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n",name,name,hp);
		this.notify();	
	}
	public synchronized void hurt(){
		while(hp==1){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.hp-=1;
		System.out.printf("t1 Ϊ%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n",name,name,hp);
		this.notify();
	}
	public void attack(Hero h){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.hp-=damage;
		System.out.println("�����ڱ�����");
		
		if(h.isDead()){
			System.out.println(h.name+"����!");
		}
	}
	public boolean isDead(){
		return hp<=0?true:false;
	}
}
