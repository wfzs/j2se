package character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class TestString implements IStringBuffer{
//	int captivy=16;
//	int length=0;
//	char[] value;
	ArrayList value;
	public TestString(){
//		value=new char[captivy];
		value=new ArrayList();
	}
	public TestString(String str){
		this();
		if(null==str)
			return;
//		if(captivy<str.length())
//		{
//			captivy=str.length()*2;
//			value=new char[captivy];
//		}
//		if(captivy>=str.length())
//			System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
//		length=str.length();
		char[] c=str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			value.add(c[i]);
		}
	}
	@Override
	public void append(String str) {
		// TODO Auto-generated method stub
		insert(value.size(),str);
	}
	@Override
	public void append(char c) {
		// TODO Auto-generated method stub
		append(String.valueOf(c));
	}
	@Override
	public void insert(int pos, char c) {
		// TODO Auto-generated method stub
		insert(pos,String.valueOf(c));
	}
	@Override
	public void insert(int pos, String str) {
		// TODO Auto-generated method stub
		if(pos<0)
			return;
		if(pos>value.size())
			return;
		if(null==str)
			return;
//		while(length+str.length()>captivy){
//			captivy=(int)((length+str.length())*1.5f);
//			char[] newvalue=new char[captivy];
//			System.arraycopy(value, 0, newvalue, 0, length);
//			value=newvalue;
//		}
//		System.arraycopy(value, pos, value, pos+str.length(), length-pos);
//
//		System.arraycopy(str.toCharArray(), 0, value, pos, str.length());
//		
//		length=length+str.length();
		char[] c=str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			value.add(pos+i, c[i]);
		}
	}
	@Override
	public void delete(int start) {
		// TODO Auto-generated method stub
		delete(start,value.size());
	}
	@Override
	public void delete(int start, int end) {
		// TODO Auto-generated method stub
		if(start<0)
			return;
		if(start>value.size())
			return;
		if(start>=end)
			return;
		if(end<0)
			return;
		if(end>value.size())
			return;
//		System.arraycopy(value, end, value, start, length-end);
		
//		length-=end-start;
		for(int i=0;i<end-start;i++){
			value.remove(start);
		}		
	}
	@Override
	public void reverse() {
		// TODO Auto-generated method stub
//		for (int i = 0; i < length/2; i++) {
//			char temp=value[i];
//			value[i]=value[length-i-1];
//			value[length-i-1]=temp;
//		}
		for (int i = 0; i < value.size()/2; i++) {
			char c=(char)value.get(i);
			value.set(i, value.get(value.size()-i-1));
			value.set(value.size()-i-1,c);
		}
//		Collections.reverse(value);
	}
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return value.size();
	}
	public String toString(){
//		char[] re=new char[length];
//		System.arraycopy(value, 0, re, 0, length);
//		return new String(re);
		char[] re=new char[value.size()];
		for (int i = 0; i < re.length; i++) {
			re[i]=(char)value.get(i);
		}
		return new String(re);
	}
	public static void main(String[] args) {
//		String s=randomString(10);
//		TestString ts=new TestString(s);
//		StringBuffer sb=new StringBuffer(s);
//		String ss=new String(s);
//		long start=System.currentTimeMillis();
//		for(int i=0;i<1000*1000;i++){
//			ts.append(s);
//		}
//		long end=System.currentTimeMillis();
//		System.out.println("自己的花费"+(end-start)+"毫秒");
//		
//		long start2=System.currentTimeMillis();
//		for(int i=0;i<1000*1000;i++){
//			sb.append(s);
//		}
//		long end2=System.currentTimeMillis();
//		System.out.println("系统的花费"+(end2-start2)+"毫秒");
		
//		long start3=System.currentTimeMillis();
//		for(int i=0;i<1000*1000;i++){
//			ss+=s;
//		}
//		long end3=System.currentTimeMillis();
//		System.out.println("自己的花费"+(end3-start3)+"毫秒");
		
//		HashMap<String,Object> m=new HashMap<String,Object>();
//		m.put(null, "NULL");
//		m.put("123", 123);
//		System.out.println(m);
		
		TestString ts=new TestString("there light");
		ts.delete(3,6);
		System.out.println(ts.toString());
	}
	public static String randomString(int length){
		String s="";
		for(char c='0';c<='9';c++)
			s+=c;
		for(char c='a';c<='z';c++)
			s+=c;
		for(char c='A';c<='Z';c++)
			s+=c;
		String v="";
		for (int i = 0; i < length; i++) {
			int index=(int)(Math.random()*s.length());
			v+=s.charAt(index);
		}
		return v;
	}
}
