package generic;

import java.util.ArrayList;
import java.util.List;

import collection.ADHero;
import collection.APHero;
import collection.Hero;

public class TestGeneric {
	public static void iterate(ArrayList<? extends Hero> heros){
		for (Hero hero : heros) {
			System.out.println(hero.getName());
		}
	}
	public static void main(String[] args) {
//		List<Number> list=new ArrayList<>();
//		list.add(2);
//		list.add("sads");
		
		//ֻȡ���ܲ���
//		ArrayList<APHero> apHero=new ArrayList<APHero>();
//		apHero.add(new APHero());
//		ArrayList<? extends Hero> heroList=apHero;
//		heroList.get(0);
		
		//ֻ�ܲ��벻��ȡ
//		ArrayList<? super Hero> heros=new ArrayList<>();
//		heros.add(new APHero());
//		heros.add(new ADHero());
//		heros.add(new Hero());
		
//		ArrayList<? super Hero> list=new ArrayList<>();
//		list.add(new Hero("���",120,0));
//		list.add(new ADHero("��ʥ",100,0));
//		list.add(new APHero("��Ī",100,0));
//		ArrayList<? extends Hero> heros=(ArrayList<? extends Hero>) list;
//		iterate(heros);
//		
//		ArrayList<Hero> hero=new ArrayList<>();
//		ArrayList<ADHero> adhero=new ArrayList<>();
//		ArrayList<APHero> aphero=new ArrayList<>();
//		
//		iterate(hero);
//		iterate(adhero);
//		iterate(aphero);
		
		ArrayList<Hero> hero=new ArrayList<Hero>();
		ArrayList<ADHero> adhero=new ArrayList<ADHero>();
//		adhero=hero;
		
	
	}
}
