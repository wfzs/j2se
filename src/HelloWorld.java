import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// char c1 = 'c';
		// Character c = c1;
		// char c2 = c;
		// Scanner sc = new Scanner(System.in);
		// System.out.println("请输入地名");
		// String location = sc.nextLine();
		//
		// System.out.println("请输入公司类型");
		// String type = sc.nextLine();
		//
		// System.out.println("请输入公司名称");
		// String companyName = sc.nextLine();
		//
		// System.out.println("请输入老板名称");
		// String bossName = sc.nextLine();
		//
		// System.out.println("请输入金额");
		// double money = sc.nextInt();
		//
		// System.out.println("请输入产品");
		// String production = sc.nextLine();
		// sc.nextLine();
		//
		// System.out.println("请输入计量单位");
		// String unit = sc.nextLine();
		//
		// String sen =
		// "%s最大%s%s倒闭了王八蛋老板%s吃喝嫖赌，欠下了%d个亿，带着他的小姨子跑了!我们没有办法，拿着%s抵工资!原价都是一%s多、两%s多、三%s多的%s，现在全部只卖二十块，统统只要二十块!%s王八蛋，你不是人!我们辛辛苦苦给你干了大半年，你不发工资，你还我血汗钱，还我血汗钱!";
		//
		// System.out.printf(sen, location, type, companyName, bossName, money,
		// production, unit, unit, unit, production,
		// bossName);

		// System.out.println("使用空格无法达到对齐的效果");
		// System.out.println("abc def");
		// System.out.println("ab def");
		// System.out.println("a def");
		//
		// System.out.println("使用\\t制表符可以达到对齐的效果");
		// System.out.println("abc\tdef");
		// System.out.println("ab\tdef");
		// System.out.println("a\ndef");

		// Scanner sc=new Scanner(System.in);
		//
		// String s=sc.nextLine();
		// char[] cs=s.toCharArray();
		// for (char c : cs) {
		// if(Character.isDigit(c)||Character.isUpperCase(c)){
		// System.out.print(c);
		// }
		// }
		int start = 0, end = 'z' + 1,num=10000,sum=10000;//num为String+的次数,sum为StringBuffer的次数
        String s1=new String();
        String s2=new String();
        char[] ch=new char[10];
        double starttime = System.currentTimeMillis();
        for(int i=0;i<num;i++) {
            for (int j = 0; j < ch.length;) {
                while (true) {
                    char c = (char) (Math.random() * (end - start) + start);
                    if (Character.isLetter(c) || Character.isDigit(c)) {
                        ch[j++]=c;
                        break;
                    }
                }
            }
            String t=new String(ch);
            s1 += t;
        }
        double spenttime=(System.currentTimeMillis()-starttime)/1000;
        System.out.println("使用字符串连接+方式，连接10000次，耗时"+spenttime+"s");
        double starttime2=System.currentTimeMillis();
        StringBuffer str=new StringBuffer(s2);
        for(int i=0;i<sum;i++){
            for(int j=0;j<ch.length;) {
                while (true) {
                    char c = (char) (Math.random() * (end - start) + start);
                    if (Character.isLetter(c) || Character.isDigit(c)) {
                        ch[j++]=c;
                        break;
                    }
                }
            }
            String t=new String(ch);
            str.append(t);
        }
        double spenttime2=(System.currentTimeMillis()-starttime2)/1000;
        System.out.println("使用StringBuffer方式，连接10000次，耗时"+spenttime2+"s");
	}
}
class RandomString{
    public static String generateString(int n) {
        String str = new String();
         
        for(int i=0;i<n;) {
            char ch = (char)(Math.random()*((int)('z'-'0'))+(int)('0'));
            if(Character.isDigit(ch)||Character.isLetter(ch)) {
                i++;
                str+=ch;
            }
        }       
        return str;
    }
    public static void printStringArray(String[] str) {
        int i = 0;
        for(String s:str) {
            i++;
            System.out.printf("%s\t",s);
            if(i%20 == 0&&i!=0) System.out.println("");
        }
    }
    public static HashSet<String> findRepeatString(String[] str) {
        HashSet<String> find = new HashSet<String>();
         
        for(int i=0;i<str.length;i++) {
            for(int j = i+1;j<str.length;j++) {
                if(str[i].equals(str[j])) {
                    find.add(str[i]);
                }
            }
        }       
        return find;
    }
}