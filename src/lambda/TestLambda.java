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
        System.out.println("初始化后的集合：");
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
//        System.out.println("使用匿名类过滤");
//        filter(heros,c);
//        System.out.println("使用Lambda过滤");
//        HeroChecker c2=(Hero h)-> h.hp>100 && h.damage<50;
//        filter(heros,h->h.hp>100 && h.damage<50);
//        TestLambda tl=new TestLambda();
//        System.out.println("使用Lambda调用静态方法过滤");
//        filter(heros,h->tl.testHero(h));
//        System.out.println("直接调用静态方法过滤");
//        filter(heros,tl::testHero);
		
        //聚合
//		heros.stream().filter(TestLambda::testHero).forEach(h->System.out.println(h.name));
//        Hero[] hs=heros.toArray(new Hero[heros.size()]);
//        Arrays.stream(hs).forEach(h->System.out.println(h.getName()));
//        System.out.println("满足条件hp>100并且damage<50的数据"); 
//        heros.stream().filter(h->h.hp>100&&h.damage<50).forEach(h->System.out.print(h));
//        
//        System.out.println("去除重复的条件，去除标准看equals");
//        heros.stream().distinct().forEach(h->System.out.print(h));  
//        
//        System.out.println("按照血量排序");
//        heros.stream().sorted((h1,h2)->h1.hp>=h2.hp?1:-1).forEach(h->System.out.print(h));
//        
//        System.out.println("保留3个");
//        long num=heros.stream().limit(3).count();
//        System.out.println(num);
//        System.out.println("忽略前3个");
//        Hero hero=heros.stream().skip(3).findFirst().get();
//        System.out.println(hero);
//        System.out.println("转化为double的Stream");
//        heros.stream().mapToDouble(Hero::getHp).forEach(h->System.out.println(h));  
//        
//        System.out.println("转化任意类型的Stream");
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
