package generic;

import java.util.ArrayList;
import java.util.List;

import collection.Hero;

public class NodeG<T extends Comparable<T>> {
	public NodeG<T> leftNode;
	public NodeG<T> rightNode;
	public T value;
	public void add(T v){
		if(null==value)
			value=v;
		else{	
			if(v.compareTo(value)<0)
			{
				if(leftNode==null)
					leftNode=new NodeG<T>();
				leftNode.add(v);
			}
			else{
				if(rightNode==null)
					rightNode=new NodeG<T>();
				rightNode.add(v);
			}
//			if((Integer)v-((Integer)value)<=0){
//				if(leftNode==null)
//					leftNode=new NodeG<T>();
//				leftNode.add(v);
//			}
//			else{
//				if(rightNode==null)
//					rightNode=new NodeG<T>();
//				rightNode.add(v);
//			}
		}
	}
	public List<T> values(){
		List<T> values=new ArrayList<T>();
		
		if(null!=leftNode)
			values.addAll(leftNode.values());
		values.add(value);
		if(null!=rightNode)
			values.addAll(rightNode.values());
		
		return values;
	}
	public static void main(String[] args) {
		int[] rands=new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
		NodeG<Integer> roots=new NodeG<>();
		for (int i : rands) {
			roots.add(i);
		}
		System.out.println(roots.values());
		NodeG<Hero> heroes=new NodeG<>();
		for (int i = 0; i < 10; i++)
            heroes.add(new Hero("гЂал" + (i + 1),0, (int) (Math.random() * 901) + 100));
        System.out.println(heroes.values());
	}
}
