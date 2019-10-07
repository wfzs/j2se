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
			ps.setString(1, "ά��");
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
					System.out.println("id="+tarid+"�����ݴ��ڣ�ɾ��������");
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
//			// ��ȡ���ݿ��������Ʒ����
//            System.out.println("���ݿ��Ʒ����:\t"+dbmd.getDatabaseProductName());
//            // ��ȡ���ݿ��������Ʒ�汾��
//            System.out.println("���ݿ��Ʒ�汾:\t"+dbmd.getDatabaseProductVersion());
//            // ��ȡ���ݿ�������������ͱ���֮��ķָ��� ��test.user
//            System.out.println("���ݿ�ͱ�ָ���:\t"+dbmd.getCatalogSeparator());
//            // ��ȡ�����汾
//            System.out.println("�����汾:\t"+dbmd.getDriverVersion());
//  
//            System.out.println("���õ����ݿ��б�");
//            // ��ȡ���ݿ�����
//            ResultSet rs = dbmd.getCatalogs();
//  
//            while (rs.next()) {
//                System.out.println("���ݿ�����:\t"+rs.getString(1));
//            }
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}
}
