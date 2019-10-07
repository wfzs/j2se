package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static int hashCode(String str){
		if(null==str)
			return -1;
		if(str.length()==0)
			return 0;
		int hash=0;
		char[] c=str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			hash+=c[i];
		}
		hash*=23;
		hash=hash<0?0-hash:hash;
		hash=hash%2000;
		return hash;
	}
	public static void main(String[] args) {
//		for(int i=0;i<100;i++){
//			int length=(int)(Math.random()*8+2);
//			String s=randomString(length);
//			int hash=hashCode(s);
//			System.out.println(s+"   hashcode值："+hash);
//		}
		
		
//		Random r=new Random();
//		List<Hero> list=new ArrayList<Hero>();
//		for(int i=0;i<10;i++){
//			list.add(new Hero("hero "+i,r.nextInt(100),r.nextInt(100)));
//		}
//		System.out.println("初始化集合");
//		System.out.println(list);
//		Comparator<Hero> c=new Comparator<Hero>(){
//			public int compare(Hero h1,Hero h2){
//				if(h1.damage>h2.damage)
//					return 1;
//				else
//					return -1;
//			}
//		};
//		Collections.sort(list,c);
		
//		Collections.sort(list);
//		System.out.println("按照血量排序后的集合");
//		System.out.println(list);
		
//		Comparator<Integer> c=new Comparator<Integer>(){
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				if(o2>o1)
//					return 1;
//				return -1;
//			}
//			
//		};
		
//		Comparator<Integer> c=(o1, o2) ->o2>o1?1:-1;		
//		Set set=new TreeSet<>(c);
//		for (int i = 0; i < 10; i++) {
//	        set.add((int)(Math.random()*100));
//	    }
//	    System.out.println(set);
		
		Random r=new Random();
		List<Hero> list=new ArrayList<Hero>();
		for(int i=0;i<10;i++){
			list.add(new Hero("hero "+i,r.nextInt(100),r.nextInt(100)));
		}
		System.out.println("初始化集合");
		System.out.println(list);
//		Comparator<Hero> c=(h1,h2)->Test.compare(h1, h2);
//		Collections.sort(list,c);
////		Collections.sort(list,Test::compare);
//		System.out.println("按照血量排序后的集合");
//		System.out.println(list);
		
//		System.out.println("按照damage排序后的集合");
//		System.out.println(list);
		
		Comparator<Hero> c2=(h1,h2)->h1.compareHero(h2);
		Collections.sort(list,c2);
//		Collections.sort(list,Hero::compareHero);
		System.out.println(list);
	}
	public static int compare(Hero h1,Hero h2){
		if(h1.hp>h2.hp)
			return 1;
		else
			return -1;
	}
	public static String randomString(int length){
		String s="";
		for(char c='0';c<='9';c++)
			s+=c;
		for(char c='a';c<='z';c++)
			s+=c;
		for(char c='A';c<='Z';c++)
			s+=c;
		char[] cc=new char[length];
		for (int i = 0; i < length; i++) {
			int index=(int)(Math.random()*s.length());
			cc[i]=s.charAt(index);
		}
		return new String(cc);
	}
}
