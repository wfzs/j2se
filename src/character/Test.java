package character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(5);
		list.add(5);
		list.add(7);
		list.add(7);
		int num=0;
		long start=System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(5))
				num++;
		}
		long end=System.currentTimeMillis();
		System.out.println(num+" "+(end-start));
		int num2=0;
		long start2=System.currentTimeMillis();
		for (Iterator it=list.iterator();it.hasNext();) {
			if(it.next().equals(5))
				num++;
		}
		long end2=System.currentTimeMillis();
		System.out.println(num2+" "+(end2-start2));
		int num3=0;
		long start3=System.currentTimeMillis();
		for(Integer i:list) {
			if(i.equals(5))
				num3++;
		}
		long end3=System.currentTimeMillis();
		System.out.println(num3+" "+(end3-start3));
	}	
}
