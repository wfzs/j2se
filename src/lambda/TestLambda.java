package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import collection.Hero;

public class TestLambda {
	public static void main(String[] args) {
		Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ��ϣ�");
        System.out.println(heros);
//        filter(heros);
//        HeroChecker c=new HeroChecker(){
//
//			@Override
//			public boolean test(Hero h) {
//				// TODO Auto-generated method stub
//				return h.hp>100 && h.damage<50;
//			}
//        	
//        };        
//        System.out.println("ʹ�����������");
//        filter(heros,c);
//        System.out.println("ʹ��Lambda����");
//        HeroChecker c2=(Hero h)-> h.hp>100 && h.damage<50;
//        filter(heros,h->h.hp>100 && h.damage<50);
//        TestLambda tl=new TestLambda();
//        System.out.println("ʹ��Lambda���þ�̬��������");
//        filter(heros,h->tl.testHero(h));
//        System.out.println("ֱ�ӵ��þ�̬��������");
//        filter(heros,tl::testHero);
		
        //�ۺ�
//		heros.stream().filter(TestLambda::testHero).forEach(h->System.out.println(h.name));
//        Hero[] hs=heros.toArray(new Hero[heros.size()]);
//        Arrays.stream(hs).forEach(h->System.out.println(h.getName()));
//        System.out.println("��������hp>100����damage<50������"); 
//        heros.stream().filter(h->h.hp>100&&h.damage<50).forEach(h->System.out.print(h));
//        
//        System.out.println("ȥ���ظ���������ȥ����׼��equals");
//        heros.stream().distinct().forEach(h->System.out.print(h));  
//        
//        System.out.println("����Ѫ������");
//        heros.stream().sorted((h1,h2)->h1.hp>=h2.hp?1:-1).forEach(h->System.out.print(h));
//        
//        System.out.println("����3��");
//        long num=heros.stream().limit(3).count();
//        System.out.println(num);
//        System.out.println("����ǰ3��");
//        Hero hero=heros.stream().skip(3).findFirst().get();
//        System.out.println(hero);
//        System.out.println("ת��Ϊdouble��Stream");
//        heros.stream().mapToDouble(Hero::getHp).forEach(h->System.out.println(h));  
//        
//        System.out.println("ת���������͵�Stream");
//        heros.stream().map(h->h.name+"-"+h.hp+"-"+h.damage).forEach(h->System.out.println(h));  
        
        String name=heros.stream().sorted((h1,h2)->h1.hp>h2.hp?-1:1).skip(2).map(h->h.getName()).findFirst().get();
        System.out.println(name);
        Hero hero=heros.stream().min((h1,h2)->h1.damage-h2.damage).get();
        System.out.println(hero);
        Hero hero2=heros.stream().max((h1,h2)->h1.damage-h2.damage).get();
        System.out.println(hero2);
    }
 
    private static void filter(List<Hero> heros,HeroChecker checker) {
        for (Hero hero : heros) {
//        	if(hero.hp>100 && hero.damage<50)
//        		System.out.println(hero);
            if(checker.test(hero))
                System.out.print(hero);
        }
    }   
}
