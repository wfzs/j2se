package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJ {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="insert into hero values(null,?,?,?)";
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
				+ "characterEncoding=UTF-8","root","");PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);Statement s=c.createStatement()) {
			ps.setString(1, "维嘉");
			ps.setFloat(2, 123f);
			ps.setInt(3, 30);
			ps.execute();
			
			ResultSet rs=ps.getGeneratedKeys();
			int id=-1;
			if(rs.next()){
				id=rs.getInt(1);
				System.out.println(id);
			}
			int tarid=id-1;
			while(true){
				ResultSet rs2=s.executeQuery("select * from hero where id="+tarid);
				if(rs2.next()){
					System.out.println("id="+tarid+"的数据存在，删除该数据");
					String delete="delete from hero where id="+tarid;
					s.execute(delete);
					break;
				}
				tarid--;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
//				+ "characterEncoding=UTF-8","root","");) {
//			DatabaseMetaData dbmd=c.getMetaData();
//			
//			// 获取数据库服务器产品名称
//            System.out.println("数据库产品名称:\t"+dbmd.getDatabaseProductName());
//            // 获取数据库服务器产品版本号
//            System.out.println("数据库产品版本:\t"+dbmd.getDatabaseProductVersion());
//            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
//            System.out.println("数据库和表分隔符:\t"+dbmd.getCatalogSeparator());
//            // 获取驱动版本
//            System.out.println("驱动版本:\t"+dbmd.getDriverVersion());
//  
//            System.out.println("可用的数据库列表：");
//            // 获取数据库名称
//            ResultSet rs = dbmd.getCatalogs();
//  
//            while (rs.next()) {
//                System.out.println("数据库名称:\t"+rs.getString(1));
//            }
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}
}
