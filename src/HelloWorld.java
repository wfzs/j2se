import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// char c1 = 'c';
		// Character c = c1;
		// char c2 = c;
		// Scanner sc = new Scanner(System.in);
		// System.out.println("���������");
		// String location = sc.nextLine();
		//
		// System.out.println("�����빫˾����");
		// String type = sc.nextLine();
		//
		// System.out.println("�����빫˾����");
		// String companyName = sc.nextLine();
		//
		// System.out.println("�������ϰ�����");
		// String bossName = sc.nextLine();
		//
		// System.out.println("��������");
		// double money = sc.nextInt();
		//
		// System.out.println("�������Ʒ");
		// String production = sc.nextLine();
		// sc.nextLine();
		//
		// System.out.println("�����������λ");
		// String unit = sc.nextLine();
		//
		// String sen =
		// "%s���%s%s���������˵��ϰ�%s�Ժ��ζģ�Ƿ����%d���ڣ���������С��������!����û�а취������%s�ֹ���!ԭ�۶���һ%s�ࡢ��%s�ࡢ��%s���%s������ȫ��ֻ����ʮ�飬ͳͳֻҪ��ʮ��!%s���˵����㲻����!����������������˴���꣬�㲻�����ʣ��㻹��Ѫ��Ǯ������Ѫ��Ǯ!";
		//
		// System.out.printf(sen, location, type, companyName, bossName, money,
		// production, unit, unit, unit, production,
		// bossName);

		// System.out.println("ʹ�ÿո��޷��ﵽ�����Ч��");
		// System.out.println("abc def");
		// System.out.println("ab def");
		// System.out.println("a def");
		//
		// System.out.println("ʹ��\\t�Ʊ�����Դﵽ�����Ч��");
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
		int start = 0, end = 'z' + 1,num=10000,sum=10000;//numΪString+�Ĵ���,sumΪStringBuffer�Ĵ���
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
        System.out.println("ʹ���ַ�������+��ʽ������10000�Σ���ʱ"+spenttime+"s");
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
        System.out.println("ʹ��StringBuffer��ʽ������10000�Σ���ʱ"+spenttime2+"s");
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