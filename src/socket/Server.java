package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {		
		try {
			ServerSocket ss=new ServerSocket(8888);
			System.out.println("�����ڶ˿ںţ�8888");
			
			Socket s=ss.accept();
			
//			System.out.println("�����ӹ���"+s);
//			InputStream is=s.getInputStream();
//			int msg=is.read();
//			InputStream is=s.getInputStream();
//			DataInputStream dis=new DataInputStream(is);
//			OutputStream os=s.getOutputStream();
//			DataOutputStream dos=new DataOutputStream(os);
			
//			while(true){				
//				String str2=dis.readUTF();
//				System.out.println("���ܵ��ͻ��˷���������Ϣ"+str2);
//				Scanner sc=new Scanner(System.in);
//				String str=sc.next();
//				dos.writeUTF(str);
//			}
			
//			s.close();
//			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
