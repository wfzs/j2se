package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestJdbc {
	public static Hero get(int id){
		Hero hero=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
				+ "characterEncoding=UTF-8","root","");Statement s=c.createStatement()) {
			String sql="select * from hero where id="+id;
			ResultSet rs=s.executeQuery(sql);
			if(rs.next()){
				hero=new Hero();
				hero.id=id;
				hero.name=rs.getString(2);
				hero.hp=rs.getFloat("hp");
				hero.damage=rs.getInt(4);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hero;
	}
	public static void add(Hero h){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="insert into hero values(null,?,?,?)";
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
				+ "characterEncoding=UTF-8","root","");PreparedStatement ps=c.prepareStatement(sql)) {
			ps.setString(1, h.name);
			ps.setFloat(2, h.hp);
			ps.setInt(3, h.damage);
			ps.execute();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void delete(Hero h){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="delete from hero where id=?";
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
				+ "characterEncoding=UTF-8","root","");PreparedStatement ps=c.prepareStatement(sql)) {
			ps.setInt(1, h.id);
			ps.execute();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void update(Hero h) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="update hero set name=?,hp=?,damage=? where id=?";
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
				+ "characterEncoding=UTF-8","root","");PreparedStatement ps=c.prepareStatement(sql)) {
			ps.setString(1, h.name);
			ps.setFloat(2, h.hp);
			ps.setInt(3, h.damage);
			ps.setInt(4, h.id);
			ps.execute();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static List<Hero> list(){
		List<Hero> heros=new ArrayList<Hero>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
				+ "characterEncoding=UTF-8","root","");Statement s=c.createStatement()) {
			String sql="select * from hero";
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()){
				Hero h=new Hero();
				h.id=rs.getInt(1);
				h.name=rs.getString(2);
				h.hp=rs.getFloat(3);
				h.damage=rs.getInt(4);
				heros.add(h);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return heros;
	}
	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
//                "root", "");Statement s=c.createStatement()) {
//			for(int i=0;i<100;i++){
//				String sql="insert into hero values(null," + "'英雄"+(i+1) + "'," + 313.0f + "," + 50 + ")";
//				s.execute(sql);
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
//				+ "characterEncoding=UTF-8","root","");Statement s=c.createStatement()) {
////			String sql="update hero set name='name 5' where id=8";
////			s.execute(sql);
////			System.out.println("操作完成");
//			
////			String sql="select * from hero limit 0,10";
////			ResultSet rs=s.executeQuery(sql);
////			while(rs.next()){
////				int id=rs.getInt("id");
////				String name=rs.getString(2);
////				float hp=rs.getFloat("hp");
////				int damage=rs.getInt(4);
////				System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
////			}
//			
////			String name = "dashen";
////            //正确的密码是：thisispassword
////            String password = "thisispassword";
////			String sql="select * from user where name='"+name+"' and password='"+password+"'";
////			ResultSet rs=s.executeQuery(sql);
////			if(rs.next()){
////				System.out.println("账号密码正确");
////			}
////			else{
////				System.out.println("账号密码错误");
////			}
//			
//			String sql="select count(*) from hero";
//			ResultSet rs=s.executeQuery(sql);
//			int total=0;
//			while(rs.next()){
//				total=rs.getInt(1);
//			}
//			System.out.println("总共有"+total+"条记录");
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String sql="insert into hero values(null,?,?,?)";
//		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
//				+ "characterEncoding=UTF-8","root","");PreparedStatement ps=c.prepareStatement(sql)) {
//			ps.setString(1, "艾希");
//			ps.setFloat(2, 400f);
//			ps.setInt(3, 80);
//			ps.execute();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
//		list(2,5);
		
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
//				+ "characterEncoding=UTF-8","root","");Statement s=c.createStatement()) {
//			
//			c.setAutoCommit(false);
//			for(int i=0;i<10;i++){
//				String sql="delete from hero where id="+(22+i);
//				System.out.println("试图删除id="+(22+i)+"的数据");
//				System.out.println("是否要删除数据（Y/N）");
//				Scanner str=new Scanner(System.in);
//				String ang=str.next();
//				if(ang.equals("Y"))
//					s.execute(sql);
//				else if(ang.equals("N")){
//					System.out.println("不删除数据");
//				}
//				else{
//					System.out.println("请重新选择");
//					ang=str.next();
//					
//				}
//			}
//			c.commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		List<Hero> hs =list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
        Hero h = new Hero();
        h.name = "新的英雄";
        System.out.println("新加一条数据");
        add(h);
        hs =list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
        System.out.println("取出id=101的数据，它的name是:");
        h = get(101);
        System.out.println(h.name);
        System.out.println("把名字改为 英雄101，并且更新到数据库");
        h.name="英雄101";
        update(h);
        System.out.println("取出id=101的数据，它的name是:");
        h = get(101);
        System.out.println(h.name);
        System.out.println("删除id=101的数据");
        delete(h);
        hs =list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
	}
	public static void list(int start, int count){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
				+ "characterEncoding=UTF-8","root","");Statement s=c.createStatement()) {
			String sql="select * from hero limit "+start+","+count;
			s.execute(sql);		
//			s.executeUpdate(sql);
			ResultSet rs=s.getResultSet();
			while(rs.next()){
				int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
