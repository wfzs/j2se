package collection;

public class Hero implements Comparable<Hero>{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 	public String name;
 	public float hp;
 	public int damage;
	public Hero(){
		
	}
	public Hero(String str,float hp,int damage){
		name=str;
		this.hp=hp;
		this.damage=damage;
	}
	public String toString(){
		return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
	}
	@Override
	public int compareTo(Hero o) {
		// TODO Auto-generated method stub
		if(this.damage<o.damage)
			return 1;
		else
			return -1;
	}
	public void attack(Hero h){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.hp-=damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
		if(h.isDead())
			System.out.println(h.name+"死了");
	}
	public boolean isDead(){
		return 0>=hp?true:false;
	}
	public int compareHero(Hero h){
		return this.hp>h.hp?1:-1;
	}
	public float getHp() {
		return hp;
	}
	public void setHp(float hp) {
		this.hp = hp;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
}
