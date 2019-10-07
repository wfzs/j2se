package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap implements IHashMap{
	LinkedList<Entry>[] value=new LinkedList[2000];

	@Override
	public void put(String key, Object object) {
		// TODO Auto-generated method stub
		int hashcode=hashCode(key);
		LinkedList<Entry> list=value[hashcode];
		if(null==list){
			list=new LinkedList<Entry>();
			value[hashcode]=list;
		}
		
		boolean found=false;
		for (Entry entry : list) {
			if(key.equals(entry.key)){
				entry.value=object;
				found=true;
			}
		}
		if(!found){
			Entry entry=new Entry(key,object);
			list.add(entry);
		}
	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		int hashcode=hashCode(key);
		LinkedList<Entry> list=value[hashcode];
		if(null==list)
			return null;
		Object result=null;
		for (Entry entry : list) {
			if(key.equals(entry.key)){
				result=entry.value;
				break;
			}
		}
		return result;
	}
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
	public String toString() {
        LinkedList<Entry> result = new LinkedList<>();
        for (LinkedList<Entry> linkedList : value) {
            if (null == linkedList)
                continue;
            result.addAll(linkedList);
        }
        return result.toString();
    }
	public static void main(String[] args) {
//		MyHashMap map=new MyHashMap();
//		map.put("t", "坦克");
//		map.put("f", "飞机");
//		map.put("d", "大炮");
//		map.put("t", "坦克2");
//		System.out.println(map);
//		System.out.println(map.get("t"));
		
		cycle: 
	        for (int i = 1; i < 10; i++) {             
	            for (int j = 1; j < 10; j++) {                
	                if(j%2==0) 
	                {
	                    System.out.println(i+":"+j);
	                    break cycle; //如果是双数，结束外部循环
	                }
	            }            
	        }   
		
		
//		List<Hero> list=new ArrayList<Hero>();
//		System.out.println("初始化开始");
//		for(int i=0;i<100000;i++){
//			int num=(int)(Math.random()*10000);
//			Hero h=new Hero("hero-"+num);
//			list.add(h);
//		}
//		MyHashMap map=new MyHashMap();
//		for (Hero hero : list) {
//			List<Hero> l=(List<Hero>)map.get(hero.name);
//			if(null==l){
//				l=new ArrayList<Hero>();
//				map.put(hero.name, l);
//			}
//			l.add(hero);
//		}
//		System.out.println("初始化结束");
//		System.out.println("开始查找");
//		findByFor(list);
//		findByMap(map);
	}

	private static void findByMap(MyHashMap map) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		List<Hero> list=(List<Hero>)map.get("hero-5555");
		long end=System.currentTimeMillis();
		System.out.println("一共找到"+list.size()+"  共花费"+(end-start));
	}

	private static void findByFor(List<Hero> list) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		List<Hero> l=new ArrayList<Hero>();
		for (Hero hero : list) {
			if(hero.name.equals("hero-5555"))
				l.add(hero);
		}
		long end=System.currentTimeMillis();
		System.out.println("一共找到"+l.size()+"  共花费"+(end-start));
	}
}
